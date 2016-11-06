package common 

import (
	"io/ioutil"
	"fmt"	
	"log"
	"net/http"
	"time"
	//"GFW/taskmanager/controllers"

	 jwt "gopkg.in/dgrijalva/jwt-go.v2"
)

const (
	privKeyPath = "keys/app.rsa"
	pubKeyPath = "keys/app.rsa.pub"
)

var (
	verifyKey,signKey []byte
	jwtToken string
)

func initKeys() {
	var err error

	signKey, err = ioutil.ReadFile(privKeyPath)
	if err != nil {
		log.Fatalf("[initKeys]: %s\n",err)
	}

	verifyKey,err = ioutil.ReadFile(pubKeyPath)
	if err != nil {
		log.Fatalf("[initKeys]: %s\n",err)
		panic(err)
	}
}

func GenerateJWT(name, role string) (string, error) {
	t := jwt.New(jwt.GetSigningMethod("RS256"))
	
	t.Claims["iss"] = "admin"
	t.Claims["UserInfo"] = struct {
		Name string
		Role string
	} {name,role}

	t.Claims["exp"] = time.Now().Add(time.Minute * 20).Unix()
	tokenString,err := t.SignedString(signKey)
	jwtToken = tokenString
	if err != nil {
		return "", err
	}
	return tokenString,nil
}
func setHeaderRequest(w http.ResponseWriter, r *http.Request ) {
	var tokenString string
 	tokenString = fmt.Sprintf("Bearer %s",jwtToken)
 	fmt.Println(tokenString)
	r.Header.Set("Authorization", tokenString)
}



func Authorize(w http.ResponseWriter, r *http.Request, next http.HandlerFunc) {
	log.Println("In Authorize")
	setHeaderRequest(w ,r)
	token,err := jwt.ParseFromRequest(r, func(token *jwt.Token) (interface{}, error) {
		return verifyKey,nil
		})
	//fmt.Println("In Authorize2")
	if err != nil {
		switch err.(type) {
		case *jwt.ValidationError:
			vErr := err.(*jwt.ValidationError)

			switch vErr.Errors {
			case jwt.ValidationErrorExpired:
				DisplayAppError(
					w,
					err,
					"Acces Token is expired, get a new Token",
					401,
				)
				return

			default:
		//		fmt.Println("default1")
				DisplayAppError(w,
					err, 
					"Error while parsing the Acces Token!",
					500,
				)
				return
			}
		default:
		//	fmt.Println("default2")
			DisplayAppError(w,
					err, 
					"Error while parsing the Acces Token!",
					500,
				)
				return
		}
		
		//fmt.Println("In Authorize3")
		
		
	}
		if token.Valid {
			//fmt.Println("Go next handler")
			next(w,r)
		} else {
			DisplayAppError(w,
				err,
				"Invalid Acces Token",
				401,
			)
		}
}


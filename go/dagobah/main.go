package main

import (
	"html/template"
	"net/http"
	"log"
	"fmt"
)
var templates = template.Must(template.ParseGlob("templates/*"))

func main() {
	http.Handle("/static/", http.StripPrefix("/static/", http.FileServer(http.Dir("static"))))
	http.HandleFunc("/contact", Contact)
	
	http.HandleFunc("/bio", Bio)
	http.HandleFunc("/video", Video)
	http.HandleFunc("/music", Music)
	http.HandleFunc("/", Index)
	fmt.Println("Server listening...")
	http.ListenAndServe(":3000", nil)
}

func Index(w http.ResponseWriter, r *http.Request) {
	if err := templates.ExecuteTemplate(w, "Index", nil); err != nil {
		log.Println(err.Error())
		http.Error(w,http.StatusText(500),500)
	}
	if err := templates.ExecuteTemplate(w, "home", nil); err != nil {
		log.Println(err.Error())
		http.Error(w,http.StatusText(500),500)
	}
}

func Music(w http.ResponseWriter, r *http.Request) {
	if err := templates.ExecuteTemplate(w, "music", nil); err != nil {
		log.Println(err.Error())
		http.Error(w, http.StatusText(500),500)
	}
}

func Video(w http.ResponseWriter, r *http.Request) {
	if err := templates.ExecuteTemplate(w, "video", nil); err != nil {
		log.Println(err.Error())
		http.Error(w, http.StatusText(500), 500)
	}
}

func Bio(w http.ResponseWriter, r *http.Request) {
	if err := templates.ExecuteTemplate(w, "bio", nil); err != nil {
		log.Println(err.Error())
		http.Error(w, http.StatusText(500), 500)
	}
}


func Contact(w http.ResponseWriter, r *http.Request) {
	if err := templates.ExecuteTemplate(w, "contact", nil); err != nil {
		log.Println(err.Error())
		http.Error(w, http.StatusText(500), 500)
	}
}

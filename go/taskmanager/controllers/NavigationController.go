package controllers

import (
	"log"
	"net/http"
	"html/template"
)

var templates = template.Must(template.ParseGlob("templates/*"))
var userLoginInfo interface{}

func RegisterPage(w http.ResponseWriter, r *http.Request) {
	if err := templates.ExecuteTemplate(w, "register", nil); err != nil {
		log.Println(err.Error())
		http.Error(w,http.StatusText(500),500)
	}
	
}
func LoginPage(w http.ResponseWriter, r *http.Request) {
	if err := templates.ExecuteTemplate(w, "login", nil); err != nil {
		log.Println(err.Error())
		http.Error(w,http.StatusText(500),500)
	}
	
}

func TaskManagerAll(w http.ResponseWriter, r *http.Request) {

	if err := templates.ExecuteTemplate(w, "all", userLoginInfo); err != nil {
		log.Println(err.Error())
		http.Error(w,http.StatusText(500),500)
	}


	
}

func TaskManagerGetTaskByUser(w http.ResponseWriter, r *http.Request) {

	if err := templates.ExecuteTemplate(w, "getTaskByUser", userLoginInfo); err != nil {
		log.Println(err.Error())
		http.Error(w,http.StatusText(500),500)
	}


	
}

func TaskManagerCreateTask(w http.ResponseWriter, r *http.Request) {

	
	if err := templates.ExecuteTemplate(w, "createTask", userLoginInfo); err != nil {
		log.Println(err.Error())
		http.Error(w,http.StatusText(500),500)
	}
	

	
}

func TaskManagerCreateNote(w http.ResponseWriter, r *http.Request) {

	
	if err := templates.ExecuteTemplate(w, "createNote", userLoginInfo); err != nil {
		log.Println(err.Error())
		http.Error(w,http.StatusText(500),500)
	}
	
}

func TaskManagerUpdateTask(w http.ResponseWriter, r *http.Request) {

	
	if err := templates.ExecuteTemplate(w, "updateTask", userLoginInfo); err != nil {
		log.Println(err.Error())
		http.Error(w,http.StatusText(500),500)
	}
}

func TaskManagerUpdateNote(w http.ResponseWriter, r *http.Request) {

	
	if err := templates.ExecuteTemplate(w, "updateNote", userLoginInfo); err != nil {
		log.Println(err.Error())
		http.Error(w,http.StatusText(500),500)
	}
}


func TaskManagerTasks(w http.ResponseWriter, r *http.Request) {

	if err := templates.ExecuteTemplate(w, "tasks", userLoginInfo); err != nil {
		log.Println(err.Error())
		http.Error(w,http.StatusText(500),500)
	}
	
}
func TaskManagerNotes(w http.ResponseWriter, r *http.Request) {

	if err := templates.ExecuteTemplate(w, "notes", userLoginInfo); err != nil {
		log.Println(err.Error())
		http.Error(w,http.StatusText(500),500)
	}
	
}
func TaskManagerGet(w http.ResponseWriter, r *http.Request) {

	if err := templates.ExecuteTemplate(w, "get", userLoginInfo); err != nil {
		log.Println(err.Error())
		http.Error(w,http.StatusText(500),500)
	}
	
}
func TaskManagerCreate(w http.ResponseWriter, r *http.Request) {

	if err := templates.ExecuteTemplate(w, "create", userLoginInfo); err != nil {
		log.Println(err.Error())
		http.Error(w,http.StatusText(500),500)
	}

	
}
func TaskManagerUpdate(w http.ResponseWriter, r *http.Request) {

	if err := templates.ExecuteTemplate(w, "update", userLoginInfo); err != nil {
		log.Println(err.Error())
		http.Error(w,http.StatusText(500),500)
	}
	
}
func TaskManagerDelete(w http.ResponseWriter, r *http.Request) {

	if err := templates.ExecuteTemplate(w, "delete", userLoginInfo); err != nil {
		log.Println(err.Error())
		http.Error(w,http.StatusText(500),500)
	}
	
}












func storeUserLogin(resource interface{}) {
	userLoginInfo = resource
	//log.Println("User:")
	//log.Println(userLoginInfo)
}
func SuccessPage(w http.ResponseWriter, r *http.Request) {
	if err := templates.ExecuteTemplate(w, "success", nil); err != nil {
		log.Println(err.Error())
		http.Error(w,http.StatusText(500),500)

	}
	//http.Redirect(w, r, "http://www.google.com", 303)
	//log.Println("SuccessPage")
	
}




func IndexPage(w http.ResponseWriter, r *http.Request) {
	if err := templates.ExecuteTemplate(w, "Index", nil); err != nil {
		log.Println(err.Error())
		http.Error(w,http.StatusText(500),500)
	}
	if err := templates.ExecuteTemplate(w, "home", nil); err != nil {
		log.Println(err.Error())
		http.Error(w,http.StatusText(500),500)
	}
}


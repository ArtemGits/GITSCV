package controllers

import (
	"GFW/taskmanager/models"
)

type (
	UserResource struct {
		Data models.User `json:"data"`
	}

	LoginResource struct {
		Data LoginModel `json:"data"`

	}
	AuthUserResource struct {
		Data AuthUserModel `json:"data"`
	}

	LoginModel struct {
		Email string 	`json:"email"`
		Password string `json:"password"`
	}
	AuthUserModel struct {
		User 	models.User `json:"user"`
		Token 	string 	    `json:"token"`
	}
)

type (
	TaskResource struct {
		Data models.Task 	`json:"data"`
	}

	TasksResource struct {
		Data []models.Task  `json:"data"`
	}
)

type (
	NoteResource struct {
		Data NoteModel 	`json:"data"`
	}
	NotesResource struct {
		Data []models.TaskNote `json:"data"`
	}
	NoteModel struct {
		TaskId 		string `json:"taskid"`
		Description string `json:"description"`
	}
)
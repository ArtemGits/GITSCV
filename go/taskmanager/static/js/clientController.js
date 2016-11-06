function createTask() {
 
 window.location = "http://localhost:8080/taskmanager/createTask";

}; 
function createNote() {
 
 window.location = "http://localhost:8080/taskmanager/createNote";

}; 



var t = '';
var note_id ='';
function getNoteId(obj) {
     note_id = $(obj).text();
    console.log(note_id)
 
  $( obj ).closest( "div" ).toggleClass( "hilight" );

 }

function clickfunc(obj) {
     t = $(obj).text();
    console.log(t)
 
  $( obj ).closest( "div" ).toggleClass( "hilight" );

 }

function clickedd(obj){
$("#myinput").value=t;
}




function getTasksByID() {

if( t != '') {
    console.log(t);
    var url = '/tasks/' + t;
    console.log(url);
    var element = document.getElementById("task");
    while (element.hasChildNodes()) {
        element.removeChild(element.lastChild);
    }
    $.get(
        url,
        function(datas) {
       // var jsonResponse = JSON.parse(datas);
        var tasks = datas;
        console.log(tasks);
        var idd = 0;
        
          var newDiv = document.createElement("div");
          
          newDiv.innerHTML = tasks.CreatedOn + ' <br/> ' + tasks.createdby + ' <br/> ' + tasks.description + '<p onclick="clickfunc(this)">' + tasks.id + '<p/>' + tasks.name + ' <br/>' + tasks.status + ' <br/>' + tasks.tags + '<br/><hr/>';
          //newDiv.setAttribute("id", "Div" + key);
          
          
         
          element.appendChild(newDiv);
          t = ''; 
        });

  } else {
    alert("Needs to select the task ID.");

  }


}; 

function deleteTaskByID() {

  if( t != '') {
    console.log(t);
    var url = '/tasks/' + t;
    console.log(url);
      $.ajax({
          url: url,
          type: 'DELETE',
          success: function(datas) {
                   // var jsonResponse = JSON.parse(datas);
                    var tasks = datas;
                    console.log(tasks);
                    var idd = 0;
                    alert("Deleted task with id =" + t);
                    t = '';
                    location.reload(); 
                    }
          
     });

  } else {
    alert("Needs to select the task ID.");

  }


}; 



function updateTask() {
console.log(t);
if( t != '') {
  window.open("http://localhost:8080/taskmanager/updateTask/"+t,"_self"); 
} else {
  alert("Needs to select the task ID.");

}

}; 

function updateNote() {
console.log(note_id);
if( note_id != '') {
  window.open("http://localhost:8080/taskmanager/updateNote/"+note_id,"_self"); 
} else {
  alert("Needs to select the note ID.");

}

}; 


(function ($) {
   
    $.fn.serializeFormJSON = function () {
       var  strarr;
        var o = {};
        var o2 = {};
        var a = this.serializeArray();
        $.each(a, function () {
              if(this.name == "tags") {
                  strarr = this.value.split(',');
                  o[this.name] = strarr;
              } else {
                 o[this.name] = this.value || '';
              }
               
            
            o2["data"] = o;
        });
        return o2;
    };
})(jQuery);

$(document).ready(function() {
 $("#createTaskForm").submit(function(event) {
  event.preventDefault();
  var url = "/tasks"
  var data = $(this).serializeFormJSON();
  var json = JSON.stringify(data);
  console.log(json);
 $.ajax({
 type: "POST",
 url: url,
 data: json, // serializes the form's elements.
         success: function(){
        // window.location.href = "/taskmanager/all"; // show response from the php script.
         alert("OK")
         getTasks();
         },
         error: function() { 
                    alert("Error!");
                }  

 });
 
 }); 
});

$(document).ready(function() {
 $("#createNoteForm").submit(function(event) {
  event.preventDefault();
  var url = "/notes"
  var data = $(this).serializeFormJSON();
  var json = JSON.stringify(data);
  console.log(json);
 $.ajax({
 type: "POST",
 url: url,
 data: json, // serializes the form's elements.
         success: function(){
        // window.location.href = "/taskmanager/all"; // show response from the php script.
         alert("OK")
         getTaskNotes();
         },
         error: function() { 
                    alert("Error!");
                }  

 });
 
 }); 
});

function test() {
  console.log("test");
};








function getTasks() {
var key;
var element = document.getElementById("task");
while (element.hasChildNodes()) {
    element.removeChild(element.lastChild);
}

$.get(
    "/tasks",
    function(datas) {
    var jsonResponse = JSON.parse(datas);
    var tasks = jsonResponse.data;
    console.log(tasks);
    var idd = 0;
    for (var key in tasks) {
      var newDiv = document.createElement("div");
      
      newDiv.innerHTML = tasks[key].CreatedOn + ' <br/> ' + tasks[key].createdby + ' <br/> ' + tasks[key].description + '<p onclick="clickfunc(this)">' + tasks[key].id + ' <p/>' + tasks[key].name + ' <br/>' + tasks[key].status + ' <br/>' + tasks[key].tags + '<br/><hr/>';
      newDiv.setAttribute("id", "Div" + key);
      
      
     
      element.appendChild(newDiv);
      
    
    }
    
    }


);



}; 


function getTaskNotes() {
var key;
var element = document.getElementById("notes");
while (element.hasChildNodes()) {
    element.removeChild(element.lastChild);
}

$.get(
    "/notes",
    function(datas) {
    var jsonResponse = jQuery.parseJSON(JSON.stringify(datas));//WTF!!!!! why is it worked?
    var notes = jsonResponse.data;
    console.log(notes);
    var idd = 0;
    for (var key in notes) {
      var newDiv = document.createElement("div");
      
      newDiv.innerHTML = notes[key].createdon  + ' <br/> ' + notes[key].description  + '</br>' + '<p onclick="getNoteId(this)">'  + notes[key].id + ' <p/>' + '<p onclick="clickfunc(this)">' + notes[key].TaskId + ' <p/>' + '<br/><hr/>';
      newDiv.setAttribute("id", "Div" + key);
      
      
     
      element.appendChild(newDiv);
      
    
    }
    
    }


);



}; 



function getNotesByTaskID() {

if( t != '') {
    console.log(t);
    var url = '/notes/task/' + t;
    console.log(url);
    var element = document.getElementById("notes");
    while (element.hasChildNodes()) {
        element.removeChild(element.lastChild);
    }
    $.get(
        url,
        function(datas) {
        
        var jsonResponse = jQuery.parseJSON(JSON.stringify(datas));//WTF!!!!! why is it worked?
        var notes = jsonResponse.data;
        console.log(notes);
        var idd = 0;
        
          for (var key in notes) {
          var newDiv = document.createElement("div");
          
          newDiv.innerHTML = notes[key].createdon  + ' <br/> ' + notes[key].description + '</br>' + '<p onclick="getNoteId(this)">'  + notes[key].id + ' <p/>' + '<p onclick="clickfunc(this)">' + notes[key].TaskId + ' <p/>' + '<br/><hr/>';
          newDiv.setAttribute("id", "Div" + key);
          
          
         
          element.appendChild(newDiv);
          
        
        }
          t = ''; 
        });

  } else {
    alert("Needs to select the task ID.");

  }


}; 

function getNoteByID() {

if( note_id != '') {
    console.log(note_id);
    var url = '/notes/' + note_id;
    console.log(url);
    var element = document.getElementById("notes");
    while (element.hasChildNodes()) {
        element.removeChild(element.lastChild);
    }
    $.get(
        url,
        function(datas) {
        
       // var jsonResponse = jQuery.parseJSON(JSON.stringify(datas));//WTF!!!!! why is it worked?
        var notes = datas;
        console.log(notes);
        var idd = 0;
        
         
          var newDiv = document.createElement("div");
          
          newDiv.innerHTML = notes.createdon  + ' <br/> ' + notes.description + '</br>' + '<p onclick="getNoteId(this)">'  + notes.id + ' <p/>' + '<p onclick="clickfunc(this)">' + notes.TaskId + ' <p/>' + '<br/><hr/>';
          
          
          
         
          element.appendChild(newDiv);
          
        
        
          note_id = ''; 
        });

  } else {
    alert("Needs to select the note ID.");

  }


}; 



function deleteNoteByID() {

  if( note_id != '') {
    console.log(note_id);
    var url = '/notes/' + note_id;
    console.log(url);
      $.ajax({
          url: url,
          type: 'DELETE',
          success: function(datas) {
                   // var jsonResponse = JSON.parse(datas);
                    var tasks = datas;
                    console.log(tasks);
                    var idd = 0;
                    alert("Deleted task with id =" + note_id);
                    note_id = '';
                    location.reload(); 
                    }
          
     });

  } else {
    alert("Needs to select the note ID.");

  }


}; 



function getTaskByUser() {
  window.location = "http://localhost:8080/taskmanager/getTaskByUser";
};

$(document).ready(function() {
 $("#getTaskByUserForm").submit(function(event) {
  event.preventDefault();
  var name = document.getElementsByName("name")[0].value;
  var url = "/tasks/users/"+name;
      
      var element = document.getElementById("task");
      while (element.hasChildNodes()) {
          element.removeChild(element.lastChild);
      }

 $.get(
    url,
    function(datas) {
    var jsonResponse = JSON.parse(datas);
    var tasks = jsonResponse.data;
    console.log(tasks);
    var idd = 0;
    for (var key in tasks) {
      var newDiv = document.createElement("div");
      
      newDiv.innerHTML = tasks[key].CreatedOn + ' <br/> ' + tasks[key].createdby + ' <br/> ' + tasks[key].description + '<p onclick="clickfunc(this)">' + tasks[key].id + ' <p/>' + tasks[key].name + ' <br/>' + tasks[key].status + ' <br/>' + tasks[key].tags + '<br/><hr/>';
      newDiv.setAttribute("id", "Div" + key);
      
      
      
      element.appendChild(newDiv);
      
    
    }
    
    }


);


 
 }); 
});




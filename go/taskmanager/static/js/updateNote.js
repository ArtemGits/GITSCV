var id;
   window.onload = function getID() {
    var pathArray = window.location.pathname.split( '/' );
     id = pathArray[3];
    console.log(id);
    
    //console.log(globId);
    var url = '/notes/' + id;
    console.log(url);
  $.ajax({
      url: url,
      type: 'GET',
      success: function(datas) {
                //var jsonResponse = JSON.parse(datas);
                var notes = datas;
                console.log(notes);
                var element = document.getElementById("updateNoteForm");   
                
                document.getElementsByName("Description")[0].value = notes.description;
                   
                 
                }
      
  });
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
 $("#updateNoteForm").submit(function(event) {
  event.preventDefault();
   var url = '/notes/' + id;
  var data = $(this).serializeFormJSON();
  var json = JSON.stringify(data);
  console.log("how")
  console.log(json);
 $.ajax({
          url: url,
          type: 'PUT',
          data: json, 
          success: function(datas) {
                    alert("OK");
                    var element = document.getElementById("notes");
                    while (element.hasChildNodes()) {
                        element.removeChild(element.lastChild);
                    }

                    $.ajax({
                          url: '/notes/' + id,
                          type: 'GET',
                          success: function(datas) {
                                    //var jsonResponse = JSON.parse(datas);
                                    var notes = datas;
                                    console.log();
                                    var newDiv = document.createElement("div");
                                    newDiv.innerHTML = notes.createdon  + ' <br/> ' + notes.description + '</br>' + '<p onclick="getNoteId(this)">'  + notes.id + ' <p/>' + '<p onclick="clickfunc(this)">' + notes.TaskId + ' <p/>' + '<br/><hr/>';
          
          
          
         
          element.appendChild(newDiv);
                                     
                                    }
                          
                    });

                     
                    }
          
     });
  

 
 }); 
});
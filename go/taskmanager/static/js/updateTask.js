var id;
   window.onload = function getID() {
    var pathArray = window.location.pathname.split( '/' );
     id = pathArray[3];
    console.log(id);
    
    //console.log(globId);
    var url = '/tasks/' + id;
    console.log(url);
  $.ajax({
      url: url,
      type: 'GET',
      success: function(datas) {
                //var jsonResponse = JSON.parse(datas);
                var tasks = datas;
                console.log(tasks);
                var element = document.getElementById("updateTaskForm");   
                document.getElementsByName("status")[0].value =tasks.status;
                document.getElementsByName("name")[0].value =tasks.name;
                document.getElementsByName("description")[0].value =tasks.description;
                document.getElementsByName("tags")[0].value =tasks.tags;            
                 
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
 $("#updateTaskForm").submit(function(event) {
  event.preventDefault();
   var url = '/tasks/' + id;
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
                    var element = document.getElementById("task");
                    while (element.hasChildNodes()) {
                        element.removeChild(element.lastChild);
                    }

                    $.ajax({
                          url: '/tasks/' + id,
                          type: 'GET',
                          success: function(datas) {
                                    //var jsonResponse = JSON.parse(datas);
                                    var tasks = datas;
                                    console.log(tasks);
                                    var newDiv = document.createElement("div");
                                    newDiv.innerHTML = tasks.CreatedOn + ' <br/> ' + tasks.createdby + ' <br/> ' + tasks.description + '<p onclick="clickfunc(this)">' + tasks.id + '<p/>' + tasks.name + ' <br/>' + tasks.status + ' <br/>' + tasks.tags + '<br/><hr/>';
                                     //newDiv.setAttribute("id", "Div" + key);
                                    element.appendChild(newDiv); 
                                     
                                    }
                          
                    });

                     
                    }
          
     });
  

 
 }); 
});
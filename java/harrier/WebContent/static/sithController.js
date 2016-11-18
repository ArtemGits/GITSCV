//siths operations


$( document ).ready(function() {
	var table = document.getElementById('tableCenterSith'),
    cells = table.getElementsByTagName('td');
	var id=1;
	var testid=1;
for (var i=0,len=cells.length; i<len; i++){
    cells[i].onclick = function(){
        
        id = parseInt(this.innerHTML);
        $("input[id=idNote]").val(id);
        testid = $('input#idNote').val()
        console.log(id);
        console.log(testid);
        /* if you know it's going to be numeric:
        console.log(parseInt(this.innerHTML),10);
        */
        

		$.get('/harrier/sith_controller', {
			HiddenId : testid
		}, function(datas) {
			var rg = /'(.*?)'/;
			var response = datas.split(rg);
            console.log(response);
            var element = document.getElementById("ResponseForm");   
            document.getElementsByName("id")[0].value =response[1];
            document.getElementsByName("rang")[0].value =response[9];
            document.getElementsByName("id_status")[0].value =response[3];
            document.getElementsByName("old_name")[0].value =response[5];
            document.getElementsByName("new_name")[0].value =response[7];
            document.getElementsByName("age")[0].value =response[17];
            document.getElementsByName("home")[0].value =response[11];
            document.getElementsByName("canon")[0].value =response[13];
            document.getElementsByName("history")[0].value =response[15];
            
            
		});
    }
}




});

function sith_update() {
	
    var id =  document.getElementsByName("id")[0].value;
    var rang =  document.getElementsByName("rang")[0].value;
    var id_status =  document.getElementsByName("id_status")[0].value;
    var old_name = document.getElementsByName("old_name")[0].value;
    var new_name = document.getElementsByName("new_name")[0].value;
    var age = document.getElementsByName("age")[0].value;
    var home = document.getElementsByName("home")[0].value;
     var canon = document.getElementsByName("canon")[0].value;
     var history = document.getElementsByName("history")[0].value;
    console.log(id);
	$.ajax({
		url: '/harrier/sith_controller' +  '?' + $.param({"id": id, "rang": rang, "id_status": id_status, "old_name": old_name, "new_name": new_name, "age": age, "home": home, "canon": canon, "history" : history}),
        type: 'PUT',
        
        	
        
        success: function(datas) {
                  alert("Update");
                                     
                  },
        error: function() {
        	alert("error");
        }
        
   });
	
};

function sith_create() {
	
	var id =  document.getElementsByName("id")[0].value;
    var rang =  document.getElementsByName("rang")[0].value;
    var id_status =  document.getElementsByName("id_status")[0].value;
    var old_name = document.getElementsByName("old_name")[0].value;
    var new_name = document.getElementsByName("new_name")[0].value;
    var age = document.getElementsByName("age")[0].value;
    var home = document.getElementsByName("home")[0].value;
     var canon = document.getElementsByName("canon")[0].value;
     var history = document.getElementsByName("history")[0].value;
    $.ajax({
        url: '/harrier/sith_controller',
        type: 'POST',
        data: {"id": id, "rang": rang, "id_status": id_status, "old_name": old_name, "new_name": new_name, "age": age, "home": home, "canon": canon, "history" : history},
        	
        
        success: function(datas) {
                  alert("Create");
                                     
                  },
        error: function() {
        	alert("error");
        }
        
   });
    
};

function sith_delete() {
	 var id = $('input#idNote').val();
	 console.log(id);
	 $.ajax({
	        url: '/harrier/sith_controller' +  '?' + $.param({"id": id}),
	        type: 'DELETE',
	       
	        	
	        
	        success: function(datas) {
	                  alert("Delete");
	                                     
	                  },
	        error: function() {
	        	alert("error");
	        }
	        
	   });
};


//status operations


$( document ).ready(function() {
	var table = document.getElementById('tableCenterStatus'),
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
        

		$.get('/harrier/status_controller_op', {
			HiddenId : testid
		}, function(datas) {
			var rg = /'(.*?)'/;
			var response = datas.split(rg);
            console.log(response);
            var element = document.getElementById("ResponseForm");   
            document.getElementsByName("id")[0].value =response[1];
            document.getElementsByName("status")[0].value =response[3];
            
		});
    }
}




});

function status_update() {
	
    var id =  document.getElementsByName("id")[0].value;
    var status =  document.getElementsByName("status")[0].value;
    console.log(id);
	$.ajax({
		url: '/harrier/status_controller_op' +  '?' + $.param({"id": id, "status": status}),
        type: 'PUT',
        
        	
        
        success: function(datas) {
                  alert("Update");
                                     
                  },
        error: function() {
        	alert("error");
        }
        
   });
	
};

function status_create() {
	
    var id =  document.getElementsByName("id")[0].value;
    var status =  document.getElementsByName("status")[0].value;
    $.ajax({
        url: '/harrier/status_controller_op',
        type: 'POST',
        data: {id: id, status: status},
        	
        
        success: function(datas) {
                  alert("Create");
                                     
                  },
        error: function() {
        	alert("error");
        }
        
   });
    
};

function status_delete() {
	 var id = $('input#idNote').val();
	 console.log(id);
	 $.ajax({
	        url: '/harrier/status_controller_op' +  '?' + $.param({"id": id}),
	        type: 'DELETE',
	       
	        	
	        
	        success: function(datas) {
	                  alert("Delete");
	                                     
	                  },
	        error: function() {
	        	alert("error");
	        }
	        
	   });
}







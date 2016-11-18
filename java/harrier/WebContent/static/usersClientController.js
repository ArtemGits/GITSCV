$( document ).ready(function() {
	var table = document.getElementById('tableCenter'),
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
        

		$.get('/harrier/achieve_update', {
			HiddenId : testid
		}, function(datas) {
			var rg = /'(.*?)'/;
			var response = datas.split(rg);
            console.log(response);
            var element = document.getElementById("ResponseForm");   
          document.getElementsByName("id")[0].value =response[1];
            document.getElementsByName("duels")[0].value =response[5];
            document.getElementsByName("wins")[0].value =response[9];
            document.getElementsByName("loses")[0].value =response[7];
            document.getElementsByName("kills")[0].value =response[3];
		});
    }
}


//alert($('input#idNote').val());

});

function achieve_update() {
	duels =   document.getElementsByName("duels")[0].value;
	wins = document.getElementsByName("wins")[0].value;
    loses= document.getElementsByName("loses")[0].value;
    id =  document.getElementsByName("id")[0].value;
    var kills =  document.getElementsByName("kills")[0].value;
    console.log(id);
	$.ajax({
        url: '/harrier/achieve_update',
        type: 'POST',
        data: {id: id, duels: duels, wins: wins, loses:loses, kills:kills},
        	
        
        success: function(datas) {
                  alert("Update");
                                     
                  },
        error: function() {
        	alert("error");
        }
        
   });
	
};

function achieve_create() {
	var duels =   document.getElementsByName("duels")[0].value;
	var wins = document.getElementsByName("wins")[0].value;
    var loses= document.getElementsByName("loses")[0].value;
    var id =  document.getElementsByName("id")[0].value;
    var kills =  document.getElementsByName("kills")[0].value;
    $.ajax({
        url: '/harrier/achieve_create',
        type: 'POST',
        data: {id: id, duels: duels, wins: wins, loses:loses, kills: kills},
        	
        
        success: function(datas) {
                  alert("Create");
                                     
                  },
        error: function() {
        	alert("error");
        }
        
   });
    
};

function achieve_delete() {
	 var id = $('input#idNote').val();
	 console.log(id);
	 $.ajax({
	        url: '/harrier/achieve_update' +  '?' + $.param({"id": id}),
	        type: 'DELETE',
	       
	        	
	        
	        success: function(datas) {
	                  alert("Delete");
	                                     
	                  },
	        error: function() {
	        	alert("error");
	        }
	        
	   });
}


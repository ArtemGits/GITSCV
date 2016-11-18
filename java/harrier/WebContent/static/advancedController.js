function getAllAchievements() {
	
	cleanSpace();  
	var div = document.createElement('div');
	div.setAttribute('class', 'someClass');
	div.innerHTML = document.getElementById('AchievementsBlock').innerHTML;
	document.getElementById('advancedController').appendChild(div);
};

function getAllSiths() {
	
	cleanSpace();    
    var div = document.createElement('div');
	div.setAttribute('class', 'someClass');
	div.innerHTML = document.getElementById('SithsBlock').innerHTML;
	document.getElementById('advancedController').appendChild(div);
};


function getAllStatus() {
	cleanSpace();    
    var div = document.createElement('div');
	div.setAttribute('class', 'someClass');
	div.innerHTML = document.getElementById('StatusBlock').innerHTML;
	document.getElementById('advancedController').appendChild(div);
};

function getAllStudents() {
	cleanSpace();    
    var div = document.createElement('div');
	div.setAttribute('class', 'someClass');
	div.innerHTML = document.getElementById('StudentBlock').innerHTML;
	document.getElementById('advancedController').appendChild(div);
};

function getAllTeachers() {
	cleanSpace();    
    var div = document.createElement('div');
	div.setAttribute('class', 'someClass');
	div.innerHTML = document.getElementById('TeacherBlock').innerHTML;
	document.getElementById('advancedController').appendChild(div);
}

function cleanSpace() {
	var element = document.getElementById('advancedController');
	 if(element.hasChildNodes()) {
		 element.removeChild(element.lastChild);
	 }
};






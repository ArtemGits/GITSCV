/**
 * 
 */

$(document).ready(function(){
  // Add smooth scrolling to all links in navbar + footer link
  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {
    // Make sure this.hash has a value before overriding default behavior
    if (this.hash !== "") {
      // Prevent default anchor click behavior
      event.preventDefault();

      // Store hash
      var hash = this.hash;

      // Using jQuery's animate() method to add smooth page scroll
      // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 900, function(){
   
        // Add hash (#) to URL when done scrolling (default click behavior)
        window.location.hash = hash;
      });
    } // End if
  });
  
  $(window).scroll(function() {
    $(".slideanim").each(function(){
      var pos = $(this).offset().top;

      var winTop = $(window).scrollTop();
        if (pos < winTop + 600) {
          $(this).addClass("slide");
        }
    });
  });
})


function disabled() {
	
	if(document.getElementById("Taz").checked) {
		document.getElementById("Volga").disabled = true;
	} else {
		document.getElementById("Volga").disabled = false;
	} 
	if(document.getElementById("Volga").checked) {
		document.getElementById("Taz").disabled = true;
	} else {
		document.getElementById("Taz").disabled = false;
	}
	if(document.getElementById("Java").checked) {
		document.getElementById("Go").disabled = true;
	} else {
		document.getElementById("Go").disabled = false;
	} 
	if(document.getElementById("Go").checked) {
		document.getElementById("Java").disabled = true;
	} else {
		document.getElementById("Java").disabled = false;
	}
	if(document.getElementById("VK").checked) {
		document.getElementById("FB").disabled = true;
	} else {
		document.getElementById("FB").disabled = false;
	} 
	if(document.getElementById("FB").checked) {
		document.getElementById("VK").disabled = true;
	} else {
		document.getElementById("VK").disabled = false;
	}
	if(document.getElementById("Subarru").checked) {
		document.getElementById("Honda").disabled = true;
	} else {
		document.getElementById("Honda").disabled = false;
	} 
	if(document.getElementById("Honda").checked) {
		document.getElementById("Subarru").disabled = true;
	} else {
		document.getElementById("Subarru").disabled = false;
	}
};



// Image Slider Band Page

jQuery(document).ready(function($) {

    //cache DOM
    var $slider = $('#slider1');
    var $slideContainer = $slider.find('.slides1');
    var $slides = $slideContainer.find('.slide1');
    var $slideImg = $slides.find('img');
    var $toggleLeft = $('#toggle-left');
    var $toggleRight = $('#toggle-right');
    var $pauseBtn = $('#pause-btn');
    var $playBtn = $('#play-btn');

    //configuration
    var width = $slider.width();
    var animationSpeed = 1500;
    var pause = 4000;
    var currentSlide = 1;

    var interval;

    $slideContainer.css('width', width * $slides.length);
    $slideImg.css('width', width);

    $pauseBtn.click(function(){stopSlider();$pauseBtn.toggle();$playBtn.toggle();});
    $playBtn.click(function(){startSlider();$playBtn.toggle();$pauseBtn.toggle();});
    $toggleLeft.click(function(){
        stopSlider();
        if (currentSlide === 1) {
            currentSlide = $slides.length;
            $slideContainer.css({'margin-left': '-'+width*($slides.length-1)+'px'});
            $slideContainer.animate({'margin-left': '+='+width}, animationSpeed, function() {
                currentSlide--;
            });
        } else {
            $slideContainer.animate({'margin-left': '+='+width}, animationSpeed, function(){
                currentSlide--;
            });
        }
        startSlider();
    });
    $toggleRight.click(function(){
        stopSlider();
        $slideContainer.animate({'margin-left': '-='+width}, animationSpeed, function(){
            currentSlide++;
            if (currentSlide === $slides.length) {
                currentSlide = 1;
                $slideContainer.css('margin-left', 0);
            }
        });
        startSlider();
    });
    function startSlider() {
        interval = setInterval(function() {
            $slideContainer.animate({'margin-left': '-='+width}, animationSpeed, function(){
                currentSlide++;
                if (currentSlide === $slides.length) {
                    currentSlide = 1;
                    $slideContainer.css('margin-left', 0);
                }
            });
        }, pause);
    }

    function stopSlider() {
        clearInterval(interval);
    }
    startSlider();
});





//FB JS

(function(d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
            if (d.getElementById(id)) return;
                js = d.createElement(s); js.id = id;
                js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.5&appId=1654160291507140";
                fjs.parentNode.insertBefore(js, fjs);
        }(document, 'script', 'facebook-jssdk'));






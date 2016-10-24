<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	
	
	<c:import url="fragments/head.jsp" />
	<body>

    <!-- Following Menu -->
<div class="ui large top fixed hidden menu">
  <div class="ui container">
        <a class="active item" href="/harrier/jsp/home.jsp">About</a>
	    <a class="item" href="/harrier/jsp/codex.jsp">Codex</a>
	    <a class="item" href="/harrier/jsp/main.jsp">Siths</a>
	    <a class="item" href="/harrier/jsp/contact.jsp">Contact</a>
    <div class="right menu">
      <div class="item">
        <a class="ui button" href="/harrier/jsp/login.jsp">Log in</a>
      </div>
      <div class="item">
        <a class="ui primary button" href="/harrier/jsp/signup.jsp">Sign Up</a>
      </div>
    </div>
  </div>
</div>

<!-- Sidebar Menu -->
<div class="ui vertical inverted sidebar menu">
        <a class="active item" href="/harrier/jsp/home.jsp">About</a>
	    <a class="item" href="/harrier/jsp/codex.jsp">Codex</a>
	    <a class="item" href="/harrier/jsp/main.jsp">Siths</a>
	    <a class="item" href="/harrier/jsp/contact.jsp">Contact</a>
  <a class="item" href="/harrier/jsp/login.jsp">Login</a>
  <a class="item" href="/harrier/jsp/signup.jsp">Signup</a>
</div>


<!-- Page Contents -->

  <div class="ui inverted vertical masthead center aligned segment" id="mastHead">

    <div class="ui container">
      <div class="ui large secondary inverted pointing menu">
        <a class="toc item">
          <i class="sidebar icon"></i>
        </a>
        <a class="active item" href="/harrier/jsp/home.jsp">About</a>
	    <a class="item" href="/harrier/jsp/codex.jsp">Codex</a>
	    <a class="item" href="/harrier/jsp/main.jsp">Siths</a>
	    <a class="item" href="/harrier/jsp/contact.jsp">Contact</a>
        <div class="right item">
          <a class="ui inverted button" href="/harrier/jsp/login.jsp">Log in</a>
          <a class="ui inverted button" href="/harrier/jsp/signup.jsp">Sign Up</a>
        </div>
      </div>
    </div>

    <div class="ui text container">
      <h1 class="ui inverted header">
        HARRIER
      </h1>
      <h2>Do whatever you want when you want to.</h2>
      <a href="register.html" class="ui huge primary button">Get Started <i class="right arrow icon"></i></a>
     
    </div>

  </div>

  <div class="ui vertical stripe segment" style="margin:0 2em 0 2em;">
    <div class="ui middle aligned stackable grid container">
      <div class="row">
        <div class="eight wide column">
          <h3 class="ui header">Быть ситхом - значит, ощущать свободу и познать вкус победы</h3>
			<p>Покой — ложь, есть только страсть.<br />
			Через страсть я получаю силу.<br />
			Через силу я получаю могущество.<br />
			Через могущество я получаю победу.<br />
			Через победу мои оковы будут разрушены.<br />
			Сила освободит меня.</p>         
	 	  <h3 class="ui header">Выкованные пламенем</h3>
         <p>«Если ты будешь помогать каждому, кто страдает в этой галактике - 
         ты лишь ослабишь себя... и ослабишь их. Это внутренняя борьба. 
         Только борясь сам с собой, ты получишь истинную награду... 
         Так что если тебя заботят другие, то забудь о жалости 
         и самопожертвовании, и позволь сражаться им в 
         их собственных битвах самим.»</p>
        </div>
        <div class="six wide right floated column">
          <img src="static/assets/images/wireframe/Imperial_Emblem.svg" class="ui large bordered rounded image">
        </div>
      </div>
      <div class="row">
        <div class="center aligned column">
          <a class="ui huge button">Check Them Out</a>
        </div>
      </div>
    </div>
  </div>

<div class="ui middle aligned stackable grid container" style="margin-top:2em; background-color:#ffffff;">
  <div class="ui vertical stripe quote segment" style="margin:0 2em 0 2em;">
    <div class="ui equal width stackable internally celled grid" >
      <div class="center aligned row" >
        <div class="column">
          <h3 class="ui header">"Темная сторона"</h3>
          <p>Тёмная сторона Силы - философия Силы, основной идеей 
          которой служило преобразование своих эмоций, в частности, негативных, таких как страх, 
          гнев и ненависть, в источник увеличения собственной мощи, для достижения, в основном, могущества. 
          Абсолютная противоположность Светлой стороне, а её основные 
          последователи, ситхи - заклятые враги джедаев.</p>
        </div>
        <div class="column">
          <h3 class="ui header">"Ты слушаешь, мальчик? Джедаи мертвы. Но есть и другой путь — Тёмная Сторона."</h3>
          <p>
            <img src="static/assets/images/avatar/nan.jpg" class="ui avatar image"> <b>Nan</b>  Гранд-инквизитор.
          </p>
        </div>
      </div>
    </div>
  </div>

  <div  id ="Sblock" class="ui vertical stripe segment">
    <div class="ui text container">
      <h3 class="ui header">Питаемые страстью</h3>
      <p>Краеугольным камнем мощи ситхов являлись их эмоции. В то время как джедаи считали, что страх, гнев и боль - это негативные эмоции, которые необходимо преодолевать и подавлять, ситхи верили, что эти сильные эмоции естественны и необходимы для выживания. Больше того, ситхи считали, что страсть - это единственный способ полностью постичь Силу. Тем не менее, ситхи также считали, что только сильный способен контролировать свои эмоции и использовать их, в то время как слабый контролировался собственными эмоциями..</p>
      <a class="ui large button">Read More</a>
      <h4 class="ui horizontal header divider">
        <a href="#">Case Studies</a>
      </h4>
      <h3 class="ui header">Сила изменит вас. Преобразует.</h3>
      <p>Основное значение слов Кодекса ситхов, равно как и то, что он пропагандирует, очевидно. Ситхи заявляли, что используя эмоции, ситх может получить огромную власть, при жизни объединившись с Великой Силой. Власть эта будет иметь более материальное представление в виде господства и богатств. Свободно поддаваясь эмоциям, объединив мощь учения ситхов с Силой, тёмные джедаи надеялись достичь цели, написанной в конце кодекса.</p>
      <a class="ui large button">I'm Still Quite Interested</a>
    </div>
  </div>
</div>
	
	<c:import url="fragments/footer.jsp" />
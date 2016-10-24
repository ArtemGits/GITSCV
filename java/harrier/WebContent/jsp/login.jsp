<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	
	
	<c:import url="fragments\head.jsp" />
	<body>



<!-- Following Menu -->
<div class="ui large top fixed hidden menu">
  <div class="ui container">
 		<a class="item" href="/harrier/jsp/home.jsp">About</a>
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
   		<a class="item" href="/harrier/jsp/home.jsp">About</a>
	    <a class="item" href="/harrier/jsp/codex.jsp">Codex</a>
	    <a class="item" href="/harrier/jsp/main.jsp">Siths</a>
	    <a class="item" href="/harrier/jsp/contact.jsp">Contact</a>
  <a class=" active item" href="/harrier/jsp/login.jsp">Login</a>
  <a class="item" href="/harrier/jsp/signup.jsp">Signup</a>
</div>


<!-- Page Contents -->

  <div class="ui inverted vertical masthead center aligned segment" id="mastHead">

    <div class="ui container">
      <div class="ui large secondary inverted pointing menu">
        <a class="toc item">
          <i class="sidebar icon"></i>
        </a>
 		<a class="item" href="/harrier/jsp/home.jsp">About</a>
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
     
    </div>

  </div>

<div class="ui middle aligned center aligned grid">
  <div class="column">
    <h2 class="ui teal image header">
      <img src="static/assets/images/logo.png" class="image">
      
        Log-in to your account
     
 
    </h2>
    <form class="ui large form" method ="post" action = "login">
      <div class="ui stacked segment" style="margin:1em 3em 1em 3em;">
        <div class="field">
          <div class="ui left icon input">
            <i class="user icon"></i>
            <input type="text" name="email" placeholder="E-mail address">
          </div>
        </div>
        <div class="field">
          <div class="ui left icon input">
            <i class="lock icon"></i>
            <input type="password" name="password" placeholder="Password">
          </div>
        </div>
       
        <input type="submit" class="ui gray submit button" value="Login" style="margin-top:0.5em;" />
      </div>

      <div class="ui error message"></div>

    </form>

    <div class="ui message">
      New to us? <a href="register.html">Sign Up</a>
    </div>
  </div>
</div>
	
	<c:import url="fragments\footer.jsp" />
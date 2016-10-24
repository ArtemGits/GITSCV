<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	
	
	<c:import url="fragments\head.jsp" />
	<body>

<!-- Following Menu -->
<div class="ui large top fixed hidden menu">
  <div class="ui container">
    <a class=" item" href="/harrier/jsp/home.jsp">About</a>
    <a class="item" href="/harrier/jsp/codex.jsp">Codex</a>
    <a class="item" href="/harrier/jsp/main.jsp">Siths</a>
    <a class="active item" href="/harrier/jsp/contact.jsp">Contact</a>
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
    <a class=" item" href="/harrier/jsp/home.jsp">About</a>
    <a class="item" href="/harrier/jsp/codex.jsp">Codex</a>
    <a class="item" href="/harrier/jsp/main.jsp">Siths</a>
    <a class="active item" href="/harrier/jsp/contact.jsp">Contact</a>
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
     <a class=" item" href="/harrier/jsp/home.jsp">About</a>
    <a class="item" href="/harrier/jsp/codex.jsp">Codex</a>
    <a class="item" href="/harrier/jsp/main.jsp">Siths</a>
    <a class="active item" href="/harrier/jsp/contact.jsp">Contact</a>
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


<div id="whiteContainer" class="ui text container" style="margin-top:1.5em;">
   
    Quisque sit amet est et sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed, commodo vitae, ornare sit amet, wisi. Aenean fermentum, elit eget tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus lacus enim ac dui. Donec non enim in turpis pulvinar facilisis. Ut felis. Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus</p>
    <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed, commodo vitae, ornare sit amet, wisi. Aenean fermentum, elit eget tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus lacus enim ac dui. Donec non enim in turpis pulvinar facilisis. Ut felis. Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus</p>
    <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed, commodo vitae, ornare sit amet, wisi. Aenean fermentum, elit eget tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus lacus enim ac dui. Donec non enim in turpis pulvinar facilisis. Ut felis. Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus</p>
  
  
  
  
  
  
  </div>
<div class="ui text container" style="margin-top:1.5em;">
<form action="index.html" >
    <fieldset class="contact-inner">
      <p class="contact-input">
        <input type="text" name="name" placeholder="Your Name…" autofocus>
      </p>

      <p class="contact-input">
        <label for="select" class="select">
          <select name="subject" id="select">
            <option value="" selected>Choose Subject…</option>
            <option value="1">I have a suggestion</option>
            <option value="1">I found a bug</option>
            <option value="1">Other</option>
          </select>
        </label>
      </p>

      <p class="contact-input">
        <textarea name="message" placeholder="Your Message…"></textarea>
      </p>

      <p class="contact-submit">
        <input type="submit" value="Send Message">
      </p>
    </fieldset>
  </form>
 

</div>
 
	
	<c:import url="fragments\footer.jsp" />
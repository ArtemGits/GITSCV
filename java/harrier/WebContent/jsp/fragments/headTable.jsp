<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	
	<c:import url="fragments\head.jsp" />
	<body>

    <!-- Following Menu -->
<div class="ui large top fixed hidden menu">
  <div class="ui container">
     <a class="item" href="/harrier/jsp/home.jsp">About</a>
	    <a class="item" href="/harrier/jsp/codex.jsp">Codex</a>
	    <a class="active item" href="/harrier/jsp/main.jsp">Siths</a>
	    <a class="item" href="/harrier/jsp/contact.jsp">Contact</a>
    <div class="right menu">
      <div class="item">
        <a class="ui button" href="login.html">Log in</a>
      </div>
      <div class="item">
        <a class="ui primary button" href="register.html">Sign Up</a>
      </div>
    </div>
  </div>
</div>

<!-- Page Contents -->

  
<div id="mastHead" style="width:100%;">
    <div class="ui container" >
      <div class="ui large secondary inverted pointing menu">
        <a class="toc item">
          <i class="sidebar icon"></i>
        </a>
  		<a class="item" href="/harrier/jsp/home.jsp">About</a>
	    <a class="item" href="/harrier/jsp/codex.jsp">Codex</a>
	    <a class="active item" href="/harrier/jsp/main.jsp">Siths</a>
	    <a class="item" href="/harrier/jsp/contact.jsp">Contact</a>
        <div class="right item">
          <a class="ui inverted button" href="/harrier/jsp/login.jsp">Log in</a>
          <a class="ui inverted button" href="/harrier/jsp/signup.jsp">Sign Up</a>
        </div>
      </div>
    </div>
</div>

    

  

  <div class="ui vertical stripe segment" style="margin:0 2em 0 2em;">
    <div class="ui middle aligned stackable grid container">
      <div class="row">
        <div class="text container" id="tableContainer">
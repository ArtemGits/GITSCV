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
  </div>
</div>

<!-- Sidebar Menu -->
<div class="ui vertical inverted sidebar menu">
 		<a class="item" href="/harrier/jsp/home.jsp">About</a>
	    <a class="item" href="/harrier/jsp/codex.jsp">Codex</a>
	    <a class="item" href="/harrier/jsp/main.jsp">Siths</a>
	    <a class="item" href="/harrier/jsp/contact.jsp">Contact</a>
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
      
      
       Successfully Login
     
 
    </h2>
    
<div class="ui large form">
	<div class="ui stacked segment"style="margin:1em 3em 1em 3em;">
	
	<p>Enjoy motherfucker</p><br/>
	<button type="button" onClick="location.href='login.html'" class="ui button">Login Form</button>
	</div>
</div>
</div>
   
  </div>



	
	<c:import url="fragments\footer.jsp" />
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	
	
	<c:import url="fragments\head.jsp" />
	<body>






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
    <h2 class="ui  image header" style="margin-top:1em;color:#ffffff;">
      New User Registration
    </h2>
    <form class="ui large form" method ="post" action = "register_user">
      <div class="ui stacked segment" style="margin:1em 3em 1em 3em;">
        <div class="field" id="inputField">
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
       
        <input type="submit" class="ui gray submit button" value="Submit" style="margin-top:0.5em;" />
      </div>

      <div class="ui error message"></div>

    </form>

    
  </div>
</div>
	
	<c:import url="fragments\footer.jsp" />
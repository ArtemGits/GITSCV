<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String Message = (String)request.getAttribute("Message"); %>

	
	
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
<div class="ui middle aligned center aligned grid">
  <div class="column">
    <h3 class="ui  image header" style="margin-top:1em;color:#ffffff;">
     Contact with us
    </h3>
				
					<form class="ui large form"   method="post" action="send_email">
					 <div class="ui text container" style="margin:1em 3em 1em 3em; background-color:#fff;'">
					
					<div class="field" style="margin-top:1em;"> Name
						<input type="text" id="pp-name" name="name"
							placeholder="enter your name here" title="Please enter your name"
							 aria-required="true" required style="margin-left:1em;">
							 
					
					</div>
					
					<div class="field" style="margin-top:1em;"> E-mail
						<input type="text"  name="email"
							placeholder="enter your email address here"
							title="Please enter your email address" 
							aria-required="true" required style="margin-left:1em;">
					</div>
					
					<div class="field" style="margin-top:1em;">Phone
						<input type="text"  name="phone"
							placeholder="enter your phone number here"
							title="Please enter your phone number" 
							aria-required="true" required style="margin-left:1em;">
					</div>
					
					<div class="field" style="margin-top:1em;">
						<textarea  name="message"
							placeholder="enter your message here" style="margin-left:1em;"></textarea>
					</div>
					<div>
					
						<%
						if(null != Message) {
							out.println(Message);
						}
						
						%>
					</div>
					<input type="submit" name="submit" value="Send Message" style="margin-top:1em;">
				</div>	
				</form>
					
				
				
				 
	</div>
</div>
 
	
	<c:import url="fragments\footer.jsp" />
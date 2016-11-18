<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <jsp:useBean id="List" scope="request" type="java.util.List<java.lang.String>"/> 
<% String email=(String)session.getAttribute("currentsession");%>

<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Theme Made By www.w3schools.com - No Copyright -->
  <title>Indra Spy</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
 
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link rel="stylesheet" type="text/css" href="stylesheet/style.css"/>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="app.js"></script>
 
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="ind_index.html" ><img src ="pictures/jedi-order-symbol-cellphone-swmand4.png"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="ind_index.html">ABOUT</a></li>
        <li><a href="ind_login.html">LOGIN</a></li>
         <li><a href="ind_register.html">REGISTER</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="jumbotron text-center">
  <h1>INDRA SPY</h1>
  <p>We specialize in spying on users.</p>
  
</div>

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-8" style="background-color:red;">
			<div>
		       <a class="navbar-brand" href="#"><span style="text-shadow: 0px 2px 6px #800000;font-size:17px;color:gold;font-family:inherit;"> Application using HIBERNATE,HTML5,CSS,BOOTSTRAP & SERVLET</span></a>
		    </div>
		</div>

				<div class="col-sm-4" style="background-color:red;">
					<div>
						<ul class="nav navbar-nav navbar-right">
							<li><a href="ind_index.html" style="color:white; font-size:14px;">Log Out</a></li>
						</ul>
					</div>
				</div>
	</div>
</div>


<table width="80%" align="center" style="margin-top:20px;">
<tr>
<td>
<form action="GetItems" method="post">

<div class="container text-center">
	<div class="row">
		<h2>Your Details</h2>

	<h3> Welcome to Your Account</h3>
	<h4>Your Email Id is: <span style="color:green;"><%=email %>
	</span><br/>
	</h4>
	<hr/>

	<input type="text" name="email" placeholder="please re enter email id">
	<button type="submit"  type="button" class="btn">CLICK ME AFTER ENTERING YOUR EMAIL ID</button>
	<hr/>
	
	
	
	
	</div>
</div>
</form>
</td><tr>
<td>
</td>
</tr>
</table>
		 <div class="container" width="80%" align="center" style="margin-top:20px;">
				<table  id="tableCenter" class="table table-bordered">
				 	 <tr>
				      <th>E-MAIL</th>
				      <th>NAME</th>
				      <th>BIKE</th>
				      <th>CAR</th>
				      <th>PROGRAMMING LANGUAGE</th>
				      <th>SOCIAL NETWORK</th>
				      <th>OS</th>
				      <th>PHONE NUMBER</th>
				      <th>DATA OF BIRTH</th>
				    </tr>
				  <tbody>
				     					<c:forEach items="${List}" var="item">
                                         
                                             <td>
                                             <c:out value="${item }"/>
                                             </td>
                                         	 
                                            
                                        </c:forEach>
				  </tbody>
				</table>


		</div>
 
<div  id ="footerContainer" class=container-fluid style="background-color:#000000;">
<footer class="container-fluid text-center">

  <a href="#myPage" title="To Top">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a>
  <p>INDRA SPY Made By <a href="#" title="Visit agits home page">www.agits.com</a></p>
</footer>
</div>

</body>
</html>



</body>
</html>

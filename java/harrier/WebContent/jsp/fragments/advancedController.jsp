<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="Achievments" scope="request" type="java.util.List<controllers.model.Achievements>"/>
<jsp:useBean id="Statuses" scope="request" type="java.util.List<controllers.model.Status>"/> 		
<jsp:useBean id="Teachers" scope="request" type="java.util.List<controllers.model.Teacher>"/>
<jsp:useBean id="Students" scope="request" type="java.util.List<controllers.model.Student>"/> 
<jsp:useBean id="Siths" scope="request" type="java.util.List<controllers.model.Siths>"/>
<script src="/harrier/static/advancedController.js"></script>
  <div class="eight wide column"  >
					        	<div class="ui stacked segment" style="overflow: auto;">
					        	
					        	<div id="advancedController">
					        	<script id="AchievementsBlock" language="text">
								
								
					        	<table class="ui selectable inverted table" >
									<h1>Achievements</h1>
								  <thead>
								    <tr>
								      <th>ID</th>
								      <th>KILS</th>
								      <th>DUELS</th>
								      <th>WINS</th>
								      <th>LOSES</th>
								    </tr>
								  </thead>
								  <tbody>
								     					<c:forEach items="${Achievments}" var="item">
				                                         <tr>
				                                             <td id="id" >${item.id}</td>
				                                         	 <td>${item.kills}</td>
													         <td>${item.duels}</td>
													         <td>${item.wins}</td>
													         <td>${item.loses}</td> 
				                                         </tr>   
				                                        </c:forEach>
								  </tbody>
								</table>
					        	
					        	</script>
					        	
					        	<script id="SithsBlock" language="text">
								
								
					        	<table class="ui selectable inverted table">
								  <h1>Siths</h1>
									<thead>
								    <tr>
								      <th>ID</th>
								      <th>RANG</th>
								      <th>ID_STATUS</th>
								      <th>OLD_NAME</th>
								      <th>NEW_NAME</th>
								      <th>AGE</th>
								      <th>HOME</th>
									  <th>CANON</th>
								      <th>HISTORY</th>
								    </tr>
								  </thead>
								  <tbody>
								     					<c:forEach items="${Siths}" var="item">
				                                         <tr>
				                                             <td id="id" >${item.id}</td>
				                                         	 <td>${item.rang}</td>
													         <td>${item.id_status}</td>
													         <td>${item.old_name}</td>
													         <td>${item.new_name}</td> 
													         <td>${item.age}</td>
													         <td>${item.home}</td>
													         <td>${item.canon}</td>
													         <td>${item.history}</td> 
				                                         </tr>   
				                                        </c:forEach>
								  </tbody>
								</table>
					        	
					        	</script>
					        	
					        	<script id="StatusBlock" language="text">
								
								
					        	<table class="ui selectable inverted table" >
								  <h1>Status</h1>
									<thead>
								    <tr>
								      <th>ID</th>
								      <th>STATUS</th>
								      
								    </tr>
								  </thead>
								  <tbody>
								     					<c:forEach items="${Statuses}" var="item">
				                                         <tr>
				                                             <td id="id" >${item.id}</td>
				                                         	 <td>${item.status}</td>
													         
				                                         </tr>   
				                                        </c:forEach>
								  </tbody>
								</table>
					        	
					        	</script>
					        	
					        	<script id="TeacherBlock" language="text">
								
								
					        	<table class="ui selectable inverted table" >
								  <h1>Teachers</h1>
								  <thead>
								    <tr>
								      <th>ID</th>
								     <th>SITH_ID</th>
								    </tr>
								  </thead>
								  <tbody>
								     					<c:forEach items="${Teachers}" var="item">
				                                         <tr>
				                                             <td id="id" >${item.id}</td>
				                                         	  <td>${item.sith_id}</td>
				                                         </tr>   
				                                        </c:forEach>
								  </tbody>
								</table>
					        	
					        	</script>
					        	
					        	<script id="StudentBlock" language="text">
								
								
					        	<table class="ui selectable inverted table" >
								  <h1>Students</h1>
								  <thead>
								    <tr>
								      <th>ID</th>
								      <th>ID_STUDENT</th>
								      <th>ID_TEACHER</th>
								    </tr>
								  </thead>
								  <tbody>
								     					<c:forEach items="${Students}" var="item">
				                                         <tr>
				                                             <td id="id" >${item.id}</td>
				                                         	 <td>${item.id_student}</td>
													         <td>${item.id_teacher}</td>
				                                         </tr>   
				                                        </c:forEach>
								  </tbody>
								</table>
					        	
					        	</script>
					        	
					        		
					        	</div>
					        	
					        	
					        	</div>
					        	<div class="ui stacked segment">
							          <a title="" class="ui  button" onclick="getAllAchievements()">Get all achievements</a>
		      						  <a title="" class="ui  button" onclick="getAllSiths()">Get all siths</a>
		      						  <a title="" class="ui  button" onclick="getAllStatus()">Get all status</a>
		      						  <a title="" style="margin-top:0.3em;" class="ui  button" onclick="getAllStudents()">Get all students</a>
		      						  <a title="" style="margin-top:0.3em;" class="ui  button" onclick="getAllTeachers()">Get all teachers</a>
					        	</div>
					        </div>
					      
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="Students" scope="request" type="java.util.List<controllers.model.Student>"/>



<c:import url="fragments\headTable.jsp" />
<script src="/harrier/static/studentController.js"></script>	
				<table class="ui selectable inverted table" id="tableCenterStudent">
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
        

	<c:import url="fragments\studentFooter.jsp" />


                        
                                
                                    
                                       
                                       
                                        
                                    
                       
                   
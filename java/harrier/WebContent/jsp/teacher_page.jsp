<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <jsp:useBean id="Teachers" scope="request" type="java.util.List<controllers.model.Teacher>"/>



<c:import url="fragments\headTable.jsp" />
<script src="/harrier/static/teacherController.js"></script>	
				<table class="ui selectable inverted table" id="tableCenterTeacher">
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
        

	<c:import url="fragments\teacherFooter.jsp" />


                        
                                
                                    
                                       
                                       
                                        
                                    
                       
                   
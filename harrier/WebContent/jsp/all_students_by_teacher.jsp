<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <jsp:useBean id="StudentsByTeacher" scope="request" type="java.util.List<controllers.model.Sith>"/> 


<c:import url="fragments\headTable.jsp" />
	
				<table class="ui selectable inverted table" id="tableCenter">
				  <thead>
				    <tr>
				      <th>OLD NAME</th>
				      <th>NEW NAME</th>
				      <th>HOME</th>
				      <th>RANG</th>
				      <th>AGE</th>
				      <th>ID_STATUS</th>
				      <th>CANON</th>
				      <th>HISTORY</th>
				    </tr>
				  </thead>
				  <tbody>
				     					<c:forEach items="${StudentsByTeacher}" var="sithTeach">
                                         <tr>
                                         	<td>${sithTeach.old_name}</td>
                                         	<td>${sithTeach.new_name}</td>
                                            <td>${sithTeach.home}</td>
                                            <td>${sithTeach.rang}</td>
                                            <td>${sithTeach.age}</td>
                                            <td>${sithTeach.id_status}</td>
                                            <td>${sithTeach.canon}</td>
                                            <td>${sithTeach.history}</td>
                                         </tr>   
                                        </c:forEach>
				  </tbody>
				</table>
        

	<c:import url="fragments\footerTable.jsp" />


                        
                                
                                    
                                       
                                       
                                        
                                    
                       
                   
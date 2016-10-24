<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <jsp:useBean id="AllSithsFromCanone" scope="request" type="java.util.List<controllers.model.Sith>"/> 


<c:import url="fragments\headTable.jsp" />
	
				<table class="ui selectable inverted table" id="tableCenter">
				  <thead>
				    <tr>
				      <th>OLD NAME</th>
				      <th>NEW NAME</th>
				      <th>HOME</th>
				      <th>CANON</th>
				      <th>HISTORY</th>
				    </tr>
				  </thead>
				  <tbody>
				     					<c:forEach items="${AllSithsFromCanone}" var="teach">
                                         <tr>
                                         	<td>${teach.old_name}</td>
                                         	<td>${teach.new_name}</td>
                                            <td>${teach.home}</td>
                                            <td>${teach.canon}</td>
                                            <td>${teach.history}</td>
                                         </tr>   
                                        </c:forEach>
				  </tbody>
				</table>
        

	<c:import url="fragments\footerTable.jsp" />


                        
                                
                                    
                                       
                                       
                                        
                                    
                       
                   
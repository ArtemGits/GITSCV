<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <jsp:useBean id="SithsByHome" scope="request" type="java.util.List<controllers.model.Siths>"/> 


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
				     					<c:forEach items="${SithsByHome}" var="sithHome">
                                         <tr>
                                         	<td>${sithHome.old_name}</td>
                                         	<td>${sithHome.new_name}</td>
                                            <td>${sithHome.home}</td>
                                            <td>${sithHome.rang}</td>
                                            <td>${sithHome.age}</td>
                                            <td>${sithHome.id_status}</td>
                                            <td>${sithHome.canon}</td>
                                            <td>${sithHome.history}</td>
                                         </tr>   
                                        </c:forEach>
				  </tbody>
				</table>
        

	<c:import url="fragments\footerTable.jsp" />


                        
                                
                                    
                                       
                                       
                                        
                                    
                       
                   
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <jsp:useBean id="SithsByRang" scope="request" type="java.util.List<controllers.model.Siths>"/> 


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
				     					<c:forEach items="${SithsByRang}" var="sithRang">
                                         <tr>
                                         	<td>${sithRang.old_name}</td>
                                         	<td>${sithRang.new_name}</td>
                                            <td>${sithRang.home}</td>
                                            <td>${sithRang.rang}</td>
                                            <td>${sithRang.age}</td>
                                            <td>${sithRang.id_status}</td>
                                            <td>${sithRang.canon}</td>
                                            <td>${sithRang.history}</td>
                                         </tr>   
                                        </c:forEach>
				  </tbody>
				</table>
        

	<c:import url="fragments\footerTable.jsp" />


                        
                                
                                    
                                       
                                       
                                        
                                    
                       
                   
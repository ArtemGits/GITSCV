<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  <jsp:useBean id="teachers" scope="request" type="java.util.List<controllers.model.Teacher>"/> 


<c:import url="fragments\headTable.jsp" />
	
				<table class="ui selectable inverted table" id="tableCenter">
				  <thead>
				    <tr>
				      <th>OLD NAME</th>
				      <th>NEW NAME</th>
				      <th class="right aligned">HOME</th>
				    </tr>
				  </thead>
				  <tbody>
				     					<c:forEach items="${teachers}" var="teach">
                                         <tr>
                                         	<td>${teach.old_name}</td>
                                         	<td>${teach.new_name}</td>
                                            <td>${teach.home}</td>
                                         </tr>   
                                        </c:forEach>
				  </tbody>
				</table>
        

	<c:import url="fragments\footerTable.jsp" />


                        
                                
                                    
                                       
                                       
                                        
                                    
                       
                   
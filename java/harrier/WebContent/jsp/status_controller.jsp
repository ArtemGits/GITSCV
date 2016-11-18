<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <jsp:useBean id="Statuses" scope="request" type="java.util.List<controllers.model.Status>"/>



<c:import url="fragments\headTable.jsp" />
<script src="/harrier/static/statusController.js"></script>	
				<table class="ui selectable inverted table" id="tableCenterStatus">
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
        

	<c:import url="fragments\statusFooter.jsp" />


                        
                                
                                    
                                       
                                       
                                        
                                    
                       
                   
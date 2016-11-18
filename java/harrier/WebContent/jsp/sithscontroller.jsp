<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="Siths" scope="request" type="java.util.List<controllers.model.Siths>"/>


<c:import url="fragments\headTable.jsp" />
<script src="/harrier/static/sithController.js"></script>	
				<table class="ui selectable inverted table" id="tableCenterSith">
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
        

	<c:import url="fragments\sithFooter.jsp" />


                        
                                
                                    
                                       
                                       
                                        
                                    
                       
                   
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <jsp:useBean id="Achievments" scope="request" type="java.util.List<controllers.model.Achievements>"/>



<c:import url="fragments\headTable.jsp" />
<script src="/harrier/static/usersClientController.js"></script>	
				<table class="ui selectable inverted table" id="tableCenter">
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
        

	<c:import url="fragments\achieveFooter.jsp" />


                        
                                
                                    
                                       
                                       
                                        
                                    
                       
                   
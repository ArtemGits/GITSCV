<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <jsp:useBean id="AchieveBySith" scope="request" type="java.util.List<controllers.model.Sith>"/> 


<c:import url="fragments\headTable.jsp" />
	
				<table class="ui selectable inverted table" id="tableCenter">
				  <thead>
				    <tr>
				      <th>NEW NAME</th>
				      <th>HOME</th>
				      <th>RANG</th>
				      <th>AGE</th>
				      <th>KILS</th>
				      <th>DUELS</th>
				      <th>WINS</th>
				      <th>LOSES</th>
				    </tr>
				  </thead>
				  <tbody>
				     					<c:forEach items="${AchieveBySith}" var="inst">
                                <c:forEach items="${inst}" var="insta">
                                   
                                        
                                       
                                        
                                        <c:forEach items="${insta.value}" var="item" >
                                        <tr>
									         
									         <td>${insta.key.new_name}</td>
									         <td>${insta.key.home}</td>
									         <td>${insta.key.rang}</td>
									         <td>${insta.key.age}</td>
									         <td>${item.kills}</td>
									         <td>${item.duels}</td>
									         <td>${item.wins}</td>
									         <td>${item.loses}</td> 
									    </tr>     
									    </c:forEach>
									    
                                   
                                </c:forEach>
                            </c:forEach>
				  </tbody>
				</table>
        

	<c:import url="fragments\footerTable.jsp" />


                        
                                
                                    
                                       
                                       
                                        
                                    
                       
                   
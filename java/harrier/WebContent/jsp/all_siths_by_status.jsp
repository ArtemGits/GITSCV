<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <jsp:useBean id="SithsByStatus" scope="request" type="java.util.List<controllers.model.Siths>"/> 


<c:import url="fragments\headTable.jsp" />
	
				<table class="ui selectable inverted table" id="tableCenter">
				  <thead>
				    <tr>
				      <th>OLD NAME</th>
				      <th>NEW NAME</th>
				      <th>HOME</th>
				      <th>RANG</th>
				      <th>AGE</th>
				      <th>STATUS</th>
				      <th>CANON</th>
				      <th>HISTORY</th>
				    </tr>
				  </thead>
				  <tbody>
				     					<c:forEach items="${SithsByStatus}" var="inst">
                                <c:forEach items="${inst}" var="insta">
                                   
                                        
                                       
                                        
                                        <c:forEach items="${insta.value}" var="item" >
                                        <tr>
									         <td>${item.old_name}</td>
									         <td>${item.new_name}</td>
									         <td>${item.home}</td>
									         <td>${item.rang}</td>
									         <td>${item.age}</td>
									         <td>${insta.key.status}</td>
									         <td>${item.canon}</td>
									         <td>${item.history}</td>
									    </tr>     
									    </c:forEach>
									    
                                   
                                </c:forEach>
                            </c:forEach>
				  </tbody>
				</table>
        

	<c:import url="fragments\footerTable.jsp" />


                        
                                
                                    
                                       
                                       
                                        
                                    
                       
                   
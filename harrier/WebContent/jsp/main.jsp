<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	
	
	<c:import url="fragments\headTable.jsp" />
	
				<table class="ui selectable inverted table" id="tableCenter">
				  <thead>
				    <tr>
				      <th>Name</th>
				      <th>Status</th>
				      <th class="right aligned">Notes</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>
				      <td>John</td>
				      <td>Approved</td>
				      <td class="right aligned">None</td>
				    </tr>
				    <tr>
				      <td>Jamie</td>
				      <td>Approved</td>
				      <td class="right aligned">Requires call</td>
				    </tr>
				    <tr>
				      <td>Jill</td>
				      <td>Denied</td>
				      <td class="right aligned">None</td>
				    </tr>
				  </tbody>
				</table>
        

	<c:import url="fragments\footerTable.jsp" />
	
	
	 
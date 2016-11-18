<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="Status" scope="request" type="controllers.model.Status"/> 

 		
        
        <div class="ui  stackable grid container" style="margin-top:1em;">
					      <div class="row">
					        <div class="eight wide column">
					          <form class="ui large form" method ="get" id="ResponseForm" enctype="application/x-www-form-urlencoded">
							      <div class="ui stacked segment">
							        <div class="field">
							          <div class="ui left icon input">
							          <div>ID</div>
							            <input type="text" name="id" value='${Status.id}'>
							          </div>
							        </div>
							        <div class="field">
							          <div class="ui left icon input">
							          <div>Status</div>
							            <input type="text" name="status" value='${Status.status}' >
							          </div>
							        </div>
							       
							        
							       
							        
							       
							       
							      </div>
							
							      <div class="ui error message"></div>
								  <input id="idNote" type="hidden" name="HiddenId"> 
							   </form>
      
						<div class="row">
					      	 
					          <a  title="" class="ui  button" onclick="status_create()">Create</a>
					          <a title="" class="ui  button" onclick="status_update()">Update</a>
					          <a title=" " class="ui  button" onclick="status_delete()">Delete</a>
					          
					      
					   </div>
					          
					        </div>
					       
					        
					        <c:import url="fragments\advancedController.jsp" />
					      </div>
					      
					      
		</div>
		 
</div>
      
       
      
    </div>
  </div>
</div>
<c:import url="fragments\footer.jsp" />
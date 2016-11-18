<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="Teacher" scope="request" type="controllers.model.Teacher"/> 

 		
        
        <div class="ui  stackable grid container" style="margin-top:1em;">
					      <div class="row">
					        <div class="eight wide column">
					          <form class="ui large form" method ="get" id="ResponseForm" enctype="application/x-www-form-urlencoded">
							      <div class="ui stacked segment">
							        <div class="field">
							          <div class="ui left icon input">
							          <div>ID</div>
							            <input type="text" name="id" value='${Teacher.id}'>
							          </div>
							        </div>
							        <div class="field">
							          <div class="ui left icon input">
							          <div>SITH_ID</div>
							            <input type="text" name="sith_id" value='${Teacher.sith_id}'>
							          </div>
							        </div>
							        
							       
							       
							        
							       
							        
							       
							       
							      </div>
							
							      <div class="ui error message"></div>
								  <input id="idNote" type="hidden" name="HiddenId"> 
							   </form>
      
						<div class="row">
					      	 
					          <a  title="" class="ui  button" onclick="teacher_create()">Create</a>
					          <a title="" class="ui  button" onclick="teacher_update()">Update</a>
					          <a title=" " class="ui  button" onclick="teacher_delete()">Delete</a>
					          
					      
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
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="Student" scope="request" type="controllers.model.Student"/> 

 		
        
        <div class="ui  stackable grid container" style="margin-top:1em;">
					      <div class="row">
					        <div class="eight wide column">
					          <form class="ui large form" method ="get" id="ResponseForm" enctype="application/x-www-form-urlencoded">
							      <div class="ui stacked segment">
							        <div class="field">
							          <div class="ui left icon input">
							          <div>ID</div>
							            <input type="text" name="id" value='${Student.id}'>
							          </div>
							        </div>
							        <div class="field">
							          <div class="ui left icon input">
							          <div>ID_student</div>
							            <input type="text" name="id_student" value='${Student.id_student}' >
							          </div>
							        </div>
							        <div class="field">
							          <div class="ui left icon input">
							          <div>ID_teacher</div>
							            <input type="text" name="id_teacher" value='${Student.id_teacher}' >
							          </div>
							        </div>
							       
							        
							       
							        
							       
							       
							      </div>
							
							      <div class="ui error message"></div>
								  <input id="idNote" type="hidden" name="HiddenId"> 
							   </form>
      
						<div class="row">
					      	 
					          <a  title="" class="ui  button" onclick="student_create()">Create</a>
					          <a title="" class="ui  button" onclick="student_update()">Update</a>
					          <a title=" " class="ui  button" onclick="student_delete()">Delete</a>
					          
					      
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
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="Sith" scope="request" type="controllers.model.Siths"/> 
        
        <div class="ui  stackable grid container" style="margin-top:1em;">
					      <div class="row">
					        <div class="eight wide column">
					          <form class="ui large form" method ="get" id="ResponseForm" enctype="application/x-www-form-urlencoded">
							      <div class="ui stacked segment">
							        <div class="field">
							          <div class="ui left icon input">
							          <div>ID</div>
							            <input type="text" name="id" value='${Sith.id}'>
							          </div>
							        </div>
							        <div class="field">
							          <div class="ui left icon input">
							          <div>RANG</div>
							            <input type="text" name="rang" value='${Sith.rang}' >
							          </div>
							        </div>
							         <div class="field">
							          <div class="ui left icon input">
							          <div>ID_STATUS</div>
							            <input type="text" name="id_status" value='${Sith.id_status}'>
							          </div>
							        </div>
							         <div class="field">
							          <div class="ui left icon input">
							          <div>OLD_NAME</div>
							            <input type="text" name="old_name" value='${Sith.old_name}'>
							          </div>
							        </div>
							        <div class="field">
							          <div class="ui left icon input">
							          <div>NEW_NAME</div>
							            <input type="text" name="new_name" value='${Sith.new_name}'>
							          </div>
							        </div>
							        <div class="field">
							          <div class="ui left icon input">
							          <div>AGE</div>
							            <input type="text" name="age" value='${Sith.age}'>
							          </div>
							        </div>
							        <div class="field">
							          <div class="ui left icon input">
							          <div>HOME</div>
							            <input type="text" name="home" value='${Sith.home}'>
							          </div>
							        </div>
							        <div class="field">
							          <div class="ui left icon input">
							          <div>CANON</div>
							            <input type="text" name="canon" value='${Sith.canon}'>
							          </div>
							        </div>
							        <div class="field">
							          <div class="ui left icon input">
							          <div>HISTORY</div>
							            <input type="text" name="history" value='${Sith.history}'>
							          </div>
							        </div>
							        
							       
							       
							      </div>
							
							      <div class="ui error message"></div>
								  <input id="idNote" type="hidden" name="HiddenId"> 
							   </form>
      
						<div class="row">
					      	 
					          <a  title="" class="ui  button" onclick="sith_create()">Create</a>
					          <a title="" class="ui  button" onclick="sith_update()">Update</a>
					          <a title="" class="ui  button" onclick="sith_delete()">Delete</a>
					          
					      
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
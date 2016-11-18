<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="Achieve" scope="request" type="controllers.model.Achievements"/> 

 		
        
        <div class="ui  stackable grid container" style="margin-top:1em;">
					      <div class="row">
					        <div class="eight wide column">
					          <form class="ui large form" method ="get" id="ResponseForm" enctype="application/x-www-form-urlencoded">
							      <div class="ui stacked segment">
							        <div class="field">
							          <div class="ui left icon input">
							          <div>ID</div>
							            <input type="text" name="id" value='${Achieve.id}'>
							          </div>
							        </div>
							        <div class="field">
							          <div class="ui left icon input">
							          <div>Duels</div>
							            <input type="text" name="duels" value='${Achieve.duels}' >
							          </div>
							        </div>
							         <div class="field">
							          <div class="ui left icon input">
							          <div>Wins</div>
							            <input type="text" name="wins" value='${Achieve.wins}'>
							          </div>
							        </div>
							         <div class="field">
							          <div class="ui left icon input">
							          <div>Loses</div>
							            <input type="text" name="loses" value='${Achieve.loses}'>
							          </div>
							        </div>
							        <div class="field">
							          <div class="ui left icon input">
							          <div>Kills</div>
							            <input type="text" name="kills" value='${Achieve.kills}'>
							          </div>
							        </div>
							        
							       
							       
							      </div>
							
							      <div class="ui error message"></div>
								  <input id="idNote" type="hidden" name="HiddenId"> 
							   </form>
      
						<div class="row">
					      	 
					          <a  title="" class="ui  button" onclick="achieve_create()">Create</a>
					          <a title="" class="ui  button" onclick="achieve_update()">Update</a>
					          <a title=" " class="ui  button" onclick="achieve_delete()">Delete</a>
					          
					      
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
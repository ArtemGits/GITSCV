<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


 		<div class="center aligned column">
          <a title="Вывести всех ситхов" class="ui  button" href="/harrier/all_siths">All siths</a>
          <a  title="Вывести самого результативного" class="ui  button" href="/harrier/best_sith_by_status">High result</a>
          <a title="Вывести всех кто есть в каноне" class="ui  button" href="/harrier/all_from_canone">Canone</a>
          <a title=" Вывести всех кто есть в историях" class="ui  button" href="/harrier/all_from_history">History</a>
          
          <div class="right aligned colum" id="userController">
          		<a title="Добавить достижения" class="ui  button" href="/harrier/achievments">Achievments controller</a>
          		<a title="Добавить ситха" class="ui  button" href="/harrier/siths_controller">Siths controller</a>
	            <a title="Добавить статус" class="ui  button" href="/harrier/status_controller">Status controller</a>
	            <a title="Добавить нового ученика" class="ui  button" href="/harrier/student_page">Students controller</a>
	            <a title="Добавить нового учителя" class="ui  button" href="/harrier/teacher_page">Teacher controller</a>
	            
	             
          </div>
          
        </div>
        
        <div class="ui middle aligned stackable grid container" style="margin-top:1em;">
					      <div class="row">
					        <div class="eight wide column">
					          <form action="/harrier/sihts_by_home" method="GET">
					          	<p> Вывести всех с одной родины. <b>Введите родину:</b><br>
								   <input  name="home" type="text" size="10">
								   <input type="submit" value="Show result">
							    </p>
					          </form>
					          <form action="/harrier/stuents_for_teacher" method="GET">
					          	<p>Вывести всех у кого общий учитель. <b>Введите имя учителя:</b><br>
								   <input  name="tname" type="text" size="10">
								   <input type="submit" value="Show result">
							    </p>
					          </form>
					           <form action="/harrier/teacher_by_student" method="GET">
					          	<p>Вывести Учителя ученика. <b>Введите имя ученика:</b><br>
								   <input  name="sname" type="text" size="10">
								   <input type="submit" value="Show result">
							    </p>
					          </form>
      

					          
					        </div>
					        <div class="eight wide column" >
					          <form action="/harrier/siths_by_rang" method="POST">
					          	<p> Вывести всех у кого определенный ранг. <b>Введите ранг:</b><br>
								   <input  name="rang" type="text" size="10">
								   <input type="submit" value="Show result">
							    </p>
					          </form>
					          <form action="/harrier/siths_by_status" method="POST">
					          	<p>Вывести всех у кого определенный статус. <b>Введите статус:</b><br>
								   <input  name="status" type="text" size="10">
								   <input type="submit" value="Show result">
							    </p>
					          </form>
					           <form action="/harrier/achieve_by_sith" method="POST">
					          	<p>Вывести достижения определенного ситха. <b>Введите имя ситха:</b><br>
								   <input  name="aname" type="text" size="10">
								   <input type="submit" value="Show result">
							    </p>
					          </form>
      
					        </div>
					      </div>
		</div>

</div>
      
       
      
    </div>
  </div>
</div>
<c:import url="fragments\footer.jsp" />
package servlets;

import controllers.Connections;

import controllers.model.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(name = "TeacherController", urlPatterns = "/teacher_controller")
public class TeacherController extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("HiddenId"));
		
		System.out.println("Hello"+ id);
		Teacher teacher = Connections.getFactory().getTeacherDao().getTeacher(id);
		
    	response.setContentType("text/plain");
		response.getWriter().write(teacher.toString());
    	
       
	}

    
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 int id = Integer.parseInt(request.getParameter("id"));
    	 int stage = Integer.parseInt(request.getParameter("sith_id"));
         
         boolean result = Connections.getFactory().getTeacherDao().updateTeacher(id,stage);
         System.out.println(result);
         if (result == true) {
        	 response.setStatus(200);
         } else {
        	 response.setStatus(500);
         }
    	
    }
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	System.out.println(id);
    	boolean result = Connections.getFactory().getTeacherDao().deleteTeacher(id);
        System.out.println(result);
        if (result == true) {
       	 response.setStatus(200);
        } else {
       	 response.setStatus(500);
        }
    	
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 int id = Integer.parseInt(request.getParameter("id"));
    	 int stage = Integer.parseInt(request.getParameter("sith_id"));
        boolean result = Connections.getFactory().getTeacherDao().createTeacher(new Teacher(id,stage));
        System.out.println(result);
        if (result == true) {
       	 response.setStatus(200);
        } else {
       	 response.setStatus(500);
        }
   	
   }
    
    
}

package servlets;

import controllers.Connections;
import controllers.Hibernate;
import controllers.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(name = "StudentController", urlPatterns = "/student_controller")
public class StudentController extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("HiddenId"));
		
		System.out.println("Hello"+ id);
		Student student = Connections.getFactory().getStudentDao().getStudent(id);
		//Hibernate.closeSession();
    	response.setContentType("text/plain");
		response.getWriter().write(student.toString());
    	
       
	}

    
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 int id = Integer.parseInt(request.getParameter("id"));
    	 int id_student = Integer.parseInt(request.getParameter("id_student"));
    	 int id_teacher = Integer.parseInt(request.getParameter("id_teacher"));
         
         boolean result = Connections.getFactory().getStudentDao().updateStudent(id,id_student,id_teacher);
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
    	boolean result = Connections.getFactory().getStudentDao().deleteStudent(id);
        System.out.println(result);
        if (result == true) {
       	 response.setStatus(200);
        } else {
       	 response.setStatus(500);
        }
    	
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 int id = Integer.parseInt(request.getParameter("id"));
	   	 int id_student = Integer.parseInt(request.getParameter("id_student"));
	   	 int id_teacher = Integer.parseInt(request.getParameter("id_teacher"));
	   	 
        boolean result = Connections.getFactory().getStudentDao().createStudent(new Student(id,id_student,id_teacher));
        System.out.println(result);
        //Hibernate.closeSession();
        if (result == true) {
       	 response.setStatus(200);
        } else {
       	 response.setStatus(500);
        }
   	
   }
    
    
}

package servlets;

import controllers.Connections;
import controllers.Hibernate;
import controllers.model.Achievements;
import controllers.model.Siths;
import controllers.model.Status;
import controllers.model.Student;
import controllers.model.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;



@WebServlet(name = "StudentPage", urlPatterns = "/student_page")
public class StudentPage extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = new Student();
    	List<Student> allStudents = Connections.getFactory().getStudentDao().getAll();
    	request.setAttribute("Students",allStudents);
    	request.setAttribute("Student",student);
    	//Hibernate.closeSession();
    	List<Teacher> allTeachers = Connections.getFactory().getTeacherDao().getAll();
    	request.setAttribute("Teachers",allTeachers);
    	List<Siths> allSiths = Connections.getFactory().getSithDao().getAll();
    	request.setAttribute("Siths",allSiths);
      	List<Status> allStatus = Connections.getFactory().getStatusDao().getAll();
    	request.setAttribute("Statuses",allStatus);
    	List<Achievements> allAchieve = Connections.getFactory().getAchieveDao().getAll();
    	request.setAttribute("Achievments",allAchieve);
    	
       request.getRequestDispatcher("jsp/students_page.jsp").forward(request, response);
    }
}

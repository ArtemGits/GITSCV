package servlets;

import controllers.Connections;
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



@WebServlet(name = "StatusController", urlPatterns = "/status_controller")
public class StatusController extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Status status = new Status();
    	List<Status> allStatus = Connections.getFactory().getStatusDao().getAll();
    	request.setAttribute("Statuses",allStatus);
    	request.setAttribute("Status",status);
    	
    	List<Teacher> allTeachers = Connections.getFactory().getTeacherDao().getAll();
    	request.setAttribute("Teachers",allTeachers);
    	List<Siths> allSiths = Connections.getFactory().getSithDao().getAll();
    	request.setAttribute("Siths",allSiths);
    	List<Student> allStudents = Connections.getFactory().getStudentDao().getAll();
    	request.setAttribute("Students",allStudents);
    	List<Achievements> allAchieve = Connections.getFactory().getAchieveDao().getAll();
    	request.setAttribute("Achievments",allAchieve);
    	
       request.getRequestDispatcher("jsp/status_controller.jsp").forward(request, response);
    }
}

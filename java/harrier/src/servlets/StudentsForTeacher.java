package servlets;

import controllers.Connections;
import controllers.model.Siths;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@WebServlet(name = "StudentsForTeacher", urlPatterns = "/stuents_for_teacher")
public class StudentsForTeacher extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	List<Siths> allStudentsByTeacher = Connections.getFactory().getSithDao().getStudentsByTeacherName(request.getParameter("tname"));
    	request.setAttribute("StudentsByTeacher",allStudentsByTeacher);
        System.out.println(allStudentsByTeacher);
        request.getRequestDispatcher("jsp/all_students_by_teacher.jsp").forward(request, response);
    }
}

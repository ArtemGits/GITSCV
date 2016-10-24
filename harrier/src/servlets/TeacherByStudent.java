package servlets;

import controllers.Connections;
import controllers.model.Sith;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@WebServlet(name = "TeacherByStudent", urlPatterns = "/teacher_by_student")
public class TeacherByStudent extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	List<Sith> allTeacherByStudent = Connections.getFactory().getSithDao().getTeacherByStudentName(request.getParameter("sname"));
    	request.setAttribute("TeacherByStudent",allTeacherByStudent);
        System.out.println(allTeacherByStudent);
        request.getRequestDispatcher("jsp/all_teacher_by_student.jsp").forward(request, response);
    }
}

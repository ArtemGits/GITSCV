package servlets;

import controllers.Connections;
import controllers.model.Sith;
import controllers.model.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by igor on 24.04.16.
 */

/**
 * Get list of all books
 */
@WebServlet(name = "AllTeachers", urlPatterns = "/all_teachers")
public class AllTeachers extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    /**
     * Get list of all books
     * @param request request
     * @param response response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	List<Teacher> allTeachers = Connections.getFactory().getTeacherDao().getAll();
    	request.setAttribute("teachers",allTeachers);
        System.out.println(allTeachers);
        request.getRequestDispatcher("jsp/all_teachers.jsp").forward(request, response);
    }
}

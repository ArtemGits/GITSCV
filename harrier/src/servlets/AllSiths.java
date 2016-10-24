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


@WebServlet(name = "AllSiths", urlPatterns = "/all_siths")
public class AllSiths extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	List<Sith> allSiths = Connections.getFactory().getSithDao().getAll();
    	request.setAttribute("AllSiths",allSiths);
        System.out.println(allSiths);
        request.getRequestDispatcher("jsp/all_siths.jsp").forward(request, response);
    }
}

package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SingOut", urlPatterns = "/signout")
public class SingOut extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//request.logout();
    	final HttpSession session = request.getSession(false);
    	if(session != null) {
    		session.invalidate();
    	}
    	request.getRequestDispatcher("/jsp/main.jsp").forward(request,response);
    }

}
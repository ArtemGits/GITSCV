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


@WebServlet(name = "SithsByHome", urlPatterns = "/sihts_by_home")
public class SithsByHome extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	List<Sith> allSithsByHome = Connections.getFactory().getSithDao().getInstanceByHome(request.getParameter("home"));
    	request.setAttribute("SithsByHome",allSithsByHome);
        System.out.println(allSithsByHome);
        request.getRequestDispatcher("jsp/all_siths_by_home.jsp").forward(request, response);
    }
}

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


@WebServlet(name = "SithsByRang", urlPatterns = "/siths_by_rang")
public class SithsByRang extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Siths> allSithsByRang = Connections.getFactory().getSithDao().getSithsByRang(request.getParameter("rang"));
    	request.setAttribute("SithsByRang",allSithsByRang);
        System.out.println(allSithsByRang);
        request.getRequestDispatcher("jsp/all_siths_by_rang.jsp").forward(request, response);
	}

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	
    }
}

package servlets;

import controllers.Connections;
import controllers.model.Achieve;
import controllers.model.Sith;
import controllers.model.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@WebServlet(name = "AchieveBySith", urlPatterns = "/achieve_by_sith")
public class AchievieBySith extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HELO");
		List<Map<Sith, List<Achieve>>> allAchieveBySith = Connections.getFactory().getSithDao().getAchieveBySith(request.getParameter("aname"));
    	request.setAttribute("AchieveBySith",allAchieveBySith);
        for( int i=0; i<allAchieveBySith.size(); i++) {
        	System.out.println(allAchieveBySith.get(i).keySet());
        	System.out.println(allAchieveBySith.get(i).values());
        }
    	
       request.getRequestDispatcher("jsp/achieve_by_sith.jsp").forward(request, response);
	}

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	
    }
}

package servlets;

import controllers.Connections;
import controllers.model.Achievements;
import controllers.model.Siths;
import controllers.model.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@WebServlet(name = "BestSithByStatus", urlPatterns = "/best_sith_by_status")
public class BestSithByStatus extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	List<Map<Siths, List<Achievements>>> allAchieveBySith = Connections.getFactory().getSithDao().getBestSithByStatus();
    	request.setAttribute("BestSithByStatus",allAchieveBySith);
        for( int i=0; i<allAchieveBySith.size(); i++) {
        	System.out.println(allAchieveBySith.get(i).keySet());
        	System.out.println(allAchieveBySith.get(i).values());
        }
    	
       request.getRequestDispatcher("jsp/best_sith_by_status.jsp").forward(request, response);
    }
}

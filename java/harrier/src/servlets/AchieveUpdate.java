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
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "AchieveUpdate", urlPatterns = "/achieve_update")
public class AchieveUpdate extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("HiddenId"));
		//String id = "3";
		System.out.println("Hello"+ id);
		Achievements achieve = Connections.getFactory().getAchieveDao().getAchieve(id);
		//List<Achieve> allAchieve = new ArrayList<>();
    	//request.setAttribute("Achieve",achieve);
    	//request.setAttribute("Achievments",allAchieve);
    	response.setContentType("text/plain");
		response.getWriter().write(achieve.toString());
    	
       
	}

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 int id = Integer.parseInt(request.getParameter("id"));
    	 System.out.println(id);
    	 int kills = Integer.parseInt(request.getParameter("kills"));
    	 System.out.println(kills);
         int duels = Integer.parseInt(request.getParameter("duels"));
         System.out.println(duels);
         int wins = Integer.parseInt(request.getParameter("wins"));
         System.out.println(wins);
         int loses = Integer.parseInt(request.getParameter("loses"));
         System.out.println(loses);
         boolean result = Connections.getFactory().getAchieveDao().updateAchive(id,duels,wins,loses,kills);
         System.out.println(result);
         if (result == true) {
        	 response.setStatus(200);
         } else {
        	 response.setStatus(500);
         }
    	
    }
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	System.out.println(id);
    	boolean result = Connections.getFactory().getAchieveDao().deleteAchieve(id);
        System.out.println(result);
        if (result == true) {
       	 response.setStatus(200);
        } else {
       	 response.setStatus(500);
        }
    	
    }
    
    
    
}

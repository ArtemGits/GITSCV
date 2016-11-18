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



@WebServlet(name = "AchieveCreate", urlPatterns = "/achieve_create")
public class AchieveCreate extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 int id = Integer.parseInt(request.getParameter("id"));
    	 int kills = Integer.parseInt(request.getParameter("kills"));
         int duels = Integer.parseInt(request.getParameter("duels"));
         int wins = Integer.parseInt(request.getParameter("wins"));
         int loses = Integer.parseInt(request.getParameter("loses"));
         boolean result = Connections.getFactory().getAchieveDao().createAchieve(new Achievements(id,kills,duels,loses,wins));
         System.out.println(result);
         if (result == true) {
        	 response.setStatus(200);
         } else {
        	 response.setStatus(500);
         }
    	
    }
   
    
    
    
}

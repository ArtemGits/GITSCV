package servlets;

import controllers.Connections;

import controllers.model.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(name = "StatusControllerOp", urlPatterns = "/status_controller_op")
public class StatusControllerOp extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("HiddenId"));
		
		System.out.println("Hello"+ id);
		Status status = Connections.getFactory().getStatusDao().getStatuses(id);
		
    	response.setContentType("text/plain");
		response.getWriter().write(status.toString());
    	
       
	}

    
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 int id = Integer.parseInt(request.getParameter("id"));
    	 String status = request.getParameter("status");
         
         boolean result = Connections.getFactory().getStatusDao().updateStatus(id,status);
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
    	boolean result = Connections.getFactory().getStatusDao().deleteStatus(id);
        System.out.println(result);
        if (result == true) {
       	 response.setStatus(200);
        } else {
       	 response.setStatus(500);
        }
    	
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 int id = Integer.parseInt(request.getParameter("id"));
    	 String status = request.getParameter("status");
        boolean result = Connections.getFactory().getStatusDao().createStatus(new Status(id,status));
        System.out.println(result);
        if (result == true) {
       	 response.setStatus(200);
        } else {
       	 response.setStatus(500);
        }
   	
   }
    
    
}

package servlets;

import controllers.Connections;

import controllers.model.Siths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(name = "SithController", urlPatterns = "/sith_controller")
public class Siths_Controller extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("HiddenId"));
		
		System.out.println("Hello"+ id);
		Siths sith = Connections.getFactory().getSithDao().getSith(id);
		
    	response.setContentType("text/plain");
		response.getWriter().write(sith.toString());
    	
       
	}
	
    
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 int id = Integer.parseInt(request.getParameter("id"));
    	 String rang = request.getParameter("rang");
    	 int id_status = Integer.parseInt(request.getParameter("id_status"));
    	 String old_name = request.getParameter("old_name");
    	 String new_name = request.getParameter("new_name");
    	 int age = Integer.parseInt(request.getParameter("age"));
    	 String home = request.getParameter("home");
    	 boolean canon = Boolean.parseBoolean(request.getParameter("canon"));
    	 boolean history = Boolean.parseBoolean(request.getParameter("history"));
       
         boolean result = Connections.getFactory().getSithDao().updateSith(id,rang,id_status,old_name,new_name,age,home,canon,history);
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
    	boolean result = Connections.getFactory().getSithDao().deleteSith(id);
        System.out.println(result);
        if (result == true) {
       	 response.setStatus(200);
        } else {
       	 response.setStatus(500);
        }
    	
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 int id = Integer.parseInt(request.getParameter("id"));
    	 String rang = request.getParameter("rang");
    	 int id_status = Integer.parseInt(request.getParameter("id_status"));
    	 String old_name = request.getParameter("old_name");
    	 String new_name = request.getParameter("new_name");
    	 int age = Integer.parseInt(request.getParameter("age"));
    	 String home = request.getParameter("home");
    	 boolean canon = Boolean.parseBoolean(request.getParameter("canon"));
    	 boolean history = Boolean.parseBoolean(request.getParameter("history"));
       
         boolean result = Connections.getFactory().getSithDao().createSith(new Siths(id,rang,id_status,old_name,new_name,age,home,canon,history));
        System.out.println(result);
        if (result == true) {
       	 response.setStatus(200);
        } else {
       	 response.setStatus(500);
        }
   	
   }
    
    
}

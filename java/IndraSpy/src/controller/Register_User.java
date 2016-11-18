package controller;

import items.Items;
import services.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.SystemException;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
@WebServlet("/Register_User")
public class Register_User extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();//delete 
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password=request.getParameter("password");
		String car=request.getParameter("car");
	    String bike=request.getParameter("bike");
	    String choice=request.getParameter("choice");
	    String net=request.getParameter("net");
	    String os=request.getParameter("os");
//	    String email12=request.getParameter("email12");
	    String cell=request.getParameter("cell");
	    String dob=request.getParameter("dob");

	    User user = new User();
	    user.setName(name);
	    user.setPassword(password);
	    user.setEmail(email);

	    Items item = new Items();
	    item.setBike(bike);
	    item.setCar(car);
	    item.setChoice(choice);
	    item.setOs(os);
	    item.setNet(net);
	    item.setCell(cell);
	    item.setDob(dob);
	    
	    LoginService loginService = new LoginService();

	    try {
	    	user = loginService.registerUser(user,item);
	    } catch(ClassNotFoundException e) {
	    	e.printStackTrace();
	    } catch(SQLException e) {
	    	e.printStackTrace();
	    }
	    if(user.isValid()) {
	    	HttpSession session = request.getSession();
	    	session.setAttribute("currentsession",user);
	    	request.getRequestDispatcher("success.html").forward(request,response);
	    } else {
	    	HttpSession session = request.getSession();
	    	session.setAttribute("currentsession", user);
            request.getRequestDispatcher("ind_error.html").forward(request,response);

	    }

	}
}
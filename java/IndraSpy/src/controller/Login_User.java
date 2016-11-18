package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.LoginService;

@WebServlet("/Login_User")
public class Login_User extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		LoginService loginService = new LoginService();
		List<String> list =new ArrayList<String>();
		user = loginService.authenticating(user);

		if(user.isValid()) {
			HttpSession session = request.getSession();
			session.setAttribute("currentsession", email);
			request.setAttribute("List", list);
			RequestDispatcher rd = request.getRequestDispatcher("ind_home.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("ind_error.html");
		}
	}
}
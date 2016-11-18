package servlets;

import servlets.security.EncodingPassword;
import controllers.Connections;
import controllers.DAO.interfaces.DaoFactory;
import controllers.DAO.interfaces.UserDao;
import controllers.model.User;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(name = "login", urlPatterns = "/jsp/login")
public class Login extends HttpServlet {
	private final Logger logger = Logger.getLogger(Login.class);
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("here");
		if(request.getParameter("email") == null || request.getParameter("password") == null) {
			logger.error("Troubles with parameters");
			response.sendError(400);
			return;
		}
		
		final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        if (email.trim().isEmpty() || password.trim().isEmpty()) {
            logger.debug("Some empty fields");
           // request.setAttribute("messageSignIn","empty");
           // doGet(request, response);
            return;
        }
		//-------------------
        System.out.println(email + " " + password);
        
        DaoFactory DAOFactory =  Connections.getFactory();
        UserDao userFactory = DAOFactory.getUserDao();
        userFactory.setUserEmail(email);
        userFactory.setUserPassword(EncodingPassword.hash(password));
        
        
		 User loginUser = userFactory.authenticating(userFactory.getUser());
		  if(loginUser.isValid()) {
			 	HttpSession session = request.getSession();
				session.setAttribute("currentsession", email);
				request.getRequestDispatcher("/jsp/usersMain.jsp").forward(request, response);
			} else {
				response.sendRedirect("failure.jsp");
			}
		 
		 
		 
		 
//		if(userFactory.getUserEmail(loginUser) == null) {
//			logger.debug("No user with such name");
//			request.setAttribute("messageSignIn", "nosucheser");
//			//doGet(request,response);
//			return;
//		}
//		if(userFactory.getUserPassword(loginUser).equals(EncodingPassword.hash(password))) {
//			HttpSession session = request.getSession();
//			//session.setAttribute("user_session", userByEmail);
//			request.getRequestDispatcher("success.html").forward(request,response);
//			return;
//		}
//		logger.debug("Wrong password");
//		request.setAttribute("messageSignIn", "notcorrectpassword");
//		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
	}
}
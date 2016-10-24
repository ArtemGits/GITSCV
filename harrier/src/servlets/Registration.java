package servlets;
import servlets.security.EncodingPassword;
import controllers.Connections;
import controllers.model.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controllers.DAO.postgresql.*;
import controllers.DAO.interfaces.*;

@WebServlet(name = "register_user", urlPatterns = "/register_user")
public class Registration extends HttpServlet {
	
	private final Logger logger = Logger.getLogger(Registration.class);
	private final Pattern p = Pattern.compile("[0-9a-z_]+@[0-9a-z_^\\.]+\\.[a-z]{2,3}");
	private Matcher m;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
        if( request.getParameter("email") == null || request.getParameter("password") == null) {
            logger.error("Troubles with parameters");
            response.sendError(400);
            return;
        }

        //final String name = request.getParameter("name");
        
        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        System.out.println(email + " " + password);
         if( email.trim().isEmpty() || password.trim().isEmpty() ) {
            logger.debug("Some empty fields");
            //request.setAttribute("messageSignUp","empty");
           // doGet(request, response);
            return;
        }

         if(email.length()>100 ) {
            logger.debug("Too long value");
            //request.setAttribute("messageSignUp","tooLong");
         //   doGet(request, response);
            return;
        }

        
        

        

        m = p.matcher(email);
        if(!m.matches()) {
        	logger.debug("Wrong email format");
            //request.setAttribute("messageSignUp","wrongEmail");
       //     doGet(request, response);
            return;
        }
        
        
        DaoFactory DAOFactory =  Connections.getFactory();
        
        UserDao userFactory = DAOFactory.getUserDao();
        
        userFactory.setUserEmail(email);
        userFactory.setUserName("sasha");
        userFactory.setUserPassword(EncodingPassword.hash(password));
        
        userFactory.registerUser(userFactory.getUser());
        
        if(userFactory.UserIsValid()) {
	    	HttpSession session = request.getSession();
	    	session.setAttribute("currentsession",userFactory.getUser());
	    	request.getRequestDispatcher("success.html").forward(request,response);
	    } else {
	    	HttpSession session = request.getSession();
	    	session.setAttribute("currentsession", userFactory.getUser());
            request.getRequestDispatcher("ind_error.html").forward(request,response);

	    }
        
        
//        final User user = Connection.getFactory().getUserDao().getUserByEmail(email);
//        if(user != null) {
//        	logger.debug("Wrong such email is already exists");
//            request.setAttribute("messageSignUp","emailExists");
//            doGet(request, response);
//            return;
//        }

        //final User newReader = new User(0,name,email,EncodingPassword.hash(password),"user");
      //  if(!Connection.getFactory().getUserDao().insertReader(newReader)) {
        //	logger.error("Trouble with insertion new Reader");
//            response.sendError(400);
//            return;
//        }
//        response.sendRedirect("/login");
   }

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp").forward(request,response);
//    }
	
	

    
}
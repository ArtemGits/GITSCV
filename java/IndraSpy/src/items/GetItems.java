package items;

import controller.User;
import hibernate.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.mapping.Value;

//import webapp.indrajit.hibernate.Hibernate;

@WebServlet("/GetItems")
public class GetItems extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String email_ = request.getParameter("email");
		Session session = Hibernate.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from User where email='"+email_+"'");
		List<User> user = (List<User>)query.list();
		session.getTransaction().commit();
		session.close();
		
		List<String> list = new ArrayList<String>();
		//System.out.println("Hello");
		
		for(User u : user) {
			list.clear();
			System.out.println("Worked");
            
            list.add(u.getEmail());
            list.add(u.getName());
            list.add(u.getItem().getBike());
            list.add(u.getItem().getCar());
            list.add(u.getItem().getChoice());
            list.add(u.getItem().getNet());
            list.add(u.getItem().getOs());
            list.add(u.getItem().getCell());
            list.add(u.getItem().getDob());
            request.setAttribute("List", list);
            System.out.println(list);
            request.getRequestDispatcher("ind_home.jsp").include(request,response);
            
            
            //            PrintWriter out = response.getWriter();
//            out.println("<HTML>");
//            out.println("<BODY COLOR=\"#000000\">");
//            out.println("<CENTER>");
//            out.println("<table BORDER=1 CELLPADDING=0 CELLSPACING=0 WIDTH=27% >");
//          
//            out.print("<tr bgcolor=#fff>");
//            out.print("<td>");
//            out.println("<h4>"+"NAME : "+name+"<BR>"+"</h4>");
//            out.println("<h4>"+"Gmail ID : "+email+"<BR>"+"</h4>");
//            out.println("<h4>"+"DOB : "+dob+"<BR>"+"</h4>");
//            out.println("<h4>"+"NUMBER : "+cell+"<BR>"+"</h4>");
//            out.println("<h4>"+"BIKE : "+bike+"<BR>"+"</h4>");
//            out.println("<h4>"+"CAR : "+car+"<BR>"+"</h4>");
//            out.println("<h4>"+"CHOICE : "+choice+"<BR>"+"</h4>");
//            out.println("<h4>"+"NETWORK : "+net+"<BR>"+"</h4>");
//            out.println("<h4>"+"OS : "+os+"<BR>"+"</h4>");
//            out.print("</tr>");
//            out.print("</td>");
//           
//            out.println("</table>");
//            out.println("</HTML>");
//            out.println("</BODY>");
           
		}

}
}
package servlets;

import controllers.Connections;
import controllers.model.Sith;
import controllers.model.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@WebServlet(name = "SithsByStatus", urlPatterns = "/siths_by_status")
public class SithsByStatus extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<Status, List<Sith>>> allSithsByStatus = Connections.getFactory().getSithDao().getSithsByStatus(request.getParameter("status"));
    	request.setAttribute("SithsByStatus",allSithsByStatus);
//        for( int i=0; i<allSithsByStatus.size(); i++) {
//        	System.out.println(allSithsByStatus.get(i).keySet().);
//        	System.out.println(allSithsByStatus.get(i).values());
//        }
//    	
        request.getRequestDispatcher("jsp/all_siths_by_status.jsp").forward(request, response);
	}

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	
    }
}

//package filters;
//
//import controllers.model.User;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//@WebFilter({"/login","/signup"})
//public class SecurityNotLoginUser implements Filter {
//    public void destroy() {
//    }
//
//    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) resp;
//        User User = (User) request.getSession().getAttribute("user_session");
//        if ( User==null || User.getRole()!=null ) {
//            request.getRequestDispatcher("/index.jsp").forward(request, response);
//            return;
//        }
//        chain.doFilter(req, resp);
//    }
//
//    public void init(FilterConfig config) throws ServletException {
//
//    }
//
//}
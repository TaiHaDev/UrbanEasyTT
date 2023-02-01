package web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/hosting", "/bookings", "/booking"})
public class LogFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
        // Initialization code goes here
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        System.out.println(req.getContextPath());
        if (session.getAttribute("userId") == null) {
        	res.sendRedirect("home?re=true");
        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
        // Finalization code goes here
    }
}

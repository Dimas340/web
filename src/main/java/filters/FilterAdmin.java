package filters;

import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(urlPatterns={"/admin/*"})
public class FilterAdmin implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest)request).getSession();

        User user = (User) session.getAttribute("user");

        if (user.getRole().equals("admin")) {
            filterChain.doFilter(request, response);
            return;
        }

        ((HttpServletResponse) response).sendRedirect("/error.jsp");
    }


    public void init(FilterConfig config) throws ServletException {

    }

}

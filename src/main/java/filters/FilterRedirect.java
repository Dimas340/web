package filters;

import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(urlPatterns={"/user"})
public class FilterRedirect implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest)request).getSession();

        User user = (User) session.getAttribute("user");
        HttpServletResponse response2 = (HttpServletResponse) response;
        if (user.getRole().equals("admin")) {
            response2.sendRedirect("/admin");
            return;
        } else {
            response2.sendRedirect("/user");
            return;

        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

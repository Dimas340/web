package filters;

import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(urlPatterns={"/*"})
public class FilterAdmin implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession();

        User user = (User) session.getAttribute("user");

        if ("admin".equals(user.getRole())) {
            filterChain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect("/user.jsp");
        }
    }

    public void init(FilterConfig filterConfig) throws ServletException {
    }
}

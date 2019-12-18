package servlets;

import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/user"})
public class FilterUser implements Filter {
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest)request).getSession();

        User user = (User) session.getAttribute("user");

        if (user != null && user.getLogin().equals("user")) {
            filterChain.doFilter(request, response);
            return;
        }

        ((HttpServletResponse) response).sendRedirect("/mistake.jsp");
    }
}

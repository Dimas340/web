package servlets;

import model.User;
import servise.Service;
import servise.ServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/authorization")
public class ServletAuthorization extends HttpServlet {
    Service service = new ServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        response.setContentType("text/html");

        User user = service.returnByLogin(login);
        if (user == null) {
            response.sendRedirect("authorization");
            return;
        }
            if (user.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                if (user.getLogin().equals("admin")) {
                    response.sendRedirect("/admin");
                    return;
                }
                response.sendRedirect("/user");
            } else {
                response.sendRedirect("authorization");
            }
        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}

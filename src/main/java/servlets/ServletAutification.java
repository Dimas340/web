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

@WebServlet("/autification")//@WebServlet("/app/admin")

public class ServletAutification extends HttpServlet {
    Service service = ServiceImpl.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = service.getUserLogin(login);
        if (user == null) {
            response.sendRedirect("autification");
            return;
        }

        if (user.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.setContentType("text/html");
            if (user.getRole().equals("admin")) {
                response.sendRedirect("/app/admin");
                return;
            }
            response.sendRedirect("/app/user");
        } else {
            response.sendRedirect("autification");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}

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
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/app/admin/adding")
public class ServletAddingAUser extends HttpServlet {
    Service service = ServiceImpl.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        service.addingUser(new User(login, password, role));
        response.sendRedirect("/app/admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/adding.jsp");
        dispatcher.forward(request, response);
    }
}

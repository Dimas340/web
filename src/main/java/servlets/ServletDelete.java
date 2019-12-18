package servlets;

import model.User;
import servise.Service;
import servise.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/delete")
public class ServletDelete extends HttpServlet {
    Service service = ServiceImpl.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        long id = Long.parseLong(request.getParameter("id"));
        User user = service.returnById(id);
        if (user != null) {
            service.deleteUser(user);
        }
        response.sendRedirect("admin");
    }
}

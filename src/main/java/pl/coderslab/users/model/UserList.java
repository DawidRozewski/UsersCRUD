package pl.coderslab.users.model;

import pl.coderslab.users.controller.User;
import pl.coderslab.users.controller.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user/list")
public class UserList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        User[] users = userDAO.findAll();
        request.setAttribute("users", users);

        getServletContext().getRequestDispatcher("/WEB-INF/users/list.jsp")
                .forward(request, response);

    }
}

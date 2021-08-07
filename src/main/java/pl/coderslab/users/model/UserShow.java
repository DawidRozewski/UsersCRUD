package pl.coderslab.users.model;

import pl.coderslab.users.controller.User;
import pl.coderslab.users.controller.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user/show")
public class UserShow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        UserDAO userDAO = new UserDAO();
        User readUser = userDAO.read(Integer.parseInt(id));
        request.setAttribute("user", readUser);
        getServletContext().getRequestDispatcher("/WEB-INF/users/showUser.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setId(Integer.parseInt(request.getParameter("id")));
        user.setUsername(request.getParameter("username"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));

        response.sendRedirect(request.getContextPath() + "/WEB-INF/user/show");

    }
}

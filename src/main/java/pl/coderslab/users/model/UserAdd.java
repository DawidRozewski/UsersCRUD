package pl.coderslab.users.model;

import pl.coderslab.users.controller.User;
import pl.coderslab.users.controller.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user/add")
public class UserAdd extends HttpServlet {

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/users/add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");

            if (isBlank(username) || isBlank(password) || isBlank(email)) {
                getServletContext().getRequestDispatcher("/users/emptyFormAlert.jsp").forward(request, response);
            } else if (!password.matches(PASSWORD_PATTERN)) {
                getServletContext().getRequestDispatcher("/users/wrongPassword.jsp").forward(request, response);
            } else {
                UserDAO userDAO = new UserDAO();
                User user = new User();
                user.setUsername(username);
                user.setEmail(email);
                user.setPassword(password);
                userDAO.create(user);
                response.sendRedirect(request.getContextPath() + "/user/list");
            }
        } catch (NumberFormatException e) {
            response.sendRedirect(request.getContextPath() + "/users/emptyFormAlert.jsp");
        }
    }

    private boolean isBlank(String text) {
        return text == null || "".equals(text);
    }
}

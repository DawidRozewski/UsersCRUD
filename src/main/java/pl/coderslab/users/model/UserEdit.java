package pl.coderslab.users.model;

import pl.coderslab.users.controller.User;
import pl.coderslab.users.controller.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user/edit")
public class UserEdit extends HttpServlet {
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Cookie cookie = new Cookie("id", id);
        cookie.setMaxAge(600);
        response.addCookie(cookie);

        UserDAO userDAO = new UserDAO();
        User readUser = userDAO.read(Integer.parseInt(id));
        request.setAttribute("user", readUser);
        getServletContext().getRequestDispatcher("/users/editUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (isBlank(username) || isBlank(email) || isBlank(password)) {
            getServletContext().getRequestDispatcher("/users/emptyEditFormAlert.jsp").forward(request, response);
        } else if (!password.matches(PASSWORD_PATTERN)) {
            getServletContext().getRequestDispatcher("/users/wrongPassEdit.jsp").forward(request, response);
        } else {
            User user = new User();
            user.setId(Integer.parseInt(request.getParameter("id")));
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);

            UserDAO userDAO = new UserDAO();
            userDAO.update(user);
            response.sendRedirect(request.getContextPath() + "/user/list");

        }
    }

    private boolean isBlank(String text) {
        return text == null || "".equals(text);
    }
}

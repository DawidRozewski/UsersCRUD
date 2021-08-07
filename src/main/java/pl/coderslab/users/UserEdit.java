package pl.coderslab.users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user/edit")
public class UserEdit extends HttpServlet {
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
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        if (isBlank(username) || isBlank(password) || isBlank(email)) {
            getServletContext().getRequestDispatcher("/users/emptyEditFormAlert.jsp").forward(request, response);
        } else {
            User user = new User();
            user.setId(Integer.parseInt(request.getParameter("id")));
            user.setUsername(username);
            user.setEmail(password);
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

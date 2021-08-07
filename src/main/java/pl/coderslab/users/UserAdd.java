package pl.coderslab.users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/user/add")
public class UserAdd extends HttpServlet {

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      getServletContext().getRequestDispatcher("/users/add.jsp").forward(request, response);
        }

        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            user.setUsername(request.getParameter("username"));
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("password"));
            userDAO.create(user);
            response.sendRedirect(request.getContextPath() + "/user/list");
        }
    }

    private boolean isBlank(String text) {
        return text == null || "".equals(text);
    }


}

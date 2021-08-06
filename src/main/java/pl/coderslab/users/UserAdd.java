package pl.coderslab.users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user/add")
public class UserAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/users/add.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        User user = new User();

        try {
            String name = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
//            if(! verifyEmail(email)) {
//                response.sendRedirect(request.getContextPath() + "/users/wrongEmail.jsp");
//            }

            user.setUsername(name);
            user.setEmail(email);
            user.setPassword(password);
            userDAO.create(user);
            response.sendRedirect(request.getContextPath() + "/user/list");
        } catch (NumberFormatException e) {
            response.sendRedirect(request.getContextPath() + "/users/emptyForm.jsp");
        }
    }

    private boolean verifyEmail(String email) {
        return email.matches("[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}");
    }

}

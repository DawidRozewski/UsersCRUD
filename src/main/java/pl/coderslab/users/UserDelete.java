package pl.coderslab.users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user/delete")
public class UserDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        UserDAO userDAO = new UserDAO();
        User readUser = userDAO.read(Integer.parseInt(id));
        request.setAttribute("user", readUser);
          getServletContext().getRequestDispatcher("/users/deleteUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            UserDAO userDAO = new UserDAO();
            userDAO.delete(id);
            response.sendRedirect(request.getContextPath() + "/user/list");

    }
}

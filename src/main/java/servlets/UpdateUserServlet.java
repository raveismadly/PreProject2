package servlets;

import model.User;
import service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateUserServlet extends HttpServlet {
    ServiceImpl service = ServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long getId = Long.parseLong(req.getParameter("id"));
        User haveThisUser = null;
        haveThisUser = service.getUserById(getId);
        req.setAttribute("haveThisUser", haveThisUser);
        req.getRequestDispatcher("WEB-INF/jsp/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        Integer age = Integer.parseInt(req.getParameter("age"));
        if (id != null || name != null || surname != null || age != null) {
            service.updateUser(new User(id, name, surname, age));
        }
        resp.sendRedirect("read");

    }
}

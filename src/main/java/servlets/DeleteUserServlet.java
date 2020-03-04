package servlets;

import model.User;
import service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {
    private ServiceImpl service = ServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long getId = Long.parseLong(req.getParameter("id"));
        User user = null;
        user= service.getUserById(getId);
        req.setAttribute("user", user);
        req.getRequestDispatcher("WEB-INF/jsp/delete.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        service.deleteUser(id);
        resp.sendRedirect("read");
    }
}

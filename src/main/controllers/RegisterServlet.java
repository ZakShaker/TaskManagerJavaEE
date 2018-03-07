package controllers;

import model.pojo.User;
import services.UserService;
import services.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class RegisterServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(RegisterServlet.class.getName());

    private static UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("RegisterServlet doGet");
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("RegisterServlet doPost");

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = userService.register(login, password);
        if (user == null) {
            resp.sendRedirect("register_error");
        } else {
            req.setAttribute("greetingsText", "Hello, successfully registered " + user.getLogin() + "!");
            req.setAttribute("user", user);
            RequestDispatcher rd = req.getRequestDispatcher("my_dashboard");
            rd.forward(req, resp);
        }
    }
}

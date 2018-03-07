package controllers;

import model.pojo.User;
import services.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class LoginServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(LoginServlet.class.getName());

    private static UserServiceImpl userService = new UserServiceImpl() ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       logger.info("LoginServlet doGet");
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("LoginServlet doPost");

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = userService.auth(login, password);
        if (user == null) {
            resp.sendRedirect("login_error");
        } else {
            req.setAttribute("greetingsText", "Hello, successfully logged in user " + user.getLogin() + "!");
            req.setAttribute("user", user);
            RequestDispatcher rd = req.getRequestDispatcher("my_dashboard");
            rd.forward(req, resp);
        }
    }
}

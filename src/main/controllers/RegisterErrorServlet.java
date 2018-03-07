package controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class RegisterErrorServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(RegisterErrorServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("RegisterServletError doGet");
        req.getRequestDispatcher("/register_error.jsp").forward(req, resp);
    }

}

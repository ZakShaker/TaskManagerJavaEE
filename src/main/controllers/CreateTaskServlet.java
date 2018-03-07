package controllers;

import model.pojo.Task;
import services.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.logging.Logger;

public class CreateTaskServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(CreateTaskServlet.class.getName());

    private static AgendaService agendaService = new AgendaServiceImpl();
    private static TaskService taskService = new TaskServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("CreateTaskServlet doGet");
        req.setAttribute("user", req.getParameter("user"));
        req.getRequestDispatcher("create_task.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("CreateTaskServlet doPost");

        String userIdString = req.getParameter("user");
        String name = req.getParameter("name");
        String description = req.getParameter("description");

        String startDateString = req.getParameter("start_date");
        String endDateString = req.getParameter("end_date");
        Date startDate = Date.valueOf(startDateString);
        Date endDate = Date.valueOf(endDateString);

        Long userId = null;
        try {
            userId = Long.parseLong(userIdString);
            Task task = taskService.createTask(name, description, startDate, endDate);

            if (task != null) {
                if (agendaService.bindTask(userId, task.getId())) {
                    req.setAttribute("user", userId);
                    RequestDispatcher rd = req.getRequestDispatcher("my_dashboard");
                    rd.forward(req, resp);
                }  //else TODO: error message on FrontEnd
            } //else TODO: error message on FrontEnd

        } catch (NumberFormatException ex) {
            logger.info("Dashboard Servlet doPost: Cannot parse user's id " + userIdString);
        }
    }
}
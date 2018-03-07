package controllers;

import model.dao.impl.TaskDAOImpl;
import model.pojo.Task;
import model.pojo.User;
import services.AgendaService;
import services.AgendaServiceImpl;
import services.UserService;
import services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class DashboardServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(DashboardServlet.class.getName());

    private static AgendaService agendaService = new AgendaServiceImpl();
    private static UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idToDelete = req.getParameter("idToDelete");
        String idToEdit = req.getParameter("idToEdit");

        User user = null;
        try {
            user = (User) req.getAttribute("user");
        } catch (ClassCastException e) {

        }

        if (user == null) {
            String userID = req.getParameter("user");
            Long longUserID = null;
            try {
                longUserID = Long.parseLong(userID);
            } catch (NumberFormatException ex) {
                logger.info("Dashboard Servlet doPost: Cannot parse to long userId:" + userID);
            }
            user = userService.find(longUserID);
        }

        List<Task> my_tasks = null;
        if (user != null) {
            my_tasks = agendaService.getAgenda(user);
        }

        if (my_tasks!=null) {

            if (idToDelete != null) {
                Long id = null;
                try {
                    id = Long.parseLong(idToDelete);
                    Task toDelete = findTask(my_tasks, id);
                    if (agendaService.deleteTask(user, toDelete)) {
                        my_tasks.remove(toDelete);
                    }
                } catch (NumberFormatException ex) {
                    logger.info("Dashboard Servlet doPost: Cannot parse id " + idToDelete);
                }

            } else if (idToEdit != null) {
                //TODO:
            }
        }

        req.setAttribute("my_tasks", my_tasks);
        req.setAttribute("user", user);
        req.setAttribute("userId", user.getId());

        req.getRequestDispatcher("/my_dashboard.jsp").forward(req, resp);
    }

    private Task findTask(List<Task> tasks, Long taskID) {
        Task toBeFound = null;
        for (Task task : tasks) {
            if (taskID.equals(task.getId())) {
                toBeFound = task;
                break;
            }
        }
        return toBeFound;
    }

}

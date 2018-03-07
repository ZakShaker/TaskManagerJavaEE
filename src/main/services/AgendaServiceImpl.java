package services;

import model.dao.impl.AgendaDAOImpl;
import model.dao.interfaces.AgendaDAO;
import model.dao.impl.TaskDAOImpl;
import model.dao.interfaces.TaskDAO;
import model.pojo.Task;
import model.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class AgendaServiceImpl implements AgendaService {
    private static AgendaDAO agendaDao = new AgendaDAOImpl();
    private static TaskDAO taskDao = new TaskDAOImpl();

    @Override
    public List<Task> getAgenda(User user) {
        List<Long> tasksIDs = agendaDao.getAgendaFor(user);
        if (tasksIDs != null) {
            ArrayList<Task> tasks = new ArrayList<>();
            for (int i = 0; i < tasksIDs.size(); i++) {
                Task task = taskDao.getById(tasksIDs.get(i));
                if (task != null) {
                    tasks.add(task);
                }
            }
            if (tasks.size() > 0) {
                return tasks;
            }
        }
        return null;
    }

    @Override
    public boolean bindTask(Long userId, Long taskId) {
        return agendaDao.createTask(userId, taskId);
    }

    @Override
    public boolean deleteTask(User user, Task task) {
        //TODO: delete task from tasks - if no one user need this
        return agendaDao.deleteTask(user, task);
    }
}

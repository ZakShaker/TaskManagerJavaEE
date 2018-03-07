package services;

import model.dao.impl.TaskDAOImpl;
import model.dao.interfaces.TaskDAO;
import model.pojo.Task;

import java.sql.Date;

public class TaskServiceImpl implements TaskService {

    private static TaskDAO taskDao = new TaskDAOImpl();

    @Override
    public Task createTask(String name, String description, Date startDate, Date endDate) {
        return taskDao.createTask(name, description, startDate, endDate);
    }
}


package services;

import model.pojo.Task;

import java.sql.Date;

public interface TaskService {
    Task createTask(String name, String description, Date startDate, Date endDate);
}

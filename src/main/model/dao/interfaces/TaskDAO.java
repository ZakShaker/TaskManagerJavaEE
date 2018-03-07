package model.dao.interfaces;

import model.pojo.Task;

import java.sql.Date;

public interface TaskDAO extends DAO<Task, Long> {
    Task createTask(String name, String description, Date startDate, Date endDate);
}

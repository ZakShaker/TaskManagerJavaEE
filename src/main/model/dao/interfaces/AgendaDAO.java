package model.dao.interfaces;

import model.pojo.Task;
import model.pojo.User;

import java.util.List;

public interface AgendaDAO {
    List<Long> getAgendaFor(User user);
    boolean deleteTask(User user, Task task);
    boolean createTask(Long userId, Long taskId);
}

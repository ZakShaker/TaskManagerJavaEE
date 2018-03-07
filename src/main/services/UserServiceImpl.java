package services;

import model.dao.impl.UserDAOImpl;
import model.dao.interfaces.UserDAO;
import model.pojo.User;

public class UserServiceImpl implements UserService {

    private static UserDAO userDAO = new UserDAOImpl();

    @Override
    public User auth(String login, String password) {
        return userDAO.searchUser(login, password);
    }

    @Override
    public User register(String login, String password) {
        return userDAO.insertUser(login, password);
    }

    @Override
    public User find(Long id) {
        return userDAO.getById(id);
    }
}

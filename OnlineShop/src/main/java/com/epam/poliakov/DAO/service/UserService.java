package com.epam.poliakov.DAO.service;

import com.epam.poliakov.DAO.user_dao.UserDAO;
import com.epam.poliakov.DAO.user_dao.UserDAOImpl;
import com.epam.poliakov.DAO.entity.User;
import com.epam.poliakov.DAO.transactionManager.TransactionManager;
import com.epam.poliakov.DAO.entity.Ban;

import javax.sql.DataSource;

public class UserService {

    private TransactionManager transactionManager;

    private UserDAO userDAO;

    public UserService(DataSource dataSource) {
        userDAO = new UserDAOImpl();
        transactionManager = new TransactionManager(dataSource);
    }

    public boolean isLogin(String login, String password) {
        return transactionManager.doInTransaction(
                connection -> {
                    User user = userDAO.getUserByLogin(login, connection);
                    return user.getPassword().equals(password);
                }
        );
    }

    public boolean isExistUser(String login) {
        return transactionManager.doInTransaction(
                connection -> userDAO.isExistUser(login, connection)
        );
    }

    public User getUser(String login) {
        return transactionManager.doInTransaction(
                connection -> userDAO.getUserByLogin(login, connection)
        );
    }

    public Boolean registrationUser(User user) {
        return transactionManager.doInTransaction(
                connection -> {
                    userDAO.createUser(user, connection);
                    return true;
                }
        );
    }

    public Boolean updateUser(Ban ban) {
        return transactionManager.doInTransaction(
                connection -> {
                    userDAO.updateUser(ban, connection);
                    return true;
                }
        );
    }
}

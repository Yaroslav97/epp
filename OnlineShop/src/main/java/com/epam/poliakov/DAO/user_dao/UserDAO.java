package com.epam.poliakov.DAO.user_dao;

import com.epam.poliakov.DAO.entity.User;
import com.epam.poliakov.DAO.entity.Ban;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDAO {

    void createUser(User user, Connection connection) throws SQLException;

    User getUserByLogin(String login, Connection connection) throws SQLException;

    boolean isExistUser(String login, Connection connection) throws SQLException;

    void updateUser(Ban ban, Connection connection) throws SQLException;

}

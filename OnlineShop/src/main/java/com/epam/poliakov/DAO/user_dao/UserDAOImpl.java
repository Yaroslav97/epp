package com.epam.poliakov.DAO.user_dao;

import com.epam.poliakov.DAO.entity.User;
import com.epam.poliakov.DAO.entity.Ban;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String PASSWORD = "password";
    private static final String AVATAR = "avatar";
    private static final String LOGIN = "login";
    private static final String EMAIL = "email";
    private static final String ROLE = "roles.role";
    private static final String ID = "id";
    private static final String BAN = "ban";
    private static final String FAILED_DATE = "failed_date";
    private static final String COUNT_FAILED_LOGIN = "count_failed_login";

    private static final String INSERT_USERS = "INSERT INTO users (login, first_name, last_name, email, password, avatar, role) VALUES(?,?,?,?,?,?,?)";
    private static final String UPDATE_USER = "UPDATE users SET ban=?, count_failed_login=?, failed_date=? WHERE login=?";
    private static final String SELECT_USERS = "SELECT * FROM users JOIN roles ON users.role = roles.id WHERE login=?";
    private static final String SELECT_ROLE_BY_NAME = "SELECT * FROM roles WHERE role=?";

    @Override
    public void createUser(User user, Connection connection) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.getImageName());
            preparedStatement.setInt(7, getRoleByName(user.getRole(), connection));
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserByLogin(String login, Connection connection) {
        User user = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS)) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User(
                        resultSet.getString(FIRST_NAME),
                        resultSet.getString(LAST_NAME),
                        resultSet.getString(LOGIN),
                        resultSet.getString(EMAIL),
                        resultSet.getString(PASSWORD),
                        resultSet.getString(AVATAR),
                        resultSet.getString(ROLE),
                        resultSet.getInt(BAN) != 0,
                        resultSet.getInt(COUNT_FAILED_LOGIN),
                        Long.valueOf(resultSet.getString(FAILED_DATE))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean isExistUser(String login, Connection connection) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS)) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString(LOGIN).equals(login);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void updateUser(Ban user, Connection connection) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)) {
            preparedStatement.setInt(1, user.getBan() ? 1 : 0);
            preparedStatement.setInt(2, user.getCountFailedLogin());
            preparedStatement.setLong(3, user.getFailedDate());
            preparedStatement.setString(4, user.getLogin());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Integer getRoleByName(String roleName, Connection connection) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROLE_BY_NAME)) {
            preparedStatement.setString(1, roleName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt(ID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

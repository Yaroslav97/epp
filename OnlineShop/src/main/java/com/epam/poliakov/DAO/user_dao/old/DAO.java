package com.epam.poliakov.DAO.user_dao.old;

import com.epam.poliakov.DAO.entity.User;

import java.util.Map;
import java.util.Set;

public interface DAO {

    void add(User user);

    User get(String login);

    Set<Map.Entry<String, User>> getAll();

    boolean isExist(String login);
}

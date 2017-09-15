package com.epam.poliakov.DAO.user_dao.old;

import com.epam.poliakov.DAO.entity.User;
import com.epam.poliakov.DAO.user_dao.old.DAO;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserDAO implements DAO {

    private Map<String, User> userMap = new HashMap<>();

    {
        userMap.put("yaroslav", new User("Yaroslav", "Poll", "yaroslav", "yaroslav@epam.com", "pass", "user"));
    }

    @Override
    public void add(User user) {
        userMap.put(user.getLogin(), user);
    }

    @Override
    public User get(String login) {
        return userMap.get(login);
    }

    @Override
    public Set<Map.Entry<String, User>> getAll() {
        return userMap.entrySet();
    }

    @Override
    public boolean isExist(String login) {
        return userMap.containsKey(login);
    }
}

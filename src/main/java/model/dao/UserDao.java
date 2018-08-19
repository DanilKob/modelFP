package model.dao;

import model.entity.User;

public interface UserDao extends GenericDao<User>{
    public User findByLoginPassword(String login, String password);
}

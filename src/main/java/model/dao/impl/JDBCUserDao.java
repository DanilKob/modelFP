package model.dao.impl;

import model.dao.UserDao;
import model.entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JDBCUserDao extends AbstractJDBCGenericDao<User> implements UserDao{


    protected JDBCUserDao(Connection connection) {
        super(connection);
    }

    @Override
    public void create(User entity) {

    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(int id) {

    }
}

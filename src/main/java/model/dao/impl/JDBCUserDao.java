package model.dao.impl;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import model.dao.UserDao;
import model.dao.statement.ColumName;
import model.dao.statement.Statements;
import model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JDBCUserDao extends AbstractJDBCGenericDao<User> implements UserDao{


    protected JDBCUserDao(Connection connection) {
        super(connection);
    }

    @Override
    public void create(User entity) {
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement(Statements.INSERT_USER_FIRST_LAST_MIDDLE_NAME_LOGIN_PASSWORD_ROLE);
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setString(3, entity.getMiddleName());
            preparedStatement.setString(4, entity.getLogin());
            preparedStatement.setString(5, entity.getPassword());
            preparedStatement.setString(6, entity.getRole().name());
            //todo remove sout
            preparedStatement.execute();
        } catch (MySQLIntegrityConstraintViolationException e){
            System.out.println("Not unique login");
        } catch (SQLException e) {
            e.printStackTrace();
            //
            // todo add logger
            throw new RuntimeException();
        }
    }

    @Override
    public User findById(int id) {
        return null;

    }

    @Override
    public User findByLoginPassword(String login, String password) {
        // todo write findBy
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement(Statements.LOGIN_BY_LOGIN_PASSWORD);
            preparedStatement.setString(1,login);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                user = new User.Builder()
                        .setId(resultSet.getInt(ColumName.USER_ID))
                        .setFirstName(resultSet.getString(ColumName.USER_FIRST_NAME))
                        .setLastName(resultSet.getString(ColumName.USER_LAST_NAME))
                        .setMiddleName(resultSet.getString(ColumName.USER_MIDDLE_NAME))
                        .setLogin(login)
                        .setRole(resultSet.getString(ColumName.USER_ROLE))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //
            // todo add logger
            throw new RuntimeException();
        }
        return user;
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

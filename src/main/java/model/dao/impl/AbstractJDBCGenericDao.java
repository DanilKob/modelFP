package model.dao.impl;

import model.dao.GenericDao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractJDBCGenericDao<T> implements GenericDao<T> {
    protected Connection connection;

    protected AbstractJDBCGenericDao(Connection connection){
        this.connection = connection;
    }

    @Override
    public void close() {
        try {
            // todo remose sout
            System.out.println("Close connection");
            connection.close();
        } catch (SQLException e) {
            // todo add logger
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}

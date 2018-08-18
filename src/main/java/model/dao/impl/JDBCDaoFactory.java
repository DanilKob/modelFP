package model.dao.impl;

import model.dao.AbstractDaoFactory;
import model.dao.BankAccountDao;
import model.dao.UserDao;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends AbstractDaoFactory {
    @Override
    public UserDao createUserDao() {
        return new JDBCUserDao(getConnection());
    }

    @Override
    public BankAccountDao createBankAccountDao() {
        return new JDBCBankAccountDao(getConnection());
    }

    public Connection getConnection(){
        try {
            return ConnectionPoolHolder.getDataSource().getConnection();
        } catch (SQLException e) {
            // todo add logger
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}

package model.dao.impl;

import model.dao.BankAccountDao;
import model.entity.BankAccount;

import java.sql.Connection;
import java.util.List;

public class JDBCBankAccountDao implements BankAccountDao {
    private Connection connection;

    public JDBCBankAccountDao(Connection connection){
        this.connection = connection;
    }

    @Override
    public void create(BankAccount entity) {

    }

    @Override
    public BankAccount findById(int id) {
        return null;
    }

    @Override
    public List<BankAccount> findAll() {
        return null;
    }

    @Override
    public void update(BankAccount entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }
}

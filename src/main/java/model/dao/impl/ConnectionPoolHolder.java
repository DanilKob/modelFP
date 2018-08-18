package model.dao.impl;

import model.dao.config.ConfigurationKeys;
import model.dao.config.DataBaseConfiguration;
import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

public class ConnectionPoolHolder {
    // todo rename
    private static volatile BasicDataSource dataSource;
    public static DataSource getDataSource(){

        if (dataSource == null){
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    BasicDataSource ds = new BasicDataSource();
                    ds.setUrl(DataBaseConfiguration.getInstance().getProperty(ConfigurationKeys.DATA_BASE_URL));
                    ds.setUsername(DataBaseConfiguration.getInstance().getProperty(ConfigurationKeys.LOGIN));
                    ds.setPassword(DataBaseConfiguration.getInstance().getProperty(ConfigurationKeys.PASSWORD));

                    ds.setMinIdle(Integer.parseInt(DataBaseConfiguration.getInstance().
                            getProperty(ConfigurationKeys.CONNECTION_MIN)));
                    ds.setMaxIdle(Integer.parseInt(DataBaseConfiguration.getInstance().
                            getProperty(ConfigurationKeys.CONNECTION_MAX)));
                    ds.setMaxOpenPreparedStatements(Integer.parseInt(DataBaseConfiguration.getInstance().
                            getProperty(ConfigurationKeys.STATEMENT_MAX)));
                    dataSource = ds;
                }
            }
        }
        return dataSource;
    }
}

package com.epam.poliakov.DAO.pool;

import java.beans.PropertyVetoException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class PoolConnection {

    public static ComboPooledDataSource getPool() {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/shop_db");
            dataSource.setUser("root");
            dataSource.setPassword("pass");

            Properties properties = new Properties();
            properties.setProperty("user", "root");
            properties.setProperty("password", "pass");
            properties.setProperty("useUnicode", "true");
            properties.setProperty("characterEncoding", "UTF8");
            dataSource.setProperties(properties);

            dataSource.setMaxStatements(180);
            dataSource.setMaxStatementsPerConnection(180);
            dataSource.setMinPoolSize(50);
            dataSource.setAcquireIncrement(10);
            dataSource.setMaxPoolSize(60);
            dataSource.setMaxIdleTime(30);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}

package org.example;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import static jdk.internal.misc.OSEnvironment.initialize;

public class ConnectionFactory {
    private static final ComboPooledDataSource dataSource = new ComboPooledDataSource();
    private static boolean inited;
    public static Connection getConnection() throws SQLException {
        initialize();
        return dataSource.getConnection();
    }
    public static void initialize(){
        if(inited) return;

    Properties pr = new Properties();
        try {
            pr.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("db properties"));
            dataSource.setDriverClass(pr.getProperty("db.driver"));
            dataSource.setJdbcUrl(pr.getProperty("db.url"));
            dataSource.setUser(pr.getProperty("db.user"));
            dataSource.setPassword(pr.getProperty("db.password"));
            inited = true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

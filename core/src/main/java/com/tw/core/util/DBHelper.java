package com.tw.core.util;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.*;

/**
 * Created by weizhang on 7/8/15.
 */
public class DBHelper {

    private static BasicDataSource basicDataSource = null;

    static {
        basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/users_management");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("");

        basicDataSource.setMaxActive(5);
        basicDataSource.setMaxIdle(5);
        basicDataSource.setMaxWait(5000);
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = basicDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close() {
        if(basicDataSource != null) {
            try {
                basicDataSource.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeResource(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();    // 归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

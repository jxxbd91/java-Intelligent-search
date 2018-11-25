package com.kingsm.search.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
    private static String url = "jdbc:mysql://localhost:3306/search?useUnicode=true&characterEncoding=UTF-8";
    private static String username = "root";
    private static String password = "123456";
    private static Connection conn;
    private static Statement st;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");

             conn = DriverManager.getConnection(url, username, password);

             st = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn () {
        return conn;
    }

    public static Statement getSt () {
        return st;
    }
}

package com.example.demoee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
    public  static Connection getMySQLConnection() throws SQLException {
        Connection con;
        String hostName = "localhost";
        String databaseName = "fpt_sem4";
        String username = "root";
        String password = "";
        String url = "jdbc:mysql://" + hostName + "/" + databaseName;
        con = DriverManager.getConnection(url, username, password);
        return con;
    }
}


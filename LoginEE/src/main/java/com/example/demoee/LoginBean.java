package com.example.demoee;

import java.sql.Connection;
import  java.sql.*;

public class LoginBean {

    private static final Connection con;
    static  {
        try {
            con = SQLConnection.getMySQLConnection();
        }catch ( SQLException e){
            throw  new RuntimeException(e);
        }
    }
    private PreparedStatement pstmt = null;

    public LoginBean() {

    }

    public boolean checkLogin (String username, String password) throws SQLException {
        String sql = "select username from users where username like ? and password like ?";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return true;
        }
        return false;
    }
//    public static void main(String[] args) throws SQLException {
//        LoginBean loginBean = new LoginBean();
//        String testUsername = "admin";
//        String testPassword = "admin1";
//        boolean result = loginBean.checkLoginDB(testUsername, testPassword);
//        if (result) {
//            System.out.println("Login successful!");
//        } else {
//            System.out.println("Login failed!");
//        }
//    }
}

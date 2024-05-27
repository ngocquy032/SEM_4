package com.example.thijava.DA;

import com.example.thijava.Entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employee (fullName,birthday, address, position, department) VALUES " + " (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM employee";
    public EmployeeDAO() {}

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        String hostName = "localhost";//127.0.0.1
        String dbName = "fpt_sem4";
        String username = "root";
        String password = "";
        String connURL = "jdbc:mysql://"+hostName+":3306/"+dbName;
        conn = DriverManager.getConnection(connURL, username, password);
        return conn;
    }
    public  void insertEmployee(Employee employee) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(INSERT_EMPLOYEE_SQL);
        ps.setString(1, employee.getFullName());
        ps.setString(2, employee.getBirthday());
        ps.setString(3, employee.getAddress());
        ps.setString(4, employee.getPosition());
        ps.setString(5, employee.getDepartment());
        ps.executeUpdate();
    }

    public List<Employee> selectAllEmployee() throws  SQLException, ClassNotFoundException{
        List<Employee> employees = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String fullName = rs.getString("fullName");
            String birthday = rs.getString("birthday");
            String address = rs.getString("address");
            String position = rs.getString("position");
            String department = rs.getString("department");
            employees.add(new Employee(id, fullName, birthday,address,position, department));
        }
        return employees;
    }
}

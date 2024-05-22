package com.example.thijava.Controller;

import com.example.thijava.DA.EmployeeDAO;
import com.example.thijava.Entity.Employee;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@WebServlet("/")
public class ServletEmployee extends HttpServlet {
    private EmployeeDAO employeeDAO;
    private RequestDispatcher dispatcher;

    public void init() { employeeDAO = new EmployeeDAO(); }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doGet(req, resp);
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertEmployee(request, response);
                    break;
                default:
                    listEmployees(request, response);
                    break;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String fullName = request.getParameter("fullName");
        String birthday = request.getParameter("birthday");
        String address = request.getParameter("address");
        String position = request.getParameter("position");
        String department = request.getParameter("department");
        Employee newEmployee = new Employee();

        newEmployee.setFullName(fullName);
        newEmployee.setBirthday(birthday);
        newEmployee.setAddress(address);
        newEmployee.setPosition(position);
        newEmployee.setDepartment(department);
        employeeDAO.insertEmployee(newEmployee);
        response.sendRedirect("list");
    }
    private void listEmployees(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        List<Employee> listEmployee = employeeDAO.selectAllEmployee();
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee.jsp");
        dispatcher.forward(request, response);
    }

}

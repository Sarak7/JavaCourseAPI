package org.example.dao;


import org.example.models.Employees;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO implements Serializable {

    private static final String URL = "jdbc:sqlite:C:\\Users\\dev\\IdeaProjects\\JavaCourse\\src\\main\\java\\Day4\\hr.db";
    private  static final  String SELECT_ALL_EMPLOYEES = "select * from employees";
    private static final String SELECT_ONE_EMPLOYEE = "select * from employees where employee_id = ?";
    private static final String SELECT_ONE_EMPLOYEE_BY_FIRST_NAME = "select * from employees where first_name = ?";
    private static final String SELECT_ONE_EMP_JOIN_JOB = "select * from jobs join employees on jobs.job_id = employees.job_id where job_id = ?";
    private static final String INSERT_EMPLOYEE = "insert into employees values (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
    private static final String UPDATE_EMPLOYEE = "update employees set first_name = ?, last_name = ?, email = ? , phone_number = ? , hire_date = ? , job_id = ? , salary = ? , manager_id = ? , department_id = ?  where employee_id = ?";
    private static final String DELETE_EMPLOYEE = "delete from employees where employee_id = ?";


    public void INSERT_EMPLOYEE(Employees employee) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(INSERT_EMPLOYEE);
        st.setInt(1, employee.getEmployee_id());
        st.setString(2, employee.getFirst_name());
        st.setString(3, employee.getLast_name());
        st.setString(4, employee.getEmail());
        st.setString(5, employee.getPhone_number());
        st.setString(6, employee.getHire_date());
        st.setInt(7, employee.getJob_id());
        st.setDouble(8, employee.getSalary());
        st.setInt(9, employee.getManager_id());
        st.setInt(10, employee.getDepartment_id());
        st.executeUpdate();
    }

    public void UPDATE_EMPLOYEE(Employees employee) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(UPDATE_EMPLOYEE);
        st.setInt(1, employee.getEmployee_id());
        st.setString(2, employee.getFirst_name());
        st.setString(3, employee.getLast_name());
        st.setString(4, employee.getEmail());
        st.setString(5, employee.getPhone_number());
        st.setString(6, employee.getHire_date());
        st.setInt(7, employee.getJob_id());
        st.setDouble(8, employee.getSalary());
        st.setInt(9,employee.getManager_id());
        st.setInt(10, employee.getDepartment_id());
        st.executeUpdate();
    }


    public void DELETE_EMPLOYEE(int employee_id) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(DELETE_EMPLOYEE);
        st.setInt(1, employee_id);
        st.executeUpdate();
    }

    public Employees selectEmployee_By_First_name(String first_name) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
//        PreparedStatement st = conn.prepareStatement(SELECT_ONE_EMPLOYEE);
        PreparedStatement st = conn.prepareStatement(SELECT_ONE_EMPLOYEE_BY_FIRST_NAME);
        st.setString(1, first_name);
        ResultSet rs = st.executeQuery();
        if(rs.next()) {
            return new Employees(rs);
        }
        else {
            return null;
        }
    }

    public Employees selectEmployee(int employee_id) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
//        PreparedStatement st = conn.prepareStatement(SELECT_ONE_EMPLOYEE);
        PreparedStatement st = conn.prepareStatement(SELECT_ONE_EMP_JOIN_JOB);
        st.setInt(1, employee_id);
        ResultSet rs = st.executeQuery();
        if(rs.next()) {
            return new Employees(rs);
        }
        else {
            return null;
        }
    }

    public ArrayList<Employees> SELECT_ALL_EMPLOYEES(Integer jobId) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(SELECT_ALL_EMPLOYEES);
        ResultSet rs = st.executeQuery();
        ArrayList<Employees> Employee = new ArrayList<>();
        while (rs.next()) {
            Employee.add(new Employees(rs));
        }

        return Employee;
    }
}
package com.employee.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Company {
    private int id;
    private String name;
    private String position;
    private String department;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department = department;
    }

    /*
    public static void TruncateTableCompany() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "");
            if (connection != null) {
                String truncateQuery = "TRUNCATE TABLE employees";
                PreparedStatement truncateStatement = connection.prepareStatement(truncateQuery);
                truncateStatement.executeUpdate(truncateQuery);
            }
        }
        catch (SQLException e) {
            System.err.println("Can not connect to database!");
            e.printStackTrace();
        }
    }
    */
    public void Database() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "");
            if (connection != null) {
                String insertQuery = "INSERT INTO employees (id, name, position, department) VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, position);
                preparedStatement.setString(4, department);

                preparedStatement.executeUpdate();

            }
        } catch (SQLException e) {
            System.err.println("Can not connect to database!");
            e.printStackTrace();
        }
    }
}
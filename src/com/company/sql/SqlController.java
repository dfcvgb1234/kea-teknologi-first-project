package com.company.sql;

import java.sql.*;

public class SqlController {

    private final String DB_URL = "jdbc:mysql://localhost:3306/kea_db";

    private Connection con;

    // This is not ideal... this should most likely have been a singleton
    // This is creating a memory leak
    public SqlController(String username, String password) {
        try {
            con = DriverManager.getConnection(DB_URL, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getResultSetFromQuery(String query) {
        try {
            Statement s = con.createStatement();
            ResultSet result = s.executeQuery(query);
            s.close();
            return result;
        }
        catch (SQLException exception) {
            return null;
        }
    }

    public void insertIntoDatabaseWithQuery(String query) {
        try {
            Statement s = con.createStatement();
            s.executeUpdate(query);
            s.close();
        }
        catch (SQLException exception) {
        }
    }

    // My attempt at making something clever.
    public SqlController closeConnection() {
        try {
            con.close();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();

            // Hopefully the garbage collector will close the connection if this is triggered.
            return null;
        }
    }
}

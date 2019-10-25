/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author JadyMartins
 */
public class db {

   // DefaultPanel customerView;
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public db() {
        connect();
    }
    //Not all the methods have been used 
    //due to the project is not concluded
    //as planned 

    public void connect() {
        try {
            // Load the database driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String dbServer = "jdbc:mysql://localhost:3306/immigration";
            String user = "root";
            String password = "";

            // Get a connection to the database
            conn = DriverManager.getConnection(dbServer, user, password);

            // Get a statement from the connection
            stmt = conn.createStatement();

        } catch (SQLException se) {
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void executeInsert(String query) {
        try {

            stmt.execute(query);
            stmt.close();
            conn.close();

        } catch (SQLException se) {
            System.out.println("SQL Exception:");
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public boolean executeQuery(String query) {
        try {
            rs = stmt.executeQuery(query);

            // This code is telling us whether we have any results
            // in our database or not
            if (rs.isBeforeFirst()) {
                return true;
               //return rs;
            }

            // Close the result set, statement and the connection
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return false;
    }
  
    public ResultSet newQuery(String query) {
        try {
            rs = stmt.executeQuery(query);

    
            if (rs.isBeforeFirst()) {
                return rs;
              
            }

            // Close the result set, statement and the connection
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Null value");
        }

        return null;
    }
 
}


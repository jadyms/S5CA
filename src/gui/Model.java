/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author JadyMartins
 */
public class Model {
    

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    db newdb; //Connection with the db

    public Model() {

        newdb = new db();
    }
/*
    public ResultSet showPerson() {

        String query = "SELECT * FROM person;";
        
        rs = newdb.newQuery(query);

        return rs;

    }
    */
     
     
      public ResultSet showPerson(String q) {

        
        String query = q;

        rs = newdb.newQuery(query);

        return rs;

    }
/*
    public ResultSet showTitles() {

        String query = "SELECT * FROM person;";
        
        rs = newdb.newQuery(query);

        return rs;

    }

    public ResultSet showTitles(String subscriptionQuery) {

        String query = subscriptionQuery;

        rs = newdb.newQuery(query);

        return rs;

    }

    public ResultSet showCustomers(String q) {

        String query = q;

        rs = newdb.newQuery(query);

        return rs;

    }

    public ResultSet showCustomers() {

        String query = "SELECT * FROM customer;";

        rs = newdb.newQuery(query);

        return rs;

    }

    public ResultSet showPoints() {

        String query = "SELECT * FROM points;";

        rs = newdb.newQuery(query);

        return rs;

    }

    public ResultSet showAllRental() {

        String query = "SELECT * FROM rental; ";

        rs = newdb.newQuery(query);

        return rs;

    }

    public ResultSet showRental(String id) {

        String query = "SELECT * FROM rental WHERE loyalty_number = '" + id + "' AND rental_status = 'RT';";

        rs = newdb.newQuery(query);

        return rs;

    }
*/
}


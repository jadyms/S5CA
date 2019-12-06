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
   
     
      public ResultSet showPerson(String q) {

        
        String query = q;

        rs = newdb.newQuery(query);

        return rs;

      }
}


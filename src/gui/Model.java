package gui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author JadyMartins
 */
public class Model {
    //Connection with the db

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    db newdb; 

    public Model() {

        newdb = new db();
    }
   
     
      public ResultSet showPerson(String q) {

        
        String query = q;

        rs = newdb.newQuery(query);

        return rs;

      }
}


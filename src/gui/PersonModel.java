/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Model;
import model.db;

/**
 *
 * @author JadyMartins
 */
public class PersonModel {
    
       static ArrayList<Person> persons;
      
    public PersonModel(){
        
    }
    
 
    public static ArrayList<Person> getPerson() {

        persons = new ArrayList<Person>();
        Person c;

        try {
            Model myModel = new Model();
           ResultSet rs = myModel.showPerson("SELECT * FROM person;");
            

            while (rs.next()) {
                c = new Person(
                        rs.getString("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("doa"),
                        rs.getString("passport"),
                        rs.getString("priority")
                );
                persons.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);

        }
    
        
       
       
        
  
        

        return persons;

    }
    /*
    public String getLastLoyaltyNumber(){
         
         int last =  Integer.parseInt(users.get(users.size()-1).getLoyaltyNumber())+1;
        System.out.println(String.valueOf(last));
         return String.valueOf(last);
    }
    */
}

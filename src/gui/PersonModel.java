
package gui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import list.DoublyLinkedList;
import list.Node;

/**
 *
 * @author JadyMartins
 */
public class PersonModel {
    
    //Get testing data from database and populate the DList
    //Reusing code from previous assignments - author @JadyMartins
    
        public static ArrayList<Person> persons;
        static Controller controller;
        static Node node;
    
        public PersonModel(){
        }
    
        public PersonModel(Controller controller){
            this.controller = controller;
        }

        public PersonModel(Node node){
            this.node = node;
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
                    
                    //Add from the db do DLL
                    node = new Node(c, 3);
                    controller.dList.addNode(node, 3);
                }

            } catch (SQLException ex) {
                Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);

            }

            return persons;

        }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package init;

import gui.Person;
import gui.PersonModel;
import gui.PersonView;
import list.DoublyLinkedList;

/**
 *
 * @author JadyMartins
 */
public class Main {
    
    public static void main(String[] args){
        
         //Loading all the Db into arraylists 
           //Then dealing only with the arrays
           
           //customers
           PersonModel personModel = new PersonModel();
           personModel.getPerson();
           
           DoublyLinkedList dList = new DoublyLinkedList();  
             dList.addNode(100,1);
        //Add nodes to the list  
        /*
        dList.addNode(new Person(
                   "1",
                   "Jady",
                    "Silva",
                    "29-10-89",
                    "Fm026271",
                    "High"
                                      
            ),2);  
        dList.addNode(new Person(
                   "1",
                   "Hugh",
                    "Oleary",
                    "29-10-89",
                    "Fm026271",
                    "High"
                                      
            ),1);  
        dList.addNode(new Person(
                   "1",
                   "Fulano",
                    "Oleary",
                    "29-10-89",
                    "Fm026271",
                    "High"
                                      
            ),1); 
     
      
        */
  
        //Displays the nodes present in the list  
        dList.showQueue();  
           
     
           
       // new MainScreen();
       new HomeView();
    }
    
}

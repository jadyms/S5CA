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
 * Some inspiration code
 * https://www.javatpoint.com/java-program-to-search-an-element-in-a-doubly-linked-list
 */
public class Main {
    
    public static void main(String[] args){
        
         //Loading all the Db into arraylists 
           //Then dealing only with the arrays
           
           PersonModel personModel = new PersonModel();
           personModel.getPerson();
       
       new HomeView();
    }
    
}

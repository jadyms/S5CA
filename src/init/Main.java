/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package init;

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
        //Add nodes to the list  
        dList.addNode(1);  
        dList.addNode(2);  
        dList.addNode(3);  
        dList.addNode(4);  
        dList.addNode(5);  
  
        //Displays the nodes present in the list  
        dList.showQueue();  
           
     
           
       // new MainScreen();
       new HomeView();
    }
    
}

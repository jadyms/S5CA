/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import init.HomeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import list.DoublyLinkedList;
import list.Node;

/**
 *
 * @author JadyMartins
 */
public class PersonController implements ActionListener, ListSelectionListener{
    
    AddPersonView addPersonView; 
    PersonView personView;
    HomeView homeView;
    PersonModel personModel = new PersonModel();
   Person person = new Person();
     static DoublyLinkedList dList = new DoublyLinkedList();
  ArrayList <DoublyLinkedList> aList = new ArrayList<DoublyLinkedList>();

    public PersonController(AddPersonView addPersonView){
        this.addPersonView = addPersonView;
    }
    
    public PersonController(HomeView homeView){
        this.homeView = homeView;
    }
//     public PersonController(PersonView personView){
//        this.personView = personView;
//    }
//    
    
    public PersonController(){
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    
        //New Person to the queue
        if(e.getActionCommand().equals("Submit")){
            
//            int last = Integer.parseInt(personModel.persons.get(personModel.persons.size() - 1).getId()) + 1;
//        dList.addNode(new Person(
//                String.valueOf(last),
//                homeView.getFirstName(),
//                homeView.getLastName(),
//                homeView.getDate(),
//                homeView.getPassport(),
//                homeView.getPriority()),
//                homeView.getPriorityNumber());
//        
        
               
           
        //Create ID
        int last = Integer.parseInt(personModel.persons.get(personModel.persons.size() - 1).getId()) + 1;
        Person newPerson = new Person(String.valueOf(last),
                homeView.getFirstName(),
                homeView.getLastName(),
                homeView.getDate(),
                homeView.getPassport(),
                homeView.getPriority());
        Node newNode = new Node(newPerson, homeView.getPriorityNumber());
        dList.addNode(newNode, homeView.getPriorityNumber());
        
            //create a new customer and add it to array
            personModel.persons.add(new Person(
                   String.valueOf(last),
                   homeView.getFirstName(),
                    homeView.getLastName(),
                     homeView.getDate(),
                    homeView.getPassport(),
                    homeView.getPriority()
                                      
            ));
            //transform DDL in 2D array
//          String[][] tableData = dList.doublyLinkedListToArray();
        //  aList.add(dList);
                                      
//          personView.populateQueue(tableData);
          
         // JOptionPane.showMessageDialog(null, personView.populateQueue(tableData));
        
           
            //add 2D array to Jtable
//		this.mainView.setData(data);
                
//		this.myList.displayForward();
            
//            personModel.queue.add(dList);
////            
           // JOptionPane.showMessageDialog(null, "Candidate added to queue");
            System.out.println("Printing DList ");
            System.out.println(dList);
           // aList.add(dList);
            
            homeView.clearText();
         homeView.setText(dList.toString());

      
   
          
            //          "Cut off from end of the queue"
        }else if(e.getActionCommand().equals("Cut off from end of the queue")){
            
             int toBeDeleted;
             int deletedNodes;
             int size;
             String message = "Elements to be removed from the end of the queue";
             
             toBeDeleted = homeView.displayGetId(message);
             size = dList.size(dList.head.previous);
             deletedNodes = dList.deleteFromEnd(toBeDeleted, size);
             homeView.displayDeletedFromEnd(deletedNodes);
             
      
                 
         homeView.clearText();
         homeView.setText(dList.toString());
                    
           //"Remove candidate from queue"
         }  else if(e.getActionCommand().equals("Remove candidate from queue")){
             dList.removeFirst();
             System.out.println(dList);
            
               homeView.clearText();
         homeView.setText(dList.toString());

               
          //"check queue"
         }  else if(e.getActionCommand().equals("Check queue")){
             
           
          
        //"Check position by ID"
         }  else if(e.getActionCommand().equals("Check position by ID")){
             
             int toFindId;
             int positionFound;
             String message = "Insert ID to get your position";
             
             toFindId = homeView.displayGetId(message);
             positionFound = dList.searchPosition(toFindId);
             homeView.displayPositionFound(positionFound);
           
         }
    }
   
        

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}

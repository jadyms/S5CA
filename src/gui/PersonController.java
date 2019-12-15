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
    
    public PersonController(){
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    
        //New Person to the queue
        if(e.getActionCommand().equals("Submit")){
           
        //Create ID
        int last = Integer.parseInt(personModel.persons.get(personModel.persons.size() - 1).getId()) + 1;
        dList.addNode(new Person(
                String.valueOf(last),
                homeView.getFirstName(),
                homeView.getLastName(),
                homeView.getDate(),
                homeView.getPassport(),
                homeView.getPriority()),
                homeView.getPriorityNumber());
               
            //create a new customer and add it to array
            personModel.persons.add(new Person(
                   String.valueOf(last),
                   homeView.getFirstName(),
                    homeView.getLastName(),
                     homeView.getDate(),
                    homeView.getPassport(),
                    homeView.getPriority()
                                      
            ));
////            
            JOptionPane.showMessageDialog(null, "Candidate added to queue");
            System.out.println("Printing Amilcar ");
            System.out.println(dList);
          
            //          "Cut off from end of the queue"
        }else if(e.getActionCommand().equals("Cut off from end of the queue")){
            
             int size = dList.size(dList.head.previous);
             int number = 1;
            
             dList.cutOffEndQueue(number, size);
               
                 System.out.println(dList);
                    
           //"Remove candidate from queue"
         }  else if(e.getActionCommand().equals("Remove candidate from queue")){
             dList.removeFirst();
             System.out.println(dList);
             
             
         }   
               
        
    }
   
        

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}

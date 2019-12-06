/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
    PersonModel personModel = new PersonModel();
    Person person = new Person();
    DoublyLinkedList<Person> dList = new DoublyLinkedList<>();
    //ArrayList <DoublyLinkedList<Person>> aList = new ArrayList<DoublyLinkedList<Person>>();

    public PersonController(AddPersonView addPersonView){
        this.addPersonView = addPersonView;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    
        //New Person to the queue
        if(e.getActionCommand().equals("Submit")){
            
        //Create ID
        int last = Integer.parseInt(personModel.persons.get(personModel.persons.size() - 1).getId()) + 1;
          
             
                dList.addNode(new Person(
                   String.valueOf(last),
                   addPersonView.getFirstName(),
                    addPersonView.getLastName(),
                     addPersonView.getDate(),
                    addPersonView.getPassport(),
                    addPersonView.getPriority()),
                    addPersonView.getPriorityNumber());
                
                
                
               // System.out.println("Printing dList");
                        
               // System.out.println(dList.toString());
               

                         
                              
            //create a new customer and add it to array
            personModel.persons.add(new Person(
                   String.valueOf(last),
                   addPersonView.getFirstName(),
                    addPersonView.getLastName(),
                     addPersonView.getDate(),
                    addPersonView.getPassport(),
                    addPersonView.getPriority()
                                      
            ));
            
            JOptionPane.showMessageDialog(null, "Customer created. You can manage details in Manage Customer");
            System.out.println("Printing Amilcar ");
                    
            System.out.println(dList);
         /*
            System.out.println(dList.size());
            System.out.println(dList.head.person.toString());
             System.out.println(dList.tail.person.toString());
           // System.out.println( dList.elementAt(0));
            */    
             
        }
         //aList.add(dList);

        /*
        System.out.println("For each aList");
                aList.forEach((person) -> System.out.println(person));
                
                dList.printList(dList.head);
                
     
        System.out.println("Method show Queue");
      dList.showQueue();
       
  
        System.out.println("aList to String");
              
        System.out.println( aList.toString());
           System.out.println("dList.prsn to String");
        System.out.println(dList.prsn.toString());
      
        System.out.println("Head of aList" + aList.get(0).head.person.toString());
        System.out.println("tail of aList" +aList.get(0).tail.person.toString());
        
        System.out.println("For each aList");
                aList.forEach((person) -> System.out.println(person));
                
         /*            
                for(DoublyLinkedList<Person> p: aList){
    System.out.println(p.toString());
}
     
         
        
for(int i =0; i<aList.size(); i++){
    System.out.println(aList.get(i).toString());
            
        }

        
       */ 
      

    }
   
        

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}

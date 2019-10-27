/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.Person;
import gui.PersonModel;
import gui.PersonView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author JadyMartins
 */
public class PersonController implements ActionListener, ListSelectionListener{
    
    AddPersonView addPersonView; 
    PersonModel personModel = new PersonModel();
    Person person = new Person();

    @Override
    public void actionPerformed(ActionEvent e) {
    
        if(e.getActionCommand().equals("Submit")){
            
              //add the new customer to the array of customers
 

            //generate a loyalty number
            //from the last number created
             int last = Integer.parseInt(personModel.persons.get(personModel.persons.size() - 1).getId()) + 1;
          
            addPersonView = new AddPersonView();
            //create a new customer and add it to array
            personModel.persons.add(new Person(
                   String.valueOf(last),
                   addPersonView.getFirstName(),
                    addPersonView.getLastName(),
                     addPersonView.getDate(),
                    addPersonView.getPassport(),
                    addPersonView.getPriority()
                                      
            ));

            System.out.println(person);
          
             JOptionPane.showMessageDialog(null, "Customer created. You can manage details in Manage Customer");

        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

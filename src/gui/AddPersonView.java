/*;
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import init.HomeView;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author JadyMartins
 */
public class AddPersonView extends JFrame{
    
     private static JTextField tfFname;
    private static JTextField tfLname;
    private static JTextField tfDate;
      private static JTextField tfPassport;
    private static JComboBox<String> priorityType;
    Priority priority;
    public static JPanel list;
  
    
       HomeView homeView;
      //  PersonModel pmodel = new PersonModel();
   PersonModel personModel= new PersonModel();
   Controller personController;
    
//    public AddPersonView(){
//        personController = new Controller(this);
//        newPersonForm();
//    }
    
    //Getters
    public String getPriority() {
     
        return String.valueOf(priorityType.getSelectedItem());
        
    }
    
    public int getPriorityNumber(){
             priority =  (Priority) priorityType.getSelectedItem();
           
         
        return priority.getPriorityLevels();
    }

      public String getFirstName() {
        return tfFname.getText();
    }
   
      public String getLastName() {
        return tfLname.getText();
    }
      
      public String getDate() {
        return tfDate.getText();
    }
       public String getPassport() {
        return tfPassport.getText();
    }
    
     public void newPersonForm(){
       //Panel for form 
        JPanel form = new JPanel(new GridBagLayout());

        //Setting Layout
        GridBagConstraints fgbc = new GridBagConstraints();
        fgbc.fill = GridBagConstraints.HORIZONTAL;

        //Form Labels
        JLabel name = new JLabel("Name: ");
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 0; //top row
        fgbc.gridwidth = 1; //1 cell
        form.add(name, fgbc);

        JLabel surname = new JLabel("Surname: ");
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 1; // row 1
        fgbc.gridwidth = 1; //1 cell
        form.add(surname, fgbc);

        JLabel dateOfArrival = new JLabel("Date of Arrival: ");
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 2; // row 3
        fgbc.gridwidth = 1; //1 cell
        form.add(dateOfArrival, fgbc);

        JLabel passport = new JLabel("Passport: ");
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 3; // row 4
        fgbc.gridwidth = 1; //1 cell
        form.add(passport, fgbc);

        JLabel priorityLabel = new JLabel("Priority: ");
        priorityLabel.setForeground(Color.red);
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 4; // row 5
        fgbc.gridwidth = 1; //1 cell
        form.add(priorityLabel, fgbc);

        //Form textfield       
        tfFname = new JTextField(20);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 0; //top row
        fgbc.gridwidth = 3; //3 cell
        form.add(tfFname, fgbc);

         tfLname = new JTextField();
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 1; // row 1
        fgbc.gridwidth = 3; //3 cell
        form.add(tfLname, fgbc);

        tfDate = new JTextField();
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 2; // row 2
        fgbc.gridwidth = 3; //3 cell
        form.add(tfDate, fgbc);

        tfPassport = new JTextField();
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 3; // row 2
        fgbc.gridwidth = 3; //3 cell
        form.add(tfPassport, fgbc);

        priorityType = new JComboBox(priority.values());
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 4; // row 3
        fgbc.gridwidth = 3; //3 cell
        form.add(priorityType, fgbc);

        //Button
        JButton btnSubmit = new JButton("Submit");
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 7; // row 6
        fgbc.gridwidth = 4; //3 cell
        form.add(btnSubmit, fgbc);
        btnSubmit.setActionCommand("Submit");
        
     //   btnSubmit.addActionListener(personController);
        
        //place panel in the main frame
    //    HomeView homeView = new HomeView("Add person to the queue ", form);

     
   }
  

             
// public JPanel  populateDDL(){
//      list = new JPanel();
//            JList detailsList =   new JList(personController.aList.toArray());
//            list.add(detailsList);
//      return list;
// }

    
}

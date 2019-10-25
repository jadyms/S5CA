/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JadyMartins
 */
public class PersonView extends JFrame{

    private String[][] data = new String[10][6];
    static JTable searchPerson;
    static JTable table;
    private static String id;
     private static String firstName;
    private static    String lastName;
        private static String doa;
        private static String passport;
        private static String queuePosition;
        static JButton[] options = new JButton[3]   ;
      

    //HomeView homeView;
      //  PersonModel pmodel = new PersonModel();
   PersonModel personModel= new PersonModel();
  // CustomerController customerController = new CustomerController();

    public JPanel populateTable() {
        //###### THIS CODE IN A SEPARATE METHOD #######
        table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        Object[] columnsName = new Object[6];
        columnsName[0] = "First Name";
        columnsName[1] = "Last Name";
        columnsName[2] = "Subscription";
        columnsName[3] = "Card Number";
        columnsName[4] = "Loyalty card";
        columnsName[5] = "Titles hold";

        model.setColumnIdentifiers(columnsName);
        Object[] rowData = new Object[6];
//
//        for (int i = 0; i < personModel.getCustomers().size(); i++) {
//
//            rowData[0] = personModel.getCustomers().get(i).getFirstname();
//            rowData[1] = personModel.getCustomers().get(i).getLastname();
//            rowData[2] = personModel.getCustomers().get(i).getSubscription();
//            rowData[3] = personModel.getCustomers().get(i).getCard();
//            rowData[4] = personModel.getCustomers().get(i).getLoyaltyNumber();
//            rowData[5] = personModel.getCustomers().get(i).getHold();
//            model.addRow(rowData);
//
//        }
         for (int i = 0; i < personModel.persons.size(); i++) {

            rowData[0] = personModel.persons.get(i).getFirstname();
            rowData[1] = personModel.persons.get(i).getLastname();
            rowData[2] = personModel.persons.get(i).getId();
            rowData[3] = personModel.persons.get(i).getDoa();
            rowData[4] = personModel.persons.get(i).getPassport();
            rowData[5] = personModel.persons.get(i).getQueuePosition();
            model.addRow(rowData);
            
   
        }
        
             //When selecting a row, JDialog will print 
        //the options below
        //to trigger action Listener for each one
        //This should be in a inner class as a List =/
        /*options[0] = new JButton("Update Customer");
        options[1] = new JButton("Create Rental from ");
        options[2] = new JButton("Manage Rental");
        
        options[0].setActionCommand("Update Customer");
        options[1].setActionCommand("Create Rental from customer Loyalty Card");
        options[2].setActionCommand("Manage Rental");
        RentalController rentalController = new RentalController();
        
         options[0].addActionListener(rentalController);
        options[1].addActionListener(rentalController);
        options[2].addActionListener(rentalController);
        */
        
        
        JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
       
        table.setModel(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(false);
        //table.getSelectionModel().addListSelectionListener(customerController);
        //Panel which we add the table to  table 
        JPanel myPanel = new JPanel();
        
        //Add ScrollPane to the panel
        myPanel.add(sp);
        
        //Populating main frame with Panel
         
     //homeView = new HomeView("Select a customer", myPanel, "Logout", "Go back");
        
     
        return myPanel;
      }
    
    public void showArray(){
        
    }
  public void showJPanel(){
      
     // homeView = new HomeView("Select a customer", populateTable(), "Logout", "Go back");

  }

             
    
    public String getFirstName(){
        return  (String) table.getValueAt(table.getSelectedRow(), 0);
    }
    
     public String getLastName(){
        return (String) table.getValueAt(table.getSelectedRow(), 1);
    }

     public String getId(){
        return (String) table.getValueAt(table.getSelectedRow(), 2);
    }
     public String getDoa(){
        return (String) table.getValueAt(table.getSelectedRow(), 3);
    }
     public String getPassport(){
        return (String) table.getValueAt(table.getSelectedRow(), 4);
    }
     public String getQueuePosition(){
        return (String) table.getValueAt(table.getSelectedRow(), 5);
    }
    
     
}
   

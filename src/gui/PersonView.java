/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import init.HomeView;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JadyMartins
 */
public class PersonView extends JFrame{

    private String[][] data = new String[10][6];
    public static JTable searchPerson;
    public static JTable table;
    private static String id;
     private static String firstName;
    private static    String lastName;
        private static String doa;
        private static String passport;
        private static String queuePosition;
        static JButton[] options = new JButton[3]   ;
        public static DefaultTableModel model;
      

    HomeView homeView;
      //  PersonModel pmodel = new PersonModel();
   PersonModel personModel= new PersonModel();
   PersonController personController; 
  // CustomerController customerController = new CustomerController();

    public JPanel populateTable() {
        //###### THIS CODE IN A SEPARATE METHOD #######
        table = new JTable();
         model = new DefaultTableModel();
        Object[] columnsName = new Object[6];
        columnsName[0] = "ID";
        columnsName[1] = "First Name";
        columnsName[2] = "Last Name";
        columnsName[3] = "DOA";
        columnsName[4] = "Passport";
        columnsName[5] = "Priority";

        model.setColumnIdentifiers(columnsName);
        Object[] rowData = new Object[6];

         for (int i = 0; i < personModel.persons.size(); i++) {
             System.out.println(personModel.persons.size());

            rowData[0] = personModel.persons.get(i).getId();
            rowData[1] = personModel.persons.get(i).getFirstname();
            rowData[2] = personModel.persons.get(i).getLastname();
            rowData[3] = personModel.persons.get(i).getDoa();
            rowData[4] = personModel.persons.get(i).getPassport();
            rowData[5] = personModel.persons.get(i).getPriority();
            model.addRow(rowData);
            
   
        }
       
        
        JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
       
        table.setModel(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(false);
        table.getSelectionModel().addListSelectionListener(personController);
        
        //Panel which we add the table to  table 
        JPanel myPanel = new JPanel();
        
        //Add ScrollPane to the panel
        myPanel.add(sp);
        
        //Populating main frame with Panel
         
     //homeView = new HomeView("Select a customer", myPanel, "Logout", "Go back");
        
     
        return myPanel;
      }
    
  /*
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

        JLabel priority = new JLabel("Priority: ");
        priority.setForeground(Color.red);
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 4; // row 5
        fgbc.gridwidth = 1; //1 cell
        form.add(priority, fgbc);

        //Form textfield       
        JTextField tfName = new JTextField(20);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 0; //top row
        fgbc.gridwidth = 3; //3 cell
        form.add(tfName, fgbc);

        JTextField tfSurname = new JTextField();
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 1; // row 1
        fgbc.gridwidth = 3; //3 cell
        form.add(tfSurname, fgbc);

        JTextField tfDate = new JTextField();
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 2; // row 2
        fgbc.gridwidth = 3; //3 cell
        form.add(tfDate, fgbc);

        JTextField tfPassport = new JTextField();
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 3; // row 2
        fgbc.gridwidth = 3; //3 cell
        form.add(tfPassport, fgbc);

        String[] priorityLevels = {"Low", "Medium", "High"};
        JComboBox tfPriority = new JComboBox(priorityLevels);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 4; // row 3
        fgbc.gridwidth = 3; //3 cell
        form.add(tfPriority, fgbc);

        //Button
        JButton btnSubmit = new JButton("Submit");
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 7; // row 6
        fgbc.gridwidth = 4; //3 cell
        form.add(btnSubmit, fgbc);
        btnSubmit.setActionCommand("Submit");
        personController = new PersonController();
        btnSubmit.addActionListener(personController);
        
        //place panel in the main frame
        HomeView homeView = new HomeView("Add person to the queue ", form, "Logout", "Go back");

        /*
        
        //Action events in the controller
        titleController = new TitleController();
        bsubmit.addActionListener(titleController);
        
                
        

                //alertDialog("Fulano: your ID is xx and position xx");
                //inputDialog("Enter ID to find position");
    
     
   }
  
    */
             
    
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
   

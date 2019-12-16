/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package init;

import gui.AddPersonView;
import gui.PersonController;
import gui.PersonModel;
import gui.PersonView;
import gui.Priority;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import list.DoublyLinkedList;


/**
 *
 * @author JadyMartins
 */
   
//This is the home
//of the application
public class HomeView extends JFrame {

    JDialog frame;
    JPanel panel;
    String message;
    String id;
    
    private static JTextField tfFname;
    private static JTextField tfLname;
    private static JTextField tfDate;
    private static JTextField tfPassport;
    private static JComboBox<String> priorityType;
    Priority priority;
    public static JPanel list;
        public static JTextArea txtArea;

    
    PersonView personView = new PersonView();
    PersonController personController;

    //first panel when system is initialized

     public HomeView(){
         personController = new PersonController(this); 
         HomePanel();
             
          

    }
     
    
    //constructor that receives panel
    //and place it onto the frame
    public HomeView(String message, JPanel panel) {
        this.message = message;
        this.panel = panel;
        mainPanel(message, panel);
    }

    //creating and setting the frame
    private void newFrame() {
       frame = new JDialog(frame, "Home");
        frame.setSize(1000,600);
        frame.setModal(true);
        frame.setTitle("INIS Appointment System");
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.validate();
        frame.repaint();
    }

    public void HomePanel() {
        //Creating Panel 2
        JPanel myPanel2 = new JPanel();
   
        JButton button2 = new JButton("Update candidate information ");
        JButton button3 = new JButton("Check position by ID");
        JButton button4 = new JButton("Cut off from end of the queue");
        JButton button5 = new JButton("Remove candidate from queue");
        JButton button6 = new JButton("Check queue");
        JButton button7 = new JButton("Logout");
        
         //Add Buttons to Panel 2
        myPanel2.add(button2);
        myPanel2.add(button3);
        myPanel2.add(button4);
        myPanel2.add(button5);
        myPanel2.add(button6);
        myPanel2.add(button7);
        
        button2.setActionCommand("Update candidate information ");
        button3.setActionCommand("Check position by ID");
        button4.setActionCommand("Cut off from end of the queue");
        button5.setActionCommand("Remove candidate from queue");
        button6.setActionCommand("Check queue");
        button7.setActionCommand("Logout");

       //Update Info
        button2.addActionListener(personController);

         //Check position by id
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        
               
               id = JOptionPane.showInputDialog(null,"Insert ID to get your position","Alert",JOptionPane.INFORMATION_MESSAGE);
               
                PersonModel personModel = new PersonModel();
                
                if(personModel.persons.contains("Hugh")){
                    System.out.println("yes");
                } else{
                      System.out.println("no");
                }
               /*
                    for(int i = 0; i<personModel.persons.size(); i++){
                 int idInt = Integer.valueOf(id);
                         System.out.println(i);
                         
                     int last = Integer.parseInt(personModel.persons.get(personModel.persons.size() - 1).getId());     
                    if(last == idInt ){
                        System.out.println("they match");;
            }
        }
                System.out.println("no match");;
             
                    */       
         
            }
        });

        //"Cut off from end of the queue"
        button4.addActionListener(personController);
            
        //"Remove candidate from queue"
        button5.addActionListener(personController);
        
        //"Check queue"
        button6.addActionListener(personController);
        
        //Instance of Logout Class that terminate the program     
        Logout l = new Logout();
        button7.addActionListener(l);

       // JPanel tablePanel = personView.populateTable();
             
        txtArea = new JTextArea(60,60);
        txtArea.setEditable(false);
        txtArea.setVisible(true);
       
   
        
      
      
        JPanel tablePanel = new JPanel();
             tablePanel.add(txtArea, BorderLayout.EAST);
        JPanel container = new JPanel();
        JPanel form = newPersonForm();
      ///  myPanel2.add(tablePanel);
        
        

        //Panel 2 Grid layout
        GridLayout glayout = new GridLayout(2,2);
        BorderLayout mgr = new BorderLayout();

        myPanel2.setLayout(glayout);
        container.setLayout(mgr);
        
        container.add(form, BorderLayout.WEST);
        container.add(myPanel2,BorderLayout.SOUTH);
        container.add(tablePanel, BorderLayout.EAST);

        //Placing panel into the frame
        mainPanel("INIS Queue Management", container);

    }
    
    public void clearText(){
        txtArea.setText ("");
    }
    
    public void setText(String list){
    
      
      txtArea.append (list + "\n");
      
         
      
        
    }
    
    public JPanel newPersonForm(){
      

    //Panel for form 
        JPanel form = new JPanel(new GridBagLayout());

        //Setting Layout
        GridBagConstraints fgbc = new GridBagConstraints();
        fgbc.fill = GridBagConstraints.HORIZONTAL;
        
         JLabel addNewPerson = new JLabel("Add New Candidate");
         fgbc.gridx = 1; //leftmost column
        fgbc.gridy = 0; //top row
        fgbc.gridwidth = 4; //1 cell
         form.add(addNewPerson, fgbc);

        //Form Labels
        JLabel name = new JLabel("Name: ");
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 1; //top row
        fgbc.gridwidth = 1; //1 cell
        form.add(name, fgbc);

        JLabel surname = new JLabel("Surname: ");
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 2; // row 1
        fgbc.gridwidth = 1; //1 cell
        form.add(surname, fgbc);

        JLabel dateOfArrival = new JLabel("Date of Arrival: ");
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 3; // row 3
        fgbc.gridwidth = 1; //1 cell
        form.add(dateOfArrival, fgbc);

        JLabel passport = new JLabel("Passport: ");
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 4; // row 4
        fgbc.gridwidth = 1; //1 cell
        form.add(passport, fgbc);

        JLabel priorityLabel = new JLabel("Priority: ");
        priorityLabel.setForeground(Color.red);
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 5; // row 5
        fgbc.gridwidth = 1; //1 cell
        form.add(priorityLabel, fgbc);

        //Form textfield       
        tfFname = new JTextField(20);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 1; //top row
        fgbc.gridwidth = 3; //3 cell
        form.add(tfFname, fgbc);

         tfLname = new JTextField();
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 2; // row 1
        fgbc.gridwidth = 3; //3 cell
        form.add(tfLname, fgbc);

        tfDate = new JTextField();
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 3; // row 2
        fgbc.gridwidth = 3; //3 cell
        form.add(tfDate, fgbc);

        tfPassport = new JTextField();
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 4; // row 2
        fgbc.gridwidth = 3; //3 cell
        form.add(tfPassport, fgbc);

        priorityType = new JComboBox(priority.values());
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 5; // row 3
        fgbc.gridwidth = 3; //3 cell
        form.add(priorityType, fgbc);

        //Button
        JButton btnSubmit = new JButton("Submit");
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 7; // row 6
        fgbc.gridwidth = 4; //3 cell
        form.add(btnSubmit, fgbc);
        btnSubmit.setActionCommand("Submit");
        btnSubmit.addActionListener(personController);
        return form;
            
    }

    public void mainPanel(String message, JPanel myPanel2) {
       //Frame size
        newFrame();
        //Panel 1 for welcome message
        JPanel myPanel1 = new JPanel();
        //message for Panel 1
        JLabel myLabel = new JLabel(message);//according to method calling it

        //Panel 3 for footer buttons
        JPanel myPanel3 = new JPanel();

       
 
        //Add Welcome message to Panel 1
        myPanel1.add(myLabel);

            
        //Frame Layout
        BorderLayout manager = new BorderLayout();
        frame.setLayout(manager);
        
        //Adding Panels to the frame
        frame.add(myPanel1, BorderLayout.NORTH);
        frame.add(myPanel2, BorderLayout.CENTER);
        frame.add(myPanel3, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    
        
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
    

}

    


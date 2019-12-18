
package init;

import gui.Controller;
import gui.PersonView;
import gui.Priority;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
    Controller personController;

    //first panel when system is initialized

     public HomeView(){
         personController = new Controller(this); 
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
        JButton button7 = new JButton("Logout");
        
         //Add Buttons to Panel 2
        myPanel2.add(button2);
        myPanel2.add(button3);
        myPanel2.add(button4);
        myPanel2.add(button5);
        myPanel2.add(button7);
        
        button2.setActionCommand("Update candidate information ");
        button2.addActionListener(personController);
        
        button3.setActionCommand("Check position by ID");
        button3.addActionListener(personController);
        
        button4.setActionCommand("Cut off from end of the queue");
        button4.addActionListener(personController);
            
        button5.setActionCommand("Remove candidate from queue");
        button5.addActionListener(personController);
      
        button7.setActionCommand("Logout");
         //Instance of Logout Class that terminate the program     
        Logout l = new Logout();
        button7.addActionListener(l);

       //Update Info
      
        //Check position by id
        

         //Check position by id
//        button3.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//        
//               
//               id = JOptionPane.showInputDialog(null,"Insert ID to get your position","Alert",JOptionPane.INFORMATION_MESSAGE);
////               
//
//
////                PersonModel personModel = new PersonModel();
////                
////                if(personModel.persons.contains("Hugh")){
////                    System.out.println("yes");
////                } else{
////                      System.out.println("no");
////                }
//               /*
//                    for(int i = 0; i<personModel.persons.size(); i++){
//                 int idInt = Integer.valueOf(id);
//                         System.out.println(i);
//                         
//                     int last = Integer.parseInt(personModel.persons.get(personModel.persons.size() - 1).getId());     
//                    if(last == idInt ){
//                        System.out.println("they match");;
//            }
//        }
//                System.out.println("no match");;
//             
//                    */       
//         
//            }
//        });

        
       

       // JPanel tablePanel = personView.populateTable();
           
       //Display DLL
        txtArea = new JTextArea(25,60);
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
    

    
    //Get the person ID and return 
    //the position in the queue
    public int displayGetId(String message){
        //Display Dialog Box and get the ID
      String input = JOptionPane.showInputDialog(this,message,"Alert",JOptionPane.INFORMATION_MESSAGE);

      //Check if numeric ID was input
      while (!isNumber(input)) {
          input = JOptionPane.showInputDialog(this,"Invalid value. Please insert a numeric value");
      }      
      
      //Parse into integer and return it
      int inputToInteger = Integer.valueOf(input);
      return inputToInteger;
    }
        
    //Display position in the queue from ID 
         public void displayPositionFound(int positionFound){
         String positionById;
         
        switch (positionFound) {
            case -1:
                positionById = "There is no one in the queue";
                break;
            case 0:
                positionById = "ID not found in the queue";
                break;
            default:
                positionById = "The person is at position " + positionFound + " in the queue";
                break;
        }
           JOptionPane.showMessageDialog(this,positionById); 
    }
     
     //Display for deleted elements from the end
     public void displayDeletedFromEnd(int deletedNodes){
         String positionById;
         
        switch (deletedNodes) {
            case -1:
                positionById = "There is no one in the queue";
                break;
            case 0:
                positionById = "Insert a lower number. There are fewer people in the queue";
                break;
            case 2:
                positionById = "No one will be removed";
                break;
               
            default:
                positionById = "Removed from the end of the queue: " + deletedNodes ;
                break;
        }
           JOptionPane.showMessageDialog(this,positionById); 
    }
     
      //Display message after remove first 
         public void displayRemoveFirst(int result){
         String positionById;
         
        switch (result) {
            case -1:
                positionById = "There is no one in the queue";
                break;
            default:
                positionById = "The appointment has been concluded";
                break;
        }
           JOptionPane.showMessageDialog(this,positionById); 
    }
     
     //To check if input is valid
      public boolean isNumber(String inputString) {
		try {
			Integer.parseInt(inputString);
			return true; //It is an integer
		} catch (NumberFormatException e) {
			return false;// Not an integer
		}
	}
    
    //Clear the whole queue from 
    //the Text Area
    public void clearText(){
        txtArea.setText ("");
    }
    
    //Display new DLL as a string in 
    //the JText Area
    public void setText(String list){
      txtArea.append (list + "\n");
    }
    
    //Form for a new Person
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
    
        //JDialog receives an input message to display
    public void generalAlertMessage(String message){
        JOptionPane.showMessageDialog(this,message);
        
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

    


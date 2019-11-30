/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package init;

import gui.AddPersonView;
import gui.Person;
import gui.PersonModel;
import gui.PersonView;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
    String logout;
    String goback;
    String id;
    
    PersonView personView = new PersonView();

    //first panel when system is initialized
    public HomeView() {
        HomePanel();
    }

    //constructor that receives panel
    //and place it onto the frame
    public HomeView(String message, JPanel panel, String logout, String goback) {
        this.message = message;
        this.panel = panel;
        this.logout = logout;
        this.goback = goback;
        mainPanel(message, panel, logout, goback);
    }

    //creating and setting the frame
    private void newFrame() {
       frame = new JDialog(frame, "Home");
        frame.setSize(600,600);
        frame.setModal(true);
        frame.setTitle("INIS Appointment System");
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.validate();
        frame.repaint();
    }

    public void HomePanel() {
        //Creating Panel 2
        JPanel myPanel2 = new JPanel();
        
        String b1 = "Add candidate to queue";
        String b2 = "Update candidate information ";
        String b3 = "Check position by ID";
        String b4 = "Cut off from end of the queue";
        String b5 = "Remove candidate from queue";
        String b6 = "Check queue";
        
    
         
        JButton button1 = new JButton(b1);
        JButton button2 = new JButton(b2);
        JButton button3 = new JButton(b3);
        JButton button4 = new JButton(b4);
        JButton button5 = new JButton(b5);
        JButton button6 = new JButton(b6);

        //Add Action command
        button1.setActionCommand(b1);
        button2.setActionCommand(b2);
        button3.setActionCommand(b3);
        button4.setActionCommand(b4);
        button5.setActionCommand(b5);
        button6.setActionCommand(b6);


        //Add Action Listeners
 
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Add a candidate to queue
                
                AddPersonView addPerson = new AddPersonView();
                addPerson.newPersonForm();
              //  DefaultPanel customer = new DefaultPanel();
                //customer.TwoButtonPanel("Customer","Add Customer", "Manage existing customer");
                
               
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //To manage titles options
               // DefaultPanel customer = new DefaultPanel();
                //customer.TwoButtonPanel("Titles","Add Title", "Manage existing title");
                //TitlesView titles = new TitlesView();
                //titles.TitlesPanel();
                System.out.println(b2);
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Check position by id
               
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
              
                
                        
                
            
                
                //DefaultPanel customer = new DefaultPanel();
                //customer.TwoButtonPanel("Rental","Create Rental from customer Loyalty Card", "Return Rental");
           
            }
        });

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //To manage Loyalty Card
                JOptionPane.showMessageDialog(null, b4);
                
               // Model myModel = new Model();
                //ResultSet rs = myModel.showPoints();

                //LoyaltyCardView loyaltyCard = new LoyaltyCardView();
                //loyaltyCard.viewPoints(rs);

            }
        });
        
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //To manage Loyalty Card
                JOptionPane.showMessageDialog(null, b5);
                
               // Model myModel = new Model();
                //ResultSet rs = myModel.showPoints();

                //LoyaltyCardView loyaltyCard = new LoyaltyCardView();
                //loyaltyCard.viewPoints(rs);

            }
        });
        
        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //To manage Loyalty Card
                JOptionPane.showMessageDialog(null, personView.populateTable());
                 DoublyLinkedList dList = new DoublyLinkedList();
                 dList.addNode(100,1);
               
                 /*dList.addNode(new Person(
                   "1",
                   "person1",
                    "Oleary",
                    "29-10-89",
                    "Fm026271",
                    "High"
                                      
            ),2); 
                dList.addNode(new Person(
                   "1",
                   "person2",
                    "Oleary",
                    "29-10-89",
                    "Fm026271",
                    "High"
                                      
            ),1); 
                
*/
                dList.showQueue();
       
             
            }
        });

        //Add Buttons to Panel 2
        myPanel2.add(button1);
        myPanel2.add(button2);
        myPanel2.add(button3);
        myPanel2.add(button4);
        myPanel2.add(button5);
        myPanel2.add(button6);
        
        
      //  JPanel tablePanel = personView.populateTable();
        JPanel container = new JPanel();
        //myPanel2.add(tablePanel);
        container.add(myPanel2);
        //container.add(tablePanel);
        

        //Panel 2 Grid layout
        GridLayout mgr = new GridLayout(3, 2);
        myPanel2.setLayout(mgr);

        //Placing panel into the frame
        mainPanel("Select an option", myPanel2, "Logout", "Go back");

    }

    public void mainPanel(String message, JPanel myPanel2, String b5, String b6) {
       //Frame size
        newFrame();
        //Panel 1 for welcome message
        JPanel myPanel1 = new JPanel();
        //message for Panel 1
        JLabel myLabel = new JLabel(message);//according to method calling it

        //Panel 3 for footer buttons
        JPanel myPanel3 = new JPanel();

        //Logout and Go Back buttons
        JButton btn5 = new JButton(b5);
        JButton btn6 = new JButton(b6);
        
        //Instance of Logout Class that terminate the program     
        Logout l = new Logout();
        btn5.addActionListener(l);
 
        //Add Welcome message to Panel 1
        myPanel1.add(myLabel);

        //Add Buttons to Panel 2
        myPanel3.add(btn5);
        myPanel3.add(btn6);
        
        //Frame Layout
        BorderLayout manager = new BorderLayout();
        frame.setLayout(manager);
        
        //Adding Panels to the frame
        frame.add(myPanel1, BorderLayout.NORTH);
        frame.add(myPanel2, BorderLayout.CENTER);
        frame.add(myPanel3, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

}

    


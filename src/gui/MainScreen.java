package gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JadyMartins
 */
public class MainScreen extends JFrame{
    
    private JDialog frame;
    private JPanel headerPanel, mainPanel, footerPanel;
    private JLabel header, header2, header3;
    
    PersonView personview = new PersonView();
    
    //Reusing code from previous assignments - author @JadyMartins
    public MainScreen(){
       panelFactory();
    }
    
     //Creating a new frame 
    private void newFrame() {
        frame = new JDialog(frame, "Home");
        frame.setSize(600,600);
        frame.setModal(true);
        frame.setTitle("INIS Appointment System");
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.validate();
        frame.repaint();
    }

    
    private void panelFactory(){
        newFrame();
                
        headerPanel = new JPanel();
      //  mainPanel = mainOptions();
        mainPanel = personview.populateTable();
        // mainPanel = addPersonDetails();
        footerPanel = new JPanel();
        
        header = new JLabel("Welcome to INIS appointment system");
       // header2 = new JLabel("h2 jfewfj");
        header3 = new JLabel("h3 jfope");   
        
        headerPanel.add(header);
       // mainPanel.add(header2);
        footerPanel.add(header3);
        
         //Frame Layout
        BorderLayout manager = new BorderLayout();
        frame.setLayout(manager);
        
       frame.add(headerPanel, BorderLayout.NORTH);
       frame.add(mainPanel, BorderLayout.CENTER);
      // frame.add(footerPanel, BorderLayout.SOUTH);
       
       frame.setVisible(true);
          
    }
    
    //First and main window
    private JPanel mainOptions(){
        JPanel mainOptions = new JPanel();
                        
        JButton button1 = new JButton("Add candidate to queue");
        JButton button2 = new JButton("Update candidate information ");
        JButton button3 = new JButton("Check position by ID");
        JButton button4 = new JButton("Cut off from end of the queue");
        JButton button5 = new JButton("Remove candidate from queue");
        JButton button6 = new JButton("Logout");
        
        mainOptions.add(button1);
        mainOptions.add(button2);
        mainOptions.add(button3);
        mainOptions.add(button4);
        mainOptions.add(button5);
        mainOptions.add(button6);
        
        //Panel 2 Grid layout
        GridLayout mgr = new GridLayout(3, 3);
        mainOptions.setLayout(mgr);

        
        return mainOptions;
    }
   
     
        
  public void alertDialog(String input){
    
       JOptionPane.showMessageDialog(this,input,"Alert",JOptionPane.INFORMATION_MESSAGE);
  }
    
   public String inputDialog(String input){
    
       String id = JOptionPane.showInputDialog(this,input,"Alert",JOptionPane.INFORMATION_MESSAGE);
       System.out.println(id);
       
       return id;
  }
    
}

/*
Class created in order to use a JTable
But instead JText Area was implemented
 */
package gui;

import init.HomeView;
import java.awt.BorderLayout;
import java.util.ArrayList;
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
public class PersonView extends JFrame {

    private String[][] data = new String[10][6];
    public static JTable searchPerson;
    public static JTable table;
    private static String id;
    private static String firstName;
    private static String lastName;
    private static String doa;
    private static String passport;
    private static String queuePosition;
    static JButton[] options = new JButton[3];
    public static DefaultTableModel model;
    public static ArrayList arr;

    HomeView homeView;
    //  PersonModel pmodel = new PersonModel();
    PersonModel personModel = new PersonModel();
    Controller personController;
    // CustomerController customerController = new CustomerController();

    public PersonView() {
        // personController = new Controller(this); 

    }

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
//        table.getSelectionModel().addListSelectionListener(personController);

        //Panel which we add the table to  table 
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BorderLayout());

        //Add ScrollPane to the panel
        myPanel.add(sp, BorderLayout.CENTER);

        //Populating main frame with Panel
        //homeView = new HomeView("Select a customer", myPanel, "Logout", "Go back");
        return myPanel;
    }

//               
    public String getFirstName() {
        return (String) table.getValueAt(table.getSelectedRow(), 0);
    }

    public String getLastName() {
        return (String) table.getValueAt(table.getSelectedRow(), 1);
    }

    public String getId() {
        return (String) table.getValueAt(table.getSelectedRow(), 2);
    }

    public String getDoa() {
        return (String) table.getValueAt(table.getSelectedRow(), 3);
    }

    public String getPassport() {
        return (String) table.getValueAt(table.getSelectedRow(), 4);
    }

    public String getQueuePosition() {
        return (String) table.getValueAt(table.getSelectedRow(), 5);
    }

}

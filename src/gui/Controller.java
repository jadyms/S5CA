/*
 
Controller of the application
 */
package gui;

import init.HomeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import list.DoublyLinkedList;
import list.Node;

/**
 *
 * @author JadyMartins
 */
public class Controller implements ActionListener {

    HomeView homeView;
    PersonModel personModel = new PersonModel();
    Person person = new Person();
    static DoublyLinkedList dList = new DoublyLinkedList();
    ArrayList<DoublyLinkedList> aList = new ArrayList<>();


    public Controller(HomeView homeView) {
        this.homeView = homeView;
    }
//     public Controller(PersonView personView){
//        this.personView = personView;
//    }
//    

    public Controller() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //New Person to the queue
        if (e.getActionCommand().equals("Submit")) {

            //Create ID
            int last = Integer.parseInt(personModel.persons.get(personModel.persons.size() - 1).getId()) + 1;
            //Create new Person
            Person newPerson = new Person(String.valueOf(last),
                    homeView.getFirstName(),
                    homeView.getLastName(),
                    homeView.getDate(),
                    homeView.getPassport(),
                    homeView.getPriority());
            //Create new Node
            Node newNode = new Node(newPerson, homeView.getPriorityNumber());

            //Add Node to the list
            dList.addNode(newNode, homeView.getPriorityNumber());

            //create a new customer and add it to array
            //To update the db
            personModel.persons.add(new Person(
                    String.valueOf(last),
                    homeView.getFirstName(),
                    homeView.getLastName(),
                    homeView.getDate(),
                    homeView.getPassport(),
                    homeView.getPriority()
            ));
           
            System.out.println("Printing DList ");
            System.out.println(dList);
            // aList.add(dList);

            //Display the queue
            homeView.clearText();
            homeView.setText(dList.toString());

            //Cut off from end of the queue
        } else if (e.getActionCommand().equals("Cut off from end of the queue")) {

            int toBeDeleted;
            int deletedNodes;
            int size;

            //get number of elements to be removed
            String message = "Elements to be removed from the end of the queue";
            toBeDeleted = homeView.displayGetId(message);

            //pass on list size and nodes to be deleted
            size = dList.size(dList.head.previous);
            deletedNodes = dList.deleteFromEnd(toBeDeleted, size);

            //display updated queue
            homeView.displayDeletedFromEnd(deletedNodes);
            homeView.clearText();
            homeView.setText(dList.toString());

//            }else if (dList.isEmpty()){
//                 throw new IllegalStateException();
//             }

            //Remove candidate from queue
        } else if (e.getActionCommand().equals("Remove candidate from queue")) {
            //call method and receive a status integer
            int removeFirst;
            removeFirst = dList.removeFirst();

            //display message according to status
            homeView.displayRemoveFirst(removeFirst);

            //display updated queue
            homeView.clearText();
            homeView.setText(dList.toString());

            //Check position by ID
        } else if (e.getActionCommand().equals("Check position by ID")) {

            int toFindId;
            int positionFound;
            //get given id
            String message = "Insert ID to get your position";
            toFindId = homeView.displayGetId(message);
            //search the position in the queue 
            positionFound = dList.searchPosition(toFindId);
            //display message according to status
            homeView.displayPositionFound(positionFound);

            //Update candidate information
        } else if (e.getActionCommand().equals("Update candidate information")) {
            int personID;
            int positionFound;
            Node head = dList.head;
            //get given id
            String message = "Insert Person ID";
            personID = homeView.displayGetId(message);
            //get the details given the position
            positionFound = dList.searchPosition(personID);
            String personDetails = dList.personDetails(head, positionFound);
            int answer = homeView.displayPersonDetails(personDetails);

        }
    }

}

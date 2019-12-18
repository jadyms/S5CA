package init;

import gui.PersonModel;

/**
 *
 * @author JadyMartins github https://github.com/jadyms Reusing code from
 * previous assignments - author @JadyMartins Some other inspiration code
 * https://www.javatpoint.com/java-program-to-search-an-element-in-a-doubly-linked-list
 * https://www.geeksforgeeks.org/priority-queue-using-doubly-linked-list/
 */
public class Main {

    public static void main(String[] args) {

        //Loading all the Db into arraylists 
        //Then dealing only with the DLL
        PersonModel personModel = new PersonModel();
        personModel.getPerson();

        //Loading main frame
        new HomeView();
    }

}

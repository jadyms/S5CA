package list;

import gui.Person;
import gui.PersonModel;

/**
 *
 * @author JadyMartins
 * @param <Person>
 */

//Node to be added onto the DLL
public class Node {
    
    public Person person;
    public Node previous;
    public Node next;
    public int p; //priority
    PersonModel personModel;
      
    //Constructor
    public Node(Person person, int p){
        this.person = person;
        this.p = p;
        previous = null;
        next = null;
        }
    
    public Node(PersonModel personModel){
        this.personModel = personModel;
        
    }
    
    //Getters and setters    
    public Person getPerson(){
        return person;
    }
    
    public void setPerson(Person person){
        this.person = person;
    }
    //ToString Method
    @Override
    public String toString(){
        return person.toString() + " " + p;
    }
    
    
    
}

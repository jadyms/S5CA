/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

import gui.Person;
import gui.Priority;

/**
 *
 * @author JadyMartins
 * @param <Person>
 */
public class Node<Person> {
    
    Person person;
    int data; //this should be person
    Node previous;
    Node next;
    Priority priority;
    int p;
    
    
      
    public Node(Person person){
        this.person = person;
              previous = null;
        next = null;
        }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

import gui.Person;

/**
 *
 * @author JadyMartins
 * @param <Person>
 */
public class Node<Person> {
    
    Person person;
    Node previous;
    Node next;
    int p;
    
    
      
    public Node(Person person, int p){
        this.person = person;
        this.p = p;
        previous = null;
        next = null;
        }
    
}
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
 */
public class Node {
    
    Person person;
    int data; //this should be person
    Node previous;
    Node next;
    Priority priority;
    
    
     public Node(int data){
        this.data = data;
    }
    
    public Node(Person person){
        this.person = person;
    }
    
}

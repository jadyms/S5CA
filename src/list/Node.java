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
public class Node {
    
    public  Person person;
    public Node previous;
    public Node next;
    public int p;
    
    
      
    public Node(Person person, int p){
        this.person = person;
        this.p = p;
        previous = null;
        next = null;
                 
        
        }

    
    public Person getPerson(){
        
               
        return person;
    }
    
    public void setPerson(Person person){
        this.person = person;
    }
    
    @Override
    public String toString(){
        
        return person.toString() + " " + p;
    }
    
    
    
}

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
public class DoublyLinkedList <Person> {
    
    Node<Person> head;
    Node<Person>  tail;
    int size;
    
    public DoublyLinkedList(){
       
    }
      public void addNode(Person person, int p){
        
         
         //creating a new node
            Node<Person> newNode = new Node(person,p);
            
            
            if (head == null){ //list is empty
                
                //head  and tail points to new Node
                head = newNode; 
                tail = newNode; 
                //before head it is null
                head.previous = null;
                //end of queue is null
                tail.next  = null;
                
            } else if(p == 3){
                Node temp = tail;
                tail = newNode;
                tail.next = null;
                tail.previous = temp;
            /*    
            }else{
                
                
                // If p is Low, go to the end of queue
        if (p <= (head).p) {  
            newNode.next = head;  
            (head).previous = newNode.next;  
            head = newNode;  
        }  
        // If p is more rear node's priority,   
        // then insert after the rear.  
        else if (p > (tail).p) {  
            newNode.next = null;  
            (tail).next = newNode;  
            newNode.previous = (tail).next;  
            tail = newNode;  
        }  
        
            */ 
            }
            
                              
        }
     public void showQueue(){
                
         Node actualNode = head;
         if(head == null){
             System.out.println("No one on the queue");
         } else{
             while(actualNode != null){
                 System.out.println(actualNode.person.toString() + "");
                 actualNode = actualNode.next;
                 
             }
         }
            }
   /*
      public void addNode(Person person, int priority){
         
         //creating a new node
            Node newNode = new Node(person);
            
            
            if (head == null){ //list is empty
                
                //head  and tail points to new Node
                head = newNode; 
                tail = newNode; 
                //before head it is null
                head.previous = null;
                //end of queue is null
                tail.next  = null;
                
            } else{
                
                
                tail.next = newNode;
                newNode.previous = tail;
                tail = newNode;
                tail.next = null;
            }
            
                              
        }
     public void showQueue(){
                
         Node actualNode = head;
         if(head == null){
             System.out.println("No one on the queue");
         } else{
             while(actualNode != null){
                 System.out.println(actualNode.person.toString() + "");
                 actualNode = actualNode.next;
             }
         }
            }
    */

    public int size() {
    
        return size;
    }
     
     
}

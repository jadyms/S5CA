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
public class DoublyLinkedList {
    
    public Node head;
    public Node  tail;
    int size ;
    public Person prsn;
    
    public DoublyLinkedList(){
       
    }
      public void addNode(Person person, int p){
        
         
         //creating a new node
            Node newNode = new Node(person, p);
          
                        
            if (head == null){ //list is empty
                
                //head  and tail points to new Node
                head = newNode; 
                tail = newNode; 
                //before head it is null
                head.previous = null;
                //end of queue is null
                tail.next  = null;
                
                //if Priority is low(3), go straight to the end of the queue
            } else if
                (p == 3){
                //Node temp = tail;
                tail.next = newNode;
                newNode.previous = tail;
                tail = newNode;
                tail.next = null;

                //Code adapted from 
                //https://www.geeksforgeeks.org/priority-queue-using-doubly-linked-list/
            }else{
                
                //newNode has a higher priority (lower number)
                //insert before current Node
                if (newNode.p < head.p) {  
                    newNode.next = head;  
                    head.previous = newNode.next;  
                    head = newNode;
                }
                
                //newNode has a lower priority (higher number) than the tail
                //insert after the current Node
                //new tail point to null
                 else if (newNode.p > tail.p) {  
                     newNode.next = null;  
                     tail.next = newNode; 
                     newNode.previous = tail.next;  
                     tail = newNode;  
        }  
                
                
                
                else { 
                     // Find position where we need to  
                     // insert.  
                     Node start = head.next;  
                     //move the pointer forward
                     //while the node priority
                     //has a lower number (higher priority)
                     // 1 1 3
                     while (start.p <= newNode.p){
                         start = start.next; 
                     }
                     (start.previous).next = newNode;  
                     newNode.next = start.previous;  
                     newNode.previous = (start.previous).next;  
                     start.previous = newNode.next;  
                 }      
   
                
                   }
                          
             size++;                 
        }
      
//      At any time, the staff member should have the ability 
//      to delete a person from the system by entering
//      in their unique ID number
      
      public void deleteById(int Id){
          
        
      }
      
      public void removeFirst(){
      
          //list is empty
        if (head == null) {
      
            System.out.println("List is empty");
            //list has only one element
        }else if(head.next==null) {
                tail = null;
                head = null;
                //if list has more than 1 element
        }else{
            //point next node to null as its previous
                head.next.previous = null;
                //set new head
                head = head.next;
            
        }
        
    }
      
      public void cutOffEndQueue(int Nth, int size){
        
          //If List is empty
          if(head == null){
              System.out.println("list is empty");
          
          //List is smaller than elements to be deleted
          }else if(Nth>size){
               System.out.println("select less elements to be deleted");
       
               //Number of elements is lower than list size
          }else if(Nth < size){
              //actualNode is the tail            
              Node actualNode = tail;
              //pointer starting at 0
              int start = 0;
              //move actualNode to the previous node until pointer 
              //reaches the Nth position 
              //that nodes will be deleted from
              while (actualNode.previous != null && start < Nth){
                  actualNode = actualNode.previous;
                  start ++;
              }
        
              //pointer points to the node to be deleted
              if (start == Nth) {
			tail = actualNode; //current node 
			tail.next = null; //tail points to null
              }
              size = (size - Nth);// decreases the list size
          } 
          
      }
     
          @Override
   public String toString() {
       
        String toReturn = "";
        
        Node current = head;
        
        while (current != null) { 
            toReturn = toReturn +  current.toString() + "\n"; 
            current = current.next; 
        }
       
        return toReturn;
   }
            
  
  
    public int size(Node head) {
       
       while (head != null)  
        { 
                size++; 
                head = head.next; 
        } 
  
        return size; 
    
    }
     
     
}

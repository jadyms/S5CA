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
           // prsn = person;
                        
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
   
  
                
//                  Node prev = null;
//                  Node cur = head;
//                  
//                  //actual node has priority 1
//                  //New node has priority 1 or 2
//                  
//                 //addFirst
//             
//                 
//                  while(cur != null &&  newNode.p > cur.p ) {
//                     
//                     prev = cur;
//                     cur = cur.next;
//                      System.out.println("This is prev" + prev);
//                      System.out.println("This is cur" + cur);
//                  }
//                  
//                  newNode.next = prev.next;
//                 prev.next = newNode;
//                 newNode.previous = prev;
//                 
//                  
//                  if(newNode.next != null){
//                      newNode.next.previous = newNode;
//                  }
//                  //insert between cur and prev
         
                
                                
                /*
                        //If new Node has higher priority (2)
            }else if(head.next != null && newNode.p > head.p){
            
                         newNode.next = null;
                         newNode.previous = head;
                        head.next = newNode;
                        tail = head.next;
                        
                        System.out.println("this is the head" + head.person.toString());
                        System.out.println("this is the tail" + tail.person.toString());
                        
                      //If there is a single node in the list
                    //and
                    //new Node has lower priority 
            }else if(head.next == null && head.p >newNode.p){
                Node temp = head;
                newNode.next = temp;
                temp.previous = newNode;
                head = newNode;
                tail = temp;
                        
                System.out.println("this is the head from met2" + head.person.toString());
                System.out.println("this is the tail from met 2" + tail.person.toString());
                
                
              
                 
                Node pointer = head.next;
              
              //while currently node has higher priority
              while(pointer.p > p){
                   pointer = pointer.next;
                  (pointer.previous).next = newNode;
                  newNode.next = pointer.previous;
                  newNode.previous = (pointer.previous).next;
                  pointer.previous = newNode.next;
                  
                  System.out.println("this is the head" + head.person.toString());
                  System.out.println("this is the tail" + tail.person.toString());
                 
                  
                  
                }
               */
               
                
                   }
                          
             size++;                 
        }
      
//      At any time, the staff member should have the ability 
//      to delete a person from the system by entering
//      in their unique ID number
      
      public void deleteById(int Id){
          
        
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
      public String elementAt(int index){
        if(index>size){
            return "blah";
        }
        Node n = head;
        while(index-1!=0){
            n=n.next;
            index--;
        }
        return n.person.toString();
    }
      
     public void showQueue(){
                
     
         if(head == null){
             return;
             
         } 
             Node actualNode = head;
                         
             while(actualNode != null){
                 System.out.println(actualNode.person.toString() + "");
                 actualNode = actualNode.next;
                 System.out.println("this is the actual node" +actualNode);
             }
             
             System.out.println("null");
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
            
    public void printList(Node node) { 
        while (node != null) { 
            System.out.print(node.person.toString() + " "); 
            node = node.next; 
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

    public int size(Node head) {
       
       while (head != null)  
        { 
                size++; 
                head = head.next; 
        } 
  
        return size; 
    
    }
     
     
}

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
  */
public class DoublyLinkedList {
    
    public Node head;
    public Node  tail;
    int size ;
    //public Person prsn;
    
    public DoublyLinkedList(){
       
    }
      public void addNode(Node futureNode, int p){
        
         
         //creating a new node
           // Node newNode =  new Node(futureNode, p);
           Node newNode = futureNode;
          
                        
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
      
      //searchNode() will search a given node in the list  
    public int searchPosition(int toFindId) {  
        int i = 1;  
        boolean flag = false;  
      
        //Node current will point to head  
        Node current = head;  
  
         
        //Checks whether the list is empty  
        if(head == null) {  
            System.out.println("List is empty");  
            return -1;  
        }  
        while(current != null) {  
             int nodeID = Integer.parseInt(current.getPerson().getId());
            //Compare value to be searched with each node in the list  
            if(nodeID == toFindId) {  
                flag = true;  
                break;  
            }  
            current = current.next;  
            i++;  
        }  
        if(flag)  {
             System.out.println("Node is present in the list at the position : " + i);  
        return i;
        }
        else  
             System.out.println("Node is not present in the list");  
   return 0;
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
      
      
      
//      public String[][] doublyLinkedListToArray(){
//         String[][] data = new String[this.size][6];
//		Node start = this.head;
//		int i = 0;
//		while (start != null) {
//			data[i][0] = String.valueOf(start.getPerson().getId());
//			data[i][1] = start.getPerson().getFirstname();
//			data[i][2] = start.getPerson().getLastname();
//			data[i][3] = start.getPerson().getDoa();
//			data[i][4] = start.getPerson().getPassport();
//			data[i][5] = start.getPerson().getPriority();
//			i++;
//			start = start.next;
//		}
//		return data;
//      }
     
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

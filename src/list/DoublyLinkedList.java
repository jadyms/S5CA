/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

/**
 *
 * @author JadyMartins
 */
public class DoublyLinkedList {
    
    Node head;
    Node tail;
    int size;
    
    public DoublyLinkedList(){
       
    }
     public void addNode(int data){
         
         //creating a new node
            Node newNode = new Node(data);
            
            
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
                 System.out.println(actualNode.data + "");
                 actualNode = actualNode.next;
             }
         }
            }
     
     
}

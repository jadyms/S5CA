/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

/**
 *
 * @author JadyMartins
 * @param <Person>
 */
public class DoublyLinkedList <Person> {
    
    Node<Person> head;
    Node<Person>  tail;
    int size = 0;
    
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
                
                //if Priority is low(3), go straight to the end of the queue
            } else if
                (p == 3){
                Node temp = tail;
                tail = newNode;
                tail.next = null;
                tail.previous = temp;
              
                        //If there is a single node in the list
                    //and
                    //new Node has higher priority (2)
            }else if(head.next == null && newNode.p > head.p){
            
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
                /*
                 
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

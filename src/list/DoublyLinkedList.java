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
  
//Default Constructor    
    public DoublyLinkedList(){
       this.head = null;
       this.tail = null;
       this.size = 0;
    }
      public void addNode(Node futureNode, int p){
     
           Node newNode = futureNode;
          
           //list is empty
            if (head == null){ 
                System.out.println("AddFirst"); 
               addFirst(newNode);
                               
                //if Priority is low(3), go straight to the end of the queue
            } else if (p == 3){
                System.out.println("AddLast");
                addLast(newNode);
                
            //newNode has a higher priority (lower number)
                //insert before current Node
                
            }else if (newNode.p < head.p && head.next != null) {  
                    System.out.println("add before ");
                    addBefore(newNode);
                    
            } else{
                System.out.println("else");
                addBetweenNodes(newNode);
                // move the pointer until the next node has
          //a lower priority (higher number)
         
//                while (head.next != null && head.next.p < newNode.p )  
//                    head = head.next; 
//                    
//                System.out.println("head > " + head);
//  
//                /* Make the appropriate links */
//              //  newNode.next = head.next; 
//                newNode.next = head.next; 
//                System.out.println("newNode.next> " + newNode.next);
//  
//                // if the new node is not inserted  
//                // at the end of the list 
//                if (head.next != null )  {
//                    System.out.println("if do else");
//                    newNode.next.previous = newNode.next;
//                    System.out.println("newNode.next.previous> " + newNode.next.previous);
//                    head.next = newNode; 
//                    System.out.println("head.next = newNode> " + head.next );
//                    newNode.previous = head; 
//                    System.out.println("newNode.previous" + newNode.previous);
//                }else if (head.next.next.p > newNode.p){
//                    
//                    System.out.println("aquiiii");
//                
//                  
//                
////                }else if(head.next.p > newNode.p && head.next != null){
////                System.out.println("add before lower priority");
////                addBeforeLowerPriority(newNode);
////                
////                }else if(head.next.p == newNode.p && head.next.next.p > newNode.p){
//////                    System.out.println("add after all higher priority");
//////                    addAfterSamePriority(newNode);
//////                
//////                //newNode has a lower priority (higher number) than the tail
//////                //insert after the current Node
//////                //new tail point to null
//////                } else if (newNode.p > tail.p) {  
//////                     System.out.println("lower priority than tail");
//////                     newNode.next = null;  
////                     tail.next = newNode; 
////                     newNode.previous = tail.next;  
//////                     tail = newNode;  
////        }  
////                
////                else { 
//////                     
//////                   //  addBeforeLowerPriority(newNode);
////////                     // Find position where we need to  
////////                     // insert.  
//////                     Node start = head.next;  
//////                     //move the pointer forward
//////                     //while the node priority
//////                     //has a lower number (higher priority)
////                     
////                     if (start.p == newNode.p){
////                     while (start.p != newNode.p){
////                         start = start.next; 
////                     }
////                     (start.previous).next = newNode;  
////                     newNode.next = start.previous;  
////                     newNode.previous = (start.previous).next;  
////                     start.previous = newNode.next;  
////                 } 
////            
//            }    
   
                
                  
                          
             size++;                 
        }
      }
      public void addBefore(Node newNode){
          newNode.next = head;  
                    head.previous = newNode.next;  
                    head = newNode;
      }
      
      
      public void addBetweenNodes(Node newNode){
            // move the pointer until the next node has
          //a lower priority (higher number)
                         while (head.next != null && head.next.p < newNode.p )  
                    head = head.next; 
                    
                System.out.println("head > " + head);
  
                /* Make the appropriate links */
              //  newNode.next = head.next; 
                newNode.next = head.next; 
                System.out.println("newNode.next> " + newNode.next);
  
                // if the new node is not inserted  
                // at the end of the list 
                if (head.next != null )  {
                    System.out.println("if do else");
                    newNode.next.previous = newNode.next;
                    System.out.println("newNode.next.previous> " + newNode.next.previous);
                    head.next = newNode; 
                    System.out.println("head.next = newNode> " + head.next );
                    newNode.previous = head; 
                    System.out.println("newNode.previous" + newNode.previous);
                }else if (head.next.next.p > newNode.p){
                    
                    System.out.println("aquiiii");
            
            }    
      }
      
//      public void addAfterSamePriority(Node newNode){
//          
//           while (head.next != null && head.next.p > newNode.p)  
//                    head = head.next; 
//  
//                /* Make the appropriate links */
//                newNode.next = head.next; 
//  
//                // if the new node is not inserted  
//                // at the end of the list 
//                if (head.next != null)  
//                    newNode.next.previous = newNode;  
//  
//                head.next = newNode;  
//                newNode.previous = head;
//          
//             /* 4. Make next of new node as next of prev_node */
//        newNode.next = prev_Node.next; 
//  
//        /* 5. Make the next of prev_node as new_node */
//        prev_Node.next = new_node; 
//  
//        /* 6. Make prev_node as previous of new_node */
//        new_node.prev = prev_Node; 
//  
//        /* 7. Change previous of new_node's next node */
//        if (new_node.next != null) 
//            new_node.next.prev = new_node; 
          
//      }
      public void addBeforeLowerPriority(Node newNode){
          
          // move the pointer until the next node has
          //a lower priority (higher number)
                while (head.next != null && head.next.p < newNode.p)  
                    head = head.next; 
  
                /* Make the appropriate links */
                newNode.next = head.next; 
  
                // if the new node is not inserted  
                // at the end of the list 
                if (head.next != null)  
                    
                    newNode.next.previous = newNode;  
  
                head.next = newNode;  
                newNode.previous = head;  
      }
      
//      At any time, the staff member should have the ability 
//      to delete a person from the system by entering
//      in their unique ID number
      
      public void deleteById(int Id){
          //call method search position and get position
          
          //create method to delete in the middle
        
      }
      
      //Remove person from the top of the queue
        public int removeFirst(){
            //list is empty
        if (head == null) {               
            return -1;
             //list has only one element           
        }else if(head.next==null) {          
                tail = null;
                head = null;
                return 1;
             //list has more than 1 element
        }else{                               
                head.next.previous = null;  //point next node to null as its previous
                head = head.next;           //set new head
            
        }
        return 1;
        
    }
        //add to the head
        public void addFirst(Node newNode){
                //head  and tail points to new Node
                head = newNode; 
                tail = newNode; 
                //before head it is null
                head.previous = null;
                //end of queue is null
                tail.next  = null;
        }
        
        //add to the tail
        public void addLast(Node newNode){
                tail.next = newNode;
                //point to the end of the queue
                newNode.previous = tail;
                tail = newNode;
                //end of the queue
                tail.next = null;
        }
   
      //return position in queue given an ID
    public int searchPosition(int toFindId) {  
        int pointer = 1;  //pointer start
        boolean flag = false;  
        Node current = head;  //node start
  
        //Checks whether the list is empty  
        if(head == null) {  
            System.out.println("List is empty");  
            return -1;  
        }  
          //Compare given ID to Current Node ID  
        while(current != null) {  
             int nodeID = Integer.parseInt(current.getPerson().getId());
            if(nodeID == toFindId) {  
                flag = true;  //If found
                break;  
            }  
            //If not found
            current = current.next;  //go to next node
            pointer++;  //increment pointer
        }  
        
        if(flag)  {
             System.out.println("Node is present in the list at the position : " + pointer);  
        return pointer;
        }
        else  
             System.out.println("Node is not present in the list");  
         return 0;
    }  
    
    //Check if list is empty
    //exceptions not correctly implemented
    public boolean isEmpty(){
        try{
            if(head == null);
            return true; //It is empty
        } catch (IllegalStateException e) {
            return false;// List is not empty
        }
	}
    
   //To delete N elements from the end of the queue
      public int deleteFromEnd(int toBeDeleted, int size){
        
          //If List is empty
          if(head == null){
        //if(isEmpty()){
              System.out.println("list is empty");
                     
              return -1;
              
          
          //List is smaller than elements to be deleted
          }else if(toBeDeleted>size){
               System.out.println("select less elements to be deleted");
                   return 0;
       
               
          }else if(toBeDeleted==0){
              System.out.println("No elements will be removed"); 
              return 2;
          }
          //Number of elements is lower than list size
              else if(toBeDeleted < size){
              //actualNode is the tail            
              Node actualNode = tail;
              //pointer starting at 0
              int start = 0;
              //move actualNode to the previous node until pointer 
              //reaches the Nth position 
              //that nodes will be deleted from
              while (actualNode.previous != null && start < toBeDeleted){
                  actualNode = actualNode.previous;
                  start ++;
              }
        
              //pointer points to the node to be deleted
              if (start == toBeDeleted) {
			tail = actualNode; //current node 
			tail.next = null; //tail points to null
              }
              size = (size - toBeDeleted);// decreases the list size
              
          } 
          return 1;
      }
   
      //return person Details  given an ID
    public String personDetails (Node head, int position) {  
       int pointer = 1;  
        
    //if count equal too n return node.data  
    if(pointer == position)  
      
    return head.person.toString();  
      
    //recursively decrease n and increase  
    // head to next pointer  
    return personDetails(head.next, position - 1);  
}  
    
    
   //Print the list to String
      @Override
   public String toString() {
        String toReturn = "";
        Node   current = head; //pointer start
        while (current != null) { 
               toReturn = toReturn +  current.toString() + "\n"; 
               current = current.next; 
        }
        return toReturn;
   }
            
  
  //get size of the list
    public int size(Node head) {
       while (head != null)  
        { 
                size++; 
                head = head.next; 
        } 
        return size; 
    
    }
     
     
}

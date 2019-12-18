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
                addFirst(newNode);
                               
                //if Priority is low(3), go straight to the end of the queue
            } else if (p == 3){
                addLast(newNode);
             
//                tail.next = newNode;
//                newNode.previous = tail;
//                tail = newNode;
//                tail.next = null;

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
        
        public void addLast(Node newNode){
          
                tail.next = newNode;
                newNode.previous = tail;
                tail = newNode;
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
    
    public boolean isEmpty(){
        try{
            if(head == null);
            return true; //It is empty
        } catch (IllegalStateException e) {
            return false;// List is not empty
        }
	}
    
   
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

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
public class Solution {
    
    
static Node front , rear; 
      
// Linked List Node  
static class Node<Person> {
    
    Person person; 
    int info;  
    int priority;  
    Node prev, next;  
} 
    
// Function to insert a new Node  
static void push(Node fr, Node rr, int n, int p)  
{  
 
    Node news = new Node();
    news.info = n;  
    news.priority = p;  
    
    // If linked list is empty  
    if (fr == null) {  
        fr = news;  
        rr = news;  
        news.next = null;  
    }  
    else {  
        // If p is less than or equal front  
        // node's priority, then insert at  
        // the front.  
        if (p <= (fr).priority) {  
            news.next = fr;  
            (fr).prev = news.next;  
            fr = news;  
        }  
    
        // If p is more rear node's priority,   
        // then insert after the rear.  
        else if (p > (rr).priority) {  
            news.next = null;  
            (rr).next = news;  
            news.prev = (rr).next;  
            rr = news;  
        }  
    
        // Handle other cases  
        else {  
    
            // Find position where we need to  
            // insert.  
            Node start = (fr).next;  
            while (start.priority > p)   
                start = start.next;              
            (start.prev).next = news;  
            news.next = start.prev;  
            news.prev = (start.prev).next;  
            start.prev = news.next;  
        }  
    }  
    front =fr; 
    rear=rr; 
}  
    
// Return the value at rear  
static int peek(Node fr)  
{  
    return fr.info;  
}  
    
static boolean isEmpty(Node fr)  
{  
    return (fr == null);  
}  
    
// Removes the element with the  
// least priority value form the list  
static int pop(Node fr, Node rr)  
{  
    Node temp = fr;  
    int res = temp.info;  
    (fr) = (fr).next;  
    if (fr == null)   
       rr = null;  
      
    front =fr; 
    rear=rr; 
       return res;  
      
}
}
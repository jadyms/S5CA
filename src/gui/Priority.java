/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author JadyMartins
 */
public enum Priority {
    
    LOW(3),
    MEDIUM(2),
    HIGH(1);
    
    private int priorityLevels;
    
    Priority(final int priorityLevels){
        this.priorityLevels = priorityLevels;
           
    }
    public int getPriorityLevels(){
        return priorityLevels;
        
    }
}

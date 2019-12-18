
package gui;

/**
 *
 * @author JadyMartins
 */
//Ordinal function could have been used here
public enum Priority {
    
    LOW(3),
    MEDIUM(2),
    HIGH(1);
    
    private final int priorityLevels;
    
    Priority(final int priorityLevels){
        this.priorityLevels = priorityLevels;
           
    }
    public int getPriorityLevels(){
        return priorityLevels;
        
    }
}

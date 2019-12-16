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
public class Person {
    //attrubutes
    
    private  String id;
    private  String firstName;
    private  String lastName;
    private  String doa;
    private  String passport;
    private  String priority;
    private int prt;
   
 //  PersonView personView = new PersonView();

    public Person(String id, String firstName, String lastName, String doa, String passport, String priority) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.doa = doa;
        this.passport = passport;
        this.priority = priority;

    }
    
    //Conversion between priority int and string
    public Person(String id, String firstName, String lastName, String doa, String passport, int prt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.doa = doa;
        this.passport = passport;
        this.prt = prt;

    }
    public Person(){
        
    }
 
    //getters and setters

    public String getFirstname() {
        return this.firstName;
    }
//     public void setFirstName(String firstName){
//         this.firstName = firstName;
//     }

    public String getLastname() {
        return this.lastName;
    }
//     public void setLastName(String lastName){
//         this.lastName = lastName;
//     }

    public String getId() {
        return this.id;
    }
//     public void setId(String id) {
//         this.id = id;
//    }

    public String getDoa() {
        return doa;
    }
//    public void setDoa(String doa) {
//        this.doa = doa;
//    }

    public String getPassport() {
        return this.passport;
    }
//     public void setPassport(String passport) {
//        this.passport = passport;
//    }

    public String getPriority() {
        return this.priority;
    }
    
//    public void setPriority(String priority) {
//        this.priority = priority;
//    }
       
     public int getPriorityNumber() {
        return this.prt;
    }
     
//      public void setPriorityNumber(int prt) {
//        this.prt = prt;
//    }
     
    
    

     
    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", doa=" + doa + ", passport=" + passport + ", queuePosition=" + priority + '}';
    }
   
    
}

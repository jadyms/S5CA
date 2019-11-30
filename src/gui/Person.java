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
   
 //  PersonView personView = new PersonView();

    public Person(String id, String firstName, String lastName, String doa, String passport, String priority) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.doa = doa;
        this.passport = passport;
        this.priority = priority;

    }
    
    public Person(){
        
    }
 
    //getters

    public String getFirstname() {
        return this.firstName;
    }

    public String getLastname() {
        return this.lastName;
    }

    public String getId() {
        return this.id;
    }

    public String getDoa() {
        return this.doa;
    }

    public String getPassport() {
        return this.passport;
    }

    public String getPriority() {
        return this.priority;
    }
       
    
    /*
     public void FillCustomerForm(String fname, String lname, String subscription, String card, String loyalty_card) {

        //get user info from the db
        //call this method passing an user as an object
        updateCustomer = new AddCustomerView();
        updateCustomer.addCustomer(fname, lname, subscription, card)
                ;
    

    }
    */

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", doa=" + doa + ", passport=" + passport + ", queuePosition=" + priority + '}';
    }
   
    
}

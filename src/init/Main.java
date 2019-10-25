/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package init;

import gui.PersonModel;

/**
 *
 * @author JadyMartins
 */
public class Main {
    
    public static void main(String[] args){
        
         //Loading all the Db into arraylists 
           //Then dealing only with the arrays
           
           //customers
           PersonModel personModel = new PersonModel();
           personModel.getPerson();
       // new MainScreen();
       new HomeView();
    }
    
}

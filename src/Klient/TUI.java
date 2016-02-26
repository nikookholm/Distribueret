/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Klient;

import java.util.Scanner;

/**
 *
 * @author amal
 */
public class TUI {
    
   private Scanner   scn = new Scanner(System.in);;
    
    public String[] login(){
        
        // result[0]  retunerer navn
        // result[1] returnerer password;
        
      
        System.out.println("indtest dit studienummer: ");
        String name = scn.nextLine();
        System.out.println("indtest dit password: ");
        String password = scn.nextLine();
        
        String[] result = new String[2];
        result[0] = name;
        result[1] = password;
        
                return result;
                
    }
    
    public void print(String text){
       
        System.out.println( text );
    }
    
    public String gætBokstav(){
        
        print("indtest en bokstave du vil gæt: " );
 
        return  scn.nextLine();
    }
    public boolean confirmRestart(){
        
        print("tryk \"Y\" for restart");
        
        if (scn.nextLine().toLowerCase().equals("y") ){
            
            return true;
        }
            
        return false;
        
    }
    
}

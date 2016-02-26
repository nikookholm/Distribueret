package Klient;

import Server.iServerFunctions;
import brugerautorisation.data.Bruger;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Klient {
    
   private iServerFunctions isf;
   private TUI tui;
   private Bruger bruger;
    
    public Klient(){
         initialize();
         login();
         gameloop();
         showResult();
         restart();
         
        
    }
    
    public static void main(String[] args){
        
        new Klient();
        
    }
    
    private void initialize(){
        
        try {
            isf = (iServerFunctions) Naming.lookup("rmi://localhost/galgeleg");
        } catch (Exception ex) { }
        
        tui = new TUI();
        
    }

    private void login() {
        
         String[] result = tui.login();
         
       try {
           bruger =  isf.login(result[0], result[1]);
           tui.print("du er login som: " + bruger.fornavn + " " + bruger.efternavn);
       } catch (RemoteException ex) {
           
           tui.print(ex.getMessage());
          
       }

    }
    
    
       private void gameloop() {
           
           if(bruger != null){
               
              
           
               try {
                    isf.nulstil();
                    
                   while(!isf.erSpilletSlut()){
                      
                       String gætBokstav = tui.gætBokstav();
                       
                       isf.gætBogstav(gætBokstav);

                   }
      
               } catch (RemoteException ex) {
                   Logger.getLogger(Klient.class.getName()).log(Level.SEVERE, null, ex);
               }
           } else{
               tui.print("man skal være login!");
           }
           
        
          
        }

    private void showResult() {
        
       try {
           if (isf.erSpilletVundet()){
               
               tui.print("Dit result: DU HAR VUNDET MED " + isf.getBrugteBogstaver().size() + " gæt!");
           }
           
           if (isf.erSpilletTabt()){
               
               tui.print("Dit result: DU HAR TABT MED " + isf.getBrugteBogstaver().size() + " gæt!");
               
           }
           // du har vuindet/tabt + resultat
           
        
       } catch (RemoteException ex) {
           Logger.getLogger(Klient.class.getName()).log(Level.SEVERE, null, ex);
       }
       
     
       
    
        
    }
    
    public void restart() {
        
       try {
           if(isf.erSpilletSlut()){
               
               if (tui.confirmRestart()){
                   
                   gameloop();
                   
               }
               
           }
       } catch (RemoteException ex) {
           Logger.getLogger(Klient.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
    }

 
    
    
   
}

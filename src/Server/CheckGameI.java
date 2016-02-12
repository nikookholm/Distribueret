/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebService;
@WebService

/**
 *
 * @author amal
 */
public interface CheckGameI {
    @WebMethod void CheckTextBodyV2(String Bodytext);
    @WebMethod ArrayList<String> CheckTextBodyV2() ;
    
}

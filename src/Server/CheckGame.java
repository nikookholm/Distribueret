/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import com.cdyne.ws.DocumentSummary;

/**
 *
 * @author amal
 */
public class CheckGame {
    
    public static void main(String[] agrs,java.lang.String bodyText ){
        
        checkTextBodyV2(bodyText);
                
    }

    private static DocumentSummary checkTextBodyV2(java.lang.String bodyText) {
        com.cdyne.ws.Check service = new com.cdyne.ws.Check();
        com.cdyne.ws.CheckSoap port = service.getCheckSoap12();
        return port.checkTextBodyV2(bodyText);
    }
    
}

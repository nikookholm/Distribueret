/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import brugerautorisation.Diverse;
import brugerautorisation.data.Bruger;
import brugerautorisation.transport.soap.Brugeradmin;
import com.cdyne.ws.DocumentSummary;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author amal
 */
public class CheckGame {
    
    public static void main(String[] agrs,java.lang.String bodyText ) throws MalformedURLException{
        
                checkTextBodyV2(bodyText);
                
                URL url = new URL("http://wsf.cdyne.com/SpellChecker/check.asmx?wsdl");
		QName qname = new QName("http://soap.transport.brugerautorisation/", "BrugeradminImplService");
		Service service = Service.create(url, qname);
		CheckGameI test = service.getPort(CheckGameI.class);

//		Bruger b = test.CheckTextBodyV2("bodyText");

                
    }

    private static DocumentSummary checkTextBodyV2(java.lang.String bodyText) {
        com.cdyne.ws.Check service = new com.cdyne.ws.Check();
        com.cdyne.ws.CheckSoap port = service.getCheckSoap12();
        return port.checkTextBodyV2(bodyText);
    }
    
}

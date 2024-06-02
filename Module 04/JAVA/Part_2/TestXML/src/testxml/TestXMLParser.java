
package testxml;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;


public class TestXMLParser {
    
    public void xmlParser(){
        SAXParserFactory saxpf = SAXParserFactory.newInstance();
        
        saxpf.setNamespaceAware(true);
        saxpf.setValidating(true);
        
        System.out.println("Parser will" + (saxpf.isNamespaceAware()? "":"not") + 
                "be namespace aware");
        System.out.println("Parser will" + (saxpf.isValidating()?"" : "Not")+ "Validate XML");
        SAXParser parserval = null;
        
        try {
            parserval = saxpf.newSAXParser();
        } catch (ParserConfigurationException | SAXException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Parser object is:"+ saxpf);
    }
    }
    

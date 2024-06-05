package xml;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class XMLWriter {

    public static void main(String[] args) {

        try {
            //Conversion to XML as like a parent
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder(); 
            Document doc = db.newDocument();
            
            Element topcompany = doc.createElement("topcompany");
            doc.appendChild(topcompany);
            
            //First Data=================
            //Children===========
            Element topcompany1 = doc.createElement("companyinfo");
            topcompany.appendChild(topcompany1);
            
            //Child=================
            Element com_id_1 = doc.createElement("id");
            com_id_1.appendChild(doc.createTextNode("1"));
            topcompany1.appendChild(com_id_1);
            
            Element com_name_1 = doc.createElement("name");
            com_name_1.appendChild(doc.createTextNode("Amazon"));
            topcompany1.appendChild(com_name_1);
            
            Element com_position_1 = doc.createElement("position");
            com_position_1.appendChild(doc.createTextNode("#1"));
            topcompany1.appendChild(com_position_1);
             //================First Data
             
             
            //Seceond Data=================
            
            //Children===========
            Element topcompany2 = doc.createElement("companyinfo");
            topcompany.appendChild(topcompany2);
            
            //Child===========
            Element comid2 = doc.createElement("id");
            comid2.appendChild(doc.createTextNode("2"));
            topcompany2.appendChild(comid2);
            
            Element comname2 = doc.createElement("name");
            comname2.appendChild(doc.createTextNode("Google"));
            topcompany2.appendChild(comname2);
            
            Element composition2 = doc.createElement("position");
            composition2.appendChild(doc.createTextNode("#2"));
            topcompany2.appendChild(composition2);
             //================Seceond Data
            
             
             //Third Data=================
            
            //Children===========
            Element topcompany3 = doc.createElement("companyinfo");
            topcompany.appendChild(topcompany3);
            
            //Child===========
            Element comid3 = doc.createElement("id");
            comid3.appendChild(doc.createTextNode("2"));
            topcompany3.appendChild(comid3);
            
            Element comname3 = doc.createElement("name");
            comname3.appendChild(doc.createTextNode("Microsoft"));
            topcompany3.appendChild(comname3);
            
            Element composition3 = doc.createElement("position");
            composition3.appendChild(doc.createTextNode("#3"));
            topcompany3.appendChild(composition3);
             //================Third Data
             
             
             
             TransformerFactory tff = TransformerFactory.newInstance();
             Transformer tnf = tff.newTransformer();
             DOMSource ds = new DOMSource(doc);
             
             StreamResult sr= new StreamResult(new File("topcominfo.xml"));
             tnf.transform(ds, sr);
             
             
             System.out.println("Top Company info XML file is created succesfully!");
            
            //Write later or declare later
            
            
        } catch (ParserConfigurationException | TransformerException e) {
            
            e.printStackTrace();

        }

    }

  

}

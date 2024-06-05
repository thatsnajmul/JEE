
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLReader {
   
    public static void main(String[] args) {
        
        try {
            DocumentBuilderFactory studentdata = DocumentBuilderFactory.newInstance();
            DocumentBuilder studentDatabuilder = studentdata.newDocumentBuilder();
            Document studentdoc = studentDatabuilder.parse("stu.xml");

            studentdoc.getDocumentElement().normalize();

            Element studentRoot = studentdoc.getDocumentElement();
            System.out.println("Root Element: " + studentRoot.getNodeName());

            NodeList studentList = studentdoc.getElementsByTagName("studentinfo");

            for (int i = 1; i < studentList.getLength(); i++) {
                Node studentnode = studentList.item(i);

                if (studentnode.getNodeType() == Node.ELEMENT_NODE) {

                    Element studentElement = (Element) studentnode;
                    
                    
                    String id = studentElement.getElementsByTagName("studentid").item(0).getTextContent();
                    String name = studentElement.getElementsByTagName("studentname").item(0).getTextContent();
                    String class_s = studentElement.getElementsByTagName("studentclass").item(0).getTextContent();
                    String roll = studentElement.getElementsByTagName("studentroll").item(0).getTextContent();

                    System.out.println("Student ID: " + id);
                    System.out.println("Student Name: " + name);
                    System.out.println("Student Position: " + class_s);
                    System.out.println("Student Roll: " + roll);

                }

            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

}

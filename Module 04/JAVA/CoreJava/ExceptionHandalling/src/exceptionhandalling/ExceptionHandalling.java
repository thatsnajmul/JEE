
package exceptionhandalling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExceptionHandalling {



    public static void main(String[] args) throws FileNotFoundException {
       
        File file = new File("C:\\Users\\Admin\\Desktop\\");
        
        PrintWriter write= new PrintWriter(file);
        write.print("Hello Java");
        write.append("Hello java again");
        write.close();
        
        Scanner s = new Scanner(file);
        
        
        
        
        
        
    }
    
}

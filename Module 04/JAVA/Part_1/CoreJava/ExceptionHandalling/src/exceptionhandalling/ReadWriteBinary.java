
package exceptionhandalling;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class ReadWriteBinary {
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Admin\\Desktop\\hhh.dat");
        
        for(int i =1; i<=10; i++){
            fos.write(i);
        }
        
        fos.close();
    }
            
}

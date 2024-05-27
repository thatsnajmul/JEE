
package three;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Studennt {
    


    public void student() {
        File file = new File("example.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write("This is an example line.");
            bw.newLine();
            bw.write("This is another line.");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }


 
}

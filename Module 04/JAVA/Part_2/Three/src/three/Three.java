
package three;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Three {
    
    
    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) throws IOException {
        
        Student[] students ={
        
            new Student("Name1",20),
            new Student("Name2",24),
            new Student("Name3",26),
            new Student("Name4",57)
            
        };
        
        writeStudentsToFile(students);
        System.out.println("Reading student data from " + FILE_NAME);
        readStudentsFromFile();
        
    }
    
    private static void writeStudentsToFile(Student[] students) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            for (Student student : students) {
                oos.writeObject(student);
            }
        System.out.println("Student data written to " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void readStudentsFromFile() {
        try (ObjectInputStream obinst = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            while (true) {
                try {
                    Student student = (Student) obinst.readObject();
                    System.out.println(student);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
    
    
    
    
    
    
    
}

package question1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Question1 {

    public static void main(String[] args) {
        try {
            File file = new File("F:\\JEE-CCSL-59\\JEE\\Module 04\\JAVA\\Exm\\Question1\\file.txt");

            PrintWriter output = new PrintWriter("F:\\JEE-CCSL-59\\JEE\\Module 04\\JAVA\\Exm\\Question1\\file.txt");

            output.append("Write something");

            output.close();

            Scanner s = new Scanner(file);

            System.out.println(s.nextLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

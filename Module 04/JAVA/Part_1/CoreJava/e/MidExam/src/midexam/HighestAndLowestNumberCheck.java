package midexam;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class HighestAndLowestNumberCheck {  
    public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       
        System.out.println("Enter your number 1:");
        int a = s.nextInt();
        System.out.println("Enter your number 2:");
        int b = s.nextInt();
        System.out.println("Enter your number 3:");
        int c = s.nextInt();
        System.out.println("Enter your number 4:");
        int d = s.nextInt();
        System.out.println("Enter your number 5:");
        int e = s.nextInt();
       
        ArrayList<Integer> x = new ArrayList<>();
        x.add(a);
        x.add(b);
        x.add(c);
        x.add(d);
        x.add(e);
        
        System.out.println(Collections.max(x)+ " "
                + "is the largest number.");
    }
    
}

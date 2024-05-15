package midexam;
import java.util.Scanner;
public class CreateSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int sum = 0;
        int num;       
        
        do {
            System.out.print("Enter a number: ");
            num = scanner.nextInt();
            if (num >= 0) {
                sum += num;
            }
        } while (num >= 0);
        
        System.out.println("Sum of positive numbers: " + sum);
        
    
    }
           
}

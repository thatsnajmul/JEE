package midexam;
import java.util.Scanner;
public class CheckPrimeNumer {   
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter your number: ");
        int number = input.nextInt();        
        
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count+=1;
            }
        }
        if(count==2){
            System.out.println("Number is prime");
        }
        else{
        System.out.println("Number is not prime");
        }
        
        
            
        
        
        
        
    }
}

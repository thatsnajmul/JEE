
package exprac;

import java.util.Scanner;


public class CheckPrimeNumber {
    
   
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter a number: ");
        int number = input.nextInt();
        
        if(number%2==0){
            System.out.println("This Number is prime " + number);
        }
        else{
            System.out.println("This Number is not prime " + number);
        }
    }
    
    
}

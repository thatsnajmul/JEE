
package exprac;

import java.util.Scanner;


public class FindMaxMin {
    
    public static void main(String[] args) {
        Scanner input = new  Scanner(System.in);
        
        System.out.println("Enter your first number 1: ");
        int num1 = input.nextInt();
        System.out.println("Enter your first number 2: ");
        int num2 = input.nextInt();
        System.out.println("Enter your first number 3: ");
        int num3 = input.nextInt();
        
        if(num1>num2 && num1>num3){
            System.out.println("Your max number is"+num1);
        }
        else if(num2>num3){
            System.out.println("Your max number is"+num2);
        }
        else if(num3>num1){
            System.out.println("Your max number is"+num3);
        }
        else{
        
        }
        
    }
    
}

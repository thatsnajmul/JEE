
package exprac;

import java.util.Scanner;


public class FindFactorial {
    
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter your factorial number: ");
        int fac = input.nextInt();
        
        
        for(int i = 1; i>fac; i--){
            fac *=i;
        }
        System.out.println("Factorial number is: "+ fac);
    }
}


package calc;

import java.util.Scanner;


public class Calc {

    public Calc() {
    }
    
    public static void main(String[] args) {
        char oprator; //
        double num1, num2, num3; //
        
         Scanner s = new Scanner(System.in);
         
         System.out.println("Choose an opearator +, -, *, /");
         
         oprator=s.next().charAt(0);
         
         System.out.println("Enter your first number");
         num1 = s.nextDouble();
         System.out.println("Enter your secoend number");
         num2 = s.nextDouble();
         
        
         
         switch (oprator) {
             
            case '+':
                
                System.out.println(num1+"+"+num2+"=");
                break;
            case '-':
                
                break;
            case '*':
                
                break;
            case '/':
                
                break;
                
            default:
                System.out.println("Invalid Operator");
                break;
                
        }
    }
}

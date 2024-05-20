package twonumberdivide;

import java.util.Scanner;

public class TwoNumberDivide {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        
        
        System.out.println("Enter number 1: ");
        int num1 = s.nextInt();
        System.out.println("Enter number 2: ");
        int num2 = s.nextInt();

        try {
            System.out.println(num1 / num2);
        } catch (ArithmeticException e) { //For array we can use ArrayIndexOutOfBoundsException
            if (num1 == 0 || num2 == 0) {
                System.out.println("Cannot possible");
            }
        }
    }

}

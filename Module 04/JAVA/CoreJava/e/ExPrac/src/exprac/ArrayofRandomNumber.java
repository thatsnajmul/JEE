package exprac;

import java.util.Scanner;

public class ArrayofRandomNumber {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //userInput 10 times
        int[] tenNumbers = new int[10];
        int userInput = 0;
        for (int i = 0; i < tenNumbers.length; i++) {
            System.out.println("Enter your number: ");
            userInput = input.nextInt();
            tenNumbers[i] = userInput;
            System.out.println(i);
        }
//        // Printing 10 times
//        for (int i = 0; i < tenNumbers.length; i++) {
//            System.out.println(tenNumbers[i] + "\n");
//        }
//        for (int n : tenNumbers) {
//           
//            System.out.println(n);
//        }
        
        

    }

}

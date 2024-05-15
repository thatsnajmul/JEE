/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package primenumber;

import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {

//        Scanner input = new Scanner(System.in);
//
//        System.out.println("Enter your number: ");
//        int number = input.nextInt();
//        int count = 0;
//
//        for (int i = 1; i <= number; i++) {
//            if (number % i == 0) {
//                count++;
//            }
//
//        }
//        if (count == 2) {
//            System.out.println("This number is prime");
//        } else {
//            System.out.println("Not Prime");
//        }




//        System.out.println("Enter your number 1");
//        int number1 = input.nextInt();
//        System.out.println("Enter your number 2");
//        int number2 = input.nextInt();
//        System.out.println("Enter your number 3");
//        int number3 = input.nextInt();
//        System.out.println("Enter your number 4");
//        int number4 = input.nextInt();
//        
//        if(number1>number2){
//            System.out.println("Prime " + number1 + " "+ number2+ " " + number3+ "" + " " + number4 );
//        }
//        else if(number1>number3){
//            System.out.println("Prime " + number1 + " "+ number2+ " " + number3+ "" + " " + number4);
//        }
//        else if(number1>number4){
//            System.out.println("Prime " + number1 + " "+ number2+ " " + number3+ "" + " " + number4);
//        }
//        else if(number2>number1){
//        System.out.println("Prime " + number1 + " "+ number2+ " " + number3+ "" + " " + number4);
//        }
//        else if(number2>number3){
//        System.out.println("Prime " + number1 + " "+ number2+ " " + number3+ "" + " " + number4);
//        }
//        else if(number2>number4){
//            System.out.println("Prime " + number1 + " "+ number2+ " " + number3+ "" + " " + number4);
//        }
//        
//        else{
//            System.out.println("Not Prime");
//        }
        

    Scanner s = new Scanner(System.in);
        //System.out.println("Enter number to check Prime or not prime");

       // int userInput = s.nextInt();
        int count = 0;
        
        for (int j = 1; j <= 100; j++) {
            
            for (int i = 1; i <= j; i++) {
                
                if (j % i == 0) {
                    count++;// count=1 count=2
                    
                }
            }

            if (count == 2) {
                System.out.println(j);
//                break;
            } 
                
            count=0;
        }
        
    
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testloops59;

import java.util.Scanner;

public class TestLoops59 {

    public static void main(String[] args) {

//---------------------------------------        
//        int n=2;
//        while(n<=100){
//            System.out.println(n+" Hello Java");
//            n++;
//        }

        Scanner input = new Scanner(System.in);

        System.out.println("Enter your start number");
        int startNumber = input.nextInt();
        System.out.println("Enter your end number");
        int endNumber = input.nextInt();

        while (startNumber <= endNumber) {

            if (startNumber % 3 == 0 && startNumber % 5 == 0) {

           } else {
                System.out.println(startNumber + "Hello Java");

           }

           startNumber++; //startPoint=startpoit+1; startpoint+=1; 

      }















//        int randNum = (int)(Math.random()*101);
//        
//        System.out.println("Guess a magic number between 0 and 100");
//        
//        int guessNum = -1;
//        
//        
//        while(guessNum != randNum){
//            System.out.println("\nEnter your guess");
//            guessNum = input.nextInt();
//            
//            if(guessNum == randNum){
//                System.out.println("Yes, the number is"+randNum);
//        }
//        else if(guessNum > randNum){
//                System.out.println("High");
//                
//        }
//            else{
//                System.out.println("Low");
//            }

            

    }

}

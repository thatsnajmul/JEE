/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guessnumberusingdowhile;

import java.util.Scanner;


public class GuessNumberUsingdoWhile {
    
   

    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
        int randNum = (int) (Math.random() * 101);

        int maxAttempts = 3;
        int attemptsCount = 0;
        
        do {            
            System.out.println("Please enter your guess number");
            int guessNumbers = input.nextInt();

            if (guessNumbers == randNum) {
                System.out.println("congratulations!");
                break;
            } else if (guessNumbers < randNum) {
                System.out.println("Your gues number is lower");
            } else if (guessNumbers > randNum) {
                System.out.println("Your guess number is Higher");
            }

            attemptsCount++;
        } while (attemptsCount < maxAttempts);
        if (attemptsCount == maxAttempts) {
            System.out.println("Sorry you loss the game and the guess number is" + randNum);
        }
            
    }
    
}

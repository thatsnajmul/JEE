package testloops;

import java.util.Scanner;

public class DoWhileLoop {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int randomNumber = (int) (Math.random() * 101);

       // int maxAttempts = 3;
        int maxAttempts =1;
        int attemptsCount = 0;

        do {
            System.out.println("Please enter your guess number:");
            int guessNumber = s.nextInt();
            
            if(guessNumber==randomNumber){
                System.out.println("Congratulations!");
            }
            else if(guessNumber < randomNumber){
                System.out.println("Your guess number is lower");
            }
            else if(guessNumber > randomNumber){
                System.out.println("Your guess number is heigher");
            }
            
            attemptsCount++;

        } while (attemptsCount<maxAttempts);       

            if (attemptsCount<maxAttempts) {
                System.out.println("Sorry, you lost the game. The guess number was " + randomNumber);
            }   
    }

}

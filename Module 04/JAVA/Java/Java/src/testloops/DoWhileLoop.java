package testloops;

import java.util.Scanner;

public class DoWhileLoop {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int randomNumber = (int) (Math.random() * 101);

        int maxAttempts = 3;
        int attemptsCount = 0;

        do {

        } while (attemptsCount<maxAttempts);       

            if (attemptsCount<maxAttempts) {
                System.out.println("Sorry, you lost the game. The guess number was " + randomNumber);
            }   
    }

}

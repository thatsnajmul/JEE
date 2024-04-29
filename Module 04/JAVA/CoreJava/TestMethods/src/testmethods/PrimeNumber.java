/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testmethods;

import java.util.Scanner;

public class PrimeNumber {
     public static void main(String[] args) {
        Scanner i = new Scanner(System.in);
        
        System.out.println("Enter your number:");
        int userNumber = i.nextInt();
      
        
        if(userNumber%2==0){
            System.out.println("Prime number is: "+userNumber);
        }
        else if(userNumber%3==0 && userNumber%5==0){
          System.out.println("Odd number is: "+userNumber);
        }
        else{
            System.out.println("Not a prime number");
        }
         
    }
    

    }

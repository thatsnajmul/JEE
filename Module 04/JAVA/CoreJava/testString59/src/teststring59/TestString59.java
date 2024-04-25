/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package teststring59;

import java.util.Scanner;

public class TestString59 {

    public static void main(String[] args) {
        
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter your email address");
        String userEmail = input.next();
        System.out.println("Enter your password");
        String password= input.next();
        String message = String.format("Welcome %ss to google", userEmail);
        
        if(userEmail.equalsIgnoreCase("java")){
//            System.out.println("Welcome to java");
              
              //intentionally blank
              //M(2016-2017)Nastrc equals.time("mi");
              if(password.equals("Java123")){
                  System.out.println(message);
              }
              else{
                  System.out.println("Incorrect password"); 
              }
        
        }
        else{
            System.out.println("Couldn't find your google account");
        }
        

    }
    
}

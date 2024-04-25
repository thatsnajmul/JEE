/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package teststring59;

import java.util.Scanner;

public class TestString59 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        //----------------------------------------------------------
//        System.out.println("Please enter your email address");
//        String userEmail = input.next();
//        String message = String.format("Welcome %ss to google", userEmail);
//        
//        if(userEmail.equalsIgnoreCase("java")){
////            System.out.println("Welcome to java");
//              System.out.println("Enter your password");
//              String password= input.next();
//              //intentionally blank
//              //M(2016-2017)Nastrc equals.time("mi");
//              if(password.equals("Java123")){
//                  System.out.println(message);
//              }
//              else{
//                  System.out.println("Incorrect password"); 
//              }
//        
//        }
//        else{
//            System.out.println("Couldn't find your google account");
//        }

//------------------------------------------------------------------------------
        System.out.println("Enter Your username:");
        String userName = input.next();
        System.out.println("Enter Your password:");
        String password = input.next();
        String message = String.format("Welcome %ss to google", userName);
        if (userName.equalsIgnoreCase("") && password.contentEquals("Java123")) {
            System.out.println(message);
//            if(userName.length()>=3){
//                System.out.println("3 or more...");
//            }
//            else{
//                System.out.println("3 or more...");
//            }
        } else {
            System.out.println("Invalid");
        }

//------------------------------------------------------------
//        System.out.println("Enter your username");
//        String userName= input.nextLine();
//        System.out.println(userName);


//--------------------------------------------------------------

// Ascii to find 
//           System.out.println("Enter your latter");
////         char userInput = (char)65;
//           String word = input.;
//         
//           
//           
//           if(userInput.){
//               System.out.println("Isn't Vaouel");  
//           }
//           else{
//             System.out.println("Isn't Vaouel");   
//           }
           
    }

}

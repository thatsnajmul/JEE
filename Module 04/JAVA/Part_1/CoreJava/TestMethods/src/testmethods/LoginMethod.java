/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testmethods;

import java.util.Scanner;


public class LoginMethod {
    public static void main(String[] args) {
        Scanner i = new Scanner(System.in);
        
        System.out.println("Enter your Name:");
        String userName = i.nextLine();
        System.out.println("Enter your Password:");
        String pass = i.nextLine();
        
        boolean result = doLogin(userName, pass);
        
        if(result){
            System.out.println("Welcome"+userName);
        }
        else{
            System.out.println("User Name Incorrect");
        }
         
         doLogin(userName,pass);
    }
    
    public static boolean doLogin(String userName, String pass){
        
        if(userName.equalsIgnoreCase("Java") && pass.equals("Java1234")){
            return true;
        }
        else{
            return false;
        }
        
        
}
}



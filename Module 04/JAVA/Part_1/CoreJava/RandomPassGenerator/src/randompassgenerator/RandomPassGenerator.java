/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package randompassgenerator;

import java.util.Random;
import java.util.Scanner;


public class RandomPassGenerator {

  
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        
        System.out.println("Enter password length");
        int passLength=s.nextInt();
        
        
        String pass ="";
        String finalPass="";
        
        System.out.println("Your password is"+pass);
        
        
    }
    
    public static String passGenerator(int passLength){
        Random random = new Random();
        
        for(int i=1; i <=8; i++){
            int range = random.nextInt(3)+1;
            switch (range) {
            case 1:
                pass +=(char)(random.nextInt(26)+65);
                break;
            case 2:
                pass +=(char)(random.nextInt(26)+97);
                break;
            case 3:
                pass +=(char)(random.nextInt(26)+48);
                break;
        }
        }
        
        for(int i =1; i<8; i++){
            //pass.length()/2
            if(i==4){
                finalPass +="_"+pass.charAt(i);
            }
            else{
                finalPass +=pass.charAt(i); //pass=ABCD__1234
            }
        }        
//        System.out.println(finalPass);
        
        return finalPass;
    }
    
    
    
    
}

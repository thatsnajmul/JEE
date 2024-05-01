/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package checkvowel;

import java.util.Scanner;

/**
 *
 * @author thatsnajmul
 */
public class CheckVowel {

   
    public static void main(String[] args) {
       
        
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter word");
//        String anyword = input.nextLine().toUpperCase();
          String anyword = input.nextLine().toUpperCase();
        
        if(anyword.startsWith("A") || anyword.startsWith("E") || anyword.startsWith("I")|| anyword.startsWith("O") || anyword.startsWith("U")){
            System.out.println("This is vowel");
            if(anyword=="D,F,G,K"){
                System.out.println("Const");
        }
        else{
            System.out.println("Invalid");
        }
        }
        
    }
    
}

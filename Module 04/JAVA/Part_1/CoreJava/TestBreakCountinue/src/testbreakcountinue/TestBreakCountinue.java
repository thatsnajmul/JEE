/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testbreakcountinue;

import java.util.Scanner;


public class TestBreakCountinue {
    
    public static void main(String[] args) {
       
        Scanner input  =new Scanner(System.in);
        
        int num=0;
        
        while(true){
            System.out.println("user input");
            int userinput=input.nextInt();
            num+=userinput;
//            break;
            
            if(num>=100){
                
            }
            else if(num>=200){
//                continue;
            }
            System.out.println("User value is:"+num);
            
            
        }
        
        
        
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package factorial;


public class Factorial {

    
    public static void main(String[] args) {
        
        int facValue=4;
        int factorial =1;
        
        for(int i =1; i<=facValue; i++){
            factorial *=i; //factorial=factorial*i
        }
        for(int i =1; i>=1; i--){
            factorial *=i; //factorial=factorial*i
        }
        System.out.println("Factorial is: "+factorial);
    }
    
}

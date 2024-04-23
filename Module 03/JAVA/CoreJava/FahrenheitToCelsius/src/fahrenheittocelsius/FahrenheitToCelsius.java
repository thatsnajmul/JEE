/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fahrenheittocelsius;

import java.util.Scanner;

public class FahrenheitToCelsius {
    public static void main(String[] args) {
        
        Scanner input=new Scanner(System.in);
        
        System.out.println("Please enter your temperature in celcious:");
        float fertemp=input.nextFloat();
        
        float result=((fertemp-32)/9)*5;
        
        System.out.println("Temperature in celsius:"+result);
        
        
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fahrenheittocelsius;

import java.util.Scanner;

public class FahrenheitToCelsius {
    public static void main(String[] args) {
        
        Scanner input=new Scanner(System.in);
//----------------------------F to C--------------------------------
//        System.out.println("Please enter your temperature in Farheneit:");
//        float fertemp=input.nextFloat();
//        float result=((fertemp-32)/9)*5;
//        
//        System.out.println("Temperature in celsius:"+result);

//-------------------------C to F--------------------------------
System.out.println("Please enter your temperature in celsius:");
        float fertemp=input.nextFloat();
//        (32°C × 9/5) + 32 = 89.6°F
          float result = ((fertemp*9)/5)+32;
        
        System.out.println("Temperature in Farheneit:"+result+"°F");
        
    }
    
}

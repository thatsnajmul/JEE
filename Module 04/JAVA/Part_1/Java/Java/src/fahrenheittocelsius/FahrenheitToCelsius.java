
package fahrenheittocelsius;

import java.util.Scanner;


public class FahrenheitToCelsius {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        //Converting temperature fahrenheit to celsius
        System.out.println("Please enter temperature in fahrenheit: ");
        float fertemp = input.nextFloat();
        
        float result = ((fertemp-32)/9)*5;
        
        System.out.println("Temperature in Celsius: "+result);
        
        
        //For current system time but not convert it
        System.out.println(System.currentTimeMillis());
        
    }
}

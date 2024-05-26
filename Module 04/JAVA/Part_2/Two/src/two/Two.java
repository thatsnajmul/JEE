
package two;

import java.util.Arrays;


public class Two {


    public static void main(String[] args) {
        

        Vehicle car = new Car("2025441", "BMW", 2002);
        Vehicle motorcycle = new Motorcycle("522211", "Honda", 2005);
        
        
        System.out.println(car.regNumber()+" "+car.brand()+" "+car.year());
        System.out.println(motorcycle.regNumber()+" "+motorcycle.brand()+" "+motorcycle.year());
        //System.out.println(motorcycle);
        
        car.start();
        car.stop();
        motorcycle.start();
        motorcycle.stop();
        
        
    }
    
}

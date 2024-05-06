
package testobjectthinking;

import math.Factorial;


public class TestObjectThinking {


    public static void main(String[] args) {
        
        
        Factorial fa = new Factorial(5);
        
        System.out.println(fa.getFactorial());
        
        if (fa instanceof Object) {
            Object object = (Object) fa;
            
        }
        
       
    }
    
}


package testclassandobject;


//import another class
import geomatry.Circle;
import primenumber.PrimeNum;


public class TestClassAndObject {


    public static void main(String[] args) {
       Circle circle = new Circle();
       PrimeNum primenum = new PrimeNum();
       
       //circle.setRadious(3);
       
       //Value change by another class variable
       //primenum.getPrimeNum(3);
       
       
       //Call another method from another class and another package name
        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());
        System.out.println(primenum.getPrimeNum());
    }
    
}

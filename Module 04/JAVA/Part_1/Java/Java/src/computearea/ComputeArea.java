
package computearea;

import java.util.Scanner;


public class ComputeArea {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //For Radius value
        /*
        System.out.println("Please enter the value of radius:");
        double radius = input.nextDouble();
        double area;
        area = radius* radius * 3.1416;
        System.out.println(area);
        */
        
        //For Area of height and width
        ///*
        System.out.println("Enter length:");
        double length = input.nextDouble();
        System.out.println("Enter Width:");
        double width= input.nextDouble();
        
        double area = length*width;
        
        System.out.println("Area of Rectangle is "+area);
        //*/
        
        //Long Number
        /*
        long number = 10L;
        System.out.println("Long Number is: "+number);
        */
     
    }
}

  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testmethods;


public class TestMethods {


    public static void main(String[] args) {
        System.out.println(doSum(10.0,20.0));
        System.out.println(doSum(50,100));
        System.out.println(doSum(50,100));
        System.out.println(doSum(10.0,30));
        
    }
    
    public static int doSum(double num1, double num2){
        int result = (int) (num1+num2);
        return result;
    }
    
}

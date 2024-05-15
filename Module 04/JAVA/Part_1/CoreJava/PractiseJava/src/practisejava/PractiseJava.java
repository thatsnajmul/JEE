/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practisejava;

/**
 *
 * @author thatsnajmul
 */
public class PractiseJava {

    public static void main(String[] args) {

            int a = 20;
            System.out.println(PractiseJava.RequiredString(a));  
    }
    
    static String RequiredString(int a) {
                
       String AlphaNumericStrings = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+ 
               "0123456789"+ "abcdefghijklmnopqrstuvxyz";

            StringBuilder s = new StringBuilder(a);
            int y;
            for (y = 0; y < a; y++) {

                int index = (int) (AlphaNumericStrings.length()* Math.random());
                s.append(AlphaNumericStrings.charAt(index));
            }
            return s.toString();
        }

}




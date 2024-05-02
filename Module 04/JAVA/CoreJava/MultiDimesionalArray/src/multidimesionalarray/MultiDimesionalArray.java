/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package multidimesionalarray;

import java.util.Arrays;
import java.util.Random;


public class MultiDimesionalArray {

 
    public static void main(String[] args) {
        
        
        int[][] numbers= new int[3][4];
        
        Random random= new Random();
        
        for(int row=0; row<numbers.length; row++){
        for(int col =0; col<numbers[0].length; col++){
            int randomNumber = random.nextInt(20);
            numbers[row][col]=randomNumber;
        }
        }
        System.out.println(Arrays.deepToString(numbers));
    }
    
}

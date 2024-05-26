
package one;

import java.util.Random;
import java.util.Scanner;


public class One {

   
    public static void main(String[] args) {
        int[] randomnum = new int[100];
        
        Random rand = new Random();
        
        for (int i = 0; i < randomnum.length; i++) {
            randomnum[i] = rand.nextInt(100);
        }
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter your number: ");
        
        try {
            int in = s.nextInt();
            System.out.println("Index number "+in +":"+ randomnum[in]);
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Out of bounds");
        }
        catch(Exception e){
            
            System.out.println("Invalid");
        
        }
        
        
    }
    
}

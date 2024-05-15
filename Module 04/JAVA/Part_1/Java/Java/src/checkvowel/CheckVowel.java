
package checkvowel;

import java.util.Scanner;


public class CheckVowel {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please Enter any word or name: ");
        //String word1 = input.nextLine().toLowerCase();
        String word = input.nextLine().toUpperCase();
        
        if(word.startsWith("A") || word.startsWith("E") || word.startsWith("I") || word.startsWith("O") || word.startsWith("U")){
            System.out.println("This word start with vowel");
        }
        else{
            System.out.println("This word start with consonent");
        }
        
    }
       
}

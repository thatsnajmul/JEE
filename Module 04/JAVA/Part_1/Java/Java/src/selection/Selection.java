
package selection;

import java.util.Scanner;


public class Selection {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        //Find max number
        int Maxnumber;
        
        System.out.println("Enter your first number: ");
        int firstNumber= scanner.nextInt();
        
        System.out.println("Enter your second number");
        int secoendNumber = scanner.nextInt();
        
        System.out.println("Enter your third number");
        int thirtNumber = scanner.nextInt();
        
        if(firstNumber>secoendNumber && firstNumber>thirtNumber){
            Maxnumber = firstNumber;
        }
        else if(secoendNumber>firstNumber && secoendNumber>thirtNumber){
            Maxnumber = secoendNumber;
        }
        else{
            Maxnumber = thirtNumber;
        }
        
        System.out.println("Maximum number is "+ Maxnumber);
        
        
        //Rand Num
        int randNumber =(int)(Math.random()*100);
        
        System.out.println(randNumber);
    }
}

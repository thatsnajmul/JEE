/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package selection59;

import java.util.Scanner;

public class Selection59 {

    public static void main(String[] args) {
        //--------------------------Find max number--------------------------------
//        Scanner scanner = new Scanner(System.in);
//        int maxNumber;
//        
//        System.out.println("Enter your first number");
//        int firstNumber =scanner.nextInt();
//        
//        
//         System.out.println("Enter your secoend number");
//        int secoendNumber =scanner.nextInt();
//        
//        
//         System.out.println("Enter your third number");
//        int thirdNumber =scanner.nextInt();
//        
//        if(firstNumber > secoendNumber && firstNumber> thirdNumber ){
//            maxNumber=firstNumber;
//        }
//        else if(secoendNumber > firstNumber && secoendNumber> thirdNumber){
//            maxNumber=secoendNumber;
//        }
//        else{
//            maxNumber=thirdNumber;
//        }
//        
//        System.out.println(maxNumber);



//-----------------------------------Math random number-------------------------
//        int randNumber = (int) (Math.random()*100);
//        System.out.println(randNumber);
//        Scanner scanner =new Scanner(System.in);
////        char grade;
//        System.out.println("Enter your number");
//        int marks= scanner.nextInt();   
//        if(marks>100 || marks<0){
//            System.out.println("Number is wrong");
//        }
//        else if(marks>=80){
//            System.out.println("A+");
//        }
//        else if(marks>=70){
//            System.out.println("A");
//        }
//        else if(marks>=60){
//            System.out.println("B");
//        }
//        else if(marks>=50){
//            System.out.println("C");
//        }
//        else if(marks>=32){
//            System.out.println("D");
//        }
//        else{
//            System.out.println("F");
//        }
//      System.out.println(marks);   
//-------------------------------------Day number ------------------------------
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter Day number:");
//        int numberOfDay = scanner.nextInt();
//
//        String dayName = "";
//
//        switch (numberOfDay) {
//            case 1:
//                dayName = "Saturday";
//                break;
//
//            case 2:
//                dayName = "Sunday";
//                break;
//            case 3:
//                dayName = "Monday";
//                break;
//            case 4:
//                dayName = "Tuesday";
//                break;
//            case 5:
//                dayName = "Wednesday";
//                break;
//            case 6:
//                dayName = "Thirsday";
//                break;
//            case 7:
//                dayName = "Friday";
//                break;
//
//            default:
//                dayName = "Invaid";
//        }
//        
//        System.out.println(dayName);
//---------------------------------A Simple calculator--------------------------
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your first number");
        float number1 = scanner.nextFloat();
        System.out.println("Enter your secoend number");
        float number2 = scanner.nextFloat();
        System.out.println("Add(+)\n Substraction(-)\npress 2\n Multiplication(X)\n Division(/)");
        int choice = scanner.nextInt();

        float result = 0.0f;

        switch (choice) {
            case 1:
                result = number1 + number2;
                break;
            case 2:
                result = number1 + number2;
                break;
            case 3:
                result = number1 + number2;
                break;
            case 4:
                result = number1 + number2;
                break;
            default:
                System.out.println("Invalid");
        }

        System.out.println("Result is" + result);

//--------------------------------
    }

}

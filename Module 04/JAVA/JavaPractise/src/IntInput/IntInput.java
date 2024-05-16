package IntInput;

import java.util.Scanner;

public class IntInput {

    public int pr(int a) {
        Scanner sc = new Scanner(System.in);

        int n = 3;
        System.out.println("Enter your number: ");
        for (int i = 0; i < n; i++) {
            int gs = sc.nextInt();
            
          System.out.println(gs);
        }   
        
        return a;
    }

}

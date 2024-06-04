
package question3;

public class Question3 {

 
    public static void main(String[] args) {
         int n = 5; 
        for (int i = 0; i < n; i++) {
            Multithread object = new Multithread();
            object.start();
        }
    }
    
}


package question3;


public class Multithread {
    
     public void start()
    {
        try {
            
            System.out.println(
                "Thread " + Thread.currentThread().getId()
                + " is running");
        }
        catch (Exception e) {
            
            System.out.println("Thread not running");
        }
    }
    
}

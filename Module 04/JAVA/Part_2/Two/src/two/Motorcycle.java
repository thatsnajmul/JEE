
package two;


public class Motorcycle extends Vehicle{

    public Motorcycle(String regNumber, String brand, int year) {
        super(regNumber, brand, year);
    }
    
    

    @Override
    public void start() {
        System.out.println("Motorcycle engine start"); 
    }

    @Override
    public void stop() {
       System.out.println("Motorcycle engine stop"); 
    }
    
    
    
}


package two;


public class Car extends Vehicle{

    public Car(String regNumber, String brand, int year) {
        super(regNumber, brand, year);
    }
    
    

    @Override
    public void start() {
        System.out.println("Car engine start");  
    }

    @Override
    public void stop() {
        System.out.println("car engine stop");  
    }
    
    
    
    
}

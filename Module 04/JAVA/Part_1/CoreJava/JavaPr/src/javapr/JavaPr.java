
package javapr;



//Play Main Class
public class JavaPr {

    public static void main(String[] args) {
       
        //Create object subclass
        Truck truck = new Truck();
        
        //Data push to subclass
        truck.setRegularPrice(200);
        truck.setWeight(2001);
        
        
        //Print 
        System.out.println(truck.getGetsalePrice());
    }
    
}


package javapr;


//Subclass and extend supper class
public class Truck extends Vehicle{
    
    //Variable declare
    private int weight;
    
    //Constractor
    public Truck() {
    }
    
    //Argument constractor
    public Truck(int weight) {
        this.weight = weight;
    }
    
    
    //Getter Setter
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    //Call supper class
    @Override
    public double getGetsalePrice() {
        
        if(this.weight>2000){
            return getRegularPrice()-getRegularPrice()*0.10;
        }
        return super.getRegularPrice(); 
    }
    
    
    
    
    
}

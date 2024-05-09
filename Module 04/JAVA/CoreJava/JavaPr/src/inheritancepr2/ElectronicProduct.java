
package inheritancepr2;


//Subclass and extends supperclass
public class ElectronicProduct extends Product {
    
    private int warrantyPeriod;

    public ElectronicProduct() {
    }
    
    public ElectronicProduct(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }
    
    
    //Override method get price connect to the inheritance pr2
    @Override
    public double getSalePrice() {
        
        if(warrantyPeriod>1){
            return super.getRegularPrice()-super.getRegularPrice() * 0.15;
        }
        return super.getRegularPrice(); 
    }
    
    
    
}

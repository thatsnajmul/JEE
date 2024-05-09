
package inheritancepr2;


public class InheritancePr2 {
    
    public static void main(String[] args) {
        ElectronicProduct e = new ElectronicProduct();
        
        e.setRegularPrice(500);
        e.setWarrantyPeriod(2);
        
        System.out.println(e.getSalePrice());
    }
}

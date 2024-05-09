
package inheritancepr2;

//Supper Class
public class Product {
    private String name;
    private double regularPrice;
    //double getSalePrice;
   

    public Product() {
    }

    public Product(String name, double regularPrice, double getSalePrice) {
        this.name = name;
        this.regularPrice = regularPrice;
        
        //this.getSalePrice = getSalePrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(double regularPrice) {
        this.regularPrice = regularPrice;
    }

    /*
    public double getGetSalePrice() {
        return getSalePrice;
    }

    public void setGetSalePrice(double getSalePrice) {
        this.getSalePrice = getSalePrice;
    }
    */
    
    
    //Method
     public double getSalePrice() {
        return regularPrice;
    }  
    
    
    
    
    
    
}

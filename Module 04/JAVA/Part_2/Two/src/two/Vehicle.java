
package two;




abstract class Vehicle {
    
    private String regNumber;
    private String brand;
    private int year;
    
    public Vehicle (String regNumber,String brand,int year) {
        
        this.regNumber=regNumber;
        this.brand=brand;
        this.year=year;
        
        
    }
    
    public String regNumber() {
        return regNumber;
    }
    public String brand() {
        return brand;
    }
    public int year() {
        return year;
    }
    
    
    public abstract void start();
    public abstract void stop();
    
}

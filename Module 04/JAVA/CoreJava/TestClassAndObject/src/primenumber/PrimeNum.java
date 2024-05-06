
package primenumber;


public class PrimeNum {
    
    
    public PrimeNum() {
    }
    
     int prime = 5;
    //Constracor
    public PrimeNum(int newPrimeNum){
        prime=newPrimeNum;
    }
    
    
    //Method return to the main class
    public int getPrimeNum(){
       int count =0;
        for(int i = 0; i<=prime; i++){
            if(prime%i==0){
                count++;
            }
        }
        
        if(count==2){
         return "It is Per
        }
    
        
       
    }
    
}

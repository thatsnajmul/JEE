
package testloops;


public class Factorial {
    
    public static void main(String[] args) {
       // Variable declare
       long fakeValue =17;
       long factorial =1;
       
       for(long i = 0; i<=fakeValue; i++){
           factorial *=i; //facetorial = facetorial*i 24
       }
       
       for(long i = fakeValue; i>fakeValue; i--){
           factorial *=i; 
       }
      
    }
}

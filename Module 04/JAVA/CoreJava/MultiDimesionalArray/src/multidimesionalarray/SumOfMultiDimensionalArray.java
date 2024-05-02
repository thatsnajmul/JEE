
package multidimesionalarray;


public class SumOfMultiDimensionalArray {
    
    public static void main(String[] args) {
        
        int[][] numbers = {{10,20,30},{10,20,30},{10,20,30}};
        
        int sumsss = doSumofMdarray(numbers);
        
        System.out.println(sumsss);
    }
    
    
    //Logically declare data
    public static int doSumofMdarray(int[][] myArrays) {
        int sum = 0; //
        for(int row=0; row<myArrays.length; row++){
            for(int col=0; col<myArrays[0].length; col++){
                sum += myArrays[row][col];
            }
        }
        return sum;
    }
    
    
    
    //https://www.ncbi.nlm.nih.gov/pmc/articles/PMC8266715/
}



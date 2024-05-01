package practisejava;
public class Java {
    public static void main(String[] args) {
        method1(args);
        method2(args);
        method3(args);    
    }
    public static void method1(String[] args) {
        String[] name = {"Rahim","Karim","Sattar","Jabbar"};
        System.out.println(name[1]);
    }
    public static void method2(String[] args) {
        int[] number = {10,20,30,40};
        System.out.println(number[3]); 
        System.out.println(number.length); 
    }
    public static void method3(String[] args) {
        String[] name = {"Rahim","Karim","Shafiq","Jabbar"};
        String[] number = {"+88 0170000000","+88 01711111","+88 01722222","+88 0173333"};
        System.out.println("Name length is:"+name.length);
        System.out.println("Number length is:"+number.length);
//        System.out.println(name[0]+" Number is " +number[0]); 
//        System.out.println(name[1]+" Number is " +number[1]); 
//        System.out.println(name[2]+" Number is " +number[2]); 
//        System.out.println(name[3]+" Number is " +number[3]); 
        
        for(String i:name){
            for(String j:number){
               System.out.println(i+" Number is "+j); 
        }
        }
    }
         
}

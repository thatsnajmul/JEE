package javadbconnect;

public class test {

    public static void main(String args[]) {
        System.out.println("Hello");
        try {
            int a, b, c;
            a = Integer.parseInt(args[8]); //8
            b = Integer.parseInt(args[0]); //0
            c = a / b;
            System.out.println(c);
        } catch (ArithmeticException e) {
            System.out.println("Bogra");
        } catch (ArrayIndexOutOfBoundsException e1) {
            System.out.println("how r u?");
        } finally {
            System.out.println("fine");
        }
    }
    

    
    
}

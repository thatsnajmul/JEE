package question2;

public class Question2 {

    public static void main(String[] args) {
        Truck truck = new Truck();
        truck.setRegularprice(100);
        truck.setWeight(2500);
        System.out.println(truck.getSalePrice());
    }

}

//Main Package
package javaallpr;
import java.util.Arrays;

//Main Class
public class JavaAllPr {

    public JavaAllPr() {
    }   
    //Main Method
    public static void main(String[] args) {
        //object declare
        Student s = new Student();
        //assaing value
        s.name="Md Najmul Islam";
        s.age=25;
        s.height=5.5f;
        s.weight=58.5f;
        s.country="Bangladesh";
        //print statement
        System.out.println("My Name is "+s.name+" age is "+s.age+", height is "+s.height+", weight is "+s.weight+"and country is "+s.country);
    }
    
    
}
//class make
class Student{
    //datatype and variable declare
    String name = "Abid";
    int age;
    float height;
    float weight;
    String country;
}

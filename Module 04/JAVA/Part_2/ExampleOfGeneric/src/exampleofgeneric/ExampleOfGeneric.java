
package exampleofgeneric;

import java.util.ArrayList;
import java.util.List;
import teacher.Teacher;

public class ExampleOfGeneric{


    public static void main(String[] args) {
        
        List li = new ArrayList();
        
        li.add("Md Najmul Islam");
        li.add(25);
        li.add("IsDB");
        li.add("Dhanmodi, Dhaka, Bangladesh");
        
        System.out.println("I'm "+li.get(0)+ ".\n"
                            +"My age is "+li.get(1)+".\n" 
                            +"I'm student of "+li.get(2)+".\n"
                            +"I Lives in "+li.get(3)+"."); 
        
        
        TeacherList e = new TeacherList();
        
       
        
        System.out.println(e);
        
    }
    
}

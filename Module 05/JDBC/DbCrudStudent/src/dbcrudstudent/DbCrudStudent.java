
package dbcrudstudent;

import static dbcrudstudent.EditData.getIntById;
import entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import util.DbUtil;

public class DbCrudStudent {


    public static void main(String[] args) {
       
        
       //+++++++++++++++++++++++++++INSERT DATA+++++++++++++++++++++++++++++++++++
       //====================================================================
       InsertData insertData = new InsertData();
       insertData.saveData();
       
       //+++++++++++++++++++++++++++SELECT DATA+++++++++++++++++++++++++++++++++++
       //====================================================================
       SelectData selectData = new SelectData();
       selectData.showData();
       
       //+++++++++++++++++++++++++++EDIT DATA+++++++++++++++++++++++++++++++++++
       //====================================================================
//       Student student = new Student();
         EditData editData = new EditData();
//       editData.changeData();

        Student student = new Student();
        List<Student> studentLi = getIntById(1);
        
        student.setStudentname(studentLi.get(0).getStudentname());
        student.setStudentemail("thatsnajmul@gmail.com");
        student.setStudentaddress(studentLi.get(0).getStudentaddress());
        student.setStudentphone(studentLi.get(0).getStudentphone());
        student.setStudentid(studentLi.get(0).getStudentid());
       
       editData.editData(student);
       selectData.showData();
       
        
        
    }
    
//    private static PreparedStatement ps;
//    private static ResultSet rs;
//    private static DbUtil db = new DbUtil();
    
    
    
    
    
    
    
}

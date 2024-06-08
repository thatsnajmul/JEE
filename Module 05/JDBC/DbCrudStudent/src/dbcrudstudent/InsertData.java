
package dbcrudstudent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DbUtil;


public class InsertData {
    
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static DbUtil db = new DbUtil();
    
    public static void saveData(){
        String insertsql = "insert into student(studentName, studentEmail, studentAddres, studentPhone)" + "values(?,?,?,?)";
        
        String name= "Md. Najmul Islam";
        String email= "najmul@gmail.com";
        String address= "Shankar, Dhanmodi, Dhaka";
        String phone= "+880179034...";
       
        try {
            ps = db.getCon().prepareStatement(insertsql);
            
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setString(4, phone);
            
            ps.executeUpdate();
            
            ps.close();
            //rs.close();
            db.getCon().close();
          
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
}

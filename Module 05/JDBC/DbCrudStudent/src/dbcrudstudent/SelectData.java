
package dbcrudstudent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DbUtil;

public class SelectData {
    
    
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static DbUtil db = new DbUtil();
    
    public static void showData(){
        String selectsql = "select * from student";
       
        try {
            ps = db.getCon().prepareStatement(selectsql);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                int id = rs.getInt("studentId");
                String name=    rs.getString("studentName");
                String email=    rs.getString("studentEmail");
                String address=    rs.getString("studentAddres");
                String phone=    rs.getString("studentPhone");
                
                System.out.println("Id is: " + id + " Name is: "+name+ " Email is: "+ email+ " Address is: "+ address+ " Phone is: "+phone);
            
            }
            
            
            ps.close();
            rs.close();
            db.getCon();
          
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
    
}

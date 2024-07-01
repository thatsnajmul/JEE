
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;
import util.DbUtil;


public class EmployeeDao {
    static PreparedStatement ps;
    static ResultSet rs;
    static String sql = "";
    
    
     public static int saveEmployee(Employee e){
     
         
          int status = 0;

        sql = "insert into employee(name, email, address, phone) "
                + "values(?,?,?,?)";
        
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            
            ps.setString(1, e.getName());
            ps.setString(2, e.getEmail());
            ps.setString(3, e.getAddress());
            ps.setString(4, e.getPhone());

            status = ps.executeUpdate();
            System.out.println(status);
            
            ps.close();
            DbUtil.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

            
        return status;
     }
}

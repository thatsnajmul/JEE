
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;
import util.DbUtil;


public class EmployeeDao {
    static PreparedStatement ps;
    static ResultSet rs;
    static String sql = "";
    
    
    
    //Insert Data
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
            //System.out.println(status);
            
            ps.close();
            DbUtil.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

            
        return status;
     }
     
     //View
     public static List<Employee> viewAllEmployee(){
         List<Employee> eList =new ArrayList<>();
         
         sql = "select * from employee";
         
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Employee e = new Employee(
                        rs.getInt("id"), 
                        rs.getString("name"), 
                        rs.getString("email"), 
                        rs.getString("address"),
                        rs.getString("phone")
                );
                
                eList.add(e);
            }
            
            ps.close();
            rs.close();
            DbUtil.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         
         
         
     return eList;
     }
     
     
     
     //Delete
     public static void deleteEmployee(Employee e){
     
         sql= "delete from employee where id=?";
         
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            
            ps.setInt(1, e.getId());
            
            ps.executeUpdate();
            
            ps.close();
            DbUtil.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
     }
}

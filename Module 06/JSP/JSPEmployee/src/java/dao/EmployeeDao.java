
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
    
    
    //Save
    public static int saveEmployee(Employee e){
        
        int status = 0;
        
        sql = "insert into employee(employeeName, employeeEmail, employeeAddress, employeePhone) "
                + "values(?,?,?,?)";
        
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            
            ps.setString(1, e.getEmployeeName());
            ps.setString(2, e.getEmployeeEmail());
            ps.setString(3, e.getEmployeeAddress());
            ps.setString(4, e.getEmployeePhone());

            status = ps.executeUpdate();
           // System.out.println(status);
            
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
                        rs.getInt("employeeId"), 
                        rs.getString("employeeName"), 
                        rs.getString("employeeEmail"), 
                        rs.getString("employeeAddress"),
                        rs.getString("employeePhone")
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
    
        sql= "delete from employee where employeeId=?";
        
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            
            ps.setInt(1, e.getEmployeeId());
            
            ps.executeUpdate();
            
            ps.close();
            DbUtil.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        
    }
    
    
    
    //Update
    public static void updateStudent(Employee e) {
        sql="update employee set employeeName=?, employeeEmail=?,employeeAddress=?,employeePhone=? where employeeId=?";
        
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            
            ps.setString(1, e.getEmployeeName());
            ps.setString(2, e.getEmployeeEmail());
            ps.setString(3, e.getEmployeeAddress());
            ps.setString(4, e.getEmployeePhone());
            ps.setInt(5, e.getEmployeeId());
            
            
            
            ps.executeUpdate();
            
            ps.close();
            DbUtil.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public static Employee getById(int employeeId) {
        Employee e = null;
        
        
        sql="select * from employee where employeeId=?";
        
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            ps.setInt(1, employeeId);
            
            while(rs.next()){            
                Employee e = new Employee(
                        rs.getInt("employeeId"), 
                        rs.getString("employeeName"), 
                        rs.getString("employeeEmail"), 
                        rs.getString("employeeAddress"),
                        rs.getString("employeePhone")
                );
                
                
            }
            
            ps.close();
            rs.close();
            DbUtil.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return e;
    }
    
    
    
}

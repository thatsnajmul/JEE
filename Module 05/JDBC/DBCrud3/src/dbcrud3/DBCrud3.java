
package dbcrud3;

import dbutil.DBUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBCrud3 {
    
    
    private static DBUtil db = new DBUtil();
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static String sql = "";
  
    public static void main(String[] args) {
        
        //insertData("Md Najmul", "najmul@gmail.com", "Dhaka", "12345697");
        //showData();
        //updateData("Md Najmul Islam", "najmul123@gmail.com", "dhanmodi", "0179220", 2);
        deleteData(3);
        showData();
    }
    
    
    public static void insertData(String name, String email, String address, String phone) {
        sql = "insert into student (name, email, address, phone) values(?,?,?,?)";
        
        try {
            ps= db.getConn().prepareStatement(sql);
            
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setString(4, phone);
            
            ps.executeUpdate();
            
            ps.close();
            db.getConn().close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DBCrud3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    public static void showData() {
        sql = "select * from student";
        try {
            ps= db.getConn().prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String id = rs.getString("id");
                
                System.out.println("ID: " +id+"\tName: "+name+"\tEmail: "+email+"\tAddress: "+address+"\tPhone: "+phone);
            }
            
            ps.close();
            rs.close();
            db.getConn().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DBCrud3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void updateData(String name, String email, String address, String phone, int id) {
        sql= "update student set name=?, email=?, address=?, phone=? where id=?";
        try {
            ps= db.getConn().prepareStatement(sql);
            
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setString(4, phone);
            ps.setInt(5, id);
            
            ps.executeUpdate();
            
            ps.close();
            db.getConn().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DBCrud3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void deleteData(int id) {
        sql = "delete from student where id =?";
        
        try {
            ps= db.getConn().prepareStatement(sql);
            
            ps.setInt(1, id);
            
            ps.executeUpdate();
            ps.close();
            db.getConn().close();
        } catch (SQLException ex) {
            Logger.getLogger(DBCrud3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

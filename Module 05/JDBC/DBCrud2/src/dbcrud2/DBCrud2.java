
package dbcrud2;


import dbutil.DBUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBCrud2 {

    public static DBUtil db = new DBUtil();
    static PreparedStatement ps;
    static ResultSet rs;
    static String sql = "";
    
    
    public static void main(String[] args) {
        //insertData("Md Najmul Islam", "najmul@gmail.com", "Dhanmondi, Dhaka", "01790349310");
        //viewData();
        updateData("Md Najmul Islam", "najmul@gmail.com", "Dhanmondi, Dhaka", "1234563", 2);
        viewData();
    }
    
    public static void insertData(String name, String email, String address, String phone) {

        sql = "insert into employee(name, email, address, phone)"
                + " values(?,?,?,?)";

        try {
            ps = db.getCon().prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setString(4, phone);
            
            ps.executeUpdate();
            ps.close();
            db.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(InsertData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void  viewData(){
        
        sql = "select * from employee";
        
        try {
            ps = db.getCon().prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String id = rs.getString("id");
                
                
                System.out.println("ID: "+ id + "\tName:"+name+"\tEmail:"+email+"\tAddress:"+address+"\tphone:"+phone);
                
                
            }
            
                ps.close();
                rs.close();
                db.getCon().close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DBCrud2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    public static void updateData(String name, String email, String address,String phone,int id){
        sql = "update employee set name=?, email=?, address=?, phone=? where id=?";
        
        try {
            ps = db.getCon().prepareStatement(sql);
            
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setString(4, phone);
            ps.setInt(5, id);
            
            
            ps.executeUpdate();
            
            ps.close();
            db.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(DBCrud2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void deleteData(int id) {
        sql = "delete from employee where id =?";
        
        try {
            ps = db.getCon().prepareStatement(sql);
            
            ps.setInt(2, id);
            
            ps.executeUpdate();
            ps.close();
            db.getCon().close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DBCrud2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
}

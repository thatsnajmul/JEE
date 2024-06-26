
package entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBUtil;


public class ShowData {
    
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static DBUtil db = new DBUtil();
    
    
    public static void showData(){
         String sql = "select * from employee";
         
        try {
            ps = db.getCon().prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String id = rs.getString("id");

                System.out.println("ID: " + id + " \tName: " + name + "\t Email: " + email + " \tAddress: " + address + " \tPhone No: " + phone);

            }
            
            ps.close();
            rs.close();
            db.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ShowData.class.getName()).log(Level.SEVERE, null, ex);
        }

         
         
         
    }
    
}

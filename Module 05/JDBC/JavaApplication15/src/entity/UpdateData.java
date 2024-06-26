
package entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBUtil;

public class UpdateData {
    
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static DBUtil db = new DBUtil();
    
    
    public static void updateData(String name, String email, String address, String phone, int id){
        
        String sql = "update employee set name=?, email=?, address=?, phone=? where id=?";
        
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
            Logger.getLogger(UpdateData.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }
    
    
}

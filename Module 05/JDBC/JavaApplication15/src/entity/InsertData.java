
package entity;

import DBCrud4.DBCrud4;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBUtil;

public class InsertData {
    
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static DBUtil db = new DBUtil();
    
    public static void insertData(String name, String email, String address, String phone) {
        
        String sql = "insert into employee(name, email, address, phone)" + "values(?,?,?,?)";
        
        try {
            ps = db.getCon().prepareStatement(sql);
            
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setString(4, phone);
            
            ps.executeUpdate();
            
            ps.close();
            //rs.close();
            db.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(DBCrud4.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}


package entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBUtil;

public class DeleteData {
    
    
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static DBUtil db = new DBUtil();
    
    public static void deleteData(int id){
        
        String sql = "delete from employee where id=?";
        
        try {
            ps = db.getCon().prepareStatement(sql);
            
            ps.setInt(1, id);

            ps.executeUpdate();

            ps.close();
            db.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DeleteData.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
}



package javadbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;




public class JavaDbConnect {


    public static void main(String[] args) {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3310/test", "root", "12345");
            
            PreparedStatement ps = connection.prepareStatement("Select * from student");
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                System.out.println(rs.getInt("id")+ " "+rs.getString("name")+ " "+ rs.getString("roll") + " "+rs.getString("age"));
            }            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JavaDbConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JavaDbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}

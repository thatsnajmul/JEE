package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;                    
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbUtil {
	
	private static String url = "jdbc:mysql://localhost:3307/student_data";
    private static String user = "root";
    private static String password = "1234";

    private static String driver = "com.mysql.cj.jdbc.Driver";

    private static Connection con = null;
    
     public static Connection getCon() {
    	 
    	 try {
             Class.forName(driver);
             con = DriverManager.getConnection(url, user, password);
         } catch (SQLException ex) {
        	 Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
        	 Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         return con;
    	 
    	 
    	 
     }

}

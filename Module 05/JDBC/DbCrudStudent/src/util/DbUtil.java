
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DbUtil {
    
    //Write something
    private Connection con = null;
    private String url = "jdbc:mysql://localhost:3307/student";
    private String user = "root";
    private String password = "1234";
    private String driver = "com.mysql.cj.jdbc.Driver";

    //Write something
    public Connection getCon() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            //System.out.println("Connection Established successfully");
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, e);
        }
        return con;
    }
    
}

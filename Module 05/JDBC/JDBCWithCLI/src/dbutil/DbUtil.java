
package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DbUtil {
    
    //Write something
    private Connection con=null;
    private String url="jdbc:mysql://localhost:3307/jdbcwithcli";
    private String user="root";
    private String password="1234";
    private String driver="com.mysql.cj.jdbc.Driver";
    
    
    //Write something
    public Connection getCon() throws ClassNotFoundException{
        
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url, user, password);
            //System.out.println("Connection Established successfully");
        } catch (SQLException ex) {
            Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
        
        
        
        
        
        /*
        String query = "select *from students"; // query to be run
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query); // Execute query
        rs.next();
        String name= rs.getString("name"); // Retrieve name from DbUtil
        System.out.println(name); // Print result on console
        st.close(); // close statement
        con.close(); // close connection
        System.out.println("Connection Closed....");
        */

    
}

package jdbcwithcli;

import dbutil.DbUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCWithCLI {

    static PreparedStatement ps;
    static ResultSet rs;

    public static void main(String[] args) {

        DbUtil db = new DbUtil();

        //Insert
        String inseertsql = "insert into jdbcwithcli(msg)" + "values(?)";

        try {
            ps = db.getCon().prepareStatement(inseertsql);
            ps.setString(1, "Hello Java");

            ps.executeUpdate();
            ps.close();
            db.getCon().close();

        } catch (SQLException | ClassNotFoundException ex) {

            Logger.getLogger(JDBCWithCLI.class.getName()).log(Level.SEVERE, null, ex);
        }

        //select
        String selectsql = "select * from jdbcwithcli";

        try {
            ps = db.getCon().prepareStatement(selectsql);
            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                String msg = rs.getString("msg");

                System.out.println("Id is: " + id + " " + "Messege is: " + msg);

            }

            ps.close();
            rs.close();
            db.getCon().close();

        } catch (SQLException | ClassNotFoundException ex) {

            Logger.getLogger(JDBCWithCLI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

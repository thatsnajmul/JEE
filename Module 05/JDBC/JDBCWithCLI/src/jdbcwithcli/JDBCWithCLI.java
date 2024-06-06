package jdbcwithcli;

import dbutil.DbUtil;
import entity.jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCWithCLI {

    private static DbUtil db = new DbUtil();
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static void main(String[] args) {

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

                System.out.println("Id is: " + id + ", " + "Messege is: " + msg);

            }

            ps.close();
            rs.close();
            db.getCon().close();

        } catch (SQLException | ClassNotFoundException ex) {

            Logger.getLogger(JDBCWithCLI.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Edit or Update
        jdbc jdbc = new jdbc();
        List<jdbc> jdbclist = getById(1);

        jdbc.setId(jdbclist.get(0).getId());
        jdbc.setMsg("Java");

        updateJDBC(jdbc);

        //Delete
    }

    
    
    
    
    
    
    
    
    
    //Edit or Update
    public static void updateJDBC(jdbc j) {
        String editsql = "update jdbcwithcli set msg=? where id=?";

        try {
            ps = db.getCon().prepareStatement(editsql);

            ps.setString(1, j.getMsg());
            ps.setInt(2, j.getId());

            ps.executeUpdate();

            ps.close();
            db.getCon().close();
            System.out.println("Edited successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static List<jdbc> getById(int id) {

        List<jdbc> jdbclist = new ArrayList<>();
        try {

            String editsql = "select * from jdbcwithcli where id=?";

            ps = db.getCon().prepareStatement(editsql);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                jdbc j = new jdbc(
                        rs.getInt("id"),
                        rs.getString("msg")
                );

                jdbclist.add(j);

            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(JDBCWithCLI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jdbclist;

    }

    //Delete
}

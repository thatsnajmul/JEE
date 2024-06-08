package dbcrudstudent;

import entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DbUtil;

public class EditData {

    private static PreparedStatement ps;
    private static ResultSet rs;
    private static DbUtil db = new DbUtil();

    public static void changeData() {
        

    }

    public static void editData(Student s) {
        String updatesql = "update student set studentName=?, studentEmail=?, studentAddress=?, studentPhone=? where Studentid=?";

        try {
            ps = db.getCon().prepareStatement(updatesql);

            ps.setString(1, s.getStudentname());
            ps.setString(2, s.getStudentemail());
            ps.setString(3, s.getStudentaddress());
            ps.setString(4, s.getStudentphone());
            ps.setInt(5, s.getStudentid());

            ps.close();
            rs.close();
            db.getCon().close();

            System.out.println("Edited Successfully");

        } catch (SQLException ex) {
            Logger.getLogger(EditData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ;
    
    public static List<Student> getIntById(int studentId) {

        List<Student> studentlist = new ArrayList<>();

        String editsql = "select * from nstudent where studentId=?";

        try {
            ps = db.getCon().prepareStatement(editsql);

            ps.setInt(1, studentId);

            rs = ps.executeQuery();

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("studentId"),
                        rs.getString("studentName"),
                        rs.getString("studentEmail"),
                        rs.getString("studentAddress"),
                        rs.getString("studentPhone")
                );

                studentlist.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EditData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return studentlist;
    }
;

}

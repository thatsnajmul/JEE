
package entity;


public class Student {
    
    private int studentid;
    private String studentname;
    private String studentemail;
    private String studentaddress;
    private String studentphone;

    public Student() {
    }

    public Student(int studentid, String studentname, String studentemail, String studentaddress, String studentphone) {
        this.studentid = studentid;
        this.studentname = studentname;
        this.studentemail = studentemail;
        this.studentaddress = studentaddress;
        this.studentphone = studentphone;
    }

    public Student(String studentname, String studentemail, String studentaddress, String studentphone) {
        this.studentname = studentname;
        this.studentemail = studentemail;
        this.studentaddress = studentaddress;
        this.studentphone = studentphone;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getStudentemail() {
        return studentemail;
    }

    public void setStudentemail(String studentemail) {
        this.studentemail = studentemail;
    }

    public String getStudentaddress() {
        return studentaddress;
    }

    public void setStudentaddress(String studentaddress) {
        this.studentaddress = studentaddress;
    }

    public String getStudentphone() {
        return studentphone;
    }

    public void setStudentphone(String studentphone) {
        this.studentphone = studentphone;
    }

    @Override
    public String toString() {
        return "Student{" + "studentid=" + studentid + ", studentname=" + studentname + ", studentemail=" + studentemail + ", studentaddress=" + studentaddress + ", studentphone=" + studentphone + '}';
    }
    
    
    
    
    
    
}

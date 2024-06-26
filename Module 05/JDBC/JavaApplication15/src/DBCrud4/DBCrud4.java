
package DBCrud4;

import entity.DeleteData;
import entity.UpdateData;
import entity.ShowData;
import entity.InsertData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.DBUtil;


public class DBCrud4 {
    
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static DBUtil db = new DBUtil();
        
    
    public static void main(String[] args) {
        InsertData insertData = new InsertData();
        insertData.insertData("Md Najmul Islam", "najmul@gmail.com", "Dhanmondi, Dhaka", "01790349310");
    
        ShowData showData = new ShowData();
       // showData.showData();
        
        UpdateData updateData = new UpdateData();
        updateData.updateData("Najmul", "change_email@email.com", "Agargaon, Dhaka", "123456789", 2);
        updateData.updateData("Najmul", "change_email@email.com", "Agargaon, Dhaka", "123456789", 3);
        showData.showData();
        
        
        DeleteData deleteData = new DeleteData();
        deleteData.deleteData(3);
    }
    
    
}

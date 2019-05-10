package crud;

import config.Connect;

import java.sql.Connection;
import java.sql.Statement;

public class Memberdb {
    public static void insertmember(String idline) {
        String sql = "insert into member value ('555',idline)";
        try {
            Connect c = new Connect();
            Connection con = c.connectDB();
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            System.out.println("บันทึกข้อมูลเรียบร้อย");

            con.close();
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

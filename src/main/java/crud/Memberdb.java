package crud;

import config.Connect;

import java.sql.Connection;
import java.sql.Statement;

public class Memberdb {
    public static void insertmember(String idline) {
        System.out.println("this id"+ idline);
        String sql = ("INSERT INTO member value ('" + idline + "'),'" + idline + "')");
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

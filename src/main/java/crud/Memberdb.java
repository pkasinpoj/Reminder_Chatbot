package crud;

import config.Connect;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Random;

public class Memberdb {
    public static void insertmember(String idline) {
        Random r = new Random();
        int randomnum = r.nextInt(1000000);
        String sql = ("INSERT INTO member value ('" + randomnum + "','" + idline + "')");
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

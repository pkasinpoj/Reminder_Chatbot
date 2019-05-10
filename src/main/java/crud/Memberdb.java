package crud;

import config.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
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

    public static boolean checkmember() {
        String sql = "select * from member";
        boolean result = false;
        try {
            Connect c = new Connect();
            Connection con = c.connectDB();
            ResultSet rs = con.createStatement().executeQuery(sql);
            String[] arr = null;
            while (rs.next()) {
                String em = rs.getString(2);
                arr = em.split("\n");
            }
            System.out.println(arr[0]);
            rs.close();
            con.close();
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return result;
        }
    }
}

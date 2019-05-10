package crud;

import condition.CheckMember;
import config.Connect;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Random;

public class Rememberdb {
    public static boolean insertremember(String work,String date,String idline) {
        boolean checksucess = false;
        try {
        Random r = new Random();
        int randomnum = r.nextInt(10000000);
        String []arr = new String[10];
        System.out.println(date);
        arr = date.split("/");
        for (int i =0;i<arr.length;i++){
            System.out.println(i);
            System.out.println(arr[i]);
        }
        String sql = ("INSERT INTO remember value ('" + randomnum + "','" + work + "','" + arr[0] + "','" + arr[1] + "','" + arr[2] + "','" + idline + "')");
        CheckMember check = new CheckMember();
        check.checkid(idline);
        Connect c = new Connect();
        Connection con = c.connectDB();
        Statement stm = con.createStatement();
        stm.executeUpdate(sql);
        System.out.println("บันทึกข้อมูลจำเรียบร้อย");
        con.close();
        stm.close();
        checksucess = true ;
        return checksucess;
        } catch (Exception e) {
            System.out.println("errorthis"+e);
            return checksucess;
        }
    }
}

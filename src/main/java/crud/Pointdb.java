package crud;

import condition.CheckMember;
import config.Connect;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Random;

public class Pointdb {
    public static boolean insertpoint(String subject,Integer point,String idline) {
        boolean checksucess = false;
        try {
            Random r = new Random();
            int randomnum = r.nextInt(10000000);
            int idpk ;
            CheckMember check = new CheckMember();
            check.checkid(idline);
            Memberdb m = new Memberdb();
            idpk = m.checkid(idline);
            if (idpk !=0){
                System.out.println(subject);
                System.out.println(point);
                System.out.println(idpk);
                String sql = ("INSERT INTO point value ('" + randomnum + "','" + subject + "','" + point + "','" + idpk + "')");
                Connect c = new Connect();
                Connection con = c.connectDB();
                Statement stm = con.createStatement();
                stm.executeUpdate(sql);
                System.out.println("บันทึกคะเเนนเรียบร้อยครับ");
                con.close();
                stm.close();
                checksucess = true ;
                return checksucess;
            }else {
                return checksucess;
            }
        } catch (Exception e) {
            System.out.println("errorthispoint"+e);
            return checksucess;
        }
    }
}

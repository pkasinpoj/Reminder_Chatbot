package crud;

import condition.CheckMember;
import config.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
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
    public static Integer showpoint(String subject,String idline) {
        String sql = "select * from point";
        int idpk = 0;
        Memberdb m = new Memberdb();
        idpk = m.checkid(idline);
        int point = 0;
        try {
            Connect c = new Connect();
            Connection con = c.connectDB();
            ResultSet rs = con.createStatement().executeQuery(sql);
            String[] arr = null;
            String[] arrpk = null;
            String[] apoint = null;
            while (rs.next()) {
                String ipk = rs.getString(2);
                String points = rs.getString(3);
                String em = rs.getString(4);
                apoint = points.split("\n");
                arrpk = ipk.split("\n");
                arr = em.split("\n");
                for (int i =0; i < arr.length; i++){
//                    System.out.println(arr[i]);
                    int checkpoint = Integer.parseInt(arr[i]);
                    if (arrpk[i].equals(subject)&&checkpoint == idpk){
                        point  = Integer.parseInt(apoint[i]);
                    }
                }
            }
            rs.close();
            con.close();
            return point;
        } catch (Exception e) {
            System.out.println("this"+e);
            return point;
        }
    }
}

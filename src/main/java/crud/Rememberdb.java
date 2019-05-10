package crud;

import condition.CheckMember;
import config.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class Rememberdb {
    public static boolean insertremember(String work,String date,String idline) {
        boolean checksucess = false;
        try {
        Random r = new Random();
        int randomnum = r.nextInt(10000000);
        String []arr = new String[10];
        arr = date.split("/");
        int idpk ;
        Memberdb m = new Memberdb();
        idpk = m.checkid(idline);
        if (idpk !=0){
            String sql = ("INSERT INTO remember value ('" + randomnum + "','" + work + "','" + arr[0] + "','" + arr[1] + "','" + arr[2] + "','" + idpk + "')");
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
        }else {
            return checksucess;
        }
        } catch (Exception e) {
            System.out.println("errorthis"+e);
            return checksucess;
        }
    }
    public static String showremember(String date,String idline) {
        String sql = "select * from remember ";
        int idpk = 0;
        String []arr = new String[10];
        arr = date.split("/");
        Memberdb m = new Memberdb();
        idpk = m.checkid(idline);
        String []text = new String[1000];
        String []spiltdate = null;
        String []spiltmonth = null;
        String []spiltyear = null;
        String []spiltwork = null;
        String []spiltpk = null;
        String texts = "";
        int k = 0;
        try {
            Connect c = new Connect();
            Connection con = c.connectDB();
            ResultSet rs = con.createStatement().executeQuery(sql);
            String[] arrpk = null;
            while (rs.next()) {
                String pk  = rs.getString(1);
                String work = rs.getString(2);
                String dates = rs.getString(3);
                String month = rs.getString(4);
                String year = rs.getString(5);
                spiltpk = pk.split("\n");
                spiltwork = work.split("\n");
                spiltdate = dates.split("\n");
                spiltmonth = month.split("\n");
                spiltyear = year.split("\n");
                for (int i =0; i < spiltdate.length; i++){
//                    System.out.println(arr[i]);
                    int ipk = Integer.parseInt(spiltpk[i]);
                    if (spiltdate[i].equals(arr[0])&&spiltmonth[i].equals(arr[1])&&spiltyear[i].equals(arr[2])&&ipk == idpk){
                        text[k]  = spiltwork[i];
                        k++;
                    }
                }
                 texts = "งานที่ต้องส่งคือ"+"\n"+text[0];
            }
            rs.close();
            con.close();
            return texts;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return texts;
        }
    }
}

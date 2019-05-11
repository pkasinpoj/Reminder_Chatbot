package config;

import java.sql.*;

public class Connect {
    public static Connection connectDB(){
        try{
            System.out.println("here");
                Class.forName("com.mysql.cj.jdbc.Driver");//ระบุ Driver
                String url = "jdbc:mysql://us-cdbr-iron-east-02.cleardb.net/heroku_50236681737c507";
                Connection connect = DriverManager.getConnection(url, "bddf2105a1f693","4e10673e");
                System.out.println("เชื่อมต่อฐานข้อมูลเรียบร้อย");
                return connect;
        }catch (Exception e){
            System.out.println("this"+e);
            return null;
        }
    }
}

package config;

import java.sql.*;

public class Connect {
    public static Connection connectiondb(){
        try{
            System.out.println("here");
                Class.forName("com.mysql.cj.jdbc.Driver");//ระบุ Driver
                String url = "jdbc:mysql://localhost/jumdee";
                Connection connect = DriverManager.getConnection(url, "root","");
                System.out.println("เชื่อมต่อฐานข้อมูลเรียบร้อย");
                return connect;
        }catch (Exception e){
            System.out.println("this"+e);
        }
        return null;
    }
}

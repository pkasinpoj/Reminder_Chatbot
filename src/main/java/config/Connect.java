package config;

import java.sql.*;

public class Connect {
    public static Connection connectDB(){
        try{
            System.out.println("here");
                Class.forName("com.mysql.cj.jdbc.Driver");//ระบุ Driver
                String url = "jdbc:mysql://xxxxxxxxxxxxxxxx";
                Connection connect = DriverManager.getConnection(url, "xxxxxxxxxxx","xxxxxxxxx");
                System.out.println("เชื่อมต่อฐานข้อมูลเรียบร้อย");
                return connect;
        }catch (Exception e){
            System.out.println("this"+e);
            return null;
        }
    }
}

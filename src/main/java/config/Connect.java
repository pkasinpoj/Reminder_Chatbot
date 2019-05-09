package config;

import java.sql.*;

public class Connect {
    public static Connection connectiondb(){
        try{
            System.out.println("here");
           Class.forName("mysql-connector-java");
           String url = "jdbc:mysql://localhost/jumdee";
           Connection con = DriverManager.getConnection(url,"root","");
            System.out.println("Success");
           return con;
        }catch (Exception e){
            System.out.println("this"+e);
        }
        ////
        return null;
    }
}

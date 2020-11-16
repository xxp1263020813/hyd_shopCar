package cn.edu.zut.util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    private static String url;
    private static String driverName;
    private static String username;
    private static String password;
    static{
        Properties pro = new Properties();
        try {
            //注意classpath的路径
            pro.load(JDBCUtil.class.getResourceAsStream("/jdbc.properties"));
            url = pro.getProperty("jdbc.url");
            driverName = pro.getProperty("jdbc.driver");
            username = pro.getProperty("jdbc.username");
            password = pro.getProperty("jdbc.password");
            //1、加载数据库驱动，将一个类加载到内存，类名是com.mysql.cj.jdbc.Driver
            Class.forName(driverName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnction(){
        try {
            return DriverManager.getConnection(url,username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static void release(ResultSet rs, Statement st, Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(st != null){
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

package com.sc.util;


import java.sql.*;

/**
 * @Author: fangju
 * @Date: 2019/5/25 12:00
 */
public class JDBCUtil {
    private static String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static String USERNAME = "hr";
    private static String PASSWORD = "123456";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接对象
     * @return
     */
    public static Connection getConn(){
        Connection conn = null;
        try {
            return conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭数据库连接
     * @param conn
     * @param st
     * @param rs
     */
    public static void closeConn(Connection conn, Statement st, ResultSet rs){
        try {
            if(rs != null){
                rs.close();
            }
            if(st != null){
                st.close();
            }
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

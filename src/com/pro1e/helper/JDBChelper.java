/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pro1e.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huyNQph11019
 */
public class JDBChelper {
//    tạo kết nối

    static String sql = "jdbc:sqlserver://localhost:1433;database=PRO1_E1";
    static String user = "sa";
    static String pass = "123123";
    static String dri = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    static {
        try {
            Class.forName(dri);
        } catch (ClassNotFoundException e) {
            System.err.println(e);
            throw new RuntimeException(e);
        }
    }

    static public Connection cnn() {

        try {
            //  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(sql, user, pass);
            System.out.println("\nconnected to DATABASE:)");
            return con;
        } catch (SQLException e) {
            e.toString();
            System.err.print("lỗi kết nối ");
        }
        return null;
    }
// trả về 1 statement
 public static PreparedStatement getStm(String sql, Object... args) { // lấy statement
        Connection kon = cnn();

        try {
            PreparedStatement stm;
            if (sql.trim().startsWith("{")) {// kiểm tra xem nhập vào có phỉa là thử tục không
                stm = kon.prepareCall(sql); // gọi thủ tục
            } else {
                stm = kon.prepareStatement(sql); // không phải thủ tục gọi với prepare nhưu thường
            }
            for (int i = 0; i < args.length; i++) { // gán dữ liệu vào stm
                stm.setObject(i + 1, args[i]);
            }
            return stm;
        } catch (SQLException e) {
            System.err.println("lỗi getstm" + e);
        }
        return null;
    }


    // query-> resultSet
    public static ResultSet query(String sql, Object... args) {
        try {
            PreparedStatement stms = getStm(sql, args);
            return stms.executeQuery(); // trả về dữ liệu là 1 resulSet
        } catch (SQLException e) {
            System.err.println("lỗi query" + e);
        }
        return null;

    }

    //update-> int  
    public static int update(String sql, Object... args) {
        try {
            PreparedStatement stms = getStm(sql, args);
         //   stms.setBoolean(0, true);
            try {
                return stms.executeUpdate();
            } finally {
                stms.getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //value-> object
       public static Object value(String sql, Object... args) {
        ResultSet rs = JDBChelper.query(sql, args); // gọi lại hàm trên để lấy ResultSet
        try {
            if (rs.next()) {
                return rs.getObject(0);// lấy dữ liệu ở cột thứu 0
            }
            rs.getStatement().getConnection().close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return null;

    }

    public static void main(String[] args) {
        JDBChelper.cnn();
    }
}

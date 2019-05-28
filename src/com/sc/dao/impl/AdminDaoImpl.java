package com.sc.dao.impl;

import com.sc.dao.IAdminDao;
import com.sc.domain.Admin;
import com.sc.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/25 15:43
 */
public class AdminDaoImpl implements IAdminDao {
    @Override
    public List<Admin> getAllAdmin() throws SQLException {
        List<Admin> adminList = null;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "select * from admin";
        conn = JDBCUtil.getConn();
        st = conn.createStatement();
        st.execute(sql);
        rs = st.getResultSet();
        adminList = new ArrayList<>();
        while (rs.next()){
            Admin admin = new Admin();
            admin.setId(rs.getString("a_id"));
            admin.setPassword(rs.getString("a_password"));
            admin.setName(rs.getString("a_name"));
            admin.setSex(rs.getString("a_sex"));
            admin.setAge(rs.getInt("a_age"));
            admin.setImage(rs.getString("a_image"));
            adminList.add(admin);
        }
        JDBCUtil.closeConn(conn,st,rs);
        return adminList;
    }

    @Override
    public Admin getAdmin(String id) throws SQLException {
        Admin admin = null;
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql = "select * from admin where a_id = ?";
        conn = JDBCUtil.getConn();
        psmt = conn.prepareStatement(sql);
        psmt.setString(1,id);
        psmt.execute();
        rs = psmt.getResultSet();
        rs.next();
        admin = new Admin();
        admin.setId(rs.getString("a_id"));
        admin.setPassword(rs.getString("a_password"));
        admin.setName(rs.getString("a_name"));
        admin.setSex(rs.getString("a_sex"));
        admin.setAge(rs.getInt("a_age"));
        admin.setImage(rs.getString("a_image"));
        JDBCUtil.closeConn(conn,psmt,rs);
        return admin;
    }

    @Override
    public int insertAdmin(Admin admin) throws SQLException {
        Connection conn = null;
        PreparedStatement psmt = null;
        String sql = "insert into admin(a_id,a_password,a_name,a_sex,a_age,a_image) values(?,?,?,?,?,?)";
        conn = JDBCUtil.getConn();
        psmt = conn.prepareStatement(sql);
        psmt.setString(1,admin.getId());
        psmt.setString(2,admin.getPassword());
        psmt.setString(3,admin.getName());
        psmt.setString(4,admin.getSex());
        psmt.setInt(5,admin.getAge());
        psmt.setString(6,admin.getImage());
        int i = psmt.executeUpdate();
        JDBCUtil.closeConn(conn,psmt,null);
        return i;
    }

    @Override
    public int updateAdmin(Admin admin) throws SQLException {
        Connection conn = null;
        PreparedStatement psmt = null;
        String sql = "update admin set a_password = ?,a_name = ?,a_sex = ?,a_age = ?,a_image = ? where a_id = ?";
        conn = JDBCUtil.getConn();
        psmt = conn.prepareStatement(sql);
        psmt.setString(1,admin.getPassword());
        psmt.setString(2,admin.getName());
        psmt.setString(3,admin.getSex());
        psmt.setInt(4,admin.getAge());
        psmt.setString(5,admin.getImage());
        psmt.setString(6,admin.getId());
        int i = psmt.executeUpdate();
        JDBCUtil.closeConn(conn,psmt,null);
        return i;
    }

    @Override
    public int deleteAdmin(String id) throws SQLException {
        Connection conn = null;
        PreparedStatement psmt = null;
        String sql = "delete from admin where a_id = ?";
        conn = JDBCUtil.getConn();
        psmt = conn.prepareStatement(sql);
        psmt.setString(1,id);
        int i = psmt.executeUpdate();
        JDBCUtil.closeConn(conn,psmt,null);
        return i;
    }

    @Override
    public boolean findAdmin(String username, String password) throws SQLException {
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql = "select * from admin where a_id = ? and a_password = ?";
        conn = JDBCUtil.getConn();
        psmt = conn.prepareStatement(sql);
        psmt.setString(1,username);
        psmt.setString(2,password);
        psmt.execute();
        rs = psmt.getResultSet();
        if(rs.next()){
            JDBCUtil.closeConn(conn,psmt,rs);
            return true;
        }
        JDBCUtil.closeConn(conn,psmt,rs);
        return false;
    }
}

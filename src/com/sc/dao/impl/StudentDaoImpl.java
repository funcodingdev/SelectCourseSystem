package com.sc.dao.impl;

import com.sc.dao.IStudentDao;
import com.sc.domain.Admin;
import com.sc.domain.Student;
import com.sc.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/25 15:36
 */
public class StudentDaoImpl implements IStudentDao {

    @Override
    public List<Student> getAllStudent() throws SQLException {
        List<Student> studentList = null;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "select * from student";
        conn = JDBCUtil.getConn();
        st = conn.createStatement();
        st.execute(sql);
        rs = st.getResultSet();
        studentList = new ArrayList<>();
        while (rs.next()){
            Student stu = new Student();
            stu.setId(rs.getString("s_id"));
            stu.setPassword(rs.getString("s_password"));
            stu.setName(rs.getString("s_name"));
            stu.setSex(rs.getString("s_sex"));
            stu.setAge(rs.getInt("s_age"));
            stu.setsClass(rs.getString("s_class"));
            stu.setDepartment(rs.getString("s_department"));
            stu.setPhone(rs.getString("s_phone"));
            stu.setImage(rs.getString("s_image"));
            studentList.add(stu);
        }
        return studentList;
    }

    @Override
    public Student getStudent(String id) throws SQLException {
        Student stu = null;
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql = "select * from student where s_id = ?";
        conn = JDBCUtil.getConn();
        psmt = conn.prepareStatement(sql);
        psmt.setString(1,id);
        psmt.execute();
        rs = psmt.getResultSet();
        rs.next();
        stu = new Student();
        stu.setId(rs.getString("s_id"));
        stu.setPassword(rs.getString("s_password"));
        stu.setName(rs.getString("s_name"));
        stu.setSex(rs.getString("s_sex"));
        stu.setAge(rs.getInt("s_age"));
        stu.setsClass(rs.getString("s_class"));
        stu.setDepartment(rs.getString("s_department"));
        stu.setPhone(rs.getString("s_phone"));
        stu.setImage(rs.getString("s_image"));
        return stu;
    }

    @Override
    public int insertStudent(Student stu) throws SQLException {
        Connection conn = null;
        PreparedStatement psmt = null;
        String sql = "insert into student(s_id,s_password,s_name,s_sex,s_age,s_image,s_class,s_department,s_phone) values(?,?,?,?,?,?,?,?,?)";
        conn = JDBCUtil.getConn();
        psmt = conn.prepareStatement(sql);
        psmt.setString(1,stu.getId());
        psmt.setString(2,stu.getPassword());
        psmt.setString(3,stu.getName());
        psmt.setString(4,stu.getSex());
        psmt.setInt(5,stu.getAge());
        psmt.setString(6,stu.getImage());
        psmt.setString(7,stu.getsClass());
        psmt.setString(8,stu.getDepartment());
        psmt.setString(9,stu.getPhone());
        return psmt.executeUpdate();
    }

    @Override
    public int updateStudent(Student stu) throws SQLException {
        Connection conn = null;
        PreparedStatement psmt = null;
        String sql = "update student set s_password = ?,s_name = ?,s_sex = ?,s_age = ?,s_image = ?,s_class = ?,s_department = ?,s_phone = ?" +
                " where s_id = ?";
        conn = JDBCUtil.getConn();
        psmt = conn.prepareStatement(sql);
        psmt.setString(1,stu.getPassword());
        psmt.setString(2,stu.getName());
        psmt.setString(3,stu.getSex());
        psmt.setInt(4,stu.getAge());
        psmt.setString(5,stu.getImage());
        psmt.setString(6,stu.getsClass());
        psmt.setString(7,stu.getDepartment());
        psmt.setString(8,stu.getPhone());
        psmt.setString(9,stu.getId());
        return psmt.executeUpdate();
    }

    @Override
    public int deleteStudent(String id) throws SQLException {
        Connection conn = null;
        PreparedStatement psmt = null;
        String sql = "delete from student where s_id = ?";
        conn = JDBCUtil.getConn();
        psmt = conn.prepareStatement(sql);
        psmt.setString(1,id);
        return psmt.executeUpdate();
    }

    @Override
    public boolean findStudent(String username, String password) throws SQLException {
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql = "select * from student where s_id = ? and s_password = ?";
        conn = JDBCUtil.getConn();
        psmt = conn.prepareStatement(sql);
        psmt.setString(1,username);
        psmt.setString(2,password);
        psmt.execute();
        rs = psmt.getResultSet();
        if(rs.next()){
            return true;
        }
        return false;
    }
}
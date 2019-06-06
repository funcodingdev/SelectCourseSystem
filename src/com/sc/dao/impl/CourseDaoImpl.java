package com.sc.dao.impl;

import com.sc.dao.ICourseDao;
import com.sc.domain.Course;
import com.sc.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/26 16:54
 */
public class CourseDaoImpl implements ICourseDao {
    @Override
    public List<Course> getAllCourse() throws SQLException {
        List<Course> courseList = null;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "select * from course";
        conn = JDBCUtil.getConn();
        st = conn.createStatement();
        st.execute(sql);
        rs = st.getResultSet();
        courseList = new ArrayList<>();
        while (rs.next()){
            Course course = new Course();
            course.setNumber(rs.getString("c_number"));
            course.setName(rs.getString("c_name"));
            course.setCredit(rs.getInt("c_credit"));
            course.setPeriod(rs.getInt("c_period"));
            course.setTheory(rs.getInt("c_theory"));
            course.setExperiment(rs.getInt("c_experiment"));
            courseList.add(course);
        }
        JDBCUtil.closeConn(conn,st,rs);
        return courseList;
    }

    @Override
    public Course getCourse(String number) throws SQLException {
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql = "select * from course where c_number = ?";
        conn = JDBCUtil.getConn();
        psmt = conn.prepareStatement(sql);
        psmt.setString(1,number);
        psmt.execute();
        rs = psmt.getResultSet();
        rs.next();
        Course course = new Course();
        course.setNumber(rs.getString("c_number"));
        course.setName(rs.getString("c_name"));
        course.setCredit(rs.getInt("c_credit"));
        course.setPeriod(rs.getInt("c_period"));
        course.setTheory(rs.getInt("c_theory"));
        course.setExperiment(rs.getInt("c_experiment"));
        JDBCUtil.closeConn(conn,psmt,rs);
        return course;
    }

    @Override
    public int insertCourse(Course course) throws SQLException {
        Connection conn = null;
        PreparedStatement psmt = null;
        String sql = "insert into course(c_number,c_name,c_credit,c_period,c_theory,c_experiment) values(?,?,?,?,?,?)";
        conn = JDBCUtil.getConn();
        psmt = conn.prepareStatement(sql);
        psmt.setString(1,course.getNumber());
        psmt.setString(2,course.getName());
        psmt.setInt(3,course.getCredit());
        psmt.setInt(4,course.getPeriod());
        psmt.setInt(5,course.getTheory());
        psmt.setInt(6,course.getExperiment());
        int i = psmt.executeUpdate();
        JDBCUtil.closeConn(conn,psmt,null);
        return i;
    }

    @Override
    public int updateCourse(Course course) throws SQLException {
        Connection conn = null;
        PreparedStatement psmt = null;
        String sql = "update course set c_name = ?,c_credit = ?,c_period = ?,c_theory = ?,c_experiment = ? where c_number = ?";
        conn = JDBCUtil.getConn();
        psmt = conn.prepareStatement(sql);
        psmt.setString(1,course.getName());
        psmt.setInt(2,course.getCredit());
        psmt.setInt(3,course.getPeriod());
        psmt.setInt(4,course.getTheory());
        psmt.setInt(5,course.getExperiment());
        psmt.setString(6,course.getNumber());
        int i = psmt.executeUpdate();
        JDBCUtil.closeConn(conn,psmt,null);
        return i;
    }

    @Override
    public int deleteCourse(String number) throws SQLException {
        Connection conn = null;
        PreparedStatement psmt = null;
        String sql = "delete from course where c_number = ?";
        conn = JDBCUtil.getConn();
        psmt = conn.prepareStatement(sql);
        psmt.setString(1,number);
        int i = psmt.executeUpdate();
        JDBCUtil.closeConn(conn,psmt,null);
        return i;
    }

    @Override
    public List<Course> getPageData(Integer start, Integer end) throws SQLException {
        List<Course> courseList = null;
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs= null;
        String sql = "SELECT * FROM(SELECT ROWNUM NO,sc.* FROM (SELECT * FROM course ORDER BY c_number ASC) sc WHERE ROWNUM<=?) WHERE NO >=?";
        conn = JDBCUtil.getConn();
        psmt = conn.prepareStatement(sql);
        psmt.setInt(2,start);
        psmt.setInt(1,end);
        psmt.execute();
        rs = psmt.getResultSet();
        courseList = new ArrayList<>();
        while (rs.next()){
            Course course = new Course();
            course.setNumber(rs.getString("c_number"));
            course.setName(rs.getString("c_name"));
            course.setCredit(rs.getInt("c_credit"));
            course.setPeriod(rs.getInt("c_period"));
            course.setTheory(rs.getInt("c_theory"));
            course.setExperiment(rs.getInt("c_experiment"));
            courseList.add(course);
        }
        JDBCUtil.closeConn(conn,psmt,rs);
        return courseList;
    }

    @Override
    public int getCourseCount() throws SQLException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs= null;
        conn = JDBCUtil.getConn();
        st = conn.createStatement();
        String sql = "select count(*) as total from course";
        st.execute(sql);
        rs = st.getResultSet();
        rs.next();
        int totalNum = rs.getInt("total");
        JDBCUtil.closeConn(conn,st,rs);
        return totalNum;
    }
}

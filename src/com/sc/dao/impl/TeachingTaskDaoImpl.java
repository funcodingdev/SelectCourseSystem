package com.sc.dao.impl;

import com.sc.dao.ITeachingTaskDao;
import com.sc.domain.SelectCourse;
import com.sc.domain.Teacher;
import com.sc.domain.TeachingTask;
import com.sc.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/27 21:04
 */
public class TeachingTaskDaoImpl implements ITeachingTaskDao {

    @Override
    public List<TeachingTask> getAllTeachingTask() throws SQLException {
        List<TeachingTask> teachingTaskList = null;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "select * from teachingTask inner join teacher on teachingTask.tt_teacherNum = teacher.t_id";
        conn = JDBCUtil.getConn();
        st = conn.createStatement();
        st.execute(sql);
        rs = st.getResultSet();
        teachingTaskList = new ArrayList<>();
        while (rs.next()){
            TeachingTask teachingTask = new TeachingTask();
            teachingTask.setTeachingTaskNum(rs.getString("TT_TEACHINGTASKNUM"));
            teachingTask.setCourseName(rs.getString("TT_COURSENAME"));
            teachingTask.setTeacherNum(rs.getString("TT_TEACHERNUM"));
            teachingTask.setLocation(rs.getString("TT_LOCATION"));
            teachingTask.setTotalNum(rs.getInt("TT_TOTALNUM"));
            teachingTask.setTeacherName(rs.getString("T_NAME"));
            teachingTaskList.add(teachingTask);
        }
        return teachingTaskList;
    }

    @Override
    public List<TeachingTask> getAllTeachingTaskExceptHave(String stuId) throws SQLException {
        List<TeachingTask> teachingTaskList = null;
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql = "select * from (select * from teachingTask inner join teacher on teachingTask.tt_teacherNum = teacher.t_id) where tt_teachingTaskNum not in (select sc_teachingTaskNum from selectCourse where sc_stuid = ?)";
        conn = JDBCUtil.getConn();
        psmt = conn.prepareStatement(sql);
        psmt.setString(1,stuId);
        psmt.execute();
        rs = psmt.getResultSet();
        teachingTaskList = new ArrayList<>();
        while (rs.next()){
            TeachingTask teachingTask = new TeachingTask();
            teachingTask.setTeachingTaskNum(rs.getString("TT_TEACHINGTASKNUM"));
            teachingTask.setCourseName(rs.getString("TT_COURSENAME"));
            teachingTask.setTeacherNum(rs.getString("TT_TEACHERNUM"));
            teachingTask.setLocation(rs.getString("TT_LOCATION"));
            teachingTask.setTotalNum(rs.getInt("TT_TOTALNUM"));
            teachingTask.setTeacherName(rs.getString("T_NAME"));
            teachingTaskList.add(teachingTask);
        }
        return teachingTaskList;
    }

    @Override
    public List<TeachingTask> getAllTeachingTaskToTea(String teacherId) throws SQLException {
        List<TeachingTask> teachingTaskList = null;
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql = "select * from teachingTask where tt_teacherNum = ?";
        conn = JDBCUtil.getConn();
        psmt = conn.prepareStatement(sql);
        psmt.setString(1,teacherId);
        psmt.execute();
        rs = psmt.getResultSet();
        teachingTaskList = new ArrayList<>();
        while (rs.next()){
            TeachingTask teachingTask = new TeachingTask();
            teachingTask.setTeachingTaskNum(rs.getString("TT_TEACHINGTASKNUM"));
            teachingTask.setCourseName(rs.getString("TT_COURSENAME"));
            teachingTask.setTeacherNum(rs.getString("TT_TEACHERNUM"));
            teachingTask.setLocation(rs.getString("TT_LOCATION"));
            teachingTask.setTotalNum(rs.getInt("TT_TOTALNUM"));
            teachingTaskList.add(teachingTask);
        }
        JDBCUtil.closeConn(conn,psmt,rs);
        return teachingTaskList;
    }

    @Override
    public TeachingTask getTeachingTask(String teachingTaskNum) throws SQLException {
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs= null;
        String sql = "select * from teachingTask where tt_teachingTaskNum = ?";
        conn = JDBCUtil.getConn();
        psmt = conn.prepareStatement(sql);
        psmt.setString(1,teachingTaskNum);
        psmt.execute();
        rs = psmt.getResultSet();
        rs.next();
        TeachingTask teachingTask = new TeachingTask();
        teachingTask.setTeachingTaskNum(rs.getString("TT_TEACHINGTASKNUM"));
        teachingTask.setCourseName(rs.getString("TT_COURSENAME"));
        teachingTask.setTeacherNum(rs.getString("TT_TEACHERNUM"));
        teachingTask.setLocation(rs.getString("TT_LOCATION"));
        teachingTask.setTotalNum(rs.getInt("TT_TOTALNUM"));
        JDBCUtil.closeConn(conn,psmt,rs);
        return teachingTask;
    }

    @Override
    public int insertTeachingTask(TeachingTask teachingTask) throws SQLException {
        Connection conn = null;
        PreparedStatement psmt = null;
        String sql = "insert into teachingTask(TT_TEACHINGTASKNUM,TT_COURSENAME,TT_TEACHERNUM,TT_LOCATION) values(?,?,?,?)";
        conn = JDBCUtil.getConn();
        psmt = conn.prepareStatement(sql);
        psmt.setString(1,teachingTask.getTeachingTaskNum());
        psmt.setString(2,teachingTask.getCourseName());
        psmt.setString(3,teachingTask.getTeacherNum());
        psmt.setString(4,teachingTask.getLocation());
        int i = psmt.executeUpdate();
        JDBCUtil.closeConn(conn,psmt,null);
        return i;
    }

    @Override
    public int updateTeachingTask(TeachingTask teachingTask) throws SQLException {
        Connection conn = null;
        PreparedStatement psmt = null;
        String sql = "update teachingTask " +
                "set TT_COURSENAME = ?,TT_TEACHERNUM = ?,TT_LOCATION = ?,TT_TOTALNUM = ? where TT_TEACHINGTASKNUM = ?";
        conn = JDBCUtil.getConn();
        psmt = conn.prepareStatement(sql);
        psmt.setString(1,teachingTask.getCourseName());
        psmt.setString(2,teachingTask.getTeacherNum());
        psmt.setString(3,teachingTask.getLocation());
        psmt.setInt(4,teachingTask.getTotalNum());
        psmt.setString(5,teachingTask.getTeachingTaskNum());
        int i = psmt.executeUpdate();
        JDBCUtil.closeConn(conn,psmt,null);
        return i;
    }

    @Override
    public int deleteTeachingTask(String teachingTaskNum) throws SQLException {
        Connection conn = null;
        PreparedStatement psmt = null;
        String sql = "delete from teachingTask where TT_TEACHINGTASKNUM = ?";
        conn = JDBCUtil.getConn();
        psmt = conn.prepareStatement(sql);
        psmt.setString(1,teachingTaskNum);
        int i = psmt.executeUpdate();
        JDBCUtil.closeConn(conn,psmt,null);
        return i;
    }

    @Override
    public List<TeachingTask> getPageData(Integer start, Integer end) throws SQLException {
        List<TeachingTask> teachingTaskList = null;
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs= null;
        String sql = "SELECT * FROM(SELECT ROWNUM NO,s.* FROM (SELECT * FROM teachingTask ORDER BY TT_TEACHINGTASKNUM ASC) s WHERE ROWNUM<=?) WHERE NO >=?";
        conn = JDBCUtil.getConn();
        psmt = conn.prepareStatement(sql);
        psmt.setInt(2,start);
        psmt.setInt(1,end);
        psmt.execute();
        rs = psmt.getResultSet();
        teachingTaskList = new ArrayList<>();
        while (rs.next()){
            TeachingTask teachingTask = new TeachingTask();
            teachingTask.setTeachingTaskNum(rs.getString("TT_TEACHINGTASKNUM"));
            teachingTask.setCourseName(rs.getString("TT_COURSENAME"));
            teachingTask.setTeacherNum(rs.getString("TT_TEACHERNUM"));
            teachingTask.setLocation(rs.getString("TT_LOCATION"));
            teachingTask.setTotalNum(rs.getInt("TT_TOTALNUM"));
            teachingTaskList.add(teachingTask);
        }
        JDBCUtil.closeConn(conn,psmt,rs);
        return teachingTaskList;
    }

    @Override
    public int geTeachingTaskCount() throws SQLException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs= null;
        conn = JDBCUtil.getConn();
        st = conn.createStatement();
        String sql = "select count(*) as total from teachingTask";
        st.execute(sql);
        rs = st.getResultSet();
        rs.next();
        int totalNum = rs.getInt("total");
        JDBCUtil.closeConn(conn,st,rs);
        return totalNum;
    }

}

package com.sc.dao.impl;

import com.sc.dao.ISelectCourseDao;
import com.sc.domain.SelectCourse;
import com.sc.domain.TeachingTask;
import com.sc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/28 15:36
 */
public class SelectCourseDaoImpl implements ISelectCourseDao {

    @Override
    public List<SelectCourse> getSelectCourse(String stuId) throws SQLException {
        List<SelectCourse> selectCourseList = null;
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql = "select * from selectCourse inner join teachingTask on selectCourse.sc_teachingTaskNum = teachingTask.tt_teachingTaskNum where sc_stuid = ?";
        conn = JDBCUtil.getConn();
        psmt = conn.prepareStatement(sql);
        psmt.setString(1,stuId);
        psmt.execute();
        rs = psmt.getResultSet();
        selectCourseList = new ArrayList<>();
        while (rs.next()){
            SelectCourse selectCourse = new SelectCourse();
            selectCourse.setStuId(stuId);
            selectCourse.setTeachingTaskNum(rs.getString("sc_teachingTaskNum"));
            selectCourse.setGrade(rs.getDouble("sc_grade"));
            TeachingTask teachingTask = new TeachingTask();
            teachingTask.setCourseName(rs.getString("TT_COURSENAME"));
            teachingTask.setTeacherNum(rs.getString("TT_TEACHERNUM"));
            teachingTask.setLocation(rs.getString("TT_LOCATION"));
            teachingTask.setTotalNum(rs.getInt("TT_TOTALNUM"));
//            teachingTask.setTeacherName(rs.getString("T_NAME"));
            selectCourse.setTeachingTask(teachingTask);
            selectCourseList.add(selectCourse);
        }
        JDBCUtil.closeConn(conn,psmt,rs);
        return selectCourseList;
    }

    @Override
    public int insertSelectCourse(SelectCourse selectCourse) throws SQLException {
        Connection conn = null;
        PreparedStatement psmt = null;
        String sql = "insert into selectCourse(sc_stuid,sc_teachingTaskNum) values(?,?)";
        conn = JDBCUtil.getConn();
        psmt = conn.prepareStatement(sql);
        psmt.setString(1,selectCourse.getStuId());
        psmt.setString(2,selectCourse.getTeachingTaskNum());
        int i = psmt.executeUpdate();
        JDBCUtil.closeConn(conn,psmt,null);
        return i;
    }

    @Override
    public int deleteSelectCourse(SelectCourse selectCourse) throws SQLException {
        Connection conn = null;
        PreparedStatement psmt = null;
        String sql = "delete from selectCourse where sc_stuid = ? and sc_teachingTaskNum = ?";
        conn = JDBCUtil.getConn();
        psmt = conn.prepareStatement(sql);
        psmt.setString(1,selectCourse.getStuId());
        psmt.setString(2,selectCourse.getTeachingTaskNum());
        int i = psmt.executeUpdate();
        JDBCUtil.closeConn(conn,psmt,null);
        return i;
    }
}

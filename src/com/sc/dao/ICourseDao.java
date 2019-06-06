package com.sc.dao;

import com.sc.domain.Course;
import com.sc.domain.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/26 16:52
 */
public interface ICourseDao {
    List<Course> getAllCourse() throws SQLException;//获取所有课程
    Course getCourse(String number) throws SQLException;//获取某个课程
    int insertCourse(Course course) throws SQLException;//插入课程
    int updateCourse(Course course) throws SQLException;//更新课程
    int deleteCourse(String number) throws SQLException;//删除课程
    List<Course> getPageData(Integer start, Integer end) throws SQLException;
    int getCourseCount() throws SQLException;
}

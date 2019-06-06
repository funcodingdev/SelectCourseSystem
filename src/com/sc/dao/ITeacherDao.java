package com.sc.dao;

import com.sc.domain.Student;
import com.sc.domain.Teacher;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/25 15:36
 */
public interface ITeacherDao {
    List<Teacher> getAllTeacher() throws SQLException;//获取所有教师
    Teacher getTeacher(String id) throws SQLException;//获取一个教师
    int insertTeacher(Teacher teacher) throws SQLException;//添加一个教师
    int updateTeacher(Teacher teacher) throws SQLException;//修改教师信息
    int deleteTeacher(String id) throws SQLException;//删除教师
    boolean findTeacher(String username,String password) throws SQLException;//查询是否有该教师
    List<Teacher> getPageData(Integer start, Integer end) throws SQLException;
    int getTeacherCount() throws SQLException;
}

package com.sc.dao;

import com.sc.domain.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/25 15:31
 */
public interface IStudentDao {
    List<Student> getAllStudent() throws SQLException;//获取所有学生
    Student getStudent(String id) throws SQLException;//根据学号获取某个学生
    int insertStudent(Student stu) throws SQLException;//插入学生
    int updateStudent(Student stu) throws SQLException;//修改学生信息
    int deleteStudent(String id) throws SQLException;//删除学生
    boolean findStudent(String username,String password) throws SQLException;//查询是否有这个学生
    List<Student> getPageData(Integer start, Integer end) throws SQLException;//获取当前页的数据
    int getStudentCount() throws SQLException;//获取所有学生个数
}

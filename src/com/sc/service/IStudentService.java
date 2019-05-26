package com.sc.service;

import com.sc.domain.Student;

import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/25 15:31
 */
public interface IStudentService {
    List<Student> getAllStudent();//获取所有学生
    Student getStudent(String id);//根据学号获取某个学生
    boolean insertStudent(Student stu);//插入学生
    boolean updateStudent(Student stu);//修改学生信息
    boolean deleteStudent(String id);//删除学生
    boolean findStudent(String username, String password);//查询是否有这个学生
}

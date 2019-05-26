package com.sc.service;

import com.sc.domain.Teacher;

import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/25 15:36
 */
public interface ITeacherService {
    List<Teacher> getAllTeacher();//获取所有教师
    Teacher getTeacher(String id);//获取一个教师
    boolean insertTeacher(Teacher teacher);//添加一个教师
    boolean updateTeacher(Teacher teacher);//修改教师信息
    boolean deleteTeacher(String id);//删除教师
    boolean findTeacher(String username, String password);//查询是否有该教师
}

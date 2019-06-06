package com.sc.service;

import com.sc.domain.Course;
import com.sc.domain.PageBean;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/26 17:23
 */
public interface ICourseService {
    List<Course> getAllCourse();//获取所有课程
    Course getCourse(String number);//获取某个课程
    boolean insertCourse(Course course);//插入课程
    boolean updateCourse(Course course);//更新课程
    boolean deleteCourse(String number);//删除课程
    PageBean<Course> getPageBean(Integer currentPage);
    int getStudentCount();
}

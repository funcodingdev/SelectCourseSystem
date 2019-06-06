package com.sc.dao;

import com.sc.domain.SelectCourse;
import com.sc.domain.TeachingTask;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/27 21:01
 */
public interface ITeachingTaskDao {
    List<TeachingTask> getAllTeachingTask() throws SQLException;
    List<TeachingTask> getAllTeachingTaskExceptHave(String stuId) throws SQLException;//获取所有选课计划，除了此学生的
    List<TeachingTask> getAllTeachingTaskToTea(String teacherId) throws SQLException;//获取此教师的所有选课计划
    TeachingTask getTeachingTask(String teachingTaskNum) throws SQLException;
    int insertTeachingTask(TeachingTask teachingTask) throws SQLException;
    int updateTeachingTask(TeachingTask teachingTask) throws SQLException;
    int deleteTeachingTask(String teachingTaskNum) throws SQLException;
    List<TeachingTask> getPageData(Integer start, Integer end) throws SQLException;
    int geTeachingTaskCount() throws SQLException;
}

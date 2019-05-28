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
    List<TeachingTask> getAllTeachingTaskExcept(String stuId) throws SQLException;
    TeachingTask getTeachingTask(String teachingTaskNum) throws SQLException;
    int insertTeachingTask(TeachingTask teachingTask) throws SQLException;
    int updateTeachingTask(TeachingTask teachingTask) throws SQLException;
    int deleteTeachingTask(String teachingTaskNum) throws SQLException;
}

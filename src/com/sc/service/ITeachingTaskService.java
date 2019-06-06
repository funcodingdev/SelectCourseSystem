package com.sc.service;

import com.sc.domain.PageBean;
import com.sc.domain.Teacher;
import com.sc.domain.TeachingTask;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/27 21:01
 */
public interface ITeachingTaskService {
    List<TeachingTask> getAllTeachingTask();
    List<TeachingTask> getAllTeachingTaskExcept(String stuId);
    List<TeachingTask> getAllTeachingTaskToTea(String teacherId);
    TeachingTask getTeachingTask(String teachingTaskNum);
    boolean insertTeachingTask(TeachingTask teachingTask);
    boolean updateTeachingTask(TeachingTask teachingTask);
    boolean deleteTeachingTask(String teachingTaskNum);
    PageBean<TeachingTask> getPageBean(Integer currentPage);
    int getTeachingTaskCount();
}

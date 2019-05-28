package com.sc.service.impl;

import com.sc.dao.DaoFactory;
import com.sc.dao.ITeachingTaskDao;
import com.sc.domain.TeachingTask;
import com.sc.service.ITeachingTaskService;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/27 21:12
 */
public class TeachingTaskServiceImpl implements ITeachingTaskService {
    private ITeachingTaskDao teachingTaskDao;

    @Override
    public List<TeachingTask> getAllTeachingTask() {
        teachingTaskDao = DaoFactory.getTeachingTaskDao();
        try {
            return teachingTaskDao.getAllTeachingTask();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TeachingTask> getAllTeachingTaskExcept(String stuId) {
        teachingTaskDao = DaoFactory.getTeachingTaskDao();
        try {
            return teachingTaskDao.getAllTeachingTaskExcept(stuId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TeachingTask getTeachingTask(String teachingTaskNum) {
        teachingTaskDao = DaoFactory.getTeachingTaskDao();
        try {
            return teachingTaskDao.getTeachingTask(teachingTaskNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertTeachingTask(TeachingTask teachingTask) {
        teachingTaskDao = DaoFactory.getTeachingTaskDao();
        try {
            if(teachingTaskDao.insertTeachingTask(teachingTask) > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateTeachingTask(TeachingTask teachingTask) {
        teachingTaskDao = DaoFactory.getTeachingTaskDao();
        try {
            if(teachingTaskDao.updateTeachingTask(teachingTask) > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteTeachingTask(String teachingTaskNum) {
        teachingTaskDao = DaoFactory.getTeachingTaskDao();
        try {
            if(teachingTaskDao.deleteTeachingTask(teachingTaskNum) > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

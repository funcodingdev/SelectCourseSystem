package com.sc.service.impl;

import com.sc.dao.DaoFactory;
import com.sc.dao.ITeachingTaskDao;
import com.sc.domain.PageBean;
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
            return teachingTaskDao.getAllTeachingTaskExceptHave(stuId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TeachingTask> getAllTeachingTaskToTea(String teacherId) {
        teachingTaskDao = DaoFactory.getTeachingTaskDao();
        try {
            return teachingTaskDao.getAllTeachingTaskToTea(teacherId);
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

    @Override
    public PageBean<TeachingTask> getPageBean(Integer currentPage) {
        teachingTaskDao = DaoFactory.getTeachingTaskDao();
        PageBean<TeachingTask> pageBean = null;
        try {
            pageBean = new PageBean<>();
            pageBean.setTotalCount(teachingTaskDao.geTeachingTaskCount());//设置总数量
            pageBean.setCurrentPage(currentPage);//设置当前页
            pageBean.setList(teachingTaskDao.getPageData(pageBean.getStart(),pageBean.getEnd()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pageBean;
    }

    @Override
    public int getTeachingTaskCount() {
        teachingTaskDao = DaoFactory.getTeachingTaskDao();
        try {
            return teachingTaskDao.geTeachingTaskCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

package com.sc.service.impl;

import com.sc.dao.DaoFactory;
import com.sc.dao.ITeacherDao;
import com.sc.domain.PageBean;
import com.sc.domain.Student;
import com.sc.domain.Teacher;
import com.sc.service.ITeacherService;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/25 15:46
 */
public class TeacherServiceImpl implements ITeacherService {
    private ITeacherDao teacherDao;
    @Override
    public List<Teacher> getAllTeacher() {
        teacherDao = DaoFactory.getTeacherDao();
        try {
            return teacherDao.getAllTeacher();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Teacher getTeacher(String id) {
        teacherDao = DaoFactory.getTeacherDao();
        try {
            return teacherDao.getTeacher(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertTeacher(Teacher teacher) {
        teacherDao = DaoFactory.getTeacherDao();
        try {
            if(teacherDao.insertTeacher(teacher) > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        teacherDao = DaoFactory.getTeacherDao();
        try {
            if(teacherDao.updateTeacher(teacher) > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteTeacher(String id) {
        teacherDao = DaoFactory.getTeacherDao();
        try {
            if(teacherDao.deleteTeacher(id) > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean findTeacher(String username, String password) {
        teacherDao = DaoFactory.getTeacherDao();
        try {
            return teacherDao.findTeacher(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public PageBean<Teacher> getPageBean(Integer currentPage) {
        teacherDao = DaoFactory.getTeacherDao();
        PageBean<Teacher> pageBean = null;
        try {
            pageBean = new PageBean<>();
            pageBean.setTotalCount(teacherDao.getTeacherCount());//设置总数量
            pageBean.setCurrentPage(currentPage);//设置当前页
            pageBean.setList(teacherDao.getPageData(pageBean.getStart(),pageBean.getEnd()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pageBean;
    }

    @Override
    public int getTeacherCount() {
        teacherDao = DaoFactory.getTeacherDao();
        try {
            return teacherDao.getTeacherCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

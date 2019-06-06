package com.sc.service.impl;

import com.sc.dao.DaoFactory;
import com.sc.dao.IStudentDao;
import com.sc.domain.Student;
import com.sc.service.IStudentService;
import com.sc.domain.PageBean;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/25 15:46
 */
public class StudentServiceImpl implements IStudentService {
    private IStudentDao studentDao;
    @Override
    public List<Student> getAllStudent() {
        studentDao = DaoFactory.getStudentDao();
        try {
            return studentDao.getAllStudent();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PageBean<Student> getPageBean(Integer currentPage) {
        studentDao = DaoFactory.getStudentDao();
        PageBean<Student> pageBean = null;
        try {
            pageBean = new PageBean<>();
            pageBean.setTotalCount(studentDao.getStudentCount());//设置总数量
            pageBean.setCurrentPage(currentPage);//设置当前页
            pageBean.setList(studentDao.getPageData(pageBean.getStart(),pageBean.getEnd()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pageBean;
    }

    @Override
    public Student getStudent(String id) {
        studentDao = DaoFactory.getStudentDao();
        try {
            return studentDao.getStudent(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertStudent(Student stu) {
        studentDao = DaoFactory.getStudentDao();
        try {
            if(studentDao.insertStudent(stu) > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateStudent(Student stu) {
        studentDao = DaoFactory.getStudentDao();
        try {
            if(studentDao.updateStudent(stu) > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteStudent(String id) {
        studentDao = DaoFactory.getStudentDao();
        try {
            if(studentDao.deleteStudent(id) > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean findStudent(String username, String password) {
        studentDao = DaoFactory.getStudentDao();
        try {
            return studentDao.findStudent(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int getStudentCount() {
        studentDao = DaoFactory.getStudentDao();
        try {
            return studentDao.getStudentCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

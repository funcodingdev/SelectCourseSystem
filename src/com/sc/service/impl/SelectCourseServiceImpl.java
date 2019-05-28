package com.sc.service.impl;

import com.sc.dao.DaoFactory;
import com.sc.dao.ISelectCourseDao;
import com.sc.domain.SelectCourse;
import com.sc.service.ISelectCourseService;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/28 16:08
 */
public class SelectCourseServiceImpl implements ISelectCourseService {
    private ISelectCourseDao selectCourseDao;

    @Override
    public List<SelectCourse> getSelectCourse(String stuId) {
        selectCourseDao = DaoFactory.getSelectCourseDao();
        try {
            return selectCourseDao.getSelectCourse(stuId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertSelectCourse(SelectCourse selectCourse) {
        selectCourseDao = DaoFactory.getSelectCourseDao();
        try {
            if(selectCourseDao.insertSelectCourse(selectCourse) > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteSelectCourse(SelectCourse selectCourse) {
        selectCourseDao = DaoFactory.getSelectCourseDao();
        try {
            if(selectCourseDao.deleteSelectCourse(selectCourse) > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

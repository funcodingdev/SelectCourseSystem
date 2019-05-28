package com.sc.dao;

import com.sc.domain.SelectCourse;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/28 15:03
 */
public interface ISelectCourseDao {
    List<SelectCourse> getSelectCourse(String stuId) throws SQLException;
    int insertSelectCourse(SelectCourse selectCourse) throws SQLException;
    int deleteSelectCourse(SelectCourse selectCourse) throws SQLException;
}

package com.sc.service;

import com.sc.domain.SelectCourse;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/28 15:03
 */
public interface ISelectCourseService {
    List<SelectCourse> getSelectCourse(String stuId);
    boolean insertSelectCourse(SelectCourse selectCourse);
    boolean deleteSelectCourse(SelectCourse selectCourse);
}

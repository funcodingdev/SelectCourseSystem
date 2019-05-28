package com.sc.test;

import com.sc.dao.DaoFactory;
import com.sc.domain.SelectCourse;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: fangju
 * @Date: 2019/5/28 15:42
 */
public class SelectCourseDaoImplTest {

    @Test
    public void getSelectCourse() {
        try {
            List<SelectCourse> selectCourse = DaoFactory.getSelectCourseDao().getSelectCourse("1");
            System.out.println(selectCourse);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
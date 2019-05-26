package com.sc.test;

import com.sc.dao.DaoFactory;
import com.sc.domain.Course;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: fangju
 * @Date: 2019/5/26 17:21
 */
public class CourseDaoImplTest {

    @Test
    public void getAllCourse() {
        try {
            List<Course> allCourse = DaoFactory.getCourseDao().getAllCourse();
            System.out.println(allCourse);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getCourse() {
    }

    @Test
    public void insertCourse() {
    }

    @Test
    public void updateCourse() {
    }

    @Test
    public void deleteCourse() {
    }
}
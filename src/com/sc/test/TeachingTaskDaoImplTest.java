package com.sc.test;

import com.sc.dao.DaoFactory;
import com.sc.domain.SelectCourse;
import com.sc.domain.TeachingTask;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: fangju
 * @Date: 2019/5/27 21:08
 */
public class TeachingTaskDaoImplTest {

    @Test
    public void getAllTeachingTask() {
        try {
            List<TeachingTask> allTeachingTask = DaoFactory.getTeachingTaskDao().getAllTeachingTask();
            System.out.println(allTeachingTask);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTeachingTask() {
    }

    @Test
    public void insertTeachingTask() {
        TeachingTask teachingTask = new TeachingTask("123","1","1","6110",0);
        try {
            DaoFactory.getTeachingTaskDao().insertTeachingTask(teachingTask);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateTeachingTask() {
    }

    @Test
    public void deleteTeachingTask() {
    }
}
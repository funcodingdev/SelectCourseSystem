package com.sc.test;

import com.sc.dao.DaoFactory;
import com.sc.domain.Student;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: fangju
 * @Date: 2019/5/25 17:22
 */
public class StudentDaoImplTest {

    @Test
    public void getAllStudent() {
        try {
            List<Student> allStudent = DaoFactory.getStudentDao().getAllStudent();
            System.out.println(allStudent);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getStudent() {
        try {
            Student stu = DaoFactory.getStudentDao().getStudent("9512101");
            System.out.println(stu.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertStudent() {
    }

    @Test
    public void updateStudent() {
    }

    @Test
    public void deleteStudent() {
    }

    @Test
    public void findStudent() {
        try {
            int i = 1/0;
            System.out.println(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(false);
    }
}
package com.sc.dao;

import com.sc.dao.IAdminDao;
import com.sc.dao.IStudentDao;
import com.sc.dao.ITeacherDao;
import com.sc.dao.impl.AdminDaoImpl;
import com.sc.dao.impl.CourseDaoImpl;
import com.sc.dao.impl.StudentDaoImpl;
import com.sc.dao.impl.TeacherDaoImpl;

/**
 * @Author: fangju
 * @Date: 2019/5/25 15:46
 */
public class DaoFactory {
    public static IStudentDao getStudentDao(){
        return new StudentDaoImpl();
    }
    public static IAdminDao getAdminDao(){
        return new AdminDaoImpl();
    }
    public static ITeacherDao getTeacherDao(){
        return new TeacherDaoImpl();
    }
    public static ICourseDao getCourseDao(){
        return new CourseDaoImpl();
    }
}

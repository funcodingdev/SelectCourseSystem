package com.sc.dao;

import com.sc.dao.IAdminDao;
import com.sc.dao.IStudentDao;
import com.sc.dao.ITeacherDao;
import com.sc.dao.impl.*;

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
    public static ITeachingTaskDao getTeachingTaskDao(){
        return new TeachingTaskDaoImpl();
    }
    public static IDepartmentDao getDepartmentDao(){
        return new DepartmentDaoImpl();
    }

    public static ISClassDao getSClassDao() {
        return new SClassDaoImpl();
    }

    public static ISelectCourseDao getSelectCourseDao(){
        return new SelectCourseDaoImpl();
    }
}

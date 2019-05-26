package com.sc.service;

import com.sc.dao.ICourseDao;
import com.sc.dao.impl.CourseDaoImpl;
import com.sc.service.impl.AdminServiceImpl;
import com.sc.service.impl.CourseServiceImpl;
import com.sc.service.impl.StudentServiceImpl;
import com.sc.service.impl.TeacherServiceImpl;

/**
 * @Author: fangju
 * @Date: 2019/5/25 15:49
 */
public class ServiceFactory {
    public static IStudentService getStudentService(){
        return new StudentServiceImpl();
    }
    public static IAdminService getAdminService(){
        return new AdminServiceImpl();
    }
    public static ITeacherService getTeacherService(){
        return new TeacherServiceImpl();
    }
    public static ICourseService getCourseService(){
        return new CourseServiceImpl();
    }
}

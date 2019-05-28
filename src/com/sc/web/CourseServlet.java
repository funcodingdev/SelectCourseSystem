package com.sc.web;

import com.sc.domain.Course;
import com.sc.service.ICourseService;
import com.sc.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/26 16:26
 */
@WebServlet("/CourseServlet")
public class CourseServlet extends BaseServlet {
    private ICourseService courseService;

    public String getAllCourse(HttpServletRequest request,HttpServletResponse response){
        courseService = ServiceFactory.getCourseService();
        List<Course> allCourse = courseService.getAllCourse();
        request.setAttribute("allCourse",allCourse);
        return DISPATCHER+":"+"/admin/courseInfo.jsp";
    }

    public String updateCourseUi(HttpServletRequest request,HttpServletResponse response){
        courseService = ServiceFactory.getCourseService();
        String number = request.getParameter("number");
        Course course = courseService.getCourse(number);
        if(course != null){
            request.setAttribute("course",course);
            return DISPATCHER+":"+"/admin/updateCourse.jsp";
        }
        return DISPATCHER+":"+"/admin/courseInfo.jsp";
    }

    public String updateCourse(HttpServletRequest request,HttpServletResponse response){
        courseService = ServiceFactory.getCourseService();
        String number = request.getParameter("number");
        String name = request.getParameter("name");
        String credit = request.getParameter("credit");
        String period = request.getParameter("period");
        String theory = request.getParameter("theory");
        String experiment = request.getParameter("experiment");
        Course course = new Course(number,name,Integer.parseInt(credit),
                Integer.parseInt(period),Integer.parseInt(theory),Integer.parseInt(experiment));
        if(courseService.updateCourse(course)){
            return DISPATCHER+":"+"/CourseServlet?action=getAllCourse";
        }
        return DISPATCHER+":"+"/admin/courseInfo.jsp";
    }

    public String deleteCourse(HttpServletRequest request,HttpServletResponse response){
        courseService = ServiceFactory.getCourseService();
        String number = request.getParameter("number");
        if(courseService.deleteCourse(number)){
            return DISPATCHER+":"+"/CourseServlet?action=getAllCourse";
        }
        return DISPATCHER +":"+"/admin/courseInfo.jsp";
    }

    public String insertCourse(HttpServletRequest request,HttpServletResponse response){
        courseService = ServiceFactory.getCourseService();
        String number = request.getParameter("number");
        String name = request.getParameter("name");
        String credit = request.getParameter("credit");
        String period = request.getParameter("period");
        String theory = request.getParameter("theory");
        String experiment = request.getParameter("experiment");
        Course course = new Course(number,name,Integer.parseInt(credit),
                Integer.parseInt(period),Integer.parseInt(theory),Integer.parseInt(experiment));
        if(courseService.insertCourse(course)){
            return DISPATCHER+":"+"/CourseServlet?action=getAllCourse";
        }
        request.setAttribute("error","插入失败！");
        return DISPATCHER +":"+"/admin/insertCourse.jsp";
    }
}

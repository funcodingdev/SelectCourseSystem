package com.sc.web;

import com.sc.domain.Course;
import com.sc.domain.PageBean;
import com.sc.domain.Student;
import com.sc.service.ICourseService;
import com.sc.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
//        List<Course> allCourse = courseService.getAllCourse();
//        request.setAttribute("allCourse",allCourse);
        String currentPage = request.getParameter("currentPage");
        PageBean<Course> pageBean = courseService.getPageBean(Integer.parseInt(currentPage));
        request.setAttribute("pageBean", pageBean);
        HttpSession session = request.getSession();
        session.setAttribute("currentPage", Integer.parseInt(currentPage));
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
            HttpSession session = request.getSession();
            int currentPage = (int) session.getAttribute("currentPage");
            return DISPATCHER+":"+"/CourseServlet?action=getAllCourse&currentPage="+currentPage;
        }
        return DISPATCHER+":"+"/admin/courseInfo.jsp";
    }

    public String deleteCourse(HttpServletRequest request,HttpServletResponse response){
        courseService = ServiceFactory.getCourseService();
        String number = request.getParameter("number");
        if(courseService.deleteCourse(number)){
            HttpSession session = request.getSession();
            int currentPage = (int) session.getAttribute("currentPage");
            int totalPage = PageBean.getTotalPage(courseService.getStudentCount());
            int indexPage = currentPage;//索引页为当前页
            if (currentPage >= totalPage) {
                indexPage = totalPage;
            }
            return DISPATCHER+":"+"/CourseServlet?action=getAllCourse&currentPage="+indexPage;
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
            return DISPATCHER+":"+"/CourseServlet?action=getAllCourse&currentPage=1";
        }
        request.setAttribute("error","插入失败！");
        return DISPATCHER +":"+"/admin/insertCourse.jsp";
    }
}

package com.sc.web;

import com.sc.domain.SelectCourse;
import com.sc.domain.Student;
import com.sc.domain.TeachingTask;
import com.sc.service.ISelectCourseService;
import com.sc.service.ServiceFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/28 14:48
 */
@WebServlet("/SelectCourseServlet")
public class SelectCourseServlet extends BaseServlet {
    private ISelectCourseService selectCourseService;

    public String selectCourseUi(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("obj");
        List<TeachingTask> allTeachingTask = ServiceFactory.getTeachingTaskService().getAllTeachingTaskExcept(student.getId());
        request.setAttribute("allTeachingTask",allTeachingTask);
        return DISPATCHER+":"+"/student/selectCourse.jsp";
    }

    public String selectCourse(HttpServletRequest request, HttpServletResponse response){
        selectCourseService = ServiceFactory.getSelectCourseService();
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("obj");
        String teachingTaskNum = request.getParameter("teachingTaskNum");
        SelectCourse selectCourse = new SelectCourse(student.getId(),teachingTaskNum,0.0);
        if(selectCourseService.insertSelectCourse(selectCourse)){
            return DISPATCHER+":"+"/SelectCourseServlet?action=selectCourseUi";
        }
        return DISPATCHER+":"+"/SelectCourseServlet?action=selectCourseUi";
    }


    public String retireCourseUi(HttpServletRequest request, HttpServletResponse response){
        selectCourseService = ServiceFactory.getSelectCourseService();
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("obj");
        List<SelectCourse> allSelectCourse = selectCourseService.getSelectCourseByStuId(student.getId());
        request.setAttribute("allSelectCourse",allSelectCourse);
        return DISPATCHER+":"+"/student/retireCourse.jsp";
    }

    public String retireCourse(HttpServletRequest request, HttpServletResponse response){
        selectCourseService = ServiceFactory.getSelectCourseService();
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("obj");
        String teachingTaskNum = request.getParameter("teachingTaskNum");
        SelectCourse selectCourse = new SelectCourse(student.getId(),teachingTaskNum,0.0);
        if(selectCourseService.deleteSelectCourse(selectCourse)){
            return DISPATCHER+":"+"/SelectCourseServlet?action=retireCourseUi";
        }
        return DISPATCHER+":"+"/SelectCourseServlet?action=retireCourseUi";
    }

    public String showStuInfoByTTNum(HttpServletRequest request, HttpServletResponse response){
        selectCourseService = ServiceFactory.getSelectCourseService();
        String teachingTaskNum = request.getParameter("teachingTaskNum");
        List<SelectCourse> allSelectCourse = selectCourseService.getSelectCourseByTTNum(teachingTaskNum);
        request.setAttribute("allSelectCourse",allSelectCourse);
        return DISPATCHER+":"+"/teacher/studentInfo.jsp";
    }

}

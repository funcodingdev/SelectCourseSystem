package com.sc.web;

import com.sc.domain.Course;
import com.sc.domain.Teacher;
import com.sc.domain.TeachingTask;
import com.sc.service.ITeachingTaskService;
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
 * @Date: 2019/5/27 20:56
 */
@WebServlet("/TeachingTaskServlet")
public class TeachingTaskServlet extends BaseServlet {
    private ITeachingTaskService teachingTaskService;

    public String getAllTeachingTask(HttpServletRequest request,HttpServletResponse response){
        teachingTaskService = ServiceFactory.getTeachingTaskService();
        List<TeachingTask> allTeachingTask = teachingTaskService.getAllTeachingTask();
        request.setAttribute("allTeachingTask",allTeachingTask);
        return DISPATCHER+":"+"/admin/teachingTaskInfo.jsp";
    }

    public String updateTeachingTaskUi(HttpServletRequest request,HttpServletResponse response){
        teachingTaskService = ServiceFactory.getTeachingTaskService();
        String teachingTaskNum = request.getParameter("teachingTaskNum");
        TeachingTask teachingTask = teachingTaskService.getTeachingTask(teachingTaskNum);
        request.setAttribute("teachingTask",teachingTask);
        return DISPATCHER+":"+"/admin/updateTeachingTask.jsp";
    }

    public String updateTeachingTask(HttpServletRequest request,HttpServletResponse response){
        teachingTaskService = ServiceFactory.getTeachingTaskService();
        String teachingTaskNum = request.getParameter("teachingTaskNum");
        String courseName = request.getParameter("courseName");
        String teacherNum = request.getParameter("teacherNum");
        String location = request.getParameter("location");
        String totalNum = request.getParameter("totalNum");
        TeachingTask teachingTask = new TeachingTask(teachingTaskNum,courseName,teacherNum,location,Integer.valueOf(totalNum));
        if(teachingTaskService.updateTeachingTask(teachingTask)){
            return DISPATCHER+":"+"/TeachingTaskServlet?action=getAllTeachingTask";
        }
        request.setAttribute("error","更新失败！");
        return DISPATCHER+":"+"/admin/updateTeachingTask.jsp";
    }

    public String deleteTeachingTask(HttpServletRequest request,HttpServletResponse response){
        teachingTaskService = ServiceFactory.getTeachingTaskService();
        String teachingTaskNum = request.getParameter("teachingTaskNum");
        if(teachingTaskService.deleteTeachingTask(teachingTaskNum)){
            return DISPATCHER+":"+"/TeachingTaskServlet?action=getAllTeachingTask";
        }
        request.setAttribute("error","删除失败！");
        return DISPATCHER+":"+"/admin/teachingTaskInfo.jsp";
    }

    public String insertTeachingTaskUi(HttpServletRequest request,HttpServletResponse response){
        List<Course> allCourse = ServiceFactory.getCourseService().getAllCourse();
        List<Teacher> allTeacher = ServiceFactory.getTeacherService().getAllTeacher();
        request.setAttribute("allCourse",allCourse);
        request.setAttribute("allTeacher",allTeacher);
        return DISPATCHER+":"+"/admin/insertTeachingTask.jsp";
    }

    public String insertTeachingTask(HttpServletRequest request,HttpServletResponse response){
        teachingTaskService = ServiceFactory.getTeachingTaskService();
        String teachingTaskNum = request.getParameter("teachingTaskNum");
        String courseName = request.getParameter("courseName");
        String teacherNum = request.getParameter("teacherNum");
        String location = request.getParameter("location");
        TeachingTask teachingTask = new TeachingTask(teachingTaskNum,courseName,teacherNum,location,0);
        System.out.println(teachingTask.toString());
        if(teachingTaskService.insertTeachingTask(teachingTask)){
            return DISPATCHER+":"+"/TeachingTaskServlet?action=getAllTeachingTask";
        }
        request.setAttribute("error","插入失败！");
        return DISPATCHER+":"+"/TeachingTaskServlet?action=insertTeachingTaskUi";
    }
}

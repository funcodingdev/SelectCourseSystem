package com.sc.web;

import com.sc.domain.Teacher;
import com.sc.service.ITeacherService;
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
 * @Date: 2019/5/26 16:09
 */
@WebServlet("/TeacherServlet")
public class TeacherServlet extends BaseServlet {
    private ITeacherService teacherService;

    public String getAllTeacher(HttpServletRequest request,HttpServletResponse response){
        teacherService = ServiceFactory.getTeacherService();
        List<Teacher> allTeacher = teacherService.getAllTeacher();
        request.setAttribute("allTeacher",allTeacher);
        return DISPATCHER+":"+"/admin/teacherInfo.jsp";
    }

    public String updateTeacherUi(HttpServletRequest request,HttpServletResponse response){
        teacherService = ServiceFactory.getTeacherService();
        String id = request.getParameter("id");
        Teacher teacher = teacherService.getTeacher(id);
        if(teacher != null){
            request.setAttribute("teacher",teacher);
            return DISPATCHER+":"+"/admin/updateTeacher.jsp";
        }
        return DISPATCHER+":"+"/admin/teacherInfo.jsp";
    }

    public String updateTeacher(HttpServletRequest request,HttpServletResponse response){
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String identity = request.getParameter("identity");
        String password = request.getParameter("password");
        Teacher teacher = new Teacher(id,name,sex,Integer.parseInt(age),identity,password,null);
        teacherService = ServiceFactory.getTeacherService();
        if(teacherService.updateTeacher(teacher)){
            return DISPATCHER+":"+"/TeacherServlet?action=getAllTeacher";
        }
        return DISPATCHER+":"+"/admin/updateTeacher.jsp";
    }

    public String deleteTeacher(HttpServletRequest request,HttpServletResponse response){
        teacherService = ServiceFactory.getTeacherService();
        String id = request.getParameter("id");
        if(teacherService.deleteTeacher(id)){
            return DISPATCHER+":"+"/TeacherServlet?action=getAllTeacher";
        }
        return DISPATCHER +":"+"/admin/teacherInfo.jsp";
    }

    public String insertTeacher(HttpServletRequest request,HttpServletResponse response){
        return null;
    }
}

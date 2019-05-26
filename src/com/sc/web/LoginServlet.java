package com.sc.web;

import com.sc.service.IAdminService;
import com.sc.service.IStudentService;
import com.sc.service.ITeacherService;
import com.sc.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: fangju
 * @Date: 2019/5/25 12:09
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends BaseServlet {

    public String login(HttpServletRequest request,HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
//        System.out.println(username+","+password+","+role);
        String invoke = null;
        String basePath = request.getContextPath();
        switch (role){
            case "0":{//学生
                IStudentService studentService = ServiceFactory.getStudentService();
                boolean having = studentService.findStudent(username, password);
                if(having){//登陆成功
                    invoke = REDIRECE+":"+basePath+"/student/student.jsp";
                }
                break;
            }
            case "1":{//教师
                ITeacherService teacherService = ServiceFactory.getTeacherService();
                boolean having = teacherService.findTeacher(username, password);
                if(having){
                    invoke = REDIRECE+":"+basePath+"/teacher/teacher.jsp";
                }
                break;
            }
            case "2":{//管理员
                IAdminService adminService = ServiceFactory.getAdminService();
                boolean having = adminService.findAdmin(username, password);
                if(having){
                    invoke = REDIRECE+":"+basePath+"/admin/admin.jsp";
                }
                break;
            }
        }
        if(invoke == null){//验证失败
            request.setAttribute("error","用户名或密码错误");
            request.setAttribute("username",username);
            invoke = DISPATCHER+":"+"/login.jsp";
        }else{//验证成功
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
        }
        return invoke;
    }

    public String exit(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        session.invalidate();
        return REDIRECE+":"+request.getContextPath()+"/login.jsp";
    }
}

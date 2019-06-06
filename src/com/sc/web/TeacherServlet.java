package com.sc.web;

import com.sc.domain.PageBean;
import com.sc.domain.Student;
import com.sc.domain.Teacher;
import com.sc.service.ITeacherService;
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
 * @Date: 2019/5/26 16:09
 */
@WebServlet("/TeacherServlet")
public class TeacherServlet extends BaseServlet {
    private ITeacherService teacherService;

    public String getAllTeacher(HttpServletRequest request,HttpServletResponse response){
        teacherService = ServiceFactory.getTeacherService();
//        List<Teacher> allTeacher = teacherService.getAllTeacher();
//        request.setAttribute("allTeacher",allTeacher);
        String currentPage = request.getParameter("currentPage");
        PageBean<Teacher> pageBean = teacherService.getPageBean(Integer.parseInt(currentPage));
        request.setAttribute("pageBean", pageBean);
        HttpSession session = request.getSession();
        session.setAttribute("currentPage", Integer.parseInt(currentPage));
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
            HttpSession session = request.getSession();
            int currentPage = (int) session.getAttribute("currentPage");
            return DISPATCHER+":"+"/TeacherServlet?action=getAllTeacher&currentPage=" + currentPage;
        }
        request.setAttribute("error","更新失败！");
        return DISPATCHER+":"+"/admin/updateTeacher.jsp";
    }

    public String deleteTeacher(HttpServletRequest request,HttpServletResponse response){
        teacherService = ServiceFactory.getTeacherService();
        String id = request.getParameter("id");
        if(teacherService.deleteTeacher(id)){
            HttpSession session = request.getSession();
            int currentPage = (int) session.getAttribute("currentPage");
            int totalPage = PageBean.getTotalPage(teacherService.getTeacherCount());
            int indexPage = currentPage;//索引页为当前页
            if (currentPage >= totalPage) {
                indexPage = totalPage;
            }
            return DISPATCHER+":"+"/TeacherServlet?action=getAllTeacher&currentPage="+indexPage;
        }
        request.setAttribute("error","删除失败！");
        return DISPATCHER +":"+"/admin/teacherInfo.jsp";
    }

    public String insertTeacherUi(HttpServletRequest request,HttpServletResponse response){
        return DISPATCHER+":"+"/admin/insertTeacher.jsp";
    }

    public String insertTeacher(HttpServletRequest request,HttpServletResponse response){
        teacherService = ServiceFactory.getTeacherService();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String identity = request.getParameter("identity");
        String password = request.getParameter("password");
        Teacher teacher = new Teacher(id,name,sex,Integer.parseInt(age),identity,password,null);
//        System.out.println(teacher.toString());
        if(teacherService.insertTeacher(teacher)){
            return DISPATCHER+":"+"/TeacherServlet?action=getAllTeacher&currentPage=1";
        }
        request.setAttribute("error","插入失败！");
        return DISPATCHER+":"+"/admin/insertTeacher.jsp";
    }
}

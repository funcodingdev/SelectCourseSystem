package com.sc.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sc.dao.DaoFactory;
import com.sc.domain.Student;
import com.sc.service.IStudentService;
import com.sc.service.ServiceFactory;
import org.omg.PortableInterceptor.DISCARDING;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/25 20:27
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends BaseServlet {
    private IStudentService studentService;

    public String getAllStudent(HttpServletRequest request,HttpServletResponse response){
        studentService = ServiceFactory.getStudentService();
        List<Student> allStudent = studentService.getAllStudent();
        request.setAttribute("allStudent",allStudent);
//        System.out.println(allStudent.size());
        return DISPATCHER +":"+"/admin/studentInfo.jsp";
    }

    public String deleteStudent(HttpServletRequest request,HttpServletResponse response){
        String id = request.getParameter("id");
        studentService = ServiceFactory.getStudentService();
        if(studentService.deleteStudent(id)){
            return DISPATCHER+":"+"/StudentServlet?action=getAllStudent";
        }
        return DISPATCHER +":"+"/admin/studentInfo.jsp";
    }

    public String updateStudentUi(HttpServletRequest request,HttpServletResponse response){
        String id = request.getParameter("id");
        studentService = ServiceFactory.getStudentService();
        Student stu = studentService.getStudent(id);
        if(stu != null){
            request.setAttribute("stu",stu);
            return DISPATCHER+":"+"/admin/updateStudent.jsp";
        }
        return DISPATCHER +":"+"/admin/studentInfo.jsp";
    }

    public String updateStudent(HttpServletRequest request,HttpServletResponse response){
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String sClass = request.getParameter("sClass");
        String dept = request.getParameter("department");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        Student stu = new Student(id,name,sex,Integer.parseInt(age),sClass,dept,phone,password,"man.png");
        studentService = ServiceFactory.getStudentService();
        if(studentService.updateStudent(stu)){
            return DISPATCHER+":"+"/StudentServlet?action=getAllStudent";
        }
        return DISPATCHER+":"+"/admin/updateStudent.jsp";
    }

    public String insertStudentUi(HttpServletRequest request,HttpServletResponse response){

        return DISPATCHER+":"+"/admin/insertStudent.jsp";
    }

    public String insertStudent(HttpServletRequest request,HttpServletResponse response){
        return null;
    }

}

package com.sc.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sc.dao.DaoFactory;
import com.sc.domain.Department;
import com.sc.domain.PageBean;
import com.sc.domain.SClass;
import com.sc.domain.Student;
import com.sc.service.IStudentService;
import com.sc.service.ServiceFactory;
import org.omg.PortableInterceptor.DISCARDING;

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
 * @Date: 2019/5/25 20:27
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends BaseServlet {
    private IStudentService studentService;

    public String getAllStudent(HttpServletRequest request, HttpServletResponse response) {
        studentService = ServiceFactory.getStudentService();
//        List<Student> allStudent = studentService.getAllStudent();
//        request.setAttribute("allStudent",allStudent);
        String currentPage = request.getParameter("currentPage");
        PageBean<Student> pageBean = studentService.getPageBean(Integer.parseInt(currentPage));
        request.setAttribute("pageBean", pageBean);
        HttpSession session = request.getSession();
        session.setAttribute("currentPage", Integer.parseInt(currentPage));
        return DISPATCHER + ":" + "/admin/studentInfo.jsp";
    }

    public String deleteStudent(HttpServletRequest request, HttpServletResponse response) {
        studentService = ServiceFactory.getStudentService();
        String id = request.getParameter("id");
        if (studentService.deleteStudent(id)) {
            HttpSession session = request.getSession();
            int currentPage = (int) session.getAttribute("currentPage");
            int totalPage = PageBean.getTotalPage(studentService.getStudentCount());
            int indexPage = currentPage;//索引页为当前页
            if (currentPage >= totalPage) {
                indexPage = totalPage;
            }
            return DISPATCHER + ":" + "/StudentServlet?action=getAllStudent&currentPage=" + indexPage;
        }
        request.setAttribute("error", "删除失败！");
        return DISPATCHER + ":" + "/admin/studentInfo.jsp";
    }

    public String updateStudentUi(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        studentService = ServiceFactory.getStudentService();
        Student stu = studentService.getStudent(id);
        if (stu != null) {
            request.setAttribute("stu", stu);
            List<Department> allDepartment = ServiceFactory.getDepartmentService().getAllDepartment();
            request.setAttribute("allDepartment", allDepartment);
            List<SClass> allSClass = ServiceFactory.getSClassService().getAllSClass(stu.getDepartment());
            request.setAttribute("allSClass", allSClass);
            return DISPATCHER + ":" + "/admin/updateStudent.jsp";
        }
        return DISPATCHER + ":" + "/admin/studentInfo.jsp";
    }

    public String updateStudent(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String sClass = request.getParameter("sClass");
        String dept = request.getParameter("department");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        Student stu = new Student(id, name, sex, Integer.parseInt(age), sClass, dept, phone, password, "man.png");
        studentService = ServiceFactory.getStudentService();
        if (studentService.updateStudent(stu)) {
            HttpSession session = request.getSession();
            int currentPage = (int) session.getAttribute("currentPage");
            return DISPATCHER + ":" + "/StudentServlet?action=getAllStudent&currentPage=" + currentPage;
        }
        request.setAttribute("error", "更新失败！");
        return DISPATCHER + ":" + "/admin/updateStudent.jsp";
    }

    public String insertStudentUi(HttpServletRequest request, HttpServletResponse response) {
        List<Department> allDepartment = ServiceFactory.getDepartmentService().getAllDepartment();
        request.setAttribute("allDepartment", allDepartment);
        return DISPATCHER + ":" + "/admin/insertStudent.jsp";
    }

    public String insertStudent(HttpServletRequest request, HttpServletResponse response) {
        studentService = ServiceFactory.getStudentService();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String sClass = request.getParameter("sclass");
        String dept = request.getParameter("department");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        Student stu = new Student(id, name, sex, Integer.valueOf(age), sClass, dept, phone, password, "man.png");
        if (studentService.insertStudent(stu)) {
            return DISPATCHER + ":" + "/StudentServlet?action=getAllStudent&currentPage=1";
        }
        request.setAttribute("error", "插入失败！");
        return DISPATCHER + ":" + "/StudentServlet?action=insertStudentUi";
    }

}

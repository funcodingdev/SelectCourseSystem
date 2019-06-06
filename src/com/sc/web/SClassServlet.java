package com.sc.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sc.domain.SClass;
import com.sc.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/28 12:31
 */
@WebServlet("/SClassServlet")
public class SClassServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("SClassServlet");
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        String department = request.getParameter("department");
        List<SClass> allSClass = ServiceFactory.getSClassService().getAllSClass(department);
        JSONArray data = new JSONArray();
        for (int i = 0; i < allSClass.size(); i++) {
            data.add(allSClass.get(i).getName());
        }
        System.out.println(data.toJSONString());
        PrintWriter writer = response.getWriter();
        writer.println(data.toJSONString());
        writer.flush();
        writer.close();
    }
}

package com.sc.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
    public static final String REDIRECE = "redirect";
    public static final String DISPATCHER = "dispatcher";

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
//        System.out.println("action="+action);
        if (action == null) {
            throw new RuntimeException("action为null");
        }
        Class clazz = this.getClass();
        Method method = null;
        try {
            method = clazz.getMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            String invoke = (String) method.invoke(this, request, response);
            if (invoke != null) {
                String[] split = invoke.split(":");
                if (DISPATCHER.equals(split[0])) {
                    //转发
                    request.getRequestDispatcher(split[1]).forward(request, response);
                } else if (REDIRECE.equals(split[0])) {
                    //重定向
                    response.sendRedirect(split[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

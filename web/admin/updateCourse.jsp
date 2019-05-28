<%--
  Created by IntelliJ IDEA.
  User: FJ
  Date: 2019/5/26
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String ctx = request.getContextPath();
    pageContext.setAttribute("ctx", ctx);
%>
<html>
<head>
    <title>Title</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <script src="${ctx}/layui/layui.js"></script>
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css">
</head>
<body>
<form class="layui-form" action="${ctx}/CourseServlet?action=updateCourse" method="post">
    <div>
        <h1 style="color: red;text-align: center">${error}</h1>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">课程号</label>
        <div class="layui-input-block">
            <input type="text" name="number" class="layui-input" required lay-verify="required"
                   autocomplete="off" value="${course.number}" readonly/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">课程名</label>
        <div class="layui-input-block">
            <input type="text" name="name" class="layui-input" required lay-verify="required" placeholder="请输入课程名"
                   autocomplete="off" value="${course.name}"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">学分</label>
        <div class="layui-input-block">
            <input type="number" name="credit" class="layui-input" required lay-verify="required" placeholder="请输入学分"
                   autocomplete="off" value="${course.credit}"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">总学时</label>
        <div class="layui-input-block">
            <input type="number" name="period" class="layui-input" required lay-verify="required" placeholder="请输入总学时"
                   autocomplete="off" value="${course.period}"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">理论学时</label>
        <div class="layui-input-block">
            <input type="number" name="theory" class="layui-input" required lay-verify="required" placeholder="请输入理论学时"
                   autocomplete="off" value="${course.theory}"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">实验学时</label>
        <div class="layui-input-block">
            <input type="number" name="experiment" class="layui-input" required lay-verify="required" placeholder="请输入实验学时"
                   autocomplete="off" value="${course.experiment}"/>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block login-btn">
            <button class="layui-btn layui-btn-lg" lay-submit lay-filter="loginForm">确定</button>
        </div>
    </div>
</form>

<script>
    layui.use('form', function () {
        var form = layui.form;
        //监听提交
        form.on('submit(loginForm)', function (data) {
            return true;
        });
    });
</script>
</body>
</html>

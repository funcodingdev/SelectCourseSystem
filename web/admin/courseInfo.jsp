<%--
  Created by IntelliJ IDEA.
  User: FJ
  Date: 2019/5/25
  Time: 20:59
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
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <script src="${ctx}/layui/layui.js"></script>
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css">
</head>
<body>
<div>
    <button class="layui-btn">
        <i class="layui-icon">&#xe608;</i> 添加
    </button>
</div>
<table class="layui-table" lay-even lay-skin="row" lay-size="lg" style="text-align: center">
    <colgroup>
        <col width="150">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
        <th>课程号</th>
        <th>课程名</th>
        <th>学分</th>
        <th>总学时</th>
        <th>理论学时</th>
        <th>实验学时</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${allCourse}" var="course">
        <tr>
            <th>${course.number}</th>
            <th>${course.name}</th>
            <th>${course.credit}</th>
            <th>${course.period}</th>
            <th>${course.theory}</th>
            <th>${course.experiment}</th>
            <th style="text-align: center">
                <a href="${ctx}/CourseServlet?action=updateCourseUi&number=${course.number}"><span class="layui-badge layui-bg-blue">编辑</span></a>&nbsp;&nbsp;&nbsp;
                <a href="${ctx}/CourseServlet?action=deleteCourse&number=${course.number}"><span class="layui-badge">删除</span></a>
            </th>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
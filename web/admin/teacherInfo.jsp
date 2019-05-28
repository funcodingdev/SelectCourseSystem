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
    <a href="${ctx}/TeacherServlet?action=insertTeacherUi" class="layui-btn" id="insertBtn">
        <i class="layui-icon">&#xe608;</i> 添加
    </a>
</div>
<table class="layui-table" lay-even lay-skin="row" lay-size="lg" style="text-align: center">
    <colgroup>
        <col width="150">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
        <th>ID</th>
        <th>头像</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>身份</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${allTeacher}" var="teacher">
        <tr>
            <th>${teacher.id}</th>
            <th><img src="${ctx}/res/image/headphoto/${teacher.image}"></th>
            <th>${teacher.name}</th>
            <th>${teacher.sex}</th>
            <th>${teacher.age}</th>
            <th>${teacher.identity}</th>
            <th style="text-align: center">
                <a href="${ctx}/TeacherServlet?action=updateTeacherUi&id=${teacher.id}"><span
                        class="layui-badge layui-bg-blue">编辑</span></a>&nbsp;&nbsp;&nbsp;
                <a href="${ctx}/TeacherServlet?action=deleteTeacher&id=${teacher.id}"><span
                        class="layui-badge">删除</span></a>
            </th>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
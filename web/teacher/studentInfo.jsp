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
        <th>班级</th>
        <th>院系</th>
        <th>成绩</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${allSelectCourse}" var="selectCourse">
        <tr>
            <th>${selectCourse.student.id}</th>
            <th><img src="${ctx}/res/image/headphoto/${selectCourse.student.image}"></th>
            <th>${selectCourse.student.name}</th>
            <th>${selectCourse.student.sex}</th>
            <th>${selectCourse.student.age}</th>
            <th>${selectCourse.student.sClass}</th>
            <th>${selectCourse.student.department}</th>
            <th>
                <input type="number" value="${selectCourse.grade}" readonly>
            </th>
            <th style="text-align: center">
                <a href="#"><span
                        class="layui-badge layui-bg-blue">编辑</span></a>
            </th>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
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
<form class="layui-form" action="${ctx}/TeachingTaskServlet?action=insertTeachingTask" method="post">
    <div>
        <h1 style="color: red;text-align: center">${error}</h1>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">教学任务号</label>
        <div class="layui-input-block">
            <input type="text" name="teachingTaskNum" class="layui-input" required lay-verify="required" placeholder="请输入教学任务号"
                   autocomplete="off"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">课程名</label>
        <div class="layui-input-block">
            <select id="courseName" name="courseName" required lay-verify="required">
                <option value="">请选择</option>
                <c:forEach items="${allCourse}" var="course">
                    <option value="${course.name}">${course.name}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">教师姓名</label>
        <div class="layui-input-block">
            <select id="teacherNum" name="teacherNum" required lay-verify="required">
                <option value="">请选择</option>
                <c:forEach items="${allTeacher}" var="teacher">
                    <option value="${teacher.id}">${teacher.name}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">上课地点</label>
        <div class="layui-input-block">
            <input type="number" name="location" class="layui-input" required lay-verify="required" placeholder="请输入上课地点"
                   autocomplete="off"/>
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

<%--
  Created by IntelliJ IDEA.
  User: FJ
  Date: 2019/5/25
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String ctx = request.getContextPath();
    pageContext.setAttribute("ctx", ctx);
%>

<html>
<head>
    <meta charset="UTF-8">
    <title>选课管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css"/>
    <link rel="stylesheet" href="${ctx}/res/css/login.css"/>
    <script type="text/javascript" src="${ctx}/layui/layui.js"></script>
<body>
<div class="login-content">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>选课管理系统</legend>
    </fieldset>
    <form class="layui-form" action="${ctx}/LoginServlet?action=login" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">用户账号</label>
            <div class="layui-input-block">
                <input type="text" name="username" required lay-verify="required" placeholder="请输入用户名"
                       autocomplete="off" class="layui-input" value="${username}"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">登陆密码</label>
            <div class="layui-input-block">
                <input type="password" name="password" required lay-verify="required" placeholder="请输入密码"
                       autocomplete="off" class="layui-input"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">登陆角色</label>
            <div class="layui-input-block">
                <select name="role" lay-verify="required">
                    <option value=""></option>
                    <option value="0">学生</option>
                    <option value="1">教师</option>
                    <option value="2">管理员</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block login-btn">
                <button class="layui-btn layui-btn-lg" lay-submit lay-filter="loginForm">登陆</button>
            </div>
        </div>
    </form>
</div>
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

<%--
  Created by IntelliJ IDEA.
  User: FJ
  Date: 2019/5/25
  Time: 15:54
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
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>选课管理系统</title>
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">选课管理系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item">
                <a href="">选课</a>
            </li>
            <li class="layui-nav-item">
                <a href="">退课</a>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="${ctx}/res/image/headphoto/head_default_man.png" class="layui-nav-img"> ${username}
                </a>
                <dl class="layui-nav-child">
                    <dd>
                        <a href="">基本资料</a>
                    </dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="${ctx}/LoginServlet?action=exit">注销</a>
            </li>
        </ul>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <table class="layui-hide" id="test" lay-filter="test"></table>

            <script type="text/html" id="toolbarDemo">
                <div class="layui-btn-container">
                    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
                    <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
                    <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
                </div>
            </script>

            <script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
            </script>


            <script>
                layui.use('table', function(){
                    var table = layui.table;

                    table.render({
                        elem: '#test'
                        ,url:'${ctx}/StudentServlet?action=getAllStudent'
                        ,toolbar: '#toolbarDemo'
                        ,title: '用户数据表'
                        ,cols: [[
                            {type: 'checkbox', fixed: 'left'}
                            ,{field:'id', title:'ID', width:80, fixed: 'left', unresize: true, sort: true}
                            ,{field:'username', title:'用户名', width:120, edit: 'text'}
                            ,{field:'email', title:'邮箱', width:150, edit: 'text', templet: function(res){
                                    return '<em>'+ res.email +'</em>'
                                }}
                            ,{field:'sex', title:'性别', width:80, edit: 'text', sort: true}
                            ,{field:'city', title:'城市', width:100}
                            ,{field:'sign', title:'签名'}
                            ,{field:'experience', title:'积分', width:80, sort: true}
                            ,{field:'ip', title:'IP', width:120}
                            ,{field:'logins', title:'登入次数', width:100, sort: true}
                            ,{field:'joinTime', title:'加入时间', width:120}
                            ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
                        ]]
                        ,page: true
                    });

                    //头工具栏事件
                    table.on('toolbar(test)', function(obj){
                        var checkStatus = table.checkStatus(obj.config.id);
                        switch(obj.event){
                            case 'getCheckData':
                                var data = checkStatus.data;
                                layer.alert(JSON.stringify(data));
                                break;
                            case 'getCheckLength':
                                var data = checkStatus.data;
                                layer.msg('选中了：'+ data.length + ' 个');
                                break;
                            case 'isAll':
                                layer.msg(checkStatus.isAll ? '全选': '未全选');
                                break;
                        };
                    });

                    //监听行工具事件
                    table.on('tool(test)', function(obj){
                        var data = obj.data;
                        //console.log(obj)
                        if(obj.event === 'del'){
                            layer.confirm('真的删除行么', function(index){
                                obj.del();
                                layer.close(index);
                            });
                        } else if(obj.event === 'edit'){
                            layer.prompt({
                                formType: 2
                                ,value: data.email
                            }, function(value, index){
                                obj.update({
                                    email: value
                                });
                                layer.close(index);
                            });
                        }
                    });
                });
            </script>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script src="${ctx}/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>

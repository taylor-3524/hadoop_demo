<%--
  Created by IntelliJ IDEA.
  User: taylor
  Date: 2019/10/18
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆您的私人云</title>
    <link type="text/css" rel="stylesheet" href="css/typecho.css"/>
    <link type="text/css" rel="stylesheet" href="css/index_bg.css"/>
</head>

<body class="body-100">
<div class="typecho-login-wrap">

    <div class="typecho-login">
        <h1 class="banner">管理员登陆</h1>
            <label class="sr-only">用户名:</label>
            <form method="post" action="login">     
                <input type="text" class="text-l w-100" autofocus placeholder="用户名" name="id">
                <label class="sr-only">密码:</label>
                <input type="password" class="text-l w-100" placeholder="密码" name="pwd">
        <p class="submit">
            <input type="submit" class="btn btn-l w-100 primary" value="提交">  
        </p>
        </form>
        <div class="register_div">
        还没有账号?•
            <a href="register.jsp">立即注册</a>
         </div>
    </div>
</div>


</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" %>
<script language="javascript">
    function on_submit() {//验证数据的合法性
        if (form1.username.value == "") {
            alert("用户名不能为空，请输入用户名！");
            form1.username.focus();
            return false;
        }
        if (form1.userpassword.value == "") {
            alert("用户密码不能为空，请输入密码！");
            form1.userpassword.focus();
            return false;
        }
    }
</script>
<%
    String username = request.getParameter("username");
    String userpassword = request.getParameter("userpassword");
    if (username != null & userpassword != null) {
        session.setAttribute("username", username);
        response.sendRedirect("sessionUserLogin1.jsp");
    }
%>
<html>
<head>
    <title>用户登录</title>
</head>
<body>

<form name="form1" method="post" action="sessionUserLogin.jsp"
      onsubmit="return on_submit()">


    <label>请输入用户名：</label>><input type="text" name="username" size="20">

    <br/>

    <label>请输入密码：</label>&nbsp;&nbsp;<input type="password" name="userpassword" size="20">

    <br/>


    <input type="submit" value="提交" name="B1">

</form>

</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link type="text/css" rel="stylesheet" href="css/typecho.css"/>
    <link type="text/css" rel="stylesheet" href="css/index_bg.css"/>
    <script src="js/jquery.js"></script>
    <script>var flag=true;</script>
    <script>
        $(function () {
            $("#username").blur(function () {
                var value = $(this).val();
                $.ajax({
                    type: "post",
                    url: "http://localhost:8080/Hadoopdemo_war/register",
                    data: {
                        username: value,
                        fun:"check_username"
                    },
                    dataType: "json",
                    success: function (msg) {
                        $("#username_tip").text(msg.data)
                        if(msg.success=="success"){
                            flag=true;
                        }else if(msg.success=="fail"){
                            flag=false;
                        }else {
                            alert("未知错误");
                        }
                    },
                    error: function (e) {
                        console.log(e.status);
                        console.log(e.responseText);
                    }
                });
            });
            $("#confirm_passwd").blur(function () {
            var pwd=$("#passwd").val();
            var pwdre=$("#confirm_passwd").val();
            if(pwd!=pwdre){
                $("#confirm_passwd_tip").text("两次输入的密码不一致!");
                flag=false;
            }else {
                $("#confirm_passwd_tip").text("");
                flag=true;
            }
            })
        })
    </script>
</head>
<body class="body-100">
<div class="typecho-login-wrap">

    <div class="typecho-login">
        <h1 class="banner">用户注册</h1>
        <input type="text" class="text-l w-100" placeholder="用户名" id="username">
        <span id="username_tip"></span>
        <br/>
        <input type="password" class="text-l w-100" placeholder="密码" id="passwd">
        <br/>
        <input type="password" class="text-l w-100" placeholder="确认密码" id="confirm_passwd">
        <span id="confirm_passwd_tip"></span>
        <br/>
        <input type="submit" class="btn btn-l w-100 primary" value="提交" onclick="check()">
        <div class="login_div">
            已有账号?•
            <a href="login.jsp">返回登陆</a>
             </div>
    </div>
</div>
<script>
    function check() {
        if($("#username_tip").text()!="用户名可用"){
           alert("请填写正确的用户名!");
            return false;
        }
        if($("#confirm_passwd_tip").text()!=""){
            alert("密码填写不正确!");
            return false;
        }
        var username=$("#username").val();
        var pwd=$("#passwd").val();
        $.ajax({
            type:"post",
            url:"register",
            data:{
                username:username,
                password:pwd,
                fun:"register"
            },
            dataType:"json",
            success:function (msg) {
                if(msg.success=="success"){
                    alert("注册成功!"+'\r\n'+"即将返回登陆");
                    window.location.href="login.jsp";
                }else if(msg.success=="fail"){
                    alert("注册失败");
                }else {
                    alert("未知错误");
                }
            },
            error:function (e) {
                console.log(e.status);
                console.log(e.responseText);
            }
        })

    }

</script>



</body>
</html>

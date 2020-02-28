<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎页面</title>
    <link type="text/css" rel="stylesheet" href="css/index_button.css" />
    <link type="text/css" rel="stylesheet" href="css/index_banner.css" />
    <link type="text/css" rel="stylesheet" href="css/index_bg.css" />
</head>
<style>

</style>
<body>

    <h1 class="banner">欢迎使用hadoop私有云</h1>

    <input type="button" class="button" value="点击这里进入登陆页面" onclick="login()">

<input type="button" class="button" value="点击这里进入test_demo" onclick="jump_test_demo()">
    <script>
        function login() {
            window.location.href="login.jsp";
        }
    </script>
    <script>
        function jump_test_demo() {
            return false;
        }
    </script>
 <script>
        function jump_test_demo() {
            window.location.href="sessionUserLogin.jsp";
        }
    </script>
</body>
</html>

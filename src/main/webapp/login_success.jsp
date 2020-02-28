<%--
  Created by IntelliJ IDEA.
  User: taylor
  Date: 2019/10/16
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="css/hello.css"/>
</head>
<style>
    #logout{
        float: right;
    }
</style>
<body>
<form method="post" action="op">
    <input type="submit" value="退出登陆" class="button" id="logout">
    <input type="hidden" value="yes" name="logout">
</form>
<div class="op">
    <form method="post" action="op">
        <input type="txt" placeholder="请输入需要上传的文件目录" name="file_path">
        <input type="submit" class="button" value="上传文件" >
    </form>

    <form method="post" action="make_dir"><%--bug:取消之后不要定向到action--%>
        <input type="submit" value="新建目录" onclick="make_dir()" id="make_dir_btn" name="dir_name" class="button" >
    </form>
    <form method="post" action="op">
        <input type="submit" value="返回根目录" class="button">
        <input type="hidden" value="yes" name="back">
    </form>

</div>

<script>
    function make_dir() {
        path=window.prompt("请输入文件夹路径名:");

        var make=document.getElementById("make_dir_btn")
        make.value=path;

    }
</script>

<table>

    <tr>
        <th>序号</th>
        <th>路径</th>

        <th>修改时间</th>
        <th>大小</th>
        <th colspan="3">操作文件</th>
    </tr>
    <c:forEach items="${list}" var="file">
        <tr>
            <td>${file.id}</td>
            <td>${file.path}</td>

            <td>${file.time}</td>
            <td>${file.len}</td>

            <td>
                <form method="post" action="op">
                    <input type="submit" value="删除" class="button" id="del_button">
                    <input type="hidden" value=${file.path} name="del_file_path">

                </form>
            </td>
            <td>
                <form method="post" action="op">
                    <input type="submit" value="下载" class="button" id="down_button" onclick="download_file()">
                    <input type="hidden" value=${file.path} name="download_file_path">
                </form>

            </td>
            <td>
                <form method="post" action="op">
                    <input type="submit" value="打开" class="button" id="open_button" onclick="open_file()">
                    <input type="hidden" value=${file.path} name="open_file_path">
                </form>
            </td>
            </form>
        </tr>

    </c:forEach>
    <script>
        function del_file() {
            alert("文件已删除!");
        }
    </script>
    <script>
        function download_file() {
            alert("文件已保存在d:/file/download文件夹下");
        }
    </script>

    <script>
        function open_file() {

         /*   alert("内容已输出至控制台");*/
        }

    </script>

</table>

</body>
</html>

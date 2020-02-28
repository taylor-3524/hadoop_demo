<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<input type="submit" onclick="getPath()">
<input type="text" id="pathtext">

<script type="text/javascript">
    function getPath(obj) {
        if (obj) {
            if (window.navigator.userAgent.indexOf("MSIE") >= 1) {
                obj.select(); return document.selection.createRange().text;
            }
            else if (window.navigator.userAgent.indexOf("Firefox") >= 1) {
                if (obj.files) {
                    return obj.files.item(0).getAsDataURL();
                }
                return obj.value;
            }
            return obj.value;
        }
    }

    function GetText(stts) {
        var s = getPath(stts);
        var textBox = document.getElementById("pathtext");
        textBox.innerText = s;
    }
</script>
</body>
</html>
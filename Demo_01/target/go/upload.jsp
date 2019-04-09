<%--
  Created by IntelliJ IDEA.
  User: admin1902
  Date: 2019/4/2
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/upload/up" enctype="multipart/form-data" method="post">
            上传用户：<input type="text" name="username"><br/>
            上传文件1：<input type="file" name="file1"><br/>
            上传文件2：<input type="file" name="file2"><br/>
             <input type="submit" value="提交">
        </form>
</body>

</html>

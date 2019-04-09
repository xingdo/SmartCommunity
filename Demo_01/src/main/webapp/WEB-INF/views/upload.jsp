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
<%@include file="/WEB-INF/head.jsp"%>
<body>
<form action="/upload/up" enctype="multipart/form-data" method="post">
            上传文件1：<input type="file" name="files"><br/>
            上传文件2：<input type="file" name="files"><br/>
             <input type="submit" value="提交">
</form>

<form action="/upload/up" method="post" enctype="multipart/form-data" id="form">
    <table>
        <tbody>
        <tr>
            <td>上传文件:</td>
            <td style="padding-left: 10px;"><input type="file" name="file" id="fileInput"></td>
            <td style="padding-left: 80px;">
                <button type="submit" class="btn btn-primary btn-q btn-outline fa fa-upload"
                        　　　　　　　　　　class="easyui-validatebox" data-options="required:true">上传
                </button>
            </td>
        </tr>
        <tr>
            <td colspan="2"><span style="color:red">*上传文件格式为xls,xlsx,txt,csv文件!</span>&nbsp;&nbsp;</td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>

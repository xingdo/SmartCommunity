<%--
  Created by IntelliJ IDEA.
  User: admin1902
  Date: 2019/4/2
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- 遍历Map集合 -->
     <c:forEach var="me" items="${fileNameMap}">
            <c:url value="/upload/download" var="downurl">
               <c:param name="filepath" value="${me.value}"></c:param>
                <c:param name="filename" value="${me.key}"></c:param>
             </c:url>
             ${me.key}<a href="${downurl}">下载</a>
             <br/>
     </c:forEach>
</body>
</html>

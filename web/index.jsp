<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 25.12.2019
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start</title>
</head>
<body>
<div align="center">
    <form action="${pageContext.servletContext.contextPath}/autification" method="POST">
        <input type="hidden" name="id" value="${user.id}">
        <label>Username: <input type="text" name="login" value="${user.login}"><br></label>
        <label>Password: <input type="text" name="password" value="${user.password}"><br></label>
        <input type="submit" align="center" value="Submit"/>
    </form>
</div>
</body>
</html>

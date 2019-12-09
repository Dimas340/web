<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<div align="center">
    <form action="${pageContext.servletContext.contextPath}/edit" method="POST">
        <input type="hidden" name="id" value="${user.id}">
        <label>Username: <input type="text" name="login" value="${user.login}"><br></label>
        <label>Password: <input type="text" name="password" value="${user.password}"><br></label>
        <input type="submit" align="center" value="Submit"/>
    </form>
</div>
</body>
</html>

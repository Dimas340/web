<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
<div align="center">
    <form action="${pageContext.servletContext.contextPath}/authorization" method="POST">
        <label>Username: <input type="text" name="login" value="${user.login}"><br></label>
        <label>Password: <input type="text" name="password" value="${user.password}"><br></label>
        <input type="submit" align="center" value="Submit"/>
    </form>
</div>
</body>
</html>

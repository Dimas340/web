<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/adding" method="POST">
    <ul>
        <li>
            <label>Username: <input type="text" name="login"></label>
        </li>
        <li>
            <label>Password: <input type="text" name="password"></label>
        </li>
        <li><input type="submit" align="center" value="Submit"/></li>
    </ul>

</form>
</body>
</html>

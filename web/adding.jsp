<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div align="center">
    <form action="${pageContext.servletContext.contextPath}/app/admin/adding" method="POST">
            <label>Username: <input type="text" name="login"><br></label>
            <label>Password: <input type="text" name="password"><br></label>
            <label>Role: <input type="text" name="role"><br></label>
            <input type="submit" align="center" value="Submit"/>
    </form>
</div>
</body>
</html>

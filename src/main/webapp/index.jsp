<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
<center>
    <h1>Welcome our website</h1>
    <h2>
        <a href="${pageContext.request.contextPath}/adding">Adding</a>

 </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>Login</th>
            <th>Password</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.login}</td>
                <td>${user.password}</td>
                <td>
                    <a href="${pageContext.servletContext.contextPath}/edit?id=${user.id}">Edit</a>
                    <a href="${pageContext.servletContext.contextPath}/delete?id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
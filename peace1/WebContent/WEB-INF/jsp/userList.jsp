<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<meta charset="UTF-8">
<title>用户列表</title>
</head>
<body>
    <table>
        <tr>
            <th>用户ID</th>
            <th>用户名</th>
            <th>密码</th>
            <th><a href="${path}/user/addUser">添加用户</a></th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id }</td>
                <td>${user.userName }</td>
                <td>${user.password }</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
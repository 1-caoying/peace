<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<meta charset="UTF-8">
<title>添加用户</title>
</head>
<body>
    <form action="${path}/user/saveUser" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td><input name="userName" value="${user.userName}"></td>
            </tr>
             <tr>
                <td>密码</td>
                <td><input name="password" value="${user.password}"></td>
            </tr>
            <tr>
                <td><input type="submit" value="保存"></td>
            </tr>
        </table>
    </form>
</body>
</html>
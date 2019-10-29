<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.username }</td>
				<td>${user.password }</td>
				<td>${user.password_salt }</td>
				<td>${user.status }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
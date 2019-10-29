<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
request:${requestScope.requestA} <br>
session:${sessionScope.sessionA} <br>
application:${applicationScope.applicationA} <br>

Map:${map2}
Map:${map1}
Map:${requestScope.map} 

<br>

Model:${hehe}
Model:${requestScope.hehe}

<br>


ModelAndView：${hehe}
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="demo" method="post">
		<input type="text" name="name1" /> 
		<input type="text" name="age1" />
		<input type="checkbox" name="hover" value="唱" />
		<input type="checkbox" name="hover" value="跳转" />
		<input type="checkbox" name="hover" value="rap" />
		<input type="checkbox" name="hover" value="篮球" />
		<input	type="submit" value="提交" />
	</form>
	
	
	<form action="demo1" method="post">
		<!-- 第一个数组 -->
		<input type="text" name="people[0].name" />
		<input type="text" name="people[0].age" />
		<!-- 第二个数组 -->
		<input type="text" name="people[1].name" />
		<input type="text" name="people[1].age" />
		<input	type="submit" value="提交" />
	</form>
	
	<a href="demo3/123/123">跳转</a>
	<a href="demo3?name=123&age=15">跳转1</a>
	<a href="demo3">跳转3</a>
</body>
</html>
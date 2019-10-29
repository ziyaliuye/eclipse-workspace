<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<a href="download?fileName=1.txt">下载</a>
	<br>

	<!-- 设置enctype属性为支持二进制内容 -->
	<!-- 文件上传需要post方式 -->
	<form action="upload" enctype="multipart/form-data" method="post">
		<input type="file" name="file" />
		<input type="submit" value="上传">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러페이지</title>
</head>
<body>

<h1>${exception}</h1>
<h3>${exception.message}</h3>

<hr>

<a href="main.do">메인으로 돌아가기</a>

</body>
</html>
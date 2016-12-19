<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>

<meta charset="utf-8">
</head>
<body>
	<c:out value="${message }" />

	<!--
		Exception: 	<c:out value="${exception }"></c:out>
		Failed url:
		<c:out value="${url }]"></c:out>
		Error message:
		<c:out value="${exception.message }"></c:out>
		<c:forEach var="line" items="${exception.stackTrace }">
			<c:out value="${line }"/>
		</c:forEach>  
		-->
</body>
</html>
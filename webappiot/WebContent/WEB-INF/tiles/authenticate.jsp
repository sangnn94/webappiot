<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html >
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">


<title><tiles:insertAttribute name="title" /></title>

<!-- Bootstrap Core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- Custom CSS -->
<link href='<c:url value="/resources/css/sb-admin.css" />'
	rel="stylesheet">


<!-- Custom Fonts -->
<link
	href='<c:url value="/resources/font-awesome/css/font-awesome.min.css" />'
	rel="stylesheet" type="text/css">

<!-- jQuery -->
<script src='<c:url value="/resources/js/jquery.js" />'></script>
<c:url var="registerUrl" value="/register"></c:url>
<c:url var="loginUrl" value="/login"></c:url>
</head>
<body>

	<!-- Fixed navbar -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">WebAppIoT</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${loginUrl }">Login</a></li>
					<li><a href="${registerUrl }">Register</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<div class="container">
		<tiles:insertAttribute name="content" />

	</div>
	<script src='<c:url value="/resources/js/bootstrap.min.js" />'></script>
	<script src='<c:url value="/resources/js/sidebar.js" />'></script>
	<script src='<c:url value="/resources/js/canvasjs.min.js" />'></script>

</body>
</html>
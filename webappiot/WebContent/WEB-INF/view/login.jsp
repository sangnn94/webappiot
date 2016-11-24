<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Login Page</title>

<!-- Bootstrap Core CSS -->


<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">

<!-- Custom CSS -->
<link href='<c:url value="/resources/css/sb-admin.css" />'
	rel="stylesheet">


<!-- Custom Fonts -->
<link
	href='<c:url value="/resources/font-awesome/css/font-awesome.min.css" />'
	rel="stylesheet" type="text/css">
</head>
<body onload='document.f.username.focus();'>
	<!-- login form -->

	<div class="container">
		<div class="wrapper">
			<form name='f' action='${pageContext.request.contextPath}/login'
				method='POST' class="form-signin">
				<h3 class="form-signin-heading">Welcome ! Please Sign In</h3>
				<c:if test="${param.error != null }">
					<p>Login failed. Check that your username and password are
						corrected.</p>
				</c:if>

				<hr class="colorgraph">
				<br> <input type="text" class="form-control" type='text'
					name='username' value='' placeholder="Username" /> <input
					type="password" class="form-control" name="password"
					placeholder="Password" />

				<button class="btn btn-lg btn-primary btn-block" name="submit"
					value="Login" type="submit">Login</button>
			</form>
		</div>
	</div>
	<!-- jQuery -->
	<script src='<c:url value="/resources/js/jquery.js" />'></script>

	<!-- Bootstrap Core JavaScript -->
	<script src='<c:url value="/resources/js/bootstrap.min.js" />'></script>

</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
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
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">

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
<c:url var="registerUrl" value="/register"></c:url>
</head>
<body>
	<div class="container">
		<div class="wrapper">
			<sf:errors path="user.*"></sf:errors>
			<sf:form id="details" method="post" action="${registerUrl }"
				modelAttribute="user" class="form-signin">
				<h3 class="form-signin-heading">Create a new account</h3>
				<div>
					<hr class="colorgraph">
				</div>
				<div class="form-group">
					<sf:input name="username" path="username" type="text"
						class="form-control" placeholder="Username" />
				</div>

				<div class="form-group">
					<sf:input name="email" path="email" type="text"
						class="form-control" placeholder="Email" />
				</div>
				<div class="form-group">
					<sf:input name="password" path="password" type="password"
						class="form-control" placeholder="Password" />
				</div>
				<div class="form-group">
					<sf:input name="matchingPassword" path="matchingPassword"
						type="password" class="form-control"
						placeholder="Confirm password" />
				</div>
				<button class="btn btn-lg btn-primary btn-block" name="submit"
					value="Login" type="submit">Sign up</button>
			</sf:form>

		</div>

	</div>
	<!-- jQuery -->
	<script src='<c:url value="/resources/js/jquery.js" />'></script>

	<!-- Bootstrap Core JavaScript -->
	<script src='<c:url value="/resources/js/bootstrap.min.js" />'></script>

</body>

</html>
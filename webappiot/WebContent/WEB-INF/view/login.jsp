<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="registerUrl" value="/register"></c:url>
<c:url var="loginUrl" value="/login"></c:url>
<div class="container">
	<div class="wrapper">
		<form name='f' method='POST' action="${loginUrl }" class="form-signin">
			<h3 class="form-signin-heading">Welcome! Please Sign In</h3>
			<div>
				<hr class="colorgraph">
			</div>
			<c:if test="${param.error != null}">
				<div class="alert alert-danger">Invalid username and password.</div>
			</c:if>
			<c:if test="${param.logout != null}">
				<div class="alert alert-success">You have been logged out.</div>
			</c:if>
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Username"
					name="username" />
			</div>
			<div class="form-group">
				<input type="password" class="form-control" placeholder="Password"
					name="password" />
			</div>
			<div class="form-group">
				<button class="btn btn-lg btn-primary btn-block" name="submit"
					value="Login" type="submit">Login</button>
			</div>
			<a href="${registerUrl }">Create a new account</a>
		</form>
	</div>
</div>

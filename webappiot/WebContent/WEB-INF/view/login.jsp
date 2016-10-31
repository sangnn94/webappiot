<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login Page</title>
</head>
<body onload='document.f.username.focus();'>
	<h3>Login with Username and Password</h3>
	<!-- login failed error message -->
	<c:if test="${param.error != null }">
		<p>Login failed. Check that your username and password are
			corrected.</p>
	</c:if>
	<!-- login form -->
	<form name='f' action='${pageContext.request.contextPath}/login'
		method='POST'>
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login" /></td>
			</tr>
		</table>
	</form>

</body>
</html>
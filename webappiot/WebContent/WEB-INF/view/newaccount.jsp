<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Create new account</h2>
	<sf:form id="details" method="post"
		action="${pageContext.request.contextPath}/createaccount"
		modelAttribute="user">
		<table>
			<tr>
				<td class="label">Username:</td>
				<td><sf:input name="username" path="username" type="text" /><br>
					<div class="error">
						<sf:errors path="username"></sf:errors>
					</div></td>
			</tr>
			<tr>
				<td class="label">Email:</td>
				<td><sf:input name="email" path="email" type="text" /> <br>
					<div class="error">
						<sf:errors path="email"></sf:errors>
					</div></td>
			</tr>
			<tr>
				<td class="label">Password:</td>
				<td><sf:input id="password" name="password" path="password"
						type="password" /> <br>
					<div class="error">
						<sf:errors path="password"></sf:errors>
					</div></td>
			</tr>
			<tr>
				<td class="label">Confirm Password:</td>
				<td><input id="confirmpass" name="confirmpass" type="password" />
					<div id="matchpass"></div></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input value="Register" type="submit" /></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>
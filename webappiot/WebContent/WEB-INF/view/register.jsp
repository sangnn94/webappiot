<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="registerUrl" value="/register"></c:url>
<c:url var="loginUrl" value="/login"></c:url>
<div class="container">
	<div class="wrapper">
		<sf:form id="details" method="post" action="${registerUrl }"
			modelAttribute="user" class="form-signin">
			<h3 class="form-signin-heading">Create a new account</h3>
			<div>
				<hr class="colorgraph">
			</div>
			<div class="form-group">
				<sf:input name="username" path="username" type="text"
					class="form-control" placeholder="Username" />
				<sf:errors path="username"></sf:errors>
			</div>

			<div class="form-group">
				<sf:input name="email" path="email" type="text" class="form-control"
					placeholder="Email" />
				<sf:errors path="email"></sf:errors>
			</div>
			<div class="form-group">
				<sf:input name="password" path="password" type="password"
					class="form-control" placeholder="Password" />
				<sf:errors path="password"></sf:errors>
			</div>

			<div class="form-group">
				<sf:input name="matchingPassword" path="matchingPassword"
					type="password" class="form-control" placeholder="Confirm password" />
			</div>
			<sf:errors></sf:errors>
			<button class="btn btn-lg btn-primary btn-block" name="submit"
				value="Login" type="submit">Sign up</button>
		</sf:form>

	</div>

</div>

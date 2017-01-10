<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<c:url var="newGatewayUrl" value="/new-gateway"></c:url>
<div class="container-fluid">

	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Add new Device</h1>
			<ol class="breadcrumb">
				<li><i class="fa fa-dashboard"></i> <a
					href="${pageContext.request.contextPath}/">WebAppIoT</a></li>
				<li><i class="fa fa-dashboard"></i> <a
					href="${pageContext.request.contextPath}/manage-device">Manage
						device</a></li>
				<li class="active"><i class="fa fa-edit"></i>Add new Device</li>
			</ol>
		</div>
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-6">

			<sf:form method="post" action="${newGatewayUrl }"
				modelAttribute="gateway">
				<div>
					<label>Location</label>
					<sf:select class="form-control" path="location"
						items="${locations }" itemValue="locationId"
						itemLabel="locationName">
					</sf:select>
				</div>
				<div class="form-group">
					<label>Device ID</label>
					<sf:input class="form-control" path="id" placeholder="Enter id" />
					<sf:errors path="id"></sf:errors>
				</div>
				<div class="form-group">
					<label>Address</label>
					<sf:input class="form-control" path="address"
						placeholder="Enter user address" />
					<sf:errors path="address"></sf:errors>
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</sf:form>

		</div>
	</div>


	<!-- /.row -->

</div>
<!-- /.container-fluid -->


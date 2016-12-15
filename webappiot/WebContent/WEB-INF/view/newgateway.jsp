<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<c:url var="newGateway" value="${pageContext.request.contextPath}/manage-device/add-device"></c:url>
<div class="container-fluid">

	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Add new Device</h1>
			<ol class="breadcrumb">
				<li><i class="fa fa-dashboard"></i> <a href="${pageContext.request.contextPath}/">WebAppIoT</a>
				</li>
				<li><i class="fa fa-dashboard"></i> <a
					href="${pageContext.request.contextPath}/manage-device">Manage device</a></li>
				<li class="active"><i class="fa fa-edit"></i>Add new Device</li>
			</ol>
		</div>
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-6">
			
			<sf:form method="post" action="${newGateway}" modelAttribute="gateway">
				<div>
					<label>Location</label> <sf:select class="form-control" path="location">
					<c:forEach items="${location}" var= "location">
						<option>${location.locationName }</option>
					</c:forEach>
					</sf:select>

				</div>
				<div class="form-group">
					<label>Address</label> <sf:input class="form-control" path="address"
						placeholder="Enter user address"/>
				</div>
				<div class="form-group">
					<label>Device ID</label> <sf:input class="form-control" path="id"
						placeholder="Enter id"/>
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
				<!--<button type="reset" class="btn btn-default">Cancel</button>-->
			</sf:form>

		</div>
	</div>


	<!-- /.row -->

</div>
<!-- /.container-fluid -->


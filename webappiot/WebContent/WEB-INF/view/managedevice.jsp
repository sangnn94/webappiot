<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="container-fluid">
	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Manage Device</h1>
			<ol class="breadcrumb">
				<li><i class="fa fa-dashboard"></i> <a
					href="${pageContext.request.contextPath}/">WebAppIoT</a></li>
				<li class="active"><i class="fa fa-edit"></i> Manage Device</li>
				<div class="navbar-right" style="margin-right: 20px">
					<b><a style="margin-right: 20px"
						href="${pageContext.request.contextPath}/manage-device/add-device">Add
							Gateway</a></b>
				</div>
			</ol>

		</div>
	</div>
	<!-- /.row -->
	<div id="page-wrapper">

		<div class="row">
			<div class="col-xs-12 ">
				<h2>List Gateway</h2>
				<div class="table-responsive">
					<table class="table table-bordered table-hover table-striped">
						<thead>
							<tr>
								<th>Device ID</th>
								<th>Device Manager</th>
								<th>Area</th>
								<th>Address</th>
								<th>Child Number</th>
								<th>View Maps</th>
								<th>Manage</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${gateways}" var="gateway">
								<tr>
									<td>${gateway.id}</td>
									<td>${gateway.user.username }</td>
									<td>${gateway.location.locationName}</td>
									<td>${gateway.address}</td>
									<td>${fn:length(gateway.nodes)}</td>
									<td><a
										href="${pageContext.request.contextPath}/manage-device/">View
											<i class="fa fa-arrow-circle-right"></i>
									</a></td>
									<td><a
										href="${pageContext.request.contextPath}/manage-device/add-device"
										class="fa fa-plus-circle"></a> <b>|</b> <a
										href="${pageContext.request.contextPath}/manage-device/add-device"
										class="fa fa-trash"></a></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</div>

		<!-- Row -->
		<div class="row">
			<div class="col-xs-12 ">
				<h2>List Node</h2>
				<div class="table-responsive">
					<table class="table table-bordered table-hover table-striped">
						<thead>
							<tr>
								<th>Device ID</th>
								<th>Gateway ID</th>
								<th>Device Manager</th>
								<th>Area</th>
								<th>Address</th>
								<th>View Maps</th>
								<th>Manage</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${gateways}" var="gateway">
								<c:forEach items="${gateway.nodes }" var="node" >
									<tr>
										<td>${node.id}</td>
										<td>${node.gateway.id}</td>
										<td>${node.gateway.user.username}</td>
										<td>${node.gateway.location.locationName}</td>
										<td>${node.address}</td>
										<td><a
											href="${pageContext.request.contextPath}/manage-device/">View
												<i class="fa fa-arrow-circle-right"></i>
										</a></td>
										<td><a
											href="${pageContext.request.contextPath}/manage-device/add-device"
											class="fa fa-gear"></a> <b>|</b> <a
											href="${pageContext.request.contextPath}/manage-device/add-device"
											class="fa fa-trash"></a></td>
									</tr>
								</c:forEach>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
						href="${pageContext.request.contextPath}/new-gateway">Add
							Gateway</a> </b>
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
								<th>Manage</th>
							</tr>
						</thead>
						<tbody>
							<jstl:forEach items="${gateways.values()}" var="gateway">
								<tr>
									<td>${gateway.id }</td>
									<td>${gateway.user.username }</td>
									<td>${gateway.location.locationName}</td>
									<td>${gateway.address}</td>
									<td>${fn:length(gateway.nodes)}</td>
									<td><a href="${pageContext.request.contextPath}/new-node"
										class="fa fa-plus-circle"></a> <b>|</b> <a href="#"
										class="fa fa-trash"></a></td>
								</tr>
							</jstl:forEach>
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
								<th>Manage</th>
							</tr>
						</thead>
						<tbody>
							<jstl:forEach items="${gateways.values()}" var="gateway">
								<jstl:forEach items="${gateway.nodes.values() }" var="node">
									<tr>
										<td>${node.id}</td>
										<td>${node.gateway.id}</td>
										<td>${node.gateway.user.username}</td>
										<td>${node.gateway.location.locationName}</td>
										<td>${node.address}</td>
										<td><a href="#" class="fa fa-gear"></a> <b>|</b> <a
											href="#" class="fa fa-trash"></a></td>
									</tr>
								</jstl:forEach>
							</jstl:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>

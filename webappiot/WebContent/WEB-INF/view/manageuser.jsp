<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="container-fluid">

	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Manage User</h1>
			<ol class="breadcrumb">
				<li><i class="fa fa-dashboard"></i> <a
					href="${pageContext.request.contextPath}/">WebAppIoT</a></li>
				<li class="active"><i class="fa fa-edit"></i> Manage User</li>

			</ol>
		</div>
	</div>
	<!-- /.row -->

	<div id="page-wrapper">

		<div class="row">
			<div class="col-xs-12 ">
				<h2>List Users</h2>
				<div class="table-responsive">
					<table class="table table-bordered table-hover table-striped">
						<thead>
							<tr>
								<th>Username</th>
								<th>Permission</th>
								<th>Email</th>
								<th>Status</th>
							</tr>
						</thead>
						<tbody>
							<jstl:forEach items="${users }" var="user">
								<jstl:if test="${user.username ne 'admin' }">
									<jstl:choose>
										<jstl:when test="${user.enabled }">
											<tr class="success">
												<td>${user.username }</td>
												<td>${user.permission }</td>
												<td>${user.email }</td>
												<td><a href="#">Disable</a></td>
											</tr>
										</jstl:when>
										<jstl:otherwise>
											<tr class="danger">
												<td>${user.username }</td>
												<td>${user.permission }</td>
												<td>${user.email }</td>
												<td><a href="#">Enable</a></td>
											</tr>
										</jstl:otherwise>
									</jstl:choose>
								</jstl:if>
							</jstl:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- /.row -->

</div>
<!-- /.container-fluid -->


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Manage Device</title>

<!-- Bootstrap Core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- Custom CSS -->
<link href='<c:url value="/resources/css/sb-admin.css" />'
	rel="stylesheet">


<!-- Custom Fonts -->
<link
	href='<c:url value="/resources/font-awesome/css/font-awesome.min.css" />'
	rel="stylesheet" type="text/css">
</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/webappiot/">Administrator</a>
			</div>
			<!-- 	Top Menu Items -->
			<ul class="nav navbar-right top-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-bell"></i> <b
						class="caret"></b></a>
					<ul class="dropdown-menu alert-dropdown">
						<li><a href="#">Alert Name <span
								class="label label-default">Alert Badge</span></a></li>
						<li><a href="#">Alert Name <span
								class="label label-primary">Alert Badge</span></a></li>
						<li><a href="#">Alert Name <span
								class="label label-success">Alert Badge</span></a></li>
						<li><a href="#">Alert Name <span class="label label-info">Alert
									Badge</span></a></li>
						<li><a href="#">Alert Name <span
								class="label label-warning">Alert Badge</span></a></li>
						<li><a href="#">Alert Name <span
								class="label label-danger">Alert Badge</span></a></li>
						<li class="divider"></li>
						<li><a href="#">View All</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-user"></i> <b
						class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#"><i class="fa fa-fw fa-user"></i> Profile</a></li>
						<li><a href="#"><i class="fa fa-fw fa-envelope"></i>
								Inbox</a></li>
						<li><a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
						</li>
						<li class="divider"></li>
						<li><a href="#"><i class="fa fa-fw fa-power-off"></i> Log
								Out</a></li>
					</ul></li>
			</ul>
			<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li><a href="/webappiot/"><i class="fa fa-fw fa-dashboard"></i>
							Overview</a></li>
					<li class="active"><a href="/webappiot/manage-device"><i
							class="fa fa-fw fa-edit"></i> Manage Device</a></li>
					<li><a href="/webappiot/manage-user"><i
							class="fa fa-fw fa-edit"></i> Manage User</a></li>
					<li><a href="/webappiot/about"><i class="fa fa-fw fa-user"></i>
							About</a></li>
				</ul>
			</div>
		</nav>

		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Manage Device</h1>
						<ol class="breadcrumb">
							<li><i class="fa fa-dashboard"></i> <a href="/webappiot/">WebAppIoT</a></li>
							<li class="active"><i class="fa fa-edit"></i> Manage Device</li>
							<b><a class="navbar-right" style="margin-right: 20px"
								href="/webappiot/manage-device/add-device">Add Device</a></b>
						</ol>

					</div>
				</div>
				<!-- /.row -->
				<div id="page-wrapper">

					<div class="row">
						<div class="col-xs-12 ">
							<h2>List Devices</h2>
							<div class="table-responsive">
								<table class="table table-bordered table-hover table-striped" >
									<thead>
										<tr>
											<th>Device</th>
											<th>Type</th>
											<th>Device Manager</th>
											<th>Area</th>
											<th>Address</th>
											<th>Created Date</th>
										</tr>
									</thead>
									<tbody>
										<tr class="active">
											<td>/index.html</td>
											<td>1265</td>
											<td>32.3%</td>
											<td>Khu phố 6, P. Linh Trung Quận Thủ Đức, Tp. Hồ Chí Minh</td>
											<td>Khu phố 6, P. Linh Trung Quận Thủ Đức, Tp. Hồ Chí
												Minh</td>
											<td>32.3%</td>

										</tr>
										<tr class="success">
											<td>/about.html</td>
											<td>261</td>
											<td>33.3%</td>
											<td>$234.12</td>
											<td>Khu phố 6, P. Linh Trung Quận Thủ Đức, Tp. Hồ Chí
												Minh</td>
											<td>32.3%</td>
										</tr>
										<tr class="warning">
											<td>/sales.html</td>
											<td>665</td>
											<td>21.3%</td>
											<td>$16.34</td>
											<td>Khu phố 6, P. Linh Trung Quận Thủ Đức, Tp. Hồ Chí
												Minh</td>
											<td>32.3%</td>
										</tr>
										<tr class="danger">
											<td>/blog.html</td>
											<td>9516</td>
											<td>89.3%</td>
											<td>$1644.43</td>
											<td>Khu phố 6, P. Linh Trung Quận Thủ Đức, Tp. Hồ Chí
												Minh</td>
											<td>32.3%</td>
										</tr>
										<tr>
											<td>/404.html</td>
											<td>23</td>
											<td>34.3%</td>
											<td>$23.52</td>
											<td>Khu phố 6, P. Linh Trung Quận Thủ Đức, Tp. Hồ Chí
												Minh</td>
											<td>32.3%</td>
										</tr>
										<tr>
											<td>/services.html</td>
											<td>421</td>
											<td>60.3%</td>
											<td>$724.32</td>
											<td>Khu phố 6, P. Linh Trung Quận Thủ Đức, Tp. Hồ Chí
												Minh</td>
											<td>32.3%</td>
										</tr>
										<tr>
											<td>/blog/post.html</td>
											<td>1233</td>
											<td>93.2%</td>
											<td>$126.34</td>
											<td>Khu phố 6, P. Linh Trung Quận Thủ Đức, Tp. Hồ Chí
												Minh</td>
											<td>32.3%</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src='<c:url value="/resources/js/jquery.js" />'></script>

	<!-- Bootstrap Core JavaScript -->
	<script src='<c:url value="/resources/js/bootstrap.min.js" />'></script>
</body>

</html>

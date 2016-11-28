<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html >
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">


<title><tiles:insertAttribute name="title" /></title>

<!-- Bootstrap Core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- Custom CSS -->
<link href='<c:url value="/resources/css/sb-admin.css" />'
	rel="stylesheet">


<!-- Morris Charts CSS -->
<link href='<c:url value="/resources/css/plugins/morris.css" />'
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href='<c:url value="/resources/font-awesome/css/font-awesome.min.css" />'
	rel="stylesheet" type="text/css">

<!-- jQuery -->
<script src='<c:url value="/resources/js/jquery.js" />'></script>
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
					<li><a href="${pageContext.request.contextPath}/"><i
							class="fa fa-fw fa-dashboard"></i> Overview</a></li>
					<li><a href="${pageContext.request.contextPath}/manage-device"><i
							class="fa fa-fw fa 	fa fa-cubes"></i> Manage Device</a></li>
					<li><a href="${pageContext.request.contextPath}/manage-user"><i
							class="fa fa-fw fa fa fa fa-cogs"></i> Manage User</a></li>
					<li><a href="${pageContext.request.contextPath}/report"><i
							class="fa fa-fw fa fa-list-alt"></i> Report</a></li>
					<li><a href="${pageContext.request.contextPath}/about"><i
							class="fa fa-fw fa-user"></i> About</a></li>
				</ul>
			</div>
			<!-- content -->
		</nav>
		<div id="page-wrapper">
			<tiles:insertAttribute name="content" />

		</div>
	</div>

	<!-- Bootstrap Core JavaScript -->
	<script src='<c:url value="/resources/js/bootstrap.min.js" />'></script>
	<script src='<c:url value="/resources/js/sidebar.js" />'></script>

	<!-- Morris Charts JavaScript -->
	<script
		src='<c:url value="/resources/js/plugins/morris/raphael.min.js" />'></script>
	<script
		src='<c:url value="/resources/js/plugins/morris/morris.min.js" />'></script>
	<script
		src='<c:url value="/resources/js/plugins/morris/morris-data.js" />'></script>
</body>
</html>
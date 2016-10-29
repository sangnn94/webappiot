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
				<a class="navbar-brand" href="">Administrator</a>
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
					<li ><a href="/webappiot/"><i
							class="fa fa-fw fa-dashboard"></i> Overview</a></li>
					<li><a href="/webappiot/manage-device"><i
							class="fa fa-fw fa-edit"></i> Manage Device</a></li>
					<li class="active"><a href="/webappiot/manage-user"><i class="fa fa-fw fa-edit"></i>
							Manage User</a></li>
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
						<h1 class="page-header">Manage User</h1>
						<ol class="breadcrumb">
							<li><i class="fa fa-dashboard"></i> <a href="/webappiot/">WebAppIoT</a>
							</li>
							<li class="active"><i class="fa fa-edit"></i> Manage User</li>
						</ol>
					</div>
				</div>
				<!-- /.row -->

				<div class="row">
					<div class="col-lg-6">

						<form role="form">

							<div class="form-group">
								<label>Text Input</label> <input class="form-control">
								<p class="help-block">Example block-level help text here.</p>
							</div>

							<div class="form-group">
								<label>Text Input with Placeholder</label> <input
									class="form-control" placeholder="Enter text">
							</div>

							<div class="form-group">
								<label>Static Control</label>
								<p class="form-control-static">email@example.com</p>
							</div>

							<div class="form-group">
								<label>File input</label> <input type="file">
							</div>

							<div class="form-group">
								<label>Text area</label>
								<textarea class="form-control" rows="3"></textarea>
							</div>

							<div class="form-group">
								<label>Checkboxes</label>
								<div class="checkbox">
									<label> <input type="checkbox" value="">Checkbox
										1
									</label>
								</div>
								<div class="checkbox">
									<label> <input type="checkbox" value="">Checkbox
										2
									</label>
								</div>
								<div class="checkbox">
									<label> <input type="checkbox" value="">Checkbox
										3
									</label>
								</div>
							</div>

							<div class="form-group">
								<label>Inline Checkboxes</label> <label class="checkbox-inline">
									<input type="checkbox">1
								</label> <label class="checkbox-inline"> <input type="checkbox">2
								</label> <label class="checkbox-inline"> <input type="checkbox">3
								</label>
							</div>

							<div class="form-group">
								<label>Radio Buttons</label>
								<div class="radio">
									<label> <input type="radio" name="optionsRadios"
										id="optionsRadios1" value="option1" checked>Radio 1
									</label>
								</div>
								<div class="radio">
									<label> <input type="radio" name="optionsRadios"
										id="optionsRadios2" value="option2">Radio 2
									</label>
								</div>
								<div class="radio">
									<label> <input type="radio" name="optionsRadios"
										id="optionsRadios3" value="option3">Radio 3
									</label>
								</div>
							</div>

							<div class="form-group">
								<label>Inline Radio Buttons</label> <label class="radio-inline">
									<input type="radio" name="optionsRadiosInline"
									id="optionsRadiosInline1" value="option1" checked>1
								</label> <label class="radio-inline"> <input type="radio"
									name="optionsRadiosInline" id="optionsRadiosInline2"
									value="option2">2
								</label> <label class="radio-inline"> <input type="radio"
									name="optionsRadiosInline" id="optionsRadiosInline3"
									value="option3">3
								</label>
							</div>

							<div class="form-group">
								<label>Selects</label> <select class="form-control">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
								</select>
							</div>

							<div class="form-group">
								<label>Multiple Selects</label> <select multiple
									class="form-control">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
								</select>
							</div>

							<button type="submit" class="btn btn-default">Submit
								Button</button>
							<button type="reset" class="btn btn-default">Reset
								Button</button>

						</form>

					</div>
					<div class="col-lg-6">
						<h1>Disabled Form States</h1>

						<form role="form">

							<fieldset disabled>

								<div class="form-group">
									<label for="disabledSelect">Disabled input</label> <input
										class="form-control" id="disabledInput" type="text"
										placeholder="Disabled input" disabled>
								</div>

								<div class="form-group">
									<label for="disabledSelect">Disabled select menu</label> <select
										id="disabledSelect" class="form-control">
										<option>Disabled select</option>
									</select>
								</div>

								<div class="checkbox">
									<label> <input type="checkbox">Disabled
										Checkbox
									</label>
								</div>

								<button type="submit" class="btn btn-primary">Disabled
									Button</button>

							</fieldset>

						</form>

						<h1>Form Validation</h1>

						<form role="form">

							<div class="form-group has-success">
								<label class="control-label" for="inputSuccess">Input
									with success</label> <input type="text" class="form-control"
									id="inputSuccess">
							</div>

							<div class="form-group has-warning">
								<label class="control-label" for="inputWarning">Input
									with warning</label> <input type="text" class="form-control"
									id="inputWarning">
							</div>

							<div class="form-group has-error">
								<label class="control-label" for="inputError">Input with
									error</label> <input type="text" class="form-control" id="inputError">
							</div>

						</form>

						<h1>Input Groups</h1>

						<form role="form">

							<div class="form-group input-group">
								<span class="input-group-addon">@</span> <input type="text"
									class="form-control" placeholder="Username">
							</div>

							<div class="form-group input-group">
								<input type="text" class="form-control"> <span
									class="input-group-addon">.00</span>
							</div>

							<div class="form-group input-group">
								<span class="input-group-addon"><i class="fa fa-eur"></i></span>
								<input type="text" class="form-control"
									placeholder="Font Awesome Icon">
							</div>

							<div class="form-group input-group">
								<span class="input-group-addon">$</span> <input type="text"
									class="form-control"> <span class="input-group-addon">.00</span>
							</div>

							<div class="form-group input-group">
								<input type="text" class="form-control"> <span
									class="input-group-btn"><button class="btn btn-default"
										type="button">
										<i class="fa fa-search"></i>
									</button></span>
							</div>

						</form>

						<p>
							For complete documentation, please visit <a
								href="http://getbootstrap.com/css/#forms">Bootstrap's Form
								Documentation</a>.
						</p>

					</div>
				</div>
				<!-- /.row -->

			</div>
			<!-- /.container-fluid -->

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
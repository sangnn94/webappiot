<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="container-fluid">
	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Statistics Overview</h1>
			<ol class="breadcrumb">
				<li><i class="fa fa-dashboard"></i> <a
					href="${pageContext.request.contextPath}/">WebAppIoT</a></li>
				<li class="active"><i class="fa fa-edit"></i> Statistics
					Overview</li>
			</ol>
		</div>
	</div>

	<!-- /.row -->
	<!-- /.row -->

	<div class="row">
		<div class="col-lg-3 col-md-6">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<div class="row">
						<div class="col-xs-3">
							<i class="fa fa-tasks fa-5x"></i>
						</div>
						<div class="col-xs-9 text-right">
							<div>
								<h3>Statistics</h3>
							</div>
							<div>Description</div>
						</div>
					</div>
				</div>
				<a href="#">
					<div class="panel-footer">
						<span class="pull-left">View</span> <span class="pull-right"><i
							class="fa fa-arrow-circle-right"></i></span>
						<div class="clearfix"></div>
					</div>
				</a>
			</div>
		</div>
		<div class="col-lg-3 col-md-6">
			<div class="panel panel-green">
				<div class="panel-heading">
					<div class="row">
						<div class="col-xs-3">
							<i class="fa fa-bar-chart-o fa-5x"></i>
						</div>
						<div class="col-xs-9 text-right">
							<div>
								<h3>Chart</h3>
							</div>
							<div>Description</div>
						</div>
					</div>
				</div>
				<a href="#">
					<div class="panel-footer">
						<span class="pull-left">View</span> <span class="pull-right"><i
							class="fa fa-arrow-circle-right"></i></span>
						<div class="clearfix"></div>
					</div>
				</a>
			</div>
		</div>
		<div class="col-lg-3 col-md-6">
			<div class="panel panel-yellow">
				<div class="panel-heading">
					<div class="row">
						<div class="col-xs-3">
							<i class="fa fa-map-marker fa-5x"></i>
						</div>
						<div class="col-xs-9 text-right">
							<div>
								<h3>Maps</h3>
							</div>
							<div>Description</div>
						</div>
					</div>
				</div>
				<a href="/webappiot/overview/maps">
					<div class="panel-footer">
						<span class="pull-left">View</span> <span class="pull-right"><i
							class="fa fa-arrow-circle-right"></i></span>
						<div class="clearfix"></div>
					</div>
				</a>
			</div>
		</div>
		<div class="col-lg-3 col-md-6">
			<div class="panel panel-red">
				<div class="panel-heading">
					<div class="row">
						<div class="col-xs-3">
							<i class="fa fa-support fa-5x"></i>
						</div>
						<div class="col-xs-9 text-right">
							<div>
								<h3>Sensor</h3>
							</div>
							<div>Description</div>
						</div>
					</div>
				</div>
				<a href="#">
					<div class="panel-footer">
						<span class="pull-left">View</span> <span class="pull-right"><i
							class="fa fa-arrow-circle-right"></i></span>
						<div class="clearfix"></div>
					</div>
				</a>
			</div>
		</div>
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<i class="fa fa-bar-chart-o fa-fw"></i> Area Chart
					</h3>
				</div>
				<div class="panel-body">
					<div id="morris-area-chart"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.row -->

	<div class="row">
		<div class="col-lg-4">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<i class="fa fa-long-arrow-right fa-fw"></i> Donut Chart
					</h3>
				</div>
				<div class="panel-body">
					<div id="morris-donut-chart"></div>
					<div class="text-right">
						<a href="#">View Details <i class="fa fa-arrow-circle-right"></i></a>
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-4">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<i class="fa fa-money fa-fw"></i> Transactions Panel
					</h3>
				</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-bordered table-hover table-striped">
							<thead>
								<tr>
									<th>Order #</th>
									<th>Order Date</th>
									<th>Order Time</th>
									<th>Amount (USD)</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>3326</td>
									<td>10/21/2013</td>
									<td>3:29 PM</td>
									<td>$321.33</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="text-right">
						<a href="#">View All Transactions <i
							class="fa fa-arrow-circle-right"></i></a>
					</div>

				</div>
			</div>
		</div>
	</div>
	<!-- /.row -->

</div>
<!-- /.container-fluid -->


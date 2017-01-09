<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container-fluid">

	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Report</h1>
			<ol class="breadcrumb">
				<li><i class="fa fa-dashboard"></i> <a
					href="${pageContext.request.contextPath}/">WebAppIoT</a></li>
				<li class="active"><i class="fa fa-edit"></i> Report</li>
			</ol>
		</div>
	</div>
	<!-- row -->
	<div class="row">
		<div class="col-lg-12">
			<form class="form-inline" action="">
				<div class="form-group">
					<label>From &nbsp; </label><input class="form-control" type="date" />
				</div>
				<div class="form-group">
					<label> &nbsp; To &nbsp; </label><input class="form-control"
						type="date" />
				</div>
				<button type="submit" class="btn btn-info" style="margin-left: 5px">View
					Report</button>
			</form>
		</div>
	</div>
	
	<!-- row -->
	<div class="row">
		<div class="col-lg-12">
				<div class="panel-heading">
					<h3 > </h3>
				</div>
				<div >
					<div class="table-responsive">
						<table class="table table-bordered table-hover table-striped">
							<thead>
								<tr>
									<th>Location</th>
									<th>Date</th>
									<th>SO2</th>
									<th>CO</th>
									<th>NO2</th>
									<th>O3</th>
									<th>TSP</th>
									<th>PM10</th>
									<th>PM2.5</th>
									<th>Pb</th>
									
								</tr>
							</thead>
							<tbody>
								
							</tbody>
						</table>
					</div>
				</div>
		</div>
	</div>
</div>



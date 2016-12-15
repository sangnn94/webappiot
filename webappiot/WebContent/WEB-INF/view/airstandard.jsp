<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container-fluid">

	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Air Standard</h1>
			<ol class="breadcrumb">
				<li><i class="fa fa-dashboard"></i> <a
					href="${pageContext.request.contextPath}/">Overview</a></li>
				<li class="active"><i class="fa fa-edit"></i> Air Standard</li>
			</ol>
		</div>
	</div>
	
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<i class="fa fa-table fa-fw"></i> WHO Air Quality
					</h3>
				</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-bordered table-hover table-striped">
							<thead>
								<tr>
									<th>Air</th>
									<th>One Year</th>
									<th>24 hours</th>
									<th>8 hours</th>
									<th>1 hour</th>
									<th>10 minutes</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>PM2.5</td>
									<td>10 μg/m3</td>
									<td>25 μg/m3</td>
									<td>-</td>
									<td>-</td>
									<td>-</td>
								</tr>
								
								<tr>
									<td>PM10</td>
									<td>20 μg/m3</td>
									<td>50 μg/m3</td>
									<td>-</td>
									<td>-</td>
									<td>-</td>
								</tr>
								
								<tr>
									<td>Ozone</td>
									<td>-</td>
									<td>-</td>
									<td>100 μg/m3</td>
									<td>-</td>
									<td>-</td>
								</tr>
								
								<tr>
									<td>NO2</td>
									<td>40 μg/m3</td>
									<td>-</td>
									<td>-</td>
									<td>200 μg/m3</td>
									<td>-</td>
								</tr>
								
								<tr>
									<td>SO2</td>
									<td>-</td>
									<td>20 μg/m3</td>
									<td>-</td>
									<td>-</td>
									<td>500 μg/m3</td>
								</tr>
								

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<i class="fa fa-table fa-fw"></i> Vietnam Air Quality
					</h3>
				</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-bordered table-hover table-striped">
							<thead>
								<tr>
									<th>Air</th>
									<th>1 hour</th>
									<th>8 hours</th>
									<th>24 hours</th>
									<th>One Year</th>
														
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>CO</td>
									<td>30000 μg/m3</td>
									<td>10000 μg/m3</td>
									<td>-</td>
									<td>-</td>
									
								</tr>
								
								<tr>
									<td>SO2</td>
									<td>350 μg/m3</td>
									<td>-</td>
									<td>125 μg/m3</td>
									<td>50 μg/m3</td>
									
								</tr>
								
								<tr>
									<td>Ozone</td>
									<td>200 μg/m3</td>
									<td>120 μg/m3</td>
									<td>-</td>
									<td>-</td>
									
								</tr>
								<tr>
									<td>NO2</td>
									<td>200 μg/m3</td>
									<td>-</td>
									<td>100 μg/m3</td>
									<td>40 μg/m3</td>
								
								</tr>
								
								<tr>
									<td>Pb</td>
									<td>-</td>
									<td>-</td>
									<td>1.5 μg/m3</td>
									<td>0.5 μg/m3</td>
									
								</tr>
								
								
								
								<tr>
									<td>TSP</td>
									<td>300 μg/m3</td>
									<td>200 μg/m3</td>
									<td>-</td>
									<td>100 μg/m3</td>
								</tr>
								
								<tr>
									<td>PM10</td>
									<td>-</td>
									<td>-</td>
									<td>150 μg/m3</td>
									<td>50 μg/m3</td>
								</tr>
								
								<tr>
									<td>PM25</td>
									
									<td>-</td>
									<td>-</td>
									<td>50 μg/m3</td>
									<td>25 μg/m3</td>
								</tr>
								

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>
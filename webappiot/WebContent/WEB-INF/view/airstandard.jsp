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
									<th class="info">Air</th>
									<th class="info">One Year</th>
									<th class="info">24 hours</th>
									<th class="info">8 hours</th>
									<th class="info">1 hour</th>
									<th class="info">10 minutes</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="info">PM2.5</td>
									<td class="danger">10 μg/m3</td>
									<td class="danger">25 μg/m3</td>
									<td>-</td>
									<td>-</td>
									<td>-</td>
								</tr>
								
								<tr>
									<td class="info">PM10</td>
									<td class="danger">20 μg/m3</td>
									<td class="danger">50 μg/m3</td>
									<td>-</td>
									<td>-</td>
									<td>-</td>
								</tr>
								
								<tr>
									<td class="info">Ozone</td>
									<td>-</td>
									<td>-</td>
									<td class="danger">100 μg/m3</td>
									<td>-</td>
									<td>-</td>
								</tr>
								
								<tr>
									<td class="info">NO2</td>
									<td class="danger">40 μg/m3</td>
									<td>-</td>
									<td>-</td>
									<td class="danger">200 μg/m3</td>
									<td>-</td>
								</tr>
								
								<tr>
									<td class="info">SO2</td>
									<td>-</td>
									<td class="danger">20 μg/m3</td>
									<td>-</td>
									<td>-</td>
									<td class="danger">500 μg/m3</td>
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
									<th class="info">Air</th>
									<th class="info">1 hour</th>
									<th class="info">8 hours</th>
									<th class="info">24 hours</th>
									<th class="info">One Year</th>
														
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="info">CO</td>
									<td class="danger">30000 μg/m3</td>
									<td class="danger">10000 μg/m3</td>
									<td>-</td>
									<td>-</td>
									
								</tr>
								
								<tr>
									<td class="info">SO2</td>
									<td class="danger">350 μg/m3</td>
									<td>-</td>
									<td class="danger">125 μg/m3</td>
									<td class="danger">50 μg/m3</td>
									
								</tr>
								
								<tr>
									<td class="info">Ozone</td>
									<td class="danger">200 μg/m3</td>
									<td class="danger">120 μg/m3</td>
									<td>-</td>
									<td>-</td>
									
								</tr>
								<tr>
									<td class="info">NO2</td>
									<td class="danger">200 μg/m3</td>
									<td>-</td>
									<td class="danger">100 μg/m3</td>
									<td class="danger">40 μg/m3</td>
								
								</tr>
								
								<tr>
									<td class="info">Pb</td>
									<td>-</td>
									<td>-</td>
									<td class="danger">1.5 μg/m3</td>
									<td class="danger">0.5 μg/m3</td>
									
								</tr>
								
								
								
								<tr>
									<td class="info">TSP</td>
									<td class="danger">300 μg/m3</td>
									<td class="danger">200 μg/m3</td>
									<td>-</td>
									<td class="danger">100 μg/m3</td>
								</tr>
								
								<tr>
									<td class="info">PM10</td>
									<td>-</td>
									<td>-</td>
									<td class="danger">150 μg/m3</td>
									<td class="danger">50 μg/m3</td>
								</tr>
								
								<tr>
									<td class="info">PM25</td>
									
									<td>-</td>
									<td>-</td>
									<td class="danger">50 μg/m3</td>
									<td class="danger">25 μg/m3</td>
								</tr>
								

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>
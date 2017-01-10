<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src='<c:url value="/resources/js/table.js" />'></script>
<script type="text/javascript">
	$(document).ready(function() {
		  $("#btnExport").click(function(e) {
		    e.preventDefault();
	
		    //getting data from our table
		    var data_type = 'data:application/vnd.ms-excel';
		    var table_div = document.getElementById('divTBRecord');
		    var table_html = table_div.outerHTML.replace(/ /g, '%20');
	
		    var ep = document.createElement('a');
		    ep.href = data_type + ', ' + table_html;
		    ep.download = 'Report.xls';
		    ep.click();
		  });
		});
</script>

<STYLE TYPE="text/css">
	.colorBlue
	{
	background-color:#FFF8EE;
	}
	.colorWhite
	{
	background-color:#FFFFFF;
	color:white;
	}
</STYLE>


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
				<div class="panel-heading ">
					<form class="form-inline " action="${pageContext.request.contextPath}/report/view" method="get">
						<div class="form-group">
							<label>From &nbsp; </label><input name="from" class="form-control" type="date" />
						</div>
						<div class="form-group">
							<label> &nbsp; To &nbsp; </label><input name = "to" class="form-control"
								type="date" />
						</div>
						<button type="submit" class="btn btn-info" style="margin-left: 5px">View</button>
						<button id="btnExport" type="button" class="btn btn-info" style="margin-left: 5px">Export</button>
					</form>
					
				</div>
				<div class="panel-body">
					<div id = "divTBRecord" class="table-responsive">
						<table class="table table-bordered table-hover table-striped"
							id="tbRecord">
							<thead>
								<tr>
									<th>location</th>
									<th>Date</th>
									<th>Air</th>
									<th>Value (μg/m3)</th>
									<th>Evaluation</th>
									
								</tr>
							</thead>
							<tbody>
							
								<c:forEach items="${records}" var="record">
									<tr id="${record.location.locationId }" >
										<td>${record.location.locationName }</td>
										<td>${record.date }</td>										
										<td>${record.air.name }</td>
										<td>${record.value }</td>
										<td>${record.evaluation }</td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
			</div>
		</div>
	</div>
</div>



<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="container-fluid">
	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Statistics Chart</h1>
			<ol class="breadcrumb">
				<li><i class="fa fa-dashboard"></i> <a
					href="${pageContext.request.contextPath}/">WebAppIoT</a></li>
				<li class="active"><i class="fa fa-edit"></i> Statistics Chart</li>
			</ol>
		</div>
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<i class="fa fa-bar-chart-o fa-fw"></i> Overview
					</h3>
				</div>
				<div class="panel-body">
					<div id="chartOverview" style="height: 400px; width: 100%;"></div>
				</div>
			</div>
		</div>
	</div>

	<!-- /.row -->

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<i class="fa fa-long-arrow-right fa-fw"></i> Carbon Monoxide
					</h3>
				</div>
				<div class="panel-body">
					<div id="chartContainer" style="height: 300px; width: 100%;"></div>
				</div>
			</div>
		</div>
	</div>

	<!-- /.row -->
	<!-- /.row -->

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<i class="fa fa-long-arrow-right fa-fw"></i> SO2
					</h3>
				</div>
				<div class="panel-body">
					<div id="morris-donut-chart"></div>
				</div>
			</div>
		</div>
	</div>

	<!-- /.row -->
	<!-- /.row -->

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<i class="fa fa-long-arrow-right fa-fw"></i> O3
					</h3>
				</div>
				<div class="panel-body">
					<div id="morris-donut-chart"></div>
				</div>
			</div>
		</div>
	</div>

	<!-- /.row -->
	<!-- /.row -->

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<i class="fa fa-long-arrow-right fa-fw"></i> Pb
					</h3>
				</div>
				<div class="panel-body">
					<div id="morris-donut-chart"></div>
				</div>
			</div>
		</div>
	</div>

	<!-- /.row -->
	<!-- /.row -->

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<i class="fa fa-long-arrow-right fa-fw"></i> TSL
					</h3>
				</div>
				<div class="panel-body">
					<div id="morris-donut-chart"></div>
				</div>
			</div>
		</div>
	</div>

	<!-- /.row -->
	<!-- /.row -->

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<i class="fa fa-long-arrow-right fa-fw"></i> PM2.5
					</h3>
				</div>
				<div class="panel-body">
					<div id="morris-donut-chart"></div>
				</div>
			</div>
		</div>
	</div>

	<!-- /.row -->
	<!-- /.row -->

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<i class="fa fa-long-arrow-right fa-fw"></i> PM10
					</h3>
				</div>
				<div class="panel-body">
					<div id="morris-donut-chart"></div>
				</div>
			</div>
		</div>
	</div>

	<!-- /.row -->
</div>

<!-- /.container-fluid -->
<!-- script column chart -->
<script type="text/javascript">
	var dataColumn = [{
			x : 90,
			y : 1000,
			label : "Quận Bình Thạnh"
		}, {
			x : 80,
			y : 5000,
			indexLabel : "Highest",
			label : "Quận Thủ Đức"
		}, {
			x : 100,
			y : 1000,
			label : "Quận Tân Bình"
		}, {
			x : 10,
			y : 1000,
			label : "Quận 1"
		}, {
			x : 20,
			y : 1000,
			label : "Quận 2"
		}, {
			x : 30,
			y : 1000,
			label : "Quận 3"
		}, {
			x : 40,
			y : 1000,
			label : "Quận 5"
		}, {
			x : 50,
			y : 1000,
			label : "Quận 7"
		}, {
			x : 60,
			y : 1000,
			label : "Quận 10"
		}, {
			x : 70,
			y : 1000,
			label : "Quận 11"
		}];
	
	var dataLine = [ {
			type : "spline",
			showInLegend : true,
			name : "CO",
			dataPoints : [ {
			
				y : 1000,
				label : "Quận Bình Thạnh"
			}, {
				
				y : 5000,
				indexLabel : "High",
				label : "Quận Thủ Đức"
			}, {
			
				y : 1000,
				label : "Quận Tân Bình"
			}, {
				
				y : 1000,
				label : "Quận 1"
			}, {
				
				y : 1000,
				label : "Quận 2"
			}, {
				
				y : 1000,
				label : "Quận 3"
			}, {
			
				y : 1000,
				label : "Quận 5"
			}, {
			
				y : 1000,
				label : "Quận 7"
			}, {
			
				y : 1000,
				label : "Quận 10"
			}, {
				
				y : 1000,
				label : "Quận 11"
			} ]
		}, {
			type : "spline",
			showInLegend : true,
			name : "SO2",
			dataPoints : [ {
				
				y : 1000,
				label : "Quận Bình Thạnh"
			}, {
				
				y : 1000,
				label : "Quận Thủ Đức"
			}, {
			
				y : 1000,
				label : "Quận Tân Bình"
			}, {
				
				y : 1000,
				label : "Quận 1"
			}, {
				
				y : 1000,
				label : "Quận 2"
			}, {
				
				y : 1000,
				label : "Quận 3"
			}, {
			
				y : 1000,
				label : "Quận 5"
			}, {
			
				y : 1000,
				label : "Quận 7"
			}, {
			
				y : 1000,
				label : "Quận 10"
			}, {
				
				y : 1000,
				label : "Quận 11"
			} ]
		}, {
			type : "spline",
			showInLegend : true,
			name : "O3",
			dataPoints : [ {
				
				y : 1000,
				label : "Quận Bình Thạnh"
			}, {
				
				y : 1000,
				label : "Quận Thủ Đức"
			}, {
			
				y : 1000,
				label : "Quận Tân Bình"
			}, {
				
				y : 1000,
				label : "Quận 1"
			}, {
				
				y : 1000,
				label : "Quận 2"
			}, {
				
				y : 1000,
				label : "Quận 3"
			}, {
			
				y : 1000,
				label : "Quận 5"
			}, {
			
				y : 1000,
				label : "Quận 7"
			}, {
			
				y : 1000,
				label : "Quận 10"
			}, {
				
				y : 1000,
				label : "Quận 11"
			} ]
		}, {
			type : "spline",
			showInLegend : true,
			name : "Pb",
			dataPoints : [ {
				
				y : 1000,
				label : "Quận Bình Thạnh"
			}, {
				
				y : 1000,
				label : "Quận Thủ Đức"
			}, {
			
				y : 1000,
				label : "Quận Tân Bình"
			}, {
				
				y : 1000,
				label : "Quận 1"
			}, {
				
				y : 1000,
				label : "Quận 2"
			}, {
				
				y : 1000,
				label : "Quận 3"
			}, {
			
				y : 1000,
				label : "Quận 5"
			}, {
			
				y : 1000,
				label : "Quận 7"
			}, {
			
				y : 1000,
				label : "Quận 10"
			}, {
				
				y : 1000,
				label : "Quận 11"
			} ]
		}, {
			type : "spline",
			showInLegend : true,
			name : "TSL",
			dataPoints : [ {
				
				y : 1000,
				label : "Quận Bình Thạnh"
			}, {
				
				y : 1000,
				label : "Quận Thủ Đức"
			}, {
			
				y : 1000,
				label : "Quận Tân Bình"
			}, {
				
				y : 1000,
				label : "Quận 1"
			}, {
				
				y : 1000,
				label : "Quận 2"
			}, {
				
				y : 1000,
				label : "Quận 3"
			}, {
				
				y : 1000,
				label : "Quận 5"
			}, {
			
				y : 1000,
				label : "Quận 7"
			}, {
			
				y : 1000,
				label : "Quận 10"
			}, {
				
				y : 1000,
				label : "Quận 11"
			} ]
		}, {
			type : "spline",
			showInLegend : true,
			name : "PM2.5",
			dataPoints : [ {
				
				y : 1000,
				label : "Quận Bình Thạnh"
			}, {
				
				y : 1000,
				label : "Quận Thủ Đức"
			}, {
			
				y : 1000,
				label : "Quận Tân Bình"
			}, {
				
				y : 1000,
				label : "Quận 1"
			}, {
				
				y : 1000,
				label : "Quận 2"
			}, {
				
				y : 1000,
				label : "Quận 3"
			}, {
				
				y : 1000,
				label : "Quận 5"
			}, {
			
				y : 1000,
				label : "Quận 7"
			}, {
			
				y : 1000,
				label : "Quận 10"
			}, {
				
				y : 1000,
				label : "Quận 11"
			} ]
		}, {
			type : "spline",
			showInLegend : true,
			name : "PM10",
			dataPoints : [ {
				
				y : 1000,
				label : "Quận Bình Thạnh"
			}, {
				
				y : 1000,
				label : "Quận Thủ Đức"
			}, {
			
				y : 1000,
				label : "Quận Tân Bình"
			}, {
				
				y : 1000,
				label : "Quận 1"
			}, {
				
				y : 1000,
				label : "Quận 2"
			}, {
				
				y : 1000,
				label : "Quận 3"
			}, {
				
				y : 1000,
				label : "Quận 5"
			}, {
			
				y : 1000,
				label : "Quận 7"
			}, {
			
				y : 1000,
				label : "Quận 10"
			}, {
				
				y : 1000,
				label : "Quận 11"
			} ]
		} 
	]

	window.onload = function() {
		var columnChart = new CanvasJS.Chart("chartContainer", {
			title : {
				text : "Carbon Monoxide (CO)"
			},
			axisX : {
				interval : 10
			},
			dataPointWidth : 60,
			data : [ {
				type : "column",
				dataPoints : dataColumn
			} ]
		});
		var lineChart = new CanvasJS.Chart(
				"chartOverview",
				{
					title : {
						text : "Overview Daily"
					},
					animationEnabled : true,
					axisY : {
						title : "mg/m3",
						includeZero : false
					},
					axisX : {
						interval : 1
					},
					toolTip : {
						shared : true,
						content : function(e) {
							var body = new String;
							var head;
							for (var i = 0; i < e.entries.length; i++) {
								var str = "<span style= 'color:"+e.entries[i].dataSeries.color + "'> "
										+ e.entries[i].dataSeries.name
										+ "</span>: <strong>"
										+ e.entries[i].dataPoint.y
										+ "</strong>'' <br/>";
								body = body.concat(str);
							}
							head = "<span style = 'color:DodgerBlue; '><strong>"
									+ (e.entries[0].dataPoint.label)
									+ "</strong></span><br/>";

							return (head.concat(body));
						}
					},
					legend : {
						horizontalAlign : "center"
					},
					data : dataLine,
				});

		columnChart.render();
		lineChart.render();
	}
</script>

	
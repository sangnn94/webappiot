<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
				<div class="panel-body">
					<div id="coChart" style="height: 300px; width: 100%;"></div>
		
				</div>
			</div>
		</div>
	</div>

	<!-- /.row -->
	<!-- /.row -->

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-body">
						<div id="so2Chart" style="height: 300px; width: 100%;"></div>
						<script type="text/javascript">test("hsabda");</script>
						<h1 id="hai"></h1>
				</div>
			</div>
		</div>
	</div>

	<!-- /.row -->
	<!-- /.row -->

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-body">
						<div id="o3Chart" style="height: 300px; width: 100%;"></div>
				</div>
			</div>
		</div>
	</div>

	<!-- /.row -->
	<!-- /.row -->

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-body">
						<div id="pbChart" style="height: 300px; width: 100%;"></div>
				</div>
			</div>
		</div>
	</div>

	<!-- /.row -->
	<!-- /.row -->

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-body">
					<div id="tslChart" style="height: 300px; width: 100%;"></div>
				</div>
			</div>
		</div>
	</div>

	<!-- /.row -->
	<!-- /.row -->

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-body">
					<div id="pm25Chart" style="height: 300px; width: 100%;"></div>
				</div>
			</div>
		</div>
	</div>

	<!-- /.row -->
	<!-- /.row -->

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-body">
					<div id="pm10Chart" style="height: 300px; width: 100%;"></div>
				</div>
			</div>
		</div>
	</div>

	<!-- /.row -->
</div>

<!-- /.container-fluid -->

<!-- script get data -->
<script type="text/javascript">

	
	function getData(air){
		var data;	
	
		if(air == 1){
			data = ${CO};
		}
		
		if(air == 2){
			data = ${SO2};
		}
		
		if(air == 3){
			data = ${O3};
		}
		
		if(air == 4){
			data = ${Pb};
		}
		
		if(air == 5){
			data = ${TSP};
		}
		
		if(air == 6){
			data = ${PM10};
		}
		
		if(air == 7){
			data = ${PM25};
		}
	
		return data;
	}
	
	function getDataLinechart(){
		var dataLine = [ {
			type : "spline",
			showInLegend : true,
			name : "CO",
			dataPoints : getData(1)
		}, {
			type : "spline",
			showInLegend : true,
			name : "SO2",
			dataPoints : getData(2)
		}, {
			type : "spline",
			showInLegend : true,
			name : "O3",
			dataPoints : getData(3)
		}, {
			type : "spline",
			showInLegend : true,
			name : "Pb",
			dataPoints : getData(4)
		}, {
			type : "spline",
			showInLegend : true,
			name : "TSL",
			dataPoints : getData(5)
		}, {
			type : "spline",
			showInLegend : true,
			name : "PM2.5",
			dataPoints : getData(6)
		}, {
			type : "spline",
			showInLegend : true,
			name : "PM10",
			dataPoints : getData(7)
		}];
		return dataLine;
	}
</script>

<!-- script chart render-->
<script type="text/javascript">
	$( document ).ready(function columnChart() {
		var lineChart = new CanvasJS.Chart(
				"chartOverview",
				{
					title : {
						text : "Overview Daily"
					},
					animationEnabled : true,
					axisY : {
						title : "μg/m3",
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
					data : getDataLinechart()
				});
		var co = new CanvasJS.Chart("coChart", {
			title : {
				text : "Carbon Monoxide (CO)"
			},
			axisX : {
				//interval : 10
			},
			axisY : {
				title : "μg/m3",
			},
			dataPointWidth : 40,
			data : [ {
				type : "column",
				dataPoints : getData(1)
			} ]
		});
		var so2 = new CanvasJS.Chart("so2Chart", {
			title : {
				text : "SO2"
			},
			axisX : {
				//interval : 10
			},
			axisY : {
				title : "μg/m3",
			},
			dataPointWidth : 40,
			data : [ {
				type : "column",
				dataPoints : getData(2)
			} ]
		});
		var o3 = new CanvasJS.Chart("o3Chart", {
			title : {
				text : "O3"
			},
			axisX : {
				//interval : 10
			},
			axisY : {
				title : "μg/m3",
			},
			dataPointWidth : 40,
			data : [ {
				type : "column",
				dataPoints : getData(3)
			} ]
		});
		var pb = new CanvasJS.Chart("pbChart", {
			title : {
				text : "Pb"
			},
			axisX : {
				//interval : 10
			},
			axisY : {
				title : "μg/m3",
			},
			dataPointWidth : 40,
			data : [ {
				type : "column",
				dataPoints : getData(4)
			} ]
		});
		var tsl = new CanvasJS.Chart("tslChart", {
			title : {
				text : "TSP"
			},
			axisX : {
				//interval : 10
			},
			axisY : {
				title : "μg/m3",
			},
			dataPointWidth : 40,
			data : [ {
				type : "column",
				dataPoints : getData(5)
			} ]
		});
		var pm10 = new CanvasJS.Chart("pm10Chart", {
			title : {
				text : "PM10"
			},
			axisX : {
				//interval : 10
			},
			axisY : {
				title : "μg/m3",
			},
			dataPointWidth : 40,
			data : [ {
				type : "column",
				dataPoints : getData(6)
			} ]
		});
		var pm25 = new CanvasJS.Chart("pm25Chart", {
			title : {
				text : "PM2.5"
			},
			axisX : {
				//interval : 10
			},
			axisY : {
				title : "μg/m3",
			},
			dataPointWidth : 40,
			data : [ {
				type : "column",
				dataPoints : getData(7)
			} ]
		});
		lineChart.render();
		co.render();
		so2.render();
		o3.render();
		pb.render();
		tsl.render();
		pm25.render();
		pm10.render();
		
	})
	
</script>

	
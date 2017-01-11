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
						<div id="noChart" style="height: 300px; width: 100%;"></div>
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
		
		if(air == 8){
			data = ${NO};
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
			name : "NO",
			dataPoints : getData(7)
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
		var coChart = new CanvasJS.Chart("coChart", {
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
		var so2Chart = new CanvasJS.Chart("so2Chart", {
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
		var o3Chart = new CanvasJS.Chart("o3Chart", {
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
		var pbChart = new CanvasJS.Chart("pbChart", {
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
		var tslChart = new CanvasJS.Chart("tslChart", {
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
		var pm10Chart = new CanvasJS.Chart("pm10Chart", {
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
		var pm25Chart = new CanvasJS.Chart("pm25Chart", {
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
		
		var noChart = new CanvasJS.Chart("noChart", {
			title : {
				text : "NO"
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
				dataPoints : getData(8)
			} ]
		});

		coChart.render();
		so2Chart.render();
		o3Chart.render();
		pbChart.render();
		tslChart.render();
		pm25Chart.render();
		pm10Chart.render();
		noChart.render();
		
	})
	
</script>

	
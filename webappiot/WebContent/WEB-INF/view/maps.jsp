<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container-fluid">

	<!-- Page Heading -->
	<!-- Page Heading -->


	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Gateway Location</h1>
			<ol class="breadcrumb">
				<li><i class="fa fa-dashboard"></i> <a
					href="${pageContext.request.contextPath}/">WebAppIoT</a></li>
				<li class="active"><i class="fa fa-edit"></i> Location</li>
			</ol>
		</div>
	</div>

	<div class="row">
		<div class="col-lg-12">
			<div class="panel-default">
				<div id="map" style="height: 430px"></div>
			</div>
		</div>
	</div>
</div>

<script>
	var map;
	var latlag = {
		lat : 10.858410,
		lng : 106.765727
	}

	var latlag1 = {
		lat : 10.870035,
		lng : 106.803403
	}
	var latlag2 = {
		lat : 10.862628,
		lng : 106.795534
	}

	function initMap() {
		map = new google.maps.Map(document.getElementById('map'), {
			center : latlag2,
			zoom : 14
		});

		var marker = new google.maps.Marker({
			position : latlag,
			map : map,
			title : 'Hello World!'
		});

		var marker1 = new google.maps.Marker({
			position : latlag1,
			map : map,
			title : 'Hello World!'
		});

		var marker1 = new google.maps.Marker({
			position : latlag2,
			map : map,
			title : 'Hello World!'
		});

	}
</script>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5YyzziI_WwblVhMJkdkiMm9_GYMJ11o4&callback=initMap"
	async defer></script>

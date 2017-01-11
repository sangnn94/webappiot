<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container-fluid">

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
	var markerLat, markerLong;
	markerLat = [
			<c:forEach items="${gateway}" var="gw">
		        <c:out value="${gw.latitude}"/>,
		    </c:forEach>
		];
	
	markerLong = [
			<c:forEach items="${gateway}" var="gw">
		        <c:out value="${gw.longitude}"/>,
		    </c:forEach>
		];
	
	var map;
	var infowindow;
	var infowindow ;
	function initMap() { 
		var latlngInit = {lat: 10.870285, lng: 106.802771};
		map = new google.maps.Map(document.getElementById('map'), {
			center : latlngInit,
			zoom : 12
		});
		var marker,i;
		for(i = 0; i<markerLong.length ; i++){
			infowindow = new google.maps.InfoWindow({
		          content: "<h5>Gateway Device</5>"
		    });
			marker = new google.maps.Marker({
				position : new google.maps.LatLng(markerLat[i], markerLong[i]),
				map : map,
				animation: google.maps.Animation.DROP
			});
			infowindow.open(map, marker);
		}
		
	}
	
</script>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5YyzziI_WwblVhMJkdkiMm9_GYMJ11o4&callback=initMap"
	async defer></script>

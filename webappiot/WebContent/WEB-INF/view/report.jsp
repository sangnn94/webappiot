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
</div>



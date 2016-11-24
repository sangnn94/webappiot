<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container-fluid">

	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Add new Device</h1>
			<ol class="breadcrumb">
				<li><i class="fa fa-dashboard"></i> <a href="/webappiot/">WebAppIoT</a>
				</li>
				<li><i class="fa fa-dashboard"></i> <a
					href="/webappiot/manage-device">Manage device</a></li>
				<li class="active"><i class="fa fa-edit"></i>Add new Device</li>
			</ol>
		</div>
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-6">

			<form role="form">
				<div>
					<label>Location</label> <select class="form-control">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
						<option>11</option>
						<option>12</option>
					</select>

				</div>

				<div class="form-group">
					<label>Address</label> <input class="form-control"
						placeholder="Enter user address">
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
				<button type="reset" class="btn btn-default">Cancel</button>
			</form>

		</div>
	</div>


	<!-- /.row -->

</div>
<!-- /.container-fluid -->


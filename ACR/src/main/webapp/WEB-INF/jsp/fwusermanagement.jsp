<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- Template Name: Clip-One - Responsive Admin Template build with Twitter Bootstrap 3.x Version: 1.3 Author: ClipTheme -->
<!--[if IE 8]><html class="ie8 no-js" lang="en"><![endif]-->
<!--[if IE 9]><html class="ie9 no-js" lang="en"><![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- start: HEAD -->
<head>
<title>User Management</title>
<!-- start: META -->
<meta charset="utf-8" />
<!--[if IE]><meta http-equiv='X-UA-Compatible' content="IE=edge,IE=9,IE=8,chrome=1" /><![endif]-->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta content="" name="description" />
<meta content="" name="author" />
<!-- end: META -->
<!-- start: MAIN CSS -->
<link rel="stylesheet"
	href="./resources/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="./resources/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="./resources/fonts/style.css">
<link rel="stylesheet" href="./resources/css/main.css">
<link rel="stylesheet" href="./resources/css/main-responsive.css">
<link rel="stylesheet" href="./resources/plugins/iCheck/skins/all.css">
<link rel="stylesheet"
	href="./resources/plugins/bootstrap-colorpalette/css/bootstrap-colorpalette.css">
<link rel="stylesheet"
	href="./resources/plugins/perfect-scrollbar/src/perfect-scrollbar.css">
<link rel="stylesheet" href="./resources/css/theme_light.css"
	type="text/css" id="skin_color">
<link rel="stylesheet" href="./resources/css/print.css" type="text/css"
	media="print" />
<!--[if IE 7]>
		<link rel="stylesheet" href="./resources/plugins/font-awesome/css/font-awesome-ie7.min.css">
		<![endif]-->
<!-- end: MAIN CSS -->
<!-- start: CSS REQUIRED FOR THIS PAGE ONLY -->
<link rel="stylesheet"
	href="./resources/plugins/DataTables/media/css/DT_bootstrap.css" />
<!-- end: CSS REQUIRED FOR THIS PAGE ONLY -->
</head>
<!-- end: HEAD -->
<!-- start: BODY -->
<body>
	
		  <div class="panel" style="text-align: center; height: 500px;">
			<div class="panel-heading">
				User Table
				<div class="panel-tools">
					<a class="btn btn-xs btn-primary"
						data-toggle="modal" data-target="#myModal">ADD USER </a> 
				</div>
			</div>
			<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title center">ADD USER</h4>
						</div>
						<div class="modal-body">
							<form role="form" action="./fwadduser" method="post"
								class="form-horizontal" id="addform">
								<div class="form-group">
									<span
										style="background-color: #f2dede; border-color: #ebccd1; color: #653838; display: block; margin-bottom: 13px; text-align: center;">${servermessage}</span>
									<label class="col-sm-2 control-label" for="form-field-1">
										UserType </label>
									<div class="col-sm-9">
										<select class="form-control" name="usertype">
											<option value="" style="display: none">Select User</option>
											<c:if test="${!empty usertype}">
												<c:forEach items="${usertype}" var="userType">
													<option value="${userType.usertype}">${userType.usertype}</option>
												</c:forEach>
											</c:if>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="form-field-1">
										Username </label>
									<div class="col-sm-9">
										<input type="text" placeholder="Username" id="demo"
											class="form-control" name="username" required>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="form-field-2">
										Password </label>
									<div class="col-sm-9">
										<input type="password" placeholder="Password"
											id="form-field-2" class="form-control" name="password"
											required>
									</div>
								</div>
								<div class="form-group">
									<button type="submit" class="btn btn-primary"
										style="width: 30%;">
										Add</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="modal fade" id="UpdateUser" role="dialog">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title center">UPDATE USER</h4>
						</div>
						<div class="modal-body">
							<form role="form" action="./fwupdateuser" method="post"
								class="form-horizontal" id="addform">
								<input id="userid" name="id" style="display:none" value="">
								<div class="form-group">
									<label class="col-sm-2 control-label" for="form-field-1">
										UserType </label>
									<div class="col-sm-9">
										<select class="form-control" name="usertype">
											<option id="usertype" value="" style="display: none">Select User</option>
											<c:if test="${!empty usertype}">
												<c:forEach items="${usertype}" var="userType">
													<option value="${userType.usertype}">${userType.usertype}</option>
												</c:forEach>
											</c:if>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="form-field-1">
										Username </label>
									<div class="col-sm-9">
										<input type="text" placeholder="Username" id="username"
											class="form-control" name="username" required>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="form-field-2">
										Password </label>
									<div class="col-sm-9">
										<input type="text"  placeholder="Password"
											id="password" class="form-control" name="password"
											required>
									</div>
								</div>
								<div class="form-group">
									<button type="submit" class="btn btn-primary"
										style="width: 30%;">
										UPDATE</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="panel-body">
				<table
					class="table table-striped table-bordered table-hover table-full-width"
					id="sample_1">
					<thead>
						<tr>
							<th>#</th>
							<th>MODIFIED ON</th>
							<th>CREATED ON</th>
							<th>USERTYPE</th>
							<th>USERNAME</th>
							<th>ACTION</th>
						</tr>
					</thead>
					<tbody>
						<%
							int serialNumber = 0;
						%>
						<c:if test="${!empty users}">
							<c:forEach items="${users}" var="user">
								<%
									serialNumber++;
								%>
								<tr>
									<td>${user.id}</td>
									<td>${user.modifiedOn}</td>
									<td>${user.createdOn}</td>
									<td>${user.usertype}</td>
									<td>${user.username}</td>
									<td class="center">
										<div>
											<a class="btn btn-xs btn-teal tooltips" data-placement="top"
												data-original-title="Edit"
												onclick="document.getElementById('usertype').value ='${user.usertype}';document.getElementById('usertype').innerHTML ='${user.usertype}';document.getElementById('username').value ='${user.username}';document.getElementById('password').value='${user.password}';document.getElementById('userid').value='${user.id}'"
												data-toggle="modal" data-target="#UpdateUser"><i
												data-target="#responsive" class="fa fa-edit"></i></a> <a
												class="btn btn-xs btn-bricky tooltips" data-placement="top"
												data-original-title="Remove"
												onclick="document.getElementById('deluser_id').value ='${user.id}'"
												class="btn btn-info btn-lg" data-toggle="modal"
												data-target="#DeleteUser"><i
												class="fa fa-times fa fa-white"></i></a>
										</div>
									</td>
								</tr>
							</c:forEach>
						</c:if>

					</tbody>
				</table>
			</div>
		</div>
		<!-- end: DYNAMIC TABLE PANEL -->
		<div class="modal fade" id="DeleteUser" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">ARE YOU SURE?</h4>
					</div>
					<form action="./fwdeleteuser" method="post">
						<input type="text" id="deluser_id" value="" name="id"
							style="display: none;">
						<div class="modal-footer">
							<button type="submit" class="btn btn-default">Yes</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">No</button>
						</div>
					</form>

				</div>
			</div>
		</div>

		<!--########################################         Update User         ##################################################  -->

		<div class="modal fade" id="" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title center">EDIT USER</h4>
					</div>
					<div class="modal-body">
						<form role="form" action="./UpdateUser" method="post"
							class="form-horizontal">
							<div class="form-group">
								<label class="col-sm-2 control-label" for="form-field-1">
									UserType </label>
								<div class="col-sm-9">
									<select class="form-control" name="usertype">
										<option id="usertype" value="" style="display: none">Select
											User</option>
										<c:if test="${!empty usersCategoryList}">
											<c:forEach items="${usersCategoryList}" var="userType">
												<option value="${userType.usertype}">${userType.usertype}</option>
											</c:forEach>
										</c:if>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="form-field-1">
									Username </label>
								<div class="col-sm-9">
									<input type="text" id="username" class="form-control"
										name="username" value="" readonly="readonly">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="form-field-1">
									Password </label>
								<div class="col-sm-9">
									<input type="text" id="password" class="form-control"
										name="password" value="">
								</div>
							</div>
							
							<div class="form-group">
									<button type="submit" class="btn btn-primary"
										style="width: 30%;">
										Add</button>
								</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	
	<!-- end: MAIN CONTAINER -->
	<!-- start: MAIN JAVASCRIPTS -->
	<!--[if gte IE 9]><!-->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
	<!--<![endif]-->
	<script src="./resources/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script src="./resources/plugins/iCheck/jquery.icheck.min.js"></script>
	<script
		src="./resources/plugins/perfect-scrollbar/src/jquery.mousewheel.js"></script>
	<script
		src="./resources/plugins/perfect-scrollbar/src/perfect-scrollbar.js"></script>
	<script src="./resources/plugins/jquery-cookie/jquery.cookie.js"></script>
	<script
		src="./resources/plugins/bootstrap-colorpalette/js/bootstrap-colorpalette.js"></script>
	<script src="./resources/js/main.js"></script>
	<!-- end: MAIN JAVASCRIPTS -->
	<script type="text/javascript"
		src="./resources/plugins/DataTables/media/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="./resources/plugins/DataTables/media/js/DT_bootstrap.js"></script>
	<script src="./resources/js/table-data.js"></script>
	<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
	<script>
		jQuery(document).ready(function() {
			/* Main.init(); */
			TableData.init();

		});
	</script>
</body>
<!-- end: BODY -->
</html>
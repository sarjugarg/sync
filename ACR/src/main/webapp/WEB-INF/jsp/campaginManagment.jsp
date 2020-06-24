<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<!-- start: HEAD -->
<head>
<title>Campaign Management</title>
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
</head>
<!-- end: HEAD -->
<!-- start: BODY -->
<body>
	<div class="container">
		<!-- start: PAGE CONTENT -->
		<div class="row">
			<div class="col-md-12">
				<!-- start: DYNAMIC TABLE PANEL -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-external-link-square"></i> Campaign Table
						<div class="panel-tools">
							<span
								style="color: white; background-color: green; text-align: center">${smsg}</span>
							<span
								style="color: white; background-color: green; text-align: center">${utmsg}</span>
							<a class="btn btn-xs"
								style="color: white; background-color: #0b738a"
								data-toggle="modal"  href="./AddCampaign"  >ADD Campaign </a> <a
								class="btn btn-xs btn-link panel-collapse collapses" href="#">
							</a>
						</div>
					</div>
					<div class="modal fade" id="addType" role="dialog">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
									<h4 class="modal-title center">Add Campaign</h4>
								</div>
								<div class="modal-body">
									<form role="form" action="./addcampaign" method="post"
										class="form-horizontal">
										<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												Campaign Name </label>
											<div class="col-sm-9">
											<input type="text" placeholder="Campaign Name"
													id="form-field-1" class="form-control" name="campaignName"
													required>
											</div>
										</div>

										<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												Brand </label>
											<div class="col-sm-9">
												<input type="text" placeholder="Brand Name"
													id="form-field-1" class="form-control" name="brand"
													required>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												Product </label>
											<div class="col-sm-9">
												<input type="text" placeholder="Product" id="form-field-1"
													class="form-control" name="product" required>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												Category </label>
											<div class="col-sm-9">
												<input type="text" placeholder="Category" id="form-field-1"
													class="form-control" name="category" required>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												Sub-Category </label>
											<div class="col-sm-9">
												<input type="text" placeholder="sub_category" id="form-field-1"
													class="form-control" name="sub_category" required>
											</div>
										</div>
									<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												Start time </label>
											<div class="col-sm-9">
												<input type="text" placeholder="Start time" id="form-field-1"
													class="form-control" name="startdDate" required>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												End Time </label>
											<div class="col-sm-9">
												<input type="text" placeholder="End Time" id="form-field-1"
													class="form-control" name="enddDate" required>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												Description </label>
											<div class="col-sm-9">
												<input type="text" placeholder="Description" id="form-field-1"
													class="form-control" name="description" required>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												Language </label>
											<div class="col-sm-9">
												<input type="text" placeholder="Language" id="form-field-1"
													class="form-control" name="language" required>
											</div>
										</div>
									<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												Audio File </label>
											<div class="col-sm-9">
												<input type="text" placeholder="Audio File" id="form-field-1"
													class="form-control" name="audio_file" required>
											</div>
										</div>
									
										<div class="form-group">
											<button type="submit" class="btn btn-primary"
												style="width: 30%; margin-left: 35%">CREATE</button>
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
									<th>SNo</th>
									<th>Campaign </th>
									<th>Brand</th>
									<th>Product</th>
									<th>Category</th>
									<th>Sub-Category</th>
									<th>Language</th>
									<th>Description</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
							<% int b=0;%>
								<c:forEach items="${campaign}" var="campaign" >
								<tr>
								<%b++; %>
								<td><%=b %></td>
								<td>${campaign.campaignName}</td>
								<td>${campaign.brand}</td>
								<td>${campaign.product}</td>
								<td>${campaign.category}</td>
								<td>${campaign.sub_category}</td>
								<td>${campaign.language}</td>
								<td>${campaign.description}</td>
								<td class="center">
												<div>
													<a class="btn btn-xs btn-teal tooltips"
														data-placement="top" data-original-title="Edit" href="./editCampaign/${campaign.campaignId}"
														<%-- onclick="document.getElementById('campainId').value ='${campaign.campaignId}';document.getElementById('feature1').value ='${feature.featureName}';document.getElementById('link').value ='${feature.link}'"
														data-toggle="modal" data-target="#updateu" --%>><i
														data-target="#responsive" class="fa fa-edit"></i></a> <a
														class="btn btn-xs btn-bricky tooltips"
														data-placement="top" data-original-title="Remove"
														onclick="document.getElementById('featureid').value ='${campaign.campaignId}'"
														class="btn btn-info btn-lg" data-toggle="modal"
														data-target="#deleteu"><i
														class="fa fa-times fa fa-white"></i></a>
												</div>
											</td>
								
								 </tr>
								</c:forEach>
								
							</tbody>
						</table>
					</div>
				</div>
				<!-- end: DYNAMIC TABLE PANEL -->
				<div class="modal fade" id="deleteu" role="dialog">
					<div class="modal-dialog">
						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">It may impact the current running order.ARE YOU SURE WANT TO DELETE?</h4>
							</div>
							<form action="./deletecampaign" method="post">
								<input type="text" id="featureid" value="" name="campaignId"
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
				<div class="modal fade" id="updateu" role="dialog">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title">EDIT Campaign</h4>
							</div>
															<div class="modal-body">
									<form role="form" action="./editcampaign" method="post"
										class="form-horizontal">
										<div class="form-group">
										
										<input type="text" id="campainId" value="" name="id"
										style="display: none;">
											<label class="col-sm-2 control-label" for="form-field-1">
												Campaign Name </label>
											<div class="col-sm-9">
											<input type="text" placeholder="Campaign Name"
													id="campaignName" class="form-control" name="campaignName"
													required>
											</div>
										</div>

										<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												Brand </label>
											<div class="col-sm-9">
												<input type="text" placeholder="Brand Name"
													id="brand" class="form-control" name="brand"
													required>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												Product </label>
											<div class="col-sm-9">
												<input type="text" placeholder="Product" id="product"
													class="form-control" name="product" required>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												Category </label>
											<div class="col-sm-9">
												<input type="text" placeholder="Category" id="category"
													class="form-control" name="category" required>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												Sub-Category </label>
											<div class="col-sm-9">
												<input type="text" placeholder="sub_category" id="subcategory"
													class="form-control" name="sub_category" required>
											</div>
										</div>
									<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												Start time </label>
											<div class="col-sm-9">
												<input type="text" placeholder="Start time" id="starttime"
													class="form-control" name="startdDate" required>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												End Time </label>
											<div class="col-sm-9">
												<input type="text" placeholder="End Time" id="endDate"
													class="form-control" name="enddDate" required>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												Description </label>
											<div class="col-sm-9">
												<input type="text" placeholder="Description" id="description"
													class="form-control" name="description" required>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												Language </label>
											<div class="col-sm-9">
												<input type="text" placeholder="Language" id="language"
													class="form-control" name="language" required>
											</div>
										</div>
									<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												Audio File </label>
											<div class="col-sm-9">
												<input type="text" placeholder="Audio File" id="audiofile"
													class="form-control" name="audio_file" required>
											</div>
										</div>
									
										<div class="form-group">
											<button type="submit" class="btn btn-primary"
												style="width: 30%; margin-left: 35%">UPDATE</button>
										</div>
									</form>
								</div>	</div>
					</div>
				</div>
			</div>
		</div>

		<!-- end: PAGE CONTENT-->
		<!-- 	</div>
			</div> -->
		<!-- end: PAGE -->
	</div>
	<!-- start: MAIN JAVASCRIPTS -->
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
			Main.init();
			TableData.init();
		});
	</script>
</body>
<!-- end: BODY -->
</html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<!-- start: HEAD -->
<head>
<title>Product Management</title>
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
	<style type="text/css">
.hov figure img {
	-webkit-transform: scale(1);
	transform: scale(1);
	-webkit-transition: .3s ease-in-out;
	transition: .3s ease-in-out;
}
.hov figure:hover img {
	-webkit-transform: scale(2);
	transform: scale(7);
}


</style>
</head>
<body>
<div class="panel-heading">
		<i class="fa fa-external-link-square"></i> Product Management
	</div>
	
		<div class="panel-tools">

			<a class="btn btn-xs" style="color: white; background-color: #0b738a; " 
				data-toggle="modal" href="./AddProduct">Create Product  </a> <a
				class="btn btn-xs btn-link panel-collapse collapses" href="#"> </a>
		</div>
	<div class="container">
		<div class="row">
		<div class="col-md-12">
			<div class="panel panel-default">
					<div class="panel-body" style="background-color: white;">
						<table
							class="table table-striped table-bordered table-hover table-full-width"
							id="sample_1">
							<thead>
								<tr>
									<th>S.No</th>
									<th>Product Name</th>
									<th>Product Image</th>
									<th>Image Height</th>
									<th>Image Width</th>
									<th>Image Url</th>
									<th>Actions</th>
								</tr>
							</thead>
							<tbody>
								<%int a = 0; %>
									<c:forEach items="${list}" var="list">
										<%a++; %>
										<tr>
											<td><%=a %></td>
											<td>${list.productName}</td>
											<td>
											<c:choose>
											
											<c:when test="${list.filename!='null'}">
											
											<div class="hov">
											<figure>
											<img 
										src="${productImageUrl}${list.filename}"  style="width: 40px; height: 20px;margin-left:40px;">
											</figure>
											</div>
											</c:when>
											<c:otherwise>
											<span>NA</span>
											</c:otherwise></c:choose>
											</td>
											<td>${list.imageHeight}</td>
											<td>${list.imageWidth}</td>
											
											<td>
											<c:choose>
											<c:when test="${list.filename!='null'}">
											${list.filename}
											</c:when>
											<c:otherwise>
											<span>NA</span>
											</c:otherwise></c:choose>
											</td>
											
											<td class="center">
												<div>
													<a class="btn btn-xs btn-teal tooltips" data-placement="top"
											data-original-title="Edit"
											href="./productEditById/${list.productId}"><i
											data-target="#responsive" class="fa fa-edit"></i></a><%--  <a
														class="btn btn-xs btn-bricky tooltips"
														data-placement="top" data-original-title="Remove"
														onclick="document.getElementById('featureid').value ='${feature.id}'"
														class="btn btn-info btn-lg" data-toggle="modal"
														data-target="#deleteu"><i
														class="fa fa-times fa fa-white"></i></a> --%>
												</div>
											</td>
										</tr>
									</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>	
		</div>	
	</div>	
</body>

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
	<!-- <script>
		jQuery(document).ready(function() {
			Main.init();
			TableData.init();
		});
	</script> -->
	
	<script>
$(document).ready(function() {
$('#sample_1').DataTable({dom: 'Bfrtip'});


});
</script>






</html>
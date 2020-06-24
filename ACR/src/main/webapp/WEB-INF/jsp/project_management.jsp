<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<!-- start: HEAD -->
<head>
<title>Project Management</title>
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

<img src="file:///${img}" style="width: 25px;height:30px;" class="img">
	<div class="modal-content">
		
		<div class="modal-header">
			<h4 class="modal-title center">Project Management</h4>
		</div>
		
		<div class="modal-body">
			<form role="form" action="./upload" method="post"
				class="form-horizontal" id="addform" enctype="multipart/form-data">
				<div class="form-group">
						<label class="col-sm-2 control-label" for="form-field-2">
							Project Name </label>
						<div class="col-sm-9">
							<input type="text" placeholder="enter ProjectName"
								id="form-field-2" class="form-control" name="projectName"
								required="">
						</div>
					</div>
				
				<div class="form-group">
						<label class="col-sm-2 control-label" for="form-field-2">
							Logo Path </label>
						<div class="col-sm-9">
							<input type="file"  id="myFile" 
								 name="LogoPath" required="">
						</div>
					</div>
					<center>
						<div class="form-group">
							<button type="submit" class="btn btn-primary" style="width: 30%">
								Submit</button>
						</div>
					</center>
				</form>
               </div>
<!-- <!-- 				<div class="form-group">
					<label class="col-sm-2 control-label" for="form-field-1">
						DataBase URL </label>
					<div class="col-sm-9">
						<input type="text" placeholder="enter DataBaseURL" id="demo"
							class="form-control" name=" dataBaseUrl" required="">
					</div>
				
					
					<div class="form-group">
						<label class="col-sm-2 control-label" for="form-field-1">
							User Name </label>
						<div class="col-sm-9">
							<input type="text" placeholder="enter Username" id="demo"
								class="form-control" name="username" required="">
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label" for="form-field-2">
							Password </label>
						<div class="col-sm-9">
							<input type="password" placeholder="enter Password"
								id="form-field-2" class="form-control" name="password"
								required="">
						</div>
					 </div> -->

				<%-- 	<div class="form-group">
						<label class="col-sm-2 control-label" for="form-field-2">
							Project Name </label>
						<div class="col-sm-9">
							<input type="text" placeholder="enter ProjectName"
								id="form-field-2" class="form-control" name="projectName"
								required="">
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label" for="form-field-2">
							Logo Path </label>
						<div class="col-sm-9">
							<input type="file"  id="myFile" 
								 name="LogoPath" required="">
						</div>
					</div>
					<center>
						<div class="form-group">
							<button type="submit" class="btn btn-primary" style="width: 30%">
								Submit</button>
						</div>
					</center>
				</div>
			</form>
 --%>			
		</div>

</body>
<!-- end: BODY -->
</html>
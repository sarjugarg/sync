<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en" class="no-js">
<!-- start: HEAD -->
<head>
<title>Report Management</title>
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
<script>

var contextpath = "${context}";

</script>
<link rel="stylesheet"
	href="./resources/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="./resources/plugins/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.2.4/css/buttons.dataTables.min.css">
	<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.css">
	<link href="https://datatables.net/download/build/dataTables.responsive.nightly.css" rel="stylesheet" type="text/css" />
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
	<style>
.tag-box2 {
	list-style: none;
    padding: 3px;
    margin-bottom: 10px;
    display: inline-block;
    font-family: arial;
    width: 100%;
        /* border: 1px solid black; */
        background-color: rgb(86,97,107,0.3);
    /* border-radius: 4px; */
}

.tag-box2 li.tags.genre {
    background: #08c;
    color: #fff;
    border-radius: 4px;
    margin: 4px 3px;
    position: relative;
    font-size: 11px;
}

.tag-box2 li.tags.channel {
    background: #D68319;
    color: #fff;
    border-radius: 4px;
    margin: 4px 3px;
    position: relative;
    font-size: 11px;
}

.tag-box2 li.tags.language1 {
    background: #008075;
    color: #fff;
    border-radius: 4px;
    margin: 4px 3px;
    position: relative;
    font-size: 11px;
}
.tag-box2 li.tags.product {
    background: green;
    color: #fff;
    border-radius: 4px;
    margin: 4px 3px;
    position: relative;
    font-size: 11px;
     white-space: nowrap; 
  overflow: hidden;
  text-overflow: ellipsis;
}

.tag-box2 li.tags.brand {
    background: red;
    color: #fff;
    border-radius: 4px;
    margin: 4px 3px;
    position: relative;
    font-size: 11px;
     white-space: nowrap; 
  overflow: hidden;
  text-overflow: ellipsis;
}
.tag-box2 li.tags.category {
    background: #002680;
    color: #fff;
    border-radius: 4px;
    margin: 4px 3px;
    position: relative;
    font-size: 11px;
     white-space: nowrap; 
  overflow: hidden;
  text-overflow: ellipsis;
}


.tag-box2 li.tags.date_range {
    background: #D68319;
    color: #fff;
    border-radius: 4px;
    margin: 4px 3px;
    position: relative;
    font-size: 11px;
}

.tag-box2 li {
    padding: 4px 6px;
    float: left;
    display: inline-block;
    padding-right: 25px;
}  

.tag-box2 li.tags:hover .close {
    /* width: 14px; */
}
.tag-box2 li.tags .close {
    cursor: pointer;
    position: absolute;
    top: 40%;
     padding-left: 10px;
    transform: translate(0%, -45%);
    color: #ffffff !important;
    opacity: 1;
    font-size: 13px !important;
}
.tag-box2 * {
    -webkit-transition-property: all;
    transition-property: all;
    -webkit-transition-duration: 0.3s;
    transition-duration: 0.3s;
}

.tag-box2 li.tags .close:after {
    content: 'x';
}



.selectable .ui-selected.channel{
	background: #D68319;
}

.selectable .ui-selected-multi.channel{
	background: #D68319;
	
}




.selectable .ui-selected.language1{
	background: #008075;
}

.selectable .ui-selected-multi.language1{
	background: #008075;
	
}



.selectable .ui-selected.brand{
	background: Red;
}

.selectable .ui-selected-multi.brand{
	background: Red;
}

.selectable .ui-selected.product{
	background: green;
}

.selectable .ui-selected-multi.product{
	background: green;
}
.selectable .ui-selected.category{
	background: #002680;
}

.selectable .ui-selected-multi.category{
	background: #002680;
}


.selectable .ui-selected.channel{
	background: #D68319;
}

.selectable .ui-selected-multi.channel{
	background: #D68319;
}

.selectable .ui-selected.language{
	background: green;
}

.selectable .ui-selected-multi.language{
	background: green;
	
}


.selectable .ui-selected.genre{
	background: #08c;
}

.selectable .ui-selected-multi.genre{
	background: #08c;
} 
.selectable {
	color: white;
	margin: 0;
	padding: 0;
	width: 100%;
	background: #414b53 !important;
	box-shadow: 16px 16px 20px 2px rgba(12, 2, 2, 0.3);

}

.selectable li {
	margin: 3px;
	padding: 1px 0px 0px 3px;
	font-size: 0.9em;
	height: 20px;
	cursor: pointer;
  white-space: nowrap; 
  overflow: hidden;
  text-overflow: ellipsis;
  	color:white;
}

.open>.dropdown-menu {
	display: block;
	height: 280px;
	overflow-y: auto;
	width: 175px;
}


/* .search-filter {
  margin: 0;
  font-family: inherit;
  font-size: inherit;
  line-height: inherit;
  width: 100%;
  background: transparent;
  border: 1px solid;
  color: white;
  font-size: 12px;
  border-radius: 4px;
  padding-left: 5px;
}
 */

#channelSearch.search-filter{
margin: 0;
    font-family: inherit;
    font-size: inherit;
    line-height: inherit;
    width: 100%;
    background: transparent;
    border: 1px solid;
    color: #cccccc;
    font-size: 12px;
    border-radius: 4px;
    padding-left: 5px;
    overflow: visible;
}
.search-filter:hover {
	color: #cccccc;
}
</style>
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
							
						</div>
					</div>
					<div class="modal fade" id="addType" role="dialog">
						<div class="modal-dialog">
							<div class="modal-content">
								
								<div class="modal-body">
																	</div>
							</div>
						</div>
					</div>
					
					
					<div class="panel-body">
					
					
					<div style="display:inline-flex; padding:3px;">
		

				
				<!-- <label>From Date</label> -->
				
				<div class="col-xs-6 input-group date" id='startDate'>
							
							
							
									<input type='text' placeholder="From date" class="form-control" name="startDate" style="background-color: #fff;color: black);"
										id="datefilterid" value="" required="required"   /> <span class="input-group-addon"
									style="background-color:#fff;"	> <span style="background-color:#fff;" 
										class="glyphicon glyphicon-calendar" ></span>
									</span>
								</div>
						<!-- <label>To Date</label> -->
						<div class="col-xs-6 input-group date" id='endDate'>
										<label>
							
							</label>
									<input type='text' placeholder="To date" class="form-control" name="endDate" id='enddate' style="background-color: #fff;color: black);" 
										 value="" required /> <span class="input-group-addon" style="background-color:#fff;"
										> <span
										class="glyphicon glyphicon-calendar" style="background-color:#fff;"></span>
									</span>
								</div>
								<span id ="dateSelectMessage" style="display:none;    width: 50%;margin-left: 65px;
    							color: red; font-size: 16px;margin-top: 4px;">please select date first</span>
								</div>
				
					
						<form id="selectBoxForm">

											<div style="display:inline-flex; padding:3px;">
						<div class="form-group">
							
								<div class="facilities">
									<!-- <select onchange="selectIngredient(this);" multiple="multiple" name='genreName'
									id="genre"> -->
									<div class="dropdown cq-dropdown" data-name='statuses'>
										<div style="color: black; font-size: 14px; width: 80px;     margin-right: 7px;"
											class="dropdown-toggle" id="dropdown1" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="true"> Channel&nbsp; <i class="fa fa-caret-down"></i></div>
										
										<ul class="dropdown-menu selectable"  id="channelfilter"
											aria-labelledby="dropdown1">
											
										
										
										</ul>
									</div>
								</div>
								</div>
								
								
								
								<div class="form-group">
							
								<div class="facilities">
									<!-- <select onchange="selectIngredient(this);" multiple="multiple" name='genreName'
									id="genre"> -->
									<div class="dropdown cq-dropdown" data-name='statuses'>
										<div style="color: black; font-size: 14px;     width: 80px;     margin-right: 4px;"
											class="dropdown-toggle" id="dropdown1" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="true"> Brand&nbsp; <i class="fa fa-caret-down"></i></div>
										<ul class="dropdown-menu selectable"  id="brandfilter"
											aria-labelledby="dropdown1">
										</ul>
									</div>
								</div>
								</div>
								
									<div class="form-group">
							
								<div class="facilities">
									<!-- <select onchange="selectIngredient(this);" multiple="multiple" name='genreName'
									id="genre"> -->
									<div class="dropdown cq-dropdown" data-name='statuses'>
										<div style="color: black; font-size: 14px;        width: 80px;     margin-right: 14px;"
											class="dropdown-toggle" id="dropdown1" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="true"> Category&nbsp; <i class="fa fa-caret-down"></i></div>
										<ul class="dropdown-menu selectable"  id="categoryfilter"
											aria-labelledby="dropdown1">
										</ul>
									</div>
								</div>
								</div>
								
									<div class="form-group">
							
								<div class="facilities">
									<!-- <select onchange="selectIngredient(this);" multiple="multiple" name='genreName'
									id="genre"> -->
									<div class="dropdown cq-dropdown" data-name='statuses'>
										<div style="color: black; font-size: 14px; width:80px;     margin-right: 7px;"
											class="dropdown-toggle" id="dropdown1" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="true">Product&nbsp; <i class="fa fa-caret-down"></i></div>
										<ul class="dropdown-menu selectable"  id="productfilter"
											aria-labelledby="dropdown1">
										</ul>
									</div>
								</div>
								</div>	
								
								<div class="form-group">
							
								<div class="facilities">
									<!-- <select onchange="selectIngredient(this);" multiple="multiple" name='genreName'
									id="genre"> -->
									<div class="dropdown cq-dropdown" data-name='statuses'>
										<div style="color: black; font-size: 14px; width:80px;     margin-right: 14px;"
											class="dropdown-toggle" id="dropdown1" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="true"> Language&nbsp; <i class="fa fa-caret-down"></i></div>
										<ul class="dropdown-menu selectable"  id="languagefilter"
											aria-labelledby="dropdown1">
										</ul>
									</div>
								</div>
								</div>
											<input type="button" placeholder="submit" value="Submit" id="button" name="button" onclick="showFilterData();" 
											style="width: 57px;color: black;padding: 0;padding-left:;border: solid 1px #bfbaba;height: 27px;">
								
								</div></form>
								
														
      
          
        <form id="filterTab">
        <div style="display:flex; flex-direction: row; padding:3px;">
        
        <ul class="tag-box2 ui-sortable" id="filtersBox" style="display: none;">
	    </ul>
        
        </div>
        </form>
						<table
							class="table table-striped table-bordered table-hover table-full-width"
							id="sample_1">
							
							<thead>
								<tr>
									
									<th>Channel </th>
									<th>Campaign </th>	
									<th> StartDate</th>
									<th>EndDate </th>
									<th>SpotCount </th>
									<th>ActualCount </th>
									<th>Cost </th>
									
									<th>Brand</th>
									<th>Product</th>
									<th>Category</th>
									<th>Sub-Category</th>
									<th>Language</th>
									<th>Description</th>
									
								</tr>
							</thead>
							<tbody>
				<%-- 			<c:forEach items="${report}" var="report">
								<tr>
								<td>${report.channnelName}</td>
								<td>${report.campaignName}</td>
								<td>${report.startdDate}</td>
								<td>${report.enddDate}</td>
								<td>${report.spotCount}</td>
								<td>${report.actualCount}</td>
								<td>${report.cost}</td>
								<td>${report.brand}</td>
								<td>${report.product}</td>
								<td>${report.category}</td>
								<td>${report.sub_category}</td>
								<td>${report.language}</td>
								<td>${report.description}</td>
								
								</tr>
								</c:forEach> --%>	
							</tbody>
							
						</table>
					</div>
				</div>
				<!-- end: DYNAMIC TABLE PANEL -->
			

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
		
	
<script src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/responsive/2.1.1/js/dataTables.responsive.min.js"></script>		
	<!--<![endif]-->
	
	
<script src="./resources/ReportJs/moment.js""></script>
	<%-- <script type="text/javascript" src="${context}/resources/js/moment.js"></script> --%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>

	
	<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<script src="https://datatables.net/download/build/dataTables.responsive.nightly.js"></script>
	
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
	<script src="./resources/ReportJs/ReportPage.js"></script>
	
	
	
	<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
	<!-- <script>
		jQuery(document).ready(function() {
			Main.init();
			
			TableData.init();
		
		});
	</script> -->
</body>
<!-- end: BODY -->
</html>
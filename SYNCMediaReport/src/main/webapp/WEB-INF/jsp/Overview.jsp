<%String username =(String)session.getAttribute("username"); 
if(username !=null){
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
<%@ include file="Libraries.jsp" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script>
    var product=''; 
	var contextpath = "${context}";
	//d0ataCount(); 
</script>
<title></title>

<meta charset="utf-8" />
<title>SYNC Dashboard</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<meta content="Coderthemes" name="author" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />


<script type="text/javascript">
								$(function() {

									var start = moment().subtract(6, 'days');
									var end = moment();

									function cb(start, end,label) {
										
										 $('#startDateSelected').val(start.format('YYYY-MM-DD'));
										 $('#endDateSelected').val(end.format('YYYY-MM-DD'));
										 $('#dateselectedlabel').val(label);
										 overviewData();
										 /* $('#reportrange span')
												.html(
														start
																.format('MMMM D, YYYY')
																+ ' - '
																+ end
																		.format('MMMM D, YYYY')); */
									}

									$('#date_range')
											.daterangepicker(
													{
														autoApply: true,
														startDate : start,
														endDate : end,
														ranges : {
															'Today' : [
																	moment(),
																	moment() ],
															'Yesterday' : [
																	moment().subtract(1,'days'),
																	moment().subtract(1,'days') ],
															'Last 7 Days' : [
																	moment().subtract(6,'days'),moment() ],
															'Last 30 Days' : [
																	moment().subtract(29,'days'),moment() ],
															'This Month' : [
																	moment().startOf('month'),
																	moment().endOf('month') ],
															'Last Month' : [
																	moment().subtract(1,'month').startOf(
																					'month'),
																	moment().subtract(1,'month').endOf('month') ]
														}
													}, cb);

									cb(start, end);

								});
								$(function() {
									$(".selectable").selectable();
								});
							</script>
<script> 
	$(document).ready(function() {
	
		$('.ProductList').slimScroll({
			height : '405px'
		});
		
		$('.ChannelList').slimScroll({
			height : '405px'
		});
		$('.CategoryList').slimScroll({
			height : '405px'
		});
		$('.BrandList').slimScroll({
			height : '405px'
		});  

		dataCount();
		getRecentCards(<%=(Integer)session.getAttribute("userid")%>);
	});  
</script>

<body style="font-family: Roboto, sans-serif !important;">

	<div id="page-wrapper">
		<!-- Top Bar Start -->
		<div class="container-fluid">
			<div class="topbar" id="topnav">
				<div class="topbar-left">
					<div class="">
						<a href="${context}/Overview" class="logo"> <img
							src="${context}/resources/images/logo.png" alt="logo"
							class="logo-lg" />
						</a>
					</div>
				</div>
				<ul
					class="nav navbar-nav navbar-right top-navbar-items-right pull-right">

					<li class="dropdown top-menu-item-xs">
					 <a href=""
						class="dropdown-toggle menu-right-item profile"
						data-toggle="dropdown" aria-expanded="true"> <img
							src="${context}/resources/images/user.png" alt="user-img">
					</a> 
						<ul class="dropdown-menu">
							<li><!-- <a href="javascript:void(0)"><i
									class="ti-user m-r-10"></i> Profile</a> --></li>
							<!-- <li class="divider">
							
							</li>
 -->	<li><a href="./Logout"><i
									class="ti-user m-r-10"></i> Logout</a></li>
						</ul></li>
				</ul>
			</div>
			<div class="dashbar">

				<div class="col-sm-5">
				</div>
				<div class="col-sm-4">
					<div class="Bar-check">
						<ul>
							<li style="">&nbsp;<input onclick="overviewData();" id="time"
								value="Playout" type="radio" checked="checked" name="options">&nbsp;Playout&nbsp;
							</li>

							<li>&nbsp;<input type="radio" onclick="overviewData();"
								value="Airtime" name="options">&nbsp;Airtime&nbsp;
							</li>
						</ul>
					</div>

				</div>
									<div class="col-sm-3">
									<div id="searchform" role="search" class="navbar-left app-search pull-right">
						<a id="searchLink"  href="#"><i
							style="position: absolute; margin-top: 1%;" class="fa fa-search"></i></a>
						<input  type="text" placeholder=" "  id="searchtag" class="form-control" />
 
 		 <ul id="searchdatalist">
		 </ul>
		

					</div>
 	</div>

 			</div>

						 	<c:forEach items="${datacount}" var="data">
								<c:set var="playout" value="${data.totalplayout}" />
								<c:set var="brandname" value="${data.totalbrands}" />
								<c:set var="airtime" value="${data.totalairtime}" />
								<c:set var="categories" value="${data.totalcategories}" />
								<c:set var="products" value="${data.totalproducts}" />
								<c:set var="spend" value="${data.spend}" />
							</c:forEach> 
<script> 
var spenddata='<c:out value="${spend}"/>';
var spendfmt=currencyFormatter(spenddata, 2); 
</script>

			<div class="page-contentbar">
				<!-- START PAGE CONTENT -->
				<div id="page-right-content">

					<div class="row" style="display: -webkit-box;">

<div class="col-sm-1" style="float:left;">


							<div id="date_range" class="form-control select-first"
								style='color: white;height: 16px !important;border:none;'>
								<!-- <i class="fa fa-calendar"></i> -->
								<span >Date Range</span>&nbsp; <i class="fa fa-caret-down"></i>
							</div>
<input type="hidden" id="startDateSelected" />
<input type="hidden" id="endDateSelected" />
<input type="hidden" id="dateselectedlabel" />
							
					
<style>
#feedback {
	font-size: 1.4em;
}

/* .selectable .ui-selecting {
	background: #FECA40;
} */

.selectable .ui-selected.channel{
	background: #D68319;
}

.selectable .ui-selected-multi.channel{
	background: #D68319;
	
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
	background: #414b53;
	box-shadow: 16px 16px 20px 2px rgba(12, 2, 2, 0.3);
}

.selectable li {
	margin: 3px;
	padding: 1px 0px 0px 3px;
	font-size: 1.4em;
	height: 20px;
	cursor: pointer;
}

.open>.dropdown-menu {
	display: block;
 	height: 280px; 
	overflow-y: auto;
	width: 175px;
}
</style>

							<%-- <div class="form-group">
								<div class="facilities">
									<!-- <select onchange="selectIngredient(this);" multiple="multiple" name='genreName'
									id="genre"> -->
									<div class="dropdown cq-dropdown" data-name='statuses'>
										<div style="color: white; font-size: 11px;"
											class="dropdown-toggle" id="dropdown1" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="true">Genre&nbsp; <i class="fa fa-caret-down"></i></div>
										<ul class="dropdown-menu selectable" id="genre"
											aria-labelledby="dropdown1">

											<c:forEach items="${genres}" var="genres">
												<li class="ui-widget-content genre" id="option_${fn:replace(fn:trim(genres.genre), ' ', '_')}">${fn:trim(genres.genre)}</li>
											</c:forEach>
										</ul>
									</div>
								</div>
							</div> --%>

							<!-- for below Select -- onchange='onChangeAllChartReload(page);  -->
						<%-- 	<div class="form-group">
								<!-- <select class="form-control select-first" onchange="selectIngredient(this);"
									id="channel"> -->

								<div class="dropdown cq-dropdown" data-name='statuses'>
									<div style="color: white; font-size: 11px;"
										class="dropdown-toggle" id="dropdown1" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="true">Channel&nbsp; <i class="fa fa-caret-down"></i></div>
									<ul class="dropdown-menu selectable"
										aria-labelledby="dropdown1" id="channel">
										<c:forEach items="${channels}" var="channels">
											<li class="ui-widget-content channel" id="option_${fn:replace(fn:trim(channels.streamid), ' ','_')}">${fn:trim(channels.streamname)}</li>
										</c:forEach>
									</ul>
								</div>

							</div>
 --%>
							<script>
								
								$("#genre li").on("click",function(e) {
									
									if ($(this).hasClass("ui-selected-multi")) {
										$(this).removeClass(
														"ui-selected ui-selected-multi");
										handleTags($(this).text(), $(this).attr('id'), "genre",
												"remove");
									} else {
										$(this)
												.addClass(" ui-selected-multi");
										handleTags($(this).text(), $(this).attr('id'), "genre",
												"add");
									} 
								});

								$("#channel li").on("click",function(e) {
									
									if ($(this).hasClass("ui-selected-multi")) {
										$(this).removeClass(
														"ui-selected ui-selected-multi");
										handleTags($(this).text(), $(this).attr('id'), "channel",
												"remove");
									} else {
										$(this).addClass(" ui-selected-multi");
										handleTags($(this).text(), $(this).attr('id'), "channel",
												"add");
									}
								});
 
								function handleTags(selection, selectionId, parent, action) {
									$('.tag-box').show();
									var ul = $(".tag-box");
									var ids = selectionId.substring(7);
									if (action == 'add'
											&& $(".tag-box").find("#tag_" + ids).length == 0) {
										$('.tag-box')
												.append(
														'<li class="tags '+parent+' ui-sortable-handle" id="tag_'+ids+'" >'
																+ selection
																+ '<a class="close"></a></li>');
										$("#tag_" + ids).addClass("tagp");
										onChangeAllChartReload(page);
									} if(action == 'remove') {
										
										$("#tag_" + ids).remove();
										var children = $('.tag-box')
												.children().length;
										if (children == 0) {
											$('.tag-box').hide();
										}
										onChangeAllChartReload(page);
									}

									$("#tag_" + ids).on("click",function(e) {
												$("#option_"+ids).removeClass("ui-selected ui-selected-multi");
												$(this).remove();
												
												
												var children = $('.tag-box')
														.children().length;
												if (children == 0) {
													$('.tag-box').hide();
												}
												onChangeAllChartReload(page);
											});
								}
							</script>

							<input type="hidden" value="10" id="limit" placeholder="limit" />
						</div>   
					
						<div class="col-sm-11">
							<!-- test filter end -->
							<ul class="tag-box ui-sortable" style="display: none;"></ul>
							<div id="tagDiv"
								style="height: 40px; margin-bottom: 15px; padding: 10px 0 0 10px; width: 98%; background: rgba(22, 26, 29, 0.55); box-shadow: 16px 16px 20px 2px rgba(12, 2, 2, 0.3); display: none;">
							</div> 
				<!-- 			<div class="grey-bg"> -->
								<div class="row">
									<div class="col-sm-12">
										<!--  <h4>  Product Dashboard </h4>     -->
									
										<div class="col-sm-3" style="display: block;">

<div
								style="height: 6%; margin-bottom: 15px; padding: 6px 0 0 10px; width: 98%; background: rgba(22, 26, 29, 0.55); box-shadow: 16px 16px 20px 2px rgba(12, 2, 2, 0.3);">

								<h4
									style="color: rgb(255, 255, 255, 0.8); font-size: 21px; font-weight: 100 !important;"><a href="./ChannelDashboard" style="color: rgb(255, 255, 255, 0.8)">Top Channels</a></h4>
							</div>
							<div style="height: 405px; overflow-y: auto;"
								class="ChannelList"></div>
						
										</div>
							 			<div class="col-sm-3">
											<!--  <h1>Genre Wise Playout </h1>-->

<div
								style="height: 6%; margin-bottom: 15px; padding: 6px 0 0 10px; width: 98%; background: rgba(22, 26, 29, 0.55); box-shadow: 16px 16px 20px 2px rgba(12, 2, 2, 0.3);">

								<h4
									style="color: rgb(255, 255, 255, 0.8); font-size: 21px; font-weight: 100 !important;"><a href="./CategoryDashboard" style="color: rgb(255, 255, 255, 0.8)">Top Categories</a></h4>
							</div>
							<div style="height: 405px; overflow-y: auto;"
								class="CategoryList"></div>
										</div>
						<div class="col-sm-3" >
							<div
								style="height: 6%; margin-bottom: 15px; padding: 6px 0 0 10px; width: 98%; background: rgba(22, 26, 29, 0.55); box-shadow: 16px 16px 20px 2px rgba(12, 2, 2, 0.3);">

								<h4
									style="color: rgb(255, 255, 255, 0.8); font-size: 21px; font-weight: 100 !important;"><a href="./ProductDashboard" style="color: rgb(255, 255, 255, 0.8)">Top Products</a></h4>
							</div>
							<div style="height: 405px; overflow-y: auto;"
								class="ProductList"></div>
												</div>
										<div class="col-sm-3">
						<div
								style="height: 6%; margin-bottom: 15px; padding: 6px 0 0 10px; width: 98%; background: rgba(22, 26, 29, 0.55); box-shadow: 16px 16px 20px 2px rgba(12, 2, 2, 0.3);">

								<h4
									style="color: rgb(255, 255, 255, 0.8); font-size: 21px; font-weight: 100 !important;"><a style="color: rgb(255, 255, 255, 0.8)" href="./BrandDashboard">Top Brands</a></h4>
							</div> 
							<div style="height: 405px; overflow-y: auto;"
								class="BrandList"></div>
															</div>
								</div>
						</div>
						<br></br>
						
							<div class="row">	
			<div class="col-sm-12 singlePg_sm_div dark" id="singlePg_sm_div" style="padding-bottom: 5px;">
   
										
									<div class="col-sm-2">
							
									<h4 style="text-align: center; color: rgb(255, 255, 255, 0.8); font-size: 14px; margin-bottom: 10px;">Categories</h4>
									<div style="text-align: center; color:rgb(85,206,249);">
										<span style="font-size: 15px;"><c:out value='${categories}' /></span>
								</div>
</div>
						<div class="col-sm-2">
									<h4 style="text-align: center; color: rgb(255, 255, 255, 0.8); font-size: 14px; margin-bottom: 10px;">Brands</h4>
									<div style="text-align: center; color:rgb(85,206,249);">
										<span style="font-size: 15px;"><c:out value='${brandname}' /></span>
								</div>
                              </div>
                              									<div class="col-sm-2">
					
									<h4 style="text-align: center; color: rgb(255, 255, 255, 0.8); font-size: 14px; margin-bottom: 10px;">Products</h4>
									<div style="text-align: center; color:rgb(85,206,249);">
										<span style="font-size: 15px;"><c:out value='${products}' /></span>
									</div>
								</div>
						<div class="col-sm-2">
									<h4 style="text-align: center; color: rgb(255, 255, 255, 0.8); font-size: 14px; margin-bottom: 10px;">Airtime</h4>
									<div style="text-align: center; color:rgb(85,206,249);">
										<span style="font-size: 15px;"><c:out value='${airtime}' /></span>
									</div>
					          </div>
                              									<div class="col-sm-2">

									<h4 style="text-align: center; color: rgb(255, 255, 255, 0.8); font-size: 14px; margin-bottom: 10px;">Playout</h4>
									<div style="text-align: center; color:rgb(85,206,249);">
										<span style="font-size: 15px;"><c:out value='${playout}' /></span>
								</div>
</div>
						<div class="col-sm-2">
									<h4 style="text-align: center; color: rgb(255, 255, 255, 0.8); font-size: 14px; margin-bottom: 10px;">Spend</h4>
									<div style="text-align: center; color:rgb(85,206,249);">
										<span style="font-size: 15px;"><%= "<script>document.writeln(spendfmt)</script>" %></span>
									</div>
			<!-- End #page-right-content -->
			</div>
		</div> 
		 <div style="width:100%;">
        <div id="thumbnail-slider">
            <div class="inner">
                <ul id="cardList">
                                                                 
                </ul>
            </div>
        </div> 
    </div>       </div>                        		
		</div>
		<!-- end .page-contentbar -->
	</div>
	</div>
	</div>
	</div>
	</div>
	<div class="footer">SYNC - Copyright © 2019</div>
    <script src="${context}/resources/card/js/thumbnail-slider.js" type="text/javascript"></script>
</body>
</html> 
<%
}
else{
response.sendRedirect("./Login");	
}
%> 
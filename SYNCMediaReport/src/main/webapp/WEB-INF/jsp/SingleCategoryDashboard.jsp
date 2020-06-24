
<%
	String username = (String) session.getAttribute("username");
	if (username != null) {
%>
<!DOCTYPE html>
<html lang="en">
<!--Highchart script start -->
<script src="https://code.highcharts.com/highcharts.js"></script>
<!-- <script src="https://code.highcharts.com/modules/pattern-fill.js"></script> -->
<!--Highchart script end -->

<head>
<%@ include file="Libraries.jsp"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<meta charset="utf-8" />
<title>SYNC Dashboard</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />


<meta content="Coderthemes" name="author" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />


<style>
.bootstrap-datetimepicker-widget {
	background-color: #333;
}
</style>
<body style="font-family: Roboto, sans-serif !important;"
	id="completeData">


	<div id="page-wrapper">
		<%@ include file="Report.jsp"%>
		<%@ include file="RecentCards.jsp"%>
		<input type="hidden" id="startDateSelected" /> <input type="hidden"
			id="endDateSelected" />
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

					<li class="dropdown top-menu-item-xs"><a href=""
						class="dropdown-toggle menu-right-item profile"
						data-toggle="dropdown" aria-expanded="true"> <img
							src="${context}/resources/images/user.png" alt="user-img">
					</a>
						<ul class="dropdown-menu">
							<li>
								<!-- <a href="javascript:void(0)"><i
									class="ti-user m-r-10"></i> Profile</a> -->
							</li>
							<!-- <li class="divider">
							
							</li>
 -->
							<li><a href="./Logout"><i class="ti-user m-r-10"></i>
									Logout</a></li>
						</ul></li>
				</ul>


			</div>
			<div class="dashbar">

				<div class="col-sm-5">
					<img src="${context}/resources/images/category.png"
						alt="Category-img" style="float: left; width: 40px; height: 37px;">
					<h1>
						<a href="${context}/CategoryDashboard"
							style="color: rgba(255, 255, 255, 0.8) !important;">Category
							Dashboard</a>
					</h1>
				</div>
				<div class="col-sm-4">
					<div class="Bar-check">
						<ul>
							<li style="">&nbsp;<input
								onclick="singleCategoryChartReload(page);" id="time"
								value="Playout" type="radio" checked="checked" name="options">&nbsp;Playout&nbsp;
							</li>

							<li>&nbsp;<input type="radio"
								onclick="singleCategoryChartReload(page);" value="Airtime"
								name="options">&nbsp;Airtime&nbsp;
							</li>
						</ul>
					</div>

				</div>
				<div class="col-sm-3">
					<div id="searchform" role="search"
						class="navbar-left app-search pull-right">
						<a id="searchLink" href="#"><i
							style="position: absolute; margin-top: 1%;" class="fa fa-search"></i></a>
						<input type="text" placeholder=" " id="searchtag"
							class="form-control" />

						<ul id="searchdatalist">
						</ul>


					</div>
				</div>

			</div>

			<div class="page-contentbar">
				<!-- START PAGE CONTENT -->
				<div id="page-right-content">
					<input type="hidden" id="limit" placeholder="limit" />
					<div class="row" style="display: -webkit-box;">
						<div class="col-sm-4">
							<c:forEach items="${Logo}" var="Logo">

								<c:set var="logo" value='${Logo}' />
							</c:forEach>
							<c:forEach items="${categoryData}" var="category">
								<c:set var="categoryname" value="${category.categoryname}" />
								<c:set var="playout" value="${category.count}" />
								<c:set var="airtime" value="${category.airtime}" />
								<c:set var="categories" value="${category.categoryname}" />
								<c:set var="languages" value="${category.language}" />
								<c:set var="channels" value="${category.cid}" />
								<c:set var="spend" value='${category.spend}' />

							</c:forEach>
							<script>
var spenddata='<c:out value="${spend}" />';
var spendfmt=currencyFormatter(spenddata, 2); 

</script>

							<div class="col-sm-12">

								<div class="col-sm-6" style="width: 46%; margin-bottom: 20px;">

									<div>
										<c:choose>
											<c:when test="${logo==null || logo ==''  || logo =='NA' }">
												<img style="opacity: 0.2;"
													src="./resources/images/no_img.png" />
											</c:when>
											<c:otherwise>
												<img src="${logoUrl}<c:out value='${logo}' />" />
											</c:otherwise>
										</c:choose>
										<%-- <span style="font-size: 21px;"><%=request.getParameter("product")%></span> --%>
									</div>
								</div>

								<div class="col-sm-6" style="width: 90%; margin-bottom: 20px;">

									<div class="sinlgePg_cat_lang">
										<div class="cate-colors" style="color: #ffffff;">
											<span title="<%=session.getAttribute("categoryname")%>"
												style="border-bottom: 1px solid rgb(37, 159, 173); font-size: 21px;"><%=session.getAttribute("categoryname")%></span>
										</div>
										<%-- <div style="padding-top: 35px;"><span title="<c:out	value='${categories}' />" style="font-size: 13px; color:  rgb(52,163,159);"><label style="font-weight:200; color:rgb(255, 255, 255, 0.8);">Categories: </label> <c:out
												value="${categories}" /></span></div>
										<div ><span style="font-size: 13px; color: rgb(111,208,206);"><label style="font-weight:200; color:rgb(255, 255, 255, 0.8);">Language: </label> <c:out
												value="${languages}" /></span></div> --%>

									</div>
								</div>

							</div>
							<div class="col-sm-6">
								<div class="singlePg_sm_div dark">

									<h4
										style="text-align: center; color: rgb(37, 159, 173); font-size: 14px; margin-bottom: 10px;">Playouts</h4>
									<div style="text-align: center; color: #fff;">
										<span style="font-size: 24px;"><c:out
												value="${playout}" /></span>
									</div>
								</div>

								<div class="singlePg_sm_div dark">

									<h4
										style="text-align: center; color: rgb(37, 159, 173); font-size: 14px; margin-bottom: 10px;">Spend</h4>
									<div style="text-align: center; color: #fff;">
										<span style="font-size: 25px;"><%="<script>document.writeln(spendfmt)</script>"%></span>
									</div>

								</div>
								<%-- <div class="singlePg_sm_div light">

									<h4
										style="text-align: center; color: rgb(255, 255, 255, 0.8); font-size: 14px; margin-bottom: 5px;">Categories</h4>
									<div style="text-align: center; color: rgb(85, 206, 249);">
										<span style="font-size: 21px;"><c:out
												value="${categories}" /></span>
									</div>
								</div> --%>

							</div>

							<div class="col-sm-6">
								<div class="singlePg_sm_div dark">

									<h4
										style="text-align: center; color: rgba(234, 95, 153); font-size: 14px; margin-bottom: 10px;">Airtime</h4>
									<div style="text-align: center; color: #fff;">
										<span style="font-size: 25px;"><c:out
												value="${airtime}" /></span>
									</div>
								</div>
								<%-- <div class="singlePg_sm_div light">

									<h4
										style="text-align: center; color: rgb(255, 255, 255, 0.8); font-size: 14px; margin-bottom: 5px;">Languages</h4>
									<div style="text-align: center; color: rgb(85, 206, 249);">
										<span style="font-size: 21px;"><c:out
												value="${languages}" /></span>
								</div>
								</div> --%>

								<div class="singlePg_sm_div dark">

									<h4
										style="text-align: center; color: rgba(234, 95, 153); font-size: 14px; margin-bottom: 10px;">Channels</h4>
									<div style="text-align: center; color: #fff;">
										<span style="font-size: 24px;"><c:out
												value="${channels}" /></span>
									</div>
								</div>

							</div>

							<div class="col-sm-12">
								<div class="grey-bg" style="height: 400px;">

									<div class="col-sm-12">
										<div class="card card-chart">
											<div class="card-header">

												<h4 class="card-title">
													<i class="tim-icons icon-tv-2"></i><a
														href="./ChannelDashboard">Top Channels</a>
												</h4>
												<h5 class="card-title2" id="titledata"></h5>
											</div>
											<div class="card-body">

												<div id="resizer"
													style="min-width: 300px; min-height: 200px; width: 500px">
													<div id="inner-resizer">
														<div id="topChannelDonut" style="height: 230px"></div>
													</div>
												</div>
											</div>
										</div>


									</div>
								</div>
							</div>
						</div>

						<div class="col-sm-8">
							<!-- test filter end -->

							<div class="grey-bg">
								<div class="row">
									<div class="col-sm-12">
										<!--  <h4>  Product Dashboard </h4>     -->
										<div class="col-sm-4" style="display: block;">
											<!-- <h1>Genre Wise Channel </h1>-->

											<div class="card card-chart">
												<div class="card-header">
													<h4 class="card-title">
														<i class="tim-icons icon-tv-2"></i><a
															href="./ChannelDashboard">Top Channels</a>
													</h4>
													<h5 class="card-title2" id="titledata"></h5>
													<!-- <h3 class="card-title"><i class="tim-icons icon-bell-55 text-primary"></i> 763,215</h3> -->
												</div>
												<div class="card-body" id="topChannelChartBody">
													<div class="chart-area" id="piegraph"
														style="overflow: visible;">
														<div id="chartLinePurple"></div>


													</div>
												</div>
											</div>
										</div>
										<div class="bd-distanse hidden-xs">
											<div class="v-border"></div>
										</div>
										<div class="col-sm-4">
											<!--  <h1>Genre Wise Playout </h1>-->

											<div class="card card-chart">
												<div class="card-header">
													<h4 class="card-title">
														<i class="tim-icons icon-bullet-list-67"></i><a
															href="./ProductDashboard">Top Products</a>
													</h4>
													<h5 class="card-title2" id="titledata"></h5>
													<!-- <h3 class="card-title"><i class="tim-icons icon-delivery-fast text-info"></i> 3,500</h3> -->
												</div>
												<div class="card-body" id="topCategoryChartBody"
													style="height: 250px;">
													<div class="chart-area2" style="height: 20px !important;">

													</div>
												</div>
											</div>
										</div>
										<div class="bd-distanse hidden-xs">
											<div class="v-border"></div>
										</div>
										<div class="col-sm-4">
											<div class="card card-chart">
												<div class="card-header">
													<h4 class="card-title">
														<i class="tim-icons icon-volume-98"></i><a
															href="./BrandDashboard">Top Brands</a>
													</h4>
													<h5 class="card-title2" id="titledata"></h5>
													<!-- <h3 class="card-title"><i class="tim-icons icon-send text-success"></i> 12,100K</h3> -->
												</div>
												<div class="card-body" id="topLanguageChartBody">
													<div id="languageDiv"></div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12">
										<!-- <div class="graph-bg" style="background-color: #606870;"> -->
										<div class="col-sm-6">
											<!-- <h1>Daily Playouts </h1>-->
											<div class="card card-chart">
												<div class="card-header">
													<h4 class="card-title">
														<i class="tim-icons icon-calendar-60"></i>Daily Playout
													</h4>
													<h5 class="card-title2" id="titledata"></h5>
													<!-- <h3 class="card-title"><i class="tim-icons icon-delivery-fast text-info"></i> 3,500</h3> -->
												</div>
												<div class="card-body">
													<div class="chart-area">
														<canvas id="dailyPlayoutLineChart"></canvas>
													</div>
												</div>
											</div>
										</div>
										<div class="bd-distanse hidden-xs">
											<div class="v-border"></div>
										</div>
										<div class="col-sm-6" style="display: block;">
											<!--<h1>Hourly Playouts </h1>-->
											<div class="card card-chart">
												<div class="card-header">
													<h4 class="card-title">
														<i class="tim-icons icon-watch-time"></i>Hourly Playout
													</h4>
													<select id="hourlyunits" class="hoursUnitSelect"
														style="background: #5d6369; float: right; border: none; outline: none;"
														onchange="hourlyPlayoutData('/getHourlyPlayoutByCategory','rgb(234, 95, 153)', 'rgb(241, 105, 91)', '0.4','hourlyPlayoutLineChart');">
														<option value="Hours">HOURS</option>
														<option value="AM">AM</option>
														<option value="PM">PM</option>
													</select>
													<h5 class="card-title2" id="titledata"></h5>

													<!-- <h3 class="card-title">
									<i class="tim-icons icon-delivery-fast text-info"></i> 3,500
								</h3> -->
												</div>
												<div class="card-body">
													<div class="chart-area">
														<canvas id="hourlyPlayoutLineChart"></canvas>
													</div>
												</div>
											</div>
										</div>
										<!-- </div> -->
									</div>
									<div class="col-sm-12">
										<div class=" download-bottom">
											<div class="pull-right hidden-xs"
												style="margin: 0 15px 0px 0;">
												<button onclick="showModal();" id="createcard"
													style="margin-left: 18px; cursor: pointer; color: #A9A9A9; border: none; background: none;">
													<i class="fa fa-plus" style="color: #A9A9A9;"
														aria-hidden="true"></i> Create Card
												</button>

												<a href="#" id="priviewData" style="color: #A9A9A9"
													onclick="screenShot();"> <i class="fa fa-eye"
													style="color: #A9A9A9;"></i>View
												</a> <a href="#" onclick="tabledata2();"
													style="margin-left: 18px; color: #A9A9A9"> <i
													class="fa fa-download" style="color: #A9A9A9;"></i>
													Download
												</a>
												<div id="showpriview" style="display: none;"></div>

											</div>

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
			<!-- End #page-right-content -->
			<div class="clearfix"></div>
		</div>
		<!-- end .page-contentbar -->
	</div>
	<div class="footer">SYNC - Copyright © 2019</div>
	<script>
var contextpath = "${context}";
var startdate='<%=session.getAttribute("startdate")%>';
var enddate='<%=session.getAttribute("enddate")%>';
var category="<%=session.getAttribute("categoryname")%>";
var elementName="<%=session.getAttribute("categoryname")%>";
var datetextdata='<%=session.getAttribute("datetext")%>';
var cid='<%=request.getParameter("cid")%>';
		var elementType = 'SingleCategory';
		var cardUrl = "#";
		var page = 'scad';
		var logo = "${Logo}";
		var cardstatus =
	<%=session.getAttribute("cardstatus")%>
		;
		singleCategoryChartReload(page);
		if (cardstatus == '1') {
			document.getElementById("createcard").disabled = true;
		} else {
			document.getElementById("createcard").disabled = false;
		}

		$(document).ready(function() {
			$('#topChannelChartBody').slimScroll({
				height : '250px'
			});
			$('#topCategoryChartBody').slimScroll({
				height : '250px'
			});
			$('#topLanguageChartBody').slimScroll({
				height : '250px'
			});

			$('#startDateSelected').val(startdate);
			$('#endDateSelected').val(enddate);

		});
	</script>

</body>
<script type="text/javascript"
	src="${context}/resources/assets/demo/report.js"></script>
</html>
<%
}
else{
response.sendRedirect("./Login");	
}
%>
.

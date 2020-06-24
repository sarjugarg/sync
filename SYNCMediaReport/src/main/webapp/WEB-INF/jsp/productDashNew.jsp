<!DOCTYPE html>
<!-- saved from url=(0041)http://13.233.39.58:8080/SYNCMediaReport/ -->
<html lang="en" class="perfect-scrollbar-on">
<!--Highchart script start -->

<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1252">
<script src="${context}/resources/allAssets/highcharts.js.download"></script>
<!-- <script src="https://code.highcharts.com/modules/pattern-fill.js"></script> -->
<!--Highchart script end -->

<script>
	var contextpath = "${context}/resources/allAssets";
</script>

<title>SYNC Dashboard</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="${context}/resources/allAssets/css" rel="stylesheet">
<meta content="Coderthemes" name="author">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link href="${context}/resources/allAssets/css(1)" rel="stylesheet">
<!-- Bootstrap core CSS -->
<link href="${context}/resources/allAssets/bootstrap.min.css"
	rel="stylesheet">
<!-- Icons CSS -->
<link href="${context}/resources/allAssets/icons.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${context}/resources/allAssets/style.css" rel="stylesheet">
<link href="${context}/resources/allAssets/black-dashboard.css"
	rel="stylesheet">
<script
	src="${context}/resources/allAssets/jquery-2.1.4.min.js.download"></script>
<script src="${context}/resources/allAssets/bootstrap.min.js.download"></script>
<script
	src="${context}/resources/allAssets/jquery.slimscroll.min.js.download"></script>
<script
	src="${context}/resources/allAssets/perfect-scrollbar.jquery.min.js.download"></script>
<script src="${context}/resources/allAssets/popper.min.js.download"></script>
<script
	src="${context}/resources/allAssets/bootstrap.min.js(1).download"></script>
<script
	src="${context}/resources/allAssets/perfect-scrollbar.jquery.min.js.download"></script>
<script src="${context}/resources/allAssets/productdata.js"></script>
<!--  Google Maps Plugin    -->
<!-- Place this tag in your head or just before your close body tag. -->
<!-- <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script> -->
<!-- Chart JS -->
<script src="${context}/resources/allAssets/chartjs.min.js.download"></script>
<style type="text/css">
/* Chart.js */
@
-webkit-keyframes chartjs-render-animation {from { opacity:0.99
	
}

to {
	opacity: 1
}

}
@
keyframes chartjs-render-animation {from { opacity:0.99
	
}

to {
	opacity: 1
}

}
.chartjs-render-monitor {
	-webkit-animation: chartjs-render-animation 0.001s;
	animation: chartjs-render-animation 0.001s;
}
</style>
<!--  Notifications Plugin    -->
<script
	src="${context}/resources/allAssets/bootstrap-notify.js.download"></script>
<!-- Control Center for Black Dashboard: parallax effects, scripts for the example pages etc -->
<script
	src="${context}/resources/allAssets/black-dashboard.min.js.download"></script>
<!-- Black Dashboard DEMO methods, don't include it in your project! -->

<script src="${context}/resources/allAssets/jquery-ui.js.download"></script>
<script src="${context}/resources/allAssets/black-dashboard.js.download"></script>

<!-- App Js -->
<script src="${context}/resources/allAssets/jquery.app.js.download"></script>
<link rel="stylesheet"
	href="${context}/resources/allAssets/bootstrap.min(1).css">
<script
	src="${context}/resources/allAssets/bootstrap.min.js(2).download"></script>
<script src="${context}/resources/allAssets/chartjs.min.js.download"></script>
<script src="${context}/resources/allAssets/demo.js"></script>
<style type="text/css">
/* Chart.js */
@
-webkit-keyframes chartjs-render-animation {from { opacity:0.99
	
}

to {
	opacity: 1
}

}
@
keyframes chartjs-render-animation {from { opacity:0.99
	
}

to {
	opacity: 1
}

}
.chartjs-render-monitor {
	-webkit-animation: chartjs-render-animation 0.001s;
	animation: chartjs-render-animation 0.001s;
}
</style>
<script src="${context}/resources/allAssets/black-dashboard.js.download"></script>
<script src="${context}/resources/allAssets/ProductGraphHighchart.js"></script>
<script>
	$(document).ready(function() {
		$('.form-control filters').slimScroll();
		$('.topProductdiv').slimScroll({
			height : '405px'
		});
		allgraph();
	});
</script>
<link rel="stylesheet" id="coToolbarStyle"
	href="chrome-extension://bejnhdlplbjhffionohbdnpcbobfejcc/toolbar/styles/placeholder.css"
	type="text/css">
<script type="text/javascript" id="cosymantecbfw_removeToolbar">
	(function() {
		var toolbarElement = {}, parent = {}, interval = 0, retryCount = 0, isRemoved = false;
		if (window.location.protocol === 'file:') {
			interval = window.setInterval(function() {
				toolbarElement = document.getElementById('coFrameDiv');
				if (toolbarElement) {
					parent = toolbarElement.parentNode;
					if (parent) {
						parent.removeChild(toolbarElement);
						isRemoved = true;
						if (document.body && document.body.style) {
							document.body.style.setProperty('margin-top',
									'0px', 'important');
						}
					}
				}
				retryCount += 1;
				if (retryCount > 10 || isRemoved) {
					window.clearInterval(interval);
				}
			}, 10);
		}
	})();
</script>
</head>

<body cz-shortcut-listen="true">

	<div id="page-wrapper">
		<div class="container-fluid">
			<!-- Top Bar Start -->
			<div class="topbar" id="topnav">

				<div class="topbar-left">
					<div class="">
						<a href="http://13.233.39.58:8080/SYNCMediaReport/index.html"
							class="logo"> <img
							src="${context}/resources/allAssets/logo.png" alt="logo"
							class="logo-lg"> <img
							src="${context}/resources/allAssets/logo_sm.png" alt="logo"
							class="logo-sm hidden">
						</a>
					</div>
				</div>
				<!-- Top nav Right menu -->
				<ul
					class="nav navbar-nav navbar-right top-navbar-items-right pull-right">
					<!--    <li class="top-menu-item-xs">
                     
                        <a class="navbar-toggle">
                            <div class="lines">
                                <span></span> <span></span> <span></span>
                            </div>
                        </a>
                    
                    </li> -->

					<li class="dropdown top-menu-item-xs"><a
						href="http://13.233.39.58:8080/SYNCMediaReport/"
						class="dropdown-toggle menu-right-item profile"
						data-toggle="dropdown" aria-expanded="true"><img
							src="${context}/resources/allAssets/user.png" alt="user-img">
					</a>
						<ul class="dropdown-menu inheritdropdown">
							<li><a href="javascript:void(0)"><i
									class="ti-user m-r-10"></i> Profile</a></li>
							<li class="divider"></li>
							<li><a href="javascript:void(0)"><i
									class="ti-power-off m-r-10"></i> Logout</a></li>
						</ul></li>
				</ul>

			</div>
			<div class="dashbar">

				<div class="col-sm-5">
					<img src="${context}/resources/allAssets/Product.png"
						alt="Product-img" style="float: left; width: 40px; height: 37px;">
					<h1>Product Dashboard</h1>
				</div>
				<div class="col-sm-4">
					<div class="Bar-check">
						<ul>
							<li style="">&nbsp;<input onclick="allgraph();" id="time"
								value="Playout" type="radio" checked="checked" name="options">&nbsp;Playout&nbsp;
							</li>

							<li>&nbsp;<input type="radio" onclick="allgraph()"
								value="Airtime" name="options">&nbsp;Airtime&nbsp;
							</li>
						</ul>
					</div>

				</div>
				<div class="col-sm-3">
					<form role="search" class="navbar-left app-search pull-right">
						<a href="http://13.233.39.58:8080/SYNCMediaReport/"><i
							style="position: absolute; margin-top: 1%;" class="fa fa-search"></i></a>
						<input type="text" placeholder="Search " class="form-control">

					</form>
				</div>

			</div>

			<!-- Page content start -->
			<div class="page-contentbar">
				<!-- START PAGE CONTENT -->
				<div id="page-right-content">
					<div class="row" style="display: -webkit-box;">
						<div class="col-sm-1">
							<select class="form-control select-first" id="date_range"
								onchange="allgraph()">
								<option value="0">Today</option>
								<option value="7" selected="">Weekly</option>
								<option value="15">15 Days</option>
								<option value="30">Monthly</option>
							</select>
<div class="form-group">
								<select class="form-control filters" style="border: none; box-shadow: none; color: white;background: none;"
								onfocus='this.size=10;' onblur='this.size=1;' onchange='this.size=1; this.blur();allgraph();' id="" >
									<option value="">Genre</option>
									<option value="">Select</option>
									<c:forEach items="${genres}" var="genres">
										<option value="'${genres.genre}'">${genres.genre}</option>
									</c:forEach>
								</select>
								
								
							</div>
							<div class="form-group">
								<select class="form-control filters" style="border: none; box-shadow: none; color: white;background: none;"
								onfocus='this.size=10;' onblur='this.size=1;' onchange='this.size=1; this.blur();allgraph();' id="channel"
								>
								    	<option value="">Channel</option>
									<option value="">Select</option>
									<c:forEach items="${channels}" var="channels">
										<option value="'${channels.streamid}'">${channels.streamname}</option>
									</c:forEach>
								</select>
							</div>
							
						</div>
						
						<div class="col-sm-3" id="topProductChartArea">
							<div class="topProductdiv"></div>

							<br>
							<div class="count-product">

								<div
									style="width: 84px; height: 84px; position: absolute; margin-top: 8px; border: 2px rgb(0, 206, 209) solid; border-radius: 84px; text-align: center; padding-top: 13px;">

<c:forEach items="${datacount}" var="data">
										<span 
											style=" font-size: 34px;color: white;">${data.totalproducts}</span>
									</c:forEach>
								</div>
								<h4
									style="margin-top: 10%; position: absolute; margin-left: 30%; color: white; font-size: 21px;">Products</h4>
							</div>

						</div>

						<div class="col-sm-8">

							<div class="grey-bg">
								<div class="row">
									<div class="col-sm-12">
										<!--  <h4>  Product Dashboard </h4>     -->
										<div class="col-sm-4" style="display: block;">
											<!-- <h1>Genre Wise Channel </h1>-->

											<div class="card card-chart">
												<div class="card-header">
													<h4 class="card-title">
														<i class="tim-icons icon-tv-2"></i>Top Channels
													</h4>
													<h5 class="card-title2">Calculated in last 15 days</h5>
													<!-- <h3 class="card-title"><i class="tim-icons icon-bell-55 text-primary"></i> 763,215</h3> -->
												</div>
												<div class="card-body" id="topChannelChartBody"
													style="border-right: 1px #458bc4 solid;">
													<div class="chart-area" id="piegraph"
														style="overflow: visible;">
														<div id="chartLinePurple" data-highcharts-chart="0"
															style="overflow: hidden;">
															<div id="highcharts-07sj9o0-0" dir="ltr"
																class="highcharts-container "
																style="position: relative; overflow: hidden; width: 253px; height: 400px; text-align: left; line-height: normal; z-index: 0; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">
																<svg version="1.1" class="highcharts-root"
																	style="font-family: &amp; amp; quot; Lucida Grande&amp;amp; quot; , &amp; amp; quot; Lucida Sans Unicode&amp;amp; quot; , Arial , Helvetica, sans-serif; font-size: 12px;"
																	xmlns="http://www.w3.org/2000/svg" width="253"
																	height="400" viewBox="0 0 253 400">
                                                                    <desc>Created with Highcharts 7.0.3</desc>
                                                                    <defs>
                                                                        <clippath
																		id="highcharts-07sj9o0-11">
                                                                            <rect
																		x="0" y="0" width="233" height="375" fill="none"></rect>
                                                                        </clippath>
                                                                    </defs>
                                                                    <rect
																		fill="none" class="highcharts-background" x="0" y="0"
																		width="253" height="400" rx="0" ry="0"></rect>
                                                                    <rect
																		fill="none" class="highcharts-plot-background" x="10"
																		y="10" width="233" height="375"></rect>
                                                                    <rect
																		fill="none" class="highcharts-plot-border"
																		data-z-index="1" x="10" y="10" width="233"
																		height="375"></rect>
                                                                    <g
																		class="highcharts-series-group" data-z-index="3">
                                                                        <g
																		data-z-index="0.1"
																		class="highcharts-series highcharts-series-0 highcharts-pie-series  highcharts-tracker"
																		transform="translate(10,10) scale(1 1)"
																		style="cursor:true;">
                                                                            <path
																		fill="rgb(0,28,83)"
																		d="M 116.48518786626127 14.27500150841739 A 72.725 72.725 0 0 1 171.6518674314097 39.59538900245875 L 163.37908731669825 46.706080652089945 A 61.81624999999999 61.81624999999999 0 0 0 116.48740968632208 25.183751282154788 Z"
																		transform="translate(0,0)" stroke="#ffffff"
																		stroke-width="1" stroke-linejoin="round"
																		class="highcharts-point highcharts-color-0"></path>
                                                                            <path
																		fill="rgb(0,54,109)"
																		d="M 171.69924445857507 39.6505645630017 A 72.725 72.725 0 0 1 188.51345832456406 97.1482730125021 L 177.7114395758794 95.62603206062678 A 61.81624999999999 61.81624999999999 0 0 0 163.4193577897888 46.75297987855145 Z"
																		transform="translate(0,0)" stroke="#ffffff"
																		stroke-width="1" stroke-linejoin="round"
																		class="highcharts-point highcharts-color-1"></path>
                                                                            <path
																		fill="rgb(22,79,134)"
																		d="M 188.50327404651676 97.22028138468833 A 72.725 72.725 0 0 1 165.1494451964677 141.05698018827806 L 157.85202841699754 132.94843316003636 A 61.81624999999999 61.81624999999999 0 0 0 177.70278293953925 95.68723917698509 Z"
																		transform="translate(0,0)" stroke="#ffffff"
																		stroke-width="1" stroke-linejoin="round"
																		class="highcharts-point highcharts-color-2"></path>
                                                                            <path
																		fill="rgb(48,105,160)"
																		d="M 165.09536390056832 141.10560259687844 A 72.725 72.725 0 0 1 120.77349961896624 159.59933075453722 L 120.1324746761213 148.70943114135662 A 61.81624999999999 61.81624999999999 0 0 0 157.80605931548308 132.98976220734667 Z"
																		transform="translate(0,0)" stroke="#ffffff"
																		stroke-width="1" stroke-linejoin="round"
																		class="highcharts-point highcharts-color-3"></path>
                                                                            <path
																		fill="rgb(73,130,185)"
																		d="M 120.70089816356197 159.60356795378158 A 72.725 72.725 0 0 1 76.75429713565565 147.90324070867862 L 82.71615256530731 138.7677546023768 A 61.81624999999999 61.81624999999999 0 0 0 120.07076343902767 148.71303276071436 Z"
																		transform="translate(0,0)" stroke="#ffffff"
																		stroke-width="1" stroke-linejoin="round"
																		class="highcharts-point highcharts-color-4"></path>
                                                                            <path
																		fill="rgb(99,156,211)"
																		d="M 76.6934137779473 147.86346456082074 A 72.725 72.725 0 0 1 48.45209872774622 112.65947695183208 L 58.65928391858429 108.81055540905726 A 61.81624999999999 61.81624999999999 0 0 0 82.66440171125521 138.73394487669762 Z"
																		transform="translate(0,0)" stroke="#ffffff"
																		stroke-width="1" stroke-linejoin="round"
																		class="highcharts-point highcharts-color-5"></path>
                                                                            <path
																		fill="rgb(124,181,236)"
																		d="M 48.426473279018765 112.59141623216374 A 72.725 72.725 0 0 1 45.56627000489813 70.9584422831826 L 56.20632950416341 73.36467594070521 A 61.81624999999999 61.81624999999999 0 0 0 58.63750228716596 108.75270379733918 Z"
																		transform="translate(0,0)" stroke="#ffffff"
																		stroke-width="1" stroke-linejoin="round"
																		class="highcharts-point highcharts-color-6"></path>
                                                                            <path
																		fill="rgb(149,206,255)"
																		d="M 45.58234702680339 70.88751658578798 A 72.725 72.725 0 0 1 62.375498853498115 38.42568579339162 L 70.4941740254734 45.71183292438288 A 61.81624999999999 61.81624999999999 0 0 0 56.21999497278289 73.3043890979198 Z"
																		transform="translate(0,0)" stroke="#ffffff"
																		stroke-width="1" stroke-linejoin="round"
																		class="highcharts-point highcharts-color-7"></path>
                                                                            <path
																		fill="rgb(175,232,255)"
																		d="M 62.42410022185732 38.37158558842096 A 72.725 72.725 0 0 1 87.08560143483064 20.488957442772247 L 91.49776121960605 30.46561382635641 A 61.81624999999999 61.81624999999999 0 0 0 70.53548518857872 45.66584775015782 Z"
																		transform="translate(0,0)" stroke="#ffffff"
																		stroke-width="1" stroke-linejoin="round"
																		class="highcharts-point highcharts-color-8"></path>
                                                                            <path
																		fill="rgb(200,255,255)"
																		d="M 87.15212717350076 20.459576304627973 A 72.725 72.725 0 0 1 116.39898643400375 14.275070152942163 L 116.41413846890318 25.183809630000844 A 61.81624999999999 61.81624999999999 0 0 0 91.55430809747565 30.440639858933785 Z"
																		transform="translate(0,0)" stroke="#ffffff"
																		stroke-width="1" stroke-linejoin="round"
																		class="highcharts-point highcharts-color-9"></path>
                                                                        </g>
                                                                        <g
																		data-z-index="0.1"
																		class="highcharts-markers highcharts-series-0 highcharts-pie-series "
																		transform="translate(10,10) scale(1 1)"></g>
                                                                    </g>
                                                                    <text
																		x="127" text-anchor="middle" class="highcharts-title"
																		data-z-index="4"
																		style="color:white;font-size:18px;fill:white;" y="24"></text>
                                                                    <text
																		x="127" text-anchor="middle"
																		class="highcharts-subtitle" data-z-index="4"
																		style="color:#666666;fill:#666666;" y="24"></text>
                                                                    <g
																		class="highcharts-legend" data-z-index="7">
                                                                        <rect
																		fill="none" class="highcharts-legend-box" rx="0"
																		ry="0" x="0" y="0" width="8" height="8"
																		visibility="hidden"></rect>
                                                                        <g
																		data-z-index="1">
                                                                            <g></g>
                                                                        </g>
                                                                    </g>
                                                                    <text
																		x="243" class="highcharts-credits" text-anchor="end"
																		data-z-index="8"
																		style="cursor:pointer;color:#999999;font-size:9px;fill:#999999;"
																		y="395">Highcharts.com</text>
                                                                </svg>
															</div>
														</div>

													</div>
												</div>
											</div>
										</div>
										<!--     <div class="col-sm-1 hidden-xs"> <div class="v-border"> </div> </div>-->
										<div class="col-sm-4">
											<!--  <h1>Genre Wise Playout </h1>-->

											<div class="card card-chart">
												<div class="card-header">
													<h4 class="card-title">
														<i class="tim-icons icon-bullet-list-67"></i>By Category
													</h4>
													<h5 class="card-title2">Calculated in last 15 days</h5>
													<!-- <h3 class="card-title"><i class="tim-icons icon-delivery-fast text-info"></i> 3,500</h3> -->
												</div>
												<div class="card-body" id="topCategoryChartBody" style="border-right: 1px #458bc4 solid;height:250px;">
													<div class="chart-area2" style="height: 20px !important;">
													</div>
													<%--     <div class="chart-area">
                                                        <div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
                                                            <div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
                                                                <div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div>
                                                            </div>
                                                            <div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
                                                                <div style="position:absolute;width:200%;height:200%;left:0; top:0"></div>
                                                            </div>
                                                        </div>
                                                        <canvas id="CountryChart" width="253" height="220" class="chartjs-render-monitor" style="display: block; width: 253px; height: 220px;"></canvas>
                                                    </div> --%>
												</div>
											</div>
										</div>
										<!--         <div class="col-sm-1 hidden-xs"> <div class="v-border"> </div> </div>-->
										<div class="col-sm-4">
											<div class="card card-chart">
												<div class="card-header">
													<h4 class="card-title">
														<i class="tim-icons icon-volume-98"></i>By Language
													</h4>
													<h5 class="card-title2">Calculated in last 15 days</h5>
													<!-- <h3 class="card-title"><i class="tim-icons icon-send text-success"></i> 12,100K</h3> -->
												</div>
												<div class="card-body" id="topLanguageChartBody">
													<div class="chart-area">
														<div class="chartjs-size-monitor"
															style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
															<div class="chartjs-size-monitor-expand"
																style="position: absolute; left: 0; top: 0; right: 0; bottom: 0; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
																<div
																	style="position: absolute; width: 1000000px; height: 1000000px; left: 0; top: 0"></div>
															</div>
															<div class="chartjs-size-monitor-shrink"
																style="position: absolute; left: 0; top: 0; right: 0; bottom: 0; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
																<div
																	style="position: absolute; width: 200%; height: 200%; left: 0; top: 0"></div>
															</div>
														</div>
														<canvas id="chartLineGreen" width="254" height="220"
															class="chartjs-render-monitor"
															style="display: block; width: 254px; height: 220px;"></canvas>
													</div>
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
													<h5 class="card-title2">Calculated in last 15 days</h5>
													<!-- <h3 class="card-title"><i class="tim-icons icon-delivery-fast text-info"></i> 3,500</h3> -->
												</div>
												<div class="card-body">
													<div class="chart-area">
														<div class="chartjs-size-monitor"
															style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
															<div class="chartjs-size-monitor-expand"
																style="position: absolute; left: 0; top: 0; right: 0; bottom: 0; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
																<div
																	style="position: absolute; width: 1000000px; height: 1000000px; left: 0; top: 0"></div>
															</div>
															<div class="chartjs-size-monitor-shrink"
																style="position: absolute; left: 0; top: 0; right: 0; bottom: 0; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
																<div
																	style="position: absolute; width: 200%; height: 200%; left: 0; top: 0"></div>
															</div>
														</div>
														<canvas id="dailyPlayoutLineChart"
															style="border-right: 1px solid rgb(69, 139, 196); display: block; width: 401px; height: 220px;"
															width="401" height="220" class="chartjs-render-monitor"></canvas>
													</div>
												</div>
											</div>
										</div>
										<div class="col-sm-6">
											<!--<h1>Hourly Playouts </h1>-->
											<div class="card card-chart">
												<div class="card-header">
													<h4 class="card-title">
														<i class="tim-icons icon-watch-time"></i>Hourly Playout
													</h4>
													<h5 class="card-title2">Calculated in last 15 days</h5>
													<!-- <h3 class="card-title">
									<i class="tim-icons icon-delivery-fast text-info"></i> 3,500
								</h3> -->
												</div>
												<div class="card-body">
													<div class="chart-area">
														<div class="chartjs-size-monitor"
															style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
															<div class="chartjs-size-monitor-expand"
																style="position: absolute; left: 0; top: 0; right: 0; bottom: 0; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
																<div
																	style="position: absolute; width: 1000000px; height: 1000000px; left: 0; top: 0"></div>
															</div>
															<div class="chartjs-size-monitor-shrink"
																style="position: absolute; left: 0; top: 0; right: 0; bottom: 0; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
																<div
																	style="position: absolute; width: 200%; height: 200%; left: 0; top: 0"></div>
															</div>
														</div>
														<canvas id="hourlyPlayoutLineChart" width="401"
															height="220" class="chartjs-render-monitor"
															style="display: block; width: 401px; height: 220px;"></canvas>
													</div>
												</div>
											</div>
										</div>
										<!-- </div> -->
									</div>
									<div class="col-sm-12">
										<div class=" download-bottom">
											<div class="pull-right hidden-xs">
												<a href="http://13.233.39.58:8080/SYNCMediaReport/#"> <i
													class="fa fa-eye" style="color: #cdcdce;"></i> View
												</a> <a href="http://13.233.39.58:8080/SYNCMediaReport/#"
													style="margin-left: 18px;"> <i
													class="fa fa-cloud-download" style="color: #cdcdce;"></i>
													Download
												</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
		<!-- end .page-contentbar -->
	</div>
	</div>
	<div class="footer">
		<strong>SYNC</strong> - Copyright © 2019
	</div>

	<script>
		var contextpath = "/SYNCMediaReport";
	</script>

</body>
<div id="coFrameDiv" style="height: 0px; display: none;">
	<iframe id="coToolbarFrame"
		src="${context}/resources/allAssets/placeholder.html"
		style="height: 0px; width: 100%; display: none;"></iframe>
</div>

</html>
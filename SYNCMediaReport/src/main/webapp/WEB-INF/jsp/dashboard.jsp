
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href='https://fonts.googleapis.com/css?family=Roboto'
	rel='stylesheet'>
<link rel="apple-touch-icon" sizes="76x76"
	href="${context}/resources/assets/img/apple-icon.png">
<link rel="icon" type="image/png"
	href="${context}/resources/assets/img/favicon.png">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/pattern-fill.js"></script>

<title>Syncmedia - Reports</title>
<!--     Fonts and icons     -->

<link
	href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,600,700,800"
	rel="stylesheet" />
<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css"
	rel="stylesheet">
<!-- Nucleo Icons -->
<link href="${context}/resources/assets/css/nucleo-icons.css"
	rel="stylesheet" />
<!-- CSS Files -->
<link href="${context}/resources/assets/css/black-dashboard.css?v=1.0.0"
	rel="stylesheet" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- CSS Just for demo purpose, don't include it in your project -->
<link href="${context}/resources/assets/demo/demo.css" rel="stylesheet" />
<script src="${context}/resources/js/jquery-2.1.4.min.js"></script>
</head>

<body class="white-content">
	<script src="${context}/resources/assets/demo/demo.js"></script>
	<script src="${context}/resources/assets/demo/productdata.js"></script>
	<script>
		var contextpath = "${context}";
		$(document).ready(function() {
			allgraph();
			//alert(topChannels);
		});
	</script>
	<div class="wrapper">
		<div class="main-panel">
			<!-- Navbar -->
			<nav
				class="navbar navbar-expand-lg navbar-absolute navbar-transparent">
				<div class="container-fluid">
					<div class="navbar-wrapper">
						<div class="navbar-toggle d-inline">
							<button type="button" class="navbar-toggler">
								<span class="navbar-toggler-bar bar1"></span> <span
									class="navbar-toggler-bar bar2"></span> <span
									class="navbar-toggler-bar bar3"></span>
							</button>
						</div>
						<a href="javascript:void(0)"><img class="logo"
							style="width: 150px;"
							src="${context}/resources/assets/img/logo.png" /></a>
					</div>
					<div style="width: 100%; padding-left: 25px;">
						<div class="row">
							<div class="col-12">
								<div class="card card-chart" style="display: -webkit-box;">
									<div class="summary-header">
										<span class="color-ring blue"><i
											class="tim-icons icon-app"></i></span> <span
											style="vertical-align: top; display: inline-block;"> <span>492<br>Products
										</span>
										</span>
									</div>
									<div class="summary-header">
										<span class="color-ring green"><i
											class="tim-icons icon-cart"></i></span> <span
											style="vertical-align: top; display: inline-block;"> <span>356<br>Brands
										</span>
										</span>
									</div>
									<div class="summary-header">
										<span class="color-ring yellow"><i
											class="tim-icons icon-bullet-list-67"></i></span> <span
											style="vertical-align: top; display: inline-block;"> <span>32<br>Categories
										</span>
										</span>
									</div>
									<div class="summary-header">
										<span class="color-ring dark-blue"><i
											class="tim-icons icon-triangle-right-17"></i></span> <span
											style="vertical-align: top; display: inline-block;"> <span>2235:21:24<br>Airtime
										</span>
										</span>
									</div>
									<div class="summary-header">
										<span class="color-ring light-blue"><i
											class="tim-icons icon-video-66"></i></span> <span
											style="vertical-align: top; display: inline-block;"> <span>1236,296<br>Playout
										</span>
										</span>
									</div>
									<div class="summary-header">
										<span class="color-ring light-green"><i
											class="tim-icons icon-coins"></i></span> <span
											style="vertical-align: top; display: inline-block;"> <span>6986
												Cr<br>Spend
										</span>
										</span>
									</div>
									<div class="summary-header">
										<span class="color-ring light-purple"><i
											class="tim-icons icon-bulb-63"></i></span> <span
											style="vertical-align: top; display: inline-block;"> <span>1254<br>Ads
										</span>
										</span>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="collapse navbar-collapse" id="navigation"
						style="width: 11%; margin-left: -25px;">
						<ul class="navbar-nav ml-auto">
							<li class="search-bar input-group">
								<button class="btn btn-link" id="search-button"
									data-toggle="modal" data-target="#searchModal">
									<i class="tim-icons icon-zoom-split"></i> <span
										class="d-lg-none d-md-block">Search</span>
								</button>
							</li>
							<li class="dropdown nav-item"><a href="#"
								class="dropdown-toggle nav-link" data-toggle="dropdown">
									<div class="photo">
										<img src="${context}/resources/assets/img/anime3.png"
											alt="Profile Photo">
									</div> <b class="caret d-none d-lg-block d-xl-block"></b>
									<p class="d-lg-none">Log out</p>
							</a>
								<ul class="dropdown-menu dropdown-navbar">
									<li class="nav-link"><a href="javascript:void(0)"
										class="nav-item dropdown-item">Profile</a></li>
									<li class="nav-link"><a href="javascript:void(0)"
										class="nav-item dropdown-item">Settings</a></li>
									<li class="dropdown-divider"></li>
									<li class="nav-link"><a href="javascript:void(0)"
										class="nav-item dropdown-item">Log out</a></li>
								</ul></li>
							<li class="separator d-lg-none"></li>
						</ul>
					</div>
				</div>
			</nav>
			<div class="modal modal-search fade" id="searchModal" tabindex="-1"
				role="dialog" aria-labelledby="searchModal" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<input type="text" class="form-control" id="inlineFormInputGroup"
								placeholder="SEARCH">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<i class="tim-icons icon-simple-remove"></i>
							</button>
						</div>
					</div>
				</div>
			</div>
			<!-- End Navbar -->
			<!-- <div class="content" style="padding: 105px 30px 30px 30px;">
				<select class="form-control distanse" id="date_range"
					style="display: none;" onchange="allgraph()">
					<option value="0">Today</option>
					<option value="7">Weekly</option>
					<option value="15" selected>15 Days</option>
					<option value="30">Monthly</option>
				</select> <input type="text" class="form-control" style="display: none;"
					onkeyup="allgraph();" id="limit" placeholder="TOP IN"> -->
				<div class="row">
					<div class="col-12">
						<div class="card card-chart">


							<div class="card-header ">
								<div class="row">
								<div class="col-sm-3">
								<h3>Product Dashboard</h3>
								</div>
									<div class="col-sm-8 float-right">
										<span class="col-sm-3">
											<div class="btn-group btn-group-toggle" data-toggle="buttons">
												<select class="form-control distanse" id="date_range"
													onchange="allgraph()">
													<option value="0">Today</option>
													<option value="7">Weekly</option>
													<option value="15" selected>15 Days</option>
													<option value="30">Monthly</option>
												</select>
											</div>
										</span> 
										<span class="col-sm-3">
											<div class="btn-group btn-group-toggle" data-toggle="buttons">
												<select class="form-control distanse" id="genre"
													onchange="allgraph()">
													<option value="">Select Genre</option>
													<c:forEach items="${genres}" var="genre">
														<option value="'${genre.genre}'">${genre.genre}</option>
													</c:forEach>
												</select>
											</div>
										</span> <span class="col-sm-3">
											<div class="btn-group btn-group-toggle" data-toggle="buttons">
												<select class="form-control distanse" id="channel"
													onchange="allgraph()">
													<option value="">Select Channel</option>
													<c:forEach items="${channels}" var="channel">
														<option value="'${channel.streamid}'">
															${channel.streamname}</option>
													</c:forEach>
												</select>
											</div>
										</span>
										<!-- <span class="col-sm-3">
											<div class="btn-group btn-group-toggle"
												data-toggle="buttons">
												<input type="text" class="form-control"
													onkeyup="allgraph();" id="limit" placeholder="TOP IN">
											</div>

										</span> -->
									</div>

									<div class="col-sm-1">

										<div class="btn-group btn-group-toggle float-right"
											data-toggle="buttons">
											<label onclick="allgraph();"
												class="btn btn-sm btn-primary btn-simple active" id="0">
												<input type="radio" name="options" value="Playout" checked>
												<span
												class="d-none d-sm-block d-md-block d-lg-block d-xl-block">Playout</span>
												<span class="d-block d-sm-none"> <i
													class="tim-icons icon-single-02"></i>
											</span>
											</label> <label onclick="allgraph();"
												class="btn btn-sm btn-primary btn-simple" id="2"> <input
												type="radio" value="Airtime" class="d-none" name="options">
												<span
												class="d-none d-sm-block d-md-block d-lg-block d-xl-block">Airtime</span>
												<span class="d-block d-sm-none"> <i
													class="tim-icons icon-tap-02"></i>
											</span>
											</label>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="firstRow">
					<div class="row">
						<div class="col-lg-3">
							<div class="card card-chart">
								<div class="card-header">
									<h4 class="card-title">
										<i class="tim-icons icon-app"></i>Top Products
									</h4>
									<h5 class="card-title">Calculated in last 15 days</h5>
								</div>
								<div class="card-body" id="topProductChartBody">
									<div class="chart-area" style="overflow-y: auto;">
										<table class="table tablesorter" id="productdata">
											<tbody>

											</tbody>
										</table>
										<%-- <canvas id="chartLinePurple"></canvas> --%>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="card card-chart">
								<div class="card-header">
									<h4 class="card-title">
										<i class="tim-icons icon-tv-2"></i>Top Channels
									</h4>
									<h5 class="card-title">Calculated in last 15 days</h5>
									<!-- <h3 class="card-title"><i class="tim-icons icon-bell-55 text-primary"></i> 763,215</h3> -->
								</div>
								<div class="card-body" id="topChannelChartBody">
									<div class="chart-area" id="piegraph"
										style="overflow: visible;">
										<canvas id="chartLinePurple"></canvas>

									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="card card-chart">
								<div class="card-header">
									<h4 class="card-title">
										<i class="tim-icons icon-bullet-list-67"></i>By Category
									</h4>
									<h5 class="card-title">Calculated in last 15 days</h5>
									<!-- <h3 class="card-title"><i class="tim-icons icon-delivery-fast text-info"></i> 3,500</h3> -->
								</div>
								<div class="card-body" id="topCategoryChartBody">
									<div class="chart-area">
										<canvas id="CountryChart"></canvas>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="card card-chart">
								<div class="card-header">
									<h4 class="card-title">
										<i class="tim-icons icon-volume-98"></i>By Language
									</h4>
									<h5 class="card-title">Calculated in last 15 days</h5>
									<!-- <h3 class="card-title"><i class="tim-icons icon-send text-success"></i> 12,100K</h3> -->
								</div>
								<div class="card-body" id="topLanguageChartBody">
									<div class="chart-area">
										<canvas id="chartLineGreen"></canvas>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6">
						<div class="card card-chart">
							<div class="card-header">
								<h4 class="card-title">
									<i class="tim-icons icon-calendar-60"></i>Daily Playout
								</h4>
								<h5 class="card-title">Calculated in last 15 days</h5>
								<!-- <h3 class="card-title"><i class="tim-icons icon-delivery-fast text-info"></i> 3,500</h3> -->
							</div>
							<div class="card-body">
								<div class="chart-area">
									<canvas id="dailyPlayoutLineChart"></canvas>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="card card-chart">
							<div class="card-header">
								<h4 class="card-title">
									<i class="tim-icons icon-watch-time"></i>Hourly Playout
								</h4>
								<h5 class="card-title">Calculated in last 15 days</h5>
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
					<!-- <div class="col-lg-4">
						<div class="card card-chart">
							<div class="card-header">
								<h5 class="card-category">Completed Tasks</h5>
								<h3 class="card-title">
									<i class="tim-icons icon-send text-success"></i> 12,100K
								</h3>
							</div>
							<div class="card-body">
								<div class="chart-area">
									<canvas id="chartLineGreen"></canvas>
								</div>
							</div>
						</div>
					</div> -->
				</div>
				<!-- <div class="row">
					<div class="col-lg-6 col-md-12">
						<div class="card card-tasks">
							<div class="card-header ">
								<h4 class="card-title">Simple Table</h4>

							</div>
							<div class="card-body ">
								<div class="table-full-width table-responsive">
									<table class="table">


										<div id="highcharts-0209bc48-88b3-4042-94b1-8faa972e9875"></div>
										



									</table>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-6 col-md-12">
						<div class="card ">
							<div class="card-header">
								<h4 class="card-title">Simple Table</h4>
							</div>
							<div class="card-body">
								<div class="table-responsive">
									<table class="table tablesorter " id="">
										<thead class=" text-primary">
											<tr>
												<th>Name</th>
												<th>Country</th>
												<th>City</th>
												<th class="text-center">Salary</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>Dakota Rice</td>
												<td>Niger</td>
												<td>Oud-Turnhout</td>
												<td class="text-center">$36,738</td>
											</tr>
											<tr>
												<td>Minerva Hooper</td>
												<td>Curaçao</td>
												<td>Sinaai-Waas</td>
												<td class="text-center">$23,789</td>
											</tr>
											<tr>
												<td>Sage Rodriguez</td>
												<td>Netherlands</td>
												<td>Baileux</td>
												<td class="text-center">$56,142</td>
											</tr>
											<tr>
												<td>Philip Chaney</td>
												<td>Korea, South</td>
												<td>Overland Park</td>
												<td class="text-center">$38,735</td>
											</tr>
											<tr>
												<td>Doris Greene</td>
												<td>Malawi</td>
												<td>Feldkirchen in Kärnten</td>
												<td class="text-center">$63,542</td>
											</tr>
											<tr>
												<td>Mason Porter</td>
												<td>Chile</td>
												<td>Gloucester</td>
												<td class="text-center">$78,615</td>
											</tr>
											<tr>
												<td>Jon Porter</td>
												<td>Portugal</td>
												<td>Gloucester</td>
												<td class="text-center">$98,615</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div> -->
			</div>
			<!--  <footer class="footer">
        <div class="container-fluid">
          <ul class="nav">
            
          </ul>
          <div class="copyright">
            ©
            <script>
              document.write(new Date().getFullYear())
            </script><i class="tim-icons icon-heart-2"></i>
            
          </div>
        </div>
      </footer> -->
		</div>
	</div>
	<div class="fixed-plugin">
		<div class="dropdown show-dropdown">
			<a href="#" data-toggle="dropdown"> <i class="fa fa-cog fa-2x">
			</i>
			</a>
			<ul class="dropdown-menu">
				<!-- <li class="header-title">Sidebar Background</li>
				<li class="adjustments-line"><a href="javascript:void(0)"
					class="switch-trigger background-color">
						<div class="badge-colors text-center">
							<span class="badge filter badge-primary active"
								data-color="primary"></span> <span
								class="badge filter badge-info" data-color="blue"></span> <span
								class="badge filter badge-success" data-color="green"></span>
						</div>
						<div class="clearfix"></div>
				</a></li> -->
				<li class="adjustments-line text-right color-change">
					<div>
						<span class="color-label">LIGHT MODE</span> <span
							class="badge light-badge ml-2"></span>
					</div>
					<div>
						<span class="color-label">DARK MODE</span> <span
							class="badge dark-badge ml-2"></span>
					</div>
					<div>
						<span class="color-label">ALL SPARK THEME</span> <span
							class="badge allSpark-badge ml-2"></span>
					</div>
				</li>


			</ul>
		</div>
	</div>
	<!--    Core JS Files   -->

	<script src="${context}/resources/assets/js/core/popper.min.js"></script>
	<script src="${context}/resources/assets/js/core/bootstrap.min.js"></script>
	<script
		src="${context}/resources/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
	<script src="${context}/resources/assets/demo/productdata.js"></script>
	<!--  Google Maps Plugin    -->
	<!-- Place this tag in your head or just before your close body tag. -->
	<!-- <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script> -->
	<!-- Chart JS -->
	<script src="${context}/resources/assets/js/plugins/chartjs.min.js"></script>
	<!--  Notifications Plugin    -->
	<script
		src="${context}/resources/assets/js/plugins/bootstrap-notify.js"></script>
	<!-- Control Center for Black Dashboard: parallax effects, scripts for the example pages etc -->
	<script
		src="${context}/resources/assets/js/black-dashboard.min.js?v=1.0.0"></script>
	<!-- Black Dashboard DEMO methods, don't include it in your project! -->

	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="${context}/resources/assets/js/black-dashboard.js"></script>



	<script>
		$(document)
				.ready(
						function() {
							$()
									.ready(
											function() {
												$sidebar = $('.sidebar');
												$navbar = $('.navbar');
												$main_panel = $('.main-panel');

												$full_page = $('.full-page');

												$sidebar_responsive = $('body > .navbar-collapse');
												sidebar_mini_active = true;
												white_color = false;

												window_width = $(window)
														.width();

												fixed_plugin_open = $(
														'.sidebar .sidebar-wrapper .nav li.active a p')
														.html();

												$('.fixed-plugin a')
														.click(
																function(event) {
																	if ($(this)
																			.hasClass(
																					'switch-trigger')) {
																		if (event.stopPropagation) {
																			event
																					.stopPropagation();
																		} else if (window.event) {
																			window.event.cancelBubble = true;
																		}
																	}
																});

												$(
														'.fixed-plugin .background-color span')
														.click(
																function() {
																	$(this)
																			.siblings()
																			.removeClass(
																					'active');
																	$(this)
																			.addClass(
																					'active');

																	var new_color = $(
																			this)
																			.data(
																					'color');

																	if ($sidebar.length != 0) {
																		$sidebar
																				.attr(
																						'data',
																						new_color);
																	}

																	if ($main_panel.length != 0) {
																		$main_panel
																				.attr(
																						'data',
																						new_color);
																	}

																	if ($full_page.length != 0) {
																		$full_page
																				.attr(
																						'filter-color',
																						new_color);
																	}

																	if ($sidebar_responsive.length != 0) {
																		$sidebar_responsive
																				.attr(
																						'data',
																						new_color);
																	}
																});

												$('.switch-sidebar-mini input')
														.on(
																"switchChange.bootstrapSwitch",
																function() {
																	var $btn = $(this);

																	if (sidebar_mini_active == true) {
																		$(
																				'body')
																				.removeClass(
																						'sidebar-mini');
																		sidebar_mini_active = false;
																		blackDashboard
																				.showSidebarMessage('Sidebar mini deactivated...');
																	} else {
																		$(
																				'body')
																				.addClass(
																						'sidebar-mini');
																		sidebar_mini_active = true;
																		blackDashboard
																				.showSidebarMessage('Sidebar mini activated...');
																	}

																	// we simulate the window Resize so the charts will get updated in realtime.
																	var simulateWindowResize = setInterval(
																			function() {
																				window
																						.dispatchEvent(new Event(
																								'resize'));
																			},
																			180);

																	// we stop the simulation of Window Resize after the animations are completed
																	setTimeout(
																			function() {
																				clearInterval(simulateWindowResize);
																			},
																			1000);
																});

												$('.switch-change-color input')
														.on(
																"switchChange.bootstrapSwitch",
																function() {
																	var $btn = $(this);

																	if (white_color == true) {

																		$(
																				'body')
																				.addClass(
																						'change-background');
																		setTimeout(
																				function() {
																					$(
																							'body')
																							.removeClass(
																									'change-background');
																					$(
																							'body')
																							.removeClass(
																									'white-content');
																				},
																				900);
																		white_color = false;
																	} else {

																		$(
																				'body')
																				.addClass(
																						'change-background');
																		setTimeout(
																				function() {
																					$(
																							'body')
																							.removeClass(
																									'change-background');
																					$(
																							'body')
																							.addClass(
																									'white-content');
																				},
																				900);

																		white_color = true;
																	}

																});

												$('.light-badge')
														.click(
																function() {
																	$('body')
																			.removeClass(
																					'allSpark-content');
																	$('body')
																			.addClass(
																					'white-content');
																});

												$('.allSpark-badge')
														.click(
																function() {
																	$('body')
																			.removeClass(
																					'white-content');
																	$('body')
																			.addClass(
																					'allSpark-content');
																});

												$('.dark-badge')
														.click(
																function() {
																	$('body')
																			.removeClass(
																					'white-content');
																	$('body')
																			.removeClass(
																					'allSpark-content');
																});
											});
						});
	</script>
	<!-- <script>
		$(document).ready(function() {
			// Javascript method's body can be found in assets/js/demos.js
			demo.initDashboardPageCharts();

		});
	</script> -->
</body>

</html>




































<script>

 function tabledata(){ 
	 $('#channelTable').dataTable().fnDestroy();
	 var fromdate = $("#startDateSelected").val();
    		var todate = $("#endDateSelected").val(); 
    		
    
    $('#channelTable').DataTable(
    		{

				'ajax' : {
					'url' : '${context}/exportData/'+fromdate+'/'+todate,
							
							
					'type' : 'POST',
					'beforeSend' : function(
							request) {
						$
								.blockUI({
									message : $('<img src="./resources/images/loader.gif" />')
								});
						$(
								".blockPage")
								.css(
										{
											'background-color' : '',
											'border' : ''
										});
						request
								.setRequestHeader(
										"dataType",
										'json');
						request
								.setRequestHeader(
										"contentType",
										'json');
					},
					'complete' : function(request) {
						$.unblockUI();
			
						$('#myModal').modal();
	
					}

				},
				"sScrollX": true,
				"sScrollY": "275px",
				"bSearchable" : true,

			 "columns" : [
				{
					"data" : "streamName"
				},
				{
					"data" : "timestamp_utc"
				},
				
				{
					"data" : "Product"
				},
				
				{
					"data" : "Brand"
				},
				{
					"data" : "Categories"
				},
				
				{
					"data" : "language1"
				},
				{
					"data" : "played_duration"
				},
				{
					"data" : "duration_ms"
				},
				
				{
					"data" : "master_type"
				}
				],
			
				"columnDefs" : [ {
					"defaultContent" : "",
					"targets" : "_all"
					
				} ] 
		});
     setTimeout( function(){
	$('#channelTable').DataTable().search( '' ).draw();
     }, 6000 ); 
     channelFilter();
     productDefaultFilter();
     brandDefaultFilter();
     genreDefaultFilter();
     languageDefaultFilter();
}
    		function brandFilter(){
    			var formData = new FormData();
    			var fromdate = $("#datefilterid").val();
    			var todate = $("#ed").val();
    		
    			 var defaultfromdate = $("#startDateSelected").val();
  	    		var defaulttodate = $("#endDateSelected").val();
  	    		
  	    	if(fromdate=="" & todate=="")
  	    		{
  	    		fromdate=defaultfromdate;
  	    		todate=defaulttodate;
  	    		}
  	    	else{
  	    	}
    			var brand =encodeURIComponent(document.getElementById('brandfilter').value);
    			var channel =encodeURIComponent(document.getElementById('channelfilter').value);
    			$.ajax({
    		    	url: '${context}/categoryFilter/'+fromdate+'/'+todate+'/'+"?brand="+brand+'&channel='+channel,
    		        processData : false,
    		        contentType : false,
    		        type : 'GET',
    		        success : function(data) {
		        		 	$('#categoryfilter').empty();
		        		 	$('<option>').val("").text("Select category").appendTo('#categoryfilter');
		            	for (i = 0; i < data.length; i++){
		        			$('<option>').val(data[i].Categories).text(data[i].Categories).appendTo('#categoryfilter');
		        			} 
    		        },
    		        error : function() {
    		        	alert("error");
    		        }
    		    });	
    		}


    		function channelFilter()
    		{
    			
    			var formData = new FormData();
    			var fromdate = $("#datefilterid").val();
    			var todate = $("#ed").val();
    		
    			
    			 var defaultfromdate = $("#startDateSelected").val();
  	    		var defaulttodate = $("#endDateSelected").val();
  	    		
  	    	if(fromdate=="" & todate=="")
  	    		{
  	    		fromdate=defaultfromdate;
  	    		todate=defaulttodate;
  	    		}
  	    	else{
  	    	}
    			$.ajax({
    		    	url: '${context}/fetchannel/'+fromdate+'/'+todate,
    		        processData : false,
    		        contentType : false,
    		        type : 'GET',
    		        success : function(data) {
    		        	$('#channelfilter').empty();
    		        		 	$('<option>').val("").text("Select Channels").appendTo('#channelfilter');
    		            	for (i = 0; i < data.length; i++){
    		        			$('<option>').val(data[i].streamName).text(data[i].streamName).appendTo('#channelfilter');
    		        			} 
    		        },
    		        error : function() {
    		        	alert("error");
    		        }
    		    });	
    			
    			}
    			
    			
    		function categoryfilterData()
    		{

    			var formData = new FormData();
    			var fromdate = $("#datefilterid").val();
    			var todate = $("#ed").val();
    			 var defaultfromdate = $("#startDateSelected").val();
 	    		var defaulttodate = $("#endDateSelected").val();
 	    		
 	    	if(fromdate=="" & todate=="")
 	    		{
 	    		fromdate=defaultfromdate;
 	    		todate=defaulttodate;
 	    		}
 	    	else{
 	    	}
 	    		
    			
    			var brand =encodeURIComponent(document.getElementById('brandfilter').value);
    			var channel =encodeURIComponent(document.getElementById('channelfilter').value);
    			var category =encodeURIComponent(document.getElementById('categoryfilter').value);
    			$.ajax({
    		    	url: '${context}/productfilter/'+fromdate+'/'+todate+'/'+'?channel='+channel+'&brand='+brand+'&category='+category,
    		        processData : false,
    		        contentType : false,
    		        type : 'GET',
    		        success : function(data) {
    		        		$('#productfilter').empty();
    		        		$('<option>').val("").text("Select Product").appendTo('#productfilter');
    		            	for (i = 0; i < data.length; i++){
    		        			$('<option>').val(data[i].Product).text(data[i].Product).appendTo('#productfilter');
    		        			} 
    		        	
    		        },
    		        error : function() {
    		        	alert("error");
    		        }
    		    });	
    			
    			}
    			
    		function productFilterData()
    		{
    			
    			var formData = new FormData();
    			var fromdate = $("#datefilterid").val();
    			var todate = $("#ed").val();
    			
    			 var defaultfromdate = $("#startDateSelected").val();
    	    		var defaulttodate = $("#endDateSelected").val();
    	    		
    	    	if(fromdate=="" & todate=="")
    	    		{
    	    		fromdate=defaultfromdate;
    	    		todate=defaulttodate;
    	    		
    	    		}
    	    	else{
    	    	}
    	    		
    	    		
    			var brand =encodeURIComponent(document.getElementById('brandfilter').value);
    			var channel =encodeURIComponent(document.getElementById('channelfilter').value);
    			var category =encodeURIComponent(document.getElementById('categoryfilter').value);
    			var product =encodeURIComponent(document.getElementById('productfilter').value);
    			
    			$.ajax({
    				url: '${context}/languageGenre/'+fromdate+'/'+todate+'/'+'?channel='+channel+'&brand='+brand+'&category='+category+'&product='+product,
    		        processData : false,
    		        contentType : false,
    		        type : 'GET',
    		        success : function(data) {
    		        		 	$('#languagefilter').empty();
    		        		 	$('<option>').val("").text("Select Language").appendTo('#languagefilter');
    		            	for (i = 0; i < data.length; i++){
    		        			$('<option>').val(data[i].language1).text(data[i].language1).appendTo('#languagefilter');
    		        			}
    		            	
    		        },
    		        error : function() {
    		        	alert("error");
    		        }
    		    });	
    			
    			}

    		function languageFilterData()
    		{
    			
    			var formData = new FormData();
    			var fromdate = $("#datefilterid").val();
    			var todate = $("#ed").val();
    			
    			 var defaultfromdate = $("#startDateSelected").val();
    	    		var defaulttodate = $("#endDateSelected").val();
    	    		
    	    	if(fromdate=="" & todate=="")
    	    		{
    	    		fromdate=defaultfromdate;
    	    		todate=defaulttodate;
    	    		
    	    		}
    	    	else{
    	    	}
    	    		
    	    		
    			var brand =encodeURIComponent(document.getElementById('brandfilter').value);
    			var channel =encodeURIComponent(document.getElementById('channelfilter').value);
    			var category =encodeURIComponent(document.getElementById('categoryfilter').value);
    			var product =encodeURIComponent(document.getElementById('productfilter').value);
    			$.ajax({
    				url: '${context}/GenreFiltre/'+fromdate+'/'+todate+'/'+'?channel='+channel+'&brand='+brand+'&category='+category+'&product='+product,
    		        processData : false,
    		        contentType : false,
    		        type : 'GET',
    		        success : function(data) {
    		        	
    		            	
    		            	 $('#genrefilter').empty();
		        		 	$('<option>').val("").text("Select Genre").appendTo('#genrefilter');
		            	for (i = 0; i < data.length; i++){
		        			$('<option>').val(data[i].master_type).text(data[i].master_type).appendTo('#genrefilter');
		        			} 
    		        	
    		        },
    		        error : function() {
    		        	alert("error");
    		        }
    		    });	
    			
    			}
    		
</script>



<script>

function  exportDataFile()
	{
	var  exportData=$("#exportData").val();
	var fromdate = $("#datefilterid").val();
	var todate = $("#ed").val();
	alert("export option value."+exportData);
	
	 var defaultfromdate = $("#startDateSelected").val();
		var defaulttodate = $("#endDateSelected").val();
		
	if(fromdate=="" & todate=="")
		{
		fromdate=defaultfromdate;
		todate=defaulttodate;
		
		}
	else{
	}
	
	var brand =encodeURIComponent(document.getElementById('brandfilter').value);
	var channel =encodeURIComponent(document.getElementById('channelfilter').value);
	var category =encodeURIComponent(document.getElementById('categoryfilter').value);
	var product =encodeURIComponent(document.getElementById('productfilter').value);
	var language =encodeURIComponent(document.getElementById('languagefilter').value);
	var genre =encodeURIComponent(document.getElementById('genrefilter').value);
	
	window.location.href = '${context}/allDataExport2/'+fromdate+'/'+todate+'/'+'?channel='+channel+'&product='+product+'&category='+category+'&brand='+brand+'&language='+language+'&genre='+genre+'&exportData='+exportData;
	}


</script>

 <script>
 
 function convertSVG(){
	 var nodesToRecover = [];
	    var nodesToRemove = [];

			var svgElem		= $("#completeData").find('svg');
	    svgElem.each(function(index, node) {
	        var parentNode = node.parentNode;
	        var svg = parentNode.innerHTML;

	        var canvasElement = document.createElement('canvas');

	        canvg(canvasElement, svg);

	        nodesToRecover.push({
	            parent: parentNode,
	            child: node
	        });
	        parentNode.removeChild(node);

	        nodesToRemove.push({
	            parent: parentNode,
	            child: canvasElement
	        });

	        parentNode.appendChild(canvasElement);
         
});
 }

 
 function screenShot()
 {
	 var element = $("#completeData"); // global variable

	 var getCanvas;
	 //alert("insert preivee function");         
 		convertSVG();
 	
 	
 	html2canvas(element, {
      onrendered: function (canvas) {
			$("#showpriview").append(canvas);
             getCanvas = canvas;
          
             
             var imgageData = getCanvas.toDataURL("image/png");
             // Now browser starts downloading it instead of just showing it
             var newData = imgageData.replace(/^data:image\/png/, "data:application/octet-stream");
             $("#priviewData").attr("download", "ChannelData.png").attr("href", newData);
          }
     }); 
	 
 
 }
 



</script>


<script>
function channelChangeFilter()
{
	var channel = encodeURIComponent(document.getElementById('channelfilter').value);
	var category = encodeURIComponent(document.getElementById('categoryfilter').value);
	var formData = new FormData();
	
	var fromdate = $("#datefilterid").val();
	var todate = $("#ed").val();

	
	 var defaultfromdate = $("#startDateSelected").val();
		var defaulttodate = $("#endDateSelected").val();
		
	if(fromdate=="" & todate=="")
		{
		fromdate=defaultfromdate;
		todate=defaulttodate;
		
		}
	else
	    {
	    }
	
	$.ajax({
    	url: '${context}/channelChangeFilter/'+fromdate+'/'+todate+'/'+'?channel='+channel,
        processData : false,
        contentType : false,
        type : 'GET',
        success : function(data) {
        	
        	$('#brandfilter').empty();
        	$('<option>').val("").text("Select Brand").appendTo('#brandfilter');
        	for (i = 0; i <data.length; i++){
    			$('<option>').val(data[i].Brand).text(data[i].Brand).appendTo('#brandfilter');
    			}
        },
        error : function() {
        	alert("error");
        }
    });
	
}

</script>




<script type="text/javascript">
$(function() {
	//var d = new Date().toLocaleString();
	var now = new Date();
	var d = moment(now).format('YYYY-MM-DD');
	$('#startDate').datetimepicker({
		format : 'YYYY-MM-DD'
	});
	$('#endDate').datetimepicker({
		format : 'YYYY-MM-DD',
		useCurrent : false
	});
	
	
	
	$(".glyphicon-calendar").click(function(){
		$(".bootstrap-datetimepicker-widget").css("background-color", "#3c3e43");
	});
	
	$("#startDate").on("dp.change", function(e) {
		$('#endDate').data("DateTimePicker").maxDate(d);
		$('#startDate').data("DateTimePicker").maxDate(d);
		$(this).data('DateTimePicker').hide();
		
		var startdate = document.getElementById('datefilterid').value;
		var endDate = document.getElementById('ed').value;
		if(startdate!="" & endDate!="")
			{
			endDateFilter(endDate,startdate);
			endDateBrandFilter(endDate,startdate);
			endDateCategoryFilter(endDate,startdate);
			endDateProductFilter(endDate,startdate);
			endDateLanguageFilter(endDate,startdate);
			endDateGenreFilter(endDate,startdate);
			}
		else{
		}
		
		document.getElementById('selectBoxForm').reset();	
		//
		
	});
	$("#endDate").on("dp.change", function(e) {
		$('#startDate').data("DateTimePicker").maxDate(e.date);
		$('#endDate').data("DateTimePicker").maxDate(d);
		$(".bootstrap-datetimepicker-widget").css("background-color", "#333");
		$(this).data('DateTimePicker').hide();
		var endDate = document.getElementById('ed').value;
		var startdate = document.getElementById('datefilterid').value;
		document.getElementById('selectBoxForm').reset();
		endDateFilter(endDate,startdate);
		endDateBrandFilter(endDate,startdate);
		endDateCategoryFilter(endDate,startdate); 
		endDateProductFilter(endDate,startdate);
		endDateLanguageFilter(endDate,startdate);
		endDateGenreFilter(endDate,startdate);
	});
	
	
});
</script>

<script type="text/javascript">
function showChannels(){
	
	var fromdate = $("#datefilterid").val();
	var todate = $("#ed").val();
	
	 var defaultfromdate = $("#startDateSelected").val();
		var defaulttodate = $("#endDateSelected").val();
		
	if(fromdate=="" & todate=="")
		{
		fromdate=defaultfromdate;
		todate=defaulttodate;
		
		}
	else
	    {
	    }
	
	var channels = encodeURIComponent(document.getElementById('channelfilter').value);
	var brand = encodeURIComponent(document.getElementById('brandfilter').value);
	var category = encodeURIComponent(document.getElementById('categoryfilter').value);
	var product =encodeURIComponent(document.getElementById('productfilter').value);
	var language = encodeURIComponent(document.getElementById('languagefilter').value);
	var genre =encodeURIComponent(document.getElementById('genrefilter').value);


    
 	$('#channelTable').DataTable(
    		{
    			'destroy':true,

				'ajax' : {
					'url' : '${context}/exportchannels/'+fromdate+'/'+todate+'/'+'?channels='+channels
							+'&brand='+brand+'&category='+category+'&product='+product+'&language='+language+'&genre='+genre,
					//'url' : '${context}/exportData/'+fromdate+'/'+todate,
					'type' : 'GET',
					'beforeSend' : function(
							request) {
						$
								.blockUI({
									message : $('<img src="./resources/images/loader.gif" />')
								});
						$(
								".blockPage")
								.css(
										{
											'background-color' : '',
											'border' : ''
										});
						request
								.setRequestHeader(
										"dataType",
										'json');
						request
								.setRequestHeader(
										"contentType",
										'json');
					},
					'complete' : function(request) {
						$.unblockUI();
			
						$('#myModal').modal();
	
					}

				},
				"sScrollY": "275px",
				"bSearchable" : true,
				
			
			 "columns" : [
				{
					"data" : "streamName"
				},
				{
					"data" : "timestamp_utc"
				},
				
				{
					"data" : "Product"
				},
				
				{
					"data" : "Brand"
				},
				{
					"data" : "Categories"
				},
				
				{
					"data" : "language1"
				},
				{
					"data" : "played_duration"
				},
				{
					"data" : "duration_ms"
				},
				
				{
					"data" : "master_type"
				}
				],
			
				"columnDefs" : [ {
					"defaultContent" : "",
					"targets" : "_all"
					
				} ] 
		});
 }


	
 

 </script>
 <script>
 function startDateFilter(startdate)
 {
		
	 $.ajax({
	    	url: '${context}/startDateFilter/'+startdate,
	        processData : false,
	        contentType : false,
	        type : 'GET',
	        success : function(data) {
	        	
	        $('#channelfilter').empty();
			$('<option>').val("").text("Select Channel").appendTo('#channelfilter');
	    	for (i = 0; i < data.length; i++){
				$('<option>').val(data[i].streamName).text(data[i].streamName).appendTo('#channelfilter');
				}
	        },
	        error : function() {
	        	alert("error");
	        }
	    });
}
 function endDateFilter(endDate,startdate) 
 {
    
	 $.ajax({
	    	url: '${context}/endDateFilter/'+endDate+'/'+startdate,
	        processData : false,
	        contentType : false,
	        type : 'GET',
	        success : function(data) {
	        	
	        $('#channelfilter').empty();
			$('<option>').val("").text("Select Channel").appendTo('#channelfilter');
	    	for (i = 0; i < data.length; i++){
				$('<option>').val(data[i].streamName).text(data[i].streamName).appendTo('#channelfilter');
				}
	        },
	        error : function() {
	        	alert("error");
	        }
	    });
 }

 
 function endDateBrandFilter(endDate,startdate) 
 {
    
	 $.ajax({
	    	url: '${context}/endDateBrandFilter/'+endDate+'/'+startdate,
	        processData : false,
	        contentType : false,
	        type : 'GET',
	        success : function(data) {
	        	
	        $('#brandfilter').empty();
			$('<option>').val("").text("Select Brand").appendTo('#brandfilter');
	    	for (i = 0; i < data.length; i++){
				$('<option>').val(data[i].Brand).text(data[i].Brand).appendTo('#brandfilter');
				}
	        },
	        error : function() {
	        	alert("error");
	        }
	    });
 }

 
 function endDateCategoryFilter(endDate,startdate) 
 {
    
	 $.ajax({
	    	url: '${context}/endDateCategoryFilter/'+endDate+'/'+startdate,
	        processData : false,
	        contentType : false,
	        type : 'GET',
	        success : function(data) {
	        	
	        $('#categoryfilter').empty();
			$('<option>').val("").text("Select category").appendTo('#categoryfilter');
	    	for (i = 0; i < data.length; i++){
				$('<option>').val(data[i].Categories).text(data[i].Categories).appendTo('#categoryfilter');
				}
	        },
	        error : function() {
	        	alert("error");
	        }
	    });
 }


 function endDateProductFilter(endDate,startdate) 
 {
    
	 $.ajax({
	    	url: '${context}/endDateProductFilter/'+endDate+'/'+startdate,
	        processData : false,
	        contentType : false,
	        type : 'GET',
	        success : function(data) {
	        	
	        $('#productfilter').empty();
			$('<option>').val("").text("Select Product").appendTo('#productfilter');
	    	for (i = 0; i < data.length; i++){
				$('<option>').val(data[i].Product).text(data[i].Product).appendTo('#productfilter');
				}
	        },
	        error : function() {
	        	alert("error");
	        }
	    });
 }
 
 
 function endDateLanguageFilter(endDate,startdate) 
 {
    
	 $.ajax({
	    	url: '${context}/endDateLanguageFilter/'+endDate+'/'+startdate,
	        processData : false,
	        contentType : false,
	        type : 'GET',
	        success : function(data) {
	        	
	        $('#languagefilter').empty();
			$('<option>').val("").text("Select Language").appendTo('#languagefilter');
	    	for (i = 0; i < data.length; i++){
				$('<option>').val(data[i].language1).text(data[i].language1).appendTo('#languagefilter');
				}
	        },
	        error : function() {
	        	alert("error");
	        }
	    });
 }

 function endDateGenreFilter(endDate,startdate) 
 {
    
	 $.ajax({
	    	url: '${context}/endDateGenreFilter/'+endDate+'/'+startdate,
	        processData : false,
	        contentType : false,
	        type : 'GET',
	        success : function(data) {
	        	
	        $('#genrefilter').empty();
			$('<option>').val("").text("Select Genre").appendTo('#genrefilter');
	    	for (i = 0; i < data.length; i++){
				$('<option>').val(data[i].master_type).text(data[i].master_type).appendTo('#genrefilter');
				}
	        },
	        error : function() {
	        	alert("error");
	        }
	    });
 }

 </script>
 <script>
 function closeModal(){
	 
	 document.getElementById('selectBoxForm').reset();
	 document.getElementById('formId').reset();
	 
 
 }
 </script>
 
 <script>
 
	function productDefaultFilter()
	{
		
		var formData = new FormData();
		var fromdate = $("#startDateSelected").val();
		var todate = $("#endDateSelected").val();
		
		$.ajax({
	    	url: '${context}/productDefautlFilter/'+fromdate+'/'+todate,
	        processData : false,
	        contentType : false,
	        type : 'GET',
	        success : function(data) {
	        	
	        	$('#productfilter').empty();
	        		 	$('<option>').val("").text("Select product").appendTo('#productfilter');
	            	for (i = 0; i < data.length; i++){
	        			$('<option>').val(data[i].Product).text(data[i].Product).appendTo('#productfilter');
	        			} 
	        },
	        error : function() {
	        	alert("error");
	        }
	    });	
		
		}

	function brandDefaultFilter()
	{
		
		var formData = new FormData();
		var fromdate = $("#startDateSelected").val();
		var todate = $("#endDateSelected").val();
		
		$.ajax({
	    	url: '${context}/brandDefautlFilter/'+fromdate+'/'+todate,
	        processData : false,
	        contentType : false,
	        type : 'GET',
	        success : function(data) {
	        	
	        	$('#brandfilter').empty();
	        		 	$('<option>').val("").text("Select Brand").appendTo('#brandfilter');
	            	for (i = 0; i < data.length; i++){
	        			$('<option>').val(data[i].Brand).text(data[i].Brand).appendTo('#brandfilter');
	        			} 
	            	
	            	$('#categoryfilter').empty();
        		 	$('<option>').val("").text("Select Category").appendTo('#categoryfilter');
            	for (i = 0; i < data.length; i++){
        			$('<option>').val(data[i].Categories).text(data[i].Categories).appendTo('#categoryfilter');
        			} 
	        
	        },
	        error : function() {
	        	alert("error");
	        }
	    });	
		
		}

	
	function genreDefaultFilter()
	{
		
		var formData = new FormData();
		var fromdate = $("#startDateSelected").val();
		var todate = $("#endDateSelected").val();
		
		$.ajax({
	    	url: '${context}/genreDefautlFilter/'+fromdate+'/'+todate,
	        processData : false,
	        contentType : false,
	        type : 'GET',
	        success : function(data) {
	        	
	        	
        	$('#genrefilter').empty();
		 	$('<option>').val("").text("Select Genre").appendTo('#genrefilter');
    	for (i = 0; i < data.length; i++){
			$('<option>').val(data[i].master_type).text(data[i].master_type).appendTo('#genrefilter');
			} 
    	
	        },
	        error : function() {
	        	alert("error");
	        }
	    });	
		
		}


	function languageDefaultFilter()
	{
		
		var formData = new FormData();
		var fromdate = $("#startDateSelected").val();
		var todate = $("#endDateSelected").val();
		
		$.ajax({
	    	url: '${context}/languageDefautlFilter/'+fromdate+'/'+todate,
	        processData : false,
	        contentType : false,
	        type : 'GET',
	        success : function(data) {
	        	
	        	
            	$('#languagefilter').empty();
    		 	$('<option>').val("").text("Select Language").appendTo('#languagefilter');
        	for (i = 0; i < data.length; i++){
    			$('<option>').val(data[i].language1).text(data[i].language1).appendTo('#languagefilter');
    			}
    	
	        },
	        error : function() {
	        	alert("error");
	        }
	    });	
		
		}
 </script>
<script>
</script>



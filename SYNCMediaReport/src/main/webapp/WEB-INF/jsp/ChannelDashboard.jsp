
<%
	String username = (String) session.getAttribute("username");
	if (username != null) {
%>
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%> --%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="Libraries.jsp"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<script>
    var product=''; 
	var contextpath = "${context}";
    var page='cd';
    var elementType='Channel';
    var cardUrl="./ChannelDashboard";
	genrefilter='<%=request.getParameter("genre")%>';
	channelfilter="<%=request.getParameter("channel")%>";
	languagefilter="<%=request.getParameter("language")%>";
	var cardstatus =<%=request.getParameter("cardstatus")%>;
</script>
<meta charset="utf-8" />
<title>SYNC Dashboard</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<meta content="Coderthemes" name="author" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link href="https://fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet">

<script type="text/javascript">
	$(function() {

		var start = moment().subtract(6, 'days');
		var end = moment();

		function cb(start, end, label) {

			$('#startDateSelected').val(start.format('YYYY-MM-DD'));
			$('#endDateSelected').val(end.format('YYYY-MM-DD'));
			$('#dateselectedlabel').val(label);
			allOnloadChannelGraph(page);
			/* $('#reportrange span')
				.html(
						start
								.format('MMMM D, YYYY')
								+ ' - '
								+ end
										.format('MMMM D, YYYY')); */
		}

		$('#date_range').daterangepicker(
				{
					autoApply : true,
					startDate : start,
					endDate : end,
					ranges : {
						'Today' : [ moment(), moment() ],
						'Yesterday' : [ moment().subtract(1, 'days'),
								moment().subtract(1, 'days') ],
						'Last 7 Days' : [ moment().subtract(6, 'days'),
								moment() ],
						'Last 30 Days' : [ moment().subtract(29, 'days'),
								moment() ],
						'This Month' : [ moment().startOf('month'),
								moment().endOf('month') ],
						'Last Month' : [
								moment().subtract(1, 'month').startOf('month'),
								moment().subtract(1, 'month').endOf('month') ]
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
		channelDataCount();

		$('.ChannelList').slimScroll({
			height : '405px'
		});
		if (cardstatus == '1') {
			document.getElementById("createcard").disabled = true;
		} else {
			document.getElementById("createcard").disabled = false;
		}
		//allOnloadChannelGraph(page);
	});
</script>
<body style="font-family: Roboto, sans-serif !important;"
	id="completeData">

	<div id="page-wrapper">
		<%@ include file="Report.jsp"%>
		<%@ include file="RecentCards.jsp"%>
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
					<img src="${context}/resources/images/channel.png"
						alt="Channel-img" style="float: left; height: 37px; padding: 5px;">
					<h1>Channel Dashboard</h1>
				</div>
				<div class="col-sm-4">
					<div class="Bar-check">
						<ul>
							<li style="">&nbsp;<input
								onclick="allOnloadChannelGraph(page)();" id="time"
								value="Playout" type="radio" checked="checked" name="options">&nbsp;Playout&nbsp;
							</li>

							<li>&nbsp;<input type="radio"
								onclick="allOnloadChannelGraph(page)()" value="Airtime"
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

					<div class="row" style="display: -webkit-box;">

						<div class="col-sm-1">


							<div id="date_range" class="form-control select-first"
								style='color: white; height: 16px !important; border: none;'>
								<!-- <i class="fa fa-calendar"></i> -->
								<span>Date Range</span>&nbsp; <i class="fa fa-caret-down"></i>
							</div>
							<input type="hidden" id="startDateSelected" /> <input
								type="hidden" id="endDateSelected" /> <input type="hidden"
								id="dateselectedlabel" />


							<style>
.bootstrap-datetimepicker-widget {
	background-color: #333;
}

#feedback {
	font-size: 1.4em;
}

/* .selectable .ui-selecting {
	background: #FECA40;
} */
.selectable .ui-selected.channel {
	background: #D68319;
}

.selectable .ui-selected-multi.channel {
	background: #D68319;
}

.selectable .ui-selected.language {
	background: green;
}

.selectable .ui-selected-multi.language {
	background: green;
}

.selectable .ui-selected.genre {
	background: #08c;
}

.selectable .ui-selected-multi.genre {
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
	font-size: 0.9em;
	height: 20px;
	cursor: pointer;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}

.open>.dropdown-menu {
	display: block;
	height: 280px;
	overflow-y: auto;
	width: 175px;
}
</style>
							<div class="form-group">
								<div class="facilities">
									<!-- <select onchange="selectIngredient(this);" multiple="multiple" name='genreName'
									id="genre"> -->
									<div class="dropdown cq-dropdown" data-name='statuses'>
										<div style="color: white; font-size: 11px;"
											class="dropdown-toggle" id="dropdown1" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="true">
											Genre&nbsp; <i class="fa fa-caret-down"></i>
										</div>
										<ul class="dropdown-menu selectable" id="genre"
											aria-labelledby="dropdown1">
											<input type="text" class="search-filter"
												onkeyup="searchFilter($(this))" ref="genre"
												placeholder="Search Genre" />
											<div class="searchList" id="genreList">
												<c:forEach items="${genres}" var="genres">
													<li data-toggle='tooltip' title="${fn:trim(genres)}"
														class="ui-widget-content genre"
														id="option_${fn:replace(fn:trim(genres), ' ', '_')}">${fn:trim(genres)}</li>
												</c:forEach>
											</div>
										</ul>
									</div>
								</div>
							</div>

							<!-- for below Select -- onchange='allOnloadChannelGraph(page);  -->
							<div class="form-group">
								<!-- <select class="form-control select-first" onchange="selectIngredient(this);"
									id="channel"> -->

								<div class="dropdown cq-dropdown" data-name='statuses'>
									<div style="color: white; font-size: 11px;"
										class="dropdown-toggle" id="dropdown1" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="true">
										Channel&nbsp; <i class="fa fa-caret-down"></i>
									</div>
									<ul class="dropdown-menu selectable"
										aria-labelledby="dropdown1" id="channel">
										<input type="text" class="search-filter"
											onkeyup="searchFilter($(this))" ref="channel"
											placeholder="Search Channel" />
										<div class="searchList">
											<c:forEach items="${channels}" var="channels">
												<li data-toggle='tooltip'
													title="${fn:trim(channels.streamname)}"
													class="ui-widget-content channel"
													id="option_${fn:replace(fn:trim(channels.streamname), ' ','_')}">${fn:trim(channels.streamname)}</li>
											</c:forEach>
										</div>
									</ul>
								</div>

							</div>


							<div class="form-group">

								<div class="dropdown cq-dropdown" data-name='statuses'>
									<div style="color: white; font-size: 11px;"
										class="dropdown-toggle" id="dropdown1" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="true">
										Language&nbsp; <i class="fa fa-caret-down"></i>
									</div>
									<ul class="dropdown-menu selectable"
										aria-labelledby="dropdown1" id="language">
										<input type="text" class="search-filter"
											onkeyup="searchFilter($(this))" ref="language"
											placeholder="Search Language" />
										<div class="searchList">
											<c:forEach items="${languages}" var="language">
												<c:choose>
													<c:when test="${fn:contains(language, ' ')}">
														<c:set var="l1"
															value="${fn:replace(fn:trim(language), '&','_')}" />
													</c:when>
													<c:otherwise>
														<c:set var="l1" value="${language}" />
													</c:otherwise>
												</c:choose>
												<li data-toggle='tooltip' title="${fn:trim(language)}"
													class="ui-widget-content language"
													id="option_${fn:replace(fn:trim(l1), ' ','_')}">${fn:trim(language)}</li>
											</c:forEach>
										</div>
									</ul>
								</div>

							</div>


							<input type="hidden" value="10" id="limit" placeholder="limit" />
						</div>
						<div class="col-sm-3">
							<div
								style="height: 6%; margin-bottom: 15px; padding: 6px 0 0 10px; width: 98%; background: rgba(22, 26, 29, 0.55); box-shadow: 16px 16px 20px 2px rgba(12, 2, 2, 0.3);">

								<h4
									style="color: rgb(255, 255, 255, 0.8); font-size: 21px; font-weight: 100 !important;">Top
									Channels</h4>
							</div>
							<div style="height: 405px; overflow-y: auto;" class="ChannelList"></div>
							<br>

							<div
								style="height: 12%; width: 98%; background: rgba(22, 26, 29, 0.7); box-shadow: 16px 16px 20px 2px rgba(12, 2, 2, 0.3);">

								<div style="text-align: center; color: rgb(85, 206, 249);">

									<span id="ChannelCount" style="font-size: 34px;"></span>

								</div>
								<h4
									style="text-align: center; color: rgb(255, 255, 255, 0.8); font-size: 21px;">Channels</h4>

							</div>

							<br>
							<div
								style="height: 12%; width: 98%; background: rgba(22, 26, 29, 0.7); box-shadow: 16px 16px 20px 2px rgba(12, 2, 2, 0.3);">

								<div style="text-align: center; color: rgb(85, 206, 249);">

									<span id="LanguageCount" style="font-size: 34px;"></span>
								</div>
								<h4
									style="text-align: center; color: rgb(255, 255, 255, 0.8); font-size: 21px;">Language</h4>

							</div>

							<br>
							<div
								style="height: 12%; width: 98%; background: rgba(22, 26, 29, 0.7); box-shadow: 16px 16px 20px 2px rgba(12, 2, 2, 0.3);">

								<div style="text-align: center; color: rgb(85, 206, 249);">

									<span id="GenreCount" style="font-size: 34px;"></span>
								</div>
								<h4
									style="text-align: center; color: rgb(255, 255, 255, 0.8); font-size: 21px;">Genre</h4>

							</div>

						</div>
						<div class="col-sm-8">
							<!-- test filter end -->
							<ul class="tag-box ui-sortable" id="filtersBox"
								style="display: none;">
							</ul>
							<div id="tagDiv"
								style="height: 40px; margin-bottom: 15px; padding: 10px 0 0 10px; width: 98%; background: rgba(22, 26, 29, 0.55); box-shadow: 16px 16px 20px 2px rgba(12, 2, 2, 0.3); display: none;">
							</div>
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
													<h5 class="card-title2" id="titledata">Calculated for
														last 7 days</h5>
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
														<i class="tim-icons icon-bullet-list-67"></i>By Genre
													</h4>
													<h5 class="card-title2" id="titledata">Calculated for
														last 7 days</h5>
													<!-- <h3 class="card-title"><i class="tim-icons icon-delivery-fast text-info"></i> 3,500</h3> -->
												</div>
												<div class="card-body" style="height: 250px;">
													<!-- this below div for graph -->
													<%-- <div class="chart-area">
														<canvas id="CountryChart"></canvas>
													</div> --%>
													<!-- this below div for progress bar-->
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
														<i class="tim-icons icon-volume-98"></i>By Language
													</h4>
													<h5 class="card-title2" id="titledata">Calculated for
														last 7 days</h5>
													<!-- <h3 class="card-title"><i class="tim-icons icon-send text-success"></i> 12,100K</h3> -->
												</div>
												<div class="card-body" id="topLanguageChartBody">
													<!-- this below div for graph -->
													<%-- 					<div class="chart-area">
														<canvas id="chartLineGreen"></canvas>
													</div> --%>
													<!-- this below div for progress bar -->
													<div id="language-Progress-Bar"></div>

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
													<h5 class="card-title2" id="titledata">Calculated for
														last 7 days</h5>
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
														onchange="hourlyPlayoutData('/getHourlyPlayoutByChannel','rgb(85, 206, 249)', 'rgb(85, 206, 249)', '0.4','hourlyPlayoutLineChart')">
														<option value="Hours">HOURS</option>
														<option value="AM">AM</option>
														<option value="PM">PM</option>
													</select>
													<h5 class="card-title2" id="titledata">Calculated for
														last 7 days</h5>

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
									<div class="col-sm-12" style="margin-top: 7%;">
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
												</a> <a href="#" onclick="tabledata();"
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
	</div>
	<div class="footer">SYNC - Copyright © 2019</div>
	<script type="text/javascript">
		var start = moment().subtract(6, 'days');
		var end = moment();

		$('#startDateSelected').val(start.format('YYYY-MM-DD'));
		$('#endDateSelected').val(end.format('YYYY-MM-DD'));

		if (genrefilter == 'null') {
		} else if (genrefilter == null) {
		} else if (genrefilter == 'undefined') {
		} else {
			var array = genrefilter.split("~");
			console.log(array);
			var filterdiv = $('#filtersBox');
			$('#filtersBox').show();
			for (var i = 0; i < array.length; i++) {
				var genreid = array[i].replace(/[^A-Z0-9]/ig, "_");
				$('#option_' + genreid).selectable();
				$('#option_' + genreid).removeClass();
				$('#option_' + genreid)
						.addClass(
								"ui-widget-content genre ui-selectee ui-selected ui-selected-multi");
				handleTags(array[i], 'option_' + genreid, "genre", "add");
			}
		}
		if (channelfilter == 'null') {

		} else if (channelfilter == null) {

		} else if (channelfilter == 'undefined') {

		} else if (channelfilter == '') {
		} else {
			var array;
			var filterdiv = $('#filtersBox');

			$('#filtersBox').show();

			if (channelfilter.includes('~')) {
				array = channelfilter.split("~");
				for (var i = 0; i < array.length; i++) {
					var channelids = array[i].replace(/[^A-Z0-9]/ig, "_");
					$('#option_' + channelids).selectable();
					$('#option_' + channelids).removeClass();
					$('#option_' + channelids)
							.addClass(
									"ui-widget-content channel ui-selectee ui-selected ui-selected-multi");
					handleTags(array[i], 'option_' + channelids, "channel",
							"add");

				}

			} else {
				array = channelfilter;
				var channelids = array.replace(/[^A-Z0-9]/ig, "_");
				$('#option_' + channelids).selectable();
				$('#option_' + channelids).removeClass();
				$('#option_' + channelids)
						.addClass(
								"ui-widget-content channel ui-selectee ui-selected ui-selected-multi");
				handleTags(array, 'option_' + channelids, "channel", "add");

			}

			console.log(array);
		}

		if (languagefilter == 'null') {

		} else if (languagefilter == null) {

		} else if (languagefilter == 'undefined') {

		} else if (languagefilter == '') {
		} else {
			var array;
			var filterdiv = $('#filtersBox');

			$('#filtersBox').show();

			if (languagefilter.includes('~')) {
				array = languagefilter.split("~");
				for (var i = 0; i < array.length; i++) {
					var languageids = array[i].replace(/[^A-Z0-9]/ig, "_");
					$('#option_' + languageids).selectable();
					$('#option_' + languageids).removeClass();
					$('#option_' + languageids)
							.addClass(
									"ui-widget-content language ui-selectee ui-selected ui-selected-multi");
					handleTags(array[i], 'option_' + languageids, "language",
							"add");

				}

			} else {
				array = languagefilter;
				var languageids = array.replace(/[^A-Z0-9]/ig, "_");
				$('#option_' + languageids).selectable();
				$('#option_' + languageids).removeClass();
				$('#option_' + languageids)
						.addClass(
								"ui-widget-content language ui-selectee ui-selected ui-selected-multi");
				handleTags(array, 'option_' + languageids, "language", "add");

			}

			console.log(array);
		}

		$("#genre li").on(
				"click",
				function(e) {

					if ($(this).hasClass("ui-selected-multi")) {
						$(this).removeClass("ui-selected ui-selected-multi");
						handleTags($(this).text(), $(this).attr('id'), "genre",
								"remove");
					} else {
						$(this).addClass(" ui-selected-multi");
						handleTags($(this).text(), $(this).attr('id'), "genre",
								"add");
					}
				});

		$("#channel li").on(
				"click",
				function(e) {

					if ($(this).hasClass("ui-selected-multi")) {
						$(this).removeClass("ui-selected ui-selected-multi");
						handleTags($(this).text(), $(this).attr('id'),
								"channel", "remove");
					} else {
						$(this).addClass(" ui-selected-multi");
						handleTags($(this).text(), $(this).attr('id'),
								"channel", "add");
					}
				});

		$("#language li").on(
				"click",
				function(e) {
					if ($(this).hasClass("ui-selected-multi")) {
						$(this).removeClass("ui-selected ui-selected-multi");
						handleTags($(this).text(), $(this).attr('id'), "",
								"remove");
					} else {
						$(this).addClass(" ui-selected-multi");
						handleTags($(this).text(), $(this).attr('id'),
								"language", "add");
					}
				});

		function handleTags(selection, selectionId, parent, action) {
			$('.tag-box').show();

			var ul = $(".tag-box");
			var ids = selectionId.substring(7);
			if (action == 'add'
					&& $(".tag-box").find("#tag_" + ids).length == 0) {
				$('.tag-box').append(
						'<li class="tags '+parent+' ui-sortable-handle" id="tag_'+ids+'" >'
								+ selection + '<a class="close"></a></li>');
				$("#tag_" + ids).addClass("tagp");
				allOnloadChannelGraph(page);
			}
			if (action == 'remove') {

				$("#tag_" + ids).remove();
				var children = $('.tag-box').children().length;
				if (children == 0) {
					$('.tag-box').hide();
				}
				allOnloadChannelGraph(page);
			}

			$("#tag_" + ids).on(
					"click",
					function(e) {
						$("#option_" + ids).removeClass(
								"ui-selected ui-selected-multi");
						$(this).remove();

						var children = $('.tag-box').children().length;
						if (children == 0) {
							$('.tag-box').hide();
						}
						allOnloadChannelGraph(page);
					});
		}
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

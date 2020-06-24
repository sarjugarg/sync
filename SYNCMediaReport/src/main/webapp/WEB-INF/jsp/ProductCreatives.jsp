<%int serialno=0; %>
<c:forEach items="${creativesName}" var="creatives">
<%serialno++; %> 
 
	<div id="page-wrapper<%=serialno%>" class="creative<%=serialno%>">
	    <input type="hidden" id="startDateSelected" />
        <input type="hidden" id="endDateSelected" />				    
<input type="hidden" id="creative"   value="${creatives}"> 		
		<!-- Top Bar Start -->
		<div class="container-fluid">
			<div class="page-contentbar">
				<!-- START PAGE CONTENT -->
				<div id="page-right-content"  class="countdiv<%=serialno %>">
					<input type="hidden" id="limit" placeholder="limit" />
					<div class="row row<%=serialno %>" style="display: -webkit-box;">
						<div class="col-sm-4 column<%=serialno %>" id="columncreative<%=serialno %>">
						 
						<script>
var spenddata='<c:out value="${spend}" />';
var spendfmt=currencyFormatter(spenddata, 2); 
var sno='<%=serialno %>';
hourlyid="hourlyPlayoutLineChart";
dailyid="dailyPlayoutLineChart";
topchannel="chartLinePurple";
topgenre="chart-area2";
toplanguage="languageDiv"; 
singleTopChannel="topChannelDonut";
desccount="#column"; 

</script>
 
						
		<div class="col-sm-12" >
					   <div class="grey-bg">
				    			
					<div class="col-sm-12" >
										<div class="card card-chart">
				<div class="card-header">
				
													<h4 class="card-title">
														<i class="tim-icons icon-tv-2"></i><a href="./ChannelDashboard">Top Channels</a>
													</h4>
													<h5 class="card-title2" id="titledata"></h5>
												</div>				
									<div class="card-body">
								
					<div id="resizer" style="min-height: 273px; width: 500px">
    <div id="inner-resizer">
        <div id="topChannelDonutcreative<%=serialno%>" style="height: 230px">
        </div>
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
														<div id="chartLinePurplecreative<%=serialno%>"></div>


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
														<i class="tim-icons icon-bullet-list-67"></i>Top Genre
													</h4>
													<h5 class="card-title2" id="titledata"></h5>
													<!-- <h3 class="card-title"><i class="tim-icons icon-delivery-fast text-info"></i> 3,500</h3> -->
												</div>
												<div class="card-body" id="topCategoryChartBodycreative<%=serialno%>"
													style="height: 250px;">
													<div class="chart-area2creative<%=serialno%>" style="height: 20px !important;">

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
													<h5 class="card-title2" id="titledata"></h5>
													<!-- <h3 class="card-title"><i class="tim-icons icon-send text-success"></i> 12,100K</h3> -->
												</div>
												<div class="card-body" id="topLanguageChartBody">
													<div id="languageDivcreative<%=serialno%>"></div>
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
														<canvas id="dailyPlayoutLineChartcreative<%=serialno%>"></canvas>
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
														onchange="hourlyPlayoutData('/getDataByHourlyPlayout','rgb(111,208,206)', 'rgb(111,208,206)', '0.4','hourlyPlayoutLineChart');">
														<option value="Hours">Hours</option>
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
														<canvas id="hourlyPlayoutLineChartcreative<%=serialno%>"></canvas>
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
					<button onclick="showModal();" id="createcard" style="margin-left: 18px;cursor: pointer;color:#A9A9A9;border: none;background:none;"> <i
													 class="fa fa-plus" style="color: #A9A9A9;"  aria-hidden="true"></i>
													Create Card
												</button>		  			

												<a href="#" id="priviewData" style="color:#A9A9A9" onclick="screenShot2('page-wrapper<%=serialno%>');"> <i class="fa fa-eye"
													style="color: #A9A9A9;"></i>View
												</a> 
												<a href="#"  onclick="tabledata2();" style="margin-left: 18px;color: #A9A9A9"> <i
													class="fa fa-download" style="color: #A9A9A9;" ></i>
													Download</a>
												<div id="showpriview" style="display:none;">
												</div>

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
	<br><br>
	</c:forEach>
	
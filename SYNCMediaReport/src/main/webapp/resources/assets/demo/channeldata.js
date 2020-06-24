
var channelHourlyUrl = "/getHourlyPlayoutByChannel";
var channelDailyUrl = "/getDailyPlayoutByChannel";
// getDatabyProduct
$(document).ajaxStart(function() {
	$.blockUI({ message: $('<img src="./resources/images/loader.gif" />') });
	$(".blockPage").css({ 'background-color' : '', 'border' : '' });
});

$(document).ajaxStop(function() {
	$.unblockUI();
});

function allOnloadChannelGraph(page) {
	
	allgraph();
	dateselecteddata();
	obj = {
		startdate : fromdate,
		enddate : todate,
		limit : limit,
		time : selectedVal,
		genre : genre,
		streamname : channelid,
		language:language
		
	// productname:product
	};
	getTopChannels(fromdate,todate,'progress-bar-success-single-channel1',
			'progress-bar-success-single-channel2', escape(datelabel),topchannel);
	getGenreData();
	getLanguageData();
	hourlyPlayoutData(channelHourlyUrl, 'rgb(85, 206, 249)',  'rgb(85, 206, 249)', 0.4, hourlyid);
	dailyPlayoutData(channelDailyUrl, 'rgb(85, 206, 249)', 'rgb(85, 206, 249)', 0.4, dailyid);
	getChannelsList(fromdate, todate,escape(datelabel));
}

function singleChannelGraph(page) {
	var selectedVal;
	var selected = $("input[name='options']:checked");
	if (selected.length > 0) {
		selectedVal = selected.val();
	}
	dateselectedOnSinglePage();
	obj = {
		startdate : startdate,
		enddate : enddate,
		time : selectedVal,
		streamname:channelid,
		cid:cid
	};
 
	hourlyPlayoutData(channelHourlyUrl,'rgb(50, 181, 176)',  'rgb(159, 225, 223)', 0.4,hourlyid);
	dailyPlayoutData(channelDailyUrl, 'rgb(205, 226, 15)', 'rgb(231, 239, 170)', 0.6,dailyid);
	getDataByProducts(startdate, enddate,
			'progress-bar-success-single-channel1',
			'progress-bar-success-single-channel2', '#chartLinePurple',escape(datetextdata));
	SingleCategoryData('progress-bar-success-single-channel1',
			'progress-bar-success-single-channel2', startdate, enddate,escape(datetextdata));
	SingleBrandData('progress-bar-success-single-channel1',
			'progress-bar-success-single-channel2', '.topbrands', startdate,
			enddate,escape(datetextdata));
}

function SingleCategoryData(classcolor1,classcolor2,date1,date2,text) {
	$.ajax({
				type : 'POST',
				url : contextpath + "/CategoryList",
				contentType : "application/json",
				dataType : 'html',
				data : JSON.stringify(obj),
				beforeSend : function() {
					$("#loading-image").show();
				},
				success : function(data) {
					var timeduration = [];
					var duration_name;
			
					var Html = "";
					var slctSubcat = $(".chart-area2");
					slctSubcat.empty();
					var objResponse = $.parseJSON(data);
					for (var i = 0; i < objResponse.length; i++) {
	                     var airtimeformat;
	                     if(objResponse[i].duration_name=='Playout'){
	                    	 airtimeformat=objResponse[i].timeduration; 
	                     }
	                     else{
	                    	 airtimeformat=toHHMMSS(objResponse[i].timeduration);
	                     }
					 	 var categoryname=objResponse[i].categoryname;
		            	 var result;
		            	 var maxLength = 20;
		            		 result=categoryname;
						var percent = (objResponse[i].timeduration / objResponse[0].timeduration) * 100;
						var logo='';
						var categorylogo=objResponse[i].logoUrl+objResponse[i].logo;
						if(categorylogo=='NA'){
						logo='./resources/images/no_img.png'	
						}
						else{
					     logo=categorylogo;
						} 
						if (i % 2 == 0) {
							Html = "<h6 style='height:1px;font-size:12px;' class='text-muted' data-toggle='tooltip'    title='"+categoryname+"' >" +
									"<a id='category"+i+"'   href='#' onclick='singleCategoryPage2("+i+")' style='color:black;' >" 
									+ result
									+ "</a></h6><div class='progress progress-sm m-0'><div class='progress-bar "+classcolor1+"' role='progressbar' aria-valuenow='' aria-valuemin='0' aria-valuemax='100' style='width:"
									+ parseInt(percent)
									+ "%;'></div> </div>"
									+ "<div class='valueread'>"
									+ airtimeformat + "</div>";
							$('.chart-area2').append(Html);
						} else {
							Html = "<h6 style='height:1px;font-size:12px;' class='text-muted' data-toggle='tooltip'    title='"+categoryname+"' >" +
							"<a id='category"+i+"'   href='#' onclick='singleCategoryPage2("+i+")'  style='color:black;'>" 
							+ result    
							+ "</a></h6><div class='progress progress-sm m-0'><div class='progress-bar "+classcolor2+"' role='progressbar' aria-valuenow='' aria-valuemin='0' aria-valuemax='100' style='width:"
							+ parseInt(percent)
							+ "%;'></div> </div>"
							+ "<div class='valueread'>"
							+airtimeformat + "</div>";
					$('.chart-area2').append(Html);
						}

					}
					$("#loading-image").hide();
				},
				error : function() {
				}
			});
}

function getGenreData() {
	$.ajax({
				type : 'POST',
				url : contextpath + "/getTopGenreByProduct",
				data : JSON.stringify(obj),
				contentType : "application/json",
				dataType : 'html',
				success : function(data) {
					var objResponse = $.parseJSON(data);
					var slctSubcat = $(".chart-area2");

					var Html = "";
					slctSubcat.empty();

					for (var i = 0; i < objResponse.length; i++) {
						var genre=objResponse[i].genre;
		            	 var result;
		            	 var maxLength = 20;
		            	 var airtimeformat;
	                     if(objResponse[i].duration_name=='Playout'){
	                    	 airtimeformat=objResponse[i].timeduration; 
	                     }
	                     else{
	                    	 airtimeformat=toHHMMSS(objResponse[i].timeduration);
	                     }
		            		 result=genre;
						var percent = (objResponse[i].timeduration / objResponse[0].timeduration) * 100;
						if (i % 2 == 0) {
							Html = "<h6 style='height:1px;font-size:12px;' class='text-muted' data-toggle='tooltip' title='"+genre+"' >"
									+ genre
									+ "</h6><div class='progress progress-sm m-0'><div class='progress-bar progress-bar-success' role='progressbar' aria-valuenow='' aria-valuemin='0' aria-valuemax='100' style='width:"
									+ parseInt(percent)
									+ "%;'></div> </div>"
									+ "<div class='valueread'>"
									+ airtimeformat + "</div>";
							$('.chart-area2').append(Html);
						} else {     
							Html = "<h6 style='height:1px;font-size:12px;' class='text-muted' data-toggle='tooltip' title='"+genre+"'>"
									+ genre
									+ "</h6><div  class='progress progress-sm m-0'><div class='progress-bar progress-bar-success2' role='progressbar' aria-valuenow='' aria-valuemin='0' aria-valuemax='100' style='width:"
									+ parseInt(percent)
									+ "%;'></div> </div>"
									+ "<div class='valueread'>"
									+ airtimeformat + "</div>";
							$('.chart-area2').append(Html);
						}

					}

				},
				error : function() {
				}
			});
}

function getChannelsList(date1, date2,text) {
	obj = {
			startdate : fromdate,
			enddate : todate,
			limit : "",
			time : selectedVal,
			genre : genre,
			streamname : channelid,
			language:language
		};
	$.ajax({
		type : 'POST',
		url : contextpath + "/ChannelsList",
		async: true,
		data : JSON.stringify(obj),
		contentType : "application/json",
		dataType : 'html',
		success : function(data) {
			var objResponse = $.parseJSON(data);
		 	channelsListGraph(objResponse, date1, date2,text);
		},
		error : function() {
		}
	});
}

function getDataByProducts(fromdate, todate, colorclass1, colorclass2, div,text) {
	$
			.ajax({
				type : 'POST',
				url : contextpath + "/TopProducts",
				data : JSON.stringify(obj),
				contentType : "application/json",
				dataType : 'html',
				success : function(data) {
					var objResponse = $.parseJSON(data);
					var Html = "";
					var slctSubcat = $("" + div + "");
					slctSubcat.empty();

					for (var i = 0; i < objResponse.length; i++) {
						 var airtimeformat;
	                     if(objResponse[i].duration_name=='Playout'){
	                    	 airtimeformat=objResponse[i].timeduration; 
	                     }
	                     else{
	                    	 airtimeformat=toHHMMSS(objResponse[i].timeduration);
	                     }
						var percent = (objResponse[i].timeduration / objResponse[0].timeduration) * 100;
						var logo = objResponse[i].logoUrl+objResponse[i].logo;
						var productname=objResponse[i].productname;
		            	 var result;
		            	 var maxLength = 20;
		            		 result=productname;
						var addlogo = '';
						if (logo == 'NA') {
							addlogo = './resources/images/no_img.png';
						} else {
							addlogo = logo;
						}
                      var  colorcode;
						if (i % 2 == 0) { 
						colorcode=colorclass1;
							
						}
						else{
						colorcode=colorclass2;	
						}
							Html = '<h6 style="height:1px;font-size:12px;" class="text-muted" data-toggle="tooltip" title="'+productname+'"' 
									+' ><a  href="#" id="product'+i+'"'
									+ ' style="color:black;" onclick="singleProductPage2('+i+')">'
									+ result
									+ '</a></h6><div  class="progress progress-sm m-0"><div class="progress-bar '+colorcode+'" ' 
									+  ' role="progressbar" aria-valuenow="" aria-valuemin="0" aria-valuemax="100" style="width:'
									+ parseInt(percent)
									+ '%;"></div> </div>'
									+ '<div class="valueread">'
									+ airtimeformat + '</div>';
							$(''+ div +'').append(Html);
						
					}

				},
				error : function() {
				}
			});
}

   function channelDataCount(){
	   $.ajax({
			type : 'GET',
			url : contextpath + "/channelsCount",
			contentType : "application/json",
	        dataType: 'html', 
			success : function(data) {
				var response = $.parseJSON(data);
				var Html = "";
				var channels = $("#ChannelCount");
				var language=$("#LanguageCount");
				var genre=$("#GenreCount");
				channels.empty();
				language.empty();
				genre.empty();
				for(var i=0;i<response.length;i++){
				channels.text(response[i].cid);
				language.text(response[i].language);	
				genre.text(response[i].genre);
				}
		},
			error : function() {
			} 
		});
   }
   
   
   function getAllGenre(){
	   $.ajax({ 
			type : 'GET',
			url : contextpath + "/AllGenre",
			contentType : "application/json",
	        dataType: 'html', 
			success : function(data) {
				var response = $.parseJSON(data);
				var genrefilter = $("#genreList");
				genrefilter.empty();
		 for(var i=0;i<response.length;i++){
		  var htmltext='<li  data-toggle="tooltip" title="'+$.trim(response[i])+'"  class="ui-widget-content genre" '
		  +'id="option_'+($.trim(response[i])).replace(" ","_")+'">'+$.trim(response[i])+'</li>';
		  genrefilter.append(htmltext);
		}
			},
			error : function() {
			} 
		});
   }
   
   function getAllChannels(){
	   $.ajax({
			type : 'GET',
			url : contextpath + "/AllChannels",
			contentType : "application/json",
	        dataType: 'html', 
			success : function(data) {
				var response = $.parseJSON(data);
				var Html = "";
			},
			error : function() {
			} 
		});
   }
   
   function SingleBrandData(colorclass1, colorclass2, div, date1, date2,text) {
		$
				.ajax({
					type : 'POST',
					url : contextpath + "/BrandList",
					contentType : "application/json",
					dataType : 'html',
					data : JSON.stringify(obj),
					beforeSend : function() {
						$("#loading-image").show();
					},
					success : function(data) {
						var categoryname = [];
						var timeduration = [];
						var duration_name;
						var objResponse = $.parseJSON(data);
						// this is category graph function
						// byCategoryGraph(objResponse);
						// below code in for loop for progress bar
						var Html = "";
						var slctSubcat = $("" + div + "");
						slctSubcat.empty();

						for (var i = 0; i < objResponse.length; i++) {
							var brand=objResponse[i].brand;
			            	 var result;
			            	 var maxLength = 20;
			            	 var airtimeformat;
		                     if(objResponse[i].duration_name=='Playout'){
		                    	 airtimeformat=objResponse[i].timeduration; 
		                     }
		                     else{
		                    	 airtimeformat=toHHMMSS(objResponse[i].timeduration);
		                     }
			            		 result=brand;
							var brandlogo =objResponse[i].logoUrl+objResponse[i].logo;
							var logo = '';
							if (brandlogo == 'NA') {
								logo = './resources/images/no_img.png';
							} else {
								logo = brandlogo;
							} 
							var percent = (objResponse[i].timeduration / objResponse[0].timeduration) * 100;
							var colorcode;
							if (i % 2 == 0) {
								colorcode=	colorclass1;
							}
							
							else{
								colorcode=	colorclass2;	
							}
							/*	Html = '<h6 style="height:1px;font-size:12px;" class="text-muted" data-toggle="tooltip"    title="'+brand+'"  > '
										+'<a href="#"  onlick="brandByData('+i+');"   id="brand'+i+'"  style="color:black;" > '+result+' '
										+ '</a></h6><div class="progress progress-sm m-0"><div class="progress-bar '+colorcode+'" '
										+ ' role="progressbar" aria-valuenow="" aria-valuemin="0" aria-valuemax="100" style="width:'
										+ parseInt(percent)+'%;"></div> </div>'  
										+ '<div class="valueread">'
										+ airtimeformat + '</div>';*/
							Html = '<h6 style="height:1px;font-size:12px;" class="text-muted" data-toggle="tooltip" title="'+brand+'"' 
							+' ><a  href="#" id="brand'+i+'"'
							+ ' style="color:black;" onclick="singleBrandPage2('+i+')">'
							+ result 
							+ '</a></h6><div  class="progress progress-sm m-0"><div class="progress-bar '+colorcode+'" ' 
							+  ' role="progressbar" aria-valuenow="" aria-valuemin="0" aria-valuemax="100" style="width:'
							+ parseInt(percent)
							+ '%;"></div> </div>'
							+ '<div class="valueread">'
							+ airtimeformat + '</div>'; 
						    $('' + div + '').append(Html);  
							$("#loading-image").hide();
						}
					},
					error : function() {
					}
				});
	}

   
   function getAllLanguage(){
	   $.ajax({
			type : 'GET',
			url : contextpath + "/AllLanguage",
			contentType : "application/json",
	        dataType: 'html', 
			success : function(data) {
				var response = $.parseJSON(data);
				var Html = "";
			},
			error : function() {
			} 
		});
   }
   
  function singleChannelPage(strid){
	  allgraph();
		dateselecteddata();
	  var	objdata = {
			startdate : fromdate,
			enddate : todate,
			cid : strid,
			datetext:datelabel,
			streamid:"null",
			streamname:""
		}; 
	  singleChannelAjax(objdata);
  }
  
  
  
  
  
  function singleChannelPage2(strid){
	  allgraph();
		dateselecteddata();
	  var	objdata = {
			startdate : startdate,
			enddate : enddate,
			cid : strid, 
			datetext:datetextdata,
			streamid:"null",
			streamname:""
		}; 
	  singleChannelAjax(objdata);
	  
	  
  }
  
  function ChannelSearch(strid,k){
	  allgraph();
		dateselecteddata();
		getDates();
	  var	objdata = {
		    startdate : begindate,
		    enddate : finalDate,
			cid : strid, 
			datetext:"",
			streamid:"null",
			streamname:"",
			card:k
		}; 
	  singleChannelAjax(objdata);
	  
	  
  }
  
  function singleChannelAjax(ajaxObj){
		$.ajax({
			type : 'POST',
			url : contextpath + "/SingleChannel",
			data : JSON.stringify(ajaxObj),
			contentType : "application/json",
			dataType : 'html',
			success : function(data) {
              window.location.href='./SingleChannelDashboard';
			},
			error : function() {
			}
		});

  } 
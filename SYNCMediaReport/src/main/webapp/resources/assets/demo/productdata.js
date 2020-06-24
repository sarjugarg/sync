var obj, fromdate, todate, selectedVal, genre , limit,products,brands,language, datelabel,productname,stream_name;
var genre2 ,products2,brands2,language2,cid;
var begindate , finalDate;
var productfilter="";
var brandfilter="";
var languagefilter="";
var genrefilter="";
var channelfilter="";
var hourlyid="";
var dailyid="";
var topchannel="";
var elementName="";
var topgenre="";  
var toplanguage=""; 
var desccount="";	
var singleTopChannel="";
topchannel="chartLinePurple";
topgenre="chart-area2";
toplanguage="languageDiv";
hourlyid="hourlyPlayoutLineChart";
dailyid="dailyPlayoutLineChart";
singleTopChannel="topChannelDonut";
var producthourlyplayout = "/getDataByHourlyPlayout";
var productdailyplayout = "/getDataByDailyPlayout";
var s='2018-04-10';
var e='2018-04-16'; 
$(document).ajaxStart(function() {
	$.blockUI({ message: $('<img src="./resources/images/loader.gif" />') ,
		
	}
	
	);
	$("#myModal").block({
		message : $('<img src="./resources/images/loader.gif" />'),
		css: {
            border: '',
            backgroundColor: '',
        }
	});
	$(".blockPage").css({ 'background-color' : '', 'border' : '' });
	$(".blockUI blockMsg blockElement").css({ 'background-color' : '', 'border' : '' });
	
});

$(document).ajaxStop(function() {
	$("#myModal").unblock();
	$.unblockUI();
	
}); 

function toHHMMSS(seconds) {
    var sec_num = parseInt(seconds);
    var hours   = Math.floor(sec_num / 3600);
    var minutes = Math.floor((sec_num - (hours * 3600)) / 60);
    var seconds = sec_num - (hours * 3600) - (minutes * 60);        
    if (hours   < 10) {hours   = "0"+hours;}
    if (minutes < 10) {minutes = "0"+minutes;}
    if (seconds < 10) {seconds = "0"+seconds;}
    var time    = hours+':'+minutes+':'+seconds;
    return time;
} 

function currencyFormatter(num, digits) {
	  var si = [
	    { value: 1, symbol: "" },
	    { value: 1E3, symbol: " K" },
	    { value: 1E5, symbol: " Lac" },
	    { value: 1E7, symbol: " Cr" },
	//    { value: 1E9, symbol: " 100Cr" },
	   
	  ];
	  var rx = /\.0+$|(\.[0-9]*[1-9])0+$/;
	  var i;
	  for (i = si.length - 1; i > 0; i--) {
	    if (num >= si[i].value) {
	      break;
	    }
	  }
	  return (num / si[i].value).toFixed(digits).replace(rx, "$1") + si[i].symbol;
	}
 



function dateselecteddata(){
	//datelabel=$(".ranges ul li.active").text();
	datelabel=$('#dateselectedlabel').val();
	var slctSubcat = $(".card-title2");
	slctSubcat.empty();
	if(datelabel=='Custom Range'){
		slctSubcat.append("calculated from "+fromdate+" to "+todate+" ")	
	}
	else{
		if(datelabel==""){
			slctSubcat.append("Calculated for Last 7 Days");	
		}
		else{
			slctSubcat.append("Calculated for "+datelabel+"");		
		}
	
	}
	
}

function dateselectedOnSinglePage(){
	var slctSubcat = $(".card-title2");
	slctSubcat.empty();
	if(datetextdata=='Custom Range'){
		slctSubcat.append("calculated from "+startdate+" to "+enddate+" ")	
	}
	else{
		if(datetextdata==""){
			slctSubcat.append("Calculated for Last 7 Days");	
		}
		else{
			slctSubcat.append("Calculated for "+datetextdata+"");		
		}
	
	}
	
}


function onChangeAllChartReload(page) {
	
	allgraph();
	dateselecteddata();
	obj = { 
		startdate :fromdate,
		enddate :todate,   
		limit : limit,
		time : selectedVal,
		genre : genre, 
		streamname : channelid,
		productname : products
	}; 
	getTopChannels(fromdate,todate,'progress-bar-success','progress-bar-success2',escape(datelabel),topchannel);
	getCategoryByProduct('progress-bar-success','progress-bar-success2',fromdate,todate,escape(datelabel));
	getLanguageData();
	hourlyPlayoutData(producthourlyplayout,'rgb(85, 206, 249)', 'rgb(85, 206, 249)', 0.4,hourlyid);
	dailyPlayoutData(productdailyplayout,'rgb(85, 206, 249)', 'rgb(85, 206, 249)', 0.4,dailyid);
	getTopProducts(fromdate,todate,escape(datelabel));
}

function singleProductChartReload(page) {
	var selectedVal; 
	var selected = $("input[name='options']:checked");
	if (selected.length > 0) {
		selectedVal = selected.val();
	}

	obj = {
		startdate : startdate,
		enddate : enddate,
		time : selectedVal,
		productname : product.replace(/'/g,"\\\'")
	};  
	dateselectedOnSinglePage();
	getTopChannels(startdate,enddate,'progress-bar-success3','progress-bar-success4',escape(datetextdata),topchannel);
	getTopGenre('progress-bar-success3','progress-bar-success4',topgenre);
	getLanguageData('progress-bar-success3','progress-bar-success4',toplanguage);
	hourlyPlayoutData(producthourlyplayout,'rgb(111,208,206)', 'rgb(111,208,206)', 0.4,hourlyid); 
	dailyPlayoutData(productdailyplayout,'rgb(52,163,159)', 'rgb(166, 206, 204)', 0.4,dailyid);
	getTopChannelsSingleProduct(singleTopChannel,'rgb(52,163,159)', 'rgb(182, 222, 221)');


}


function creativesByProductChartReload(page) {
	$('div[class^="creative"]').each(function( ) {
	var creative=$(this).find('#creative').val();
	var creativediv=$(this).attr('class');
	var descountdata=desccount+creativediv;
	var selectedVal; 
	var selected = $("input[name='options']:checked");
	if (selected.length > 0) {
		selectedVal = selected.val();
	}

	obj = {
		startdate : startdate,
		enddate : enddate,
		time : selectedVal,
		productname : product.replace(/'/g,"\\\'"),
		creative:creative.replace(/'/g,"\\\'")
	};  
	dateselectedOnSinglePage();
	getTopChannels(startdate,enddate,'progress-bar-success3','progress-bar-success4',escape(datetextdata),topchannel+creativediv);
	getTopGenre('progress-bar-success3','progress-bar-success4',topgenre+creativediv);
	getLanguageData('progress-bar-success3','progress-bar-success4',toplanguage+creativediv);
	hourlyPlayoutData(producthourlyplayout,'rgb(111,208,206)', 'rgb(111,208,206)', 0.4,hourlyid+creativediv); 
	dailyPlayoutData(productdailyplayout,'rgb(52,163,159)', 'rgb(166, 206, 204)', 0.4,dailyid+creativediv);
	getTopChannelsSingleProduct(singleTopChannel+creativediv,'rgb(52,163,159)', 'rgb(182, 222, 221)');
	});
	}


function creativesByProduct(page) {
	$('div[class^="creative"]').each(function( ) {
	var creative=$(this).find('#creative').val();
	var creativediv=$(this).attr('class');
	var descountdata=desccount+creativediv;
	var selectedVal; 
	var selected = $("input[name='options']:checked");
	if (selected.length > 0) {
		selectedVal = selected.val();
	}

	obj = {
		startdate : startdate,
		enddate : enddate,
		time : selectedVal,
		productname : product.replace(/'/g,"\\\'"),
		creative:creative.replace(/'/g,"\\\'")
	};  
	dateselectedOnSinglePage();
	getTopChannels(startdate,enddate,'progress-bar-success3','progress-bar-success4',escape(datetextdata),topchannel+creativediv);
	getTopGenre('progress-bar-success3','progress-bar-success4',topgenre+creativediv);
	getLanguageData('progress-bar-success3','progress-bar-success4',toplanguage+creativediv);
	hourlyPlayoutData(producthourlyplayout,'rgb(111,208,206)', 'rgb(111,208,206)', 0.4,hourlyid+creativediv); 
	dailyPlayoutData(productdailyplayout,'rgb(52,163,159)', 'rgb(166, 206, 204)', 0.4,dailyid+creativediv);
	getTopChannelsSingleProduct(singleTopChannel+creativediv,'rgb(52,163,159)', 'rgb(182, 222, 221)');
	dynamicCreativeCounts(descountdata);
	});
	}

function dynamicCreativeCounts(abc){
	$.ajax({
		type : 'POST',
		url : contextpath + '/singleCreativeData',
		contentType : "application/json",
		dataType : 'html',
		data : JSON.stringify(obj),
		success : function(data) {
			var timeduration = [];
			var date = [];
			var duration_name;
			var response = $.parseJSON(data);
			var selectdiv=$(""+abc+""); 
			
			$("#contentdiv"+i+"").empty();
			for(var i=0 ; i<response.length;i++){
				var imglogo=response[i].logoUrl+response[i].logo;
				var logo;
				if(response[i].logo=='NA'){
					logo='./resources/images/no_img.png';
				}
				else{
					logo=imglogo;
				} 
				var html='<div id="contentdiv'+i+'"><div class="col-sm-12" id>'
					+'<div class="col-sm-6" style="width: 46%; margin-bottom: 20px;">'
				    +'<div><img src='+logo.replace(/ /g, "%20")+' /></div></div>'
					+'<div class="col-sm-6" style="width: 90%; margin-bottom: 20px;">'
					+'<div class="sinlgePg_cat_lang"><div style="color:#FFFFFF;;"><span title="'+response[i].creative+'" style="border-bottom:1px solid rgb(111,208,206); font-size: 21px;">'+response[i].creative+'</span></div>'
					+'<div style="padding-top: 35px;"><span title="'+response[i].categoryname+'" style="font-size: 13px; color:rgb(52,163,159);"><label style="font-weight:200; color:rgb(255, 255, 255, 0.8);">Category: </label> '+response[i].categoryname+' </span></div>'
					+'<div ><span title="'+response[i].language+'"  style="font-size: 13px; color:rgb(111,208,206);"><label style="font-weight:200; color:rgb(255, 255, 255, 0.8);">Language: </label> '+response[i].language+'</span></div>'
					+'</div></div></div><div class="col-sm-6"><div class="singlePg_sm_div dark"><h4 '
					+' style="text-align: center; color:rgb(52,163,159); font-size: 14px; margin-bottom: 10px;">Playouts</h4>'
					+'<div style="text-align: center; color:#FFFFFF;"><span style="font-size: 24px;">'+response[i].count+''
					+'</span></div></div><div class="singlePg_sm_div dark">'
					+'<h4 style="text-align: center; color:rgb(52,163,159); font-size: 14px; margin-bottom: 10px;">Spend</h4>'
					+'<div style="text-align: center; color:#FFFFFF;"><span style="font-size: 25px;"> '+currencyFormatter(response[i].spend,2)+' </span>'
					+'</div></div></div><div class="col-sm-6"><div class="singlePg_sm_div dark">'
					+'<h4 style="text-align: center; color:rgb(111,208,206); font-size: 14px; margin-bottom: 10px;">Airtime</h4>'
					+'<div style="text-align: center; color:#FFFFFF;"><span style="font-size: 25px;">'
					+''+response[i].Airtime+'</span></div></div><div class="singlePg_sm_div dark">'
				    +'<h4 style="text-align: center; color:rgb(111,208,206); font-size: 14px; margin-bottom: 10px;">Channels</h4>'
					+'<div style="text-align: center; color:#FFFFFF;"> <span style="font-size: 24px;">'
					+''+response[i].cid+'</div></div></div></div>';
				selectdiv.prepend(html);
		
			}
		
		},
		error : function() {
		}
	});
}
function daysBetween(one, another) {
	  return Math.round(Math.abs((+one) - (+another))/8.64e7);
	}           
function allgraph(){    
    fromdate = $("#startDateSelected").val();
    todate = $("#endDateSelected").val(); 
    //fromdate=s;
    //todate=e;     
	var dt = new Date(); 
	var day;
	if (dt.getDate() < 10) {
		day = '0' + dt.getDate();
	} else {
		day = dt.getDate();
	}
	var month;
	if (dt.getMonth() + 1 < 10) {
		month = '0' + (dt.getMonth() + 1);
	} else {
		month = dt.getMonth() + 1;
	}
	var currendate= dt.getFullYear() + '-'+month + '-' + day;
 	
	limit = document.getElementById("limit").value;
	var selected = $("input[name='options']:checked");
	if (selected.length > 0) {
		selectedVal = selected.val();
	}
	var channelIds =[];
	var genreNames = []; 
	var productNames = [];
	var brandNames = [];
	var productNames2 = [];
	var brandNames2 = [];

	var languageNames = [];
    stream_name="";
	channelid = "";
	genre = "";
	products="";
	brands="";
	language="";
	
	$('.tag-box li').each(function (i) {
		if($(this).hasClass("channel")){
			channelIds.push(($(this).text().trim()));
			//channelIds.push($(this).attr("id").substring(4).replace("_"," "));
			channelid = "'" + channelIds.join("','") + "'";
			stream_name="" + channelIds.join("~") + ""
		} 
		if($(this).hasClass("genre")){
			//genreNames.push($(this).attr("id").substring(4).replace("_"," "));
			genreNames.push(($(this).text()).trim());
			genre = "'" + genreNames.join("','") + "'";
			genre2 =genreNames.join("~");
			}  
		       
		if($(this).hasClass("product")){
			var productdata=(($(this).text()).trim()).replace(/'/g,"\\\'");
			productNames.push(productdata);
			productNames2.push(($(this).text()).trim());
			//productNames.push($(this).attr("id").substring(4).replace("_"," "));
			products = "'" +  productNames.join("','") + "'";
			products2 =productNames.join("~");
			}
		if($(this).hasClass("brand")){
		brandNames.push(($(this).text().trim()).replace(/'/g,"\\\'"));
		brandNames2.push(($(this).text()).trim());
	//		brandNames.push($(this).attr("id").substring(4).replace("_"," "));
			brands = "'" +  brandNames.join("','") + "'";
			brands2 =brandNames.join("~");			
			}
		
		if($(this).hasClass("language")){
			languageNames.push(($(this).text()).trim());
			language = "'" +  languageNames.join("','") + "'";
			language2 =languageNames.join("~");
			}
    });	//allgraph();  
 
}


var channelidR;
var productsR;
var brandsR;

var categorysR;
var genreR;
var languageR;

//
//channelidR="";
//productsR="";
//brandsR="";
//categorysR="";
//genreR="";
//languageR="";

function multiColumn(){ 
	var channelIds =[];
	var genreNames = []; 
	var productNames = [];
	var brandNames = [];
	var productNames2 = [];
	var brandNames2 = [];

	var languageNames = [];
	var categoryNames=[];
	var categoryNames2=[];
	
	
	 channelidR="";
	 productsR="";
	 brandsR="";
	 categorysR="";
	 genreR="";
	 languageR="";
	
	
$('.tag-box2 li').each(function (i) {
	if($(this).hasClass("channel")){
		channelIds.push($(this).text());
		//channelIds.push($(this).attr("id").substring(4).replace("_"," "));
		channelidR = "'" + channelIds.join("','") + "'";
	} 
	if($(this).hasClass("genre")){
		genreNames.push($(this).text());
		genreR = "'" + genreNames.join("','") + "'";
	}  
	       
	if($(this).hasClass("product")){
		var productdata=($(this).text()).replace(/'/g,"\\\'");
		productNames.push(productdata);
		productNames2.push($(this).text());
		productsR = "'" +  productNames.join("','") + "'";
		}
	
	if($(this).hasClass("category")){
		var categorydata=$(this).text();
		categoryNames.push(categorydata);
		categoryNames2.push($(this).text());
		categorysR = "'" +  categoryNames.join("','") + "'";
		}
	
	if($(this).hasClass("brand")){
	brandNames.push($(this).text().replace(/'/g,"\\\'"));
	brandNames2.push($(this).text());
	brandsR = "'" +  brandNames.join("','") + "'";
		}
	
	if($(this).hasClass("language1")){
		languageNames.push($(this).text());
		languageR = "'" +  languageNames.join("','") + "'";
	}
});	//allgraph();  

}


function dataCount(){
	$.ajax({
        type: 'GET',
        url:contextpath+"/dataCount" ,
		contentType : "application/json",
        dataType: 'html', 
        success: function(data){   
        var response=$.parseJSON(data);
        var datadiv= $("#singlePg_sm_div");
        var Html="";  
        datadiv.empty();    
        for(var i=0; i<response.length; i++){
        var html='<div class="col-sm-2"><img src="./resources/logo/category.png" style="width: 20%;display: block;margin: auto;margin-top: 15px;margin-bottom: -10px;"/>'
			+'<h4 style="text-align: center; color: rgb(255, 255, 255, 0.8); font-size: 14px; margin-bottom: 10px;">'+response[i].totalcategories+'</h4>'
			+'<div style="text-align: center; color:rgb(85,206,249);">'
			+'<span style="font-size: 15px;">Categories</span></div></div>'
			+'<div class="col-sm-2"><img src="./resources/logo/brand.png" style="width: 20%;display: block;margin: auto;margin-top: 15px;margin-bottom: -10px;"/><h4 style="text-align: center; color: rgb(255, 255, 255, 0.8); font-size: 14px; margin-bottom: 10px;">'+response[i].totalbrands+'</h4>'
			+'<div style="text-align: center; color:rgb(85,206,249);">' 
			+'<span style="font-size: 15px;">Brands</span></div></div>'
            +'<div class="col-sm-2"><img src="./resources/logo/product.png" style="width: 20%;display: block;margin: auto;margin-top: 15px;margin-bottom: -10px;"/><h4 style="text-align: center; color: rgb(255, 255, 255, 0.8); font-size: 14px; margin-bottom: 10px;">'+response[i].totalproducts+'</h4>'
			+'<div style="text-align: center; color:rgb(85,206,249);">'
			+'<span style="font-size: 15px;">Products</span></div></div>'
			+'<div class="col-sm-2"><img src="./resources/logo/airtime.png" style="width: 20%;display: block;margin: auto;margin-top: 15px;margin-bottom: -10px;"><h4 style="text-align: center; color: rgb(255, 255, 255, 0.8); font-size: 14px; margin-bottom: 10px;">'+response[i].totalairtime+'</h4>'
			+'<div style="text-align: center; color:rgb(85,206,249);">'
		    +'<span style="font-size: 15px;">Airtime</span></div></div>'
            +'<div class="col-sm-2"><img src="./resources/logo/video.png" style="width: 20%;display: block;margin: auto;margin-top: 15px;margin-bottom: -10px;"><h4 style="text-align: center; color: rgb(255, 255, 255, 0.8); font-size: 14px; margin-bottom: 10px;">'+response[i].totalplayout+'</h4>'
			+'<div style="text-align: center; color:rgb(85,206,249);"><span style="font-size: 15px;">Playout</span></div></div>'
			+'<div class="col-sm-2"><img src="./resources/logo/inr.png" style="width:20%;display: block;margin: auto;margin-top: 15px;margin-bottom: -10px;"><h4 style="text-align: center; color: rgb(255, 255, 255, 0.8); font-size: 14px; margin-bottom: 10px;">'+currencyFormatter(response[i].spend, 2)+'</h4>'
		    +'<div style="text-align: center; color:rgb(85,206,249);">'
		    +'<span style="font-size: 15px;">Spend</span></div></div>'  
		    datadiv.append(html);       
        
        }    
        }, 
        error:function(){
        }
    });
	 
}   


function getTopProducts(date1,date2,daterangetext) {
	obj = { 
		startdate :fromdate,
		enddate :todate,   
		limit : "",
		time : selectedVal,
		genre : genre, 
		streamname : channelid,
		productname : products
	}; 
	$.ajax({
		type : 'POST',
		url : contextpath + "/TopProducts",
		async: true,
		data : JSON.stringify(obj),
		contentType : "application/json",
		dataType : 'html',
		
		/*'beforeSend': function () {
			$.blockUI({ message: null }); 
		},
		'complete' : function(request) {
			 $.unblockUI();
		},*/
		success : function(data) {
			var objResponse = $.parseJSON(data);
			topProductsGraph(objResponse,date1,date2,daterangetext);
		},
		error : function() {
		}
	});
} 

function getTopChannelsSingleProduct(chartId,colorCode1, colorCode2) {
	$.ajax({
		type : 'POST',
		url : contextpath + "/ChannelsList",
		data : JSON.stringify(obj),
		contentType : "application/json",
		dataType : 'html',
		beforeSend : function() {
			$("#loading-image").show();
		},
		success : function(data) {
			var resp = "";
			var productnamearr = [];
			var obj2;
			var duration_name;
			resp = $.parseJSON(data);
			
			topChannelHighchart(resp, chartId);
			topChannelHighchart2(resp, chartId,colorCode1, colorCode2);
			$("#loading-image").hide();
		},
		error : function() {
		}
	});
} 

function getTopChannels(date1,date2,colorclass1,colorclass2,text,id) {
	$.ajax({  
				type : 'POST',
				url : contextpath + "/ChannelsList",
				data : JSON.stringify(obj),
				contentType : "application/json",
				dataType : 'html',
				beforeSend : function() {
					$("#loading-image").show();
				},
				success : function(data) {
					var resp = "";
					var productnamearr = [];
					var obj2;
					var duration_name;
					resp = $.parseJSON(data);
					var chartId = id;
					if (page == 'pd' || page=='cd' || page=='cad' || page=='bd') {
						topChannelHighchart(resp, chartId);
					} else {
									
			/*			$('div[id^="chartLinePurple"]').each(function( ) {
		            if($.trim( $(this).html() ).length==0){
			
			*/
			var slctSubcat=$("#"+id+"");
			var Html = "";
			slctSubcat.empty();

						for (var i = 0; i < resp.length; i++) {
							 var airtimeformat;
		                     if(resp[i].duration_name=='Playout'){
		                    	 airtimeformat=resp[i].timeduration; 
		                     }
		                     else{
		                    	 airtimeformat=toHHMMSS(resp[i].timeduration);
		                     }
							
							var streamname=resp[i].streamname;
			            	 var result;
			            	 var maxLength = 20;
			            		 result=streamname;
			            	var percent = (resp[i].timeduration / resp[0].timeduration) * 100;
							if (i % 2 == 0) { 
								Html = "<h6 style='height:1px;font-size:12px;' class='text-muted' data-toggle='tooltip' title='"+streamname+"' ><a href='#' onclick='singleChannelPage2("+resp[i].cid+")' style='color:black;'>"
										+ streamname
										+ "</a></h6><div class='progress progress-sm m-0'><div class='progress-bar "+colorclass1+"' role='progressbar' aria-valuenow='' aria-valuemin='0' aria-valuemax='100' style='width:"
										
										+ parseInt(percent)
										+ "%;'></div> </div>"
										+ "<div class='valueread'>"
										+ airtimeformat
										+ "</div>";
								$("#"+id+"").append(Html);
							} else {
								Html = "<h6 style='height:1px;font-size:12px;' class='text-muted' data-toggle='tooltip' title='"+streamname+"'  ><a href='#' onclick='singleChannelPage2("+resp[i].cid+")'  style='color:black;'>"
										+ streamname
										+ "</a></h6><div  class='progress progress-sm m-0'><div class='progress-bar "+colorclass2+"' role='progressbar' aria-valuenow='' aria-valuemin='0' aria-valuemax='100' style='width:"
										+ parseInt(percent)
										+ "%;'></div> </div>"
										+ "<div class='valueread'>"
										+ airtimeformat
										+ "</div>";
								$("#"+id+"").append(Html);
							} 
                         
						}
					}
					/*	return false;
		            }*/
		    /*        else{
		            }
						 
						});*/
					//}
					$("#loading-image").hide();
				},
				error : function() {
				}
			});
}  

function getCategoryByProduct(classcolor1,classcolor2,date1,date2,text) {
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
									"<a id='category"+i+"'   href='#' onclick='singleCategoryPage("+i+")' style='color:black;' >" 
									+ result
									+ "</a></h6><div class='progress progress-sm m-0'><div class='progress-bar "+classcolor1+"' role='progressbar' aria-valuenow='' aria-valuemin='0' aria-valuemax='100' style='width:"
									+ parseInt(percent)
									+ "%;'></div> </div>"
									+ "<div class='valueread'>"
									+ airtimeformat + "</div>";
							$('.chart-area2').append(Html);
						} else {
							Html = "<h6 style='height:1px;font-size:12px;' class='text-muted' data-toggle='tooltip'    title='"+categoryname+"' >" +
							"<a id='category"+i+"'   href='#' onclick='singleCategoryPage("+i+")'  style='color:black;'>" 
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

function getLanguageData(colorclass1,colorclass2,id) {
	$.ajax({
				type : 'POST',
				url : contextpath + "/getDataByLanguage",
				contentType : "application/json",
				dataType : 'html',
				data : JSON.stringify(obj),
				beforeSend : function() {
					$("#loading-image").show();
				},
				success : function(data) {
					var objResponse = $.parseJSON(data);
	
					if (page == 'pd' || page=='cd' || page=='cad' || page=='bd') {

						// This is language graph function
						// byLanguageGraph(objResponse);

						// Below code until for loop is for progress bar
						var Html = "";
						var slctSubcat = $("#language-Progress-Bar");
						slctSubcat.empty();

						for (var i = 0; i < objResponse.length; i++) {
							var objResponse = $.parseJSON(data);
						 	 var language=objResponse[i].language;
			            	 var result;
			            	 var maxLength = 20;
			                 var airtimeformat;
		                     if(objResponse[i].duration_name=='Playout'){
		                    	 airtimeformat=objResponse[i].timeduration; 
		                     }
		                     else{
		                    	 airtimeformat=toHHMMSS(objResponse[i].timeduration);
		                     }
			            	 
			            	 
		                     
		                     	 result=language;
			            	 
							var percent = (objResponse[i].timeduration / objResponse[0].timeduration) * 100;
							if (i % 2 == 0) {
								Html = "<h6 style='height:1px;font-size:12px;' class='text-muted' data-toggle='tooltip' title='"+language+"' >"
										+ result
										+ "</h6><div class='progress progress-sm m-0'><div class='progress-bar progress-bar-success' role='progressbar' aria-valuenow='' aria-valuemin='0' aria-valuemax='100' style='width:"
										+ parseInt(percent)
										+ "%;'></div> </div>"
										+ "<div class='valueread'>"
										+ airtimeformat
										+ "</div>";
								$('#language-Progress-Bar').append(Html);
							} else {
								Html = "<h6 style='height:1px;font-size:12px;' class='text-muted' data-toggle='tooltip' title='"+language+"'>"
										+ result
										+ "</h6><div  class='progress progress-sm m-0'><div class='progress-bar progress-bar-success2' role='progressbar' aria-valuenow='' aria-valuemin='0' aria-valuemax='100' style='width:"
										+ parseInt(percent)
										+ "%;'></div> </div>"
										+ "<div class='valueread'>"
										+ airtimeformat
										+ "</div>";
								$('#language-Progress-Bar').append(Html);
							}

						}

					} else {
						var Html = "";
						var slctSubcat =$("#"+id+"");
						slctSubcat.empty();
					var Html="";	
					
						for (var i = 0; i < objResponse.length; i++) {
							var percent = (objResponse[i].timeduration / objResponse[0].timeduration) * 100;
							 var language=objResponse[i].language;
			            	 var result;
			            	 var airtimeformat;
		                     if(objResponse[i].duration_name=='Playout'){
		                    	 airtimeformat=objResponse[i].timeduration; 
		                     }
		                     else{
		                    	 airtimeformat=toHHMMSS(objResponse[i].timeduration);
		                     }
			            	 var maxLength = 20;
			            	 	 result=language;
							if (i % 2 == 0) {
								Html = "<h6 style='height:1px;font-size:12px;' class='text-muted'  data-toggle='tooltip' title='"+language+"' >"
										+ result
										+ "</h6><div class='progress progress-sm m-0'><div class='progress-bar "+colorclass1+"' role='progressbar' aria-valuenow='' aria-valuemin='0' aria-valuemax='100' style='width:"
										+ parseInt(percent)
										+ "%;'></div> </div>"
										+ "<div class='valueread'>"
										+ airtimeformat
										+ "</div>";
								slctSubcat.append(Html);
							} else {  
								Html = "<h6 style='height:1px;font-size:12px;' class='text-muted' data-toggle='tooltip' title='"+language+"'  >"
										+ result
										+ "</h6><div  class='progress progress-sm m-0'><div class='progress-bar "+colorclass2+"' role='progressbar' aria-valuenow='' aria-valuemin='0' aria-valuemax='100' style='width:"
										+ parseInt(percent)
										+ "%;'></div> </div>"
										+ "<div class='valueread'>"
										+ airtimeformat
										+ "</div>";
								slctSubcat.append(Html);
							}

						}
					
						/*var slctSubcat = $("#languageDiv");

						var Html = "";
						slctSubcat.empty();
						for (var i = 0; i < objResponse.length; i++) {
							var maxLength = 20;
							var language = objResponse[i].language;
							var result;
							Html = "<div class='element-list-singlePg' ><p> <a style='color:rgb(111,208,206);' href='#'>"
									+ language
									+ "</a></p><span> "
									+ objResponse[i].timeduration + "</span></div>";
							$('#languageDiv').append(Html);
						}*/
					}

					$("#loading-image").hide();
				},
				error : function() {
				}
			});
}

function hourlyPlayoutData(url,gradientColor1, gradientColor2, opacity,id) {
	$.ajax({
		type : 'POST',
		url : contextpath + url,
		contentType : "application/json",
		dataType : 'html',
		data : JSON.stringify(obj),
		beforeSend : function() {
			$("#loading-image").show();
		},
		success : function(data) {
			//hourghlyplayout(data);
			hourghlyplayout(data,gradientColor1, gradientColor2, opacity,id);
			
			$("#loading-image").hide();
			/*
			 * var timeduration=[]; var hours=[]; var
			 * response=$.parseJSON(data); var duration_name;
			 * hourlyPlayout.push(response); for(var i=0;i<response.length;i++){
			 * timeduration.push(response[i].timeduration);
			 * hours.push(response[i].hours);
			 * duration_name=response[0].duration_name; }
			 */

		},
		error : function() {
		}
	});

}


function hourlyPlayoutData2(url,gradientColor1, gradientColor2, opacity,id,descvalue,dropdownid) {
	
	obj = {
			startdate : startdate,
			enddate : enddate,
			time : selectedVal,
			productname : product,
			description:descvalue
		};

	$.ajax({
		
		
		type : 'POST',
		url : contextpath + url,
		contentType : "application/json",
		dataType : 'html',
		data : JSON.stringify(obj),
		beforeSend : function() {
			$("#loading-image").show();
		},
		success : function(data) {
			//hourghlyplayout(data);
			hourghlyplayout2(data,gradientColor1, gradientColor2, opacity,id,dropdownid);
			
			$("#loading-image").hide();
			/*
			 * var timeduration=[]; var hours=[]; var
			 * response=$.parseJSON(data); var duration_name;
			 * hourlyPlayout.push(response); for(var i=0;i<response.length;i++){
			 * timeduration.push(response[i].timeduration);
			 * hours.push(response[i].hours);
			 * duration_name=response[0].duration_name; }
			 */

		},
		error : function() {
		}
	});

}


function dailyPlayoutData(url,gradientColor1, gradientColor2, opacity,id) {

	$.ajax({
		type : 'POST',
		url : contextpath + url,
		contentType : "application/json",
		dataType : 'html',
		data : JSON.stringify(obj),
		beforeSend : function() {
			$("#loading-image").show();
		},
		success : function(data) {
			var timeduration = [];
			var date = [];
			var duration_name;
			var response = $.parseJSON(data);
			dailyplayoutgraph(response,gradientColor1, gradientColor2, opacity,id);
			$("#loading-image").hide();
		},
		error : function() {
		}
	});

}


   
function getTopGenre(colorclass1,colorclass2,id) {
	$
			.ajax({
				type : 'POST',
				url : contextpath + "/getTopGenreByProduct",
				data : JSON.stringify(obj),
				contentType : "application/json",
				dataType : 'html',
				success : function(data) {
					var resp = $.parseJSON(data);
					var Html = "";
    				var slctSubcat = $("."+id+"");
    				slctSubcat.empty();
 
    				for (var i = 0; i < resp.length; i++) {
    					 var genre=resp[i].genre;
    	            	 var result;
    	            	 var maxLength = 20;
    	            	 var airtimeformat;
	                     if(resp[i].duration_name=='Playout'){
	        
	                    	 airtimeformat=resp[i].timeduration; 
	                     }
	                     else{
	                    	 airtimeformat=toHHMMSS(resp[i].timeduration);
	                     }
    	            		 result=genre;
    	            	 
    					var percent = (resp[i].timeduration / resp[0].timeduration) * 100;
    					if (i % 2 == 0) {
    						Html = "<h6 style='height:1px;font-size:12px;' class='text-muted'  data-toggle='tooltip' title='"+genre+"'>"
    								+ genre
    								+ "</h6><div class='progress progress-sm m-0'><div class='progress-bar "+colorclass1+"' role='progressbar' aria-valuenow='' aria-valuemin='0' aria-valuemax='100' style='width:"
    								+ parseInt(percent)
    								+ "%;'></div> </div>"
    								+ "<div class='valueread'>"
    								+ airtimeformat
    								+ "</div>";
    						slctSubcat.append(Html);
    					} else {
    						Html = "<h6 style='height:1px;font-size:12px;' class='text-muted' data-toggle='tooltip' title='"+genre+"' >"
    								+ genre
    								+ "</h6><div  class='progress progress-sm m-0'><div class='progress-bar "+colorclass2+"' role='progressbar' aria-valuenow='' aria-valuemin='0' aria-valuemax='100' style='width:"
    								+ parseInt(percent)
    								+ "%;'></div> </div>"
    								+ "<div class='valueread'>"
    								+ airtimeformat
    								+ "</div>";
    						
    						slctSubcat.append(Html);
    					}
    				}	     


            
								},
				error : function() {
				}
			}); 
}
   
function searchFilter(inputElement) {
    var input, filter, ul, li, a, i, txtValue;
    filter = inputElement.val().toUpperCase();
    ul = document.getElementById(inputElement.attr("ref"));
    li = ul.getElementsByTagName("li");
    for (i = 0; i < li.length; i++) {
        a = li[i];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.visibility = "visible";
            li[i].style.height = "20px";
            li[i].style.position = "relative";
            li[i].style.left = ""; 
        } else { 
        	  li[i].style.visibility = "hidden";
              li[i].style.height = "0px";
              li[i].style.position = "absolute";
              li[i].style.left = "-1000px";
        } 
    }  
}


function getProductcount(){
	   $.ajax({
			type : 'GET',
			url : contextpath + "/TotalProducts",
			contentType : "application/json",
	        dataType: 'html', 
			success : function(data) {
		    var countdata=$("#ProductCount");
		   countdata.empty();
		   countdata.text(data);						
			},
			error : function() {
			} 
		});
}
function singleProductPage(pro){
	var product_name=(document.getElementById("product"+pro).text).trim();
	allgraph();
		dateselecteddata();
	  var	objdata = { 
			startdate : fromdate,
			enddate : todate,
			product : product_name.replace(/'/g,"\\\'"),
			datetext:datelabel,
		}; 
	  SingleProductAjax(objdata);
}


function singleProductPage2(pro){
	var product_name=(document.getElementById("product"+pro).text).trim();
	allgraph();
		dateselecteddata();
	  var	objdata = {
			startdate : startdate,
			enddate : enddate,
			product : product_name.replace(/'/g,"\\\'"),
			datetext:datetextdata,
		}; 
	  SingleProductAjax(objdata);
}
function getDates(){
	var today = new Date();
	var date2 = new Date();
	date2.setDate(date2.getDate() - 6);

	var month1=(today.getMonth()+1);
	var day1=today.getDate();
	if(month1<10){
		month1='0'+month1;	
	}
	if(day1<10){
		day1='0'+day1;	
	}
	var month2=(date2.getMonth()+1);
	var day2=date2.getDate();
	if(month2<10){
		month2='0'+month2;	
	}
	
	if(day2<10){
		day2='0'+day2;	
	}
	begindate =date2.getFullYear()+'-'+month2+'-'+day2;	
	finalDate= today.getFullYear()+'-'+month1+'-'+day1;
}

 
function ProductSearch(pro,j,k){ 
	getDates();
	var product_name="";
	if(j==1){
		console.log("SingleProduct"+pro);
		product_name	=($("#searchdatalist .search-li  #SingleProduct"+pro).val()).trim();
		
	}
	else 	if(j==2){
		product_name	=($("#cardList .card-li .thumb #SingleProduct"+pro).val()).trim();
		
	}

	allgraph();
		dateselecteddata();
	  var	objdata = {
			startdate : begindate,
			enddate : finalDate,
			product : product_name.replace(/'/g,"\\\'"),
			datetext:"",
			card:k
		}; 
	  SingleProductAjax(objdata);
}

function SingleProductAjax(senddata){
	$.ajax({ 
		type : 'POST',
		url : contextpath + "/SingleProduct",
		data : JSON.stringify(senddata),
		contentType : "application/json",
		dataType : 'html',
		success : function(data) {
        window.location.href='./SingleProductDashboard';
		},
		error : function() {
		}
	}); 
}
  
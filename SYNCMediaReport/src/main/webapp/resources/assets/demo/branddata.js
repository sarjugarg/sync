var brandHourlyUrl="/getHourlyPlayoutByBrand";
var brandDailyUrl="/getDailyPlayoutByBrand";


$(document).ajaxStart(function() {
	$.blockUI({ message: $('<img src="./resources/images/loader.gif" />') });
	$(".blockPage").css({ 'background-color' : '', 'border' : '' });
});

$(document).ajaxStop(function() {
	$.unblockUI();
});

function allOnloadBrandGraph(page){
	
	allgraph(); 
	dateselecteddata();
    obj={startdate:fromdate,
            enddate:todate,
            limit:limit,
            time:selectedVal,
            genre:genre,
            streamname : channelid, 
            brandname:brands
           // productname:product
   };
     

//	getTopChannels(fromdate,todate,'progress-bar-success1','progress-bar-success2',escape(datelabel),topchannel);
	getTopBrands('progress-bar-success','progress-bar-success2', '.topbrands', fromdate,todate,escape(datelabel));
    getTopGenre('progress-bar-success','progress-bar-success2',topgenre);
	getLanguageData('progress-bar-success','progress-bar-success2');
    hourlyPlayoutData(brandHourlyUrl,'rgb(85, 206, 249)', 'rgb(85, 206, 249)', 0.4,hourlyid);
	dailyPlayoutData(brandDailyUrl,'rgb(85, 206, 249)', 'rgb(85, 206, 249)', 0.4,dailyid);
	getBrandList(fromdate,todate,escape(datelabel));
	//getChannelsList(fromdate,todate);
}


function getTopBrands(colorclass1, colorclass2, div, date1, date2,text) {
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
						+ ' style="color:black;" onclick="singleBrandPage('+i+')">'
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


function singleBrandChartReload(page) {
//alert("inside single brand function");
	var selectedVal;
	var selected = $("input[name='options']:checked");
	if (selected.length > 0) {
		selectedVal = selected.val();
	}
//alert("id in single brand"+dailyid);
//alert("brandname= "+ brandname);
	obj = {
		startdate : startdate,
		enddate : enddate,
		time : selectedVal, 
		brandname : brand.replace(/'/g,"\\\'")
	};
	dateselectedOnSinglePage();
	getTopChannels(startdate,enddate,'progress-bar-success-brand1','progress-bar-success-brand2',escape(datetextdata),topchannel);
	getTopGenre('progress-bar-success-brand1','progress-bar-success-brand2',topgenre);
	getLanguageData('progress-bar-success-brand1','progress-bar-success-brand2',toplanguage);
	hourlyPlayoutData(brandHourlyUrl,'rgb(205, 83, 124)', 'rgb(210, 200, 200)', 0.4,hourlyid); 
	dailyPlayoutData(brandDailyUrl,'rgb(235, 73, 96)', 'rgb(253, 206, 170)', 0.4,dailyid);
	getTopChannelsSingleProduct('topChannelDonut','rgb(205, 83, 124)','rgb(235, 73, 96)');  
}

 

function singleProductGraphContentDesc(page) {
	$('div[class^="desc"]').each(function( ) {
		var desp=$(this).find('#description').val();
		var descdiv=$(this).attr('class');
		var descountdata=desccount+descdiv;
	var selectedVal;
	var selected = $("input[name='options']:checked");
	if (selected.length > 0) {
		selectedVal = selected.val();
	}

	
	obj = {
		startdate : startdate,
		enddate : enddate,
		time : selectedVal,
		productname : desp.replace(/'/g,"\\\'"),
		brandname : brand.replace(/'/g,"\\\'")
	};
	dateselectedOnSinglePage();
	getTopChannels(startdate,enddate,'progress-bar-success-brand1','progress-bar-success-brand2',escape(datetextdata),topchannel+descdiv);
	getTopGenre('progress-bar-success-brand1','progress-bar-success-brand2',topgenre+descdiv);
	getLanguageData('progress-bar-success-brand1','progress-bar-success-brand2',toplanguage+descdiv);
	hourlyPlayoutData(producthourlyplayout,'rgb(205, 83, 124)', 'rgb(210, 200, 200)', 0.4,hourlyid+descdiv); 
	dailyPlayoutData(productdailyplayout,'rgb(235, 73, 96)', 'rgb(253, 206, 170)', 0.4,dailyid+descdiv);
	getTopChannelsSingleProduct(singleTopChannel+descdiv,'rgb(205, 83, 124)','rgb(235, 73, 96)');
	});
}



function singleProductChartByDesc(page) {
	$('div[class^="desc"]').each(function( ) {
		var desp=$(this).find('#description').val();
		var descdiv=$(this).attr('class');
	//	alert("inside single product by brand");
		//alert("daily id in function"+dailyid+descdiv);
		var descountdata=desccount+descdiv;
		var selectedVal;
	var selected = $("input[name='options']:checked");
	if (selected.length > 0) {
		selectedVal = selected.val();
	}

	obj = {
		startdate : startdate,
		enddate : enddate,
		time : selectedVal,
		productname : desp.replace(/'/g,"\\\'"),
		brandname : brand.replace(/'/g,"\\\'")
	};
	dateselectedOnSinglePage();
	getTopChannels(startdate,enddate,'progress-bar-success-brand1','progress-bar-success-brand2',escape(datetextdata),topchannel+descdiv);
	getTopGenre('progress-bar-success-brand1','progress-bar-success-brand2',topgenre+descdiv);
	getLanguageData('progress-bar-success-brand1','progress-bar-success-brand2',toplanguage+descdiv);
	hourlyPlayoutData(producthourlyplayout,'rgb(205, 83, 124)', 'rgb(210, 200, 200)', 0.4,hourlyid+descdiv); 
	dailyPlayoutData(productdailyplayout,'rgb(235, 73, 96)', 'rgb(253, 206, 170)', 0.4,dailyid+descdiv);
	getTopChannelsSingleProduct(singleTopChannel+descdiv,'rgb(205, 83, 124)','rgb(235, 73, 96)');
	dynamicSingleProductCounts(descountdata);
	});
}


function dynamicSingleProductCounts(abc){
	//alert(desccount);
	$.ajax({
		type : 'POST',
		url : contextpath + '/BrandByEachProduct',
		contentType : "application/json",
		dataType : 'html',
		data : JSON.stringify(obj),
		success : function(data) {
		//alert(data);
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
				    +'<div><img src='+imglogo.replace(/ /g, "%20")+' /></div></div>'
					+'<div class="col-sm-6" style="width: 90%; margin-bottom: 20px;">'
					+'<div class="sinlgePg_cat_lang"><div style="color:#FFFFFF;;"><span title="'+response[i].productname+'" style="border-bottom: 1px solid rgb(235, 73, 96); font-size: 21px;">'+response[i].productname+'</span></div>'
					+'<div style="padding-top: 35px;"><span title="'+response[i].categoryname+'" style="font-size: 13px; color:rgb(235, 73, 96);"><label style="font-weight:200; color:rgb(255, 255, 255, 0.8);">Category: </label> '+response[i].categoryname+' </span></div>'
					+'<div ><span title="'+response[i].language+'"  style="font-size: 13px; color:rgb(205, 83, 124);"><label style="font-weight:200; color:rgb(255, 255, 255, 0.8);">Language: </label> '+response[i].language+'</span></div>'
					+'</div></div></div><div class="col-sm-6"><div class="singlePg_sm_div dark"><h4 '
					+' style="text-align: center; color: rgb(235, 73, 96); font-size: 14px; margin-bottom: 10px;">Playouts</h4>'
					+'<div style="text-align: center; color:#FFFFFF;"><span style="font-size: 24px;">'+response[i].count+''
					+'</span></div></div><div class="singlePg_sm_div dark">'
					+'<h4 style="text-align: center; color: rgb(235, 73, 96); font-size: 14px; margin-bottom: 10px;">Spend</h4>'
					+'<div style="text-align: center; color:#FFFFFF;"><span style="font-size: 25px;"> '+currencyFormatter(response[i].spend,2)+' </span>'
					+'</div></div></div><div class="col-sm-6"><div class="singlePg_sm_div dark">'
					+'<h4 style="text-align: center; color: rgb(205, 83, 124); font-size: 14px; margin-bottom: 10px;">Airtime</h4>'
					+'<div style="text-align: center; color:#FFFFFF;"><span style="font-size: 25px;">'
					+''+response[i].Airtime+'</span></div></div><div class="singlePg_sm_div dark">'
				    +'<h4 style="text-align: center; color: rgb(205, 83, 124); font-size: 14px; margin-bottom: 10px;">Channels</h4>'
					+'<div style="text-align: center; color:#FFFFFF;"> <span style="font-size: 24px;">'
					+''+response[i].cid+'</div></div></div></div>';
				//alert(html);
				selectdiv.prepend(html);
		
			}
		
		},
		error : function() {
		}
	});

	//var selectdiv=$(".countdiv1 .row1 .column1");
}




function getBrandList(date1,date2,text){
    obj={startdate:fromdate,
            enddate:todate,
            limit:"",
            time:selectedVal,
            genre:genre,
            streamname : channelid, 
            brandname:brands
           // productname:product
   };
	$.ajax({
        type: 'POST',
        url:contextpath+"/BrandList" ,
        async: true,
        data: JSON.stringify(obj),
        contentType: "application/json",
	    dataType: 'html',
        success: function(data){
        	//alert(data);
         var objResponse=$.parseJSON(data);
         //channelsListGraph(objResponse,date1,date2);
         
         var slctSubcat= $(".BrandList");
         var Html="";  
         //alert(objResponse)
              slctSubcat.empty(); 
                  for(var i=0; i<objResponse.length; i++){
                 	 var maxLength = 20;
                 	 var brand=objResponse[i].brand;
                 	 var result;
                 	 var time_duration=""; 
                	 if(objResponse[i].duration_name=='Playout'){
                		 time_duration= objResponse[i].timeduration;
                	 } 
                	 else{
                		 time_duration=toHHMMSS(objResponse[i].timeduration); 
                	 }
                 		 result=brand;
                 		 var logo=objResponse[i].logoUrl+objResponse[i].logo;
                 
                	   if(objResponse[i].logo=='NA'){ 
             		   Html='<div class="element-list" data-toggle="tooltip" title="'+brand+'"><div class="Pr-logo" style="position:relative;" ><img style="position:absolute;margin:auto;" onerror="this.src="./resources/images/no_img.png""   src="./resources/images/no_img.png" /></div> <p> <a style="color:rgb(85,206,249);" href="#" id="brand'+i+'" onclick="singleBrandPage('+i+')" > '+result+'</a></p><span >  '  + time_duration+'</span></div>';
                        $('.BrandList').append(Html);         
             	   }else{ 
             		   Html='<div class="element-list" data-toggle="tooltip" title="'+brand+'"><div class="Pr-logo" style="position:relative;" ><img style="position:absolute;margin:auto;" onerror="this.src="./resources/images/no_img.png""   src='+logo.replace(/ /g, "%20")+' /> </div><p> <a style="color:rgb(85,206,249);" href="#" id="brand'+i+'" onclick="singleBrandPage('+i+')"> '+result+'</a></p><span >  '  + time_duration+'</span></div>';
                      $('.BrandList').append(Html);       
             	   }
                            
                  }    
        }, 
        error:function(){
        	//alert("fail")
        }
    });
}	

function getBrandcount(){
	   $.ajax({
			type : 'GET',
			url : contextpath + "/TotalBrands",
			contentType : "application/json",
	        dataType: 'html', 
			success : function(data) {
				var countdata=$("#BrandCount");
				countdata.empty();
				countdata.text(data);						
			},
			error : function() {
			} 
		});
}


 
function singleBrandPage(brands){
	var brand_name=(document.getElementById("brand"+brands).text).trim();
	allgraph();
		dateselecteddata();
	  var	objdata = {
			startdate : fromdate,
			enddate : todate,
			brand : brand_name.replace(/'/g,"\\\'"),
			datetext:datelabel,
		}; 
	  singleBrandAjax(objdata);
  
} 

function singleBrandPage2(brands){
	var brand_name=(document.getElementById("brand"+brands).text).trim();
	allgraph();
		dateselecteddata();
	  var	objdata = {
			startdate : startdate,
			enddate : enddate,
			brand : brand_name.replace(/'/g,"\\\'"),
			datetext:datetextdata,
		}; 
	  singleBrandAjax(objdata);
  
}
          


function BrandSearch(brands,j,k){
	getDates();
	var brand_name;
	if(j==1){
		brand_name=($("#searchdatalist .search-li  #SingleBrand"+brands).val()).trim();
		
	}
	else 	if(j==2){
		brand_name=($("#cardList .card-li .thumb #SingleBrand"+brands).val()).trim();
		
	}
	allgraph();
		dateselecteddata();
	  var	objdata = {
				startdate : begindate,
				enddate : finalDate,
  			brand : brand_name.replace(/'/g,"\\\'"),
			datetext:"",
			card:k
		};  
	  singleBrandAjax(objdata);
}
function singleBrandAjax(ajaxobj){
	$.ajax({
		type : 'POST',
		url : contextpath + "/SingleBrand",
		data : JSON.stringify(ajaxobj),
		contentType : "application/json",
		dataType : 'html',
		success : function(data) {
        window.location.href='./SingleBrandDashboard';
		},
		error : function() {
		}
	}); 
 	
}    
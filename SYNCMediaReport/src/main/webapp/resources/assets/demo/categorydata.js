var categoryHourlyUrl="/getHourlyPlayoutByCategory";
var categoryDailyUrl="/getDailyPlayoutByCategory";
//getDatabyProduct
$(document).ajaxStart(function() {
	$.blockUI({ message: $('<img src="./resources/images/loader.gif" />') });
	$(".blockPage").css({ 'background-color' : '', 'border' : '' });
});

$(document).ajaxStop(function() {
	$.unblockUI();
});

function allOnloadCategoryGraph(page){
	allgraph();
	dateselecteddata();
    obj={startdate:fromdate,
            enddate:todate,
            limit:limit, 
            time:selectedVal,
            genre:genre,
            streamname : channelid, 
           // productname:product
   };
    
	//getTopChannels(fromdate,todate,'progress-bar-success','progress-bar-success2',escape(datelabel),topchannel);
	getCategoryByProduct('progress-bar-success','progress-bar-success2',fromdate,todate,escape(datelabel));
    getLanguageData();
	getTopGenre('progress-bar-success','progress-bar-success2','genredata');
    hourlyPlayoutData(categoryHourlyUrl,'rgb(85, 206, 249)', 'rgb(85, 206, 249)', 0.4,hourlyid);
	dailyPlayoutData(categoryDailyUrl,'rgb(85, 206, 249)', 'rgb(85, 206, 249)', 0.4,dailyid);
	getCategoryList(fromdate,todate,escape(datelabel));
	//getChannelsList(fromdate,todate);
}

function singleCategoryChartReload(page) {
allgraph();	
var selectedVal;
	var selected = $("input[name='options']:checked");
	if (selected.length > 0) {
		selectedVal = selected.val();
	}

	obj = {
		startdate : startdate,
		enddate : enddate,
		time : selectedVal,
		category : category
	};
	dateselectedOnSinglePage();
	getTopChannels(startdate,enddate,'progress-bar-success-category1','progress-bar-success-category2',escape(datetextdata),topchannel);
	getDataByProducts(startdate,enddate,'progress-bar-success-category1','progress-bar-success-category2','.chart-area2',escape(datetextdata));
	hourlyPlayoutData(categoryHourlyUrl,'rgb(234, 95, 153)', 'rgb(241, 105, 91)', 0.3,hourlyid); 
	dailyPlayoutData(categoryDailyUrl,'rgb(37, 159, 173)', 'rgb(22, 218, 189)', 0.3,dailyid);  
	getTopChannelsSingleProduct('topChannelDonut','rgb(22, 218, 189)', 'rgb(241, 105, 91)'); 
	SingleBrandData('progress-bar-success-category1','progress-bar-success-category2','#languageDiv',startdate,enddate,escape(datetextdata));

}



function getCategoryList(date1,date2,text){
    obj={startdate:fromdate,
            enddate:todate,
            limit:"",  
            time:selectedVal,
            genre:genre,
            streamname : channelid, 
   };

	$.ajax({
        type: 'POST',
        url:contextpath+"/CategoryList" ,
        async: true,
        data: JSON.stringify(obj),
        contentType: "application/json",
	    dataType: 'html',
        success: function(data){
         var objResponse=$.parseJSON(data);
         //channelsListGraph(objResponse,date1,date2);
         
         var slctSubcat= $(".CategoryList");
         var Html="";  
              slctSubcat.empty(); 
                  for(var i=0; i<objResponse.length; i++){
                 	 var maxLength = 20;
                 	 var categoryname=objResponse[i].categoryname;
                 	 var category=''+categoryname+'';
                 	 var result;
                 	 var time_duration=""; 
                	 if(objResponse[i].duration_name=='Playout'){
                		 time_duration= objResponse[i].timeduration;
                	 } 
                	 else{
                		 time_duration=toHHMMSS(objResponse[i].timeduration); 
                	 }
        		 result=categoryname;
                        var logo;
                	   if(objResponse[i].logo=='NA'){
             		   logo='./resources/images/no_img.png';
                	   }
                	   else{
                		  logo=objResponse[i].logoUrl+objResponse[i].logo; 
                	   }  
                      Html='<div class="element-list"  data-toggle="tooltip" title="'+categoryname+'" ><div class="Pr-logo" style="position:relative;" ><img  style="position:absolute;margin:auto;" onerror="this.src="./resources/images/no_img.png"" class="hov"   src="'+logo.replace(/ /g, "%20")+'" /></div> <p> <a style="color:rgb(85,206,249);" id="category'+i+'" onclick="singleCategoryPage('+i+')"  href="#">'+unescape(categoryname)+'</a></p><span > '+time_duration+'</span></div>';
                      $('.CategoryList').append(Html);        
                          }     
        }, 
        error:function(){
        	//alert("fail")
        }
    });
}	



function getAllCategories(){
	   $.ajax({
			type : 'GET',
			url : contextpath + "/TotalCategories",
			contentType : "application/json",
	        dataType: 'html', 
			success : function(data) {
				var response = $.parseJSON(data);
				var countdata=$("#Categorycount");
				countdata.empty();
				for(var i=0; i< response.length;i++){
			    countdata.text(response[i].categoryname);						
				}
			},
			error : function() {
			} 
		});
}

function singleCategoryPage(categ){
	var category_name=(document.getElementById("category"+categ).text).trim();
	allgraph();
		dateselecteddata();
	  var	objdata = {
			startdate : fromdate,
			enddate : todate,
			category : category_name.replace(/'/g,"\\\'"),
			datetext:datelabel,
		}; 
	  SingleCategoryAjax(objdata);		
}
          



function singleCategoryPage2(categ){
	var category_name=(document.getElementById("category"+categ).text).trim();
	allgraph(); 
		dateselecteddata();
	  var	objdata = {
			  startdate : startdate,
				enddate : enddate,
			category : category_name.replace(/'/g,"\\\'"),
			datetext:datetextdata,
		};       
	  SingleCategoryAjax(objdata);		
} 
function CategorySearch(categ,j,k){
	var cate_name="";
	if(j==1){
		cate_name=($("#searchdatalist .search-li  #SingleCategory"+categ).val()).trim();
	}
	else 	if(j==2){
		cate_name=($("#cardList .card-li .thumb #SingleCategory"+categ).val()).trim();
	}	
	allgraph();
	getDates();
		dateselecteddata();
	  var	objdata = {
				startdate : begindate,
				enddate : finalDate,
			category : cate_name.replace(/'/g,"\\\'"),
			datetext:"",
			card:k
		}; 
	  SingleCategoryAjax(objdata);		
}
function singleCategoryPage(categ){
	var category_name=(document.getElementById("category"+categ).text).trim();
	allgraph();
		dateselecteddata();
	  var	objdata = {
			startdate : fromdate,
			enddate : todate,
			category : category_name.replace(/'/g,"\\\'"),
			datetext:datelabel,
		}; 
	  SingleCategoryAjax(objdata);		
}
          

function SingleCategoryAjax(ajaxObj){
	$.ajax({
		type : 'POST',
		url : contextpath + "/SingleCategory",
		data : JSON.stringify(ajaxObj),
		contentType : "application/json",
		dataType : 'html',
		success : function(data) {
        window.location.href='./SingleCategoryDashboard';
		},
		error : function() {
		}
	}); 
} 
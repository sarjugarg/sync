
		jQuery(document).ready(function() {
		fetchChannel();
			brandDefaultFilter();
			categoryDefaultFilter();
			endDateProductFilter();
			endDateLanguageFilter();
			ReportTable();
			
		});
//******************************************** ** CLICK FUNCTION **  ****************************************************************************************

		
		

$("#channelfilter ").on("click","li",function(e) {
	 if ($(this).hasClass("ui-selected-multi")) {
		$(this).removeClass(
						"ui-selected ui-selected-multi");
		handleTags2($(this).text(), $(this).attr('id'), "channel",
				"remove");
		////alert("li ////alert");
		channel="";
	} else {
		$(this).addClass(" ui-selected-multi");
		handleTags2($(this).text(), $(this).attr('id'), "channel",
				"add");
	}
	 fetchBrand();
	 //alert(channelidR);
	 /*channelChangeFilter(channelidR);
	 genreFilter(categorysR,channelidR,brandsR,productsR) */
});

$("#brandfilter ").on("click","li",function(e) {
	
	 Brand=encodeURIComponent($(this).text());
		
		 if ($(this).hasClass("ui-selected-multi")) {
			$(this).removeClass(
							"ui-selected ui-selected-multi");
			handleTags2($(this).text(), $(this).attr('id'), "brand",
					"remove");
			Brand="";
			channel="";
		} else {
			$(this).addClass(" ui-selected-multi");
			handleTags2($(this).text(), $(this).attr('id'), "brand",
					"add");
		}
		 fetchCategory();
	});

$("#categoryfilter").on("click","li",function(e) {
	
	category=encodeURIComponent($(this).text());
	
		 if ($(this).hasClass("ui-selected-multi")) {
			$(this).removeClass(
							"ui-selected ui-selected-multi");
			handleTags2($(this).text(), $(this).attr('id'), "category",
					"remove");
			category="";
			channel="";
			Brand="";
		} else {
			$(this).addClass(" ui-selected-multi");
			handleTags2($(this).text(), $(this).attr('id'), "category",
					"add");
		} 
		 feetchProductFilter() ;
	});



$("#productfilter ").on("click","li",function(e) {
	
	product=encodeURIComponent($(this).text());

	 if ($(this).hasClass("ui-selected-multi")) {
			$(this).removeClass(
							"ui-selected ui-selected-multi");
			handleTags2($(this).text(), $(this).attr('id'), "product",
					"remove");
			category="";
			channel="";
			Brand="";
			product="";
		} else {
			$(this).addClass(" ui-selected-multi");
			handleTags2($(this).text(), $(this).attr('id'), "product",
					"add");
		}
	 fetchLanguageFilter();
	 });




$("#languagefilter").on("click","li",function(e) {
	
	language=encodeURIComponent($(this).text());
		 if ($(this).hasClass("ui-selected-multi")) {
			$(this).removeClass(
							"ui-selected ui-selected-multi");
			handleTags2($(this).text(), $(this).attr('id'), "language1",
					"remove");
			category="";
			channel="";
			Brand="";
			product="";
		} else {
			$(this).addClass(" ui-selected-multi");
			handleTags2($(this).text(), $(this).attr('id'), "language1",
					"add");
		} 
});


//******************************************** **END CLICK FUNCTION **  ****************************************************************************************







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
	//alert("inside tag-box2 div");
	if($(this).hasClass("channel")){
		channelIds.push($(this).text());
		//channelIds.push($(this).attr("id").substring(4).replace("_"," "));
		channelidR = "'" + channelIds.join("','") + "'";
	} 
	if($(this).hasClass("genre")){
		genreNames.push($(this).text());
		genreR = "'" + genreNames.join("','") + "'";
		////alert("genre name"+genreR);
	}  
	       
	if($(this).hasClass("product")){
		var productdata=($(this).text()).replace(/'/g,"\\\'");
		productNames.push(productdata);
		productNames2.push($(this).text());
		productsR = "'" +  productNames.join("','") + "'";
		 
		
		////alert("product name"+productsR);
		}
	
	if($(this).hasClass("category")){
		var categorydata=$(this).text();
		categoryNames.push(categorydata);
		categoryNames2.push($(this).text());
		categorysR = "'" +  categoryNames.join("','") + "'";
		////alert("category name="+categorysR);
		}
	
	if($(this).hasClass("brand")){
	brandNames.push($(this).text().replace(/'/g,"\\\'"));
	brandNames2.push($(this).text());
	brandsR = "'" +  brandNames.join("','") + "'";
	////alert("brand="+brandsR)
		}
	
	if($(this).hasClass("language1")){
		languageNames.push($(this).text());
		languageR = "'" +  languageNames.join("','") + "'";
		////alert("language="+languageR);
	}
});	//allgraph();  

}





function handleTags2(selection, selectionId, parent, action) {
	$('.tag-box2').show();
	
	var ul = $(".tag-box2");
	var ids = selectionId.substring(8);
	if (action == 'add'
			&& $(".tag-box2").find("#tag_" + ids).length == 0) {
			$('.tag-box2').append('<li class="tags '+parent+' ui-sortable-handle" id="tag_'+ids+'" >'
								+ selection
								+ '<a class="close"></a></li>');
		$("#tag_" + ids).addClass("tagp");
		multiColumn();
		//allOnloadChannelGraph(page);
	} if(action == 'remove') {
		////alert("function  ////alert");
		////alert("aftre removre channel"+channel);
		$("#tag_" + ids).remove();
		channel="";
		
		var children = $('.tag-box2')
				.children().length;
		if (children == 0) {
			$('.tag-box2').hide();
		}
		multiColumn();
		//allOnloadChannelGraph(page);
	}

	$("#tag_" + ids).on("click",function(e) {
				$("#option2_"+ids).removeClass("ui-selected ui-selected-multi");
				$(this).remove();
				
				////alert("closed channel"+channelidR);
				
			//	channelidR="";
				
				////alert("closed function"+channelidR);
				
				var children = $('.tag-box2')
						.children().length;
				if (children == 0) {
					$('.tag-box2').hide();
				}
						
				//allOnloadChannelGraph(page);
				multiColumn();
			});
}							



//**********************************************AJAX FUNCTION//***************************************************************





function fetchChannel()
{
		
	 $.ajax({
	    	url: contextpath +'/fetchSchedule',
	        processData : false,
	        contentType : false,
	        type : 'POST',
	        success : function(data) {
	        	////alert("sucess");
	        	//console.log(JSON.stringify(data));
	       /* $('#channelfilter').empty();
			$('<option>').val("").text("Select Channel").appendTo('#channelfilter');
	    	for (i = 0; i < data.length; i++){
				$('<option>').val(data[i].streamName).text(data[i].streamName).appendTo('#channelfilter');
				}*/
	        	
	        	
	        	
	        	$('#channelfilter').empty();
	        	//////alert("after date");
	        	var ht='<input type="text"  id="channelSearch" class="search-filter" onkeyup="searchFilter1($(this))" ref="channelfilter" placeholder="Search Channel"/>';
	        	$('#channelfilter').append(ht);
	        	for (var i = 0; i < data.length; i++){
	        		
	        		 var stream=(data[i].channnelName);
	        		 //stream=stream.replace(/\s/g, '_');
  var html='<li   data-toggle="tooltip"   title="'+data[i].channnelName+'"'+ 
  'class="ui-widget-content channel" id="option2_'+stream.replace(/\s/g, '_')+'">'+
''+data[i].channnelName+'</li>';
  $('#channelfilter').append(html);
	        	}
	        },
	        error : function() {
	        	
	        }
	    });
}



function brandDefaultFilter()
{
	
	var formData = new FormData();
/*	var fromdate = $("#startDateSelected").val();
	var todate = $("#endDateSelected").val();*/
	
	$.ajax({
    	url: contextpath +'/brandSchedule',
        processData : false,
        contentType : false,
        type : 'POST',
        success : function(data) {
        /*	
        	$('#brandfilter').empty();
        		 	$('<option>').val("").text("Select Brand").appendTo('#brandfilter');
            	for (i = 0; i < data.length; i++){
        			$('<option>').val(data[i].Brand).text(data[i].Brand).appendTo('#brandfilter');
        			} */
        //	console.log(JSON.stringify(data));
        	
        	$('#brandfilter').empty();
        	var ht='<input type="text"  id="brandfilter" class="search-filter" onkeyup="searchFilter1($(this))" ref="brandfilter" placeholder="Search Brand"/>';
        	$('#brandfilter').append(ht);
        	for (var i = 0; i < data.length; i++){
        		
        var brand=(data[i].brand);	
        
var html='<li   data-toggle="tooltip"  title="'+data[i].brand+'"'+ 
'class="ui-widget-content brand" id="option2_'+brand.replace(/\s/g, '_')+'">'+
''+data[i].brand+'</li>';
$('#brandfilter').append(html); 	
        }
            
        
        
        },
        error : function() {
        	
        }
    });	
	
	}


function categoryDefaultFilter()
{
	
	$.ajax({
    	url: contextpath +'/fetchCategory',
        processData : false,
        contentType : false,
        type : 'POST',
        success : function(data) {
        	
        	//console.log(JSON.stringify(data));
        	$('#categoryfilter').empty();
        	var ht='<input type="text"  id="categoryfilter" class="search-filter" onkeyup="searchFilter1($(this))" ref="categoryfilter" placeholder="Search Category"/>';
        	$('#categoryfilter').append(ht);
        	for (var i = 0; i < data.length; i++){
        		var categ=(data[i].category);
        		//categ=categ.replace(/\s/g, '_');
         		////////alert("category"+categ);
        		var html='<li   data-toggle="tooltip"  title="'+data[i].category+'"'+ 
        		'class="ui-widget-content category" id="option2_'+categ.replace(/\s/g, '_')+'">'+
        		''+data[i].category+'</li>';
        		$('#categoryfilter').append(html); 	
        	}
        },
        error : function() {
        	
        }
    });	
	
	}



function endDateProductFilter() 
{
	 $.ajax({
	    	url: contextpath +'/fetchProduct/',
	        processData : false,
	        contentType : false,
	        type : 'POST',
	        success : function(data) {
	        	
	        	$('#productfilter').empty();
	        	var ht='<input type="text"  id="productfilter" class="search-filter" onkeyup="searchFilter1($(this))" ref="productfilter" placeholder="Search Product"/>';
	        	$('#productfilter').append(ht);
	        	for (var i = 0; i < data.length; i++){
	        		
	        		 var prod=(data[i].product);
	        		 //prod=prod.replace(/\s/g, '_');		 
	var html='<li   data-toggle="tooltip"  title="'+data[i].product+'"'+ 
	'class="ui-widget-content product" id="option2_'+prod.replace(/\s/g, '_')+'">'+
	''+data[i].product+'</li>';
	$('#productfilter').append(html);
	        	}
	        },
	        error : function() {
	        	
	        }
	    });
}



function endDateLanguageFilter() 
{
 

	
	 $.ajax({
	    	url: contextpath +'/fetchLanguage/',
	        processData : false,
	        contentType : false,
	        type : 'POST',
	        success : function(data) {
	      
	        
	        	$('#languagefilter').empty();
	        	var ht='<input type="text"  id="languagefilter" class="search-filter" onkeyup="searchFilter1($(this))" ref="languagefilter" placeholder="Search Language"/>';
	        	$('#languagefilter').append(ht);
	        	for (var i = 0; i < data.length; i++){
	        		
	        		 var lang=(data[i].language);
	        		 //lang=lang.replace(/\s/g, '_'); 
  var html='<li   data-toggle="tooltip"  title="'+data[i].language+'"'+ 
  'class="ui-widget-content language1" id="option2_'+lang.replace(/\s/g, '_')+'">'+
''+data[i].language+'</li>';
  $('#languagefilter').append(html); 	
	        }
	        },
	        error : function() {
	        	
	        }
	    });
}



//********************************************** END OF AJAX FUNCTIONS//***************************************************************

//*********************************************searchFunction*****************************////////////////////////////***********





function searchFilter1(inputElement) {
	
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



//**************************************************** fetch filter data*********************************************************************
function showFilterData()
{
	
	
	var startdate=document.getElementById('datefilterid').value;
	var enddate=document.getElementById('enddate').value;
	

	if(startdate==null || enddate==null || startdate=="" || enddate=="")
		{
	
		document.getElementById("dateSelectMessage").style.display = "block";
		}	
	
	else{
		document.getElementById("dateSelectMessage").style.display = "none";


if(brandsR=='undefined')
{
	brandsR="";
}

if(channelidR=='undefined')
{
	channelidR="";
}

if(categorysR=='undefined')
{
	categorysR="";
}

if(productsR=='undefined')
{
	productsR="";
}

if(languageR=='undefined')
{
	languageR="";
}

//alert("channel name"+channelidR);
//alert("categorys name"+categorysR);
//alert("brands name"+brandsR);
//alert("products name"+productsR);


 var reportmodel=
{
		
		'channnelName':channelidR,
		'category':categorysR,
		'brand':brandsR,
		'product':productsR,
		'language':languageR,
		'startTime':startdate,
		'endTime':enddate,
}
//alert(JSON.stringify(reportmodel));


		
//var CustomerPriceBookReq = {"customerId":customerId,"invType":"C"}; 

$('#sample_1').DataTable({
"destroy":true,
scrollX : true,
scrollY : "395px",
scrollCollapse : true,
//"lengthMenu" : [ [ 15, 25, 50, 100 ], [ 15, 25, 50, 100 ] ],	

'ajax': {
'url': contextpath +'/dataFilterParams',
'type': 'POST',
"contentType": "application/json",
data : function (data) {
return JSON.stringify(reportmodel);
console.log("response data"+data);
}
},

"columns" : [
	{
		"data" : "channnelName"
	},
	{
		"data" : "campaignName"
	},

	{
		"data" : "startdDate"
	},

	{
		"data" : "enddDate"
	},
	{
		"data" : "spotCount"
	},

	{
		"data" : "actualCount"
	},
	{
		"data" : "cost"
	},
	{
		"data" : "brand"
	},

	{
		"data" : "product"
	},
	{
		"data" : "category"
	},
	{
		"data" : "sub_category"
	},
	{
		"data" : "language"
	},
	{
		"data" : "description"
	}
	],
"columnDefs" : [ {
"defaultContent" : "",
"targets" : "_all"
} ]
} );

}
	

		

}
//*******************************************             DATA TABLE      ****************************************************************************************/////////




function ReportTable(){ 
	//$('#sample_1').destroy();
	$('#sample_1').DataTable(
			
			{
					
				'ajax' : {
					'url' : contextpath +'/fetchData',
					'type' : 'POST',
					contentType : "application/json",	
				
				},
				"destroy": true,
				 scrollX : true,
				 scrollY : "395px",
				 scrollCollapse : true,
				"bSearchable" : true,
				
				"columns" : [
					{
						"data" : "channnelName"
					},
					{
						"data" : "campaignName"
					},

					{
						"data" : "startdDate"
					},

					{
						"data" : "enddDate"
					},
					{
						"data" : "spotCount"
					},

					{
						"data" : "actualCount"
					},
					{
						"data" : "cost"
					},
					{
						"data" : "brand"
					},

					{
						"data" : "product"
					},
					{
						"data" : "category"
					},
					{
						"data" : "sub_category"
					},
					{
						"data" : "language"
					},
					{
						"data" : "description"
					}
					],

					"columnDefs" : [ {
						"defaultContent" : "",
						"targets" : "_all"

					} ] 
			});
	setTimeout( function(){
		$('#sample_1').DataTable().search( '' ).draw();
	}, 6000 ); 

}





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
		
		//var startdate = document.getElementById('datefilterid').value;
	/*	var endDate = document.getElementById('ed').value;
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
		*/
		document.getElementById('selectBoxForm').reset();	
		//
		
	});
	$("#endDate").on("dp.change", function(e) {
		$('#startDate').data("DateTimePicker").maxDate(e.date);
		$('#endDate').data("DateTimePicker").maxDate(d);
		$(".bootstrap-datetimepicker-widget").css("background-color", "#333");
		$(this).data('DateTimePicker').hide();
		//var endDate = document.getElementById('ed').value;
		//var startdate = document.getElementById('datefilterid').value;
		//document.getElementById('selectBoxForm').reset();
		/*endDateFilter(endDate,startdate);
		endDateBrandFilter(endDate,startdate);
		endDateCategoryFilter(endDate,startdate); 
		endDateProductFilter(endDate,startdate);
		endDateLanguageFilter(endDate,startdate);
		endDateGenreFilter(endDate,startdate);*/
	});
	
	
});



///***********************************chanel ,brand ,category ,porduct or language based filter data*******************************







function fetchBrand()
{
	
	alert("channel name"+channelidR);
	var obj={

			'channnelName':channelidR,
	}
	$.ajax({
    	url: contextpath +'/fetchBrandFilter',
        processData : false,
        "contentType": "application/json",
        type : 'POST',
        data:JSON.stringify(obj),
        success : function(data) {

        	
        	$('#brandfilter').empty();
        	var ht='<input type="text"  id="brandfilter" class="search-filter" onkeyup="searchFilter1($(this))" ref="brandfilter" placeholder="Search Brand"/>';
        	$('#brandfilter').append(ht);
        	for (var i = 0; i < data.length; i++){
        		
        var brand=(data[i].brand);	
        
var html='<li   data-toggle="tooltip"  title="'+data[i].brand+'"'+ 
'class="ui-widget-content brand" id="option2_'+brand.replace(/\s/g, '_')+'">'+
''+data[i].brand+'</li>';
$('#brandfilter').append(html); 	
        }
            
        
        
        },
        error : function() {
        	
        }
    });	
	
	
}

function fetchCategory(){
alert("brand name"+brandsR+ " channel name"+channelidR);
	var obj=
	{
			
			'channnelName':channelidR,
			'brand':brandsR,
	} 
	
	$.ajax({
    	url: contextpath +'/fetchCategoryByBrand',
        processData : false,
        "contentType": "application/json",
        type : 'POST',
        data:JSON.stringify(obj),
        success : function(data) {

        	$('#categoryfilter').empty();
        	var ht='<input type="text"  id="categoryfilter" class="search-filter" onkeyup="searchFilter1($(this))" ref="categoryfilter" placeholder="Search Category"/>';
        	$('#categoryfilter').append(ht);
        	for (var i = 0; i < data.length; i++){
        var categ=(data[i].category);
        
var html='<li   data-toggle="tooltip"  title="'+data[i].category+'"'+ 
'class="ui-widget-content category" id="option2_'+categ.replace(/\s/g, '_')+'">'+
''+data[i].category+'</li>';
$('#categoryfilter').append(html); 	
        }
        },
        error : function() {
        }
    });	
}








function feetchProductFilter() {

alert("product");


	
	var obj=
		 {
		 		
		 		'channnelName':channelidR,
		 		'category':categorysR,
		 		'brand':brandsR,
		 }
	
	$.ajax({
	    	url: contextpath +'/fetchCategoryByProduct/',
	        processData : false,
	        "contentType": "application/json",
	        type : 'POST',
	        data:JSON.stringify(obj),
	        success : function(data) {
	        	
	        	$('#productfilter').empty();
	        	var ht='<input type="text"  id="productfilter" class="search-filter" onkeyup="searchFilter1($(this))" ref="productfilter" placeholder="Search Product"/>';
	        	$('#productfilter').append(ht);
	        	for (var i = 0; i < data.length; i++){
	        		
	        		 var prod=(data[i].product);
	        		 //prod=prod.replace(/\s/g, '_');		 
	var html='<li   data-toggle="tooltip"  title="'+data[i].product+'"'+ 
	'class="ui-widget-content product" id="option2_'+prod.replace(/\s/g, '_')+'">'+
	''+data[i].product+'</li>';
	$('#productfilter').append(html);
	        	}
	        },
	        error : function() {
	        	
	        }
	    });
}


function fetchLanguageFilter() 
{
 var obj={
	'channnelName':channelidR,
	'category':categorysR,
	'brand':brandsR,
	'product':productsR,
 }
	 $.ajax({
	    	url: contextpath +'/fetchLanguageyByProduct/',
	        processData : false,
	        "contentType": "application/json",
	        type : 'POST',
	        data:JSON.stringify(obj),
	        success : function(data) {
	      
	        
	        	$('#languagefilter').empty();
	        	var ht='<input type="text"  id="languagefilter" class="search-filter" onkeyup="searchFilter1($(this))" ref="languagefilter" placeholder="Search Language"/>';
	        	$('#languagefilter').append(ht);
	        	for (var i = 0; i < data.length; i++){
	        		
	        		 var lang=(data[i].language);
	        		 //lang=lang.replace(/\s/g, '_'); 
  var html='<li   data-toggle="tooltip"  title="'+data[i].language+'"'+ 
  'class="ui-widget-content language1" id="option2_'+lang.replace(/\s/g, '_')+'">'+
''+data[i].language+'</li>';
  $('#languagefilter').append(html); 	
	        }
	        },
	        error : function() {
	        	
	        }
	    });
}





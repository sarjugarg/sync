

function tabledata(){
	//$('#channelTable').dataTable().fnDestroy();
	var fromdate = $("#startDateSelected").val();
	var todate = $("#endDateSelected").val(); 
	ReportTable(fromdate,todate);
}
function tabledata2(){
	//$('#channelTable').dataTable().fnDestroy();
	var fromdate = $("#startDateSelected").val();
	var todate = $("#endDateSelected").val(); 
	ReportTable(fromdate,todate);
}

function ReportTable(date1,date2){ 
	 
	$('#channelTable').DataTable(
			{

				'ajax' : {
					'url' : contextpath +'/exportData/'+date1+'/'+date2,


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
				"bDestroy": true,
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

					} ], 
					language: {
					    infoEmpty: "No Records Found",
					}	
			});
	
	 $("#channelTable").on("draw.dt", function () {
		    $(this).find(".dataTables_empty").parents('tbody').empty();
		})
		
	setTimeout( function(){
		$('#channelTable').DataTable().search( '' ).draw();
	}, 6000 ); 
	channelFilter(date1,date2);
	productDefaultFilter(date1,date2);
	brandDefaultFilter(date1,date2);
	genreDefaultFilter(date1,date2);
	languageDefaultFilter(date1,date2);
	categoryDefaultFilter(date1,date2);
}
    		function brandFilter(brandsR,channelidR){
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
  	    	
    			 brandsR =encodeURIComponent(brandsR);
    			 channelidR =encodeURIComponent(channelidR);
    			$.ajax({
    		    	url: contextpath +'/categoryFilter/'+fromdate+'/'+todate+'/'+"?brand="+brandsR+'&channel='+channelidR,
    		        processData : false,
    		        contentType : false,
    		        type : 'POST',
    		        success : function(data) {
		        		 /*	$('#categoryfilter').empty();
		        		 	$('<option>').val("").text("Select category").appendTo('#categoryfilter');
		            	for (i = 0; i < data.length; i++){
		        			$('<option>').val(data[i].Categories).text(data[i].Categories).appendTo('#categoryfilter');
		        			} */
    		        	
    		        	$('#categoryfilter').empty();
    		        	var ht='<input type="text"  id="categoryfilter" class="search-filter" onkeyup="searchFilter1($(this))" ref="categoryfilter" placeholder="Search Category"/>';
    		        	$('#categoryfilter').append(ht);
    		        	for (var i = 0; i < data.length; i++){
    		        var categ=(data[i].Categories.trim()).replace(/[:;%',&.*+?^${}()|[\]\\]/g, '\_');
    		        
    	   var html='<li   data-toggle="tooltip"  title="'+data[i].Categories+'"'+ 
    	   'class="ui-widget-content category" id="option2_'+categ.replace(/\s/g, '_')+'">'+
    	''+data[i].Categories+'</li>';
    	   $('#categoryfilter').append(html); 	
    		        }
    		        },
    		        error : function() {
    		        }
    		    });	
    		}


    		function channelFilter(date1,date2)
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
  	    	$.ajax({
    		    	url: contextpath +'/fetchannel/'+date1+'/'+date2,
    		        processData : false,
    		        contentType : false,
    		        type : 'POST',
    		        success : function(data) {
    		        	$('#channelfilter').empty();
    		        	var ht='<input type="text"  id="channelSearch" class="search-filter" onkeyup="searchFilter1($(this))" ref="channelfilter" placeholder="Search Channel"/>';
    		        	$('#channelfilter').append(ht);
    		        	for (var i = 0; i < data.length; i++){
    		        		
    		        		var stream=(data[i].streamName.trim()).replace(/[:;%',&.*+?^${}()|[\]\\]/g, '\_');
          
    		        		var html='<li   data-toggle="tooltip"   title="'+data[i].streamName+'"'+ 
           'class="ui-widget-content channel" id="option2_'+stream.replace(/\s/g, '_')+'">'+
        ''+data[i].streamName+'</li>';
           $('#channelfilter').append(html); 	
    		        }
    		        
    		        },
    		        error : function() {
    		        }
    		    });	
    			
    			}
    			
    			
    		function categoryfilterData(categorysR,channelidR,brandsR)
    		{
    			categorysR=encodeURIComponent(categorysR);
    			channelidR=encodeURIComponent(channelidR);
    			brandsR=encodeURIComponent(brandsR);
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
 	    	
 	    		
    			
    			//var brand =encodeURIComponent(document.getElementById('brandfilter').value);
    			//var channel =encodeURIComponent(document.getElementById('channelfilter').value);
    			//var category =encodeURIComponent(document.getElementById('categoryfilter').value);
    			$.ajax({
    		    	url: contextpath +'/productfilter/'+fromdate+'/'+todate+'/'+'?channel='+channelidR+'&brand='+brandsR+'&category='+categorysR,
    		        processData : false,
    		        contentType : false,
    		        type : 'POST',
    		        success : function(data) {
    		        		/*$('#productfilter').empty();
    		        		$('<option>').val("").text("Select Product").appendTo('#productfilter');
    		            	for (i = 0; i < data.length; i++){
    		        			$('<option>').val(data[i].Product).text(data[i].Product).appendTo('#productfilter');
    		        			} 
    		        	*/
    		        	
    		        	$('#productfilter').empty();
    		        	var ht='<input type="text"  id="productfilter" class="search-filter" onkeyup="searchFilter1($(this))" ref="productfilter" placeholder="Search Product"/>';
    		        	$('#productfilter').append(ht);
    		        	for (var i = 0; i < data.length; i++){
    		        		var prod=(data[i].Product.trim()).replace(/[:;%',&.*+?^${}()|[\]\\]/g, '\_');
    		var html='<li   data-toggle="tooltip"  title="'+data[i].Product+'"'+ 
    		'class="ui-widget-content product" id="option2_'+prod.replace(/\s/g, '_')+'">'+
    		''+data[i].Product+'</li>';
    		$('#productfilter').append(html);
    		        	}
    		        },
    		        error : function() {
    		        }
    		    });	
    			
    			}
    			
    		function productFilterData(category,channel,brand,product)
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
    	    	
    	    	
    	    	category=encodeURIComponent(category);
    	    	channel=encodeURIComponent(channel);
    	    	brand=encodeURIComponent(brand);
    	    	product=encodeURIComponent(product);
    	    	
    	    	
    	    		
    		//	var brand =encodeURIComponent(document.getElementById('brandfilter').value);
    			//var channel =encodeURIComponent(document.getElementById('channelfilter').value);
    			//var category =encodeURIComponent(document.getElementById('categoryfilter').value);
    			//var product =encodeURIComponent(document.getElementById('productfilter').value);
    			
    			$.ajax({
    				url: contextpath +'/languageGenre/'+fromdate+'/'+todate+'/'+'?channel='+channel+'&brand='+brand+'&category='+category+'&product='+product,
    		        processData : false,
    		        contentType : false,
    		        type : 'POST',
    		        success : function(data) {
    		        		 /*	$('#languagefilter').empty();
    		        		 	$('<option>').val("").text("Select Language").appendTo('#languagefilter');
    		            	for (i = 0; i < data.length; i++){
    		        			$('<option>').val(data[i].language1).text(data[i].language1).appendTo('#languagefilter');
    		        			}*/
    		        	
    		        	
    		        	
    		        	$('#languagefilter').empty();
    		        	var ht='<input type="text"  id="languagefilter" class="search-filter" onkeyup="searchFilter1($(this))" ref="languagefilter" placeholder="Search Language"/>';
    		        	$('#languagefilter').append(ht);
    		        	for (var i = 0; i < data.length; i++){
    		        		var lang=(data[i].language1.trim()).replace(/[:;%',&.*+?^${}()|[\]\\]/g, '\_');
    		var html='<li   data-toggle="tooltip"  title="'+data[i].language1+'"'+ 
    		'class="ui-widget-content language1" id="option2_'+lang.replace(/\s/g, '_')+'">'+
    		''+data[i].language1+'</li>';
    		$('#languagefilter').append(html);
    		        	}
    		            	
    		        },
    		        error : function() {
    		        }
    		    });	
    			
    			}

      		function genreFilter(category,channel,brand,product)
    		{
    			category=encodeURIComponent(category);
    			product=encodeURIComponent(product);
    			brand=encodeURIComponent(brand);
    			channel=encodeURIComponent(channel);
    			
    			
    			
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
    	    	
    	    		
    	    		
    			//var brand =encodeURIComponent(document.getElementById('brandfilter').value);
    			//var channel =encodeURIComponent(document.getElementById('channelfilter').value);
    			//var category =encodeURIComponent(document.getElementById('categoryfilter').value);
    			///var product =encodeURIComponent(document.getElementById('productfilter').value);
    			$.ajax({
    				url: contextpath +'/GenreFiltre/'+fromdate+'/'+todate+'/'+'?channel='+channel+'&brand='+brand+'&category='+category+'&product='+product,
    		        processData : false,
    		        contentType : false,
    		        type : 'POST',
    		        success : function(data) {
    		        	
    		            	
    		            	/* $('#genrefilter').empty();
		        		 	$('<option>').val("").text("Select Genre").appendTo('#genrefilter');
		            	for (i = 0; i < data.length; i++){
		        			$('<option>').val(data[i].master_type).text(data[i].master_type).appendTo('#genrefilter');
		        			} */
    		        	
    		          	$('#genrefilter').empty();
    		        	var ht='<input type="text"  id="genrefilter" class="search-filter" onkeyup="searchFilter1($(this))" ref="genrefilter" placeholder="Search Genre"/>';
    		        	$('#genrefilter').append(ht);
    		        	for (var i = 0; i < data.length; i++){
    		        		var gen=(data[i].master_type.trim()).replace(/[:;%',&.*+?^${}()|[\]\\]/g, '\_');	
    		        		
    	   var html='<li   data-toggle="tooltip"  title="'+data[i].master_type+'"'+ 
    	   'class="ui-widget-content genre" id="option2_'+gen.replace(/\s/g, '_')+'">'+
    	''+data[i].master_type+'</li>';
    	   $('#genrefilter').append(html);
    		        	}
    		        	
    		        },
    		        error : function() {
                    
    		        }
    		    });	
    			
    			}
    		






function  exportDataFile()
	{
	
	var  exportData=$("#exportData").val();
	var fromdate = $("#datefilterid").val();
	var todate = $("#ed").val();
	
	 var defaultfromdate = $("#startDateSelected").val();
		var defaulttodate = $("#endDateSelected").val();
		
	if(fromdate=="" & todate=="")
		{
		fromdate=defaultfromdate;
		todate=defaulttodate;
		
		}
	
	var brand1 =encodeURIComponent(brandsR);
	var channel1 =encodeURIComponent(channelidR);
	var category1 =encodeURIComponent(categorysR);
	var product1 =encodeURIComponent(productsR);
	var language1 =encodeURIComponent(languageR);
	var genre1 =encodeURIComponent(genreR);
	
	
	if(brand1=='undefined')
	{
		brand1="";
	}
	
	if(channel1=='undefined')
	{
		channel1="";
	}
	
	if(category1=='undefined')
	{
		category1="";
	}
	
	if(product1=='undefined')
	{
		product1="";
	}
	
	if(language1=='undefined')
	{
		language1="";
	}
	
	if(genre1=='undefined')
	{
		genre1="";
	}
	
	/*$.ajax({
		url: contextpath +'/allDataExport2/'+fromdate+'/'+todate+'/'+'?channel='+channel+'&product='+product+'&category='+category+'&brand='+Brand+'&language='+language+'&genre='+genre+'&exportData='+exportData,
        processData : false,
        contentType : false,
        type : 'POST',
        success : function(data) {
        	////alert("download sucess");
        },
        error : function() {
            
        	////alert("download error ");
        }
        
	});
	}*/
	
	window.location.href = contextpath +'/allDataExport2/'+fromdate+'/'+todate+'/'+'?channel='+channel1+'&product='+product1+'&category='+category1+'&brand='+brand1+'&language='+language1+'&genre='+genre1+'&exportData='+exportData;
	}




 
 
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

 
 /*function screenShot()
 {
	 var element = $("#completeData"); // global variable

	 var getCanvas;
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
*/ 
 var screenShot =  function() {
		convertSVG();		 
		html2canvas(document.body, {
			onrendered: function(canvas) {
				var link = document.createElement("a");
				document.body.appendChild(link);
				link.download = "SyncReport.png";
				link.href = canvas.toDataURL("image/png");
				link.target = '_blank';
				link.click();
			}
		});
	};

 
function channelChangeFilter(channel)
{
//	var channel = encodeURIComponent(document.getElementById('channelfilter').value);
	//var category = encodeURIComponent(document.getElementById('categoryfilter').value);
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
	
	
	$.ajax({
    	url: contextpath +'/channelChangeFilter/'+fromdate+'/'+todate+'/'+'?channel='+channel,
        processData : false,
        contentType : false,
        type : 'POST',
        success : function(data) {
       
        	
        	
        	$('#brandfilter').empty();
        	var ht='<input type="text"  id="brandfilter" class="search-filter" onkeyup="searchFilter1($(this))" ref="brandfilter" placeholder="Search Brand"/>';
        	$('#brandfilter').append(ht);
        	for (var i = 0; i < data.length; i++){
        		var brand=(data[i].Brand.trim()).replace(/[:;%',&.*+?^${}()|[\]\\]/g, '\_');
        		
var html='<li   data-toggle="tooltip"  title="'+data[i].Brand+'"'+ 
'class="ui-widget-content brand" id="option2_'+brand.replace(/\s/g, '_')+'">'+
''+data[i].Brand+'</li>';
$('#brandfilter').append(html);
        	}
        	
        /*	$('#brandfilter').empty();
        	$('<option>').val("").text("Select Brand").appendTo('#brandfilter');
        	for (i = 0; i <data.length; i++){
    			$('<option>').val(data[i].Brand).text(data[i].Brand).appendTo('#brandfilter');
    			}*/
        	
        	
        	
        },
        error : function() {
        	
        }
    });
	
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
		/*useCurrent : false*/
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
		document.getElementById("dateErrorMessage").style.display = "none";
		if(endDate=="")
			{
			document.getElementById("dateErrorMessage").style.display = "block";
			$("#dateErrorMessage").html('Please Select End Date');
			}
		 else if(startdate!="" & endDate!=""){
		endDateFilter(endDate,startdate);
		endDateBrandFilter(endDate,startdate);
		endDateCategoryFilter(endDate,startdate); 
		endDateProductFilter(endDate,startdate);
		endDateLanguageFilter(endDate,startdate);
		endDateGenreFilter(endDate,startdate);
		}
		});
	
	
});



function showChannels(){
	
	////alert("show channel post method");
	
	 
	var fromdate = $("#datefilterid").val();
	var todate = $("#ed").val();
	
	 var defaultfromdate = $("#startDateSelected").val();
		var defaulttodate = $("#endDateSelected").val();
		
	if(fromdate=="" & todate=="")
		{
		fromdate=defaultfromdate;
		todate=defaulttodate;
		
		}

	if(fromdate!="" & todate=="")
		{
				document.getElementById("dateErrorMessage").style.display = "block";
		$("#dateErrorMessage").html('Please Select End Date');
		}
	else{
		
	var	channel = encodeURIComponent(channelidR);
	var brand = encodeURIComponent(brandsR);
	var category = encodeURIComponent(categorysR);
	var product =encodeURIComponent(productsR);
	var language =encodeURIComponent(languageR);
	var genre =encodeURIComponent(genreR);
	
	if(channel=='undefined')
	{
		channel="";
	}
	if(brand=='undefined')
	{
		brand="";
	}
	if(category=='undefined')
	{
		category="";
	}
	if(product=='undefined')
	{
		product="";
	}
	
	if(language=='undefined')
	{
		language="";
	}
	
	if(genre=='undefined')
	{
		genre="";
	}
	
	
	
	
	
	
/*	var language = encodeURIComponent(languagesR);
	var genre =encodeURIComponent(genre);*/

		
 	$('#channelTable').DataTable(
    		{
    			'destroy':true,

				'ajax' : {
					'url' : contextpath +'/exportchannels/'+fromdate+'/'+todate+'/'+'?channels='+channel
							+'&brand='+brand+'&category='+category+'&product='+product+'&language='+language+'&genre='+genre,
					//'url' : contextpath +'/exportData/'+fromdate+'/'+todate,
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
					
				} ] ,
				language: {
				    infoEmpty: "No Records Found",
				}	

		});
 	
 	$("#channelTable").on("draw.dt", function () {
	    $(this).find(".dataTables_empty").parents('tbody').empty();
	})
 }


}
 

 
 
 function startDateFilter(startdate)
 {
		
	 $.ajax({
	    	url: contextpath +'/startDateFilter/'+startdate,
	        processData : false,
	        contentType : false,
	        type : 'POST',
	        success : function(data) {
	        	
	       /* $('#channelfilter').empty();
			$('<option>').val("").text("Select Channel").appendTo('#channelfilter');
	    	for (i = 0; i < data.length; i++){
				$('<option>').val(data[i].streamName).text(data[i].streamName).appendTo('#channelfilter');
				}*/
	        	
	        	
	        	
	        	$('#channelfilter').empty();
	        	////alert("after date");
	        	var ht='<input type="text"  id="channelSearch" class="search-filter" onkeyup="searchFilter1($(this))" ref="channelfilter" placeholder="Search Channel"/>';
	        	$('#channelfilter').append(ht);
	        	for (var i = 0; i < data.length; i++){
	        		
	        		 var stream=(data[i].streamName.trim()).replace(/[:;%',&.*+?^${}()|[\]\\]/g, '\_');
	        		 //stream=stream.replace(/\s/g, '_');
   var html='<li   data-toggle="tooltip"   title="'+data[i].streamName+'"'+ 
   'class="ui-widget-content channel" id="option2_'+stream.replace(/\s/g, '_')+'">'+
''+data[i].streamName+'</li>';
   $('#channelfilter').append(html);
	        	}
	        },
	        error : function() {
	        	
	        }
	    });
}
 function endDateFilter(endDate,startdate) 
 {
    
	 $.ajax({
	    	url: contextpath +'/endDateFilter/'+endDate+'/'+startdate,
	        processData : false,
	        contentType : false,
	        type : 'POST',
	        success : function(data) {
	        	
	      /*  $('#channelfilter').empty();
			$('<option>').val("").text("Select Channel").appendTo('#channelfilter');
	    	for (i = 0; i < data.length; i++){
				$('<option>').val(data[i].streamName).text(data[i].streamName).appendTo('#channelfilter');
				}*/
	        	
	        	$('#channelfilter').empty();
	        	////alert("after date");
	        	var ht='<input type="text"  id="channelSearch" class="search-filter" onkeyup="searchFilter1($(this))" ref="channelfilter" placeholder="Search Channel"/>';
	        	$('#channelfilter').append(ht);
	        	for (var i = 0; i < data.length; i++){
	        		
	        	
	        		var stream=(data[i].streamName.trim()).replace(/[:;%',&.*+?^${}()|[\]\\]/g, '\_');
	        		 
	        		 //stream=stream.replace(/\s/g, '_');
   var html='<li   data-toggle="tooltip"   title="'+data[i].streamName+'"'+ 
   'class="ui-widget-content channel" id="option2_'+stream.replace(/\s/g, '_')+'">'+
''+data[i].streamName+'</li>';
   $('#channelfilter').append(html);
	        	} 	
	        	
	        	
	        },
	        error : function() {
	        	
	        }
	    });
 }

 
 function endDateBrandFilter(endDate,startdate) 
 {
    
	 $.ajax({
	    	url: contextpath +'/endDateBrandFilter/'+endDate+'/'+startdate,
	        processData : false,
	        contentType : false,
	        type : 'POST',
	        success : function(data) {
	        	
	     /*   $('#brandfilter').empty();
			$('<option>').val("").text("Select Brand").appendTo('#brandfilter');
	    	for (i = 0; i < data.length; i++){
				$('<option>').val(data[i].Brand).text(data[i].Brand).appendTo('#brandfilter');
				}*/
	        	
	        	
	        	$('#brandfilter').empty();
	        	var ht='<input type="text"  id="brandfilter" class="search-filter" onkeyup="searchFilter1($(this))" ref="brandfilter" placeholder="Search Brand"/>';
	        	$('#brandfilter').append(ht);
	        	for (var i = 0; i < data.length; i++){
	        		 var brand=(data[i].Brand.trim()).replace(/[:;%',&.*+?^${}()|[\]\\]/g, '\_');	
	        		 //brand=brand.replace(/\s/g, '_');
   var html='<li   data-toggle="tooltip"  title="'+data[i].Brand+'"'+ 
   'class="ui-widget-content brand" id="option2_'+brand.replace(/\s/g, '_')+'">'+
''+data[i].Brand+'</li>';
   $('#brandfilter').append(html); 	
	        }
	        },
	        error : function() {
	        	
	        }
	    });
 }

 
 function endDateCategoryFilter(endDate,startdate) 
 {
    
	 $.ajax({
	    	url: contextpath +'/endDateCategoryFilter/'+endDate+'/'+startdate,
	        processData : false,
	        contentType : false,
	        type : 'POST',
	        success : function(data) {
	        	
	       /* $('#categoryfilter').empty();
			$('<option>').val("").text("Select category").appendTo('#categoryfilter');
	    	for (i = 0; i < data.length; i++){
				$('<option>').val(data[i].Categories).text(data[i].Categories).appendTo('#categoryfilter');
				}*/
	        	
	        	
	        	
	        	$('#categoryfilter').empty();
	        	var ht='<input type="text"  id="categoryfilter" class="search-filter" onkeyup="searchFilter1($(this))" ref="categoryfilter" placeholder="Search Category"/>';
	        	$('#categoryfilter').append(ht);
	        	for (var i = 0; i < data.length; i++){
	        		
	        		//var categ=(data[i].Categories.trim()).replace('&','_');
	        		var categ=(data[i].Categories.trim()).replace(/[:;%',&.*+?^${}()|[\]\\]/g, '\_');
	        		//categ=categ.replace(/\s/g, '_');
	        		//categ=categ.replace(/\s/g, '_'); 
	         		//////alert("category"+categ);
   var html='<li   data-toggle="tooltip"  title="'+data[i].Categories+'"'+ 
   'class="ui-widget-content category" id="option2_'+categ.replace(/\s/g, '_')+'">'+
   ''+data[i].Categories+'</li>';
   $('#categoryfilter').append(html); 	
	        }
	        },
	        error : function() {
	        	
	        }
	    });
 }


 function endDateProductFilter(endDate,startdate) 
 {
    
	 $.ajax({
	    	url: contextpath +'/endDateProductFilter/'+endDate+'/'+startdate,
	        processData : false,
	        contentType : false,
	        type : 'POST',
	        success : function(data) {
	        	
	       /* $('#productfilter').empty();
			$('<option>').val("").text("Select Product").appendTo('#productfilter');
	    	for (i = 0; i < data.length; i++){
				$('<option>').val(data[i].Product).text(data[i].Product).appendTo('#productfilter');
				}*/
	        	
	        	
	        	$('#productfilter').empty();
	        	var ht='<input type="text"  id="productfilter" class="search-filter" onkeyup="searchFilter1($(this))" ref="productfilter" placeholder="Search Product"/>';
	        	$('#productfilter').append(ht);
	        	for (var i = 0; i < data.length; i++){
	        		
	        		 var prod=(data[i].Product.trim()).replace(/[:;%'&.,*+?^${}()|[\]\\]/g, '\_');
	        		 //prod=prod.replace(/\s/g, '_');		 
	var html='<li   data-toggle="tooltip"  title="'+data[i].Product+'"'+ 
	'class="ui-widget-content product" id="option2_'+prod.replace(/\s/g, '_')+'">'+
	''+data[i].Product+'</li>';
	$('#productfilter').append(html);
	        	}
	        },
	        error : function() {
	        	
	        }
	    });
 }
 
 
 function endDateLanguageFilter(endDate,startdate) 
 {
    
	 $.ajax({
	    	url: contextpath +'/endDateLanguageFilter/'+endDate+'/'+startdate,
	        processData : false,
	        contentType : false,
	        type : 'POST',
	        success : function(data) {
	      /*  	
	        $('#languagefilter').empty();
			$('<option>').val("").text("Select Language").appendTo('#languagefilter');
	    	for (i = 0; i < data.length; i++){
				$('<option>').val(data[i].language1).text(data[i].language1).appendTo('#languagefilter');
				}*/
	        	
	        	$('#languagefilter').empty();
	        	var ht='<input type="text"  id="languagefilter" class="search-filter" onkeyup="searchFilter1($(this))" ref="languagefilter" placeholder="Search Language"/>';
	        	$('#languagefilter').append(ht);
	        	for (var i = 0; i < data.length; i++){
	        		
	        		 var lang=(data[i].language1.trim()).replace(/[:;%'&.,*+?^${}()|[\]\\]/g, '\_');
	        		 //lang=lang.replace(/\s/g, '_'); 
   var html='<li   data-toggle="tooltip"  title="'+data[i].language1+'"'+ 
   'class="ui-widget-content language1" id="option2_'+lang.replace(/\s/g, '_')+'">'+
''+data[i].language1+'</li>';
   $('#languagefilter').append(html); 	
	        }
	        },
	        error : function() {
	        	
	        }
	    });
 }

 function endDateGenreFilter(endDate,startdate) 
 {
    
	 $.ajax({
	    	url: contextpath +'/endDateGenreFilter/'+endDate+'/'+startdate,
	        processData : false,
	        contentType : false,
	        type : 'POST',
	        success : function(data) {
	        	
	     /*   $('#genrefilter').empty();
			$('<option>').val("").text("Select Genre").appendTo('#genrefilter');
	    	for (i = 0; i < data.length; i++){
				$('<option>').val(data[i].master_type).text(data[i].master_type).appendTo('#genrefilter');
				}*/
	        	
	        	$('#genrefilter').empty();
	        	var ht='<input type="text"  id="genrefilter" class="search-filter" onkeyup="searchFilter1($(this))" ref="genrefilter" placeholder="Search Genre"/>';
	        	$('#genrefilter').append(ht);
	        	for (var i = 0; i < data.length; i++){
	        		 var gen=(data[i].master_type.trim()).replace(/[:;%'&.,*+?^${}()|[\]\\]/g, '\_');
	        		// gen=gen.replace(/\s/g, '_'); 		
	        		
   var html='<li   data-toggle="tooltip"  title="'+data[i].master_type+'"'+ 
   'class="ui-widget-content genre" id="option2_'+gen.replace(/\s/g, '_')+'">'+
''+data[i].master_type+'</li>';
   $('#genrefilter').append(html);
	        	}
	        },
	        error : function() {
	        	
	        }
	    });
 }

 
 
 function closeModal(){
	 
	 document.getElementById('selectBoxForm').reset();
	 document.getElementById('formId').reset();
	 document.getElementById('filterTab').reset();
 
 }
 

	function categoryDefaultFilter(date1,date2)
	{
		
		var formData = new FormData();
		var fromdate = $("#startDateSelected").val();
		var todate = $("#endDateSelected").val();
		
		$.ajax({
	    	url: contextpath +'/categoryDefaultFilter/'+date1+'/'+date2,
	        processData : false,
	        contentType : false,
	        type : 'POST',
	        success : function(data) {
	        	
	        	/*$('#categoryfilter').empty();
	        		 	$('<option>').val("").text("Select Category").appendTo('#categoryfilter');
	            	for (i = 0; i < data.length; i++){
	        			$('<option>').val(data[i].Categories).text(data[i].Categories).appendTo('#categoryfilter');
	        			}*/
	        	
	        	
	        	$('#categoryfilter').empty();
	        	var ht='<input type="text"  id="categoryfilter" class="search-filter" onkeyup="searchFilter1($(this))" ref="categoryfilter" placeholder="Search Category"/>';
	        	$('#categoryfilter').append(ht);
	        	for (var i = 0; i < data.length; i++){
	        		var categ=(data[i].Categories.trim()).replace(/[:;%'&,.*+?^${}()|[\]\\]/g, '\_');
	        		//categ=categ.replace(/\s/g, '_');
	         		//////alert("category"+categ);
   var html='<li   data-toggle="tooltip"  title="'+data[i].Categories+'"'+ 
   'class="ui-widget-content category" id="option2_'+categ.replace(/\s/g, '_')+'">'+
   ''+data[i].Categories+'</li>';
   $('#categoryfilter').append(html); 	
	        }
	        },
	        error : function() {
	        	
	        }
	    });	
		
		}

 
 
	function productDefaultFilter(date1,date2)
	{
		var formData = new FormData();
		var fromdate = $("#startDateSelected").val();
		var todate = $("#endDateSelected").val();
		
		$.ajax({
	    	url: contextpath +'/productDefautlFilter/'+date1+'/'+date2,
	        processData : false,
	        contentType : false,
	        type : 'POST',
	        success : function(data) {
	        	
	        /*	$('#productfilter').empty();
	        		 	$('<option>').val("").text("Select product").appendTo('#productfilter');
	            	for (i = 0; i < data.length; i++){
	        			$('<option>').val(data[i].Product).text(data[i].Product).appendTo('#productfilter');
	        			} */
	        	
	        	
	        	$('#productfilter').empty();
	        	var ht='<input type="text"  id="productfilter" class="search-filter" onkeyup="searchFilter1($(this))" ref="productfilter" placeholder="Search Product"/>';
	        	$('#productfilter').append(ht);
	        	for (var i = 0; i < data.length; i++){
	        		var prod=(data[i].Product.trim()).replace(/[!/#:;%'&,.*+?^${}()|[\]\\]/g, '\_');
	        		/*prod=prod.replace(/\s/g, '_');*/
	        		//categ=categ.replace(/\s/g, '_'); 
	         		//////alert("product name"+prod);	
	        		
	var html='<li   data-toggle="tooltip"  title="'+data[i].Product+'"'+ 
	'class="ui-widget-content product" id="option2_'+prod.replace(/\s/g, '_')+'">'+
	''+data[i].Product+'</li>';
	$('#productfilter').append(html);
	        	}
	        },
	        error : function() {
	        	
	        }
	    });	
		
		}

	function brandDefaultFilter(date1,date2)
	{
		
		var formData = new FormData();
		var fromdate = $("#startDateSelected").val();
		var todate = $("#endDateSelected").val();
		
		$.ajax({
	    	url: contextpath +'/brandDefautlFilter/'+date1+'/'+date2,
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
	            	
	        	$('#brandfilter').empty();
	        	var ht='<input type="text"  id="brandfilter" class="search-filter" onkeyup="searchFilter1($(this))" ref="brandfilter" placeholder="Search Brand"/>';
	        	$('#brandfilter').append(ht);
	        	for (var i = 0; i < data.length; i++){
	        
	        var brand=(data[i].Brand.trim()).replace(/[:;%',&.*+?^${}()|[\]\\]/g, '\_');	
	        
   var html='<li   data-toggle="tooltip"  title="'+data[i].Brand+'"'+ 
   'class="ui-widget-content brand" id="option2_'+brand.replace(/\s/g, '_')+'">'+
''+data[i].Brand+'</li>';
   $('#brandfilter').append(html); 	
	        }
	            
	        
	        
	        },
	        error : function() {
	        	
	        }
	    });	
		
		}

	
	function genreDefaultFilter(date1,date2)
	{
		
		var formData = new FormData();
		var fromdate = $("#startDateSelected").val();
		var todate = $("#endDateSelected").val();
		
		$.ajax({
	    	url: contextpath +'/genreDefautlFilter/'+date1+'/'+date2,
	        processData : false,
	        contentType : false,
	        type : 'POST',
	        success : function(data) {
	        	
	        	
	        	$('#genrefilter').empty();
	        	var ht='<input type="text"  id="genrefilter" class="search-filter" onkeyup="searchFilter1($(this))" ref="genrefilter" placeholder="Search Genre"/>';
	        	$('#genrefilter').append(ht);
	        	for (var i = 0; i < data.length; i++){
	        		
	      var gen=(data[i].master_type.trim()).replace(/[:;%',&.*+?^${}()|[\]\\]/g, '\_');
	      //gen=gen.replace(/\s/g, '_');
   var html='<li   data-toggle="tooltip"  title="'+data[i].master_type+'"'+ 
   'class="ui-widget-content genre" id="option2_'+gen.replace(/\s/g, '_')+'">'+
''+data[i].master_type+'</li>';
   $('#genrefilter').append(html);
	        	}
    	
	        },
	        error : function() {
	        	
	        }
	    });	
		
		}


	function languageDefaultFilter(date1,date2)
	{
		
		var formData = new FormData();
		var fromdate = $("#startDateSelected").val();
		var todate = $("#endDateSelected").val();
		
		$.ajax({
	    	url: contextpath +'/languageDefautlFilter/'+date1+'/'+date2,
	        processData : false,
	        contentType : false,
	        type : 'POST',
	        success : function(data) {
	        	
	        	
            	/*$('#languagefilter').empty();
    		 	$('<option>').val("").text("Select Language").appendTo('#languagefilter');
        	for (i = 0; i < data.length; i++){
    			$('<option>').val(data[i].language1).text(data[i].language1).appendTo('#languagefilter');
    			}*/
	        	
	        	
	        	$('#languagefilter').empty();
	        	var ht='<input type="text"  id="languagefilter" class="search-filter" onkeyup="searchFilter1($(this))" ref="languagefilter" placeholder="Search Language"/>';
	        	$('#languagefilter').append(ht);
	        	for (var i = 0; i < data.length; i++){
	        		
	        		var lang=(data[i].language1.trim()).replace(/[:;%',&.*+?^${}()|[\]\\]/g, '\_');
	        		//lang=lang.replace(/\s/g, '_');
	        		//categ=categ.replace(/\s/g, '_'); 	
   var html='<li   data-toggle="tooltip"  title="'+data[i].language1+'"'+ 
   'class="ui-widget-content language1" id="option2_'+lang.replace(/\s/g, '_')+'">'+
''+data[i].language1+'</li>';
   $('#languagefilter').append(html); 	
	        }
    	
	        },
	        error : function() {
	        	
	        }
	    });	
		
		}
 



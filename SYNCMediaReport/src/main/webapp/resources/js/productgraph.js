
/*Highcharts.chart('morris-area-example23424', {
	    chart: {
	        type: 'area'
	    },
	    title: {
	        text: 'US and USSR nuclear stockpiles'
	    },
	    subtitle: {
	        text: 'Sources: <a href="https://thebulletin.org/2006/july/global-nuclear-stockpiles-1945-2006">' +
	            'thebulletin.org</a> &amp; <a href="https://www.armscontrol.org/factsheets/Nuclearweaponswhohaswhat">' +
	            'armscontrol.org</a>'
	    },
	    xAxis: {
	        allowDecimals: false,
	          
		        
	    },
	    yAxis: {
	        title: {
	            text: 'Nuclear weapon states'
	        },
	        labels: {
	            formatter: function () {
	                return this.value / 10;
	            }
	        }
	    },
	    tooltip: {
	        pointFormat: '{series.name} had stockpiled <b>{point.y:,.0f}</b><br/>warheads in {point.x}'
	    },
	    plotOptions: {
	        area: {
	            //pointStart: 2018-04-10,
	            marker: {
	                enabled: false,
	                symbol: 'circle',
	                radius: 2,
	                states: {
	                    hover: {
	                        enabled: true
	                    }
	                }
	            }
	        }
	    },
	    series: [{
	        name: 'Playouts',
	        data: [
	             4368, 4018
	        ]
	    }]
	});	
	







	//Line Graph
	(function(){ var files = ["https://code.highcharts.com/stock/highstock.js",
	"https://code.highcharts.com/highcharts-more.js","https://code.highcharts.com/highcharts-3d.js",
	"https://code.highcharts.com/modules/data.js","https://code.highcharts.com/modules/exporting.js",
	"https://code.highcharts.com/modules/funnel.js","https://code.highcharts.com/modules/annotations.js",
	"https://code.highcharts.com/modules/solid-gauge.js"],loaded = 0; if (typeof window["HighchartsEditor"] === "undefined") 
	{window.HighchartsEditor = {ondone: [cl],hasWrapped: false,hasLoaded: false};include(files[0]);} else {if (window.HighchartsEditor.hasLoaded) {cl();} 
	else {window.HighchartsEditor.ondone.push(cl);}}function isScriptAlreadyIncluded(src){var scripts = document.getElementsByTagName("script");
	for (var i = 0; i < scripts.length; i++) {if (scripts[i].hasAttribute("src")) 
	{if ((scripts[i].getAttribute("src") || "").indexOf(src) >= 0 || (scripts[i].getAttribute("src") === "http://code.highcharts.com/highcharts.js"
	 && src === "https://code.highcharts.com/stock/highstock.js")) {return true;}}}return false;}function check() {if (loaded === files.length) 
	 {for (var i = 0; i < window.HighchartsEditor.ondone.length; i++) {try {window.HighchartsEditor.ondone[i]();}
	 catch(e) {console.error(e);}}window.HighchartsEditor.hasLoaded = true;}}function include(script) 
	 {function next() {++loaded;if (loaded < files.length) {include(files[loaded]);}check();}
	 if (isScriptAlreadyIncluded(script)) {return next();}var sc=document.createElement("script");
	 sc.src = script;sc.type="text/javascript";sc.onload=function() { next(); };
	 document.head.appendChild(sc);}function each(a, fn){if (typeof a.forEach !== "undefined"){a.forEach(fn);}
	 else{for (var i = 0; i < a.length; i++){if (fn) {fn(a[i]);}}}}var inc = {},incl=[];
	 each(document.querySelectorAll("script"), function(t) {inc[t.src.substr(0, t.src.indexOf("?"))] = 1; }); 
	 function cl() {if(typeof window["Highcharts"] !== "undefined")
	 {var options={"title":{
		 "text":"Hourly Playouts", style: {color: 'white'}},"subtitle":{"text":""},"exporting":{},
	"xAxis": {labels: {style: {color: 'white'}}},"yAxis": {labels: {style: {color: 'white'}}},
	"chart":{"type":"area","backgroundColor":"#757c7f"},
	"legend":{"layout":"vertical","align":"right","verticalAlign":"middle","enabled": false},
	"plotOptions":{"series":{"label":{"connectorAllowed":false,},"pointStart":2010,"animation":false}},
	 "series":[{"name":"Installation"},{"name":"Manufacturing"},{"name":"Sales &amp; Distribution"},{"name":"Project Development"},{"name":"Other"}],"responsive":{"rules":[{"condition":{"maxWidth":500},
	 "chartOptions":{"legend":{"layout":"horizontal","align":"center","verticalAlign":"bottom"}},"_id":"highcharts-iv8bxqs-44"}]},
	 "data":{"csv":"\"Category\";\"Installation\";\"Manufacturing\";\"Sales &amp; Distribution\";\"Project Development\";\"Other\"\n2010;43934; \n2011;52503;\n2012;57177;\n2013;69658;\n2014;97031;\n2015;119931;\n2016;137133;\n2017;1541;","googleSpreadsheetKey":false,"googleSpreadsheetWorksheet":false}};
	// Sample of extending options:
	Highcharts.merge(true, options, {
	    chart: {
	        backgroundColor: "#bada55"
	    },
	    plotOptions: {
	        series: {
	            cursor: "pointer",
	            events: {
	                click: function(event) {
	                    alert(this.name + " clicked\n" +
	                          "Alt: " + event.altKey + "\n" +
	                          "Control: " + event.ctrlKey + "\n" +
	                          "Shift: " + event.shiftKey + "\n");
	                }
	            }
	        }
	    }
	});
	new Highcharts.Chart("morris-line-example", options);}}})();
	

	//Area Graph
	(function(){ var files = ["https://code.highcharts.com/stock/highstock.js",
	"https://code.highcharts.com/highcharts-more.js",
	"https://code.highcharts.com/highcharts-3d.js",
	"https://code.highcharts.com/modules/data.js",
	"https://code.highcharts.com/modules/exporting.js",
	"https://code.highcharts.com/modules/funnel.js",
	"https://code.highcharts.com/modules/annotations.js",
	"https://code.highcharts.com/modules/solid-gauge.js"],
	loaded = 0; if (typeof window["HighchartsEditor"] === "undefined")
		{window.HighchartsEditor = {ondone: [cl],hasWrapped: false,hasLoaded: false};include(files[0]);} 
	else {if (window.HighchartsEditor.hasLoaded) {cl();} else {window.HighchartsEditor.ondone.push(cl);}}
	function isScriptAlreadyIncluded(src){var scripts = document.getElementsByTagName("script");
	for (var i = 0; i < scripts.length; i++) {if (scripts[i].hasAttribute("src"))
		{if ((scripts[i].getAttribute("src") || "").indexOf(src) >= 0 || 
	(scripts[i].getAttribute("src") === "http://code.highcharts.com/highcharts.js" 
	&& src === "https://code.highcharts.com/stock/highstock.js")) {return true;}}}return false;}
	function check() {if (loaded === files.length) {for (var i = 0; i < window.HighchartsEditor.ondone.length; i++) 
	{try {window.HighchartsEditor.ondone[i]();} catch(e) {console.error(e);}}window.HighchartsEditor.hasLoaded = true;}}
	function include(script) {function next() {++loaded;if (loaded < files.length) {include(files[loaded]);}check();}
	if (isScriptAlreadyIncluded(script)) {return next();}var sc=document.createElement("script");
	sc.src = script;sc.type="text/javascript";sc.onload=function() { next(); };
	document.head.appendChild(sc);}function each(a, fn)
	{if (typeof a.forEach !== "undefined"){a.forEach(fn);}else{for (var i = 0; i < a.length; i++)
	{if (fn) {fn(a[i]);}}}}var inc = {},incl=[]; each(document.querySelectorAll("script"), function(t) {inc[t.src.substr(0, t.src.indexOf("?"))] = 1; }); 
	function cl() {if(typeof window["Highcharts"] !== "undefined")
	{var options={"title":{"text":"Daily Playouts",style: {color: 'white'}},
	"xAxis": {labels: {style: {color: 'white'}}},"yAxis": {labels: {style: {color: 'white'}}},

	"subtitle":{"text":""},
	"exporting":{},
	"chart":{"type":"area","polar":false,"backgroundColor":"#606870"},
	"legend":{"layout":"vertical","align":"right","verticalAlign":"middle","enabled": false},
	"plotOptions":{"series":{"label":{"connectorAllowed":false},"pointStart":2010,"animation":false}},
	"series":[{"name":"Installation"},{"name":"Manufacturing"},{"name":"Sales &amp; Distribution"},{"name":"Project Development"},{"name":"Other"}],"responsive":{"rules":[{"condition":{"maxWidth":500},
	"chartOptions":{"legend":{"layout":"horizontal","align":"center","verticalAlign":"bottom"}},"_id":"highcharts-iv8bxqs-44"}]},
	"data":{"csv":"\"Category\";\"Installation\";\"Manufacturing\";\"Sales &amp; Distribution\";\"Project Development\";\"Other\"\n2010;43934;\n2011;52503;\n2012;57177;\n2013;69658;\n2014;97031;\n2015;119931;\n2016;137133;\n2017;154175;","googleSpreadsheetKey":false,"googleSpreadsheetWorksheet":false}};
	// Sample of extending options:
	Highcharts.merge(true, options, {
	    chart: {
	        backgroundColor: "#bada55"
	    },
	    plotOptions: {
	        series: {
	            cursor: "pointer",
	            events: {
	                click: function(event) {
	                    alert(this.name + " clicked\n" +
	                          "Alt: " + event.altKey + "\n" +
	                          "Control: " + event.ctrlKey + "\n" +
	                          "Shift: " + event.shiftKey + "\n");
	                }
	            }
	        }
	    }
	});
	new Highcharts.Chart("morris-area-example2", options);}}})();

*/
var topchannels=[];
var byCategory=[]; 


function allgraph(){ 
/*	Highcharts.setOptions({
	    colors: ["#FFFFFF","#FFFFE0","#00CED1","#B0E0E6","#7B68EE","#1E90FF","#D3D3D3","#FFA07A","#FA8072","#DEB887","#BC8F8F","#D2691E"]
	}); 
*/
	Highcharts.setOptions({
	    colors: ['#058DC7', '#50B432', '#ED561B', '#DDDF00', '#24CBE5', '#64E572', '#FF9655', '#FFF263', '#6AF9C4']
	});	
	var selectedVal = "";
	var selected = $("input[name='time']:checked");
	if (selected.length > 0) {
	    selectedVal = selected.val();
	}
      var days='42342354353'; 	
	//var days=document.getElementById("date_range").value; // Days you want to subtract
	var date = new Date();
	var last = new Date(date.getTime() - (days * 24 * 60 * 60 * 1000));
	var day =last.getDate();
	var month=last.getMonth()+1;
	var year=last.getFullYear();
	var fromdate=year+"-"+month+"-"+day;
	//alert(year+"-"+month+"-"+day);
	var today=date.getDate(); 
	var current_month=date.getMonth()+1;
	var current_year=date.getFullYear();
	//alert(current_year+"-"+current_month+"-"+today);
	var todate=current_year+"-"+current_month+"-"+today;
	var fromdate=year+"-"+month+"-"+day;

	var seriesname=[];
	var dataArray=[];
	var jsonarray=[];
	var limit=document.getElementById("limit").value;
	//alert("limit = " +limit)
	if(limit ==""){
		limit ='7';
	}
	var urlpath=contextpath+"/getDataByChannels";
    var obj={startdate:fromdate,
             enddate:todate,
             limit:limit,
             time:selectedVal
    };   
    jsonarray.push(obj);
	$.ajax({
          type: 'POST',
          url:urlpath ,
          data: JSON.stringify(obj),
          contentType: "application/json",
  	      dataType: 'html',
          success: function(data){
           var productnamearr=[];	  
           var obj2;
           var duration_name;
           var resp=$.parseJSON(data);
           topchannels.push(resp);  
           //alert(byCategory);
           
           if(resp!=null || resp !=""){
           for(var i=0;i<resp.length;i++){
        	   productnamearr.push({"name":resp[i].streamname,"y":resp[i].timeduration});
        	   seriesname.push(resp[i].streamname);
        	   duration_name=resp[0].duration_name;
           }
           } 
          // alert(productnamearr);
           console.log(productnamearr);
       	   console.log("data");
           console.log(data);
              
           var ctx = document.getElementById("morris-bar-stacked");    
       	   var chart = new Highcharts.Chart({
       	  
       	    chart: {
       	        renderTo:'morris-bar-stacked', 
       	        type: 'pie',
       	     polar:false,
       	     //backgroundColor:"#606870",
       	     //backgroundColor:"#32325d"   
       	  backgroundColor:false
       	    },  
       	 title:{
       		    text:"", 
       		    style: {color: 'white'}
       	    },
       	 plotOptions:{pie:{ 
       		 allowPointSelect:true,
       		 cursor:true, 
       		  //size:'100%', 
       		 innerSize:'85%',
       		 dataLabels:{enabled:false},
       		 shadow:false,
       		 center:['50%','50%']},
       		
       	 },
       	    series: [{
       	    	name:duration_name, 
       	        data: productnamearr,
       	     /*colors: ['#058DC7', '#50B432', '#ED561B', '#DDDF00', '#24CBE5', '#64E572', 
                 '#FF9655', '#FFF263', '#6AF9C4'],*/
       	       
       	    }]
       	  
       	});      
           
           },
          error:function(){
          	//alert("fail")
          }
      });
      

	
	$.ajax({
        type: 'POST',
        url:contextpath+"/getcategoryByPlayout" ,
        contentType: "application/json",
	    dataType: 'html',
	    data: JSON.stringify(obj),   
        success: function(data){
         var categoryarray=[];
         var obj2;
         

         var response=$.parseJSON(data);
       
         for(var i=0;i<response.length;i++){
        	 categoryarray.push({"name":response[i].categoryname,"y":response[i].count});
      	   
         }
         
         
     	console.log("data");
     	console.log(data);
     	var chart = new Highcharts.Chart({
     	    chart: {
     	        renderTo: 'morris-donut-example2',
     	        type: 'pie',
     	     polar:false,
     	     backgroundColor:"#606870" 
     	    },
     	 title:{
     		    text:"Category by Playout", 
     		    style: {color: 'white'}
     	    },
     	 plotOptions:{pie:{allowPointSelect:true,
     		 cursor:true,innerSize:'85%', 
     		 dataLabels:{enabled:false},
     		shadow:false,center:['50%','30%'],
     		size:'100%'
     		 },
     	 },  
     	    series: [{
     	    	name:'Playout',
     	        data: categoryarray,
     	      // colors:["pink"],
     //	      fillColor:{linearGradient:[0,0,0,200],stops:[[0,"rgba(56,165,210, 0.1)"],[1,Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get("rgba")]]}
     	    }]   
     	});         
         
         },
        error:function(){
        	//alert("fail")
        }
    });

	
	
	
	
	$.ajax({
        type: 'POST',
        url:contextpath+"/getcategoryByAirtime" ,
        contentType: "application/json",
	    dataType: 'html',
	    data: JSON.stringify(obj),
        success: function(data){
        	productnamearr=[];
         var obj2;
         var response=$.parseJSON(data);
         for(var i=0;i<response.length;i++){
      	   productnamearr.push({"name":response[i].categoryname,"y":response[i].playoutduration});
      	   
         }
         
         console.log(productnamearr);
     	console.log("data");
     	console.log(data);
     	var chart = new Highcharts.Chart({
     	    chart: {
     	        renderTo: 'bar-graph2',
     	        type: 'pie',
     	     polar:false,
     	     backgroundColor:"#606870"
     	    },
     	 title:{
     		    text:"Category by Airtime", 
     		    style: {color: 'white'}
     	    },
     	 plotOptions:{pie:{allowPointSelect:true,
     		 cursor:true,innerSize:'85%',
     		 dataLabels:{enabled:false},
     		shadow:false,center:['50%','30%'],
     		///size:'100%'	
     	 },
     	 },
     	    series: [{
     	    	name:'Airtime',
     	        data: productnamearr
     	    }]
     	 
     	});
     	
     	
         
         },
        error:function(){
        	//alert("fail")
        }
    });


	
	$.ajax({
        type: 'POST',
        url:contextpath+"/getDataByCategory" ,
        contentType: "application/json",
	    dataType: 'html',
	    data: JSON.stringify(obj),
        success: function(data){
         var categoryname=[];
         var timeduration=[];
         var duration_name;
         var response=$.parseJSON(data);
         for(var i=0;i<response.length;i++){
        	 categoryname.push(response[i].categoryname);
        	 timeduration.push(response[i].timeduration);
        	 duration_name=response[0].duration_name;
         }
         

     	Highcharts.chart('bar-graph1', {
     	    chart: {
     	        type: 'bar',
     	        inverted:true,
     	    	polar:false,
     	    	backgroundColor:'#606870',
     	    	//height: '80%',
     	    },
     	    title: {
     	        text: 'By Categories',
     	        style: {color: 'white'}
     	    },
     	    subtitle: {
     	        text: ''
     	    }, 
     	    xAxis: {
     	        categories: categoryname,
     	        crosshair: true,
     	        labels:
     	  	  {  style: 
     	  	     { 
     	  		   color: 'white'
     	  	     }
     	       } 
     	    },
     	    yAxis: {
     	    	 labels: 
     	  	   {
     	  		  style: 
     	  		   {
     	  			   color: 'white'
     	  		   }
     	       }
     	        
     	    },
     	    plotOptions: {
     	    	series:{stacking:'normal',animation:false,
     	    	}
     	    },
     	    legend:
     	         {
     	    	   reversed:true,backgroundColor:'#fafafa',
     	    	   enabled: false
     	    	 },
     	    series: [{
     	        name:duration_name,
     	        data: timeduration

     	    } ]
     	});	
 	     },
        error:function(){
        	//alert("fail")
        }
    });

	
	
	$.ajax({
        type: 'POST',
        url:contextpath+"/getDataByLanguage" ,
        contentType: "application/json",
	    dataType: 'html',
	    data: JSON.stringify(obj),
        success: function(data){
         var language=[];
         var timeduration=[];
         var duration_name;
         var response=$.parseJSON(data);
         for(var i=0;i<response.length;i++){
        	 language.push(response[i].language);
        	 timeduration.push(response[i].timeduration);
        	 duration_name=response[0].duration_name;
         }
     	Highcharts.chart('bar-graph3', {
     	    chart: {
     	        type: 'bar',
     	        inverted:true,
     	    	polar:false,
     	    	backgroundColor:'#606870',
     	    	//height: '80%'
     	    },
     	    title: {
     	        text: 'By Language',
     	        style: {color: 'white'}
     	    },
     	    subtitle: {
     	        text: ''
     	    },
     	    xAxis: {
     	        categories: language,
     	        crosshair: true,
     	        labels:
     	  	  {  style: 
     	  	     { 
     	  		   color: 'white'
     	  	     }
     	       } 
     	    },
     	    yAxis: {
     	    	 labels: 
     	  	   {
     	  		  style: 
     	  		   {
     	  			   color: 'white'
     	  		   }
     	       }
     	        
     	    },
     	    /*tooltip: {
     	        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
     	        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
     	            '<td></td></tr>',
     	        footerFormat: '</table>',
     	        shared: true,
     	        useHTML: true
     	    },*/
     	    plotOptions: {
     	    	series:{stacking:'normal',animation:false,
     	    	}
     	    },
     	    legend:
     	         {
     	    	   reversed:true,backgroundColor:'#fafafa',
     	    	   enabled: false
     	    	 },
     	    series: [{
     	        name:duration_name,
     	        data: timeduration,
                
     	    } ]
     	});	
 	     },
        error:function(){
        	//alert("fail")
        }
    });

	

	
	//Hourly Playouts

	$.ajax({
        type: 'POST',
        url:contextpath+"/getDataByHourlyPlayout" ,
        contentType: "application/json",
	    dataType: 'html',
	    data: JSON.stringify(obj),
        success: function(data){
         var timeduration=[];
         var hours=[];
         var response=$.parseJSON(data);
         var duration_name;
         for(var i=0;i<response.length;i++){
        	 timeduration.push(response[i].timeduration);
        	 hours.push(response[i].hours);
        	 duration_name=response[0].duration_name;
         }
         
     	Highcharts.chart('morris-line-example', {
		    chart: {
		        type: 'area',
		        polar:false,
		        backgroundColor:"#606870",
		    },
		    title: {
		        text: 'Hourly Playouts',
		        style: {color: 'white'}
		    },
		    subtitle: {
		        text: ''
		    },
		    legend:{
		    	layout:'vertical',align:'right',
		    	verticalAlign:'middle',enabled: false
		    	},

		    xAxis: {
		        allowDecimals: false,
		        categories:hours,
		        labels: {
		        	style: {color: 'white'},
		        }
		    },
		    yAxis: {
		      
		        labels: {
		        	style: {color: 'white'},
		            formatter: function () {
		                return this.value;
		            }
		        }
		    },
		 /*   tooltip: {
		        pointFormat: '{series.name} had stockpiled <b>{point.y:,.0f}</b><br/>warheads in {point.x}'
		    },*/
		    plotOptions: {
		        area: {
		            //pointStart: 2018-04-10,
		            marker: {
		                enabled: false,
		                symbol: 'circle',
		                radius: 2,
		                states: {
		                    hover: {
		                        enabled: true
		                    }
		                }
		            }
		        }
		    },
		    series: [{
		        name: duration_name,
		        data:timeduration
		    }]
		});	

 	     },
        error:function(){
        	//alert("fail")
        }
    });

	
	
	$.ajax({
        type: 'POST',
        url:contextpath+"/getDataByDailyPlayout" ,
        contentType: "application/json",
	    dataType: 'html',
	    data: JSON.stringify(obj),    
        success: function(data){
         var timeduration=[];
         var date=[];
         var duration_name;
         var response=$.parseJSON(data);
         for(var i=0;i<response.length;i++){
        	 timeduration.push(response[i].timeduration);
        	 date.push(response[i].date);
        	 duration_name=response[0].duration_name;
         }
          
     	Highcharts.chart('morris-area-example', {
		    chart: {
		        type: 'area',
		        polar:false,
		        backgroundColor:"#606870",
		    },
		    title: {
		        text: 'Daily Playouts',
		        style: {color: 'white'}
		    }, 
		    subtitle: {
		        text: ''
		    },
		    legend:{
		    	layout:'vertical',align:'right',
		    	verticalAlign:'middle',enabled: false
		    	},

		    xAxis: {
		        allowDecimals: false,
		        categories:date,
		        labels: {
		        	style: {color: 'white'},
		        }
		    },
		    yAxis: {
		      
		        labels: {
		        	style: {color: 'white'},
		            formatter: function () {
		                return this.value;
		            }
		        }
		    },
		 /*   tooltip: {
		        pointFormat: '{series.name} had stockpiled <b>{point.y:,.0f}</b><br/>warheads in {point.x}'
		    },*/
		    plotOptions: {
		        area: {
		            //pointStart: 2018-04-10,
		            marker: {
		                enabled: false,
		                symbol: 'circle',
		                radius: 2,
		                states: {
		                    hover: {
		                        enabled: true
		                    }
		                }
		            }
		        }
		    },
		    series: [{
		        name: duration_name,
		        data:timeduration
		    }]
		});	

 	     },
        error:function(){
        	//alert("fail")
        }
    });	
	
	
	//Bar Graph4
	(function(){ var files = ["https://code.highcharts.com/stock/highstock.js",
	"https://code.highcharts.com/highcharts-more.js","https://code.highcharts.com/highcharts-3d.js",
	"https://code.highcharts.com/modules/data.js",
	"https://code.highcharts.com/modules/funnel.js",
	"https://code.highcharts.com/modules/annotations.js",
	"https://code.highcharts.com/modules/solid-gauge.js"],
	loaded = 0; if (typeof window["HighchartsEditor"] === "undefined") 
	{window.HighchartsEditor = {ondone: [cl],hasWrapped: false,hasLoaded: false};include(files[0]);} 
	else {if (window.HighchartsEditor.hasLoaded) {cl();} else {window.HighchartsEditor.ondone.push(cl);}}
	function isScriptAlreadyIncluded(src){var scripts = document.getElementsByTagName("script");
	for (var i = 0; i < scripts.length; i++) {if (scripts[i].hasAttribute("src")) 
	{if ((scripts[i].getAttribute("src") || "").indexOf(src) >= 0 || 
	(scripts[i].getAttribute("src") === "http://code.highcharts.com/highcharts.js" 
	&& src === "https://code.highcharts.com/stock/highstock.js")) {return true;}}}return false;}
	function check() {if (loaded === files.length) {for (var i = 0; i < window.HighchartsEditor.ondone.length; i++) 
	{try {window.HighchartsEditor.ondone[i]();} catch(e) {console.error(e);}}window.HighchartsEditor.hasLoaded = true;}}
	function include(script) {function next() {++loaded;if (loaded < files.length) {include(files[loaded]);}check();}
	if (isScriptAlreadyIncluded(script)) {return next();}var sc=document.createElement("script");
	sc.src = script;sc.type="text/javascript";sc.onload=function() { next(); };document.head.appendChild(sc);}
	function each(a, fn){if (typeof a.forEach !== "undefined")
	{a.forEach(fn);}else{for (var i = 0; i < a.length; i++){if (fn) {fn(a[i]);}}}}var inc = {},incl=[]; 
	each(document.querySelectorAll("script"), function(t) {inc[t.src.substr(0, t.src.indexOf("?"))] = 1; }); 
	function cl() {if(typeof window["Highcharts"] !== "undefined")
	{var options={"title":{"text":"Top Brands", style: {color: 'white'}},"subtitle":{"text":""},"exporting":{},
	"chart":
	  {
		"type":"bar","inverted":true,
		"polar":false,"backgroundColor":"#606870"
	 },
	"xAxis": 
	  { 
		 labels:
		  {  style: 
		     {
			   color: 'white'
		     }
	     }
	   }, 
	   
	 "yAxis": 
	    {
		  labels: 
		   {
			  style: 
			   {
				   color: 'white'
			   }
	     }
	   },
	"legend":{"reversed":true,"backgroundColor":"#fafafa","enabled": false},
	"plotOptions":{"series":{"stacking":"normal","animation":false}},
	"series":[{"name":"John","turboThreshold":0}],
	//{"name":"Jane","turboThreshold":0},{"name":"Joe","turboThreshold":0}],
	//"data":{"csv":"\"Category\";\"John\";\"Apples\";5\"Oranges\";3\,"googleSpreadsheetKey":false,"googleSpreadsheetWorksheet":false}};
	"data":{"csv":"\"Category\";\"Genre\"\n\"Entertainment\";5\n\"Movies\";3\n\"News\";4\n\"Music\";7\n\"Lifestyle\";2\n\"Kids\";2","googleSpreadsheetKey":false,"googleSpreadsheetWorksheet":false}};
	/*
	// Sample of extending options:
	Highcharts.merge(true, options, {
	    chart: {
	        backgroundColor: "#bada55"
	    },
	    plotOptions: {
	        series: {
	            cursor: "pointer",
	            events: {
	                click: function(event) {
	                    alert(this.name + " clicked\n" +
	                          "Alt: " + event.altKey + "\n" +
	                          "Control: " + event.ctrlKey + "\n" +
	                          "Shift: " + event.shiftKey + "\n");
	                }
	            }
	        } 
	    }
	});
	*/new Highcharts.Chart("bar-graph4", options);}}})();

		}

/*function getData(data){
	
	alert("inside get data"); 
	data=[];
	data.push(byCategory);
}*/
      
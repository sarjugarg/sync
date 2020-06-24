
var delayInMilliseconds = 4000; 
var chart1;
var chart2;
var chart3;
var chart4;
var chart5;
 
var chart33="";
var chart34=""; 
var chart44="";
type = ['primary', 'info', 'success', 'warning', 'danger'];
demo = {

 /* initPickColor: function() {

    $('.pick-class-label').click(function() {
      var new_class = $(this).attr('new-class');
      var old_class = $('#display-buttons').attr('data-class');
      var display_div = $('#display-buttons');
      if (display_div.length) {
        var display_buttons = display_div.find('.btn');
        display_buttons.removeClass(old_class);
        display_buttons.addClass(new_class);
        display_div.attr('data-class', new_class);
      }
    });
  },
  
*/  
 /* initDocChart: function() {

	    
    chartColor = "#FFFFFF";
    // General configuration for the charts with Line gradientStroke
    gradientChartOptionsConfiguration = {
      maintainAspectRatio: false,
      legend: {
        display: false
      },
      tooltips: {
        bodySpacing: 4,
        mode: "nearest",
        intersect: 0,
        position: "nearest",
        xPadding: 10,
        yPadding: 10,
        caretPadding: 10
      },
      responsive: true,
      scales: {
        yAxes: [{
          display: 0,
          gridLines: 0,
          ticks: {
            display: false
          },
          gridLines: {
            zeroLineColor: "transparent",
            drawTicks: false,
            display: false,
            drawBorder: false
          }
        }],
        xAxes: [{
          display: 0,
          gridLines: 0,
          ticks: {
            display: false
          },
          gridLines: {
            zeroLineColor: "transparent",
            drawTicks: false,
            display: false,
            drawBorder: false
          }
        }]
      },
      layout: {
        padding: {
          left: 0,
          right: 0,
          top: 15,
          bottom: 15
        }
      }
    };

    
    
    
    ctx = document.getElementById('lineChartExample').getContext("2d");
    gradientStroke = ctx.createLinearGradient(500, 0, 100, 0);
    gradientStroke.addColorStop(0, '#80b6f4');
    gradientStroke.addColorStop(1, chartColor);

    gradientFill = ctx.createLinearGradient(0, 170, 0, 50);
    gradientFill.addColorStop(0, "rgba(128, 182, 244, 0)");
    gradientFill.addColorStop(1, "rgba(249, 99, 59, 0.40)");
   
    myChart = new Chart(ctx, {
      type: 'line',
      responsive: true,
      data: {
        labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
        datasets: [{
          label: "Active Users",
          borderColor: "#f96332",
          pointBorderColor: "#FFF",
          pointBackgroundColor: "#f96332",
          pointBorderWidth: 2,
          pointHoverRadius: 4,
          pointHoverBorderWidth: 1,
          pointRadius: 4,
          fill: true,
          backgroundColor: gradientFill,
          borderWidth: 2,
          data: [542, 480, 430, 550, 530, 453, 380, 434, 568, 610, 700, 630]
        }]
      },
      options: gradientChartOptionsConfiguration
    });
  },  
*///hedfdsf
		
		
		
 
  
  
  initGoogleMaps: function() {
    var myLatlng = new google.maps.LatLng(40.748817, -73.985428);
    var mapOptions = {
      zoom: 13,
      center: myLatlng,
      scrollwheel: false, //we disable de scroll over the map, it is a really annoing when you scroll through page
      styles: [{
          "elementType": "geometry",
          "stylers": [{
            "color": "#1d2c4d"
          }]
        },
        {
          "elementType": "labels.text.fill",
          "stylers": [{
            "color": "#8ec3b9"
          }]
        },
        {
          "elementType": "labels.text.stroke",
          "stylers": [{
            "color": "#1a3646"
          }]
        },
        {
          "featureType": "administrative.country",
          "elementType": "geometry.stroke",
          "stylers": [{
            "color": "#4b6878"
          }]
        },
        {
          "featureType": "administrative.land_parcel",
          "elementType": "labels.text.fill",
          "stylers": [{
            "color": "#64779e"
          }]
        },
        {
          "featureType": "administrative.province",
          "elementType": "geometry.stroke",
          "stylers": [{
            "color": "#4b6878"
          }]
        },
        {
          "featureType": "landscape.man_made",
          "elementType": "geometry.stroke",
          "stylers": [{
            "color": "#334e87"
          }]
        },
        {
          "featureType": "landscape.natural",
          "elementType": "geometry",
          "stylers": [{
            "color": "#023e58"
          }]
        },
        {
          "featureType": "poi",
          "elementType": "geometry",
          "stylers": [{
            "color": "#283d6a"
          }]
        },
        {
          "featureType": "poi",
          "elementType": "labels.text.fill",
          "stylers": [{
            "color": "#6f9ba5"
          }]
        },
        {
          "featureType": "poi",
          "elementType": "labels.text.stroke",
          "stylers": [{
            "color": "#1d2c4d"
          }]
        },
        {
          "featureType": "poi.park",
          "elementType": "geometry.fill",
          "stylers": [{
            "color": "#023e58"
          }]
        },
        {
          "featureType": "poi.park",
          "elementType": "labels.text.fill",
          "stylers": [{
            "color": "#3C7680"
          }]
        },
        {
          "featureType": "road",
          "elementType": "geometry",
          "stylers": [{
            "color": "#304a7d"
          }]
        },
        {
          "featureType": "road",
          "elementType": "labels.text.fill",
          "stylers": [{
            "color": "#98a5be"
          }]
        },
        {
          "featureType": "road",
          "elementType": "labels.text.stroke",
          "stylers": [{
            "color": "#1d2c4d"
          }]
        },
        {
          "featureType": "road.highway",
          "elementType": "geometry",
          "stylers": [{
            "color": "#2c6675"
          }]
        },
        {
          "featureType": "road.highway",
          "elementType": "geometry.fill",
          "stylers": [{
            "color": "#9d2a80"
          }]
        },
        {
          "featureType": "road.highway",
          "elementType": "geometry.stroke",
          "stylers": [{
            "color": "#9d2a80"
          }]
        },
        {
          "featureType": "road.highway",
          "elementType": "labels.text.fill",
          "stylers": [{
            "color": "#b0d5ce"
          }]
        },
        {
          "featureType": "road.highway",
          "elementType": "labels.text.stroke",
          "stylers": [{
            "color": "#023e58"
          }]
        },
        {
          "featureType": "transit",
          "elementType": "labels.text.fill",
          "stylers": [{
            "color": "#98a5be"
          }]
        },
        {
          "featureType": "transit",
          "elementType": "labels.text.stroke",
          "stylers": [{
            "color": "#1d2c4d"
          }]
        },
        {
          "featureType": "transit.line",
          "elementType": "geometry.fill",
          "stylers": [{
            "color": "#283d6a"
          }]
        },
        {
          "featureType": "transit.station",
          "elementType": "geometry",
          "stylers": [{
            "color": "#3a4762"
          }]
        },
        {
          "featureType": "water",
          "elementType": "geometry",
          "stylers": [{
            "color": "#0e1626"
          }]
        },
        {
          "featureType": "water",
          "elementType": "labels.text.fill",
          "stylers": [{
            "color": "#4e6d70"
          }]
        }
      ]
    };

    var map = new google.maps.Map(document.getElementById("map"), mapOptions);

    var marker = new google.maps.Marker({
      position: myLatlng,
      title: "Hello World!"
    });

    // To add the marker to the map, call setMap();
    marker.setMap(map);
  },

  showNotification: function(from, align) {
    color = Math.floor((Math.random() * 4) + 1); 

    $.notify({
      icon: "tim-icons icon-bell-55",
      message: "Welcome to <b>Black Dashboard</b> - a beautiful freebie for every web developer."

    }, {
      type: type[color],
      timer: 8000,
      placement: {
        from: from,
        align: align
      }
    });
  }

};
   
function topProductsGraph(objResponse,fromdate,todate,text){
        var slctSubcat= $(".ProductList");
	var Html="";   
         slctSubcat.empty(); 
             for(var i=0; i<objResponse.length; i++){
            	 var maxLength = 20;
            	 var productname=objResponse[i].productname;
            	 var result;
            		 result=productname;
            	 
            	 var time_duration=""; 
            	 if(objResponse[i].duration_name=='Playout'){
            		 time_duration= objResponse[i].timeduration;
            	 } 
            	 else{
            		 time_duration=toHHMMSS(objResponse[i].timeduration); 
            	 }  
            	   if(objResponse[i].logo=='NA'){
            	 Html='<div class="element-list"  data-toggle="tooltip" title="'+productname+'" > <div class="Pr-logo" style="position:relative;" ><img style="position:absolute; margin:auto;" onerror="this.src="./resources/images/no_img.png""   src="./resources/images/no_img.png" /> </div> <p> <a id="product'+i+'" onclick="singleProductPage('+i+')"  style="color:rgb(85,206,249);" href="#" ">'  +result+'</a></p><span class="countColor"> ' +time_duration+'</span></div>';
                       $('.ProductList').append(Html);         
            	   }
            	   else{
                  	 Html='<div class="element-list"  data-toggle="tooltip" title="'+productname+'" > <div class="Pr-logo" style="position:relative;" ><img style="position:absolute; margin:auto;" onerror="this.src="./resources/images/no_img.png""   src='+objResponse[i].logoUrl+(objResponse[i].logo).replace(/ /g, '%20')+' /> </div> <p> <a id="product'+i+'" onclick="singleProductPage('+i+')"   style="color:rgb(85,206,249);" href="#" ">'+result+'</a></p><span class="countColor">'+time_duration+'</span></div>';
                  	 
                         $('.ProductList').append(Html);          		   
            	   }	   
             }    
} 

function topChannelGraph(resp){
         var productnamearr=[];	  
         var obj2;
         var duration_name;
     	var time_duration=[];
    	var seriesname=[]; 
        var chart1data;	
         if(resp!=null || resp !=""){
         for(var i=0;i<resp.length;i++){
      	   productnamearr.push({"name":resp[i].streamname,"y":resp[i].timeduration});
      	   seriesname.push(resp[i].streamname);
      	   time_duration.push(resp[i].timeduration);
      	 chart1data={label:resp[i].streamname,
      			 value:resp[i].timeduration}
         } 
           
         }    
         var time_duration2=[34,32,23,22,34];
         var ctx = document.getElementById("chartLinePurple").getContext("2d");
         var randomColorGenerator = function () {
             return '#' + (Math.random().toString(16) + '0000000').slice(2, 8);
          };
          var ict_unit = [];
          var efficiency = [];
          var coloR = [];

          var dynamicColors = function() {
             var r = Math.floor(Math.random() * 255);
             var g = Math.floor(Math.random() * 255);
             var b = Math.floor(Math.random() * 255);
             return "rgb(" + r + "," + g + "," + b + ")";
          };
    
          for (var i in resp) {
             ict_unit.push("ICT Unit " + resp[i].ict_unit);
             efficiency.push(resp[i].efficiency);
             coloR.push(dynamicColors());
          }
         var data={}
         data = {
         labels:seriesname, 
         //labels: ['Star Plus', 'Zee Cinema', '&TV', 'Neo Sports', 'Discovery', 'Zee TV'],
           datasets: [{
             backgroundColor: [
                 "#2ecc71",
                 "#3498db",
                 "#95a5a6",
                 "#9b59b6",
                 "#f1c40f",
                 "#e74c3c",
                 "#34495e",
                 "pink",
                 "rgb(186, 255, 167)",
                 "cyan"
                 ], 
             //backgroundColor: gradientStroke,
             //borderColor: '#d048b6',  
        	 //backgroundColor :coloR,    
         //backgroundColor: ["#0074D9", "#FF4136", "#2ECC40", "#FF851B", "#7FDBFF", "#B10DC9", "#FFDC00", "#001f3f", "#39CCCC", "#01FF70", "#85144b", "#F012BE", "#3D9970", "#111111", "#AAAAAA"],
             borderWidth: 1,
             borderDash: [],
             borderDash: 0.0,
             pointBackgroundColor: '#d048b6',
             pointBorderColor: 'rgba(255,255,255,0)',
             pointHoverBackgroundColor: '#d048b6',
             pointBorderWidth: 10,
             pointHoverRadius: 4,
             pointHoverBorderWidth: 15,
             pointRadius: 4,  
            //data: [20, 200, 70, 56, 120, 80],
             data:time_duration,
           }]
         };
           
        var pieChartOptionsConfiguration = {
         	      maintainAspectRatio: false,
         	      legend: {
         	        display: false
         	      },
         	      tooltips: {
         	        bodySpacing: 4,
         	        mode: "nearest",
         	        intersect: 0,
         	        position: "nearest",
         	        xPadding: 10,
         	        yPadding: 10,
         	        caretPadding: 10
         	      },
         	      responsive: true,
         	      scales: {
         	        yAxes: [{
         	          display: 0,
         	          gridLines: 0,
         	          ticks: {
         	            display: false
         	          },
         	          gridLines: {
         	            zeroLineColor: "transparent",
         	            drawTicks: false,
         	            display: false,
         	            drawBorder: false
         	          }
         	        }],
         	        xAxes: [{
         	          display: 0,
         	          gridLines: 0,
         	          ticks: {
         	            display: false
         	          },
         	          gridLines: {
         	            zeroLineColor: "transparent",
         	            drawTicks: false,
         	            display: false,
         	            drawBorder: false
         	          }
         	        }]
         	      },
         	      layout: {
         	        padding: {
         	          left: 0,
         	          right: 0,
         	          top: 15,
         	          bottom: 15
         	        }
         	      }
         	    };
        if(chart1) chart1.destroy();
        chart1 = new Chart(ctx, {
           type: 'doughnut',
           data: data, 
           options: pieChartOptionsConfiguration
           
         });
         var gradientStroke = ctx.createLinearGradient(0, 230, 0, 50);

         gradientStroke.addColorStop(1, 'rgba(66,134,121,0.15)');
         gradientStroke.addColorStop(0.4, 'rgba(66,134,121,0.0)'); //green colors
         gradientStroke.addColorStop(0, 'rgba(66,134,121,0)'); //green colors
       
 
}  
 
function byCategoryGraph(objResponse){
	         var categoryname=[];
	         var timeduration=[];
	         var name="";
	         for(var i=0;i<objResponse.length;i++){
	        	 categoryname.push(objResponse[i].categoryname);
	        	 timeduration.push(objResponse[i].timeduration);
	        	 name=objResponse[0].duration_name;
	         }  
	         var slctSubcat= $(".chart-area");
	         var ctx = document.getElementById("CountryChart").getContext("2d");
	    
	         var gradientStroke = ctx.createLinearGradient(0, 230, 0, 50);

	         //gradientStroke.addColorStop(1, 'rgba(29,140,248,0.2)');
	         //gradientStroke.addColorStop(1, '#1f8ef1');
	         gradientStroke.addColorStop(1, 'rgb(85, 206, 249)');
	         gradientStroke.addColorStop(0.4, 'rgb(85, 206, 249)');
	         gradientStroke.addColorStop(0, 'rgb(85, 206, 249)'); //blue colors
    
	         if(chart2) chart2.destroy();
	          chart2 = new Chart(ctx, {
	           type: 'horizontalBar',
	           responsive: true,
	           legend: {
	             display: false
	           }, 
	           data: {
	             //labels: ["Entertainment", "Movies", "News", "Music", "Lifestyle", "Sports"], 
	             labels:categoryname,
	        	   datasets: [{
	               label:name,
	               fill: true, 
	               backgroundColor: gradientStroke,
	               hoverBackgroundColor: gradientStroke,
	               borderColor: gradientStroke,
	               borderWidth: 2,
	               borderDash: [],
	               borderDashOffset: 0.0,
	               data:timeduration
	             }]
	           },
	           options: gradientBarChartConfiguration
	         });

	 
	                  }



function byLanguageGraph(response){
	         var language=[];
	         var timeduration=[];
	         var duration_name;
	         for(var i=0;i<response.length;i++){
	        	   
	        	 language.push(response[i].language);
	        	/* if(language.length> 2){
	        		 language.substring(0,20)+"...";
	        	 }
	        	 */
	        	 timeduration.push(response[i].timeduration);
	        	 duration_name=response[0].duration_name;
	         }
	         
	         
	         var ctxGreen = document.getElementById("chartLineGreen").getContext("2d");
	         var gradientStroke = ctxGreen.createLinearGradient(0, 230, 0,50);
    
	//         gradientStroke.addColorStop(1, '#00d6b4');
	         gradientStroke.addColorStop(1, 'rgb(85, 206, 249)');
	         gradientStroke.addColorStop(0.2, 'rgb(85, 206, 249)');
	         gradientStroke.addColorStop(0, 'rgb(85, 206, 249)'); //purple colors
 
	         
	         var data = {
	           labels: language,
	           datasets: [{
	               //label:,
	               fill: true, 
	               backgroundColor: gradientStroke,
	               hoverBackgroundColor: gradientStroke,
	               //borderColor: '#00d6b4',
	               borderColor:'rgb(85, 206, 249)',
	               borderWidth: 2,    
	               borderDash: [],
	               borderDashOffset: 0.0,
	             data:timeduration,
	           }]
	         }; 
	         if(chart3) chart3.destroy();
	          chart3 = new Chart(ctxGreen, {
	           type: 'horizontalBar',
	           data: data,
	           options: gradientChartOptionsConfigurationWithTooltipGreen

	         });

}
var bodercolor1;  
function dailyplayoutgraph(response,gradientColor1, gradientColor2, opacity,id){
         var timeduration=[];
         var date=[];
         var duration_name;
         for(var i=0;i<response.length;i++){
        	 timeduration.push(response[i].timeduration);
        	 date.push(response[i].date);
        	 duration_name=response[0].duration_name;
         }
         var color1 = gradientColor1;
     	var color2 = gradientColor2;
         if(gradientColor1.includes("#")){
     		color1 = hexToRgb(gradientColor1);
     	}
     	if(gradientColor2.includes("#")){
     		color2= hexToRgb(gradientColor2);
     	}

         var ctx = document.getElementById(id).getContext("2d");
         /*var gradientStroke = ctx.createLinearGradient(0, 230, 0, 50);

         gradientStroke.addColorStop(1, 'rgba(72,72,176,0.2)');
         gradientStroke.addColorStop(0.2, 'rgba(72,72,176,0.0)');
         gradientStroke.addColorStop(0, 'rgba(119,52,169,0)'); //purple colors

*/
         
         var gradientStroke = ctx.createLinearGradient(0, 500, 0, 100);
         gradientStroke.addColorStop(0, color1.replace(')', ', '+opacity+')').replace('rgb', 'rgba'));
         gradientStroke.addColorStop(1, color2.replace(')', ', '+opacity+')').replace('rgb', 'rgba')); //pink colors
         
         var lineGradientStroke = ctx.createLinearGradient(500, 0, 100, 0);
         lineGradientStroke.addColorStop(0, gradientColor1);
         lineGradientStroke.addColorStop(1, gradientColor2); //pink colors
         
         var data = {
         		 labels: date,
         	        datasets: [{
         	          label:duration_name,
         	          fill: true,
         	         backgroundColor: gradientStroke,
        	          borderColor:lineGradientStroke,
        	          borderWidth: 2,
        	          borderDash: [],
        	          borderDashOffset: 0.0,
        	          pointBackgroundColor: gradientColor1.replace(')', ', '+opacity+')').replace('rgb', 'rgba'),
        	          pointBorderColor: 'rgba(255,255,255,0)',
        	          pointHoverBackgroundColor:gradientColor1,
        	          pointBorderWidth: 20,
        	          pointHoverRadius: 4,
        	          pointHoverBorderWidth: 15,
        	          pointRadius: 4,
        	          data: timeduration,
           }]
         };  
         
      //   if(chart44) chart44.destroy();
         chart44 = new Chart(ctx, {
           type: 'line',
           data: data,
           options: gradientChartOptionsConfigurationWithTooltipPurple
           
         });
}


function hourghlyplayout(data,gradientColor1, gradientColor2, opacity,id){
	var responseObject=$.parseJSON(data);
    	var timeduration=[];
    	var hours=[];  
    	var duration_name;
    	var color1 = gradientColor1;
    	var color2 = gradientColor2;
 		if(gradientColor1.includes("#")){
			color1 = hexToRgb(gradientColor1);
		}
		if(gradientColor2.includes("#")){
			color2= hexToRgb(gradientColor2);
		}
		
	    var hourlyunits=document.getElementById("hourlyunits").value;
	    if(hourlyunits=='AM'){
	    	for(var i=0;i<12;i++){
	       	 timeduration.push(responseObject[i].timeduration);
	       	 hours.push(responseObject[i].hours);
	       	 duration_name=responseObject[0].duration_name;
	        }
	    	
	    }else if(hourlyunits=='PM'){
	    	for(var i=12;i<24;i++){
	       	 timeduration.push(responseObject[i].timeduration);
	       	 hours.push(responseObject[i].hours);
	       	 duration_name=responseObject[0].duration_name;
	        }
	    	
	    }
	     
	    else{
	    	for(var i=0;i<responseObject.length;i++){
	       	 timeduration.push(responseObject[i].timeduration);
	       	 hours.push(responseObject[i].hours);
	       	 duration_name=responseObject[0].duration_name;
	        }
		
	    }
/*	    $('[id^="hourlyPlayoutLineChart"]').each(function( ) {
    	alert($(this).attr('id'));
       if($.trim( $(this).html() ).length==0){
 
    	   var val=$(this).attr('id');
    
    
*/    	   
    	    
      		 var   ctx = document.getElementById(id).getContext("2d");	   
    	     var gradientStroke = ctx.createLinearGradient(0, 500, 0, 100);
    	     gradientStroke.addColorStop(0, color1.replace(')', ', '+opacity+')').replace('rgb', 'rgba'));
    	     gradientStroke.addColorStop(1, color2.replace(')', ', '+opacity+')').replace('rgb', 'rgba')); //pink colors
    	     
    	     var lineGradientStroke = ctx.createLinearGradient(500, 0, 100, 0);
    	     lineGradientStroke.addColorStop(0, gradientColor1);
    	     lineGradientStroke.addColorStop(1, gradientColor2); //pink colors

    	     var data = {
    	     		 labels: hours,
    	     	        datasets: [{ 
    	     	          label: duration_name,
    	     	          fill: true,
    	     	          backgroundColor: gradientStroke,
    	     	          borderColor:lineGradientStroke,
    	     	          borderWidth: 2,
    	     	          borderDash: [],
    	     	          borderDashOffset: 0.0,
    	     	          pointBackgroundColor: gradientColor1.replace(')', ', '+opacity+')').replace('rgb', 'rgba'),
    	     	          pointBorderColor: 'rgba(255,255,255,0)',
    	     	          pointHoverBackgroundColor:gradientColor1,
    	     	          pointBorderWidth: 20,
    	     	          pointHoverRadius: 4,
    	     	          pointHoverBorderWidth: 15,
    	     	          pointRadius: 4,
    	     	          data: timeduration,
    	       }]
    	     };
   
    	   /*  if(chart34){
    	    	 chart34.destroy();
    	     }*/
    	     
    	     chart34 = new Chart(ctx, {
    	       type: 'line',
    	       data: data,
    	       options: gradientChartOptionsConfigurationWithTooltipPurple2
    	       
     	     });
    	/*     
  return false;     
       }
       else{
       }
    });*/
     } 



function hourghlyplayout2(data,gradientColor1, gradientColor2, opacity,id,dropdownid){
	var responseObject=$.parseJSON(data);
    	var timeduration=[];
    	var hours=[];  
    	var duration_name;
    	var color1 = gradientColor1;
    	var color2 = gradientColor2;
 		if(gradientColor1.includes("#")){
			color1 = hexToRgb(gradientColor1);
		}
		if(gradientColor2.includes("#")){
			color2= hexToRgb(gradientColor2);
		}
		
	    var hourlyunits=document.getElementById(""+dropdownid+"").value;
	    if(hourlyunits=='AM'){
	    	for(var i=0;i<12;i++){
	       	 timeduration.push(responseObject[i].timeduration);
	       	 hours.push(responseObject[i].hours);
	       	 duration_name=responseObject[0].duration_name;
	        }
	    	
	    }else if(hourlyunits=='PM'){
	    	for(var i=12;i<24;i++){
	       	 timeduration.push(responseObject[i].timeduration);
	       	 hours.push(responseObject[i].hours);
	       	 duration_name=responseObject[0].duration_name;
	        }
	    	
	    }
	     
	    else{
	    	for(var i=0;i<responseObject.length;i++){
	       	 timeduration.push(responseObject[i].timeduration);
	       	 hours.push(responseObject[i].hours);
	       	 duration_name=responseObject[0].duration_name;
	        }
		
	    }
/*	    $('[id^="hourlyPlayoutLineChart"]').each(function( ) {
    	alert($(this).attr('id'));
       if($.trim( $(this).html() ).length==0){
 
    	   var val=$(this).attr('id');
    
    
*/    	   
    	    
      		 var   ctx = document.getElementById(id).getContext("2d");	   
      		 var canvas= document.getElementById(id);
      		 var gradientStroke = ctx.createLinearGradient(0, 500, 0, 100);
    	     gradientStroke.addColorStop(0, color1.replace(')', ', '+opacity+')').replace('rgb', 'rgba'));
    	     gradientStroke.addColorStop(1, color2.replace(')', ', '+opacity+')').replace('rgb', 'rgba')); //pink colors
    	     
    	     var lineGradientStroke = ctx.createLinearGradient(500, 0, 100, 0);
    	     lineGradientStroke.addColorStop(0, gradientColor1);
    	     lineGradientStroke.addColorStop(1, gradientColor2); //pink colors

    	     var data = {
    	     		 labels: hours,
    	     	        datasets: [{ 
    	     	          label: duration_name,
    	     	          fill: true,
    	     	          backgroundColor: gradientStroke,
    	     	          borderColor:lineGradientStroke,
    	     	          borderWidth: 2,
    	     	          borderDash: [],
    	     	          borderDashOffset: 0.0,
    	     	          pointBackgroundColor: gradientColor1.replace(')', ', '+opacity+')').replace('rgb', 'rgba'),
    	     	          pointBorderColor: 'rgba(255,255,255,0)',
    	     	          pointHoverBackgroundColor:gradientColor1,
    	     	          pointBorderWidth: 20,
    	     	          pointHoverRadius: 4,
    	     	          pointHoverBorderWidth: 15,
    	     	          pointRadius: 4,
    	     	          data: timeduration,
    	       }]
    	     };
    	   /*  if(chart33){
    	    	 chart33.destroy();
    	     }*/
    	     chart33 = new Chart(ctx, {
    	       type: 'line',
    	       data: data,
    	       options: gradientChartOptionsConfigurationWithTooltipPurple2
    	       
     	     });
    	/*     
  return false;     
       }
       else{
       }
    });*/
     } 


function channelsListGraph(objResponse,fromdate,todate,text){
    var slctSubcat= $(".ChannelList");
    var Html="";  
 
     slctSubcat.empty(); 
         for(var i=0; i<objResponse.length; i++){
        	 var maxLength = 20;
        	 var channelname=objResponse[i].streamname;
        	 var result;
        	 var time_duration=""; 
        	 if(objResponse[i].duration_name=='Playout'){
        		 time_duration= objResponse[i].timeduration;
        	 } 
        	 else{
        		 time_duration=toHHMMSS(objResponse[i].timeduration); 
        	 }
        	 result=channelname;
        	/* if(channelname.length>20){
        		 result = channelname.substring(0, maxLength) + '...';
        	 }   
        	 else{ 
        		 result=channelname;
        	 }*/
        	 var channelLogo;
        	   if(objResponse[i].logo=='NA'){
        		   channelLogo='./resources/images/no_img.png';
        	   }
        	   else{
        		   channelLogo=objResponse[i].logoUrl+objResponse[i].logo;
        	   }
       	     Html="<div class='element-list' data-toggle='tooltip' title='"+channelname+"'><div class='Pr-logo' style='position:relative;' ><img style='position:absolute;margin:auto;' onerror='this.src='./resources/images/no_img.png''   src='"+channelLogo.replace(/ /g, "%20")+"' /></div> <p> <a style='color:rgb(85,206,249);' onclick='singleChannelPage("+objResponse[i].cid+")' href='#'>"  +result+"</a></p><span > "   +  time_duration+"</span></div>";
               $('.ChannelList').append(Html);         
                }    
} 


gradientChartOptionsConfigurationWithTooltipBlue = {
	      maintainAspectRatio: false,
	      legend: {
	        display: false
	      },

	      tooltips: {
	        backgroundColor: '#f5f5f5',
	        titleFontColor: '#333',
	        bodyFontColor: '#666',
	        bodySpacing: 4,
	        xPadding: 12,
	        mode: "nearest",
	        intersect: 0,
	        position: "nearest"
	      },
	      responsive: true,
	      scales: {
	        yAxes: [{
	          barPercentage: 1.6,
	          gridLines: {
	            drawBorder: false,
	            color: 'rgba(29,140,248,0.0)',
	            zeroLineColor: "transparent",
	          },
	          ticks: {
	            suggestedMin: 60,
	            suggestedMax: 125,
	            padding: 20,
	            fontColor: "#2380f7"
	          }
	        }],

	        xAxes: [{
	          barPercentage: 1.6,
	          gridLines: {
	            drawBorder: false,
	            color: 'rgba(29,140,248,0.1)',
	            zeroLineColor: "transparent",
	          },
	          ticks: {
	            padding: 20,
	            fontColor: "#2380f7"
	          }
	        }]
	      }
	    };

	    gradientChartOptionsConfigurationWithTooltipPurple = {
	      maintainAspectRatio: false,
	      legend: {
	        display: false
	      },

	      tooltips: {
	    	  /*callbacks: {
	    	         title: function() {}
	    	      },*/
	        backgroundColor: '#f5f5f5',
	        titleFontColor: '#333',
	        bodyFontColor: '#666',
	        bodySpacing: 4,
	        xPadding: 12,
	        mode: "nearest",
	        intersect: 0,
	        position: "nearest"
	      },
	      responsive: true,
	      scales: {
	        yAxes: [{
	        	
	          barPercentage: 1.6,
	          gridLines: {
/*	            drawBorder: false,
	            color: 'rgba(29,140,248,0.0)',
	            zeroLineColor: "transparent",
*/	        display:false
}
	        ,
	          ticks: {
	            suggestedMin: 60,
	            suggestedMax: 125,
	       	  autoSkip: true,	  
	            maxTicksLimit: 7,
	        	  padding: 20,
	            fontColor: "rgba(0,0,0,.87)",
	            callback: function(value) {
	                var ranges = [
	                   { divider: 1e6, suffix: 'M' },
	                   { divider: 1e3, suffix: 'K' }
	                ];
	                function formatNumber(n) {
	                   for (var i = 0; i < ranges.length; i++) {
	                      if (n >= ranges[i].divider) {
	                         return (n / ranges[i].divider).toString() + ranges[i].suffix;
	                      }
	                   }
	                   return n;
	                }
	                return   formatNumber(value);
	             }
	        
	          },
	          
	        }],
 
	        xAxes: [{
	        	/*type: 'date',
	            time: {
	                displayFormats: {
	                	'millisecond': 'DD MMM',
	                    'second': 'DD MMM',
	                    'minute': 'DD MMM',
	                    'hour': 'DD MMM',
	                    'day': 'DD MMM',
	                    'week': 'DD MMM',
	                    'month': 'DD MMM',
	                    'quarter': 'DD MMM',
	                    'year': 'DD MMM',
	                }
		        },*/   
	        	
	        	type: 'time',
	            time: {
	              unit: 'day',
	              unitStepSize: 1,
	              displayFormats: {
	                 'day': 'MMM DD'
	              }
	            },
	        	barPercentage: 1.6,
	          gridLines: {
/*	            drawBorder: false,
	            color: 'rgba(225,78,202,0.1)',
	            zeroLineColor: "transparent",
*/
	        	  display:false
	        	  },
	          ticks: {
	            padding: 20,
	           fontColor: "rgba(0,0,0,.87)",
	            maxRotation: 0,
	        /*   maxRotation: 90,
               minRotation: 90  , */
	            //minTicksLimit:4,
		       	  autoSkip: true,	  
		            maxTicksLimit: 7,
		            minTicksLimit: 7
	          },
	           
	        }]
	      }
	    };
	    
	    gradientChartOptionsConfigurationWithTooltipPurple2 = {
	  	      maintainAspectRatio: false,
	  	      legend: {
	  	        display: false
	  	      },

	  	      tooltips: {
	  	   /* 	callbacks: {
	    	         title: function() {}
	    	    },*/  
	  	        backgroundColor: '#f5f5f5',
	  	        titleFontColor: '#333',
	  	        bodyFontColor: '#666',
	  	        bodySpacing: 4,
	  	        xPadding: 12,
	  	        mode: "nearest",
	  	        intersect: 0,
	  	        position: "nearest"
	  	      },
	  	      responsive: true,
	  	      scales: {
	  	        yAxes: [{
	  	          barPercentage: 1.6,
	  	          gridLines: {
	  	            drawBorder: false,
	  	            color: 'rgba(29,140,248,0.0)',
	  	            zeroLineColor: "transparent",
	  	          },
	  	          ticks: {
	  	            suggestedMin: 60,
	  	            suggestedMax: 125,
	  	       	  autoSkip: true,	  
		            maxTicksLimit: 7,
 
	  	            padding: 20,
	  	            fontColor: "rgba(0,0,0,.87)",
	  	          callback: function(value) {
		                var ranges = [
		                   { divider: 1e6, suffix: 'M' },
		                   { divider: 1e3, suffix: 'K' } 
		                ];
		                function formatNumber(n) {
		                   for (var i = 0; i < ranges.length; i++) {
		                      if (n >= ranges[i].divider) {
		                         return (n / ranges[i].divider).toString() + ranges[i].suffix;
		                      }
		                   }
		                   return n;
		                }
		                return   formatNumber(value);
		             }
	  	          }
	  	        }],

	  	        xAxes: [{
	  	          barPercentage: 1.6,
	  	          gridLines: {
	  	        	display:false
	  	    /*        drawBorder: false,
	  	            color: 'rgba(225,78,202,0.1)',
	  	            zeroLineColor: "transparent",*/
	  	          },
	  	          ticks: {
	  	            padding: 20,
	  	          fontColor: "rgba(0,0,0,.87)",
	  	       	  autoSkip: true,	  
		            maxTicksLimit:12,
	  	            maxRotation: 0,
	  	          minTicksLimit:12
	  	            /*
	                  minRotation: 90  */
	  	          }
	  	        }]
	  	      }
	  	    };

	    gradientChartOptionsConfigurationWithTooltipOrange = {
	      maintainAspectRatio: false,
	      legend: {
	        display: false
	      }, 

	      tooltips: {
	        backgroundColor: '#f5f5f5',
	        titleFontColor: '#333',
	        bodyFontColor: '#666',
	        bodySpacing: 4,
	        xPadding: 12,
	        mode: "nearest",
	        intersect: 0,
	        position: "nearest"
	      },
	      responsive: true,
	      scales: {
	        yAxes: [{
	          barPercentage: 1.6,
	          gridLines: {
/*	            drawBorder: false,
	            color: 'rgba(29,140,248,0.0)',
	            zeroLineColor: "transparent",
*/
	        	  display:false
	        	  },
	          ticks: {
	            suggestedMin: 50,
	            suggestedMax: 110,
	            padding: 20,
             fontColor: "rgba(0,0,0,.87)",
	          }
	        }],

	        xAxes: [{
	          barPercentage: 1.6,
	          gridLines: {
	            drawBorder: false,
	            color: 'rgba(220,53,69,0.1)',
	            zeroLineColor: "transparent",
	          },
	          ticks: {
	        	  autoSkip: true,	  
	            padding: 20,
	            fontColor: "black" ,
	          
	          }
	        }]
	      }
	    };

	    gradientChartOptionsConfigurationWithTooltipGreen = {
	      maintainAspectRatio: false,
	      legend: {
	        display: false
	      }, 
          
	      tooltips: {
	    	  callbacks: {
	    	         title: function() {}
	    	      },
	        backgroundColor: '#f5f5f5',
	      /*  titleFontColor: '#333',*/
	        bodyFontColor: '#666',
	        bodySpacing: 4,
	        xPadding: 12,
	        mode: "nearest",
	        intersect: 0,
	        position: "nearest"
	      },
	      responsive: true,
	      scales: {
	        yAxes: [{
	          //barPercentage: 1.6,
	          gridLines: {
	            /*drawBorder: false,
	            color: 'rgba(0,242,195,0.1)',
	            zeroLineColor: "transparent",*/
	        	  display:false
	          },
	          ticks: {
	            suggestedMin: 50,
	            suggestedMax: 125,
	            padding: 20,
	            fontColor: "black"
	            
	          }
	        }],

	        xAxes: [{
	          barPercentage: 1.6,
	          gridLines: {
/*	            drawBorder: false,
	            color: 'rgba(0,242,195,0.1)',
	            zeroLineColor: "transparent",*/
	        	  display:false,
	     
	              
	          },
	          ticks: {
	            padding: 20,
	            fontColor: "black",
	         	  callback: function(value) {
		                var ranges = [
		                   { divider: 1e6, suffix: 'M' },
		                   { divider: 1e3, suffix: 'K' }
		                ];
		                function formatNumber(n) {
		                   for (var i = 0; i < ranges.length; i++) {
		                      if (n >= ranges[i].divider) {
		                         return (n / ranges[i].divider).toString() + ranges[i].suffix;
		                      }
		                   }
		                   return n;
		                }
		                return   formatNumber(value);
		             }     
	          }
	        }]
	      }
	    };


	    gradientBarChartConfiguration = {
	      maintainAspectRatio: false,
	      legend: {
	        display: false
	      },

	      tooltips: {
	        backgroundColor: '#f5f5f5',
	        titleFontColor: '#333',
	        bodyFontColor: '#666',
	        bodySpacing: 4,
	        xPadding: 12,
	        mode: "nearest",
	        intersect: 0,
	        position: "nearest"
	      },
	      responsive: true,
	      scales: {
	        yAxes: [{

	          gridLines: {
/*	            drawBorder: false,
	            color: 'rgba(29,140,248,0.1)',
	            zeroLineColor: "transparent",
*/           display:false
	        	  },
	          ticks: {
	            suggestedMin: 60,
	            suggestedMax: 120,
	            padding: 20,
	            fontColor: "black",
	             
	          }
	        }],

	        xAxes: [{

	          gridLines: {
	         /*   drawBorder: false,
	            color: 'rgba(29,140,248,0.1)',
	            zeroLineColor: "transparent",*/
	        	  display:false
	          },
	          ticks: {
	            padding: 20,
	            fontColor: "black",
	            callback: function(value) {
	                var ranges = [
	                   { divider: 1e6, suffix: 'M' },
	                   { divider: 1e3, suffix: 'K' }
	                ];
	                function formatNumber(n) {
	                   for (var i = 0; i < ranges.length; i++) {
	                      if (n >= ranges[i].divider) {
	                         return (n / ranges[i].divider).toString() + ranges[i].suffix;
	                      }
	                   }
	                   return n;
	                }
	                return   formatNumber(value);
	             }
	           }
	        }]
	      }
	    }; 


 function initDashboardPageCharts(){

    var rp;
    
 dataByLanguage(rp);
   /* var selectedVal ;
	var selected = $("input[name='options']:checked");
	if (selected.length > 0) {
	    selectedVal = selected.val();
	}
	//alert(selectedVal);
    var days=document.getElementById("date_range").value; // Days you want to subtract
	//var days="2018-04-10";
    var date = new Date();
	var last = new Date(date.getTime() - (days * 24 * 60 * 60 * 1000));
	var day =last.getDate();
	var month=last.getMonth()+1;
	var year=last.getFullYear();
	var fromdate=year+"-"+month+"-"+day;
	var today=date.getDate(); 
	var current_month=date.getMonth()+1;
	var current_year=date.getFullYear();
	var todate=current_year+"-"+current_month+"-"+today;
	var fromdate=year+"-"+month+"-"+day;
	var dataArray=[];
	var jsonarray=[];
	var limit=document.getElementById("limit").value;
	//alert("limit = " +limit)
	if(limit ==""){
		limit ='10';
	}  
    var obj={startdate:fromdate,
             enddate:todate,
             limit:limit,
             time:selectedVal
    };
    jsonarray.push(obj);
     
	    //Hourly
	//hourghlyplayout(obj);
*/

  }; 
  
  function hexToRgb(hex) {
		var result = /^#?([a-f\d]{2})([a-f\d]{2})([a-f\d]{2})$/i.exec(hex);
	    
	    var r = parseInt(result[1], 16);
	    var g = parseInt(result[2], 16);
	    var b = parseInt(result[3], 16);
	   

	    return "rgb("+r + "," + g + "," + b+")";
	}
                
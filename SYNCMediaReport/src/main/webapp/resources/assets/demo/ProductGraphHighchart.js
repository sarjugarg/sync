function topChannelHighchart(resp, chartid) {

	var productnamearr = [];
	var obj2;
	var duration_name;
	var time_duration = [];
	var seriesname = [];
	var chart1data;
	if (resp != null || resp != "") {
		for (var i = 0; i < resp.length; i++) {
			productnamearr.push({
				"name" : resp[i].streamname,
				"y" : resp[i].timeduration
			});
			seriesname.push(resp[i].streamname);
			time_duration.push(resp[i].timeduration);
			duration_name = resp[0].duration_name;
			chart1data = {
				label : resp[i].streamname,
				value : resp[i].timeduration
			}
		}

	}
	// topChannelGraph(resp);
	var chartLinePurple = document.getElementById(chartid);
	var pieColors = (function() {
		var colors = [], base = Highcharts.getOptions().colors[0], i;

		for (i = 0; i < 10; i += 1) {
			// Start out with a darkened base color (negative brighten), and end
			// up with a much brighter color
			colors.push(Highcharts.Color(base).brighten((i - 6) / 10).get());
		}
		return colors;
	}());
	var chart = new Highcharts.Chart({

		chart : {
			renderTo : chartLinePurple,
			type : 'pie',
			polar : false,
			// backgroundColor:"#606870",
			// backgroundColor:"#32325d"
			backgroundColor : false
		},
		tooltip : {
			formatter : function() {

				return this.point.name + ': ' + this.y;
			}
		},
		title : {
			text : "",
			style : {
				color : 'white'
			}
		},
		plotOptions : {
			pie : {
				allowPointSelect : true,
				cursor : true,
				colors : pieColors,
				size : '145',
				innerSize : '77%',
				dataLabels : {
					enabled : false
				},
				shadow : false,
				center : [ '50%', '20%' ],
				showInLegend : true,
				borderWidth : 0.7
			},

		},
		legend : {
			align : 'right',
			layout : 'vertical',
			verticalAlign : 'top',
			enabled : true,
			x : 40,
			y : 20,
			itemStyle : {
				fontSize : '8px',
				// font: '20pt Trebuchet MS, Verdana, sans-serif',
				color : '#rgba(0,0,0,.87)',
				fontWeight : 100

			},

		},
		series : [ {
			colorByPoint : true,
			name : duration_name,
			data : productnamearr,


		} ]

	});

}




function topChannelHighchart2(resp, chartid,colorCode1, colorCode2) {
	var productnamearr = [];
	var obj2;
	var duration_name;
	var time_duration = [];
	var seriesname = [];
	var chart1data;
	if (resp != null || resp != "") {
		for (var i = 0; i < resp.length; i++) {
			productnamearr.push({
				"name" : resp[i].streamname,
				"y" : resp[i].timeduration
			});
			seriesname.push(resp[i].streamname);
			time_duration.push(resp[i].timeduration);
			duration_name = resp[0].duration_name;
			chart1data = {
				label : resp[i].streamname,
				value : resp[i].timeduration
			}
		}
	}
	
	var color1 = colorCode1;
	var color2 = colorCode2;
/*	if(colorCode1.includes("#")){
 		color1 = hexToRgb(colorCode1);
 	}
 	if(colorCode2.includes("#")){
 		color2= hexToRgb(colorCode2);
 	}
*/	// topChannelGraph(resp);
	$('#resizer').resizable({
	    // On resize, set the chart size to that of the 
	    // resizer minus padding. If your chart has a lot of data or other
	    // content, the redrawing might be slow. In that case, we recommend 
	    // that you use the 'stop' event instead of 'resize'.
	    resize: function() {
	        chart.setSize(
	            this.offsetWidth - 20, 
	            this.offsetHeight - 20,
	            false
	        );
	    }
	});


	var chartLinePurple = document.getElementById(chartid);
	var pieColors = (function() { 
		var colors = [], base =colorCode1  ,i;
  
		for (i = 0; i <time_duration.length; i += 1) {
			// Start out with a darkened base color (negative brighten), and end
			// up with a much brighter color
			  
			colors.push(Highcharts.Color(base).brighten((i - 2) / time_duration.length).get());
		}
		/*var spitter = updateSpitter(color1, color2, time_duration.length);*/
		return colors;
	}());
	
	var chart = new Highcharts.Chart({

		chart : {
			renderTo : chartLinePurple,
			type : 'pie',
			polar : false,
			// backgroundColor:"#606870",
			// backgroundColor:"#32325d"
			backgroundColor : false
		},
		tooltip : {
			formatter : function() {

				return this.point.name + ': ' + this.y;
			}
		},
		title : {
			text : "",
			style : {
				color : 'white'
			}
		},
		plotOptions : {
			pie : {
				allowPointSelect : true,
				cursor : true,
				colors : pieColors,
				size : '170',
				innerSize : '77%',
				dataLabels : {
					enabled : false
				},
				shadow : false, 
				center : [ '40%', '50%' ],
				borderWidth: 0.5,
				showInLegend : true,
			},

		},
		legend : {
			 layout: 'vertical',
		        align: 'right',
		        y: 5, 
		        x:-150,
		        navigation: {
		            activeColor: 'black',
		            inactiveColor: 'rgb(204, 204, 204)'
		          },
		        verticalAlign: 'top',
		        itemStyle : {
					fontSize : '8px',
					// font: '20pt Trebuchet MS, Verdana, sans-serif',
					color : 'rgba(0,0,0,.87)',
					fontWeight : 100

				},

			/*align : 'right',
			layout : 'vertical',
			verticalAlign : 'top',
			enabled : true,
			x : 20,
			y : 20,
			itemStyle : {
				fontSize : '8px',
				// font: '20pt Trebuchet MS, Verdana, sans-serif',
				color : '#rgba(0,0,0,.87)',
				fontWeight : 100,
		        maxHeight: 210,
		        overflow: 'auto' 
			},*/
			

		},
		series : [ {
			colorByPoint : true,
			name : duration_name,
			data : productnamearr,


		} ]

	});
	
// Get Gradient Color Array Start CALL updateSpitter() ----- 
		
		var val1El;
		var val2El;
		var stepsEl;

		// constants for switch/case checking representation type
		const HEX = 1;
		const RGB = 2;
		const RGBA = 3;

		// get the string representation 
		// type and set it on the element (HEX/RGB/RGBA)
		function getType(val) {
		  if (val.indexOf('#') > -1) return 'HEX';
		  if (val.indexOf('rgb(') > -1) return 'RGB';
		  if (val.indexOf('rgba(') > -1) return 'RGBA';
		}

		// process the value irrespective of representation type
		function processValue(el, value) {
		  switch (el) {
		    case 'HEX':
		      {
		        return processHEX(value);
		      }
		    case 'RGB':{
		      return processRGB(value);
		    }
		    case 'RGBA':{
		      return processRGB(value);
		    }
		      
		  }
		}

		//return a workable RGB int array [r,g,b] from rgb/rgba representation
		function processRGB(val){
		  var rgb = val.split('(')[1].split(')')[0].split(',');
		  return [
		      parseInt(rgb[0],10),
		      parseInt(rgb[1],10),
		      parseInt(rgb[2],10)
		  ];
		}

		//return a workable RGB int array [r,g,b] from hex representation
		function processHEX(val) {
		  //does the hex contain extra char?
		  var hex = (val.length >6)?val.substr(1, val.length - 1):val;
		  // is it a six character hex?
		  if (hex.length > 3) {

		    //scrape out the numerics
		    var r = hex.substr(0, 2);
		    var g = hex.substr(2, 2);
		    var b = hex.substr(4, 2);

		    // if not six character hex,
		    // then work as if its a three character hex
		  } else {

		    // just concat the pieces with themselves
		    var r = hex.substr(0, 1) + hex.substr(0, 1);
		    var g = hex.substr(1, 1) + hex.substr(1, 1);
		    var b = hex.substr(2, 1) + hex.substr(2, 1);

		  }
		  // return our clean values
		    return [
		      parseInt(r, 16),
		      parseInt(g, 16),
		      parseInt(b, 16)
		    ]
		}

		function updateSpitter(color1, color2, steps) {
		    //attach start value
		    var hasSpun = 0;
		    var color1Type = getType(color1);
		    var color2Type = getType(color2);
		   /* val1El.dataType = getType(color1);
		    val2El.dataType = getType(color2);*/

		    var val1RGB = processValue(color1Type, color1);
		    var val2RGB = processValue(color2Type, color2);
		    var colors = [
		      // somewhere to dump gradient
		    ];
		    // the pre element where we spit array to user
		    var spitter = [];

		    //the number of steps in the gradient
		    var stepsInt = steps;
		    //the percentage representation of the step
		    var stepsPerc = 100 / (stepsInt+1);

		    // diffs between two values 
		    var valClampRGB = [
		      val2RGB[0] - val1RGB[0],
		      val2RGB[1] - val1RGB[1],
		      val2RGB[2] - val1RGB[2]
		    ];
		  
		    // build the color array out with color steps
		    for (var i = 0; i < stepsInt; i++) {
		      var clampedR = (valClampRGB[0] > 0) 
		      ? pad((Math.round(valClampRGB[0] / 100 * (stepsPerc * (i + 1)))).toString(16), 2) 
		      : pad((Math.round((val1RGB[0] + (valClampRGB[0]) / 100 * (stepsPerc * (i + 1))))).toString(16), 2);
		      
		      var clampedG = (valClampRGB[1] > 0) 
		      ? pad((Math.round(valClampRGB[1] / 100 * (stepsPerc * (i + 1)))).toString(16), 2) 
		      : pad((Math.round((val1RGB[1] + (valClampRGB[1]) / 100 * (stepsPerc * (i + 1))))).toString(16), 2);
		      
		      var clampedB = (valClampRGB[2] > 0) 
		      ? pad((Math.round(valClampRGB[2] / 100 * (stepsPerc * (i + 1)))).toString(16), 2) 
		      : pad((Math.round((val1RGB[2] + (valClampRGB[2]) / 100 * (stepsPerc * (i + 1))))).toString(16), 2);
		      
		      colors[i] = [
		        '#',
		        clampedR,
		        clampedG,
		        clampedB
		      ].join('');
		      colors[i] = hexToRgb(colors[i]);
		    }
		  //build div representation of gradient
		/*  var html = [];
		    for(var i = 0;i<colors.length;i++){
		      html.push("<div class='color' style='background-color:"+colors[i]+"; height:"+((i-(i-1))/colors.length*100)+"%;'></div>");
		    }*/
		 /*document.getElementById("colors").innerHTML = html.join('');*/
		    //update the pre element
		    spitter = colors;
		    return spitter;
		  }
		  /**
		   * padding function:
		   * cba to roll my own, thanks Pointy!
		   * ==================================
		   * source: http://stackoverflow.com/questions/10073699/pad-a-number-with-leading-zeros-in-javascript
		   */
		
		function hexToRgb(hex) {
			var result = /^#?([a-f\d]{2})([a-f\d]{2})([a-f\d]{2})$/i.exec(hex);
		    
		    var r = parseInt(result[1], 16);
		    var g = parseInt(result[2], 16);
		    var b = parseInt(result[3], 16);
		   

		    return "rgba("+r + "," + g + "," + b+")";
		}
		
		function pad(n, width, z) {
		  z = z || '0';
		  n = n + '';
		  return n.length >= width ? n : new Array(width - n.length + 1).join(z) + n;
		}
		/*updateSpitter();*/
	}

//Get Gradient Color Array END ----- 

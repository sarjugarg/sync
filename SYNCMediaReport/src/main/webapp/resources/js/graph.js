

/* (function(){ var files = ["https://code.highcharts.com/stock/highstock.js",
"https://code.highcharts.com/highcharts-more.js","https://code.highcharts.com/highcharts-3d.js",
"https://code.highcharts.com/modules/data.js",
"https://code.highcharts.com/modules/funnel.js","https://code.highcharts.com/modules/annotations.js",
"https://code.highcharts.com/modules/solid-gauge.js"],
loaded = 0; if (typeof window["HighchartsEditor"] === "undefined") 
{window.HighchartsEditor = {ondone: [cl],hasWrapped: false,hasLoaded: false};include(files[0]);}
 else {if (window.HighchartsEditor.hasLoaded) {cl();} else {window.HighchartsEditor.ondone.push(cl);}}
 function isScriptAlreadyIncluded(src){var scripts = document.getElementsByTagName("script");
 for (var i = 0; i < scripts.length; i++) {if (scripts[i].hasAttribute("src")) {if ((scripts[i].getAttribute("src") || "").indexOf(src) >= 0 ||
 (scripts[i].getAttribute("src") === "http://code.highcharts.com/highcharts.js" && src === "https://code.highcharts.com/stock/highstock.js"))
 {return true;}}}return false;}function check() {if (loaded === files.length) {for (var i = 0; i < window.HighchartsEditor.ondone.length; i++)
	 {try {window.HighchartsEditor.ondone[i]();} catch(e) {console.error(e);}}window.HighchartsEditor.hasLoaded = true;}}function include(script) 
	 {function next() {++loaded;if (loaded < files.length) {include(files[loaded]);}check();}if (isScriptAlreadyIncluded(script)) 
	 {return next();}var sc=document.createElement("script");sc.src = script;sc.type="text/javascript";sc.onload=function() { next(); };
 document.head.appendChild(sc);}function each(a, fn){if (typeof a.forEach !== "undefined"){a.forEach(fn);}else{for (var i = 0; i < a.length; i++)
 {if (fn) {fn(a[i]);}}}}var inc = {},incl=[]; each(document.querySelectorAll("script"), function(t) {inc[t.src.substr(0, t.src.indexOf("?"))] = 1; }); 
function cl() {if(typeof window["Highcharts"] !== "undefined"){var options={"title":{"text":"Genre Wise Channel", style: {color: 'white'}},
"subtitle":{"text":""},"exporting":{},   
"chart":{"type":"pie","polar":false,backgroundColor:"#757c7f",},"plotOptions":{"pie":{"allowPointSelect":true,"cursor":true,"innerSize":"60%","dataLabels":{"enabled":false},
"shadow":false,"center":["50%","50%"]},"series":{"animation":false}},"tooltip":{"valueSuffix":"%"},
"series":[{"name":"Browsers","turboThreshold":0,"size":"60%","dataLabels":{"color":"#ffffff","distance":-30}},
{"name":"Versions","turboThreshold":0,"size":"80%","innerSize":"60%","dataLabels":{},"id":"versions"}],
"responsive":{"rules":[{"condition":{"maxWidth":400},"chartOptions":{"series":[{"id":"versions",
"dataLabels":{"enabled":false}}]},"_id":"highcharts-sl7alni-55"}]},
//"data":{"firefox","25"},
"data":{"csv":"\"Category\";\"Browsers\";\"Versions\"\n\"Chrome\";62.74\n\"Chrome v65.0\";;0.1\n\"Firefox\";10.57\n\"Chrome v64.0\";;1.3\n\"Internet Explorer\";7.23\n\"Chrome v63.0\";;53.02\n\"Safari\";5.58\n\"Chrome v62.0\";;1.4\n\"Edge\";4.02\n\"Chrome v61.0\";;0.88\n\"Opera\";1.92\n\"Chrome v60.0\";;0.56\n\"Chrome v59.0\";;0.45\n\"Chrome v58.0\";;0.49\n\"Chrome v57.0\";;0.32\n\"Chrome v56.0\";;0.29\n\"Chrome v55.0\";;0.79\n\"Chrome v54.0\";;0.18\n\"Chrome v51.0\";;0.13\n\"Chrome v49.0\";;2.16\n\"Chrome v48.0\";;0.13\n\"Chrome v47.0\";;0.11\n\"Chrome v43.0\";;0.17\n\"Chrome v29.0\";;0.26\n\"Firefox v58.0\";;1.02\n\"Firefox v57.0\";;7.36\n\"Firefox v56.0\";;0.35\n\"Firefox v55.0\";;0.11\n\"Firefox v54.0\";;0.1\n\"Firefox v52.0\";;0.95\n\"Firefox v51.0\";;0.15\n\"Firefox v50.0\";;0.1\n\"Firefox v48.0\";;0.31\n\"Firefox v47.0\";;0.12\n\"Internet Explorer v11.0\";;6.2\n\"Internet Explorer v10.0\";;0.29\n\"Internet Explorer v9.0\";;0.27\n\"Internet Explorer v8.0\";;0.47\n\"Safari v11.0\";;3.39\n\"Safari v10.1\";;0.96\n\"Safari v10.0\";;0.36\n\"Safari v9.1\";;0.54\n\"Safari v9.0\";;0.13\n\"Safari v5.1\";;0.2\n\"Edge v16\";;2.6\n\"Edge v15\";;0.92\n\"Edge v14\";;0.4\n\"Edge v13\";;0.1\n\"Opera v50.0\";;0.96\n\"Opera v49.0\";;0.82\n\"Opera v12.1\";;0.14\n\"Other\";7.62;7.62",
"googleSpreadsheetKey":false,"googleSpreadsheetWorksheet":false}};/*

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

new Highcharts.Chart("morris-bar-stacked22", options);}}})();
*/

//Donut graph2
 (function(){ var files = ["https://code.highcharts.com/stock/highstock.js",
"https://code.highcharts.com/highcharts-more.js","https://code.highcharts.com/highcharts-3d.js",
"https://code.highcharts.com/modules/data.js",
"https://code.highcharts.com/modules/funnel.js","https://code.highcharts.com/modules/annotations.js",
"https://code.highcharts.com/modules/solid-gauge.js"],
loaded = 0; if (typeof window["HighchartsEditor"] === "undefined") 
{window.HighchartsEditor = {ondone: [cl],hasWrapped: false,hasLoaded: false};include(files[0]);}
 else {if (window.HighchartsEditor.hasLoaded) {cl();} else {window.HighchartsEditor.ondone.push(cl);}}
 function isScriptAlreadyIncluded(src){var scripts = document.getElementsByTagName("script");
 for (var i = 0; i < scripts.length; i++) {if (scripts[i].hasAttribute("src")) {if ((scripts[i].getAttribute("src") || "").indexOf(src) >= 0 ||
 (scripts[i].getAttribute("src") === "http://code.highcharts.com/highcharts.js" && src === "https://code.highcharts.com/stock/highstock.js"))
 {return true;}}}return false;}function check() {if (loaded === files.length) {for (var i = 0; i < window.HighchartsEditor.ondone.length; i++)
	 {try {window.HighchartsEditor.ondone[i]();} catch(e) {console.error(e);}}window.HighchartsEditor.hasLoaded = true;}}function include(script) 
	 {function next() {++loaded;if (loaded < files.length) {include(files[loaded]);}check();}if (isScriptAlreadyIncluded(script)) 
	 {return next();}var sc=document.createElement("script");sc.src = script;sc.type="text/javascript";sc.onload=function() { next(); };
 document.head.appendChild(sc);}function each(a, fn){if (typeof a.forEach !== "undefined"){a.forEach(fn);}else{for (var i = 0; i < a.length; i++)
 {if (fn) {fn(a[i]);}}}}var inc = {},incl=[]; each(document.querySelectorAll("script"), function(t) {inc[t.src.substr(0, t.src.indexOf("?"))] = 1; }); 
function cl() {if(typeof window["Highcharts"] !== "undefined"){var options={"title":{"text":"Top Categories", style: {color: 'white'}},
"subtitle":{"text":""},"exporting":{},
"chart":{"type":"pie","polar":false,backgroundColor:"#757c7f"},"plotOptions":{"pie":{"allowPointSelect":true,"cursor":true,"innerSize":"60%","dataLabels":{"enabled":false},
"shadow":false,"center":["50%","50%"]},"series":{"animation":false}},"tooltip":{"valueSuffix":"%"},
"series":[{"name":"Browsers","turboThreshold":0,"size":"60%","dataLabels":{"color":"#ffffff","distance":-30}},
{"name":"Versions","turboThreshold":0,"size":"80%","innerSize":"60%","dataLabels":{},"id":"versions"}],
"responsive":{"rules":[{"condition":{"maxWidth":400},"chartOptions":{"series":[{"id":"versions",
"dataLabels":{"enabled":false}}]},"_id":"highcharts-sl7alni-55"}]},
//"data":{"firefox","25"},
"data":{"csv":"\"Category\";\"Browsers\";\"Versions\"\n\"Chrome\";62.74\n\"Chrome v65.0\";;0.1\n\"Firefox\";10.57\n\"Chrome v64.0\";;1.3\n\"Internet Explorer\";7.23\n\"Chrome v63.0\";;53.02\n\"Safari\";5.58\n\"Chrome v62.0\";;1.4\n\"Edge\";4.02\n\"Chrome v61.0\";;0.88\n\"Opera\";1.92\n\"Chrome v60.0\";;0.56\n\"Chrome v59.0\";;0.45\n\"Chrome v58.0\";;0.49\n\"Chrome v57.0\";;0.32\n\"Chrome v56.0\";;0.29\n\"Chrome v55.0\";;0.79\n\"Chrome v54.0\";;0.18\n\"Chrome v51.0\";;0.13\n\"Chrome v49.0\";;2.16\n\"Chrome v48.0\";;0.13\n\"Chrome v47.0\";;0.11\n\"Chrome v43.0\";;0.17\n\"Chrome v29.0\";;0.26\n\"Firefox v58.0\";;1.02\n\"Firefox v57.0\";;7.36\n\"Firefox v56.0\";;0.35\n\"Firefox v55.0\";;0.11\n\"Firefox v54.0\";;0.1\n\"Firefox v52.0\";;0.95\n\"Firefox v51.0\";;0.15\n\"Firefox v50.0\";;0.1\n\"Firefox v48.0\";;0.31\n\"Firefox v47.0\";;0.12\n\"Internet Explorer v11.0\";;6.2\n\"Internet Explorer v10.0\";;0.29\n\"Internet Explorer v9.0\";;0.27\n\"Internet Explorer v8.0\";;0.47\n\"Safari v11.0\";;3.39\n\"Safari v10.1\";;0.96\n\"Safari v10.0\";;0.36\n\"Safari v9.1\";;0.54\n\"Safari v9.0\";;0.13\n\"Safari v5.1\";;0.2\n\"Edge v16\";;2.6\n\"Edge v15\";;0.92\n\"Edge v14\";;0.4\n\"Edge v13\";;0.1\n\"Opera v50.0\";;0.96\n\"Opera v49.0\";;0.82\n\"Opera v12.1\";;0.14\n\"Other\";7.62;7.62",
"googleSpreadsheetKey":false,"googleSpreadsheetWorksheet":false}};/*

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
*/new Highcharts.Chart("morris-donut-example2", options);}}})();


//Bar Graph1
(function(){ var files = ["https://code.highcharts.com/stock/highstock.js",
"https://code.highcharts.com/highcharts-more.js","https://code.highcharts.com/highcharts-3d.js",
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
sc.src = script;sc.type="text/javascript";sc.onload=function() { next(); };document.head.appendChild(sc);}
function each(a, fn){if (typeof a.forEach !== "undefined")
{a.forEach(fn);}else{for (var i = 0; i < a.length; i++){if (fn) {fn(a[i]);}}}}var inc = {},incl=[]; 
each(document.querySelectorAll("script"), function(t) {inc[t.src.substr(0, t.src.indexOf("?"))] = 1; }); 
function cl() {if(typeof window["Highcharts"] !== "undefined")
{var options={"title":{"text":"Genre Wise Playout", style: {color: 'white'}},"subtitle":{"text":""},"exporting":{},
"chart":{"type":"bar","inverted":true,"polar":false,"backgroundColor":"#757c7f"},
"xAxis": {labels: {style: {color: 'white'}}},"yAxis": {labels: {style: {color: 'white'}}},
"legend":{"reversed":true,"backgroundColor":"#fafafa","enabled": false},
"plotOptions":{"series":{"stacking":"normal","animation":false}},"series":[{"name":"John","turboThreshold":0}],
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
*/new Highcharts.Chart("bar-graph1", options);}}})();




//Bar Graph2
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
"chart":{"type":"bar","inverted":true,"polar":false,"backgroundColor":"#757c7f"},
"xAxis": {labels: {style: {color: 'white'}}},"yAxis": {labels: {style: {color: 'white'}}},
"legend":{"reversed":true,"backgroundColor":"#fafafa","enabled": false},
"plotOptions":{"series":{"stacking":"normal","animation":false}},"series":[{"name":"John","turboThreshold":0}],
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
*/new Highcharts.Chart("bar-graph2", options);}}})();




//Bar Graph3
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
{var options={"title":{"text":"Genre Wise Playout", style: {color: 'white'}},"subtitle":{"text":""},"exporting":{},
"chart":{"type":"bar","inverted":true,"polar":false,"backgroundColor":"#757c7f"},
"xAxis": {labels: {style: {color: 'white'}}},"yAxis": {labels: {style: {color: 'white'}}},
"legend":{"reversed":true,"backgroundColor":"#fafafa","enabled": false},
"plotOptions":{"series":{"stacking":"normal","animation":false}},"series":[{"name":"John","turboThreshold":0}],
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
*/new Highcharts.Chart("bar-graph3", options);}}})();





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
"chart":{"type":"bar","inverted":true,"polar":false,"backgroundColor":"#757c7f"},
"xAxis": {labels: {style: {color: 'white'}}},"yAxis": {labels: {style: {color: 'white'}}},
"legend":{"reversed":true,"backgroundColor":"#fafafa","enabled": false},
"plotOptions":{"series":{"stacking":"normal","animation":false}},"series":[{"name":"John","turboThreshold":0}],
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
 {var options={"title":{"text":"Hourly Playouts", style: {color: 'white'}},"subtitle":{"text":""},"exporting":{},
"xAxis": {labels: {style: {color: 'white'}}},"yAxis": {labels: {style: {color: 'white'}}},
"chart":{"type":"line","backgroundColor":"#757c7f"},
"legend":{"layout":"vertical","align":"right","verticalAlign":"middle","enabled": false},
"plotOptions":{"series":{"label":{"connectorAllowed":false,},"pointStart":2010,"animation":false}},
 "series":[{"name":"Installation"},{"name":"Manufacturing"},{"name":"Sales &amp; Distribution"},{"name":"Project Development"},{"name":"Other"}],"responsive":{"rules":[{"condition":{"maxWidth":500},
 "chartOptions":{"legend":{"layout":"horizontal","align":"center","verticalAlign":"bottom"}},"_id":"highcharts-iv8bxqs-44"}]},
 "data":{"csv":"\"Category\";\"Installation\";\"Manufacturing\";\"Sales &amp; Distribution\";\"Project Development\";\"Other\"\n2010;43934; \n2011;52503;\n2012;57177;\n2013;69658;\n2014;97031;\n2015;119931;\n2016;137133;\n2017;154175;","googleSpreadsheetKey":false,"googleSpreadsheetWorksheet":false}};/*
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
*/new Highcharts.Chart("morris-line-example", options);}}})();


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
"chart":{"type":"area","polar":false,"backgroundColor":"#757c7f"},
"legend":{"layout":"vertical","align":"right","verticalAlign":"middle","enabled": false},
"plotOptions":{"series":{"label":{"connectorAllowed":false},"pointStart":2010,"animation":false}},
"series":[{"name":"Installation"},{"name":"Manufacturing"},{"name":"Sales &amp; Distribution"},{"name":"Project Development"},{"name":"Other"}],"responsive":{"rules":[{"condition":{"maxWidth":500},
"chartOptions":{"legend":{"layout":"horizontal","align":"center","verticalAlign":"bottom"}},"_id":"highcharts-iv8bxqs-44"}]},
"data":{"csv":"\"Category\";\"Installation\";\"Manufacturing\";\"Sales &amp; Distribution\";\"Project Development\";\"Other\"\n2010;43934;\n2011;52503;\n2012;57177;\n2013;69658;\n2014;97031;\n2015;119931;\n2016;137133;\n2017;154175;","googleSpreadsheetKey":false,"googleSpreadsheetWorksheet":false}};/*
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
*/new Highcharts.Chart("morris-area-example", options);}}})();



var colors = Highcharts.getOptions().colors,
    categories = [
        'Chrome',
        'Firefox',
        'Internet Explorer',
        'Safari',
        'Edge',
        'Opera',
        'Other'
    ],
    data = [
        {
            y: 62.74,
            color: colors[2],
            drilldown: {
                name: 'Chrome',
                categories: [
                    'Chrome v65.0',
                    'Chrome v64.0',
                    'Chrome v63.0',
                ],
                data: [
                    0.1,
                    1.3,
                    53.02,
                ]
            }
        },
        {
            y: 10.57,
            color: colors[1],
            drilldown: {
                name: 'Firefox',
                categories: [
                    'Firefox v58.0',
                    'Firefox v57.0',
                    'Firefox v56.0',
                    'Firefox v55.0',
                ],
                data: [
                    1.02,
                    7.36,
                    0.35,
                    0.11,
                ]
            }
        },
        {
            y: 7.23,
            color: colors[0],
            drilldown: {
                name: 'Internet Explorer',
                categories: [
                    'Internet Explorer v11.0',
                    'Internet Explorer v10.0',
                    'Internet Explorer v9.0',
                    'Internet Explorer v8.0'
                ],
                data: [
                    6.2,
                    0.29,
                    0.27,
                    0.47
                ]
            }
        },
        {
            y: 5.58,
            color: colors[3],
            drilldown: {
                name: 'Safari',
                categories: [
                    'Safari v11.0',
                    'Safari v10.1',
                    'Safari v10.0',
                    'Safari v9.1',
                ],
                data: [
                    3.39,
                    0.96,
                    0.36,
                    0.54,
                ]
            }
        },
        {
            y: 4.02,
            color: colors[5],
            drilldown: {
                name: 'Edge',
                categories: [
                    'Edge v16',
                    'Edge v15',
                    'Edge v14',
                    'Edge v13'
                ],
                data: [
                    2.6,
                    0.92,
                    0.4,
                    0.1
                ]
            }
        },
        {
            y: 1.92,
            color: colors[4],
            drilldown: {
                name: 'Opera',
                categories: [
                    'Opera v50.0',
                    'Opera v49.0',
                    'Opera v12.1'
                ],
                data: [
                    0.96,
                    0.82,
                    0.14
                ]
            }
        },
        {
            y: 7.62,
            color: colors[6],
            drilldown: {
                name: 'Other',
                categories: [
                    'Other'
                ],
                data: [
                    7.62
                ]
            }
        }
    ],
    browserData = [],
    versionsData = [],
    i,
    j,
    dataLen = data.length,
    drillDataLen,
    brightness;

	
	// Build the data arrays
for (i = 0; i < dataLen; i += 1) {

    // add browser data
    browserData.push({
        name: categories[i],
        y: data[i].y,
        color: data[i].color
    });

    // add version data
    drillDataLen = data[i].drilldown.data.length;
    for (j = 0; j < drillDataLen; j += 1) {
        brightness = 0.2 - (j / drillDataLen) / 5;
        versionsData.push({
            name: data[i].drilldown.categories[j],
            y: data[i].drilldown.data[j],
            color: Highcharts.Color(data[i].color).brighten(brightness).get()
        });
    }
}

// Create the chart
Highcharts.chart('morris-bar-stacked', {
    chart: {
        type: 'pie',
		backgroundColor:"#757c7f"
    },
    title: {
        text: 'Genre Wise Channel',
		style: {color: 'white'}
		    },
    subtitle: {
        text: ''
    },
    plotOptions: {
        pie: {
			innerSize:'80%',
            shadow: false,
            center: ['50%', '50%']
        },
              dataLabels: {
                        enabled: false
                    }
    },
    tooltip: {
        valueSuffix: '%'
    },
    series: [{
        name: 'Browsers',
        data: browserData,
        size: '60%',
        dataLabels: {
            formatter: function () {
                return this.y > 5 ? this.point.name : null;
            },
            color: '#ffffff',
            distance: -30,
                        enabled: false
        }
    }, {
        name: 'Versions',
        data: versionsData,
        size: '80%',
        innerSize: '60%',
        dataLabels: {
            formatter: function () {
                // display only if larger than 1
                return this.y > 1 ? '<b>' + this.point.name + ':</b> ' +
                    this.y + '%' : null;
            }
        },
        id: 'versions'
    }],
    responsive: {
        rules: [{
            condition: {
                maxWidth: 400
            },
            chartOptions: {
                series: [{
                    id: 'versions',
                    dataLabels: {
                        enabled: false
                    }
                }]
            }
        }]
    }
});

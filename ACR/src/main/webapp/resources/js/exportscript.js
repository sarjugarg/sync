function JSONToCSVConvertor(JSONData,JSONData2,JSONData3, ReportTitle, ShowLabel) {
  //If JSONData is not an object then JSON.parse will parse the JSON string in an Object
  var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData) : JSONData;
    var arrData2 = typeof JSONData != 'object' ? JSON.parse(JSONData2) : JSONData2;
    var arrData3 = typeof JSONData != 'object' ? JSON.parse(JSONData3) : JSONData3;

  var CSV = '';
//Set Report title in first row or line
 
  CSV +=','+','+','+','+','+','+ ReportTitle + '\r\n\n';

  
 for (var i = 0; i < arrData.length; i++) {
   
    for (var index in arrData[i]) {
	 var row = "";
      row=',';
	var ad=arrData[i][index];
	for(var j in ad){
	
    
	row +=j + ','; 
	}
 
	    }
			row.slice(0, row.length - 1);	    
 CSV += row + '\r\n';

}
  for (var i = 0; i < arrData.length; i++) {
    for (var index in arrData[i]) {
	 var row = "";
      row  =index + ',';
	var ad=arrData[i][index];
	for(var j in ad){
	row += '"' + ad[j] + '",';
	}
row.slice(0, row.length - 1);	    
 CSV += row + '\r\n';

	    }
  }
  
  
  //2nd array
  
 var      row=',';
	//		row.slice(0, row.length - 1);	    
 CSV += row + '\r\n';
  
   
  
  
  
  
  for (var i = 0; i < arrData2.length; i++) {
   
    for (var index in arrData2[i]) {
	 var row = "";
      row=',';
	var ad=arrData2[i][index];
	for(var j in ad){
	
    
	row +=j + ','; 
	}
 
	    }
			row.slice(0, row.length - 1);	    
 CSV += row + '\r\n';

}
  for (var i = 0; i < arrData2.length; i++) {
    for (var index in arrData2[i]) {
	 var row = "";
      row  =index + ',';
	var ad=arrData2[i][index];
	for(var j in ad){
	row += '"' + ad[j] + '",';
	}
row.slice(0, row.length - 1);	    
 CSV += row + '\r\n';

	    }
  }
  
  //3rd array 

  
  var      row=',';
 	//		row.slice(0, row.length - 1);	    
  CSV += row + '\r\n';
   
   for (var i = 0; i < arrData3.length; i++) {
    
     for (var index in arrData3[i]) {
 	 var row = "";
       row=',';
 	var ad=arrData3[i][index];
 	for(var j in ad){
 	
     
 	row +=j + ','; 
 	}
  
 	    }
 			row.slice(0, row.length - 1);	    
  CSV += row + '\r\n';

 }
   for (var i = 0; i < arrData3.length; i++) {
     for (var index in arrData3[i]) {
 	 var row = "";
       row  =index + ',';
 	var ad=arrData3[i][index];
 	for(var j in ad){
 	row += '"' + ad[j] + '",';
 	}
 row.slice(0, row.length - 1);	    
  CSV += row + '\r\n';

 	    }
   }
   
   
  if (CSV == '') {
    alert("Invalid data");
    return;
  }

  //Generate a file name
  var fileName = "MyReport_";
  //this will remove the blank-spaces from the title and replace it with an underscore
  fileName += ReportTitle.replace(/ /g, "_");

  //Initialize file format you want csv or xls
  var uri = 'data:text/csv;charset=utf-8,' + escape(CSV);

  // Now the little tricky part.
  // you can use either>> window.open(uri);
  // but this will not work in some browsers
  // or you will not get the correct file extension    

  //this trick will generate a temp <a /> tag
  var link = document.createElement("a");
  link.href = uri;

  //set the visibility hidden so it will not effect on your web-layout
  link.style = "visibility:hidden";
  link.download = fileName + ".csv";

  //this part will append the anchor tag and remove it after automatic click
  document.body.appendChild(link);
  link.click();
  document.body.removeChild(link);
}

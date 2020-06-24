<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="context" value="${pageContext.request.contextPath}" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.css">
<link href="//cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css"
	rel="stylesheet" />
<link
	href="https://cdn.rawgit.com/harvesthq/chosen/gh-pages/chosen.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link href="${context}/resources/css/gamePanel/dropdown.css" rel="stylesheet"
	type="text/css" />

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment-with-locales.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
<script src="//cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.flexmonster.com/flexmonster.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script
	src="https://cdn.rawgit.com/harvesthq/chosen/gh-pages/chosen.jquery.min.js"></script>
<script src="https://www.marvinj.org/releases/marvinj-0.8.js"></script>
<script src="${context}/resources/js/gamePanelJs/tab.js"></script>

<script>
function check(){
    
	var value =document.getElementById("isactive");
        //var value = $(this).val();	
	 if($(value).prop("checked") == true){
         document.getElementById("isactive").value="1";
     }  
     else if($(value).prop("checked") == false){
       
         document.getElementById("isactive").value="0";
            
     }
      
}
    
</script>



<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta content="" name="description" />
<meta content="" name="author" />
<!-- end: META -->
<!-- start: MAIN CSS -->
<link rel="stylesheet"
	href="${context}/resources/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${context}/resources/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="${context}/resources/fonts/style.css">
<link rel="stylesheet" href="${context}/resources/css/main.css">
<link rel="stylesheet" href="${context}/resources/css/main-responsive.css">
<link rel="stylesheet" href="${context}/resources/plugins/iCheck/skins/all.css">
<link rel="stylesheet"
	href="${context}/resources/plugins/bootstrap-colorpalette/css/bootstrap-colorpalette.css">
<link rel="stylesheet"
	href="${context}/resources/plugins/perfect-scrollbar/src/perfect-scrollbar.css">
<link rel="stylesheet" href="${context}/resources/css/theme_light.css"
	type="text/css" id="skin_color">
<link rel="stylesheet" href="${context}/resources/css/print.css" type="text/css"
	media="print" />
<!--[if IE 7]>
		<link rel="stylesheet" href="${context}/resources/plugins/font-awesome/css/font-awesome-ie7.min.css">
		<![endif]-->
<!-- end: MAIN CSS -->
<!-- start: CSS REQUIRED FOR THIS PAGE ONLY -->
<link rel="stylesheet"
	href="${context}/resources/plugins/DataTables/media/css/DT_bootstrap.css" />
<link rel="stylesheet"
	href="${context}/resources/css/gamePanel/dataTable.css"/>
<title>Games Panel</title>
</head>
<body>
			<div class="panel-heading">
		<i class="fa fa-external-link-square"></i> Channel management
		
	</div>
<div id="head1">
<form  class="form-horizontal" action="${context}/editProduct"  role="form" modelAttribute="Product" method='POST' id="div1">
					<br><br>
					
					<div id="jsondiv">
				
					<div class="form-group">
					<label class="col-xs-3 control-label">Channel</label>
					<div class="col-xs-6  col-sm-3">
						<input type="text" class="form-control" name="category" id="category" required="true">
					</div>
					</div>
					<span id="spantext" style="margin-right: 25%;color: red;"></span>
					
					<div class="form-group">
					<label class="col-xs-3 control-label">Spend</label>
					<div class="col-xs-6  col-sm-3">
						<input type="number" class="form-control" name="spend" id="spend" required="true">
					</div>
					
					</div>
					<!-- <div class="form-group">
					<label class="col-xs-3 control-label">SpendUnit</label>
					<div class="col-xs-6  col-sm-3">
						<input type="number" class="form-control" name="spendunit" id="spendunit" required="true">
					</div> -->
					
					</div>
					<div class="form-group">
					<label class="col-xs-3 control-label">Image Upload</label>

					<div class="col-xs-6  col-sm-3">
						<input type="file" name='imageUrl' class="form-control" id="imageUrl" required="true"
							accept="image/*" />
					</div>
				 <!-- <div class="col-xs-1">
										<button type="button" onclick="imgUpload();" input
											class="btn btn-default">Upload</button>
									</div> --> 
					</div> 
				
					
								
									<div class="form-group">					
								<div class="col-xs-4"></div>
							<div class="col-xs-1">
								<button input type="button" onclick="create1()" class="btn btn-default">Submit</button>
							</div>	</div>
									
						
 </form>
	</div>

</body>
<script>
var formData = new FormData();
$("input#img").change(function() {

	var ele = document.getElementById($(this).prop('id'));
	var result = ele.files;

	for (var x = 0; x < result.length; x++) {
		var fle = result[x];
		formData.append("file",fle);
	}
	
	
});



function imgUpload(){
	$.ajax({
	url: '${context}/upload',
	data :formData,
	processData : false,
	contentType : false,
	type : 'POST',
	success : function(data) {
	console.log(data)
	//alert('success');
	},
	error : function() {
		//alert('error');
	}
	});
	}
	
	



var image = new MarvinImage();
var formData = new FormData();
/***********************************************
 * FILE CHOOSER AND UPLOAD
 **********************************************/
 $('#imageUrl').change(function (event) {
	 //alert("grey image ");
	//form = new FormData();
	console.log(event.target.files[0].name);
	console.log(event.target.files[0]);
	 formData.append('name', event.target.files[0].name);
	
	reader = new FileReader();
	reader.readAsDataURL(event.target.files[0]);
	
	reader.onload = function(){
		image.load(reader.result, imageLoaded);
	};
});  


 function imageLoaded(){
	  //alert("image loaded function. ");
	  //Marvin.scale(image.clone(), image, 500);
	  Marvin.grayScale(image.clone(), image);
	  formData.append("file", image.toBlob());
	  console.log(image.toBlob());
}
	


	
function create1(){
	var channelName = document.getElementById('category').value;
	var spend = document.getElementById('spend').value;
	var spendunit = 1;
	////alert("spend  unit ammount==="+spendunit);
	
	
//	var formData = new FormData();
		resultArr = [];
		arr2=[]
			    $("#jsondiv #div1").each(function(key, val){
			
				        val = $(this);
				        if(val.html() !== "") {
				            
				            var obj = 
				                { 
				            		imageUrl:val.find('#imageUrl').val(),
				                }
				        }
				            resultArr.push(obj);
				            console.log(resultArr)
				       		        });
		formData.append('file', $('#imageUrl')[0].files[0]);
		formData.append('data', JSON.stringify(resultArr)); 
		$.ajax({
			        	url: '${context}/InsertChannel/'+channelName+'/'+spend+'/'+spendunit,
			            data :formData,
			            processData : false,
			            contentType : false,
			            type : 'POST',
			            success : function(data) {
			            	if(data=="success")
			            	{
			            	window.location.href="${context}/channelmanagement";
			            	}
			            	else{
			            		////alert("Category is exist already..");
								document.getElementById("spantext").innerHTML = "channel is alreay Exist,please insert Fresh channel. ";	
			            		
			            	}
			            	
			            },
			            error : function() {
			            	//alert("error");
			            }
			        });
		}

</script>
</html>
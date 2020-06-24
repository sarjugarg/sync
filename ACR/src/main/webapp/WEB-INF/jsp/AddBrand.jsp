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
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <script src="https://www.dukelearntoprogram.com/course1/common/js/image/SimpleImage.js" ></script>
	
	
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
<style>
canvas 
		{
		  height: 300px;
		  width:300px;
		  border: 1px solid lightgray;
		}
</style>
</head>
<body>
			<div class="panel-heading">
		<i class="fa fa-external-link-square"></i> Brand management
		
	</div>
<div id="head1">
<form  class="form-horizontal" action="${context}/editProduct"  role="form" modelAttribute="Product" method='POST' id="div1">
					<br><br>
					
					<div id="jsondiv">
				
					<div class="form-group">
					<label class="col-xs-3 control-label">Brand</label>
					<div class="col-xs-6  col-sm-3">
						<input type="text" class="form-control" name="brand" id="brand" required="true"  >
					</div>
					
					</div>
			<span id="spantext" style="margin-right: 25%;color: red;"></span>
					<div class="form-group">
					<label class="col-xs-3 control-label">Image Upload</label>

					<div class="col-xs-6  col-sm-3">
						<!-- <input type="file" name='imageUrl' class="form-control" id="imageUrl" onchange="imageconvert(this.value);" required="true" 
							accept="image/*" /> -->
							
							<input type="file" name='imageUrl' class="form-control" id="imageUrl"  required="true" 
							accept="image/*" />
					</div>
				 
				 <p>
	 <!--  <input type="button" value="Make Grayscale" onclick="makeGray()" > -->
	</p>
				 
					</div> 
					
					
					
					</div>
					
								
									<div class="form-group">						
								<div class="col-xs-4"></div>
							<div class="col-xs-1">
								<button  type="button" onclick="create1()" class="btn btn-default">Submit</button>
							</div>	
							</div>		
						
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
	var brandName = encodeURIComponent(document.getElementById('brand').value);
	////alert("brandName name==="+brandName);
	
	
	
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
		//formData.append('data', JSON.stringify(resultArr)); 
		console.log("from data value."+formData);
		$.ajax({
			        	url: '${context}/InsertBrand/'+'?brandName='+brandName,
			            data :formData,
			            processData : false,
			            contentType : false,
			        	enctype: 'multipart/form-data',
			            type : 'POST',
			            success : function(data) {
			            	//alert("response=="+data)
						 if(data=="sucess")
							{
			            	window.location.href="${context}/brandManagement";
							}
						else{
						//	//alert("bradn is exust already..");
							document.getElementById("spantext").innerHTML = "brand is alreay Exist,please insert Fresh brand. ";							
							
						} 
			            },
			            error : function() {
			            	//alert("error");
			            }
			        });
		}

</script>
<!-- <script>
function imageconvert(name)
{

	
	var image = null;
	var fileinput = document.getElementById("imageUrl");
	  //Make new SimpleImage from file input
	  image = new SimpleImage(fileinput);
	  
	//var url = $(t).val();
	//alert("image click."+name);
	//alert("original image ."+image);
	
	
	for (var pixel of image.values()) {
		var avg = (pixel.getRed()+pixel.getGreen()+pixel.getBlue())/3;
		pixel.setRed(avg);
		pixel.setGreen(avg);
		pixel.setBlue(avg);
	  }

	//display new image
	   var canvas = document.getElementById("can");
	  image.drawTo(canvas); 
	
	
	}
</script>
 -->
<!-- <script type="text/javascript">
		var image = null;

		function upload() {
		  //Get input from file input
		  var fileinput = document.getElementById("imageUrl");
		  //Make new SimpleImage from file input
		  image = new SimpleImage(fileinput);
		  //Get canvas
		 /*  var canvas = document.getElementById("can");
		  //Draw image on canvas
		  image.drawTo(canvas); */
		  
		  for (var pixel of image.values()) {
				var avg = (pixel.getRed()+pixel.getGreen()+pixel.getBlue())/3;
				pixel.setRed(avg);
				pixel.setGreen(avg);
				pixel.setBlue(avg);
			  }
			  //display new image
			  var canvas = document.getElementById("can");
			  image.drawTo(canvas);
		}

		function makeGray() {
		  //change all pixels of image to gray
		  for (var pixel of image.values()) {
			var avg = (pixel.getRed()+pixel.getGreen()+pixel.getBlue())/3;
			pixel.setRed(avg);
			pixel.setGreen(avg);
			pixel.setBlue(avg);
		  }
		  //display new image
		  var canvas = document.getElementById("can");
		  image.drawTo(canvas);
		}
	
	</script> -->

<script>

</script>

</html>
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

<style>
.modal-content {
    font-size: 0px;
    font-family: sans-serif;
    min-height: 105px !important;
    text-decoration: none;
    color: black;
}
</style>
</head>
<body>
			<div class="panel-heading">
		<i class="fa fa-external-link-square"></i> Edit Channel Image details
		
	</div>
<div id="head1" style="background-color: #white;">
<form  class="form-horizontal" action=""  role="form" modelAttribute="Channel" method='POST' id="div1">
					<br><br>
					
					
				<%-- 	<div class="form-group">
									<label class="col-xs-3 control-label">Channel Name</label>

							
							
							<div class="form-group">
					<input type="text" name="channelImageId" id="channelImageId" value="${map}">
					</div>
							
							<div class="col-xs-6 col-sm-3" id="dp1">
								<select class="form-control " name="channelId" id="channelId" readonly="true"
									required>
									 <c:forEach items="${map}" var="map">
									 <c:choose>
									<c:when test="${map.key==list.channelId}"> 
									<option value="${ list.channelId}">${ map.value}</option>
									 </c:when>
									 </c:choose>
									</c:forEach> 
									<c:forEach items="${map}" var="map">

										<option value="${map.key}">${map.value}</option>

									</c:forEach>
								</select>
							</div>
					</div> --%>
					
					<c:forEach items="${list}" var="list">
					<div class="form-group">
					<label class="col-xs-3 control-label">Channel Name</label>
					<div class="col-xs-6  col-sm-3">
						<input type="text" class="form-control" name="imageWidth" id="channelname" value="${list.channel}">
					</div>
					
					</div>
					<span id="spantext" style="margin-right: 25%;color: red;"></span>
					
					
					
					<div id="jsondiv">
					
					
					<div class="form-group">
					<input type="text" name="channelId" id="channelId" value="${list.channelId}" style="display:none">
					</div>
					
					<div class="form-group">
					<input type="text" name="streamId" id="streamId" value="${list.streamId}" style="display:none">
					</div>
					<div class="form-group">
					<label class="col-xs-3 control-label">Previous Image</label>
					<div class="col-xs-6  col-sm-3" style="display: inline-flex;" >
						
						<c:choose>
						<c:when test="${list.filename=='null'}">
						<img src="${channelImageUrl}${list.filename}"
							style="width: 250px; height: 150px;">
						<button type="button" data-target="" disabled="disabled" onclick="ConfirmDelete();"
							data-toggle="modal" class="btn btn-info btn-lg" class="btn btn-default" 
							style="margin-left: 26px;  height: fit-content; padding: 4px 3px; background-color: #C83A2A;color: white;margin-top: 60px;">
							Delete image</button>
					
						
						</c:when>
						<c:otherwise>
						<img src="${channelImageUrl}${list.filename}"
							style="width: 240px; height: 150px;">
							
							
							<button type="button" data-target="" onclick="ConfirmDelete();"
							data-toggle="modal" class="btn btn-info btn-lg" class="btn btn-default" 
							style="margin-left: 26px;height: fit-content; padding: 4px 3px; background-color: #C83A2A;color: white;margin-top: 60px;">
							Delete image</button>
							</c:otherwise>
							</c:choose>
					
					</div>
					</div>
					<div class="form-group">
					<label class="col-xs-3 control-label">Image Height</label>
					<div class="col-xs-6  col-sm-3">
						<input type="text" class="form-control" name="imageHeight" id="imageHeight" value="${list.imageHeight }" readonly="true">
						
					</div>
					</div>
					<div class="form-group">
					<label class="col-xs-3 control-label">Image Width</label>
					<div class="col-xs-6  col-sm-3">
						<input type="text" class="form-control" name="imageWidth" id="imageWidth" value="${list.imageWidth }" readonly="true">
					</div>
					</div>
					
					
					<div class="form-group">
					<label class="col-xs-3 control-label">Spend <c:choose >
						<c:when test="${map.spendUnit==1}" >
						(Per Sec)
						</c:when>
						</c:choose></label>
					<div class="col-xs-6  col-sm-3">
						<input type="number" class="form-control" name="spend" id="spend" value="${list.spend }">
						
					</div>
					</div>
					
					<div class="form-group">
					<label class="col-xs-3 control-label">Image Upload</label>

					<div class="col-xs-6  col-sm-3">
						<input type="file" name='imageUrl' class="form-control" id="imageUrl"
							accept="image/*" />
					</div>
				 <!-- <div class="col-xs-1">
										<button type="button" onclick="imgUpload();" input
											class="btn btn-default">Upload</button>
									</div> --> 
					</div> 
					</div>
					</c:forEach>
								
								<div class="form-group">							
								<div class="col-xs-4"></div>
							<div class="col-xs-1">
								<button input type="button" onclick="create1()" class="btn btn-default">Submit</button>
							</div>			</div>
						
 </form>
</div>

 
 	<div class="modal fade" id="deleteu" role="dialog">
					<div class="modal-dialog">
						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">ARE YOU SURE?</h4>
							</div>
							<form action="./deletelogo" method="GET" modelAttribute="Channel">
								<input type="text" id="deleteid" value=""  name="channelId"
									style="display: none;">
								<div class="modal-footer">
									<button type="button" onclick="deleteLogo();" class="btn btn-default">Yes</button>
									<button type="button" class="btn btn-default"
										data-dismiss="modal">No</button>
								</div>
							</form>

						</div>
					</div>
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
	var a = document.getElementById('channelId').value;
	//var b = document.getElementById('channelImageId').value;
	var spend = document.getElementById('spend').value;
	var channelname = encodeURIComponent(document.getElementById('channelname').value);
	var streamId = encodeURIComponent(document.getElementById('streamId').value);
	var spendunit = 1;
	////alert("spentunit."+spendunit);
	
	

	//var formData = new FormData();
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
//		formData.append('file', $('#imageUrl')[0].files[0]);
		//formData.append('data', JSON.stringify(resultArr)); 
		$.ajax({
			        	url: '${context}/editChannel/'+a+'/'+spend+'/'+spendunit+'/'+streamId+'/'+'?channelName='+channelname,
			            data :formData,
			            processData : false,
			            contentType : false,
			            type : 'POST',
			            success : function(data) {
			          //  //alert("response="+data);
			            if(data=="updated"){
			            	window.location.href="${context}/channelmanagement";
			            }
			            else{
			            	document.getElementById("spantext").innerHTML = "Channel is already Exist,please insert Fresh Channel. ";
			            	
			            }
			            
			            			                             
			            },
			            error : function() {
			            	//alert("error");
			            }
			        });
		}

</script>
<script>


/*  function deleteImage(){

	var value=document.getElementById('channelId').value;
	////alert("chaanel id="+value);
	$('#deleteid').val(value);
	var valueId=document.getElementById('deleteid').value;
	//alert("id valuein delete."+valueId);
 } */
 

 function deleteLogo(){
	
	 var imageid=document.getElementById('channelImageId').value;
	// //alert("channelImageId id="+imageid);	
		
		
	 $.ajax({
 	url: '${context}/deletelogo/'+imageid,
 	data :formData,
 	processData : false,
 	contentType : false,
 	type : 'POST',
 	success : function(data) {
 		
 		window.location.href="${context}/channelmanagement";
 	},
 	error : function() {
 		//alert('error');
 	}
 	});
 	}

</script>
<script>


function ConfirmDelete()
{
  var x = confirm("Are you sure you want to delete?");
  if (x){
	  var channelId=document.getElementById('channelId').value;
		// //alert("channelImageId id="+imageid);	
			
			
		 $.ajax({
	 	url: '${context}/deletelogo/'+channelId,
	 	data :formData,
	 	processData : false,
	 	contentType : false,
	 	type : 'POST',
	 	success : function(data) {
	 		
	 		window.location.href="${context}/channelmanagement";
	 	},
	 	error : function() {
	 		//alert('error');
	 	}
	 	});

	 // //alert("delete sucesfull");
      return true;
  }
  else
  {
	/* //alert("cancel delete.")  ; */
	return false;
	  
  }
  
     
}


/* <input type="button" onclick="ConfirmDelete()"> */
</script>
</html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en" class="no-js">
<!-- start: HEAD -->
<head>
<title>Campaign Management</title>
<!-- start: META -->
<meta charset="utf-8" />
<!--[if IE]><meta http-equiv='X-UA-Compatible' content="IE=edge,IE=9,IE=8,chrome=1" /><![endif]-->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta content="" name="description" />
<meta content="" name="author" />
<!-- end: META -->
<!-- start: MAIN CSS -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<link rel="stylesheet"
	href="${context}/resources/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${context}/resources/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="${context}/resources/fonts/style.css">
<link rel="stylesheet" href="${context}/resources/css/main.css">
<link rel="stylesheet"
	href="${context}/resources/css/main-responsive.css">
<link rel="stylesheet"
	href="${context}/resources/plugins/iCheck/skins/all.css">
<link rel="stylesheet"
	href="${context}/resources/plugins/bootstrap-colorpalette/css/bootstrap-colorpalette.css">
<link rel="stylesheet"
	href="${context}/resources/plugins/perfect-scrollbar/src/perfect-scrollbar.css">
<link rel="stylesheet" href="${context}/resources/css/theme_light.css"
	type="text/css" id="skin_color">
<link rel="stylesheet" href="${context}/resources/css/print.css"
	type="text/css" media="print" />
<!--[if IE 7]>
		<link rel="stylesheet" href="./resources/plugins/font-awesome/css/font-awesome-ie7.min.css">
		<![endif]-->
<!-- end: MAIN CSS -->
<!-- start: CSS REQUIRED FOR THIS PAGE ONLY -->
<link rel="stylesheet"
	href="${context}/resources/plugins/DataTables/media/css/DT_bootstrap.css" />
</head>
<!-- end: HEAD -->
<!-- start: BODY -->
<body>
	<div class="container">
		<!-- start: PAGE CONTENT -->
		<div class="row">
			<div class="col-md-12">
				<!-- start: DYNAMIC TABLE PANEL -->
				<div class="panel panel-default">
					<div class="panel-heading"></div>
					<div class="modal-body">
						<form role="form" action="" method="" id="formid"
							class="form-horizontal">

							<input type="text" value="${campaign.brand}" id="brid" style="display: none;" >
								 <input type="text" value="${campaign.product}" id="prdid" style="display: none;">
							<input type="text"  value="${campaign.category}" id="catid" style="display: none;">
							 <input type="text" value="${campaign.language}" style="display: none;">

							<div id="seconddiv">
								<input type="text" style="display: none;"
									placeholder="Campaign Name" value="${campaign.campaignId} "
									id="campaignId" class="form-control" name="campaignId" required>
								<div class="form-group">
									<label class="col-sm-3 control-label" for="form-field-1">
										Campaign Name </label>
									<div class="col-sm-3">
										<input type="text" placeholder="Campaign Name"
											value="${campaign.campaignName} " id="campaignName"
											class="form-control" name="campaignName" required>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label" for="form-field-1">
										Brand </label>
									<div class="col-sm-3">


										<select class="form-control " id="brandId"style="height: 30px;margin-left: 92px; margin-top: 3px;">

										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="form-field-1">
										Product </label>
									<div class="col-sm-3">

										<select class="form-control " 
											id="productId"
											style="height: 30px;  margin-left: 92px;margin-top: 3px;">

										</select>

									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="form-field-1">
										Category </label>
									<div class="col-sm-3">

										<select class="form-control " 
											id="categoryId"
											style="height: 30px;  margin-left: 92px; margin-top: 3px;">

										</select>
									</div>
								</div>






								<div class="form-group">
									<label class="col-sm-3 control-label" for="form-field-1">
										Sub-Category </label>
									<div class="col-sm-3">
										<input type="text" placeholder="sub_category"
											id="sub_categoryId" value="${campaign.sub_category}"
											class="form-control" name="sub_category" required>
									</div>
								</div>
								<!-- <div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												Start time </label>
											<div class="col-sm-9">
												<input type="text" placeholder="Start time" id="form-field-1"
													class="form-control" name="startdDate" required>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												End Time </label>
											<div class="col-sm-9">
												<input type="text" placeholder="End Time" id="form-field-1"
													class="form-control" name="enddDate" required>
											</div>
										</div> -->
								<div class="form-group">
									<label class="col-sm-3 control-label" for="form-field-1">
										Description </label>
									<div class="col-sm-3">
										<input type="text" placeholder="Description"
											id="descriptionId" value="${campaign.description}"
											class="form-control" name="description" required>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label" for="form-field-1">
										Language </label>
									<div class="col-sm-3">
										
												<select class="form-control " 
											id="languageId"
											style="height: 30px; margin-top: 3px;">

										</select>
									</div>
								</div>


								<div class="form-group">
									<button type="button" onclick="uploadImage()"
										class="btn btn-primary" style="width: 10%; margin-left: 30%">UPDATE</button>
								</div>

							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- end: DYNAMIC TABLE PANEL -->




	

	<script>
function uploadImage(){
	var formData = new FormData();
	 var newcampaign ;
	var resultArr = [];
		var arr2=[];
			    $("#formid #seconddiv").each(function(key, val){
			
				        val = $(this);
				        newcampaign = 
				                { 
            						"campaignId":val.find('#campaignId').val(),
				            		"campaignName":val.find('#campaignName').val(),
				            		 "brand":val.find('#brandId').val(),
				            		"product":val.find('#productId').val(),
				            		 "category":val.find('#categoryId').val(),
				            		 "sub_category":val.find('#sub_categoryId').val(),
				            		 "language":val.find('#languageId').val(),
				            		 "description":val.find('#descriptionId').val(),
				            		// "audio_file":$('#audio_fileId')[0].files[0]
				            	 	 //"startdDate":val.find('#startTimeId').val(),
				            		 //"enddDate":val.find('#endTimeId').val()
				            		 
				            		//"audio_file":val.find('#audioFile').val(),
				                }
				});
	
	     console.log(JSON.stringify(newcampaign));
	   /*   formData.append('file', $('#audio_fileId')[0].files[0]);
	   	 formData.append('data', JSON.stringify(newcampaign)); */
	     
	     $.ajax({
			        	url: '${context}/updatecampaign',
			        	//headers: {'Content-Type': "multipart"},
			            type : 'POST',
			         //   processData: false,
			           // contentType: false,
			            data :JSON.stringify(newcampaign),
			            contentType: 'application/json',
			            //enctype:"multipart/form-data",
			            success : function(data) {
			            	//alert("response=="+data);
			            	//alert("sucess");
			            	window.location.href="${context}/campaign";
			            },
			            error : function() {
			            	//alert("error");
			            }
			        });
		}

$(document).ready(function(){
	
	brandSelect();
	productSelect();
	categorySelect();
	languageSelect();
});


function brandSelect()
{
	//alert("before hit campaign");
	$.ajax({
		
    	url: '${context}/brandSchedule',
        processData : false,
        contentType : false,
        type : 'POST',
        success : function(data) {
       	//alert("success");
        //console.log( JSON.stringify(data));
       	
        //'<option value="'+${shedule.channnelName}+'">'+${shedule.channnelName}+'</option>'
    	$('#brandId').empty();
    	for (i = 0; i < data.length; i++){
    		var html='<option value="'+data[i].brand+'">'+data[i].brand+'</option>';
			//$('<option>').val(data[i]).channnelName.text(data[i]).channnelName.appendTo('#channelId');
			$('#brandId').append(html);	
			}
    	$('#brandId').val($("#brid").val());
    	
        	 
        },
        error : function() {
        }
    });		
	
	
}
function productSelect()
{
	//alert("before hit campaign");
	$.ajax({
		
    	url: '${context}/fetchProduct',
        processData : false,
        contentType : false,
        type : 'POST',
        success : function(data) {
       //	alert("success");
        //console.log( JSON.stringify(data));
       	
        //'<option value="'+${shedule.channnelName}+'">'+${shedule.channnelName}+'</option>'
    	$('#productId').empty();
    	for (i = 0; i < data.length; i++){
    		var html='<option value="'+data[i].product+'">'+data[i].product+'</option>';
			//$('<option>').val(data[i]).channnelName.text(data[i]).channnelName.appendTo('#channelId');
			$('#productId').append(html);	
			}
    	$('#productId').val($("#prdid").val());
    	
        	 
        },
        error : function() {
        }
    });		
	
	
}

function categorySelect()
{
	//alert("before hit campaign");
	$.ajax({
		
    	url: '${context}/fetchCategory',
        processData : false,
        contentType : false,
        type : 'POST',
        success : function(data) {
       //	alert("success");
        //console.log( JSON.stringify(data));
       	
        //'<option value="'+${shedule.channnelName}+'">'+${shedule.channnelName}+'</option>'
    	$('#categoryId').empty();
    	for (i = 0; i < data.length; i++){
    		var html='<option value="'+data[i].category+'">'+data[i].category+'</option>';
			//$('<option>').val(data[i]).channnelName.text(data[i]).channnelName.appendTo('#channelId');
			$('#categoryId').append(html);	
			}
    	$('#categoryId').val($("#catid").val());
    	
        	 
        },
        error : function() {
        }
    });		
	
	
}


function languageSelect()
{
	//alert("before hit campaign");
	$.ajax({
		
    	url: '${context}/fetchLanguage',
        processData : false,
        contentType : false,
        type : 'POST',
        success : function(data) {
       	//alert("success");
        //console.log( JSON.stringify(data));
       	
        //'<option value="'+${shedule.channnelName}+'">'+${shedule.channnelName}+'</option>'
    	$('#languageId').empty();
    	for (i = 0; i < data.length; i++){
    		var html='<option value="'+data[i].language+'">'+data[i].language+'</option>';
			//$('<option>').val(data[i]).channnelName.text(data[i]).channnelName.appendTo('#channelId');
			$('#languageId').append(html);	
			}
    	$('#languageId').val($("#langid").val());
    	
        	 
        },
        error : function() {
        }
    });		
	
	
}



</script>


<script>
	


	
	</script>







	<!-- end: PAGE CONTENT-->
	<!-- 	</div>
			</div> -->
	<!-- end: PAGE -->

	<!-- start: MAIN JAVASCRIPTS -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
	<!--<![endif]-->
	<script
		src="${context}/resources/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script src="${context}/resources/plugins/iCheck/jquery.icheck.min.js"></script>
	<script
		src="${context}/resources/plugins/perfect-scrollbar/src/jquery.mousewheel.js"></script>
	<script
		src="${context}/resources/plugins/perfect-scrollbar/src/perfect-scrollbar.js"></script>
	<script
		src="${context}/resources/plugins/jquery-cookie/jquery.cookie.js"></script>
	<script
		src="${context}/resources/plugins/bootstrap-colorpalette/js/bootstrap-colorpalette.js"></script>
	<script src="${context}/resources/js/main.js"></script>
	<!-- end: MAIN JAVASCRIPTS -->
	<script type="text/javascript"
		src="${context}/resources/plugins/DataTables/media/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="${context}/resources/plugins/DataTables/media/js/DT_bootstrap.js"></script>
	<script src="${context}/resources/js/table-data.js"></script>
	<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->

</body>
<!-- end: BODY -->
</html>
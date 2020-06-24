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
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>
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
<title>SyncMedia Panel</title>
</head>
<body>
			<div class="panel-heading">
		<i class="fa fa-external-link-square"></i> Campaign management
		
	</div>
<div id="head1">
<div style="margin-left: 65px;  width: 128%;">

<input type="text" value="${shedule.channnelName }" id="chName" style="display:none">
<input type="text" value="${shedule.campaignName }" id="camp" style="display:none">
					<form role="form"  id="formid"
										class="form-horizontal">
										
										<div id="seconddiv">
										<input type="text" style="display:none" id="sheduleId" value="${shedule.planId}">
										<div class="form-group">
										
											<label class="col-sm-2 control-label" for="form-field-1">
												Channel </label>
											<div class="col-sm-3">
											<!-- <input type="text" placeholder="Campaign Name"
													id="form-field-1" class="form-control" name="campaignName"
													required> -->
													
													<select class="form-control " name="channel" id='channelId'   style="height: 30px; width:209px ;margin-top: 3px;" >
											</select>
											
											</div>
										</div>
											
										<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												Campaign </label>
											<div class="col-sm-3">
												<!-- <input type="text" placeholder="Brand Name"
													id="form-field-1" class="form-control" name="brand"
													required> -->
													
												<select class="form-control "  name="campaign" id='campaignId'  style="height: 30px; width:209px; margin-top: 3px;" >
									 					
									 				
											</select>
											</div>
										</div>
									<!-- 	<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												StartDate </label>
											<div class="col-sm-2">
												<input type="text" placeholder="Product" id="startDate"
													class="form-control" name="product" required>
											</div>
										</div>
										 -->
											<div class="form-group" id="sdd">
								<label class="col-sm-2 control-label">Start Date</label>

								<div class="col-sm-2 input-group date" id='startDate'>
									<input type='text' class="form-control" name="startDate" 
										id="startDateI" value="${shedule.startTime}" required /> <span class="input-group-addon"
										> <span
										class="glyphicon glyphicon-calendar" onclick="selectStartDate();"></span>
									</span>
								</div>
							</div>
							
								<div class="form-group endDate" id="edd">
								<label class="col-sm-2 control-label">End Date</label>

								<div class="col-sm-2 input-group date" id='endDate'>
									<input type='text' class="form-control" name="endDate" 
									value="${shedule.endTime}"	id='endDateI' value="" required /> <span class="input-group-addon"
										> <span
										class="glyphicon glyphicon-calendar" onclick="selectEndDate();"></span>
									</span>
								</div>
							</div>
										<!-- <div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												EndDate </label>
											<div class="col-sm-2">
												<input type="text" placeholder="Category" id="endDate"
													class="form-control" name="category" required>
											</div>
										</div> -->
										<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												Spot Count </label>
											<div class="col-sm-2">
												<input type="number" placeholder="spot count" id="spotId" 
											onkeypress="spotSelect();"	value="${shedule.spotCount}"	class="form-control" name="spot count" required >
											</div>
										</div>
									<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												Cost </label>
											<div class="col-sm-2">
												<input type="number" placeholder="count" id="countId" 
											value="${shedule.cost}"	onkeypress="countSelect();"	class="form-control" name="count" required>
											</div>
										</div>
										
									
										<div class="form-group">
											<button type="button" class="btn btn-primary" onclick="uploadImage();" id="submitbtn"
												 style="width: 10%; margin-right: 54%;">UPDATE</button>
										</div>
										</div>
									</form>
</div>
</div>


	

</body>

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
            		// campaignId:val.find('#audioFile').val(),
				            		"planId":val.find('#sheduleId').val(),
				            		 "channnelName":val.find('#channelId').val(),
				            		"campaignName":val.find('#campaignId').val(),
				            		 "startTime":val.find('#startDateI').val(),
				            		 "endTime":val.find('#endDateI').val(),
				            		 "spotCount":val.find('#spotId').val(),
				            		 "cost":val.find('#countId').val(),
				            		
				                }
				});
	
	     console.log(JSON.stringify(newcampaign));
	   /*   formData.append('file', $('#audio_fileId')[0].files[0]);
	   	 formData.append('data', JSON.stringify(newcampaign)); */
	     
	     $.ajax({
			        	url: '${context}/updateSchedule',
			        	//headers: {'Content-Type': "multipart"},
			            type : 'POST',
			         //   processData: false,
			           // contentType: false,
			            data :JSON.stringify(newcampaign),
			            contentType: 'application/json',
			            //enctype:"multipart/form-data",
			            success : function(data) {
			            	//alert("response=="+data);
			            	alert("success");
			            	window.location.href="${context}/sheduleCampaign";
			            	
			            },
			            error : function() {
			            	//alert("error");
			            }
			        });
		}

</script>
<script>

$(function() {
	//var d = new Date().toLocaleString();
	var now = new Date();
	var d = moment(now).format('YYYY-MM-DD h:mm:ss A');
	$('#startDate').datetimepicker({
		format : 'YYYY-MM-DD h:mm:ss A'
	});
	$('#endDate').datetimepicker({
		format : 'YYYY-MM-DD h:mm:ss A',
		useCurrent : false
	//Important! See issue #1075
	});
	$("#startDate").on("dp.change", function(e) {
		$('#endDate').data("DateTimePicker").minDate(e.date);
		$('#startDate').data("DateTimePicker").minDate(d);
		$(this).data('DateTimePicker').hide();
	});
	$("#endDate").on("dp.change", function(e) {
		$('#startDate').data("DateTimePicker").maxDate(e.date);
		$(this).data('DateTimePicker').hide();
	});
});


function channelSelect() {
	
	document.getElementById("campaignId").disabled="";
	
}
function campaignSelect()  {

	document.getElementById("startDateI").disabled="";
	
}
function selectStartDate(){

	document.getElementById("endDateI").disabled="";
	
}
function selectEndDate() {

	document.getElementById("spotId").disabled="";
	
} 
function spotSelect() {

	document.getElementById("countId").disabled="";
	
} 
function countSelect(){
	
	document.getElementById("submitbtn").disabled="";
	
}

</script>



<script>

$(document).ready(function(){
	//$("input[name='categoryfilter']").click(categoryFilter()); 
	channelSelect();
	campaignSelect();
});
function channelSelect()
{
	//alert("before hit campaign");
	$.ajax({
		
    	url: '${context}/fetchSchedule',
        processData : false,
        contentType : false,
        type : 'POST',
        success : function(data) {
      //  alert("success");
        console.log( JSON.stringify(data));
       	
        //'<option value="'+${shedule.channnelName}+'">'+${shedule.channnelName}+'</option>'
    	$('#channelId').empty();
    	for (i = 0; i < data.length; i++){
    		var html='<option value="'+data[i].channnelName+'">'+data[i].channnelName+'</option>';
			//$('<option>').val(data[i]).channnelName.text(data[i]).channnelName.appendTo('#channelId');
			$('#channelId').append(html);	
			}
    	$('#channelId').val($("#chName").val());
    	
        	 
        },
        error : function() {
        }
    });		
	
	
}

function campaignSelect()
{
	//alert("before hit");
	$.ajax({
		
    	url: '${context}/fetchcampaign',
        processData : false,
        contentType : false,
        type : 'POST',
        success : function(data) {
      //  alert("success");
        console.log( JSON.stringify(data));
 
        $('#campaignId').empty();
    	for (i = 0; i < data.length; i++){
    		var html='<option value="'+data[i].campaignName+'">'+data[i].campaignName+'</option>';
			//$('<option>').val(data[i]).channnelName.text(data[i]).channnelName.appendTo('#channelId');
			
			$('#campaignId').append(html);	
			}
    	$('#campaignId').val($("#camp").val());
         
        },
        error : function() {
        }
    });		
	
	
}


</script>
</html>
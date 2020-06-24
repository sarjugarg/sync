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
<title>SyncMedia Panel</title>
</head>
<body>
			<div class="panel-heading">
		<i class="fa fa-external-link-square"></i> Campaign management
		
	</div>
<div id="head1">
<div style="margin-left: 65px;  width: 128%;">


									<form role="form" action="" method=""  id="formid"
										class="form-horizontal">
								
						<div id="seconddiv">	
										
										<div class="form-group">
											<label
											 class="col-sm-2 control-label" for="form-field-1">
												Campaign Name </label>
											<div class="col-sm-3">
											<input type="text" placeholder="Campaign Name"
													id="campaignId" class="form-control" name="campaignName"
													onkeypress="campaignChange();"required>
											</div>
										</div>

										<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												Brand </label>
											<div class="col-sm-3">
												<!-- <input type="text" placeholder="Brand Name" onkeypress="brandChange()"
											disabled="disabled"		id="brandId" class="" name="brand"
													required> -->
													
														
												<select class="form-control " disabled="disabled"   	id="brandId" onchange="brandChange();" style="height: 30px; width:330px; margin-top: 3px;" >
									 					<c:forEach items="${brand}" var="brand">
									 				<option value="${brand.brand}">${brand.brand}</option>
									 				</c:forEach>
											</select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												Product </label>
											<div class="col-sm-3">
												<!-- <input type="text" placeholder="Product" id="productId" onkeypress="productChange()"
													disabled="disabled"			class="form-control" name="product" required> -->
													
											<select class="form-control " disabled="disabled"   	id="productId" onchange="productChange();" style="height: 30px; width:330px; margin-top: 3px;" >
									 					<c:forEach items="${product}" var="product">
									 				<option value="${product.product}">${product.product}</option>
									 				</c:forEach>
											</select>		
													
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												Category </label>
											<div class="col-sm-3">
												<!-- <input type="text" placeholder="Category" id="categoryId"
											disabled="disabled"		 onkeypress="categoryChange()" class="form-control" name="category" required> -->
											
											<select class="form-control " disabled="disabled"   	id="categoryId" onchange="categoryChange();" style="height: 30px; width:330px; margin-top: 3px;" >
									 					<c:forEach items="${category}" var="category">
									 				<option value="${category.category}">${category.category}</option>
									 				</c:forEach>
											</select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												Sub-Category </label>
											<div class="col-sm-3">
												<input type="text" placeholder="sub_category" id="sub_categoryId"
										disabled="disabled"		onkeypress="sub_categoryChange()"	class="form-control" name="sub_category" required>
											</div>
										</div>
									<!-- <div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												Start time </label>
											<div class="col-sm-3">
												<input type="text" placeholder="Start time" id="startTimeId"
													class="form-control" name="startdDate" required>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												End Time </label>
											<div class="col-sm-3">
												<input type="text" placeholder="End Time" id="endTimeId"
													class="form-control" name="enddDate" required>
											</div>
										</div>
									 -->	<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												Description </label>
											<div class="col-sm-3">
												<input type="text" placeholder="Description" id="descriptionId" disabled="disabled"
												onkeypress="descriptionChange()"	class="form-control" name="description" required>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												Language </label>
											<div class="col-sm-3">
												<!-- <input type="text" placeholder="Language" id="languageId" disabled="disabled"
												onkeypress="languageChange()"	class="form-control" name="language" required -->
												
												
											<select class="form-control " disabled="disabled"   	id="languageId" onchange="languageChange();" style="height: 30px; width:330px; margin-top: 3px;" >
									 					<c:forEach items="${language}" var="language">
									 				<option value="${language.language}">${language.language}</option>
									 				</c:forEach>
											</select>		
											</div>
										</div>
									<!-- <div class="form-group">
											<label class="col-sm-2 control-label" for="form-field-1">
												Audio File </label>
											<div class="col-sm-3">
												<input type="file" placeholder="Audio File" id="audio_fileId"
													class="form-control" name="audio_file" accept="image/*" required>
											</div>
										</div> -->
									 
										<div class="form-group">
											<button type="button" id="create" class="btn btn-primary" onclick="uploadImage();"
											disabled="disabled"	style="margin-right: 621px;width: 10%;">CREATE</button>
										</div>
									
									<span id="errormessage"></span>
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
				            		"campaignName":val.find('#campaignId').val(),
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
			        	url: '${context}/addcampaign',
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
			            	window.location.href="${context}/campaign";
			            },
			            error : function() {
			            	//alert("error");
			            }
			        });
		}

</script>
<script>

/* var b=('#brandId').val;
alert("brandId"+b);

$(document).ready(function (){
    validate();
    $('#campaignName,#brandId,#productId,#categoryId,#productId,#sub_categoryId,#sub_categoryId,#descriptionId,#languageId').keyup(validate);
   
});

function validate(){
    if (
    	$('#campaignName').val()   >   0   &&	
        
         
    	$('#brandId').val()    >   0  && $('#productId').val()    >   0  && $('#categoryId').val()>0 &&
    	$('#productId').val() >0 && $('#sub_categoryId').val() >0 && $('#descriptionId').val() >0 && $('#languageId').val() >0)
    {
    	document.getElementById("errormessage").innerHTML = "";
    	document.getElementById('create').disabled = false;
    	//document.getElementById('submit1').disabled = false;
    }
    else {
    	document.getElementById("errormessage").innerHTML = "<span style='color:red; margin-left: 51px;'>*All fields are mandatory.</span>";
    	document.getElementById('create').disabled = true;
    }
} */


function campaignChange() {
	
	document.getElementById("brandId").disabled="";
	
}
function brandChange() {

	document.getElementById("productId").disabled="";
	
}
function productChange() {

	document.getElementById("categoryId").disabled="";
	
}
function categoryChange() {

	document.getElementById("sub_categoryId").disabled="";
	
} 
function sub_categoryChange() {

	document.getElementById("descriptionId").disabled="";
	
} 
function descriptionChange(){
	
	document.getElementById("languageId").disabled="";
	
}
function  languageChange () {

	document.getElementById("create").disabled="";
	
}
</script>
</html>
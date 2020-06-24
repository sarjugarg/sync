<style>
.selectable li {
	margin: 3px;
	padding: 1px 0px 0px 3px;
	font-size: 0.9em;
	height: 20px;
	cursor: pointer;
    white-space: nowrap; 
    overflow: hidden;
    text-overflow: ellipsis;
}

</style>

<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
<div class="modal-content">
        <div class="modal-header">
          <button type="button" onclick="closeModal();" class="close" data-dismiss="modal">&times;</button>
          
          <h4 class="modal-title" style="color: black;    font-size: 25px;">Sync Media Report</h4>
        </div>
        <div class="modal-body">
    <div style="display:inline-flex; padding:3px;">
        <!-- <button type="button" style=" height: 33px;margin-left: 6px; background-color:#333;margin-top: 4px;     color: rgb(85,206,249);" onclick="exportDataFile();">Export </button> -->
        
	
	<form class="form-horizontal"  role="form" modelAttribute="Pack" method='POST' id="formId">						
		<div style="display:inline-flex; padding:3px;">
		
		<select style=" height: 34px;margin-left: 6px;margin-right: 5px; background-color:#fff;color: black;" onchange="exportDataFile();" id="exportData">
       <option value="" disabled selected>Export</option>
        <option value="csv">Export Excel</option>
        <option value="pdf">Export Pdf</option>
        
        </select>		

				
				<!-- <label>From Date</label> -->
				
				<div class="col-xs-6 input-group date" id='startDate'>
							
							
							
									<input type='text' placeholder="From date" class="form-control" name="startDate" style="background-color: #fff;color: black);"
										id="datefilterid" value="" required="required"  onchange="datefilter();" /> <span class="input-group-addon"
									style="background-color:#fff;"	> <span style="background-color:#fff;" 
										class="glyphicon glyphicon-calendar" ></span>
									</span>
								</div>
						<!-- <label>To Date</label> -->
						<div class="col-xs-6 input-group date" id='endDate'>
										<label>
							
							</label>
									<input type='text' placeholder="To date" class="form-control" name="endDate" id='ed' style="background-color: #fff;color: black);" 
										 value="" required /> <span class="input-group-addon" style="background-color:#fff;"
										> <span
										class="glyphicon glyphicon-calendar" style="background-color:#fff;"></span>
									</span>
								</div>
<span id ="dateErrorMessage" style="display:none;"></span>
								</div>
							</form>
							</div>
							<form id="selectBoxForm">

											<div style="display:inline-flex; padding:3px;">
						<!-- 	
						<div class="dropdown cq-dropdown" data-name='statuses'>
						<div style="color: white; font-size: 11px;"
											class="dropdown-toggle" id="dropdown1" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="true">Select channel&nbsp; <i class="fa fa-caret-down"></i></div>
							<ul class="dropdown-menu selectable" aria-labelledby="dropdown1" style="margin-left: 5px;width:130px; background-color:#333; color: rgb(85,206,249);" name="channelfilter" id="channelfilter"  onchange="channelChangeFilter();"> 
							
							<input type="text" id="channelSearch" class="search-filter" onkeyup="searchFilter($(this))" ref="genre" placeholder="Search Genre"/>
											<div class="searchList" id="channelSearch">
										</div>
							</ul>
							<input type="text" id="channelSearch" onkeyup="searchFilter($(this))" >
							</div> -->
							 
							
							<div class="form-group">
							
								<div class="facilities">
									<!-- <select onchange="selectIngredient(this);" multiple="multiple" name='genreName'
									id="genre"> -->
									<div class="dropdown cq-dropdown" data-name='statuses'>
										<div style="color: black; font-size: 14px; width: 80px;     margin-right: 7px;"
											class="dropdown-toggle" id="dropdown1" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="true"> Channel&nbsp; <i class="fa fa-caret-down"></i></div>
										<ul class="dropdown-menu selectable"  id="channelfilter"
											aria-labelledby="dropdown1">
											
										
										
										</ul>
									</div>
								</div>
								</div>
							
								<div class="form-group">
							
								<div class="facilities">
									<!-- <select onchange="selectIngredient(this);" multiple="multiple" name='genreName'
									id="genre"> -->
									<div class="dropdown cq-dropdown" data-name='statuses'>
										<div style="color: black; font-size: 14px;     width: 80px;     margin-right: 4px;"
											class="dropdown-toggle" id="dropdown1" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="true"> Brand&nbsp; <i class="fa fa-caret-down"></i></div>
										<ul class="dropdown-menu selectable"  id="brandfilter"
											aria-labelledby="dropdown1">
										</ul>
									</div>
								</div>
								</div>
							
							<div class="form-group">
							
								<div class="facilities">
									<!-- <select onchange="selectIngredient(this);" multiple="multiple" name='genreName'
									id="genre"> -->
									<div class="dropdown cq-dropdown" data-name='statuses'>
										<div style="color: black; font-size: 14px;        width: 80px;     margin-right: 14px;"
											class="dropdown-toggle" id="dropdown1" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="true"> Category&nbsp; <i class="fa fa-caret-down"></i></div>
										<ul class="dropdown-menu selectable"  id="categoryfilter"
											aria-labelledby="dropdown1">
										</ul>
									</div>
								</div>
								</div>
							

							<div class="form-group">
							
								<div class="facilities">
									<!-- <select onchange="selectIngredient(this);" multiple="multiple" name='genreName'
									id="genre"> -->
									<div class="dropdown cq-dropdown" data-name='statuses'>
										<div style="color: black; font-size: 14px; width:80px;     margin-right: 7px;"
											class="dropdown-toggle" id="dropdown1" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="true">Product&nbsp; <i class="fa fa-caret-down"></i></div>
										<ul class="dropdown-menu selectable"  id="productfilter"
											aria-labelledby="dropdown1">
										</ul>
									</div>
								</div>
								</div>							

<div class="form-group">
							
								<div class="facilities">
									<!-- <select onchange="selectIngredient(this);" multiple="multiple" name='genreName'
									id="genre"> -->
									<div class="dropdown cq-dropdown" data-name='statuses'>
										<div style="color: black; font-size: 14px; width:80px;     margin-right: 14px;"
											class="dropdown-toggle" id="dropdown1" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="true"> Language&nbsp; <i class="fa fa-caret-down"></i></div>
										<ul class="dropdown-menu selectable"  id="languagefilter"
											aria-labelledby="dropdown1">
										</ul>
									</div>
								</div>
								</div>	
<div>
<div class="facilities">
									<!-- <select onchange="selectIngredient(this);" multiple="multiple" name='genreName'
									id="genre"> -->
									<div class="dropdown cq-dropdown" data-name='statuses'>
										<div style="color: black; font-size: 14px; width:80px;     margin-right: 14px;"
											class="dropdown-toggle" id="dropdown1" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="true">Genre&nbsp; <i class="fa fa-caret-down"></i></div>
										<ul class="dropdown-menu selectable"  id="genrefilter"
											aria-labelledby="dropdown1">
										</ul>
									</div>
								</div>
								</div>	
							<!-- <select style="margin-left: 5px;width:130px; background-color:#333;    color: rgb(85,206,249);" name="brandfilter" id="brandfilter" onchange="brandFilter();" > 
							<option value="">select Brand</option>
							</select> -->
							<!--  <select style="margin-left: 5px;width:130px; background-color:#333;    color: rgb(85,206,249);" name="categoryfilter" id="categoryfilter" onchange="categoryfilterData()" > 
							<option value="">select Category</option>
		
							</select> -->
							<!-- <select style="margin-left: 5px;width:130px; background-color:#333;     color: rgb(85,206,249);" name="productfilter" id="productfilter" onchange="productFilterData()" > 
							<option value="">select Product</option>
							</select> -->
							<!-- <select style="margin-left: 5px;width:130px; background-color:#333;     color: rgb(85,206,249);" name="languagefilter" id="languagefilter" onchange="languageFilterData()" > 
							<option value="">select Language</option>
							</select> -->
							<!-- <select style="margin-left: 5px;width:130px; background-color:#333;     color: rgb(85,206,249);" name="genrefilter" id="genrefilter" > 
							<option value="">select Genre</option>
							</select>  -->
							<!-- <button type="button" style="margin-left: 5px;background-color:#333;     color: black;" onclick="showChannels();">SUBMIT</button> -->
							<input type="button" placeholder="submit" value="Submit" id="button" name="button" onclick="showChannels();" style="
width: 57px;
color: black;
padding: 0;
padding-left:;
background: none;
border: solid 1px #bfbaba;
height: fit-content;
">
							</div>
							
        </form>
          
        <form id="filterTab">
        <div style="display:flex; flex-direction: row; padding:3px;">
        
        <ul class="tag-box2 ui-sortable" id="filtersBox" style="display: none;">
	    </ul>
        
        </div>
        </form>
        </div>
          <table id="channelTable" class="display" style="width:100%">
          
          
          <thead id="tablehead" style="border-collapse: collapse;">
         <tr class="jsondiv" style="background-color:#fff;">
          <th>Channel</th>
         <th>Time</th>
         <th>Product</th>
         <th>Brand</th>
          <th>Category</th>
         
         <th>Language</th>
           <th>Playtime</th>
         <th>Airtime</th>
         <th>Genre</th>
         
       
       </tr>
          </thead>
          
          <tbody>
          
          </tbody>
          
          </table>
          
          
        </div>
      </div>
      </div>
      </div>

<script>
function searchFilter1(inputElement) {
	var input, filter, ul, li, a, i, txtValue;
	filter = inputElement.val().toUpperCase();
	ul = document.getElementById(inputElement.attr("ref"));
	li = ul.getElementsByTagName("li");
	for (i = 0; i < li.length; i++) {
	a = li[i];
	txtValue = a.textContent || a.innerText;
	if (txtValue.toUpperCase().indexOf(filter) > -1) {
	li[i].style.visibility = "visible";
	li[i].style.height = "20px";
	li[i].style.position = "relative";
	li[i].style.left = ""; 
	} else { 
	li[i].style.visibility = "hidden";
	li[i].style.height = "0px";
	li[i].style.position = "absolute";
	li[i].style.left = "-1000px";
	} 
	} 
	}

/* 	
function clickA() {
	//alert("inside function");
//	
 	//alert($(this).text());
	console.log($(this).text()); 
	
 } */
	
	
 var channel="";	
 var Brand="";
 var category="";
 var product="";
 var language="";
 var genre="";
var  productsR="";
$("#channelfilter ").on("click","li",function(e) {
	
		
 //channel=encodeURIComponent($(this).text());
	
	////alert("channel name="+channel);
	
	//alert("channel in report"+channelidR);
	
	
	
	 if ($(this).hasClass("ui-selected-multi")) {
		$(this).removeClass(
						"ui-selected ui-selected-multi");
		handleTags2($(this).text(), $(this).attr('id'), "channel",
				"remove");
		//alert("li //alert");
		channel="";
	} else {
		$(this).addClass(" ui-selected-multi");
		handleTags2($(this).text(), $(this).attr('id'), "channel",
				"add");
	}
 
	 channelChangeFilter(channelidR);
	 genreFilter(categorysR,channelidR,brandsR,productsR) 
});

$("#brandfilter ").on("click","li",function(e) {
	
	 Brand=encodeURIComponent($(this).text());
		
		////alert("Brand name="+Brand);
		
		//channelChangeFilter(channel);
		
		 if ($(this).hasClass("ui-selected-multi")) {
			$(this).removeClass(
							"ui-selected ui-selected-multi");
			handleTags2($(this).text(), $(this).attr('id'), "brand",
					"remove");
			Brand="";
			channel="";
		} else {
			$(this).addClass(" ui-selected-multi");
			handleTags2($(this).text(), $(this).attr('id'), "brand",
					"add");
		}
		 brandFilter(brandsR,channelidR);
	});
	
$("#categoryfilter").on("click","li",function(e) {
	
	category=encodeURIComponent($(this).text());
		
		////alert("category name="+category);
		
		
		 if ($(this).hasClass("ui-selected-multi")) {
			$(this).removeClass(
							"ui-selected ui-selected-multi");
			handleTags2($(this).text(), $(this).attr('id'), "category",
					"remove");
			category="";
			channel="";
			Brand="";
		} else {
			$(this).addClass(" ui-selected-multi");
			handleTags2($(this).text(), $(this).attr('id'), "category",
					"add");
		} 
		 categoryfilterData(categorysR,channelidR,brandsR);
	});
	
$("#productfilter ").on("click","li",function(e) {
	
	product=encodeURIComponent($(this).text());
		
		////alert("category name="+product);
		
		
	 if ($(this).hasClass("ui-selected-multi")) {
			$(this).removeClass(
							"ui-selected ui-selected-multi");
			handleTags2($(this).text(), $(this).attr('id'), "product",
					"remove");
			category="";
			channel="";
			Brand="";
			product="";
		} else {
			$(this).addClass(" ui-selected-multi");
			handleTags2($(this).text(), $(this).attr('id'), "product",
					"add");
		}
	 productFilterData(categorysR,channelidR,brandsR,productsR);
	 });
$("#languagefilter").on("click","li",function(e) {
	
	language=encodeURIComponent($(this).text());
		
		////alert("category name="+product);
		
		
		 if ($(this).hasClass("ui-selected-multi")) {
			$(this).removeClass(
							"ui-selected ui-selected-multi");
			handleTags2($(this).text(), $(this).attr('id'), "language1",
					"remove");
			category="";
			channel="";
			Brand="";
			product="";
		} else {
			$(this).addClass(" ui-selected-multi");
			handleTags2($(this).text(), $(this).attr('id'), "language1",
					"add");
		} 
		 //languageFilterData(categorysR,channelidR,brandsR,productsR);
});
	
$("#genrefilter ").on("click","li",function(e) {
	
	genre=encodeURIComponent($(this).text());
		////alert("genre name="+genre);
		////alert("category name="+product);
		//languageFilterData(category,channel,Brand,product);
		
		 if ($(this).hasClass("ui-selected-multi")) {
			$(this).removeClass(
							"ui-selected ui-selected-multi");
			handleTags2($(this).text(), $(this).attr('id'), "genre",
					"remove");
			//alert("li //alert");
			genre="";
		} else {
			$(this).addClass(" ui-selected-multi");
			handleTags2($(this).text(), $(this).attr('id'), "genre",
					"add");
		} 
		 
	});
	 

function handleTags2(selection, selectionId, parent, action) {
	$('.tag-box2').show();
	
	var ul = $(".tag-box2");
	var ids = selectionId.substring(8);
	if (action == 'add'
			&& $(".tag-box2").find("#tag_" + ids).length == 0) {
			$('.tag-box2').append('<li class="tags '+parent+' ui-sortable-handle" id="tag_'+ids+'" >'
								+ selection
								+ '<a class="close"></a></li>');
		$("#tag_" + ids).addClass("tagp");
		multiColumn();
		//allOnloadChannelGraph(page);
	} if(action == 'remove') {
		//alert("function  //alert");
		//alert("aftre removre channel"+channel);
		$("#tag_" + ids).remove();
		channel="";
		
		var children = $('.tag-box2')
				.children().length;
		if (children == 0) {
			$('.tag-box2').hide();
		}
		multiColumn();
		//allOnloadChannelGraph(page);
	}

	$("#tag_" + ids).on("click",function(e) {
				$("#option2_"+ids).removeClass("ui-selected ui-selected-multi");
				$(this).remove();
				
				//alert("closed channel"+channelidR);
				
			//	channelidR="";
				
				//alert("closed function"+channelidR);
				
				var children = $('.tag-box2')
						.children().length;
				if (children == 0) {
					$('.tag-box2').hide();
				}
						
				//allOnloadChannelGraph(page);
				multiColumn();
			});
}							

</script>
      
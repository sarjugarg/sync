
	
$(document).ready(function() {
	
	
	var li="";
	var liSelected="";

	/*				$('#searchtag').keypress(function(e) {
			        if(e.which == 13) {
			            searchData();
			            e.preventDefault();
			            return false;
			        }
			    });*/

	$('#searchLink').on("click",function(e){
		searchData();
	});

	function searchData(){
		var _this =document.getElementById("searchtag").value; // copy of this object for further usage
		//  if(_this.length>2 && _this.length<=50){

		var v = document.getElementById("searchtag").value;
		var obj = {
				"term" : v
		};
		dontBlock = true;
		$.ajax({
			global: false,
			type : "POST",
			data : JSON.stringify(obj),
			contentType : "application/json",
			dataType : 'html',
			url : contextpath +"/search",
			success : function(data) {
				var selectdiv=$("#searchdatalist");
				selectdiv.empty();
				var response=[];
				var text="Last 7 days"; 
				response =$.parseJSON(data);
				var Html="";
				if(data.trim()==''|| data.trim()=="[]"){
					$("#searchdatalist").hide();
				}
				else{
					$("#searchdatalist").show();
					for(var i=0;i<response.length;i++)
					{
						var maxLength = 15;
						var term=response[i].term;
						var searchfield;
						if(term.length>15){
							searchfield = term.substring(0, maxLength) + '...';
						} 
						else{
							searchfield=term;
						}
						var j=1;
						if(response[i].type=='Brand'){
							Html='<li  id="'+i+'"  class="search-li Brand"  ><input  type="hidden" value="'+term+'" id="SingleBrand'+i+'" /><a  onclick="BrandSearch('+i+','+j+')"   style="position: inherit;color:white;font-size:11px;"  href="#"><span title="'+term+'"  style="font-size: 11px;">'+searchfield+'</span> - '+response[i].type+'</a></li>';
							$('ul#searchdatalist').append(Html);				    		   
						}
						else if(response[i].type=='Channel'){
							Html='<li  id="'+response[i].cid+'" class="search-li Channel" ><a  style="color:white;font-size:11px;    position: inherit"  onclick="ChannelSearch('+response[i].cid+')" href="#"><span title="'+term+'"  style="font-size: 11px;">'+searchfield+'</span> - '+response[i].type+'</a></li>';
							$('ul#searchdatalist').append(Html);				    		   
						}
						if(response[i].type=='Category'){
							Html='<li  id="'+i+'"  class="search-li Category"><input type="hidden" value="'+term+'"  id="SingleCategory'+i+'" /><a style="color:white;font-size:11px;position: inherit;"  onclick="CategorySearch('+i+','+j+')" href="#"><span title="'+term+'"  style="font-size: 11px;">'+searchfield+'</span> - '+response[i].type+'</a></li>';
							$('ul#searchdatalist').append(Html);				    		         
						} 
						else if(response[i].type=='Product'){

							Html='<li  id="'+i+'"  class="search-li Product"><input type="hidden" value="'+term+'"  id="SingleProduct'+i+'" /><a style="color:white;font-size:11px;position: inherit;" href="#" onclick="ProductSearch('+i+','+j+')" ><span title="'+term+'" style="font-size: 11px;" >'+searchfield+'</span> - '+response[i].type+'</a></li>';
							$('ul#searchdatalist').append(Html);				    		   
						}  
						else{
						} 

					}
				}

			}, 

			error : function() {
			}

		});

		/*}     
		            else{
		            	$("#searchdata").hide();	
		            }*/

	} 


	//$(window).on('keydown', function(e){
	//  $(window).on("keydown",function(e) { 	
/*	var selected=""; 
	$("body").on("keyup", "#searchform input#searchtag", function (e) {
	
		var _this =$(this).val();
		if(_this.length>0){
            
			li = $('#searchdatalist  li');			    
			if(e.which === 40){
				if(liSelected){
					liSelected.removeClass('background');
					next = liSelected.next();
					if(next.length > 0){
						liSelected = next.addClass('background');
						selected = next.text();

					}else{
						liSelected = li.eq(0).addClass('background');
						selected = li.eq(0).text();
					}
				}else{

					liSelected = li.eq(0).addClass('background');
					selected = li.eq(0).text();
				}
			}else if(e.which === 38){
				if(liSelected){
					liSelected.removeClass('background');
					next = liSelected.prev();
					if(next.length > 0){
						liSelected = next.addClass('background');
						selected = next.text();

					}else{

						liSelected = li.last().addClass('background');
						selected = li.last().text()
					}
				}else{

					liSelected = li.last().addClass('background');
					selected = li.last().text();

				}
			}
			else if(e.which===8){
				searchData();
			}
			else if(e.which===13){
				//event.preventDefault();
				var idName=$('.background').attr('id');
				
				var classname=li.attr("class");
				if(classname=='search-li Brand background'){
					BrandSearch(idName,1);
				}
				else if(classname=='search-li Channel background'){
					ChannelSearch(idName);
				}
				//else if(classname=='search-li Product background'){
				else if(classname=='search-li Product background'){	
					ProductSearch(idName,1);
				}
				else if(classname=='search-li Category background'){
					CategorySearch(idName,1);
				}
				
				else{
				}
			}
			else{
				searchData();
			}
		}
		else if (_this.length=0){
			$("#searchdatalist").hide();   
		}
		else{
			$("#searchdatalist").hide(); 
		}
	});*/


});	


$(document).ready(function() {
	
	
	var li="";
	var liSelected="";

	/*				$('#searchtag').keypress(function(e) {
			        if(e.which == 13) {
			            searchData();
			            e.preventDefault();
			            return false;
			        }
			    });*/

	$('#searchLink').on("click",function(e){
		searchData();
	});
function liselected(pos){
	document.getElementById('searchdatalist').scrollTop = pos	

}
	
	function searchData(){
		var _this =document.getElementById("searchtag").value; // copy of this object for further usage
		//  if(_this.length>2 && _this.length<=50){

		var v = document.getElementById("searchtag").value;
		var obj = {
				"term" : v
		};
		dontBlock = true;
		$.ajax({
			global: false,
			type : "POST",
			data : JSON.stringify(obj),
			contentType : "application/json",
			dataType : 'html',
			url : contextpath +"/search",
			success : function(data) {
				var selectdiv=$("#searchdatalist");
				selectdiv.empty();
				var response=[];
				var text="Last 7 days"; 
				response =$.parseJSON(data);
				var Html="";
				if(data.trim()==''|| data.trim()=="[]"){
					$("#searchdatalist").hide();
				}
				else{
					$("#searchdatalist").show();
					for(var i=0;i<response.length;i++)
					{
						var maxLength = 15;
						var term=response[i].term;
						var searchfield;
						if(term.length>15){
							searchfield = term.substring(0, maxLength) + '...';
						} 
						else{
							searchfield=term;
						}
						var j=1;
						if(response[i].type=='Brand'){
							Html='<li   id="'+i+'"  class="search-li Brand"  ><input  type="hidden" value="'+term+'" id="SingleBrand'+i+'" /><a  onclick="BrandSearch('+i+','+j+')"   style="position: inherit;color:white;font-size:11px;"  href="#"><span title="'+term+'"  style="font-size: 11px;">'+searchfield+'</span> - '+response[i].type+'</a></li>';
							$('ul#searchdatalist').append(Html);				    		   
						}
						else if(response[i].type=='Channel'){
							Html='<li  id="'+response[i].cid+'" class="search-li Channel" ><a  style="color:white;font-size:11px;    position: inherit"  onclick="ChannelSearch('+response[i].cid+')" href="#"><span title="'+term+'"  style="font-size: 11px;">'+searchfield+'</span> - '+response[i].type+'</a></li>';
							$('ul#searchdatalist').append(Html);				    		   
						}
						if(response[i].type=='Category'){
							Html='<li  id="'+i+'"  class="search-li Category"><input type="hidden" value="'+term+'"  id="SingleCategory'+i+'" /><a style="color:white;font-size:11px;position: inherit;"  onclick="CategorySearch('+i+','+j+')" href="#"><span title="'+term+'"  style="font-size: 11px;">'+searchfield+'</span> - '+response[i].type+'</a></li>';
							$('ul#searchdatalist').append(Html);				    		         
						} 
						else if(response[i].type=='Product'){

							Html='<li  id="'+i+'"  class="search-li Product"><input type="hidden" value="'+term+'"  id="SingleProduct'+i+'" /><a style="color:white;font-size:11px;position: inherit;" href="#" onclick="ProductSearch('+i+','+j+')" ><span title="'+term+'" style="font-size: 11px;" >'+searchfield+'</span> - '+response[i].type+'</a></li>';
							$('ul#searchdatalist').append(Html);				    		   
						}  
						else{
						} 

					}
				}

			}, 

			error : function() {
			}

		});

		/*}     
		            else{
		            	$("#searchdata").hide();	
		            }*/

	} 


	//$(window).on('keydown', function(e){
	//  $(window).on("keydown",function(e) { 	
	var selected=""; 
	$("body").on("keyup", "#searchform input#searchtag", function (e) {
		var _this =$(this).val();
		if(_this.length>0){
			
			li = $('#searchdatalist  li');			    
				if(e.which === 40){
					liselected(40);
					if(liSelected){
					liSelected.removeClass('background');
					next = liSelected.next();
					if(next.length > 0){
						liSelected = next.addClass('background');
						selected = next.text();

					}else{
						liSelected = li.eq(0).addClass('background');
						selected = li.eq(0).text();
					}
				}else{
					liSelected = li.eq(0).addClass('background');
					selected = li.eq(0).text();
				}
				
			}else if(e.which === 38){
				document.getElementById('searchdatalist').scrollDown = 30	
				if(liSelected){
					liSelected.removeClass('background');
					next = liSelected.prev();
					if(next.length > 0){
						liSelected = next.addClass('background');
						selected = next.text();

					}else{

						liSelected = li.last().addClass('background');
						selected = li.last().text()
					}
				}else{
					liSelected = li.last().addClass('background');
					selected = li.last().text();

				}
			}
			else if(e.which===8){
				searchData();
			}
			else if(e.which===13){
				//event.preventDefault();
				var idName=$('.background').attr('id');
				var classname=$('.background').attr("class");
				if(classname=='search-li Brand background'){
					BrandSearch(parseInt(idName),1);
				}
				else if(classname=='search-li Channel background'){
					ChannelSearch(parseInt(idName));
				}
				//else if(classname=='search-li Product background'){
				else if(classname=='search-li Product background'){
					console.log(idName,1,0);
					ProductSearch(parseInt(idName),1,0);
				}
				else if(classname=='search-li Category background'){
					CategorySearch(parseInt(idName),1);
				}
				
				else{
					//console.log(idName,1,0);
					//ProductSearch(idName,1,0);		
				}
			}
			else{
				searchData();
			}
		}
		else if (_this.length=0){
			$("#searchdatalist").hide();   
		}
		else{
			$("#searchdatalist").hide(); 
		}
		

		
		})
	
 
});	

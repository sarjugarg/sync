								 if(productfilter=='null'){
									}
								 else  if(productfilter==null){
									}
									else if(productfilter=='undefined'){
									}
									else{

								var array = productfilter.split("~");
							var filterdiv=$('#tagBox');
	           						$('#tagBox').show();  
					    	for(var i=0;i<array.length;i++){
								var productid=array[i].replace(/[^A-Z0-9~!@#%&-=`\/^$|?*+().]/ig, "_");
								productid=productid.replace(' ','_');
								$('#option_'+productid).selectable();							
	                            $('#option_'+productid).removeClass();
	                            $('#option_'+productid).addClass("ui-widget-content product ui-selectee ui-selected ui-selected-multi");
 	                            handleTags(array[i],'option_'+productid, "product", "add");
 	                    	}
								}
								
                             if(genrefilter=='null'){
							}
                             else if(genrefilter==null){
 							}
							else if(genrefilter=='undefined'){
							}
							else{
								 var array = genrefilter.split("~");
								var filterdiv=$('#tagBox');
		           						$('#tagBox').show();  
						    	for(var i=0;i<array.length;i++){
									var genreid=array[i].replace(/[^A-Z0-9]/ig, "_");
								    $('#option_'+genreid).selectable();							
		                            $('#option_'+genreid).removeClass();
		                            $('#option_'+genreid).addClass("ui-widget-content genre ui-selectee ui-selected ui-selected-multi");
									handleTags(array[i],'option_'+genreid, "genre", "add");
		
	 	                            /* 		var html='<li class="tags product ui-sortable-handle tagp"  '+ 
									' id="tag_'+productid+'">'+array[i]+'<a class="close" onclick="removeLi(1)"></a></li></ul>';
									filterdiv.append(html); */
								}
									}						
							if(channelfilter=='null'){
								
							}
							else if(channelfilter==null){
								
							}
							else if(channelfilter=='undefined'){
								
							}
							else{
								var array;
								var filterdiv=$('#tagBox');
						   		
           						$('#tagBox').show();  
				    
								if (channelfilter.includes(',')) {
								    array = channelfilter.split("~");
									for(var i=0;i<array.length;i++){
										var channelids=array[i].replace(/[^A-Z0-9]/ig, "_");
									    $('#option_'+channelids).selectable();							
			                            $('#option_'+channelids).removeClass();
			                            $('#option_'+channelids).addClass("ui-widget-content channel ui-selectee ui-selected ui-selected-multi");
		 	                            handleTags(array[i],'option_'+channelids, "channel", "add");
			
		 	                    	}
			
								}
								else{
									array = channelfilter;	
									var channelids=array.replace(/[^A-Z0-9]/ig, "_");
								    $('#option_'+channelids).selectable();							
		                            $('#option_'+channelids).removeClass();
		                            $('#option_'+channelids).addClass("ui-widget-content channel ui-selectee ui-selected ui-selected-multi");
	 	                            handleTags(array,'option_'+channelids, "channel", "add");
					
								}
												}


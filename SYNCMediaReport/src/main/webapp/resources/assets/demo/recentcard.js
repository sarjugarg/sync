var logo;
function addRecentCardData(){
	var regex = new RegExp("'","g");
	var name=document.getElementById("cardName").value;
	allgraph();
	var obj={
		     time:selectedVal,
	         genre:genre2,
	         streamname:stream_name,		
	         brand:brands2,
	    	 language:language2,
	 		 product : products2,
	 		 cardName:name,
	 		 cid:cid,
	 		 elementType:elementType,
			 elementName:elementName,
			 url:cardUrl,
			 logo:logo
	}
	$.ajax({
		type : 'POST',
		url : contextpath + "/AddRecentCard",
		async: true,
		data : JSON.stringify(obj),
		contentType : "application/json",
		dataType : 'html',
        success: function(data){   
        	if(data=='Card created sucessfully!'){
        		 $('#cardmsg').css('color', '#d4ffa6');
        		 $('#cardmsg').text(data);
       document.getElementById("savecard").disabled =true;        		 
        	}
        	else{
           	 $('#cardmsg').css('color', '#ff2007');
        	$('#cardmsg').text(data);
        	}
        }, 
        error:function(){ 
        }
    });

} 
  
function getRecentCards(userid){
	   $.ajax({
			type : 'GET',
			url : contextpath + "/getRecentCards/"+userid,
			contentType : "application/json",
	        dataType: 'html', 
			success : function(data) {
			var resp=$.parseJSON(data);
	        var cardDiv=$('.inner ul');
	        cardDiv.empty();
	        for(var i=0;i<resp.length;i++){
	        var logo=resp[i].logo;
	        var elementType=resp[i].elementType;
	        productfilter=resp[i].product;
	        if(logo=='NA' || logo==''){
	        	logo='./resources/images/no_img.png';
	        }
            if(elementType=='Category'){
	        	logo='./resources/images/category.png';
	        }
	        else if(elementType=='Product'){
	        	logo='./resources/images/Product.png';	
	        }
	        else if(elementType=='Channel'){
	        	logo='./resources/images/channel.png';	
	        }
	        else if(elementType=='Brand'){
	        	logo='./resources/images/brand.png';	
	        }
	        else{
	        	if(logo!='./resources/images/no_img.png'){
	        	 	logo=resp[i].logoUrl+logo; 		
	        	}
	       
	        	
	        }
	         
	        var functioncall="";
	        var j=parseInt(2)
	        i=parseInt(i);
	        var channelf=null;
	        var productf=null;
	        var brandf=null;
	        var genref=null;
	        var languagef=null;
	        channelf=resp[i].streamname;
	        productf=resp[i].product;
	        genref=resp[i].genre;
	        languagef=resp[i].language;
	        brandf=resp[i].brand;
	        if(elementType=='SingleCategory'){
	        	functioncall='CategorySearch('+i+','+j+',1)';	
	        }
	        else if(elementType=='SingleProduct'){
	        	functioncall='ProductSearch('+i+','+j+',1)';	
	        }
	        else if(elementType=='SingleChannel'){
	        	functioncall='ChannelSearch('+resp[i].elementName+',1)';	
	        }
	        else if(elementType=='SingleBrand'){
	        	functioncall='BrandSearch('+i+','+j+',1)';	
	        }
	        else if(elementType=='Product'){
	        	functioncall="window.location.href='"+resp[i].url+"?productfilter="+escape(productf)+"&genre="+escape(genref)+"&channel="+escape(channelf)+"&cardstatus=1'";	
	        }
	        else if(elementType=='Brand'){
	        	functioncall="window.location.href='"+resp[i].url+"?brandfilter="+escape(brandf)+"&genre="+escape(genref)+"&channel="+escape(channelf)+"&cardstatus=1'";	
	        }
	        else if(elementType=='Channel'){
	        	functioncall="window.location.href='"+resp[i].url+"?genre="+escape(genref)+"&channel="+escape(channelf)+"&language="+escape(languagef)+"&cardstatus=1'";	
	        }
	        else if(elementType=='Category'){
	        	functioncall="window.location.href='"+resp[i].url+"?genre="+escape(genref)+"&channel="+escape(channelf)+"&cardstatus=1'";	
	        } 
	        
	        var filterdiv=$('.tag-box ui-sortable');
	        products=resp[i].product;  
	        var html='<li class="card-li"><div class="thumb">'+
			'<img src="'+logo+'" alt="image02" class="img">'+
			'<input type="hidden" id="'+elementType+i+'" value="'+resp[i].elementName+'"/>'+
			'<a data-toggle="tooltip" title="'+resp[i].cardName+'" href="#" style="width: 89%;white-space: nowrap;overflow: hidden;text-overflow: ellipsis;"  class="center">'+resp[i].cardName+'</a>'+
			'<a    onclick="'+functioncall+'"   class="icon-1"><i class="fas fa-eye" style="font-size:30px;color:gray;"></i></a>'+
		'</div></li>';
	        
	        /*var html='<li>'+
            '<a class="thumb" href="'+logo+'"></a>'+
           '<input type="hidden" id="'+elementType+'0'+i+'" value="'+resp[i].elementName+'"/> '+
			'<a  onclick="'+functioncall+'"  href="'+resp[i].url+'" class="center '+elementType+'"> '+resp[i].cardName+' </a>'+
        '</li>';*/
	        
	        cardDiv.append(html);
	       
	        }
          if(data!='[]'){
	   slideshow(); 	
	        }
	       
			},
			error : function() {
			} 
		});
} 
     


function clickCards(i){
	var j='0';
	var elementType=$(this).attr('class');
    if(elementType=="SingleChannel"){
   	 ChannelSearch(""+i+"");  
    }
    else if(elementType=="SingleProduct")
   	 {
   	 ProductSearch("0"+i+""); 
   	 }
    else if(elementType=="SingleCategory"){
   	 CategorySearch("0"+i+""); 
    }
    else if(elementType=="SingleBrand"){
   	 BrandSearch("0"+i+""); 
    }
   } 
function showModal(){
document.getElementById('cardmsg').innerHTML = '';
document.getElementById("cardName").value="";
$("#cardModal").modal();	
}                                           
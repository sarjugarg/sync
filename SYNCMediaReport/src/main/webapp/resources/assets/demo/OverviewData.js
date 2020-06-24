$(document).ajaxStart(function() {
	$.blockUI({ message: $('<img src="./resources/images/loader.gif" />') });
	$(".blockPage").css({ 'background-color' : '', 'border' : '' });
});

$(document).ajaxStop(function() {
	$.unblockUI();
});


function overviewData(){
	allgraph();
	dateselecteddata();
	obj = {
			startdate :fromdate,
			enddate :todate, 
			time : selectedVal
		}; 
	getChannelsList(fromdate, todate,escape(datelabel));
    getCategoryList(fromdate,todate,escape(datelabel));
	getTopProducts(fromdate,todate,escape(datelabel));
	getBrandList(fromdate,todate,escape(datelabel));
	
}
/*$(document).ajaxStart(function() {
	$.blockUI({ message: $('<img src="./resources/images/security_bnr_fp.gif" />') });
	$(".blockPage").css({ 'background-color' : '', 'border' : '' });
});

$(document).ajaxStop(function() {
	$.unblockUI();
	
});  


*/






/*var ul = document.querySelector('.CategoryList');
var nodes = document.querySelectorAll('div');
var selected = 0;

[].forEach.call(nodes, function(el) {
    el.addEventListener('click', function() {
        select(this);
    })
}); 

document.addEventListener('keydown', function(e) {
    if (e.keyCode === 38) { // up
        select(nodes[selected - 1]);
    }
    if (e.keyCode === 40) { // down
        select(nodes[selected + 1]);
    }
    e.preventDefault();
});

function select(el) {
    var s = [].indexOf.call(nodes, el);
    if (s === -1) return;
    
    selected = s;
    
    var elHeight = $(el).height();
    var scrollTop = $(ul).scrollTop();
    var viewport = scrollTop + $(ul).height();
    var elOffset = elHeight * selected;
    
    console.log('select', selected, ' viewport', viewport, ' elOffset', elOffset);
    if (elOffset < scrollTop || (elOffset + elHeight) > viewport)
        $(ul).scrollTop(elOffset);
    
    document.querySelector('li.selected').classList.remove('selected');
    el.classList.add('selected');
}*/

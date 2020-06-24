$(document).ajaxStart(function() {
	$.blockUI({ message: $('<img src="./resources/images/loader.gif" />') });
	$(".blockPage").css({ 'background-color' : '', 'border' : '' });
});

$(document).ajaxStop(function() {
	$.unblockUI();
});
 function tabledata(){ 
	var fromdate = $("#startDateSelected").val();
    var todate = $("#endDateSelected").val(); 
	$('#channelTable').DataTable({
	//	"processing": true,
      //  "serverSide": true,
			'ajax' : {
				 url: ''+contextpath+'/exportData/'+fromdate+'/'+todate,
				'type' : 'POST',
			
			},
			 	scrollX : "125px",
				scrollY : "275px",
				"aaSorting" : [],
				"bPaginate" : true,
				"bFilter" :true ,
				"bInfo" : true,
				"destroy": true,
				'paging':  true,
				"bSearchable" : true,
				  dom: 'Bfrtip',
			      buttons: [
			            'excelHtml5',
			            'csvHtml5',
			            {
			                'extend': 'pdfHtml5',
			                'processing': true,
							'serverSide': true,
			                'orientation':  'landscape',
			                'pageSize':  'A0',
			                'exportOptions':
			                {
			                  'columns':  ':visible'
			                },
			            }
			        ],
				

			"columns" : [
					{
						"data" : "streamName"
					},
					{
						"data" : "stream_url"
					},
					{
						"data" : "stream_id"
					},
					{
						"data" : "status"
					},
					{
						"data" : "msg"
					},
					{
						"data" : "code"
					},
					{
						"data" : "version"
					},
					{
						"data" : "Result_Type"
					},
					{
						"data" : "record_timestamp"
					},
					{
						"data" : "timestamp_utc"
					},
					{
						"data" : "played_duration"
					},
					{
						"data" : "type"
					},
					{
						"data" : "count"
					},
					{
						"data" : "play_offset_ms"
					},
					{
						"data" : "sample_begin_time_offset_ms"
					},
					{
						"data" : "score"
					},
					{
						"data" : "sample_end_time_offset_ms"
					},
					{
						"data" : "title"
					},
					{
						"data" : "duration_ms"
					},
					{
						"data" : "bucket_id"
					},
					{
						"data" : "db_begin_time_offset_ms"
					},
					{
						"data" : "db_end_time_offset_ms"
					},
					{
						"data" : "acrid"
					},
					{
						"data" : "Rupa"
					},
					{
						"data" : "Astral_Pipes"
					},
					{
						"data" : "Act_II"
					},
					{
						"data" : "key1"
					},
					{
						"data" : "extra1"
					},
					{
						"data" : "extra2"
					},
					{
						"data" : "Sub_Brand"
					},
					{
						"data" : "Description"
					},
					{
						"data" : "Campaign"
					},
					{
						"data" : "Brand"
					},
					{
						"data" : "Genre"
					},
					{
						"data" : "Sub_Categories"
					},
					{
						"data" : "Language"
					},
					
					{
						"data" : "master_status"
					},
					{
						"data" : "language1"
					}],
			

		});
$('#myModal').modal();
 
}
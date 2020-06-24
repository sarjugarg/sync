
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 <link href='https://fonts.googleapis.com/css?family=Roboto'
	rel='stylesheet'>

<c:set var="context" value="${pageContext.request.contextPath}" />
<link href="${context}/resources/css/style2.css" type="text/css"
	rel="stylesheet" />
<link href="${context}/resources/css/style.css" type="text/css"
	rel="stylesheet" />
<link href="${context}/resources/css/reportstyle.css" type="text/css"
	rel="stylesheet" />

<link href="${context}/resources/css/icons.css" rel="stylesheet" />
<link href="${context}/resources/assets/css/black-dashboard.css?v=1.0.0"
	rel="stylesheet" />
 <link href="${context}/resources/css/dataTables.min.css"
	rel="stylesheet" />
 <link rel="stylesheet" type="text/css"
	href="${context}/resources/css/daterangepicker.css"></link>
<link rel="stylesheet"
	href="${context}/resources/css/bootstrap.min.css">
<link type='text/css' rel='stylesheet'
	href='${context}/resources/card/css/cardstyle.css' />
   <link href="${context}/resources/card/css/thumbnail-slider.css" rel="stylesheet" />
	<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'/>
   <link href="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/build/css/bootstrap-datetimepicker.css" rel="stylesheet">

<style>
.modal-body {
	height: 400px;
}

.modal-content {
	width: 198%;
	margin-left: -250px;
}
</style>


<meta content="Coderthemes" name="author" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
 <script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Report lib -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.2.4/css/buttons.dataTables.min.css">
<script src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
   <script src="https://cdn.datatables.net/buttons/1.5.6/js/dataTables.buttons.min.js"></script>
    <script src="https://cdn.datatables.net/responsive/2.1.1/js/dataTables.responsive.min.js"></script>
      <script src="https://cdn.datatables.net/fixedheader/3.1.2/js/dataTables.fixedHeader.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.5.6/js/buttons.html5.min.js"></script>   
 <script src="https://files.codepedia.info/files/uploads/iScripts/html2canvas.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/canvg/1.5/canvg.js"></script>   
 <script src="https://cdn.datatables.net/buttons/1.5.6/js/buttons.html5.min.js"></script>
<link href="https://datatables.net/download/build/dataTables.responsive.nightly.css" rel="stylesheet" type="text/css" />
<script src="https://datatables.net/download/build/dataTables.responsive.nightly.js"></script>
<!-- end of report lib -->



	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>


<script type="text/javascript"
	src="https://code.highcharts.com/highcharts.js"></script>
	

<script type="text/javascript"
	src="${context}/resources/js/jquery.slimscroll.min.js"></script>
<script type="text/javascript"
	src="http://malsup.github.io/jquery.blockUI.js"></script>
<script type="text/javascript"
	src="${context}/resources/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
<script type="text/javascript"
	src="${context}/resources/assets/js/core/popper.min.js"></script>


<!-- Chart JS -->
<script type="text/javascript"
	src="${context}/resources/assets/js/plugins/chartjs.min.js"></script>
<script type="text/javascript" src="${context}/resources/js/moment.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>

<!--  Notifications Plugin    -->
<script type="text/javascript"
	src="${context}/resources/assets/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Black Dashboard: parallax effects, scripts for the example pages etc -->
<script type="text/javascript"
	src="${context}/resources/assets/js/black-dashboard.min.js?v=1.0.0"></script>
<!-- Black Dashboard DEMO methods, don't include it in your project! -->

<script type="text/javascript"
	src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript"
	src="${context}/resources/assets/js/black-dashboard.js"></script>

<!-- App Js -->
<script type="text/javascript"
	src="${context}/resources/js/jquery.app.js"></script>

<script type="text/javascript"
	src="${context}/resources/assets/js/plugins/chartjs.min.js"></script>
<script type="text/javascript"
	src="${context}/resources/assets/js/black-dashboard.js"></script>
<script type="text/javascript"
	src="${context}/resources/assets/demo/demo.js"></script>
<script type="text/javascript"
	src="${context}/resources/assets/demo/productdata.js"></script>
<script type="text/javascript"
	src="${context}/resources/assets/demo/search.js"></script>
<script type="text/javascript"
	src="${context}/resources/assets/demo/recentcard.js"></script>
<script type="text/javascript"
	src="${context}/resources/assets/demo/branddata.js"></script>
<script type="text/javascript"
	src="${context}/resources/assets/demo/categorydata.js"></script>
<script type="text/javascript"
	src="${context}/resources/assets/demo/channeldata.js"></script>
<script type="text/javascript"
	src="${context}/resources/assets/demo/OverviewData.js"></script>
<script type="text/javascript"
	src="${context}/resources/assets/demo/ProductGraphHighchart.js"></script>
<%-- <script type="text/javascript" src="${context}/resources/js/moment.js"></script>
 --%>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<script type="text/javascript" src="${context}/resources/assets/demo/report.js"></script>

</head>
   
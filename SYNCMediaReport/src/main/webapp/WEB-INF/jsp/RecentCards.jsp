<script type="text/javascript">
function enablebutton(){
	var cardinput=document.getElementById("cardName").value;
	if(cardinput!=""){
		document.getElementById("savecard").disabled = false;
	}
}     

</script>
<div class="modal fade" id="cardModal" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content" style="width:100%; height:40%;display: block;
    margin: auto;">
				<div class="modal-header" style="margin-top:20px;">
					<button type="button" class="close" data-dismiss="modal" style="margin-top:10px;">&times;</button>
					<h4 class="modal-title">Recent Cards</h4>
				</div>
				<div class="width:100%;">
				
					<span style="text-align:center;">
						<p id="cardmsg" style="margin-bottom:-5px;"></p>
					</span>
				</div>
				<div class="modal-body">
					<div class="form-group"> 
						<div style="width: 85%; display: block; margin: auto; border-radius: 5px; margin-bottom:-20px; outline:none;">
							<input onkeyup="enablebutton();" type="text" id="cardName" class="form-control" style="color: black; height:30px; font-size:14px; border-radius: 5px !important;"  id="inputEmail3" placeholder="Enter Card Name"/>
						</div>
					</div>  
					<br>
					<div class="form-group">
						<div>
						<button disabled="disabled" type="submit" id="savecard" onclick="addRecentCardData()" class="btn btn-default" style="display: block; margin: auto; width: 40%; height: 30px; font-size: 14px;background: white !important;color: black !important;">Save</button>
						</div>
					</div>
				</div>
			</div>
		</div> 
	</div>  
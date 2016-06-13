
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Add New Location</h4>
      </div>
      <div class="modal-body ">
      		<div class="form-group ">
        				<label class=" control-lable">Location Id</label>
                        <div class="">
                            <input type="text" class="form-control" id="locationId" name= "locationId">
                             
                        </div>
        	</div>
        	<div class="form-group ">
        				<label class=" control-lable">Location Name</label>
                        <div class="">
                            <input type="text" class="form-control" id="locationDescription" name= "locationDescription">
                             
                        </div>
        	</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="saveLocation()">Save changes</button>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
function saveLocation() {
	var locationId =  $("#locationId").val();
	var locationDescription = $("#locationDescription").val();
/* 	$("#myModal").hide();
	$(".modal-backdrop").hide(); */
	
	$.ajax({
		type: 'POST',
        url: 'saveLocation?${_csrf.parameterName}=${_csrf.token}',
        data: {"locationId": locationId,"locationDescription":locationDescription},
        success : function(data) {  	        		
        	location.reload();
        },
        error: function(){
        	alert("Operation Error!");
        }
	});
	
	location.reload();
}
</script>

<!--

//-->
</script>
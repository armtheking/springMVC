<%-- 
    Document   : home2
    Created on : May 24, 2016, 2:51:17 PM
    Author     : C13.272
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
     <head>
     <%@ include file="../template/head.jspf" %>
        

    </head>
    <body>
    <%@ include file="../template/pageTitle.jspf" %>
    <div class="container">
	<div class="row">
	
		<div class="col-sm-2">
		
		</div>	
		<div class="col-sm-8">
				<div class="panel panel-default">
			<div class="panel-heading">Panel Header</div>
			<div class="panel-body">

				<%-- action="saveDownloadFileForm?${_csrf.parameterName}=${_csrf.token}" --%>
			<%-- <form:form enctype="multipart/form-data" method="POST"  modelAttribute="reportAccident" class="form-horizontal" > --%>
			<form action="" enctype="multipart/form-data" class="form-horizontal" method="POST">
                <div class="row">
               
                
                    <div class="form-group col-md-12">
                        <label class="col-md-6 control-lable" for="report_name">Report Name</label>
                        <div class="col-md-6">
                        	<input placeholder=" please input " type="text" name="report_name" id="report_name" class="form-control input-sm clearF" >
                            
                            <%-- Spring Tag <form:input type="text" path="report_name" id="report_name" class="form-control input-sm"/> --%>
                            
                            <div class="has-error">
                                <form:errors path="report_name" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-6 control-lable" for="reportType">Report Type</label>
                        <div class="col-md-6">
                        	
                            <%--Spring Tag  <form:select path="reportType" id="reportType" items="${report_type}" multiple="false" itemValue="id" itemLabel="typeName" class="form-control input-sm"/> --%>
                          
								<select id="report_type" name="report_type" class="form-control input-sm clearF" >
									<option value="" > Select Report Type</option>
	                           		<c:forEach items="${report_type}" var="obj">
										<option value="${obj.id}" >${obj.typeName}</option>
	                           		</c:forEach>
								</select>
                          
                           
                            <div class="has-error">
                                <form:errors path="reportType" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>
              
                <div class="row">
                
                    <div class="form-group col-md-12">
                        <label class="col-md-6 control-lable" for="reportLocation">Report Location</label>
                        <div class="col-md-6">
                            <%-- Spring Tag <form:select path="reportLocation" id="reportLocation" items="${report_location}" multiple="false" itemValue="id" itemLabel="location_name" class="form-control input-sm"/> --%>
                            <select title="test" id="report_location" name="report_location" class="form-control input-sm clearF" >
	                           		<option value="" > Select Report Location</option>
	                           		<c:forEach items="${report_location}" var="obj">
										<option value="${obj.locationId}" >${obj.locationId} / ${obj.locationDescription}</option>
	                           		</c:forEach>
								</select>
                            <div class="has-error">
                                <form:errors path="reportLocation" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>
               

                <div class="row">
                	<div class="form-group col-md-12">
	                	<div class="col-md-6">
	                	</div>
	                    <div class="col-md-6">
	                    	
	                        <input type="button" onclick="submitForm()" value=" Download File" class="btn form-control  btn-primary btn-sm clearF">
	                    	
	                    </div>
                     </div>
                </div>
                  <div class="row loadedReportForm_success" hidden="true">
                	<div class="form-group col-md-12">
	                	<div align="center"><h3 style="color: red">LOADED REPORT FORM</h3></div>
                     </div>
                </div>
            <%-- </form:form> --%>
			</form>
			</div>
    	</div>
    	
				 
	                
	            
	        
		</div>	
		
		
		<div class="col-sm-2">
	   		
	        
	  
	    </div>   
     
	</div>  
	</div>   
	<script type="text/javascript">
	$(document).ready(function(){
		
		$(".clearF").bind( "chick change mouseover", function() {
			$(".loadedReportForm_success").hide();
		});
	
	});
	
	function submitForm(){
	
		 callAjaxSaveForm() ;
		
		
		
		/* $.ajax({
			success:function(){
				$.when($.ajax(callAjaxSaveForm())).then(function(data, textStatus, jqXHR){
					$.when($.ajax(callAjaxDowloadFille())).then(function(data, textStatus, jqXHR){
						window.location.href ='${pageContext.request.contextPath}/uploadFileForm';
					});
				});
			}
		}); */
	

	
	}
	function callAjaxSaveForm() {
		var reportName = $("#report_name").val();
		var reportType = $("#report_type").val();
		var reportLocation = $("#report_location").val();
		$.ajax({
			type: 'POST',
	        url: 'saveDownloadFileForm?${_csrf.parameterName}=${_csrf.token}',
	        data: {"reportName": reportName,"reportType":reportType, "reportLocation":reportLocation},
	        success : function(data) {  	        		
	        		console.log(data.map_fileName);	     
	        		callAjaxDowloadFille(data.map_fileName);
	        },
	        error: function(){
	        	alert("Operation Error!");
	        }
		});
		
	}
	function callAjaxDowloadFille(obj){
		window.open("${pageContext.request.contextPath}/downloadFileForm1?partFile="+obj);
		//window.close();
		closeDialog();
		
	}
	function closeDialog() {
		
		$(".loadedReportForm_success").show();
	}
	</script>
	 <div class="navbar navbar-fixed-bottom">
            <div class="container-fluid c">
                <span class="navbar-text">
                    <br>
                    <img src="resources/img/LOGONEC.png" style="width:50px;height:20px; margin-bottom: 10px;"><b>&nbsp; Nippon Express NEC Logistics (Thailand) Co., Ltd.</b>                

                </span>
                <span class="navbar-text navbar-right" style="margin-right: 2%; margin-top:40px;">         
                    <b><font size="2px" >Template By: </font></b> 
                    <b><font size="2px" color="#08298A">Mr.Samart Panwan</font></b>
                </span>
            </div>
        </div>
       
          <%@ include file="../template/footer.jspf" %>
        <%@ include file="../template/scripts.jspf" %>
    </body>
</html>

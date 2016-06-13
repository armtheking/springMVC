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

				
			<form:form enctype="multipart/form-data" method="POST" action="saveUploadFile?${_csrf.parameterName}=${_csrf.token}" modelAttribute="reportAccident" class="form-horizontal" >

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-6 control-lable" for="report_name">Report Name</label>
                        <div class="col-md-6">
                            <form:input type="text" path="report_name" id="report_name" class="form-control input-sm"/>
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
                            <form:select path="reportType" items="${report_type}" multiple="false" itemValue="id" itemLabel="typeName" class="form-control input-sm"/>
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
                            <form:select path="reportLocation" items="${report_location}" multiple="false" itemValue="locationId" itemLabel="locationDescription" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="reportLocation" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>
                
                 <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-6 control-lable" for="file_data">Report File</label>
                        <div class="col-md-6">
                            <input type="file" name="file_data" class="form-control">
                             <div class="has-error">
                                <form:errors path="file_data" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                	<div class="col-md-6">
                	</div>
                    <div class="col-md-6">
                        <input type="submit" value="Register" class="btn btn-primary btn-sm"> or <a href="<c:url value='uploadFile' />">Cancel</a>
                    </div>
                </div>
            </form:form>

			</div>
    	</div>
    	
				 
	                
	            
	        
		</div>	
		
		
		<div class="col-sm-2">
	   		
	        
	  
	    </div>   
     
	</div>
	</div>  
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

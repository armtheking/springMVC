<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%@ include file="../template/head.jspf" %>
<!-- include file Dailog -->
<%@ include file="locationFormDialog/locationFormDialog.jsp" %>
<title>Insert title here</title>


<link href="<c:url value='/resources/datatable/css/demo_table_jui.css' />" rel="stylesheet" type="text/css" />

<link href="<c:url value='/resources/datatable/css/jquery-ui-1.8.24.custom.css' />" type="text/css" media="all" />


<script src="<c:url value='/resources/datatable/js/jquery.js' />" type="text/javascript"></script>
<script src="<c:url value='/resources/datatable/js/jquery.dataTables.js' />" type="text/javascript"></script>
	<script type="text/javascript">
        $(document).ready(function () {
            $("#companies").dataTable({
                "sPaginationType": "full_numbers",
                "bJQueryUI": true               
            });
        });
 </script>


  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<style type="text/css">
.btn_addnew {
 	margin-top: -10px;
    margin-bottom: 5px;
}
.btn-custom:hover{
    color: #000;
    background-color: #e9e9e9;
    border-color: #dddddd;

}
.btn-custom {
    color: #000;
    background-color: #f6f6f6;
    border-color: #dddddd;
}
</style>
</head>
<body>
<%@ include file="../template/pageTitle.jspf" %>
<div class="container">
<div class="row">
	
		<div class="col-sm-2">
		
		</div>	
		<div class="col-sm-8">
				<div class="panel panel-default">
			<div class="panel-heading">Location Report</div>
			<div class="panel-body">
				<div class="btn_addnew" align="right">
				<button type="button" class="btn  btn-custom" data-toggle="modal" data-target="#myModal">
				<i class="fa fa-plus-circle" aria-hidden="true"></i> New Location
				</button>
				</div>
 
				<table id="companies" class="display">
		            <thead>
		            
		                <tr>
		                    <th><u>LOCATION ID</u></th>
		                    <th><u>LOCATION DESCRIPTION</u></th>
                            <th><u></u></th>
		                </tr>
		            </thead>
		            <tbody>
		            	
						  
		          		<c:forEach items="${reportLocationList}" var="reportLocationList">
						  <tr>
						    <td>${reportLocationList.locationId }</td>
						    <td>${reportLocationList.locationDescription }</td>
						    
                            <td>
                              <div align="center">
                              		<a href="admin_edit_news.do?id=${news.news_ID }"><i class="fa fa-pencil" aria-hidden="true"></i></a>
                                	/ <a href="admin_deleteNews.do?id=${news.news_ID }"><i class="fa fa-trash" aria-hidden="true"></i></a>
                              </div>         
                            </td>
                            
						  </tr>
                          </c:forEach>
                          
						
		            </tbody>
		        </table>
			

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
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
 <%@ include file="template/head.jspf" %>
        

    </head>
    <body>
     <%@ include file="template/pageTitle.jspf" %>
	<div class="container">
		<div class="row">
		<div class="col-sm-2">
		
		</div>	
		<div class="col-sm-8">
		<div class="panel panel-default">
			<div class="panel-heading">Panel Header</div>
			<div class="panel-body">

				Dear <strong>${userName}</strong>, Welcome to  Page.


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
       
          <%@ include file="template/footer.jspf" %>
        <%@ include file="template/scripts.jspf" %>
    </body>
</html>

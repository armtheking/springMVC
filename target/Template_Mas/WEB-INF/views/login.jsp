<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="template/head.jspf" %>

        <!--    <ul id="menu" >
                <li style="float: right;"><a  href="${pageContext.request.contextPath}/viewData" style="color:#58ACFA;"> View Data </a></li>
        
            </ul>-->
    </head>

    <body   style="background:url(resources/img/bb.jpg)no-repeat center center fixed; 
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;">




        <form action="${loginUrl}" method="post" class="form-horizontal">

            <div class="box">
                <div class="container">
                    </br></br></br></br></br></br></br></br></br></br>
                    <div class="panel" style="background:none; width: 50%;  margin: 0 auto;" >

                        <div class="row" style="background-color: rgba(0,0,0,0.13);">
                            <center> <img src="resources/img/metric_tracking_icon.png" width="130" height="130"  /></center>
                            <p><FONT style="color: #FFFFFF; font-size:  22px;">IT-Tracking Version 1.0</FONT></p>
                        </div>
                        <div class="row" style="background-color: rgba(0,0,0,0.13);">
                            <br/> 
                            <div class="col-md-7">
                                <c:if test="${param.error != null}">

                                    <p><FONT style="color: #FF0000">Invalid username and password.</FONT></p>

                                </c:if>
                                <c:if test="${param.logout != null}">

                                    <p><FONT style="color: #01DF01">You have been logged out successfully.</FONT></p>

                                </c:if>
                                <center> <input type="text" class="form-control" id="username" name="username" placeholder="Username" autofocus="true" required> </center>
                                <br/>
                                <center> <input type="password" class="form-control" id="password" name="password" placeholder="Password" required> </center>

                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                                <button type="submit">Login</button>
                            </div>
                            <div class="col-md-1">
                                <div style=" border-left: 1px solid #FFFFFF;
                                     height: 200px;
                                     width: 1px;">
                                </div>

                            </div>
                            <div class="col-md-3">
                                <br/><br/>
                                <a  href="${pageContext.request.contextPath}/viewData" class="btn btn-primary" style="color:#FFFFFF; width: 136px; font-weight: bold;"><i class="glyphicon glyphicon-th-list"></i> View Data </a>
                                <br/><br/>
                                <a  href="${pageContext.request.contextPath}/tracking/" class="btn btn-danger" style="color:#FFFFFF; width: 136px; font-weight: bold;"><i class="glyphicon glyphicon-screenshot"></i> Tracking </a>

                            </div>

                        </div>           
                    </div>
                </div>
            </div>
        </form>



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
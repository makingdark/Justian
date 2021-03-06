<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%
 if (session.getAttribute("student") == null) {
%>
<jsp:forward page="login-student.jsp" />
<%
 }
%>
<html>
	<head>
		<meta charset="utf-8 u00E0"/>
		<title>Toets</title>
		<link href="/css/bootstrap.min.css" rel="stylesheet">
		<link href="/css/style.css" rel="stylesheet">
	</head>
	<body>	
		<nav class="navbar navbar-default" id="headernew">
		  <div class="container-fluid">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" id="toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand">
				<img alt="" src="images/logo.png" style="height: 25px"></img>
		      </a>
		    </div>
	      </div>
	    </nav>	
		<div class="container" id="content">
			<div class="row">
				<div class="col-md-5">
					<h2>Toets Succesvol beëindigd</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-5">
					<p>Je hebt de toets afgerond en de resultaten zijn naar de
						docent gestuurd.</p>
					<p>Bedankt voor het maken van de toets!</p>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<a href="logout-student.do" class="btn btn-default">beëindigen</a>
				</div>
			</div>
		</div>
		<nav class="navbar navbar-default navbar-fixed-bottom" id="footernew">
			<div class="container-fluid">
				<h6>© Direct-ACT & Justian Knobbout</h6>
			</div>
		</nav>
	</body>
</html>
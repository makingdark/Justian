<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8 u00E0"/>
		<title>Login</title>
		<link href="/css/bootstrap.min.css" rel="stylesheet">
		<link href="/css/style.css" rel="stylesheet">
	</head>
	<body>	
		<nav class="navbar navbar-default navbar-static-top" id="headernew">
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
				<h2>Log hier in als Student</h2>
			</div>
			<div class="row">
				<div class="col-md-4">
					<p>Vraag uw docent naar inloggegevens</p>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<div id="msgs">
						<% 
						Object msgs = request.getAttribute("msgs"); 
						if (msgs != null) { 	 
							out.println(msgs); 
							out.println(); 		
						}	%>
					</div>
				</div>
			</div>
			<div class="row" position = "center">
				<form id="studentInlog" action="/login-student.do" method="get">
	  				<div class="col-md-3">
						<input class="form-group form-control" type="number" name="code" placeholder="Voer hier uw code in" required autofocus="on">
					</div>
					<div class="col-md-2">
						<button class="btn btn-default" type="submit" name="button" value="login">login</button>
					</div>
				</form>
			</div>
		</div>
		<nav class="navbar navbar-default navbar-fixed-bottom" id="footernew">
		  <div class="container-fluid">
		    <h6>� Direct-ACT & Justian Knobbout</h6>
		  </div>
		</nav>
	</body>
</html>
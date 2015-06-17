<!DOCTYPE html>
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
		      <a class="navbar-brand" href="#">
				<img alt="" src="images/logo.png" style="height: 25px"></img>
		      </a>
	      </div>
	    </nav>	
		<div class="container" id="content">
			<div class="row">
				<h2>Vraag ${vraagnummer}</h2>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="row">
						<p>${context}</p>
					</div>
					<div class="row">
						<p><b>${vraag}</b></p>
					</div>
					<div class="row">
						<div class="col-md-6">
							<form id="antwoord" action="toets-vraag.do" method="get">
								<div class="form-group">
									<div class="row">
										<input class="form-control" type="text" required name="antwoord" placeholder="Voer hier uw antwoord in">
									</div>
									<div class="row">
										<button class="btn btn-default" type="submit" name="rekenmachine" value="toon">rekenmachine</button>
										<button class="btn btn-default" type="submit" name="button" value="volgende">volgende</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<img id="ilustratie" alt="ilustratie" src="data:image/gif;base64,${plaatje}"></img>
				</div>
			</div>
		</div>
		<nav class="navbar navbar-default navbar-fixed-bottom" id="footernew">
		  <div class="container-fluid">
		    <h6>� Direct-ACT & Justian Knobbout</h6>
		  </div>
		</nav>
	</body>
</html>

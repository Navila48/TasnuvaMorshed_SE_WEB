<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>ICC | home</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<!--[if lt IE 9]>
      <script src="static/js/html5shiv.min.js"></script>
      <script src="static/js/respond.min.js"></script>
    <![endif]-->

</head>
<body>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/welcome" class="navbar-brand">ICC</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="#">Login</a></li>
					<li><a href="/registerCountry">New Country</a></li>
					<li><a href="show-countries">All Countries</a></li>
					<li><a href="#">New Team Member</a></li>
					<li><a href="#">All Team Members</a></li>
				</ul>
			</div>
		</div>
	</div>


	<c:choose>
		<c:when test="${mode=='HOME' }">
			<div class="container" id="homediv">
				<div class="jumbotron text-center">
					<h1>Welcome to ICC</h1>
				</div>
			</div>
		</c:when>
<c:when test="${mode=='REGISTER_COUNTRY' }">
		<div class="container text-center">
			<h3>New Country Registration</h3>
			<hr>
			<form class="form-horizontal" method="POST" action="save-country">
				<input type="hidden" name="id" value="${country.id }" />
				<div class="form-group">
					<label class="control-label col-md-3">Country</label>
					<div class="col-md-7">
						<input type="text" class="form-control" name="country_name"
							value="${country.country_name}" />
					</div>
				</div>
				<div class="form-group ">
					<input type="submit" class="btn btn-primary" value="Register" />
				</div>
			</form>
		</div>
		</c:when>
		
		<c:when test="${mode=='ALL_COUNTRIES' }">
			<div class="container text-center" id="tasksDiv">
				<h3>All Countries</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Country</th>
								<th>Delete</th>
								<th>Edit</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="country" items="${countries }">
								<tr>
									<td>${country.id}</td>
									<td>${country.country_name}</td>								
									<td><a href="/delete-country?id=${country.id }"><span class="glyphicon glyphicon-trash"></span></a></td>
									
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
</c:when>
		
	</c:choose>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>
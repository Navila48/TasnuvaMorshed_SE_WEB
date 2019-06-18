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
					<li><a href="/show-countries">All Countries</a></li>
					<li><a href="/register-user">New Team Member</a></li>
					<li><a href="/show-users">All Team Members</a></li>
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
									<td><a href="/delete-country?id=${country.id }"><span
											class="glyphicon glyphicon-trash"></span></a></td>
									<td><a href="/edit-country?id=${country.id }"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
<c:when test="${mode=='UPDATE_COUNTRY' }">
			<div class="container text-center">
				<h3>Update Country Name</h3>
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
						<input type="submit" class="btn btn-primary" value="Update" />
					</div>
				</form>
			</div>
		</c:when>


<c:when test="${mode=='REGISTER_USER' }">
			<div class="container text-center">
				<h3>New Registration</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-user">
					<input type="hidden" name="id" value="${user.id }" />
					<div class="form-group">
						<label class="control-label col-md-3">Username</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="username"
								value="${user.username }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">DOB</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="dob"
								value="${user.dob }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Age</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="age"
								value="${user.age }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Role </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="role"
								value="${user.role }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Country </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="country"
								value="${user.country }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Password</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="password"
								value="${user.password }" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Register" />
					</div>
				</form>
			</div>
</c:when>


<c:when test="${mode=='ALL_TeamMembers' }">
<div class="container text-center" id="tasksDiv">
				<h3>All Team Members</h3>
				<hr>
				
				<div class="container mySpace">
	     <form method="GET" action="/show-users" class="form-inline">
	        <div class="form-group mb-2">
	         <input type="text" class="form-control" name="country"  placeholder="Search User" />
	         <input type="submit" value="Search"  class="btn btn-primary"/>
	        </div>
</form>
</div>
				
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Name</th>
								<th>Age</th>
								<th>Role</th>
								<th>Delete</th>
								<th>Edit</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${users }">
								<tr>
									<td>${user.username}</td>
									<td>${user.age}</td>
									<td>${user.role }</td>
									<td><a href="/delete-user?id=${user.id }&country=${user.country}"><span
											class="glyphicon glyphicon-trash"></span></a></td>
									<td><a href="/edit-user?id=${user.id }"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
</c:when>

<c:when test="${mode=='UPDATE_USER' }">
			<div class="container text-center">
				<h3>New Registration</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-user">
					<input type="hidden" name="id" value="${user.id }" />
					<div class="form-group">
						<label class="control-label col-md-3">Username</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="username"
								value="${user.username }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">DOB</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="dob"
								value="${user.dob }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Age</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="age"
								value="${user.age }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Role </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="role"
								value="${user.role }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Country </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="country"
								value="${user.country }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Password</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="password"
								value="${user.password }" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Register" />
					</div>
				</form>
			</div>
</c:when>


	</c:choose>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>
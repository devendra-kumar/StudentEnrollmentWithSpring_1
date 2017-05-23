<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="assets/css/bootstrap-united.css" rel="stylesheet" />

<style>
.error {
	color: #ff0000;
	font-size: 0.9em;
	font-weight: bold;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<title>Student Enrollment Login</title>
</head>
<body>
	<script src="jquery-1.8.3.js">
		
	</script>

	<script src="bootstrap/js/bootstrap.js">
		
	</script>
	
	<script>
	$(document).ready(function(){
		
		$("#ddlStudent").on("change",function(){
			//alert($(this).val());
			
			$.ajax({
				url : "getStudentDetailByID.html",
				data : {"id":$(this).val()},
				type : "GET",

				success : function(response) {
					$("#divStudentinfo").html("");
					$("#divStudentinfo").html(response);
				},
				error : function(xhr, status, error) {
					alert("error");
					$("#divStudentinfo").html("");
				}
			});
			
		})
	})
	
	</script>

	<div class="navbar navbar-default">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-responsive-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>

		<div class="navbar-collapse collapse navbar-responsive-collapse">
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search">
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/StudentEnrollmentWithSpring">Home</a></li>
				<li><a href="signup.html">Signup</a></li>
				<li class="active"><a href="login.html">Login</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Explore<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">Contact us</a></li>
						<li class="divider"></li>
						<li><a href="#">Further Actions</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.nav-collapse -->
	</div>

	<div class="container">
		<div class="jumbotron">
			<div>
				<h1>Welcome to Online Student Enrollment Login</h1>
				<p>Login to explore the complete features!</p>
			</div>
		</div>

		<div></div>
	</div>

	<div class="col-lg-6 col-lg-offset-3">
		<div class="well">
			<div class="container">
				<div class="row">
					<div class="col-lg-4">
						<form:form id="myForm" method="GET"
							class="bs-example form-horizontal" modelAttribute="student">
							
								<form:select path="firstName" class ="form-control" id="ddlStudent">
								<form:option value="0" label="Select One" />							
							     <form:options items="${studentList}"/>
								</form:select>							
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="col-lg-10 col-lg-offset-1">
		<div class="well">
			<div class="container">
				<div class="row">
					<div class="col-lg-10" id="divStudentinfo">
						
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>

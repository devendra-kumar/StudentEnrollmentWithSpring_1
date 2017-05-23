<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="assets/css/bootstrap-united.css" rel="stylesheet" />
<title>Student Enrollment Login</title>
</head>
<body>
	<script src="jquery-1.8.3.js"></script>

	<script src="bootstrap/js/bootstrap.js"></script>	
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


	<div class="col-lg-12 col-lg-offset-0">
		<div class="well">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<form:form method="POST" action="uploadMultipleFile.html" name="fileModel" modelAttribute="fileModel"
							enctype="multipart/form-data">
							Question: <input type="file" name="file" class="file">
							Question File Name: <form:input type="text" name="name" path="QuestionFileName"/><br />
							
							Answer 1: <input type="file" name="file">
							Answer 1 File Name: <form:input type="text"  name="name" path="AnswerFileName1"/><br />
							
							Answer 2: <input type="file" name="file">
							Answer 2 File Name: <form:input type="text"  name="name" path="AnswerFileName2"/><br />
							
							Answer 3: <input type="file" name="file">							
							Answer 3 File Name: <form:input type="text"  name="name" path="AnswerFileName3"/><br />
							
							Answer 4: <input type="file" name="file">
							Answer 4 File Name: <form:input type="text"  name="name" path="AnswerFileName4"/><br />
							<br/><br />
							 
							<input type="submit" value="Upload">
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
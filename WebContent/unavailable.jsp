<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
	</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
.semere {
	display: block;
	margin-left: auto;
	margin-right: auto;
}
</style>

</head>
<body>
	<header style="background-color: #03a9f4; height: 30px;">
	 </header>
	<div  class="container">
	     <hr style="border-top: 5px solid rgba(103,58,183,1);"/>
		<img src="img/car.jpg" class="semere"  style="height: 200px;">
		<h1>Sorry! this application is only up and running between ${applicationScope.startTime} PM to ${applicationScope.endTime} PM only</h1>	
		<img src="img/sry.jpg" class="semere"  style="height: 330px;">
		
	</div>

</body>
</html>
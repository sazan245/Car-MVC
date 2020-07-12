<%@page import="dao.CarDaoImpl"%>
<%@page import="dao.CarDao"%>
<%@page import="dao.entity.CarEntity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div  class="container">
      <img src="img/car.jpg"  style="height: 139px">


<table class="table table-bordered">

<tr>
<th>UserId:</th>
<td> ${sessionScope.userData.userid}</td>
</tr>
    
<tr>
<th>Name:</th>
<td> ${sessionScope.userData.name}</td>
</tr>

<tr>
<th>Address:</th>
<td> ${sessionScope.userData.address}</td>
</tr>

<tr>
<th>Vendor:</th>
<td> ${sessionScope.userData.vendor}</td>
</tr>

<tr>
<th>Car Model:</th>
<td> ${sessionScope.userData.model}</td>
</tr>

<tr>
<th>Car Color:</th>
<td> ${sessionScope.userData.color}</td>
</tr>

<tr>
<th>Car Number:</th>
<td> ${sessionScope.userData.number}</td>
</tr>

<tr>
<th>Price:</th>
<td> ${sessionScope.userData.price}</td>
</tr>
        
  </table>
  <a href="dashboard.jsp"> 
   				  	        <button type="button" class="btn btn-success">Return to Dashboard</button>
   				  	 </a>
  
  </div>
    <footer  class="footer">
  
   @Copyright SajanCarShowroom 2020

  </footer>

</body>
</html>
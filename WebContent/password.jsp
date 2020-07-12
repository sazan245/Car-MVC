<%@page import="dao.entity.CarEntity"%>
<%@page import="dao.CarDaoImpl"%>
<%@page import="dao.CarDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Password</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<%
String  userid=request.getParameter("userid");
CarDao carDao = new CarDaoImpl();
CarEntity carEntity = carDao.findprofile(userid);
%>

<header  style="height: 30px;background-color: #21c9ff;">
   </header>
    <div  class="container">
         <img src="img/car.jpg"  style="height: 239px">
          <br/>
          </div>
          
          <h3>Your Password is : <%=carEntity.getPassword() %></h3>
          
          <a href="index.jsp"> 
   				  	        <button type="button" class="btn btn-success">Return to login</button>
   				  	 </a>

</body>
</html>
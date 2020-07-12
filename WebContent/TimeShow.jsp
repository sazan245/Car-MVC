<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="dao.CarDaoImpl"%>
<%@page import="dao.CarDao"%>
<%@page import="dao.entity.CarEntity"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <title>Cars!!</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="css/style.css">
</head>
<body>

   <header  style="height: 30px;background-color: #21c9ff;">
   </header>
    <div  class="container">
         <img src="img/car.jpg"  style="height: 200px">
      <div class="container">
           <a href="car"> 
         <button type="button" class="btn btn-primary">Manage Users</button>
         </a>
         <a href="time"> 
         <button type="button" class="btn btn-primary">Block Time</button>
         </a>
          <a href="upload.jsp"> 
         <button type="button" class="btn btn-primary">Upload Photo</button>
         </a>
   				  	 <a href="profile.jsp"> 
   				  	        <button type="button" class="btn btn-success">Profile</button>
   				  	 </a>
   				  	 <a href="photos"> 
         <button type="button" class="btn btn-primary">Show Photo</button>
         </a>
   				  	  <a href="logout"> 
   				  	        <button type="button" class="btn btn-warning">Logout</button>
   				  	 </a>
         <hr/> 
   				  	  <br/>
   				  <span style="font-size: 20px;">${message}</span>  
         <hr/>
<p >ALL TIMES SAVED IN THE DATABASE</p>            
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Id</th>
        <th>Start Time</th>
        <th>End Time</th>

        <th>Action</th>
      </tr>
    </thead>
    <tbody>
    
    <c:forEach  items="${timeList}"  var="entity">
      <tr 
      <c:if test="${entity.active=='Yes'}">
      style="background-color:#73b5fd;"
        </c:if>
      >
         <td>${entity.pid}</td>
         <td>${entity.start}</td>
         <td>${entity.end}</td>
        <td>
        <c:if test="${entity.active=='No'}">
            <a  href="unlockBlockTime?pid=${entity.pid}"> 
         <img src="img/locked.jpg"  style="height: 40px">
         </a>
         </c:if>
             
             <c:if test="${entity.active=='Yes'}">
         <img src="img/unlocked.png"  style="height: 40px">
         </c:if>

         </tr>
     </c:forEach>

            
      
    </tbody>
  </table>
  
  </div>
  </div>
  
<footer  class="footer">
  
   @Copyright SajanCarShowroom 2020

  </footer>
</body>
</html>
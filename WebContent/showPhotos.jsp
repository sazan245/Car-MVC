<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
   <header  style="height: 30px;background-color: #21c9ff;">
   <b style="margin-left: 50px;">Hello! Mr.  ${sessionScope.userData.name}
   </b>
   </header>
    <div  class="container">
         <img src="img/car.jpg"  style="height: 139px">
         <br/>
         <hr/>
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
         <div class="form-group" style="width: 50%">

                   <table class="table table-bordered">
    <thead>
      <tr>
        <th>SID</th>
        <th>Name</th>
        <th>PHOTO</th>

      </tr>
    </thead>
    <tbody>

  <c:forEach  items="${mapa}"  var="entity">
      <tr>
        <td>${entity.key}</td>
        <td>${entity.value}</td>
        <td>
          <img src="image?sid=${entity.key}" style="height: 200px;"/>
        </td>
     </c:forEach>
    </tbody>
  </table>

  </div>

    </div>

</body>
</html>
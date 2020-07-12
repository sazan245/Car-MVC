<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Forgot Password</title>
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
         <img src="img/car.jpg"  style="height: 239px">
          <br/>
         
         <hr/>
         <div class="form-group" style="width: 50%">
         <form action="password.jsp">
  				  <label for="userid">Userid*</label>
   				  <input type="text"  class="form-control" name="userid">
   				  
   				   <br/>
   				     <a href="password.jsp"> 
   				  <button type="submit" class="btn btn-success">Submit</button>
   				  </a>
   				  </form>


		</div>

	</div>
	 <footer  class="footer">
  
   @Copyright SajanCarShowroom 2020

  </footer>
	
</body>
</html>
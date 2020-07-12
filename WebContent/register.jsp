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
   <header  style="height: 30px;background-color: #21c9ff;">
   </header>
    <div  class="container">
    
         <a href="showcar.jsp">
         <img src="img/car.jpg"  style="height: 139px">
    </a>
    <a href="index.jsp"> 
   				  	        <button type="button" class="btn btn-success">Return to login</button>
   				  	 </a>
         <h4>Car Registration Page</h4>
          <span style="font-size: 18px;color: red;">${kuebiko}</span>
         <hr/>
         <div class="form-group" style="width: 50%">
                 <form action="process.jsp">
  				  <label for="userid">Userid*</label>
   				  <input type="text"  class="form-control" name="userid">
   				  
   				    <label for="password">Password*</label>
   				  <input type="password"  class="form-control" name="password">
   				  
   				   <label for="name">Name:</label>
   				  <input type="text"  class="form-control" name="name">
   				  
   				    <label for="number">Number:</label>
   				  <input type="text"  class="form-control" name="number">
   				     
   				       <label for="color">Color:</label>
   				  <input type="text"  class="form-control" name="color">
   				  
   				  <label for="vendor">Vendor:</label>
   				  <input type="text"  class="form-control" name="vendor">
   				  
   				   <label for="model">Model:</label>
   				  <input type="text"  class="form-control" name="model">
   				  
   				  <label for="address">Address:</label>
   				  <input type="text"  class="form-control" name="address">
   				  
   				     
   				     <label for="price">Price:</label>
   				        <select   class="form-control" name="price">
   				              <option>500</option>
   				              <option>1000</option>
   				              <option>1500</option>
   				              <option>2000</option>
   				              <option>2500</option>
								<option>3000</option>   				              
   				              <option>3500</option>
   				        </select>
   				     <label for="role">Role:</label>
   				        <select   class="form-control" name="role">
   				              <option>Admin</option>
   				              <option>Customer</option>
   				        </select>
   				     <br/>
   				     <a href="process.jsp"> 
   				  <button type="submit" class="btn btn-success">Register</button>
   				  </a>
   				  <button type="reset" class="btn btn-danger">Clear</button>
   				  	 <br/>
   				  	 <br/>
   				  	       
   				  </form>
  </div>
     
    </div>
   
   <footer  class="footer">
  
   @Copyright SajanCarShowroom 2020

  </footer>
</body>
</html>
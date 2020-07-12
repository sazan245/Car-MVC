<%@page import="dao.CarDaoImpl"%>
<%@page import="dao.CarDao"%>
<%@page import="dao.entity.CarEntity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
  <%
  String  userid=request.getParameter("userid");
  String  password=request.getParameter("password");
  String  name=request.getParameter("name");
  String  number=request.getParameter("number");
  String  color=request.getParameter("color");
  String  vendor=request.getParameter("vendor");
  String  model=request.getParameter("model");
  String  address=request.getParameter("address");
  String  price=request.getParameter("price");
  String role = request.getParameter("role");
  long pric = Long.parseLong(price);
  CarEntity entity=new CarEntity(0, name, number, color, vendor, model, address, pric, userid, password, role);
  CarDao carDao=new CarDaoImpl();
  carDao.save(entity);
  
  //Setting  message inside request scope
  request.setAttribute("kuebiko","You have successfully registered with us!!");
  %>
 <jsp:forward page="register.jsp"/>

</body>
</html>
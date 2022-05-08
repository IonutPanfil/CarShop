<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="java.util.List"%>
    <%@ page import="interogari.*" %>
    <%@ page import="connectionDB.*" %>
    <%@ page import="reprezentanta.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<title>DETAILS</title>
</head>

	<style>
	
	
	body	{
		background: url(https://www.jcpportraits.com/sites/jcpportraits.com/files/styles/portrait_background/public/background/1808/191-s-124_charcoalbackground.jpg?itok=2pFIVYPV);
		background-repeat: no-repeat;
		background-size: cover;
	}
	
	
	</style>

<body>

  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="clientpageindex.jsp">CarS</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="clientpageindex.jsp">${user} <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="clientpageproducts.jsp">PRODUCTS</a>
      </li>
      </ul>
      
    
      <form class="form-inline my-2 my-lg-0">
      <!--<input class="form-control mr-sm-2" type="text" placeholder="User" aria-label="User">
      <input class="form-control mr-sm-3" type="text" placeholder="Password" aria-label="Password"> -->
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          MY ACCOUNT
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="clientpagesettings.jsp">Details</a>
        </div>
      </li>
    </form> 
  </div>
</nav>

<center>

<br><h1 style="color:#A9A9A9;">Datele contului</h1>
	<h3 style="color:#E0FFFF;">Username: ${user}</h3>
	<h3 style="color:#E0FFFF;">Email: ${email}</h3>
	<h3 style="color:#E0FFFF;">Tipul contului: ${tip}</h3>
	

</center>

<form action="./Logout" method="get">
	<input type = "submit" value = "Logout">
</form>

</body>
</html>
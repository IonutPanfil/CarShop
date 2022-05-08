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
<title>PRODUCTS</title>
</head>

<style>
	body	{
		background: url(https://www.jcpportraits.com/sites/jcpportraits.com/files/styles/portrait_background/public/background/1808/191-s-124_charcoalbackground.jpg?itok=2pFIVYPV);
		background-repeat: no-repeat;
		background-size: cover;
	}

	table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
    }
   	table tr:nth-child(even) {
    background-color: #eee;
    }
    table tr:nth-child(odd) {
    background-color: #fff;
    }
    table th {
    background-color: black;
    color: white;
    }
     #client_logos {
    display: inline-block;
    width:100%;
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
        <a class="nav-link" href="clientpageindex.jsp">${user}</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="clientpageproducts.jsp">PRODUCTS <span class="sr-only">(current)</span></a>
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

<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="Honda1.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="Honda2.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="Honda3.jpg" class="d-block w-100" alt="...">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>

<center><br>
	<h1 style="color:white;">Auto:</h1>
	<% List<Auto> auto = AutoManager.getAllAuto(); %>
	<table style="width: 50%; background-color: aqua;">
	<tr>
            <th style="text-align: left">ID Auto</th>
            <th style="text-align: left">Model</th>
            <th style="text-align: left">Year</th>
            <th style="text-align: left">Capacity motor</th>
        </tr>
	<%for (Auto c : auto) {%>
        <tr>
            <td style="align-content: center"><%=c.getId()%></td> 
            <td style="align-content: center"><%=c.getDenumire()%></td>
            <td style="align-content: center"><%=c.getAnFab()%></td>
            <td style="align-content: center"><%=c.getCapacitateMotor()%></td>
        </tr>
         <% } %>
     </table><br><br>
     
     <h1 style="color:white">Buy auto:</h1>
	<form action="Cumpara" method="post">
		<input name="name" type="text" value="${user}" style="font-size:0.01px; color:gray;"><br>
		<input name="idBuy" type="text" placeholder="Input auto code for buy">
		<input type = "submit" value = "Buy">
		<h2 style="color:white">After press buy button check in History</h2>
	</form>
	
</center>

<br><br>
<form action="./Logout" method="get">
	<input type = "submit" value = "Logout">
</form>

</body>
</html>
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
<title>OUR OFFER</title>

<style>
	body{
	background: url(https://images.pexels.com/photos/531880/pexels-photo-531880.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500);
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


</head>
<body>


  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">CarS</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="index.jsp">HOME </a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="offers.jsp">OUR OFFER <span class="sr-only">(current)</span></a>
      </li>
      </ul>
      
    
      <form class="form-inline my-2 my-lg-0">
      <!--<input class="form-control mr-sm-2" type="text" placeholder="User" aria-label="User">
      <input class="form-control mr-sm-3" type="text" placeholder="Password" aria-label="Password"> -->
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          YOUR ACCOUNT
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="login.jsp">Login</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="signup.jsp">Signup</a>
        </div>
      </li>
    </form> 
  </div>
</nav>

<br><br><br>

<center>
	<% List<Auto> auto = AutoManager.getAllAuto(); %>
	<table style="width: 70%; background-color: aqua;">
	<tr>
            <th style="text-align: left">ID</th>
            <th style="text-align: left">Model</th>
            <th style="text-align: left">Year</th>
            <th style="text-align: left">Motor Capacity</th>
        </tr>
	<%for (Auto a : auto) {%>
        <tr>
            <td style="align-content: center"><%=a.getId()%></td> 
            <td style="align-content: center"><%=a.getDenumire()%></td>
            <td style="align-content: center"><%=a.getAnFab()%></td>
            <td style="align-content: center"><%=a.getCapacitateMotor()%>$</td>
        </tr>
         <% } %>
     </table>
 </center>
 
 <br><br><br>

<center>
<div id="client_logos">
<img style="display: inline; margin: 0 5px; " title="heartica_logo" src="https://www.honda.ro/images/cars.jpg" alt="" width="400" height="290" />
<img style="display: inline; margin: 0 5px;" title="mouseflow_logo" src="https://static.automarket.ro/v5/img/auto_resized/db/model_lev1/000/793/494671-300x192-b-2417b4da.jpg" alt="" width="400" height="290" />
<img style="display: inline; margin: 0 5px;" title="piiholo_logo" src="https://www.honda.co.uk/content/dam/central/cars/coming%20soon/civic-type-r/Honda-Civic-Type-R-Pure-Sport-mobile.jpg/jcr:content/renditions/m.jpg" alt="" width="400" height="290" />
</div>
</center>

</body>
</html>
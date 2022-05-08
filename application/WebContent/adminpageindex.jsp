<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="java.util.List"%>
    <%@ page import="interogari.*" %>
    <%@ page import="connectionDB.*" %>
    <%@ page import="reprezentanta.*" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="pt-br">
   <head>
   
   <style>
   html, body {
      margin: 0;
      padding: 0;
      width: 100%;
}

body {
      font-family: "Helvetica Neue",sans-serif;
      font-weight: lighter;
      background: url(https://htmlcolorcodes.com/assets/images/html-color-codes-color-tutorials-hero.jpg);
}

header {
      width: 100%;
      height: 100vh;
      background: url(https://images.unsplash.com/photo-1550355291-bbee04a92027?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxleHBsb3JlLWZlZWR8M3x8fGVufDB8fHw%3D&w=1000&q=80) no-repeat 50% 50%;
      background-size: cover;
}

.content {
      width: 94%;
      margin: 4em auto;
      font-size: 20px;
      line-height: 30px;
      text-align: justify;
}

.logo {
      line-height: 60px;
      position: fixed;
      float: left;
      margin: 16px 46px;
      color: #fff;
      font-weight: bold;
      font-size: 20px;
      letter-spacing: 2px;
}

nav {
      position: fixed;
      width: 100%;
      line-height: 60px;
}

nav ul {
      line-height: 60px;
      list-style: none;
      background: rgba(0, 0, 0, 0);
      overflow: hidden;
      color: #fff;
      padding: 0;
      text-align: right;
      margin: 0;
      padding-right: 40px;
      transition: 1s;
}

nav.black ul {
      background: #000;
}

nav ul li {
      display: inline-block;
      padding: 16px 40px;;
}

nav ul li a {
      text-decoration: none;
      color: #fff;
      font-size: 16px;
}

.menu-icon {
      line-height: 60px;
      width: 100%;
      background: #000;
      text-align: right;
      box-sizing: border-box;
      padding: 15px 24px;
      cursor: pointer;
      color: #fff;
      display: none;
}

@media(max-width: 786px) {

      .logo {
            position: fixed;
            top: 0;
            margin-top: 16px;
      }

      nav ul {
            max-height: 0px;
            background: #000;
      }

      nav.black ul {
            background: #000;
      }

      .showing {
            max-height: 34em;
      }

      nav ul li {
            box-sizing: border-box;
            width: 100%;
            padding: 24px;
            text-align: center;
      }

      .menu-icon {
            display: block;
      }
      
      .content {
      	width: 100%;
      	height: 100vh;
      	background: url(https://tipsmake.com/data/images/100-most-beautiful-background-picture-7-pECPMYPW0.jpg);
      	background-size: cover;
      }

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
   
   
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta http-equiv="X-UA-Compatible" content="ie=edge">
      <title>Home administrator</title>
      <link rel="stylesheet" href="style.css">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
      <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
   </head>
   <body>
      <div class="wrapper">
         <header>
            <nav>
               <div class="menu-icon">
                  <i class="fa fa-bars fa-2x"></i>
               </div>
               <div class="logo">
                  CarS
               </div>
               <div class="menu">
                  <ul>
                     <li><a href="adminpageindex.jsp">${user} </a></li>
                     <li><a href="adminpagelistaclienti.jsp">Lista clienti</a></li>
                     <li><a href="adminpagelistatranz.jsp">Lista tranzactii</a></li>
                     <li><a href="adminpagelistaconsultanti.jsp">Lista consultanti</a></li>
                     
                  </ul>
               </div>
            </nav>
         </header>
         
         <center>
         	<p style="color: white;"> Hello <h1 style="color: gray;">${user}</h1></p><p style="color: white; font-size: 30px;">Let's manage our site!!!</p>
         	
         	<br><br><br>
         	<h1 style="color: white;">Auto models:</h1>
         	
         	<% List<Auto> auto = AutoManager.getAllAuto(); %>
	<table style="width: 70%; background-color: aqua;">
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
     </table>
         	<br><br>
         	<h1 style="color: white;">Insert auto:</h1>
         <form action="InsertAuto" method="post">
         	<input name="modelAdd" type="text" placeholder="Model"><br>
         	<input name="yearAdd" type="text" placeholder="Year"><br>
         	<input name="capacityAdd" type="text" placeholder="Capacity"><br>
         	<input class="submit-addAuto" type="submit" value="Add"></input>
         </form>
         	<br><br>
         	<h1 style="color: white;">Delete auto:</h1>
         	<form action="DeleteAuto" method="post">
         		<input name="idDel" type="text" placeholder="ID Model">
         		<input class="submit-addAuto" type="submit" value="Delete Auto"></input>
         	</form>
         	
         	
         </center>
         
         
         
         <div class="content">
            <p>
               <form action="./Logout" method="get">
							<input type = "submit" value = "Logout">
					 </form>
            </p>
            
         </div>
      </div>
   </body>
</html>
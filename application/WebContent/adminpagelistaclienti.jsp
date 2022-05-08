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
   	body{
	background: url(https://loveisinmytummy.com/wp-content/uploads/2017/07/New-Blue-Background-Main-2.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	}
   	
   html, body {
      margin: 0;
      padding: 0;
      width: 100%;
}

body {
      font-family: "Helvetica Neue",sans-serif;
      font-weight: lighter;
}

header {
      width: 100%;
      height: 100vh;
      background: url(https://i.pinimg.com/originals/68/29/29/68292919de76b5f4866c52c37df1abc6.jpg) no-repeat 50% 50%;
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
      <title>Lista clienti - administrator</title>
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
         <br><br><br>
         
         <center>
         
         <% List<Conturi> conturi = Interogari.getAllConturiByTip("client"); %>
	<table style="width: 70%; background-color: aqua;">
	<tr>
            <th style="text-align: left">ID</th>
            <th style="text-align: left">Username</th>
            <th style="text-align: left">Email</th>
            <th style="text-align: left">Type</th>
        </tr>
	<%for (Conturi c : conturi) {%>
        <tr>
            <td style="align-content: center"><%=c.getIdCont()%></td> 
            <td style="align-content: center"><%=c.getUsername()%></td>
            <td style="align-content: center"><%=c.getEmail()%></td>
            <td style="align-content: center"><%=c.getTip()%></td>
        </tr>
         <% } %>
     </table>
         
         </center>
         
         <center><br><br>
         <h1 style="color:white;"> Schimba client in consultant:</h1>
         <form action="SwitchToConsultant" method="post">
         	<input name="idcont" type="text" placeholder="ID cont">
         	<input class="submit-consultant" type="submit" value="Schimba"></input>
         </form>
                 
         
         </center>
         
           <center><br>
         	<h1 style="color: #DCDCDC;"> Sterge client</h1>
         <form action="DeleteAccount" method="post">
         	<input name="idcont-stergere" type="text" placeholder="ID cont">
         	<input class="submit-stergere" type="submit" value="Sterge"></input>
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
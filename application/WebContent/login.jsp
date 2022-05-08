<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="java.util.List"%>
    <%@page import="interogari.*"%>
    <%@page import="reprezentanta.*"%>
    <%@page import="connectionDB.*"%>
    <%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>


<style>
	body{background: #eee url(https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTLUYKlBiq01sOajlBkUsTKhkwjTw55dfr77w&usqp=CAU);}
	
	html,body{
    position: relative;
    height: 100%;
}

.login-container{
    position: relative;
    width: 300px;
    margin: 80px auto;
    padding: 20px 40px 40px;
    text-align: center;
    background: #fff;
    border: 1px solid #ccc;
}

#output{
    position: absolute;
    width: 300px;
    top: -75px;
    left: 0;
    color: #fff;
}

#output.alert-success{
    background: rgb(25, 204, 25);
}

#output.alert-danger{
    background: rgb(228, 105, 105);
}


.login-container::before,.login-container::after{
    content: "";
    position: absolute;
    width: 100%;height: 100%;
    top: 3.5px;left: 0;
    background: #fff;
    z-index: -1;
    -webkit-transform: rotateZ(4deg);
    -moz-transform: rotateZ(4deg);
    -ms-transform: rotateZ(4deg);
    border: 1px solid #ccc;

}

.login-container::after{
    top: 5px;
    z-index: -2;
    -webkit-transform: rotateZ(-2deg);
     -moz-transform: rotateZ(-2deg);
      -ms-transform: rotateZ(-2deg);

}

.avatar{
	background: url(data:image/jpeg;base64,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);
    width: 100px;height: 100px;
    margin: 10px auto 30px;
    border-radius: 100%;
    border: 2px solid #aaa;
    background-size: cover;
}

.form-box input{
    width: 100%;
    padding: 10px;
    text-align: center;
    height:40px;
    border: 1px solid #ccc;;
    background: #fafafa;
    transition:0.2s ease-in-out;

}

.form-box input:focus{
    outline: 0;
    background: #eee;
}

.form-box input[type="text"]{
    border-radius: 5px 5px 0 0;
    text-transform: lowercase;
}

.form-box input[type="password"]{
    border-radius: 0 0 5px 5px;
    border-top: 0;
}

.form-box input[type="submit"]{
    border-radius: 0 0 5px 5px;
    border-top: 0;
    background: blue;
}

.animated {
  -webkit-animation-duration: 1s;
  animation-duration: 1s;
  -webkit-animation-fill-mode: both;
  animation-fill-mode: both;
}

@-webkit-keyframes fadeInUp {
  0% {
    opacity: 0;
    -webkit-transform: translateY(20px);
    transform: translateY(20px);
  }

  100% {
    opacity: 1;
    -webkit-transform: translateY(0);
    transform: translateY(0);
  }
}

@keyframes fadeInUp {
  0% {
    opacity: 0;
    -webkit-transform: translateY(20px);
    -ms-transform: translateY(20px);
    transform: translateY(20px);
  }

  100% {
    opacity: 1;
    -webkit-transform: translateY(0);
    -ms-transform: translateY(0);
    transform: translateY(0);
  }
}

.fadeInUp {
  -webkit-animation-name: fadeInUp;
  animation-name: fadeInUp;
}
	
</style>


<title>LOGIN</title>
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
      <li class="nav-item">
        <a class="nav-link" href="offers.jsp">OUR OFFER</a>
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

<div class="container">
	<div class="login-container">
            <div id="output"></div>
            <div class="avatar"></div>
            <div class="form-box">
                <form action="Login" method="post">
                    <input name="user" type="text" placeholder="">
                    <input name ="password" type="password" placeholder="">
                    <input class="btn btn-info btn-block login" type="submit" value="Login"></input>
                    <a class="signup-login" href="signup.jsp">Signup</a>
                </form>
            </div>
        </div>
        
</div>

</body>
</html>
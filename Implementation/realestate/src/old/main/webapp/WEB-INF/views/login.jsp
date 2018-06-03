<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Realestate | Login</title>
        <link rel="stylesheet" href="./../../assets/css/style.css">
        <link rel="shortcut icon" href="./../../assets/images/logo.png">
    </head>
    <body>
     
     	<header>
     		
     		<nav>
       			<ul>
       				<li><a href="/">home</a></li>
       				<li><a href="#">about</a></li>
       				<li><a href="#">contact</a></li>			
       				<li><a href="/login">login</a></li>
       				<li><a href="/subscribe">subscribe</a></li>
       				<span class="pipe"></span>
                    <li><a href="#"> <span class="fa fa-phone"></span>Call Us</a><span class="underline"></span></li>
       			</ul>
       		</nav>
     	
     		<div class="error ${ login_err }"><p>${ login_msg }</p></div>
			<form  method="post" action="/login">
				<label for="email">Email</label>
				<input id="email" type="email" name="email" placeholder="Your email please." required/>
				<br><br>
				<label for="password">Password</label>
				<input id="password" type="password"  name="password" placeholder="Your password please." required/>
				<br><br>
				<input type="submit" class="button" value="Login" >
			</from>
     	</header>
        
    	<script src="./../../assets/js/script.js"></script>
    </body>
</html>
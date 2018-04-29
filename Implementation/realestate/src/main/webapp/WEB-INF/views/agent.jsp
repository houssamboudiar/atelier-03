<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Realestate</title>
        <link rel="stylesheet" href="./../../assets/css/bootstrap-grid.css">
        <link rel="stylesheet" href="./../../assets/css/style.css">
        <link rel="shortcut icon" href="./../../assets/images/logo.png">
    </head>
    <body>
       
       
		<header>
       		<nav>
       			<ul>
       				<li><a href="/">home</a></li>			
       				<li><a href="/logout">logout</a></li>
       				<li><a href="/show_appointements">appointements</a></li>
       				<span class="pipe"></span>
                    <li><a href="#"> <span class="fa fa-phone"></span>Call Us</a><span class="underline"></span></li>
       			</ul>
       		</nav>
       </header>
       <section>       		
       		<input class="search-bar" type="text"><button class="search-btn">search</button>
       		
       		<div class="lodgs"></div>
       </section>
       <footer></footer>    
        
        <script src="./../../assets/js/search_script.js"></script>

    </body>
</html>
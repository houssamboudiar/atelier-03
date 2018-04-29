<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8">
        <title>Realestate | Subscribe</title>
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
       		<div>
       			The subscribe page
       		</div>
       </header>
       <section>
			<div class="error ${ sub_err }"><p>${ sub_msg }</p></div>
               <form class="sub"  method="post" action="/subscribe">
                       	
                <label for="username">Username</label>
                <input id="username" type="text" name="username" placeholder="Your username" maxlength="50" minlength="5" required/>
            
                <label for="email">Email</label>
                <input id="email" type="email" name="email" placeholder="Your email" maxlength="50" minlength="6" required/>
            
                <label for="password">Password</label>
                <input id="password" type="password"  name="password" placeholder="Your password" maxlength="50" minlength="6" required/>
           
                <label for="repassword">Confirmation</label>
                <input  id="repassword" type="password"  name="repassword" placeholder="Confirme your password"  maxlength="50" minlength="6" required/>
           
                <label for="name">Name</label>
                <input id ="name" type="text" name="name" placeholder="name" maxlength="50" minlength="4" required/>
            
                <label for="f_name">Family name</label>
                <input id="f_name" type="text" name="f_name" placeholder="Your family name" maxlength="50" minlength="4" required/>
           
                <label for="birthdate">Birthdate</label>
                <input id="birthdate" type="date" name="birthdate" placeholder="Your birthdate" max="2002-12-31" min="1921-08-07" required/>
            
                <label for="phone">Phone number</label>
                <input id="phone" type="phone" name="phone" placeholder="Your phone number" maxlength="20" minlength="7" required/>
            
                <label for="address">Address</label>
                <input id="address" type="text" name="address" placeholder="Your address" maxlength="50" minlength="3" required/>
            
                <label for="gender">Gender</label>
                <select id="gender" name="gender" id="gender">
					<option value="male">Male</option>
					<option value="female">Female</option>
				</select>
                              
                <label for="type">Type</label>
                <select id="type" name="type" id="type">
					<option value="client">Client</option>
					<option value="operator">Operator</option>
					<option value="agent">Agent</option>
				</select>
                             
                   <input type="submit" class="button" value="Register" >
                               
               </from>
           </section>
           
           <footer></footer>
        
        <script src="./../../assets/js/subscribe_script.js"></script>
    </body>
</html>

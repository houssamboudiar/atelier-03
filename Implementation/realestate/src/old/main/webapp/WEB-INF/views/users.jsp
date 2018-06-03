<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib	uri="http://java.sun.com/jsp/jstl/core"	prefix="c"	%>
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
       				<li><a href="/users">users</a></li>			
       				<li><a href="/logout">logout</a></li>
       			</ul>
       		</nav>
       </header>
                </div>
                
                <h2>List of users: </h2>	
                <br><br>
                <div>
                		
                		<table>
						  	<tr>
						    	<th class="id">id</th>
						    	<th class="email">email</th>
						    	<th class="type">type</th>
						    	<th class="name">name</th>
						    	<th class="f_name">family name</th>
						    	<th class="birth">birthdate</th>
						    	<th class="phone">phone</th>
						    	<th class="gender">gender</th>
						    	<th class="blocked">blocked</th>
						  	</tr>
		                	<c:forEach	var="user"	items="${users}">		 
							  	<tr>
							    	<td class="id">${user.getId()}</td>
							    	<td class="email">${user.getEmail()}</td>
							    	<td class="type">${user.getType()}</td>
							    	<td class="name">${user.getName()}</td>
							    	<td class="f_name">${user.getF_name()}</td>
							    	<td class="birth">${user.getBirthdate()}</td>
							    	<td class="phone">${user.getPhone()}</td>
							    	<td class="gender">${user.getGender()}</td>
							    	<td class="blocked">
							    	<input type="checkbox" name="blocked" <c:if test="${user.getBlocked() == 1}">checked</c:if> >
							    	</td>
							  	</tr>
							 </c:forEach>
						</table> 
                </div>
                                
            </header>
        
        <script src="./../../assets/js/users_script.js"></script>
    </body>
</html>
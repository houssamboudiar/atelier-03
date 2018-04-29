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
                
                <h2>List of Lodgements: </h2>	
                <br><br>
                <div>
                		
                		<table>
						  	<tr>
						    	<th class="id">id</th>
						    	<th class="address">address</th>
						    	<th class="state">state</th>
						    	<th class="surface">surface</th>
						    	<th class="type">type</th>
						    	<th class="Locale">Locale</th>
						    	<th class="price">price</th>
						    	<th class="reserved">reserved</th>
						  	</tr>
		                	<c:forEach	var="lodgement"	items="${lodgements}">		 
							  	<tr>
							    	<td class="id">${lodgement.getId()}</td>
							    	<td class="address">${lodgement.getAddress()}</td>
							    	<td class="state">${lodgement.getState()}</td>
							    	<td class="surface">${lodgement.getSurface()}</td>
							    	<td class="type">${lodgement.getType()}</td>
							    	<td class="Locale">${lodgement.getLocale()}</td>
							    	<td class="price">${lodgement.getPrice()}</td>
							    	<td class="reserved">
							    	<input type="checkbox" name="reserved" <c:if test="${lodgement.getReserved() == 0}">checked</c:if> >
							    	</td>
							  	</tr>
							 </c:forEach>
						</table> 
                </div>
                                
            </header>
        
        <script src="./../../assets/js/lodgements_script.js"></script>
    </body>
</html>
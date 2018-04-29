<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Realestate | Appointement</title>
        <link rel="stylesheet" href="./../../assets/css/style.css">
        <link rel="shortcut icon" href="./../../assets/images/logo.png">
    </head>
    <body>
       
       <header>
       		<nav>
       			<ul>
       				<li><a href="/">home</a></li>			
       				<li><a href="/logout">logout</a></li>
       				<span class="pipe"></span>
                    <li><a href="#"> <span class="fa fa-phone"></span>Call Us</a><span class="underline"></span></li>
       			</ul>
       		</nav>
       </header>
       <section>     
       
     ${ success }
       
       		<%@ page import="java.util.List, java.util.ArrayList, com.realestate.models.User" %>
	       		
				<form method="post" action="/reserve_op">
	       			<ul>
	       				<li>Appointements:</li>
	       							
						
							<%
							List<String> list_appo = (ArrayList<String>)request.getAttribute("appointements");
							
								for(int j=0; j<list_appo.size(); j++){
							
									out.println("<li>client: <select name=\"clientId\" id=\"client\">");
								      
									List<User> list_clients = (ArrayList<User>)request.getAttribute("clients"+(j+1));
									for(int i = 0; i < list_clients.size();i++){
										out.println("<option value='" + list_clients.get(i).getId() + "'>" + list_clients.get(i).getEmail() + "</option>" );
									}
									out.println("</select> | ");
									
									out.println("agent: <select name=\"agentId\" id=\"agent\">");
						      
									List<User> list_agents = (ArrayList<User>)request.getAttribute("agents"+(j+1));
									for(int i = 0; i < list_agents.size();i++){
										out.println("<option value='" + list_agents.get(i).getId() + "'>" + list_agents.get(i).getUsername() + "</option>" );
									}
									out.println("</select>");
									
									out.println(" Appointement: "+list_appo.get(j)+"<input type=\"radio\" name=\"date\" value='"+ list_appo.get(j) +"'>");
									
									out.println("</li>");
								}
								%>
								
						<li><input type="submit" class="save" value="save" /></li>
			
	       			</ul>
       			</form>
       		</div>  		
       		
       </section>
       <footer></footer>
       
    </body>
</html>
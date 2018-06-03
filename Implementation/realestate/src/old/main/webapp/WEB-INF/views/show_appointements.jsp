<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@	taglib	uri="http://java.sun.com/jsp/jstl/core"	prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Realestate</title>
        <link rel="stylesheet" href="./../../assets/css/style.css">
        <link rel="shortcut icon" href="./../../assets/images/logo.png">
    </head>
    <body>
       
       <header>
       		<nav>
       			<ul>
       				<li><a href="/">home</a></li>		
       				<li><a href="/show_appointements">appointements</a></li>	
       				<li><a href="/logout">logout</a></li>
       				<span class="pipe"></span>
                    <li><a href="#"> <span class="fa fa-phone"></span>Call Us</a><span class="underline"></span></li>
       			</ul>
       		</nav>
       		
       		<div class="profile">
       		
       		</div>	
       </header>
       <section>     
	       <ul>
	       	
	       		<%@ page import="java.util.List, java.util.ArrayList, com.realestate.models.Appointement" %>
	       		<%
					List<Appointement> appoitements = (ArrayList<Appointement>)request.getAttribute("appointements");
					for(int i=0; i<appoitements.size(); i++){
						
						out.print("<li> Date: "+ appoitements.get(i).getDate() +" | agent confirmed:  <input class='confirmed' value='"+ appoitements.get(i).getId()+"' type='checkbox'");
						
						if(request.getAttribute("type").equals("client"))
							out.print(" disabled  "); 
						
						if(appoitements.get(i).getAgent_confirmed()==1)
							out.print(" checked ");
						
						out.print("> | client confirmed:  <input class='confirmed' value='"+ appoitements.get(i).getId()+"' type='checkbox' ");
						
						if(request.getAttribute("type").equals("agent"))
							out.println(" disabled "); 
						
						if(appoitements.get(i).getClient_confirmed()==1)
							out.print(" checked ");
						
						if(request.getAttribute("type").equals("client"))
							out.print("> | <a href='/change_appointement?id="+appoitements.get(i).getId() +"&date="+appoitements.get(i).getDate() +"'>change appointement</a>");
						else
							out.print(">");
						
						if(request.getAttribute("type").equals("agent"))
							out.print("<input type='text' value='"+appoitements.get(i).getReview()+"' placeholder='Enter the client review.' ><button class='save_review' id='"+appoitements.get(i).getId()+"'>save</button>");
						
						
						
						if(request.getAttribute("type").equals("client") && appoitements.get(i).getReview() != null){
							out.print("<span> | Review: ");
							out.print("<span class='review'>"+appoitements.get(i).getReview()+"</span></span>");
						}
							
						out.println("</li> ");
						
					       
					}
					
					%>
		       
	       </ul>
       </section>
       <footer></footer>
        
        <script src="./../../assets/js/appointements_script.js"></script>

    </body>
</html>
var xhr =new XMLHttpRequest();
var xhr1 =new XMLHttpRequest();
var search_bar = document.querySelector(".search-bar")
var search_btn = document.querySelector(".search-btn")
var lodgs = document.querySelector(".lodgs")
var result

search_btn.addEventListener("click", function(){
	
	review = ""
	result = ""  //192.168.43.239
	xhr.open("POST","http://localhost:8080/search",true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send("state=" + search_bar.value);
	
	xhr.onreadystatechange= function()
	  {
	   if (xhr.readyState==4 && xhr.status==200)
	    {		   
		   _lodgs = JSON.parse(xhr.responseText)
		   result = ""
		   for(var i=0; i<_lodgs.length; i++){
			   result += "<div class='lodg'>" +
	   			"<p>price: "+ _lodgs[i].price +"</p>" +
	   			"<p>state: "+ _lodgs[i].state +"</p>" +
	   			"<p>locale: "+ _lodgs[i].locale +"</p>" +
	   			"<p>type: "+ _lodgs[i].type +"</p>" +
	   			"</div><a href='/reserve?id="+_lodgs[i].id+"' class='reserve' >reserve</a><br><div><p style='text-decoration: underline'>Reviews</p><div>"
	   			//192.168.43.239
	   			xhr1.open("POST","http://localhost:8080/get_reviews",false);
				xhr1.setRequestHeader("Content-type","application/x-www-form-urlencoded");
				xhr1.send("id=" + _lodgs[i].id);
				xhr1.addEventListener("readystatechange", function(){
				   if (xhr1.readyState==4 && xhr1.status==200){		   
					   _reviews = JSON.parse(xhr1.responseText)
					   review = ""
					   for(var j=0; j<_reviews.length; j++){
						   if( _reviews[j] != "null")
							   review += "<p>"+_reviews[j]+"</p>"
					   }
					   
					   
				    }
				}, false)
				result += review + "<hr></div></div>" 		
		   }
		   	   
	    }
	   lodgs.innerHTML = result
	  } 

}, false)
var xhr =new XMLHttpRequest();
var search_bar = document.querySelector(".search-bar")
var search_btn = document.querySelector(".search-btn")
var lodgs = document.querySelector(".lodgs")
var result

search_btn.addEventListener("click", function(){
	
	result = ""
	xhr.open("POST","http://192.168.43.239:8080/search",true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send("state=" + search_bar.value);
	
	xhr.onreadystatechange= function()
	  {
	   if (xhr.readyState==4 && xhr.status==200)
	    {		   
		   _lodgs = JSON.parse(xhr.responseText)

		   for(var i=0; i<_lodgs.length; i++){
			   result += "<div class='lodg'>" +
	   			"<p>price: "+ _lodgs[i].price +"</p>" +
	   			"<p>state: "+ _lodgs[i].state +"</p>" +
	   			"<p>locale: "+ _lodgs[i].locale +"</p>" +
	   			"</div><a href='/reserve_op?id="+_lodgs[i].id+"' class='reserve'>reserve</a>" 	
		   }
		   	   
	    }
	   lodgs.innerHTML = result

	  } 

})
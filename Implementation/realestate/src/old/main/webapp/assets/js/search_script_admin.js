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
	   			"</div><a href='/sale_lodgement?id="+_lodgs[i].id+"' class='reserve' >remove lodgement</a><br>"
		   }
		   	   
	    }
	   lodgs.innerHTML = result
	  } 

}, false)
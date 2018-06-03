var links = document.querySelectorAll(".check>p")
var x = 0

for(var i = 0; i < links.length; i++){
	
	links[i].addEventListener("click", function(){
		if(this.nextElementSibling.style.display == "none")
			this.nextElementSibling.style.display="block"
		else
			this.nextElementSibling.style.display = "none"
		
		
	}, false)
	
}
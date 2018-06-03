var appointements = document.querySelectorAll(".confirmed")
var xhr =new XMLHttpRequest();


for(var i=0; i<appointements.length; i++){
	appointements[i].addEventListener("change", function(){
		//192.168.43.239
		xhr.open("POST","http://localhost:8080/show_appointements",true)
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded")
		
		
		
		if(this.checked){
			xhr.send("confirmed="+1+"&id="+this.value)
		}
			
		else
			xhr.send("confirmed="+0+"&id="+this.value)
			
	}, false)
}

var save_review = document.querySelectorAll(".save_review")

for(var i=0; i<save_review.length; i++){
	save_review[i].addEventListener("click", function(){
		//192.168.43.239
		xhr.open("POST","http://localhost:8080/save_review",true)
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded")
		
		xhr.send("review="+this.previousElementSibling.value+"&id="+this.id)
		console.log("review="+this.previousElementSibling.value+"&id="+this.id)
	}, false)
}



var xhr =new XMLHttpRequest();
var id, accepted = 0, blocked = 0 

var users_list = document.querySelectorAll("tr")

for(var i=1; i< users_list.length; i++){
	
	
	users_list[i].lastElementChild.firstElementChild.addEventListener("click", function(){
		
		id = this.parentElement.parentElement.firstElementChild.textContent
				
		if(this.parentElement.firstElementChild.checked){
			blocked = 1
		}else{
			blocked = 0
		}
		
		xhr.open("POST","http://localhost:8080/users",true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send("id="+id+"&blocked="+blocked);
			
	}, false)
}

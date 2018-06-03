

var xhr =new XMLHttpRequest();
var id, reserved = 0 

var lodgements_list = document.querySelectorAll("tr")

for(var i=1; i< lodgements_list.length; i++){
	
	
	lodgements_list[i].lastElementChild.firstElementChild.addEventListener("click", function(){
		
		id = this.parentElement.parentElement.firstElementChild.textContent
				
		if(this.parentElement.firstElementChild.checked){
			reserved = 0
		}else{
			reserved = 1
		}
		
		xhr.open("POST","http://localhost:8080/lodgement",true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send("id="+id+"&reserved="+reserved);
			
	}, false)
}

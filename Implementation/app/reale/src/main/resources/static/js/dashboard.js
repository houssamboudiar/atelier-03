var body = document.querySelector("body")
var gear = document.querySelector(".gear")
var profile_dropdown_menu = document.querySelector(".profile_dropdown_menu")

gear.addEventListener("click", function(){
	
	if(profile_dropdown_menu.classList.contains("show")){
		profile_dropdown_menu.classList.remove("show")
		profile_dropdown_menu.classList.add("hide")
	}else{
		profile_dropdown_menu.classList.remove("hide")
		profile_dropdown_menu.classList.add("show")
	}
	
}, false)


var vertical_nav = document.querySelector(".vertical_nav")
var toggle_menu = document.querySelector(".toggle_menu")
var main_section = document.querySelector(".main_section")

toggle_menu.addEventListener("click", function(){
	
	if(toggle_menu.classList.contains("move_right")){
		vertical_nav.classList.remove("show_big")
		vertical_nav.classList.add("hide_big")

		toggle_menu.classList.add("move_left")
		toggle_menu.classList.remove("move_right")
		
		main_section.classList.remove("small_section")
		main_section.classList.add("big_section")

	}else{
		vertical_nav.classList.remove("hide_big")
		vertical_nav.classList.add("show_big")
		
		toggle_menu.classList.add("move_right")
		toggle_menu.classList.remove("move_left")
		
		main_section.classList.add("small_section")
		main_section.classList.remove("big_section")

	}
	
}, false)


var xhr =new XMLHttpRequest()

var nbr_all_visites = document.querySelector(".nbr_all_visites")
var nbr_client_visites = document.querySelector(".nbr_client_visites")
var nbr_agent_visites = document.querySelector(".nbr_agent_visites")
var nbr_operator_visites = document.querySelector(".nbr_operator_visites")

//setInterval(function(){
//	
//	xhr.open("POST","http://localhost:8080/statistcs",true);
//	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
//	xhr.send()
//		
//	xhr.onreadystatechange=function(){
//		
//		if (xhr.readyState==4 && xhr.status==200){	
//			_search_result = JSON.parse(xhr.responseText)
//			nbr_all_visites.innerHTML = _search_result 
//		}
//	}
//	
//}, 500)



	


































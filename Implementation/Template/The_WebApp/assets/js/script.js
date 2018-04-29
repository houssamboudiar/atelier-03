
var header = document.querySelector("header")
var i = 0

setInterval(function(){
    i = i + 1 
    header.style.backgroundImage = "url('./assets/images/bg"+i+".jpg')"
    
    if (i == 3)
        i = -1

}, 3500)
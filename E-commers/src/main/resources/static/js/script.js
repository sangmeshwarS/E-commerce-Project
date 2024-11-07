/*document.getElementById("submit-button").onclick = function() {
document.getElementById("form1").submit();
}*/

document.getElementById('submitButton').onclick = function() {
	alert("Hello")
    const form = document.getElementById('myForm');
    if (form.checkValidity()) {
        form.submit();
    } else {
        form.reportValidity(); // Show validation errors
    }
};

	
/*decreasebtn1 = document.getElementById("decrease");
increasebtn = document.getElementById("increase");
span = document.getElementById("span");
count = span.innerHTML;

decreasebtn1.addEventListener("click", function(){
    count--;
    span.innerHTML = count;  
})

increasebtn.addEventListener("click", function(){
    count = parseInt(count);
    count++;
    span.innerHTML = count;
})*/
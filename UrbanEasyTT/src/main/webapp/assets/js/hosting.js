let btns = document.querySelectorAll('.delete-icon');

btns.forEach(function(btn){
btn.addEventListener('click', function(){
	let nextDiv = btn.nextElementSibling;
	nextDiv.classList.remove('hiddenn');
});
});
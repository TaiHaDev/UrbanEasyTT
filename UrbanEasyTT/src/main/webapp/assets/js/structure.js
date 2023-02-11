// constraint to chooose
const buttons = document.querySelectorAll(".type-rent-house-button");
let selectedButton;
let selectedCategory = {};

buttons.forEach(button => {
	button.addEventListener('click', (e) => {
		if (selectedButton) {
			selectedButton.classList.remove('selected');
		}
		button.classList.add('selected');
		selectedButton = button;

		console.log(button.dataset.value);
		selectedCategory.selectedCategory = button.dataset.value;
		console.log(selectedCategory);
		
		document.querySelector("#verify-structure").disabled = false;
	})
});



let struc = document.getElementById("verify-structure");
struc.addEventListener('click', function() {

	fetch("http://localhost:8080/UrbanEasyTT/structure", {
		method: 'POST',
		headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(selectedCategory)
	});
	
});

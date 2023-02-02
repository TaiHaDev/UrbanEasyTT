// constraint to chooose
let selectedCategories = [];
const typeRentHouseButtons = document.querySelectorAll('.type-rent-house-button');
const submitSelections = document.getElementById('submit-selections');
typeRentHouseButtons.forEach(button => {
	button.addEventListener('click', e => {
		const index = selectedCategories.indexOf(e.target.dataset.value);
		if(index > -1) {
			selectedCategories.splice(index, 1);
			e.target.classList.remove('selected');
		} else {
			selectedCategories.push(e.target.dataset.value);
			e.target.classList.add('selected');
		}
		console.log(selectedCategories);
		submitSelections.disabled = selectedCategories.length > 0 ? false : true;
	});

});

let struc = document.getElementById("verify-structure");
console.log(struc);
struc.addEventListener('click', function() {
	console.log("hhuhu")
	fetch("http://localhost:8080/UrbanEasy_TT/structure", {
	method: 'POST',
	headers: {
		'Accept': 'application/json',
		'Content-Type': 'application/json'
	},
	body: JSON.stringify(selectedCategories)
});
});

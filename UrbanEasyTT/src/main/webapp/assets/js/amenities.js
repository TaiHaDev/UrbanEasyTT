
let selectedAmenities = [];
const amenitiesButtons = document.querySelectorAll('.amenities-button');
const submit2Selections = document.getElementById('submit-selections2');
amenitiesButtons.forEach(button => {
	button.addEventListener('click', e => {
		const index = selectedAmenities.indexOf(e.target.dataset.value);
		if(index > -1) {
			selectedAmenities.splice(index, 1);
			button.classList.remove('selected');
		} else {
			selectedAmenities.push(button.dataset.value);
			button.classList.add('selected');
		}
		console.log(selectedAmenities);
		submit2Selections.disabled = selectedAmenities.length > 0 ? false : true;
	});
});




let amen = document.getElementById("verify-amenities");

amen.addEventListener('click', function() {
	console.log("nho doi url project thanh _TT");
	fetch("http://localhost:8080/UrbanEasyTT/amenities", {
	method: 'POST',
	headers: {
		'Accept': 'application/json',
		'Content-Type': 'application/json'
	},
	body: JSON.stringify(selectedAmenities)
});
});
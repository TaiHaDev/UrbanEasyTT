var geocoder;
		var map;
		function initAutocomplete() {
			// Create the autocomplete object
			autocomplete = new google.maps.places.Autocomplete(
				/** @type {!HTMLInputElement} */(document.getElementById('address')),
				{types: ['geocode']});
		}
    
    function codeAddress() {
			geocoder = new google.maps.Geocoder();
			var address = document.getElementById('address').value;
			geocoder.geocode( { 'address': address}, function(results, status) {
				if (status == 'OK') {
					var latitude = results[0].geometry.location.lat();
					var longitude = results[0].geometry.location.lng();


					var fullName = results[0].formatted_address;

					var city = results[0].address_components.find((add) => add.types[0] == "administrative_area_level_1").long_name;
					var country = results[0].address_components.find((add) => add.types[0] == "country").long_name;
					var street = results[0].address_components.find((add) => add.types[0] == "street_number").long_name + ' '
					results[0].address_components.find((add) => add.types[0] == "route").long_name;

					var myLatLng = {lat: latitude, lng: longitude};
					console.log(latitude);
					console.log(longitude);
					console.log(fullName);
					console.log(street);
					console.log(city);
					console.log(country);
					
					// Initialize the map
					map = new google.maps.Map(document.getElementById('map'), {
						center: myLatLng,
						zoom: 15
					});
					
					// Place a marker
					var marker = new google.maps.Marker({
						position: myLatLng,
						map: map,
						title: 'your place'
					});
				} else {
					alert('Geocode was not successful for the following reason: ' + status);
				}
			});
		}

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

let selectedAmenities = [];
const amenitiesButtons = document.querySelectorAll('.amenities-button');
const submit2Selections = document.getElementById('submit-selections2');
amenitiesButtons.forEach(button => {
	button.addEventListener('click', e => {
		const index = selectedAmenities.indexOf(e.target.dataset.value);
		if(index > -1) {
			selectedAmenities.splice(index, 1);
			e.target.classList.remove('selected');
		} else {
			selectedAmenities.push(e.target.dataset.value);
			e.target.classList.add('selected');
		}
		console.log(selectedAmenities);
		submit2Selections.disabled = selectedAmenities.length > 0 ? false : true;
	});
});
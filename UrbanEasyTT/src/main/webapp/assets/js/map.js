var finalResult={};

var geocoder;
var map;
function initAutocomplete() {
	// Create the autocomplete object
	autocomplete = new google.maps.places.Autocomplete(
		/** @type {!HTMLInputElement} */(document.getElementById('address')),
		{types: ['geocode']});
}

let propertyAddress={};
function codeAddress() {
	geocoder = new google.maps.Geocoder();
	var address = document.getElementById('address').value;
	
	let retrievedData = localStorage.getItem("userData");
	//Parse the object
	let parsedData = JSON.parse(retrievedData);

	//Output the parsed object
	console.log(parsedData);

	geocoder.geocode( { 'address': address}, function(results, status) {
		if (status == 'OK') {
			var latitude = results[0].geometry.location.lat();
			var longitude = results[0].geometry.location.lng();


			var fullName = results[0].formatted_address;

			var city = results[0].address_components.find((add) => add.types[0] == "administrative_area_level_1").long_name;
			var country = results[0].address_components.find((add) => add.types[0] == "country").long_name;
			var streetAddress = results[0].address_components.find((add) => add.types[0] == "street_number").long_name;
			var district = results[0].address_components.find((add) => add.types[0] == "route").long_name;

			var myLatLng = {lat: latitude, lng: longitude};

			propertyAddress.latitude=latitude;
			propertyAddress.longitude=longitude;

			propertyAddress.streetAddress=streetAddress;
			propertyAddress.district=district;
			propertyAddress.fullName=fullName;

			propertyAddress.city=city;
			propertyAddress.country=country;
			
			
			console.log(propertyAddress);
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

//Retrieve object from local storage

	
let locate = document.getElementById("verify-location");

locate.addEventListener('click', function() {
	console.log("nho doi url project thanh _TT");
	fetch("http://localhost:8080/UrbanEasy_TT/location", {
	method: 'POST',
	headers: {
		'Accept': 'application/json',
		'Content-Type': 'application/json'
	},
	body: JSON.stringify(propertyAddress)
});
});



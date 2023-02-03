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

	geocoder.geocode( { 'address': address}, function(results, status) {
		if (status == 'OK') {
			var latitude = results[0].geometry.location.lat();
			var longitude = results[0].geometry.location.lng();

			var fullName = results[0].formatted_address;

			var city = results[0].address_components.find((add) => add.types[0] == "administrative_area_level_1")?.long_name;
			var country = results[0].address_components.find((add) => add.types[0] == "country").long_name;
			var streetNumber = results[0].address_components.find((add) => add.types[0] == "street_number")?.long_name;
			var route = results[0].address_components.find((add) => add.types[0] == "route")?.long_name;
			var streetAddress = streetNumber + ' '+ route;
			var district = results[0].address_components.find((add) => add.types[0] == "administrative_area_level_2")?.long_name;

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
			
			console.log(typeof streetNumber !== 'undefined');
			if(typeof propertyAddress.latitude!== 'undefined' && typeof propertyAddress.longitude !== 'undefined' && typeof streetNumber !== 'undefined' 
				&& typeof route !== 'undefined' 
				&& typeof propertyAddress.city!==  'undefined' && typeof propertyAddress.country!== 'undefined') {
				   document.querySelector("#verify-location").disabled = false;
			} else {
				alert("Please input address in detail (street number, route)");
			}
		} else {
			alert('Geocode was not successful for the following reason: ' + status);
		}
	});

}

//Retrieve object from local storage

	
let locate = document.getElementById("verify-location");

locate.addEventListener('click', function() {
	console.log("nho doi url project thanh TT");
	fetch("http://localhost:8080/UrbanEasyTT/location", {
	method: 'POST',
	headers: {
		'Accept': 'application/json',
		'Content-Type': 'application/json'
	},
	body: JSON.stringify(propertyAddress)
});
});



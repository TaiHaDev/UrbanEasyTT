const destinationInput = document.getElementById("destination");

const initMap = () => {
	autocomplete = new google.maps.places.Autocomplete(
		destinationInput,
		{fields: [], types: ['geocode']});
}

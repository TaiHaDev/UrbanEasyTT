const dropDownList = document.querySelector("#drop-down-menu");
const user = document.querySelector("#user");
const main = document.getElementsByTagName('main')[0];
let isDropDownListShowed = false;
const searchBarBackDrop = document.getElementById("search-bar-back-drop");
const open = () => {
	dropDownList.classList.remove('hidden');
	isDropDownListShowed = true;
}
const close = () => {
	dropDownList.classList.add('hidden');
	isDropDownListShowed = false;

}
user.addEventListener('mousedown', event => {
	if (isDropDownListShowed) {
		close();
		document.body.removeEventListener("mousedown", closeDropDownListHandler);
	} else {
		open();
		document.body.addEventListener("mousedown", closeDropDownListHandler);
	}
})


const closeDropDownListHandler = event => {
	const isClickInsideButton = user.contains(event.target)
	const isClickInsideAvoidElement = dropDownList.contains(event.target);
	if (!isClickInsideButton && !isClickInsideAvoidElement) {
		close();
	}
}

const searchBar = document.querySelector("#search-bar");
let isSearchBarShowed = false;
const searchButton = document.querySelector("#search-button-small");
const searchBarSmall = document.querySelector("#search-bar-small");
const closeSearchBar = () => {

}
const openSearchBar = event => {
	searchBarSmall.classList.add("hidden");
	searchBar.classList.remove("hidden");
	isSearchBarShowed = true;
	searchBarBackDrop.addEventListener('mousedown', toggleSearchBarHandler);
	searchBarBackDrop.classList.remove("hidden");
	
}
searchButton.addEventListener('click', openSearchBar);
const toggleSearchBarHandler = event => {
	isInsideSearchBar = searchBar.contains(event.target);
	if (!isInsideSearchBar && isSearchBarShowed) {
		searchBar.classList.add("hidden");
		searchBarSmall.classList.remove("hidden");
		isSearchBarShowed = false;
		searchBarBackDrop.classList.add("hidden");
		searchBarBackDrop.removeEventListener('mousedown', toggleSearchBarHandler);
	}
};

const destinationInput = document.getElementById("destination");
let auto;
let searchingDistrict;
let searchingCity;
let searchingCountry;
function initSearching() {
	// Create the autocomplete object
	auto = new google.maps.places.Autocomplete(
		/** @type {!HTMLInputElement} */destinationInput,
		{ types: ['geocode'], fields: ['address_components'] });
	auto.addListener("place_changed", onPlaceChanged);
}

function onPlaceChanged() {
	let place = auto.getPlace();

	if (!place.address_components) {
		destination.value = '';
		destination.placeholder = 'Re-enter a valid place';

	} else {
		const component = place.address_components;
		let display = "";
		if (component.find((add) => add.types[0] == "administrative_area_level_2")) {
			searchingDistrict = component.find((add) => add.types[0] == "administrative_area_level_2").long_name;
			display = searchingDistrict + ", ";
		}
		if (component.find(add => add.types[0] == "administrative_area_level_1")) {
			searchingCity = component.find(add => add.types[0] == "administrative_area_level_1").long_name;
			display += searchingCity + ", ";
		}
		searchingCountry = component.find((add) => add.types[0] == "country").long_name;
		display  +=  searchingCountry;
		destination.value = display;
	}
}
const cal1 = document.getElementById('check-in');
const cal2 = document.getElementById('check-out');
const config = {
	mode: "range",
	dateFormat: "d/m/Y",
	minDate: "today",
	maxDate: new Date().fp_incr(365),
	onChange: function(selectedDates, dateStr, instance) {
		cal1.value = selectedDates[0].toLocaleDateString();
		if (selectedDates[1]) {
			cal2.value = selectedDates[1].toLocaleDateString();
		}
	},

};
let calendar = flatpickr(cal1, config);
let calendar2 = flatpickr(cal2, config);

const guestNumber = document.getElementById("guest-number");

searchBar.addEventListener("submit", event => {
	if (searchingCountry && cal1.value && cal2.value && guestNumber.value) {
		const cityInput = document.getElementById("city");
		const countryInput = document.getElementById("country");
		const districtInput = document.getElementById("district");
		if (searchingCity) {
			searchingCity.name = "city";
			cityInput.value = searchingCity;
		}

		if (searchingDistrict) {
			districtInput.name = "district";
			districtInput.value = searchingDistrict;
		}
		countryInput.value = searchingCountry;

	} else {
		event.preventDefault();
	}
})

const codes = document.querySelectorAll('.verification-code')

codes[0].focus()

codes.forEach((code, idx) => {
	code.addEventListener('keydown', (e) => {
		if (e.key >= 0 && e.key <= 9) {
			codes[idx].value = ''
			setTimeout(() => codes[idx + 1].focus(), 10)
		} else if (e.key === 'Backspace') {
			setTimeout(() => codes[idx - 1].focus(), 10)
		}
	})
})
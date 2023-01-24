let curr = 1;
const showMoreHandler = event => {
	showingReviews(++curr);
}
const showingReviews = currentN => {
	for (let i = currentN * 6 - 6; i < currentN * 6; i++) {
		const elem = document.getElementById(`review${i}`);
		if (elem) elem.classList.remove("hidden");
	}
}
showingReviews(curr);
const showMoreButton = document.getElementById("show-more-review");
showMoreButton.addEventListener("click", showMoreHandler);

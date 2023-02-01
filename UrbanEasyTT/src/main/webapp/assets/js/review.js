function onload(event) {

	for (let i = 1; i <= 6; i++) {
		var starRatingStep = raterJs({
			starSize: 25,
			step: 0.5,
			element: document.querySelector("#rater-step" + i),
			rateCallback: function rateCallback(rating, done) {
				this.setRating(rating);
				done();
			},
			onHover: function(currentIndex, currentRating) {
				document.querySelector('.live-rating' + i).textContent = currentIndex;
			},
			onLeave: function(currentIndex, currentRating) {
				document.querySelector('.live-rating' + i).textContent = currentRating;
			}
		});
	}
}

window.addEventListener("load", onload, false);



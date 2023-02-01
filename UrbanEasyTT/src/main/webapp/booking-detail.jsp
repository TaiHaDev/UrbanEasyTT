<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="assets/js/tailwind.js"></script>
<title>Booking Detail - Urban Easy</title>
</head>
<body>
	<jsp:include page="header.jsp">
		<jsp:param name="userId" value="${sessionScope.userId}" />
		<jsp:param name="avatar" value="${sessionScope.avatar }" />
	</jsp:include>
	<main class="px-4 md:mx-10 lg:mx-20 xl:mx-40 2xl:mx-80 lg:px-24">
		<div class="flex justify-between items-center border-b py-6">
			<div class="flex flex-col space-y-4">
				<p class="font-bold text-gray-400 text-sm">${booking.status}</p>
				<p class="font-bold text-2xl">${booking.name }</p>
				<p class="text-sm font-light">${booking.guest}guest(s),
					${booking.length} night(s)</p>
				<p class="text-sm font-light">
					Hosted by <span class="font-bold">${booking.hostName}</span>
				</p>
			</div>
			<img src="${booking.avatarUrl }" class="w-16 rounded-full" />
		</div>
		<div class="mt-3">
			<img src="${booking.propertyUrl }" class="rounded-md w-1/2 mx-auto" />
			<p class="text-lg font-bold text-center">${booking.name }</p>
		</div>
		<div class="my-4 space-y-3">
			<h1 class="text-3xl">Details</h1>
			<div class="flex justify-between">
				<div class="flex flex-col space-y-1">
					<p class="font-bold">Check-in:</p>
					<p class="text-sm font-medium">${booking.startDate }</p>
					<p class="text-sm font-medium">Check-in after 3 pm</p>
				</div>
				<div class="flex flex-col space-y-1 items-end">
					<p class="font-bold">Check-out:</p>
					<p class="text-sm font-medium">${booking.endDate }</p>
					<p class="text-sm font-medium">Check-out before 11 am</p>
				</div>
			</div>
			<div class="py-3 border-t border-b flex justify-between items-center">
				<p class="font-bold">Address</p>
				<p class="font-bold text-sm">${booking.address }</p>
			</div>
			<div class="py-3 border-b flex justify-between items-center">
				<p class="font-bold">Host Phone number</p>
				<p class="font-bold text-sm">${booking.hostPhoneNumber }</p>
			</div>
			<div class="py-3 border-b flex justify-between items-center">
				<p class="font-bold">Booking Date</p>
				<p class="font-bold text-sm">${booking.bookingDate }</p>
			</div>
			<div class="py-3 border-b flex justify-between items-center">
				<p class="font-bold">Host Email</p>
				<p class="font-bold text-sm">${booking.hostEmail}</p>
			</div>
			<div class="py-3 border-b flex justify-between items-center">
				<p class="font-bold">You paid</p>
				<p class="font-bold text-sm">$${booking.paidAmount } AUD</p>
			</div>
		</div>
		<div class="flex justify-between border-b">
			<div class="flex flex-col items-center space-y-2 w-60">
				<a href="<%=request.getContextPath()%>/user?id=${booking.hostId}"><button
					class="px-3 py-1 border rounded-md hover:bg-slate-700 hover:text-white">
					Host
						Details
				</button></a>
				<p class="font-light text-xs max-w-xs text-center">Get to know
					your host better</p>
			</div>
			<div class="flex flex-col items-center space-y-2 w-60">
				<a
						href="<%=request.getContextPath()%>/product-detail?id=${booking.propertyId}"><button
					class="px-3 py-1 border rounded-md hover:bg-slate-700 hover:text-white">
					Property
						Details
				</button></a>
				<p class="font-light text-xs max-w-xs text-center">Take a look
					at where you are going to stay soon!</p>
			</div>
			<c:if test="${booking.status == 'booked'}">
				<div class="flex flex-col items-center space-y-2 w-60">
				<button
					id="cancel-booking"
					class="px-3 py-1 border rounded-md hover:bg-slate-700 hover:text-white">Cancel
					Booking</button>
				<p class="font-light text-xs max-w-xs text-center">You will be
					charged 20% of your payment when you cancel 3 days before your
					booking date</p>
			</div>
			</c:if>
		</div>
		<c:if test="${booking.isReviewed() == false}">
			<h1 class="text-3xl my-6">Leave a review</h1>
			<div class="space-y-4">

				<div class="flex justify-between">
					<p class="text-lg font-bold">Check-in:</p>
					<div class="flex space-x-2">
						<div id="rater-step1"></div>
						<div class="live-rating1 w-8"></div>
					</div>
				</div>
				<div class="flex justify-between">
					<p class="text-lg font-bold">Cleanliness:</p>
					<div class="flex space-x-2">
						<div id="rater-step2"></div>
						<div class="live-rating2 w-8 font-medium"></div>
					</div>
				</div>
				<div class="flex justify-between">
					<p class="text-lg font-bold">Communication:</p>
					<div class="flex space-x-2">
						<div id="rater-step3"></div>
						<div class="live-rating3 w-8 font-medium"></div>
					</div>
				</div>
				<div class="flex justify-between">
					<p class="text-lg font-bold">Accuracy:</p>
					<div class="flex space-x-2">
						<div id="rater-step4"></div>
						<div class="live-rating4 w-8 font-medium"></div>
					</div>
				</div>
				<div class="flex justify-between">
					<p class="text-lg font-bold">Location:</p>
					<div class="flex space-x-2">
						<div id="rater-step5"></div>
						<div class="live-rating5 w-8 font-medium"></div>
					</div>
				</div>
				<div class="flex justify-between">
					<p class="text-lg font-bold">Value:</p>
					<div class="flex space-x-2">
						<div id="rater-step6"></div>
						<div class="live-rating6 w-8 font-medium"></div>
					</div>
				</div>
				<div>
					<p class="text-lg font-bold mb-4">Comments:</p>
					<textarea id="comment"
						class="resize rounded-md text-lg font-medium placeholder:text-lg p-2 border shadow-md block"
						placeholder="Share your thinking" rows="4" cols="50"></textarea>

				</div>
			</div>
			<div class="mb-16 flex flex-col items-end space-y-1">
				<button id="submit-review"
					class="px-3 py-2 border border-slate-800 rounded-md hover:bg-slate-200">Submit
					Review</button>
				<p id="review-warning" class="text-xs font-bold text-red-400 hidden">Please
					rate all categories</p>
			</div>
		</c:if>
		<c:if test="${booking.isReviewed() != false}">
			<div class="mb-16"></div>
		</c:if>
		<script src="assets/js/review.js"></script>
		<script src="assets/js/rater-js/index.js"></script>

	</main>
	<script type="text/javascript">
	const checkIn = document.querySelector(".live-rating1");
	const cleanliness = document.querySelector(".live-rating2");
	const communication = document.querySelector(".live-rating3");
	const accuracy = document.querySelector(".live-rating4");
	const loc = document.querySelector(".live-rating5");
	const value = document.querySelector(".live-rating6");
	const comment = document.getElementById("comment");
	const submitReviewButton = document.getElementById("submit-review");
	const bookingId = "${id}";
	if (submitReviewButton) {
		submitReviewButton.addEventListener("click", async event => {
			const checkInRating = checkIn.textContent;
			const cleanlinessRating = cleanliness.textContent;
			const communicationRating = communication.textContent;
			const accuracyRating = accuracy.textContent;
			const locationRating = loc.textContent;
			const valueRating = value.textContent;
			const commentContent = comment.value;
			const propertyId = "${booking.propertyId}";
			const userId = "${sessionScope.userId}";
			if (checkInRating != '' && cleanlinessRating != '' && communicationRating != '' && accuracyRating != '' && locationRating != '' && valueRating != '') {
				const payload = {
					propertyId,
					userId,
					checkInRating,
					cleanlinessRating,
					communicationRating,
					locationRating,
					accuracyRating,
					valueRating,
					commentContent,
					bookingId
				}
				await fetch("http://localhost:8080/UrbanEasyTT/submitReview", {
					method: 'POST',
					headers: {
						'Accept': 'application/json',
						'Content-Type': 'application/json'
					},
					body: JSON.stringify(payload)
				});
				window.location.reload();

			} else {
				const warning = document.getElementById('review-warning');
				warning.classList.remove("hidden");
			}

		})
	}
	const cancelButton = document.getElementById("cancel-booking");
	cancelButton.addEventListener("click", async event => {
		const response = await fetch("http://localhost:8080/UrbanEasyTT/CancelBooking?id=" + bookingId);
		console.log(response.ok)
		window.location.reload();

	})
	</script>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
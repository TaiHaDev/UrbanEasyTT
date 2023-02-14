<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<script src="assets/js/tailwind.js"></script>



<script src='https://api.mapbox.com/mapbox-gl-js/v2.11.0/mapbox-gl.js'></script>
<link href='https://api.mapbox.com/mapbox-gl-js/v2.11.0/mapbox-gl.css'
	rel='stylesheet' />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>


</head>
<body>
	<jsp:include page="header.jsp" >
		<jsp:param name="userId" value="${sessionScope.userId}"/>
		<jsp:param name="avatar" value="${sessionScope.avatar }"/>
	</jsp:include>
	<main class="h-screen">
		
		<div class="px-4 md:mx-10 lg:mx-20 xl:mx-40 2xl:mx-80 lg:px-24">
			<div class="font-medium text-3xl pt-6">${product.getName()}</div>
			<div class="flex space-x-1 items-center mt-3 mb-5">
				<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"
					fill="currentColor" class="w-5 h-5">
  <path fill-rule="evenodd"
						d="M10.868 2.884c-.321-.772-1.415-.772-1.736 0l-1.83 4.401-4.753.381c-.833.067-1.171 1.107-.536 1.651l3.62 3.102-1.106 4.637c-.194.813.691 1.456 1.405 1.02L10 15.591l4.069 2.485c.713.436 1.598-.207 1.404-1.02l-1.106-4.637 3.62-3.102c.635-.544.297-1.584-.536-1.65l-4.752-.382-1.831-4.401z"
						clip-rule="evenodd" />
</svg>
				<c:if test="${reviewsList.size() > 0 }">
					<span class="font-medium">${averageReview}</span>
					<span class="text-sm font-bold mx-3">.</span>
					<a href="#review" class="underline"> <span class="font-medium">${reviewsList.size()}</span>
						<span class="font-medium">reviews</span>
					</a>
				</c:if>
				<c:if test="${reviewsList.size() == 0 }">
					<span class="font-bold">NEW</span>
				</c:if>
				<span class="text-sm font-bold mx-3">.</span> <span
					class=" font-medium underline">${product.getDistrict()},
					${product.getCity()}, ${product.getCountry()}</span>
			</div>
			<div id="address" class="ml-4"></div>
			<div>
				<img src="" alt="" /> <img src="" alt="" /> <img src="" alt="" />
			</div>
			<div class="grid grid-cols-1 md:grid-cols-4 grid-rows-2 gap-2">
				<img src=<c:out value="${assets[0]}"/> alt=""
					class="h-full col-span-2 row-span-2 rounded object-cover bg-center" /> <img
					src=<c:out value="${assets[1]}"/> alt=""
					class="h-full hidden col-span-1 row-span-1 rounded md:block" /> <img
					src=<c:out value="${assets[2]}"/> alt=""
					class="h-full hidden col-span-1 row-span-1 rounded md:block" /> <img
					src=<c:out value="${assets[3]}"/> alt=""
					class="h-full hidden col-span-1 row-span-1 rounded md:block" /> <img
					src=<c:out value="${assets[4]}"/> alt=""
					class="hidden col-span-1 row-span-1 rounded md:block" />
			</div>

			<div
				class="flex flex-col space-y-3 sm:space-y-0 sm:grid grid-cols-12 grid-rows-2 mt-4 gap-x-4 pb-8 border-b">
				<div class="col-span-5 row-span-2">
					<div class="border-b">
						<div class="font-medium text-xl mb-2">Entire cottage hosted
							by</div>
						<div class="flex mb-2 flex-wrap">
							<div>${product.getGuest()} ${product.getGuest() > 1 ? "guests" : "guest"}</div>
							<span class="text-xs font-bold mx-2">.</span>
							<div>${product.getBedroom()} ${product.getBedroom() > 1 ? "bedrooms" : "bedroom"}</div>
							<span class="text-xs font-bold mx-2">.</span>
							<div>${product.getBed() } ${product.getBed() > 1 ? "beds" : "bed"}
							</div>
							<span class="text-xs font-bold mx-2">.</span>
							<div>${product.getBath()} ${ product.getBath() > 1 ? "baths" : "bath"}</div>
						</div>
					</div>
					<div class="my-2 border-b pb-3">
						<div class="flex items-center space-x-2 my-2">
							<svg xmlns="http://www.w3.org/2000/svg" fill="none"
								viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor"
								class="w-6 h-6">
                  <path stroke-linecap="round" stroke-linejoin="round"
									d="M15.75 5.25a3 3 0 013 3m3 0a6 6 0 01-7.029 5.912c-.563-.097-1.159.026-1.563.43L10.5 17.25H8.25v2.25H6v2.25H2.25v-2.818c0-.597.237-1.17.659-1.591l6.499-6.499c.404-.404.527-1 .43-1.563A6 6 0 1121.75 8.25z" />
                </svg>
							<div>
								<p class="text-sm font-medium">Great check in experience</p>
								<p class="text-xs font-light">100% of recent guests gave the
									check-in process a 5 stars rating.</p>
							</div>
						</div>
						<div class="flex items-center space-x-2 my-2">
							<svg xmlns="http://www.w3.org/2000/svg" fill="none"
								viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor"
								class="w-6 h-6">
                  <path stroke-linecap="round" stroke-linejoin="round"
									d="M12 4.5v15m0 0l6.75-6.75M12 19.5l-6.75-6.75" />
                </svg>

							<div>
								<p class="text-sm font-medium">Park for free</p>
								<p class="text-xs font-light">This is one of the few places
									in the area with free parking</p>
							</div>
						</div>
						<div class="flex items-center space-x-2 my-2">
							<svg xmlns="http://www.w3.org/2000/svg" fill="none"
								viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor"
								class="w-6 h-6">
                  <path stroke-linecap="round" stroke-linejoin="round"
									d="M6.75 3v2.25M17.25 3v2.25M3 18.75V7.5a2.25 2.25 0 012.25-2.25h13.5A2.25 2.25 0 0121 7.5v11.25m-18 0A2.25 2.25 0 005.25 21h13.5A2.25 2.25 0 0021 18.75m-18 0v-7.5A2.25 2.25 0 015.25 9h13.5A2.25 2.25 0 0121 11.25v7.5m-9-6h.008v.008H12v-.008zM12 15h.008v.008H12V15zm0 2.25h.008v.008H12v-.008zM9.75 15h.008v.008H9.75V15zm0 2.25h.008v.008H9.75v-.008zM7.5 15h.008v.008H7.5V15zm0 2.25h.008v.008H7.5v-.008zm6.75-4.5h.008v.008h-.008v-.008zm0 2.25h.008v.008h-.008V15zm0 2.25h.008v.008h-.008v-.008zm2.25-4.5h.008v.008H16.5v-.008zm0 2.25h.008v.008H16.5V15z" />
                </svg>
							<div>
								<p class="text-sm font-medium">Free cancellation before
									3:00pm on 6 Jan.</p>
							</div>
						</div>
					</div>
					<div class="font-medium text-lg my-2">What this place offer</div>

					<div class="flex justify-between ">
						<div>
							<div class="flex items-center space-x-3 my-2">
								<svg xmlns="http://www.w3.org/2000/svg" fill="none"
									viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor"
									class="w-6 h-6">
                    <path stroke-linecap="round" stroke-linejoin="round"
										d="M8.288 15.038a5.25 5.25 0 017.424 0M5.106 11.856c3.807-3.808 9.98-3.808 13.788 0M1.924 8.674c5.565-5.565 14.587-5.565 20.152 0M12.53 18.22l-.53.53-.53-.53a.75.75 0 011.06 0z" />
                  </svg>
								<div class="text-sm">Wi-Fi</div>
							</div>
							<div class="flex items-center space-x-3 my-2">
								<svg xmlns="http://www.w3.org/2000/svg" fill="none"
									viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor"
									class="w-6 h-6">
                    <path stroke-linecap="round"
										d="M15.75 10.5l4.72-4.72a.75.75 0 011.28.53v11.38a.75.75 0 01-1.28.53l-4.72-4.72M4.5 18.75h9a2.25 2.25 0 002.25-2.25v-9a2.25 2.25 0 00-2.25-2.25h-9A2.25 2.25 0 002.25 7.5v9a2.25 2.25 0 002.25 2.25z" />
                  </svg>

								<div class="text-sm">Sercurity cameras on property</div>
							</div>
							<div class="flex items-center space-x-3 my-2">
								<svg xmlns="http://www.w3.org/2000/svg" fill="none"
									viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor"
									class="w-6 h-6">
                    <path stroke-linecap="round" stroke-linejoin="round"
										d="M9 17.25v1.007a3 3 0 01-.879 2.122L7.5 21h9l-.621-.621A3 3 0 0115 18.257V17.25m6-12V15a2.25 2.25 0 01-2.25 2.25H5.25A2.25 2.25 0 013 15V5.25m18 0A2.25 2.25 0 0018.75 3H5.25A2.25 2.25 0 003 5.25m18 0V12a2.25 2.25 0 01-2.25 2.25H5.25A2.25 2.25 0 013 12V5.25" />
                  </svg>

								<div class="text-sm">Spare desktop</div>
							</div>
							<button
								class="py-2 px-3 border border-slate-700 rounded-md my-4 text-sm hover:bg-slate-100">
								Show all 41 amentities</button>
						</div>
						<div class="hidden md:block">
							<div class="flex items-center space-x-3 my-2">
								<svg xmlns="http://www.w3.org/2000/svg" fill="none"
									viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor"
									class="w-6 h-6">
                    <path stroke-linecap="round" stroke-linejoin="round"
										d="M6 20.25h12m-7.5-3v3m3-3v3m-10.125-3h17.25c.621 0 1.125-.504 1.125-1.125V4.875c0-.621-.504-1.125-1.125-1.125H3.375c-.621 0-1.125.504-1.125 1.125v11.25c0 .621.504 1.125 1.125 1.125z" />
                  </svg>

								<div class="text-sm">24" HDTV</div>
							</div>
							<div class="flex items-center space-x-3 my-2">
								<svg xmlns="http://www.w3.org/2000/svg" fill="none"
									viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor"
									class="w-6 h-6">
                    <path stroke-linecap="round" stroke-linejoin="round"
										d="M8.25 21v-4.875c0-.621.504-1.125 1.125-1.125h2.25c.621 0 1.125.504 1.125 1.125V21m0 0h4.5V3.545M12.75 21h7.5V10.75M2.25 21h1.5m18 0h-18M2.25 9l4.5-1.636M18.75 3l-1.5.545m0 6.205l3 1m1.5.5l-1.5-.5M6.75 7.364V3h-3v18m3-13.636l10.5-3.819" />
                  </svg>

								<div class="text-sm">Modern house</div>
							</div>
							<div class="flex items-center space-x-3 my-2">
								<svg xmlns="http://www.w3.org/2000/svg" fill="none"
									viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor"
									class="w-6 h-6">
                    <path stroke-linecap="round" stroke-linejoin="round"
										d="M12 12.75c1.148 0 2.278.08 3.383.237 1.037.146 1.866.966 1.866 2.013 0 3.728-2.35 6.75-5.25 6.75S6.75 18.728 6.75 15c0-1.046.83-1.867 1.866-2.013A24.204 24.204 0 0112 12.75zm0 0c2.883 0 5.647.508 8.207 1.44a23.91 23.91 0 01-1.152 6.06M12 12.75c-2.883 0-5.647.508-8.208 1.44.125 2.104.52 4.136 1.153 6.06M12 12.75a2.25 2.25 0 002.248-2.354M12 12.75a2.25 2.25 0 01-2.248-2.354M12 8.25c.995 0 1.971-.08 2.922-.236.403-.066.74-.358.795-.762a3.778 3.778 0 00-.399-2.25M12 8.25c-.995 0-1.97-.08-2.922-.236-.402-.066-.74-.358-.795-.762a3.734 3.734 0 01.4-2.253M12 8.25a2.25 2.25 0 00-2.248 2.146M12 8.25a2.25 2.25 0 012.248 2.146M8.683 5a6.032 6.032 0 01-1.155-1.002c.07-.63.27-1.222.574-1.747m.581 2.749A3.75 3.75 0 0115.318 5m0 0c.427-.283.815-.62 1.155-.999a4.471 4.471 0 00-.575-1.752M4.921 6a24.048 24.048 0 00-.392 3.314c1.668.546 3.416.914 5.223 1.082M19.08 6c.205 1.08.337 2.187.392 3.314a23.882 23.882 0 01-5.223 1.082" />
                  </svg>

								<div class="text-sm">Bug Free</div>
							</div>
						</div>
					</div>
				</div>


				<div
					class="col-span-3 row-span-1 shadow-md flex items-center rounded-md">
					<div
						class="flex flex-col items-center justify-between space-y-2 w-full">
						<div class="flex">
							<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"
								fill="currentColor" class="w-4 h-4">
                  <path fill-rule="evenodd"
									d="M10.788 3.21c.448-1.077 1.976-1.077 2.424 0l2.082 5.007 5.404.433c1.164.093 1.636 1.545.749 2.305l-4.117 3.527 1.257 5.273c.271 1.136-.964 2.033-1.96 1.425L12 18.354 7.373 21.18c-.996.608-2.231-.29-1.96-1.425l1.257-5.273-4.117-3.527c-.887-.76-.415-2.212.749-2.305l5.404-.433 2.082-5.006z"
									clip-rule="evenodd" />
                </svg>
							<div class="font-medium text-xs">${owner.getTotalReview()}
								reviews</div>
							<span class="hidden text-xs ml-1 lg:block">(100% response
								rate)</span>
						</div>
						<a href="<%=request.getContextPath()%>/user?id=${owner.getId()}">
							<div class="flex justify-center items-center space-x-3">

								<img src="${owner.getAvatarURL() }" alt=""
									class="w-10 rounded-full">
								<div class="text-sky-600 text-sm">${owner.getName()}</div>


							</div>
						</a>
						<button
							class="text-white bg-gray-500 text-sm px-4 py-2 rounded-md">Contact
							host</button>
						<a href="<%=request.getContextPath()%>/user?id=${owner.getId()}">
							<button
								class="text-gray-700 bg-white border border-slate-700 text-sm px-2 py-1 rounded-md">View
								profile</button>

						</a>
					</div>
				</div>
				<form action="<%=request.getContextPath()%>/paymentServlet" id="booking-form"
						method="post" class="col-span-4 row-span-2 flex flex-col justify-center items-between border p-4 space-y-3 shadow-md">

					<div class="flex justify-between items-center">
						<div class="font-medium text-lg">${product.getPrice()}AUD
							total</div>
						<div class="flex ml-2">
							<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"
								fill="currentColor" class="w-4 h-4">
                  <path fill-rule="evenodd"
									d="M10.788 3.21c.448-1.077 1.976-1.077 2.424 0l2.082 5.007 5.404.433c1.164.093 1.636 1.545.749 2.305l-4.117 3.527 1.257 5.273c.271 1.136-.964 2.033-1.96 1.425L12 18.354 7.373 21.18c-.996.608-2.231-.29-1.96-1.425l1.257-5.273-4.117-3.527c-.887-.76-.415-2.212.749-2.305l5.404-.433 2.082-5.006z"
									clip-rule="evenodd" />
                </svg>
							<div class="text-xs font-medium">${averageReview}</div>
							<span class="text-xs font-light hidden lg:block">(${reviewsList.size() }
								reviews)</span>
						</div>
					</div>
					
					<div class="border rounded-md flex flex-col ">
						<div class="flex ">
							<div class="inset-x-0 flex flex-col w-1/2 border-r border-b p-2">
								<label class="font-medium text-xs" for="final-check-in">CHECK-IN</label>
								<input type="text" id="final-check-in" name="start-date"
									class="w-3/4 outline-none text-sm font-light"
									placeholder="date in"
									name="">
							</div>
							<div class="flex flex-col w-1/2 border-b pt-2 pl-3">
								<label class="font-medium text-xs" for="final-check-out">CHECK-OUT</label>
								<input type="text" id="final-check-out" name="end-date"
									class="outline-none text-sm font-light" placeholder="date out">
							</div>
						</div>
						<div class="flex justify-between p-3 items-center">
							<div class="flex flex-col">
								<label class="font-medium text-xs" for="final-guests">GUESTS</label>
								<p class=" text-sm font-light">Maximum ${product.getGuest()}
									guests</p>
							</div>
						</div>
					</div>
				
					
						<input type="hidden" name="name" value="${product.getName()}"> 
						<input type="hidden" name="image" value="${assets[0]}">
						<input type="hidden" name="price" id="price-param" >
						<input type="hidden" name="propertyId" value="${product.id}">
				
						<button type="submit"
							class="text-white bg-gray-500 w-full py-2.5 rounded-md">
							Reserve</button>

			

					<div class="text-center font-medium text-red-600 text-sm hidden"
						id="missing-dates">Please choose your check-in and check-out
						dates</div>
					<div class="text-center font-light text-xs">You won't be
						charge yet</div>
					<div class="text-center font-light text-xs">Price shown is
						the total trip price, including additional fees and taxes.</div>
					<div class="space-y-2 pb-3 border-b">
						<div class="flex justify-between">
							<div id="price-info"
								class="font-light decoration-1 underline text">$${product.getPrice()}
								AUD x 0 nights</div>
							<div id="staying-fee" class="font-light">$0 AUD</div>
						</div>
						<div class="flex justify-between">
							<div class="font-light decoration-1 underline text">Service
								fee</div>
							<div id="service-fee" class="font-light">$0 AUD</div>
						</div>
					</div>
					<div class="flex justify-between">
						<div class="font-bold">Total</div>
						<div id="total-fee" class="font-medium">$0 AUD</div>
					</div>
				</form>
			</div>
			<div class="py-4 border-b flex flex-col space-y-2">
				<span class="font-medium text-xl">About this</span>
					<p>${product.description}</p>
			</div>
			<div class="my-3 space-y-3">
				<span class="font-medium text-xl">Location</span>
				<div class="font-medium">${product.getDistrict()},
					${product.getCity()}, ${product.getCountry()}</div>
				<div class="text-sm">${product.neighbourhoodOverview}</div>
				<div id='map' class="mt-3" style='width: full; height: 450px;'></div>



				<script>
					const lng = "<c:out value="${product.lng}"/>";
					const lat = "<c:out value="${product.lat}"/>";
					mapboxgl.accessToken = 'pk.eyJ1IjoiYXBpZXhwbG9yZXIiLCJhIjoiY2xiZzJ4ZmEyMGFrejN2bXV1YXRucnRkMCJ9.3KIUk-IF5zhcKaaPNEyQjQ';
					const map = new mapboxgl.Map(
							{
								container : 'map', // container ID
								style : 'mapbox://styles/apiexplorer/clccutn42000914o552o67bpk', // style URL
								center : [ lng, lat ], // starting position [lng, lat]
								zoom : 12, // starting zoom
								scrollZoom: false,
							});
					var rightClickCount = 0;

					map.on('contextmenu', function (e) {
					  rightClickCount += 1;
					  setTimeout(function () {
					    rightClickCount = 0;
					  }, 500);

					  if (rightClickCount === 2) {
					    map.zoomTo(map.getZoom() - 1, {duration: 500});
					  }
					});
					
					const marker1 = new mapboxgl.Marker().setLngLat(
							[ lng, lat ]).addTo(map);
				</script>
			</div>
			<div class="border-b pb-4">
				<div class="flex space-x-2 text-lg font-medium my-4">
					<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"
						fill="currentColor" class="w-6 h-6">
  <path fill-rule="evenodd"
							d="M10.788 3.21c.448-1.077 1.976-1.077 2.424 0l2.082 5.007 5.404.433c1.164.093 1.636 1.545.749 2.305l-4.117 3.527 1.257 5.273c.271 1.136-.964 2.033-1.96 1.425L12 18.354 7.373 21.18c-.996.608-2.231-.29-1.96-1.425l1.257-5.273-4.117-3.527c-.887-.76-.415-2.212.749-2.305l5.404-.433 2.082-5.006z"
							clip-rule="evenodd" />
</svg>
					<span>${averageReview }</span> <span class="text-base">.</span>
					<div id="review" class="font-medium">${reviewsList.size()}
						Reviews</div>
				</div>

				<div>
					<div
						class="flex justify-between items-center space-x-4 md:space-x-20 ">
						<div class="w-1/2 space-y-2">
							<div class="flex justify-between items-center">
								<span class="text-sm">Cleanliness</span>
								<div class="w-1/3 flex items-center space-x-2">
									<div class="bg-gray-300 rounded-full h-1.5 w-[95%] ">
										<div class="bg-slate-700 h-1.5 rounded-full"
											style="width: ${ratingsPercentage.get(0)}%"></div>
									</div>
									<div class="text-xs font-medium">${averageRatings.get(0)}</div>
								</div>
							</div>
							<div class="flex justify-between items-center">
								<span class="text-sm">Communication</span>
								<div class="w-1/3 flex items-center space-x-2">
									<div class="bg-gray-300 rounded-full h-1.5 w-[95%] ">
										<div class="bg-slate-700 h-1.5 rounded-full"
											style="width: ${ratingsPercentage.get(1)}%"></div>
									</div>
									<div class="text-xs font-medium">${averageRatings.get(1)}</div>
								</div>
							</div>
							<div class="flex justify-between items-center">
								<span class="text-sm">Check-in</span>
								<div class="w-1/3 flex items-center space-x-2">
									<div class="bg-gray-300 rounded-full h-1.5 w-[95%] ">
										<div class="bg-slate-700 h-1.5 rounded-full"
											style="width: ${ratingsPercentage.get(2)}%"></div>
									</div>
									<div class="text-xs font-medium">${averageRatings.get(2)}</div>
								</div>

							</div>
						</div>
						<div class="w-1/2 space-y-2">
							<div class="flex justify-between items-center ">
								<span class="text-sm">Accuracy</span>
								<div class="w-1/3 flex items-center space-x-2">
									<div class="bg-gray-300 rounded-full h-1.5 w-[95%] ">
										<div class="bg-slate-700 h-1.5 rounded-full"
											style="width: ${ratingsPercentage.get(3)}%"></div>
									</div>
									<div class="text-xs font-medium">${averageRatings.get(3)}</div>
								</div>
							</div>
							<div class="flex justify-between items-center">
								<span class="text-sm">Location</span>
								<div class="w-1/3 flex items-center space-x-2">
									<div class="bg-gray-300 rounded-full h-1.5 w-[95%] ">
										<div class="bg-slate-700 h-1.5 rounded-full"
											style="width: ${ratingsPercentage.get(4)}%"></div>
									</div>
									<div class="text-xs font-medium">${averageRatings.get(4)}</div>
								</div>
							</div>
							<div class="flex justify-between items-center">
								<span class="text-sm">Value</span>
								<div class="w-1/3 flex items-center space-x-2">
									<div class="bg-gray-300 rounded-full h-1.5 w-[95%] ">
										<div class="bg-slate-700 h-1.5 rounded-full"
											style="width: ${ratingsPercentage.get(5)}%"></div>
									</div>
									<div class="text-xs font-medium">${averageRatings.get(5)}</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="flex flex-col justify-between">
					<div class="flex justify-between my-8 flex-wrap ">
						<c:forEach var="review" items="${reviewsList}" varStatus="loop">
							<div class="mt-4 hidden" id="review${loop.index}">
								<a
									href="<%=request.getContextPath()%>/user?id=${review.getReviewerId()}">
									<div class="flex items-center space-x-2">
										<img src="${review.getUserUrl()}" alt=""
											class="w-8 rounded-full">
										<div class="inline-flex flex-col">
											<span class="text-sm font-medium">${review.getUserName() }</span>
											<span class="text-xs font-light">${review.getDate()}</span>
										</div>
									</div>
								</a>
								<p class="text-sm lg:max-w-sm">${review.getComment()}</p>
							</div>
						</c:forEach>

					</div>
				</div>
				<c:if test="${reviewsList.size() > 0 }">
					<button id="show-more-review"
						class="text-sm font-medium px-3 py-2 border border-slate-800 rounded-md hover:bg-gray-200">Show
						more reviews</button>
				</c:if>

			</div>
			<div class="pb-12">
				<div class="text-lg font-medium">Things to know</div>
				<div class="w-full flex justify-between my-4">
					<div class="flex flex-col space-y-2 items-start">
						<p class="text-sm font-medium">House rules</p>
						<p class="text-sm">Check-in: 3:00 pm - 12:00 am</p>
						<p class="text-sm">Check-out before 11:00 am</p>
						<p class="text-sm">2 guests maximum</p>
						<button class="text-sm decoration-1 underline font-medium">
							Show more
							<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"
								fill="currentColor" class="w-4 h-4 inline">
              <path fill-rule="evenodd"
									d="M7.21 14.77a.75.75 0 01.02-1.06L11.168 10 7.23 6.29a.75.75 0 111.04-1.08l4.5 4.25a.75.75 0 010 1.08l-4.5 4.25a.75.75 0 01-1.06-.02z"
									clip-rule="evenodd" />
            </svg>
						</button>
					</div>
					<div class="flex flex-col space-y-2 items-start">
						<p class="text-sm font-medium">House rules</p>
						<p class="text-sm">Check-in: 3:00 pm - 12:00 am</p>
						<p class="text-sm">Check-out before 11:00 am</p>
						<p class="text-sm">2 guests maximum</p>

						<button class="text-sm decoration-1 underline font-medium">
							Show more
							<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"
								fill="currentColor" class="w-4 h-4 inline">
              <path fill-rule="evenodd"
									d="M7.21 14.77a.75.75 0 01.02-1.06L11.168 10 7.23 6.29a.75.75 0 111.04-1.08l4.5 4.25a.75.75 0 010 1.08l-4.5 4.25a.75.75 0 01-1.06-.02z"
									clip-rule="evenodd" />
            </svg>

						</button>
					</div>
					<div class="flex flex-col space-y-2 items-start">
						<p class="text-sm font-medium">House rules</p>
						<p class="text-sm">Check-in: 3:00 pm - 12:00 am</p>
						<p class="text-sm">Check-out before 11:00 am</p>
						<p class="text-sm">2 guests maximum</p>

						<button class="text-sm decoration-1 underline font-medium">
							Show more
							<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"
								fill="currentColor" class="w-4 h-4 inline">
              <path fill-rule="evenodd"
									d="M7.21 14.77a.75.75 0 01.02-1.06L11.168 10 7.23 6.29a.75.75 0 111.04-1.08l4.5 4.25a.75.75 0 010 1.08l-4.5 4.25a.75.75 0 01-1.06-.02z"
									clip-rule="evenodd" />
            </svg>

						</button>
					</div>
				</div>
			</div>
			
	</main>
	<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript">

	function daysBetween(date1, date2) {
		  // Convert both dates to milliseconds
		  var date1_ms = date1.getTime();
		  var date2_ms = date2.getTime();
		  // Calculate the difference in milliseconds
		  var difference_ms = date2_ms - date1_ms;
		  // Convert back to days and return
		  return Math.round(difference_ms/1000/60/60/24);
		}
		let night;
		let totalPrice;
		const dateString = "${bookedDates}"
        const disabledDates = dateString.slice(1, -1).split(", ");
        const elem = document.getElementById('final-check-in');
        const elem2 = document.getElementById('final-check-out');
    	const modifyDisableDates = date => {
    			
    		for (let i = 0; i < disabledDates.length; i++) {
    			const d = disabledDates[i];
    			const parts = d.split("/");
    			const day = parts[0];
    			const month = parts[1] - 1;
    			const year = parts[2];
    			const date2 = new Date(year, month, day);
    			if (date < date2) {
    				disabledDates.splice(i, 1);
    				date2.setDate(date2.getDate() + 1);
    				disabledDates.push(date2);
    				disabledDates.push(date);
    				return 
    			}
    			
    		}
    	}
        const config = {
                mode: "range",
                dateFormat: "d/m/Y",
                minDate: "today",
                maxDate: new Date().fp_incr(365),
                disable: disabledDates,
                onChange: function(selectedDates, dateStr, instance) {
                	elem.value = selectedDates[0].toLocaleDateString();
                	if (selectedDates[1]) {
                		
                        elem2.value = selectedDates[1].toLocaleDateString();
                       	night = daysBetween(selectedDates[0], selectedDates[1]);
                        calculateAndRenderFee(night);
                	} else {
                		modifyDisableDates(selectedDates[0]);
                    	instance.config.disable = disabledDates;
                    	instance.redraw();
                	}
                },
          
              };
      let calendar = flatpickr(elem, config);
      let calendar2 = flatpickr(elem2, config);
      function calculateAndRenderFee(night) {
    	  const priceInfo = document.getElementById('price-info');
    	  const stayingFee = document.getElementById('staying-fee');
    	  const serviceFee = document.getElementById('service-fee')
    	  const totalFee = document.getElementById('total-fee');
    	  const pricePerDay = "${product.getPrice()}";
    	  const nightText = night == 1 ? "night" : "nights"
    	  const priceInfoText = "$" + pricePerDay + " AUD x " + night + " " + nightText;
    	  priceInfo.innerHTML = priceInfoText;
    	  const stayingPrice = pricePerDay * night;
    	  stayingFee.innerHTML = "$" + stayingPrice + " AUD";
    	  const servicePrice = 10 * night;
    	  serviceFee.innerHTML = "$" + servicePrice + " AUD";
    	  totalPrice = stayingPrice + servicePrice
    	  totalFee.innerHTML = "$" + totalPrice + " AUD";
      }
      const bookingForm = document.getElementById("booking-form");
      bookingForm.addEventListener("submit", event => {
    	  if (!elem.value && !elem2.value) {
    		  const warning = document.getElementById("missing-dates");
    		  warning.classList.remove("hidden");
    		  event.preventDefault();
    	  } else {
    		  const priceElem = document.getElementById("price-param");
    		  priceElem.value = totalPrice * 100;
    		  const userId = "${sessionScope.userId}";
    		  if (!userId) {
    				showModalHandler();
    				onClickLoginTabHandler();
    				event.preventDefault();
    		  }
    		  
    	  }
      })
     
    </script>
	<script src="./assets/js/reviewFunction.js"></script>
	<script src="./assets/js/ultilities.js"></script>
</body>
</html>
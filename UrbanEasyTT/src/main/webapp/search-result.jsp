<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="">
<meta name="author" content="">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;200;300;400;500;600;700;800;900&display=swap"
	rel="stylesheet">
<link rel="icon" href="assets/images/favicon.png">
<title>UrbanEasy: Your Urban Agency</title>



<!-- Additional CSS Files -->
<script src="assets/js/tailwind.js"></script>
<script src='https://api.mapbox.com/mapbox-gl-js/v2.11.0/mapbox-gl.js'></script>
<link href='https://api.mapbox.com/mapbox-gl-js/v2.11.0/mapbox-gl.css'
	rel='stylesheet' />
<link rel="stylesheet" href="assets/css/fontawesome.css">
<link rel="stylesheet" href="assets/css/templatemo-plot-listing.css">
<script src="https://kit.fontawesome.com/c14056925e.js"
	crossorigin="anonymous"></script>

 <script src='https://cdn.jsdelivr.net/npm/@turf/turf@5/turf.min.js'></script>

<style>
@media screen and (max-width: 55em) {
	footer {
		display: none;
	}
	.sub-footer {
		display: flex;
	}
}
</style>

</head>

<body>
	<jsp:include page="header.jsp">
		<jsp:param name="userId" value="${sessionScope.userId}" />
		<jsp:param name="avatar" value="${sessionScope.avatar }" />
	</jsp:include>


	<div class="flex relative">
		<div class="product-card gridd w-[60%]">

		<c:forEach var="p" items="${product}" varStatus="loop">
			<div class="card2 rounded md " id="property${loop.index}">
				<a
					
					href="<%=request.getContextPath()%>/product-detail?id=${p.getId()}">
					<div class="flexing">
						<img data-src="${p.getUrl()}" src="assets/images/placeholding.jpg"
							onerror="this.style.display='none'" alt="${p.getId()}"
							class="lazy"> <a><img class="layer-hi liked" id="like"
							src="assets/images/favorite-icon.png" alt="heart"
							style="width: 22px; height: 22px"></a>
					</div>
					<div class="info-card">
						<div class="main-name">
							<p>
								<strong><c:out
										value="${p.getCity()}, ${p.getCountry()}" /></strong>
							</p>
							<div class="icon-star">
								<i class="fa fa-star" aria-hidden="true"></i>
								<p>
									<c:out value="${p.getStars()} " />
								</p>
							</div>
						</div>
						<div class="price-info">
							<p class="price" id="price${loop.index}">
								$
								<c:out value="${p.getPrice()}" />
								AUD
							</p>
							<p>/night</p>
						</div>
					</div>
				</a>
			</div>

		</c:forEach>
	</div>
	<div id='map' class="w-[40%] h-screen sticky top-0"></div>
	</div>


	<jsp:include page="footer.jsp" />

	<script>
  const images = document.querySelectorAll('.lazy');
  const options = {
    rootMargin: '0px 0px 50px 0px'
  };

  const observer = new IntersectionObserver(function(entries, observer) {
    entries.forEach(entry => {
      if (entry.isIntersecting) {
    	  console.log()
        const image = entry.target;
        image.src = image.dataset.src;
        observer.unobserve(image);
      }
    });
  }, options);
  images.forEach(image => {
    observer.observe(image);
  });
</script>
	<script>
	const lat = "${lat}";
	const latList = lat.slice(1,-1).split(",");
	const lng = "${lng}";
	const lngList = lng.slice(1,-1).split(",");
	const numbers = [];
	for (let i = 0; i < latList.length; i++) {
		numbers.push(i);
	}; 
	console.log(numbers);
	mapboxgl.accessToken = 'pk.eyJ1IjoiYXBpZXhwbG9yZXIiLCJhIjoiY2xiZzJ4ZmEyMGFrejN2bXV1YXRucnRkMCJ9.3KIUk-IF5zhcKaaPNEyQjQ';
	const map = new mapboxgl.Map(
			{
				container : 'map', // container ID
				style : 'mapbox://styles/apiexplorer/clccutn42000914o552o67bpk', // style URL
				center : [ 10, 10 ], // starting position [lng, lat]
				zoom : 12, // starting zoom			
			});
	var markers = [];
	
	for (let i = 0; i < numbers.length; i++) {
		const el = document.createElement("div");
		el.className = "marker px-2 py-0.5 font-bold bg-slate-200 rounded-full hover:z-10 hover:bg-slate-700 hover:text-white";
		const corElem = document.getElementById('property' + i);
		const priceElem = document.getElementById("price" + i);
		el.innerText = priceElem.innerText;
		el.addEventListener('mouseenter', function () {
		    corElem.classList.add("shadow-2xl");
		  });
		 el.addEventListener('mouseleave', function () {
				corElem.classList.remove("shadow-2xl");
			  });
		 el.addEventListener('click', function () {
			 const aTag = corElem.getElementsByTagName('a')[0];
			 window.location.href = aTag.href;
			 
		 })
		markers.push(new mapboxgl.Marker(el).setLngLat(
				[ lngList[i], latList[i] ]).addTo(map));
	
	}
	  var coordinates = markers.map(function (marker) {
		    return marker.getLngLat().toArray();
		  });

		  // Calculate the center of all coordinates using the Turf.js center method
		  var center = turf.center(turf.featureCollection(coordinates.map(function (coordinate) {
		    return turf.point(coordinate);
		  })));
		  map.setCenter(center.geometry.coordinates);
	

</script>
	<script src="assets/js/owl-carousel.js"></script>
	<script src="assets/js/animation.js"></script>
	<script src="assets/js/imagesloaded.js"></script>
	<script src="assets/js/custom.js"></script>
	<script src="assets/js/signInFunction.js"></script>

	<script src="./assets/js/ultilities.js"></script>
</body>

</html>
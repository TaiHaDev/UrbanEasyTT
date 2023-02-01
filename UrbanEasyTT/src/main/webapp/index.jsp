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
<link rel="stylesheet" href="assets/css/fontawesome.css">
<link rel="stylesheet" href="assets/css/templatemo-plot-listing.css">
<script src="https://kit.fontawesome.com/c14056925e.js"
	crossorigin="anonymous"></script>



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

	<jsp:include page="header.jsp" >
		<jsp:param name="userId" value="${sessionScope.userId}"/>
		<jsp:param name="avatar" value="${sessionScope.avatar }"/>
	</jsp:include>

	<!-- slider categories -->
	<div class="wrapper">

		<div class="icon2">
			<i id="left" class="fa-solid fa-angle-left"></i>
		</div>

		<ul class="tabs-box">

			<li class="tab active" id="${firstCategory.getId()}"><img
				src="${firstCategory.getUrl()}" alt="${firstCategory.getId()}">
				<button class="catebutton" type="${firstCategory.getId()}">

				</button>
				<p>${firstCategory.getName()}</p></li>

			<c:forEach var="ca" items="${categories}">
				<li class="tab " id="${ca.getId()}"><img src="${ca.getUrl()}"
					alt="${ca.getId()}">
					<button class="catebutton" type="${firstCategory.getId()}">

					</button>
					<p>${ca.getName()}</p></li>
			</c:forEach>

		</ul>
		<div class="icon2">
			<i id="right" class="fa-solid fa-angle-right"></i>

		</div>

		<!-- <button class="button-23" role="button">Filter</button> -->
	</div>

	<div class="product-card gridd"
		id="${firstProduct.get(0).getCategoryID()}">

		<c:forEach var="p" items="${firstProduct}">
			<div class="card2">
				<a
					href="<%=request.getContextPath()%>/product-detail?id=${p.getId()}">
					<div class="flexing">
						<img data-src="${p.getUrl()}" src="assets/images/placeholding.jpg" onerror="this.style.display='none'" alt="${p.getId()}" class="lazy"> <a><img
							class="layer-hi liked" id="like"
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
						<p>Viewed 22,424 times last week</p>
						<p>Jul 30 - Aug 4</p>
						<div class="price-info">
							<p class="price">
								$
					  				<c:out value="${p.getPrice()}" /> AUD
							</p>
							<p>&nbsp night</p>
						</div>
					</div>
				</a>
			</div>

		</c:forEach>
	</div>

	<c:forEach var="productList" items="${products}">
		<!-- product card -->

		<div class="product-card hiddenn"
			id="${productList.get(0).getCategoryID()}">

			<c:forEach var="p" items="${productList}">
				<div class="card2">
					<a
						href="<%=request.getContextPath()%>/product-detail?id=${p.getId()}">
						<div class="flexing">
							<img data-src="${p.getUrl()}" alt="${p.getId()}" src="assets/images/placeholding.jpg" class="lazy"> <a><img
								class="layer-hi liked" id="like"
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
							<p>Viewed 22,424 times last week</p>
							<p>Jul 30 - Aug 4</p>
							<div class="price-info">
								<p class="price">
									$
									<c:out value="${p.getPrice()}" /> AUD
								</p>
								<p>&nbsp night</p>
							</div>
						</div>
					</a>
				</div>

			</c:forEach>

		</div>

	</c:forEach>

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


	<script src="assets/js/owl-carousel.js"></script>
	<script src="assets/js/animation.js"></script>
	<script src="assets/js/imagesloaded.js"></script>
	<script src="assets/js/custom.js"></script>
	<script src="assets/js/signInFunction.js"></script>
	<script src="assets/js/slider.js"></script>
		<script src="./assets/js/ultilities.js"></script>
</body>

</html>
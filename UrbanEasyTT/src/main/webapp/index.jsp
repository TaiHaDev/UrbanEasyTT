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
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    <link rel="icon" href="assets/images/favicon.png">
    <title>UrbanEasy: Your Urban Agency</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Additional CSS Files -->
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-plot-listing.css">
    <script src="https://kit.fontawesome.com/c14056925e.js" crossorigin="anonymous"></script>
    

    
    <style>
      @media screen and (max-width: 55em) {
          footer{
            display: none;
          }
          .sub-footer{
            display: flex;
          }
      }
    </style>
    
  </head>

<body>
	
  <jsp:include page="header.jsp"/>

   <!-- slider categories -->
   <div class="wrapper">
    <div class="icon2"><i id="left" class="fa-solid fa-angle-left"></i></div>
    <ul class="tabs-box">
      <li class="tab active">
        <img src="https://a0.muscache.com/pictures/3b1eb541-46d9-4bef-abc4-c37d77e3c21b.jpg" alt="Amazing views">
        <p>Amazing views</p>
      </li>
      <li class="tab">
        <img src="https://a0.muscache.com/pictures/6ad4bd95-f086-437d-97e3-14d12155ddfe.jpg" alt="Countryside">
        <p>Countryside</p>
      </li>
      <li class="tab">
        <img src="https://a0.muscache.com/pictures/c5a4f6fc-c92c-4ae8-87dd-57f1ff1b89a6.jpg" alt="OMG!">
        <p>OMG!</p>
      </li>
      <li class="tab">
        <img src="https://a0.muscache.com/pictures/50861fca-582c-4bcc-89d3-857fb7ca6528.jpg" alt="Design">
        <p>Design</p>
      </li>
      <li class="tab">
        <img src="https://a0.muscache.com/pictures/10ce1091-c854-40f3-a2fb-defc2995bcaf.jpg" alt="Beach">
        <p>Beach</p>
      </li>
      <li class="tab">
        <img src="https://a0.muscache.com/pictures/732edad8-3ae0-49a8-a451-29a8010dcc0c.jpg" alt="Cabins">
        <p>Cabins</p>
      </li>
      <li class="tab">
        <img src="https://a0.muscache.com/pictures/ee9e2a40-ffac-4db9-9080-b351efc3cfc4.jpg" alt="Tropical">
        <p>Tropical</p>
      </li>
      <li class="tab">
        <img src="https://a0.muscache.com/pictures/3fb523a0-b622-4368-8142-b5e03df7549b.jpg" alt="Amazing pools">

        <p>Amazing pools</p>
      </li>
      <li class="tab">
        <img src="https://a0.muscache.com/pictures/eb7ba4c0-ea38-4cbb-9db6-bdcc8baad585.jpg" alt="Private rooms">

        <p>Private rooms</p>
      </li>
      <li class="tab">
        <img src="https://a0.muscache.com/pictures/51f5cf64-5821-400c-8033-8a10c7787d69.jpg" alt="Hanoks">
        <p>Hanoks</p>
      </li>
      <li class="tab">
        <img src="https://a0.muscache.com/pictures/757deeaa-c78f-488f-992b-d3b1ecc06fc9.jpg" alt="Ski-in/out">
        <p>Ski-in/out</p>
      </li>
      <li class="tab">
        <img src="https://a0.muscache.com/pictures/3726d94b-534a-42b8-bca0-a0304d912260.jpg" alt="Treding">
        <p>Treding</p>
      </li>
      <li class="tab">
        <img src="https://a0.muscache.com/pictures/78ba8486-6ba6-4a43-a56d-f556189193da.jpg" alt="Masions">
        <p>Masions</p>
      </li>
      <li class="tab">
        <img src="https://a0.muscache.com/pictures/c0fa9598-4e37-40f3-b734-4bd0e2377add.jpg" alt="New">
        <p>New</p>
      </li>
      <li class="tab">
        <img src="https://a0.muscache.com/pictures/9a2ca4df-ee90-4063-b15d-0de7e4ce210a.jpg" alt="Off the grid">
        <p>Off the grid</p>
      </li>
      <li class="tab">
        <img src="https://a0.muscache.com/pictures/a4634ca6-1407-4864-ab97-6e141967d782.jpg" alt="Lake">
        <p>Lake</p>
      </li>
      <li class="tab">
        <img src="https://a0.muscache.com/pictures/248f85bf-e35e-4dc3-a9a1-e1dbff9a3db4.jpg" alt="Top of the world">
        <p>Top of the world</p>
      </li>
      <li class="tab">
        <img src="https://a0.muscache.com/pictures/4d4a4eba-c7e4-43eb-9ce2-95e1d200d10e.jpg" alt="Tree houses">
        <p>Tree houses</p>
      </li>
      <li class="tab">
        <img src="https://a0.muscache.com/pictures/5ed8f7c7-2e1f-43a8-9a39-4edfc81a3325.jpg" alt="Bed & breakfast">
        <p>Bed & breakfast</p>
      </li>
      <li class="tab">
        <img src="https://a0.muscache.com/pictures/f0c5ca0f-5aa0-4fe5-b38d-654264bacddf.jpg" alt="Play">
        <p>Play</p>
      </li>
      <li>
        
      </li>
    </ul>
  <div class="icon2"><i id="right" class="fa-solid fa-angle-right"></i></div>



    <!-- <button class="button-23" role="button">Filter</button> -->
  </div>


  <!-- product card -->
  <div class="product-card">
	<c:forEach var="p" items="${products}">
		<div class="card2">
		<a href="<%=request.getContextPath()%>/product-detail?id=${p.getId()}">
	      <div class="flexing">
	        <img src="${p.getUrl()}" alt="${p.getId()}" >
	        <a><img class="layer-hi liked" id="like" src="assets/images/favorite-icon.png" alt="heart" style="width:22px; height:22px"></a>
	      </div>
	      <div class="info-card">
	        <div class="main-name">
	          <p><strong><c:out value="${p.getCity()}, ${p.getCountry()}"/></strong></p>
	          <div class="icon-star">
	            <i class="fa fa-star" aria-hidden="true"></i>
	            <p><c:out value="${p.getStars()}"/></p>
	          </div>
	        </div>
	        <p>Viewed 22,424 times last week</p>
	        <p>Jul 30 - Aug 4</p>
	        <div class="price-info">
	          <p class="price">$<c:out value="${p.getPrice()}"/></p> 
	          <p>night</p>
	        </div>
	      </div>
	      </a>
	    </div>
    
    </c:forEach>
    
  </div>
  

  <jsp:include page="footer.jsp"/>

    

  <!-- Scripts -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/js/owl-carousel.js"></script>
  <script src="assets/js/animation.js"></script>
  <script src="assets/js/imagesloaded.js"></script>
  <script src="assets/js/custom.js"></script>
  <script src="assets/js/signInFunction.js"></script>
  <script src="assets/js/slider.js"></script>
</body>

</html>
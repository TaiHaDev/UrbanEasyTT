<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   
    <!-- Additional CSS Files -->
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-plot-listing.css">
    <link rel="stylesheet" href="assets/css/swiper-bundle.min.css">
    <script src="https://kit.fontawesome.com/c14056925e.js" crossorigin="anonymous"></script>
    
<title>${userInfo.getName()}</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="mx-8  lg:mx-40 xl:mx-80 my-12">
  <div class="flex justify-between">
<div>
  <p class="font-medium text-3xl">Hi! I am ${userInfo.getName() }</p>
  <p class="font-light text-sm">Joined in ${userInfo.getYear() }</p>
</div>
<img src="${userInfo.getAvatarURL() }" alt="" class="w-24 rounded-full mt-6">
</div>
<div class="flex space-x-3 mb-4">
  <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-7 h-7">
  <path stroke-linecap="round" stroke-linejoin="round" d="M8.25 21v-4.875c0-.621.504-1.125 1.125-1.125h2.25c.621 0 1.125.504 1.125 1.125V21m0 0h4.5V3.545M12.75 21h7.5V10.75M2.25 21h1.5m18 0h-18M2.25 9l4.5-1.636M18.75 3l-1.5.545m0 6.205l3 1m1.5.5l-1.5-.5M6.75 7.364V3h-3v18m3-13.636l10.5-3.819" />
</svg>

  <p>Super Host</p>
</div>
<div class="flex space-x-3 mb-4">
  <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-7 h-7">
  <path stroke-linecap="round" stroke-linejoin="round" d="M11.48 3.499a.562.562 0 011.04 0l2.125 5.111a.563.563 0 00.475.345l5.518.442c.499.04.701.663.321.988l-4.204 3.602a.563.563 0 00-.182.557l1.285 5.385a.562.562 0 01-.84.61l-4.725-2.885a.563.563 0 00-.586 0L6.982 20.54a.562.562 0 01-.84-.61l1.285-5.386a.562.562 0 00-.182-.557l-4.204-3.602a.563.563 0 01.321-.988l5.518-.442a.563.563 0 00.475-.345L11.48 3.5z" />
</svg>


  <p>${totalReviews} Reviews</p>
</div>
<div class="flex space-x-3 pb-4 border-b">
  <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-7 h-7">
  <path stroke-linecap="round" stroke-linejoin="round" d="M9 12.75L11.25 15 15 9.75m-3-7.036A11.959 11.959 0 013.598 6 11.99 11.99 0 003 9.749c0 5.592 3.824 10.29 9 11.623 5.176-1.332 9-6.03 9-11.622 0-1.31-.21-2.571-.598-3.751h-.152c-3.196 0-6.1-1.248-8.25-3.285z" />
</svg>


  <p>Identity verified</p>
</div>
<div>
  <h2 class="text-xl font-medium mt-4">About</h2>
  <p class="py-6 border-b">${userInfo.getAbout() } </p>
</div>
<c:if test="${userInfo.isHost()}">
<div>
  <h2 class="text-xl font-medium mt-4">Torstein's listing</h2>
</div>

<div class="max-w-6xl w-full px-14 swiper">
            <div class="slide-content my-8 md:my-14 overflow-hidden rounded-md">
                <div class="card-wrapper swiper-wrapper">
                    
                   <c:forEach var="property" items="${propertyList}">
                 
                   	<div class="swiper-slide rounded-md">
                        <div class="flex flex-col items-center px-1.5 py-2">
                            <a href="<%=request.getContextPath()%>/product-detail?id=${property.getId()}" class="w-96 p-2">
                                <img  class="rounded-lg" src="${property.getUrl()}" alt="" class="card-img">
                            </a>
                        </div>  
                        <div class="flex flex-col items-center px-1.5 py-2">
                        <div class="flex space-x-1">
                       <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-5 h-5">
  <path fill-rule="evenodd" d="M10.788 3.21c.448-1.077 1.976-1.077 2.424 0l2.082 5.007 5.404.433c1.164.093 1.636 1.545.749 2.305l-4.117 3.527 1.257 5.273c.271 1.136-.964 2.033-1.96 1.425L12 18.354 7.373 21.18c-.996.608-2.231-.29-1.96-1.425l1.257-5.273-4.117-3.527c-.887-.76-.415-2.212.749-2.305l5.404-.433 2.082-5.006z" clip-rule="evenodd" />
</svg>
                        
                         <p >${property.getStars() == 0 ? "NEW" : property.getStars()}</p>
                       </div>
                           
                            <p class="text-sm font-light text-center">${property.getName()}</p>
                        </div>
                    </div>
                   	
                   </c:forEach>
                    
                </div>
            </div>
            <div class="swiper-button-next swiper-navBtn"></div>
            <div class="swiper-button-prev swiper-navBtn"></div>
        </div>
          <!-- Swiper JS -->
    <script src="assets/js/swiper-bundle.min.js"></script>

    <!-- JavaScript -->
    <script src="assets/js/script.js"></script>
    </c:if>
    <div class="flex space-x-2">
    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-6 h-6">
  <path fill-rule="evenodd" d="M10.788 3.21c.448-1.077 1.976-1.077 2.424 0l2.082 5.007 5.404.433c1.164.093 1.636 1.545.749 2.305l-4.117 3.527 1.257 5.273c.271 1.136-.964 2.033-1.96 1.425L12 18.354 7.373 21.18c-.996.608-2.231-.29-1.96-1.425l1.257-5.273-4.117-3.527c-.887-.76-.415-2.212.749-2.305l5.404-.433 2.082-5.006z" clip-rule="evenodd" />
</svg>
    <p>${totalReviews} Reviews</p>
    </div>
    <div class="flex flex-col space-y-4">
    	<c:forEach var="review" items="${reviewList}">
    		<div>
    		<div class="flex items-center justify-between">
    			<div class="flex space-x-2 items-center">
    				<a href="<%=request.getContextPath()%>/user?id=${review.getReviewerId()}"><img src="${review.getUserUrl() }" class="w-14 rounded-full object-fit" /></a>
    				<div >
    					<p class="font-medium" >${review.getUserName()}, ${review.getCity()}, ${review.getCountry()}</p>
    					<p class="font-light text-sm">commented on ${review.getDate() }</p>
    				</div>
    			</div>
    			<a href="<%=request.getContextPath()%>/product-detail?id=${review.getPropertyId()}">
    			<img src="${review.getPropertyUrl() }" class="w-28 rounded-md"/></a>
    			
    		
    		</div>
    			<p class="font-bold text-lg my-2">${review.getPropertyName() }</p>
    			<p class="my-4">${review.getComment()}</p>
    	</div>
    	</c:forEach>
    
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
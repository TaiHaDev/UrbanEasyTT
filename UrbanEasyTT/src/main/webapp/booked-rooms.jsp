<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Bookings - UrbanEasy</title>
<script src="assets/js/tailwind.js"></script>
</head>
<body>
	<jsp:include page="header.jsp" >
		<jsp:param name="userId" value="${sessionScope.userId}"/>
		<jsp:param name="avatar" value="${sessionScope.avatar }"/>
	</jsp:include>
	<main class="px-4 md:mx-10 lg:mx-20 xl:mx-40 2xl:mx-80 lg:px-24">
		<h1 class="text-4xl font-bold py-5 border-b">Trips</h1>
		<c:if test="${bookings.size() == 0 }">
			<div class="flex flex-col space-y-4 items-start py-4 border-b">
			<h2 class="text-2xl font-medium">No trips booked yet...</h2>
			<p class="text-sm">Time to pack up your bag and start exploring the world</p>
			<button class="text-lg bg-white font-medium rounded-md px-5 py-3 border border-slate-800 hover:bg-slate-300"><a href="<%=request.getContextPath()%>/home">Start Searching</a></button>
		</div>
		</c:if>
		<div class="mt-4 mb-8">
			<c:forEach var="booking" items="${bookings}">
			<div class="border my-4 p-3 flex space-x-4 rounded-md hover:bg-slate-100">
			<img src="${booking.propertyUrl}" class="w-52 rounded-md"/>
			<div class="flex flex-col justify-between items-start">
				<p class="font-bold">${booking.name }</p>
				<div class="flex space-x-3"><span class="text-sm font-medium">From: <span class="font-bold">${booking.startDate}</span></span> <span class="text-sm font-medium">To: <span class="font-bold">${booking.endDate }</span></span></div>
				<p class="text-sm">Address: <span class="font-bold">${booking.address }</span></p>
				<p class="text-sm">Status: <span class="font-bold">${booking.status }</span></p>
				<button class="text-lg px-2 py-1 border border-slate-800 rounded-md hover:bg-slate-800 hover:text-white"><a href="<%=request.getContextPath()%>/booking?id=${booking.id}">View More</a></button>
			</div>
		</div>
		</c:forEach>
		</div>


	</main>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
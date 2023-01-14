<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.tailwindcss.com"></script>
<title>UrbanEasy</title>
</head>
<body>
<h1>Home</h1>
<div className="flex flex-wrap space-x-3">

	<c:forEach var="p" items="${products}">
		<div>
			<a href="<%=request.getContextPath()%>/product-detail?id=${p.getId()}">
				<img src="${p.getUrl()}" class="w-32"/>
			
				<p>Location: <c:out value="${p.getCity()}, ${p.getCountry()}"/><p>
			</a>
		</div>
	</c:forEach>
	
</div>


</body>
</html>
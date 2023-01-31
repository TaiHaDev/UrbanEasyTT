<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="icon" href="assets/images/favicon.png">
    <title>Rent your house - Structure</title>
</head>
<body>
    <jsp:include page="header-rent-home.jsp" />

    <div class="structure-content">
        <h1>Which of these best describes your place?</h1>
        <div class="type-rent-house">
        	<c:forEach var="ca" items="${categories}">
	            <button type="button" class="type-rent-house-button" data-value="house">
	                <img src="${ca.getUrl()}" alt="${ca.getId()}">
	                <p>${ca.getName()}</p>
	            </button>
            </c:forEach>
        </div>
    </div>

    <!-- footer -->
    <div class="foot-rent-home">
        <a href="<%=request.getContextPath()%>/rent-house-step1" class="foot-rent-back">
            <button>Back</button>
        </a>
        <a href="<%=request.getContextPath()%>/location">
            <button type="submit" id="submit-selections" disabled class="foot-rent-home-button">Next</button>
        </a>

    </div>
    <!-- footer -->

    <script src="assets/js/map.js"></script>
</body>
</html>
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
    <link rel="stylesheet" 
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
    <title>Choose your amenities</title>
</head>
<body>
    <jsp:include page="header-rent-home.jsp" />

    <div class="structure-content">
        <h1>Tell guests what your place has to offer</h1>
        <span>You can add more amenities after you publish your listing.</span>
        <div class="type-rent-house">
        	<c:forEach var="fa" items="${facilities}">
	            <button class="type-rent-house-button amenities-button" data-value="${fa.getId()}">
	                <i class="${fa.getIcon()}"></i>
	                <p>${fa.getName()}</p>
	            </button>
	         </c:forEach>
            </button>
        </div>
    </div>
    
    <!-- footer -->
    <div class="foot-rent-home">
        <a href="step2.jsp" class="foot-rent-back">
            <button>Back</button>
        </a>
        <a href="<%=request.getContextPath()%>/title">
            <button type="submit" id="verify-amenities" class="foot-rent-home-button">Next</button>
        </a>

    </div>
    <!-- footer -->


    <script src="assets/js/amenities.js"></script>

</body>
</html>
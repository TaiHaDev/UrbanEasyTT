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
    <link rel="stylesheet" 
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
    <title>Choose your amenities</title>
</head>
<body>
    <!-- header -->
    <div class="nav-rent-home">
        <img src="./assets/images/black-logo.png" alt="logo" height="45px"/>
        <div class="nav-button-rent-home ">
            <button class="button-nav-rent ">Questions?</button>
            <button class="button-nav-rent ">Save & exit</button>
        </div>
    </div>
    <!-- header -->

    <div class="structure-content">
        <h1>Tell guests what your place has to offer</h1>
        <span>You can add more amenities after you publish your listing.</span>
        <div class="type-rent-house">
        	<c:forEach var="fa" items="${facilities}">
	            <button class="type-rent-house-button amenities-button" data-value="${ca.getId()}">
	                ${ca.getSvg()}
	                <p>${fa.getName()}</p>
	            </button>
	         </c:forEach>
            </button>
        </div>
    </div>
    
    <!-- footer -->
    <div class="foot-rent-home">
        <a href="<%=request.getContextPath()%>/rent-house-step2" class="foot-rent-back">
            <button>Back</button>
        </a>
        <a href="<%=request.getContextPath()%>/image-upload">
            <button type="submit" id="submit-selections2" disabled class="foot-rent-home-button">Next</button>
        </a>

    </div>
    <!-- footer -->


    <script src="asset/js/map.js"></script>

</body>
</html>
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
    <title>Select total guests</title>
</head>
<body>
    <jsp:include page="header-rent-home.jsp" />

    <div class="container-floor-plan">
        <div class="text-floor-plan">
            <h1>Share some basics about your place</h1>
            <span>You'll add more details later, like bed types.</span>
        </div>
        <div class="amount-floor-plan">
            <div class="amount-guest">
                <span>Guests</span>
                <div>
                    <button class="minus1">-</button>
                    <span class="num1">01</span>
                    <button class="plus1">+</button>
                </div>
            </div>
            <hr>
            <div class="amount-bedrooms">
                <span>Bedrooms</span>
                <div>
                    <button class="minus2">-</button>
                    <span class="num2">01</span>
                    <button class="plus2">+</button>
                </div>
            </div>
            <hr>
            <div class="amount-beds">
                <span>Beds</span>
                <div>
                    <button class="minus3">-</button>
                    <span class="num3">01</span>
                    <button class="plus3">+</button>
                </div>   
            </div>
            <hr>
            <div class="amount-bathrooms">
                <span>Bathrooms</span>
                <div>
                    <button class="minus4">-</button>
                    <span class="num4">01</span>
                    <button class="plus4">+</button>
                </div>
            </div>
        </div>
        
    </div>

    


    <!-- footer -->
    <div class="foot-rent-home">
        <a href="<%=request.getContextPath()%>/location-confirm" class="foot-rent-back">
            <button>Back</button>
        </a>
        <a href="step2.jsp">
            <button class="foot-rent-home-button" id="verify-floor-plan">Next</button>
        </a>

    </div>
    <!-- footer -->
	
	<script src="assets/js/floor-plan.js"></script>
	
</body>
</html>
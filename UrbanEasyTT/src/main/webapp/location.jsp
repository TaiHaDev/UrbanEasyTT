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
    <title>Enter the location</title>
</head>
<body>
    <jsp:include page="header-rent-home.jsp" />

    <div class="location-content">
        <div class="location-message">
            <h1>Where's your place located?</h1>
            <span>Your address is only shared with guests after they've made a reservation.</span>
        </div>
        <div class="location-api">
            <div class="location-input">
                <input id="address" type="text" class="input-map-search" size="60">
                <input type="button" value="Search" class="button-map-search" onclick="codeAddress()">
            </div>
            <div class="location-map">
                <div id="map"></div>
                <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBqxun3-xLRkE9DdmDb336V48R3iU0UWns&libraries=places&callback=initAutocomplete" async defer></script>
            </div>
        </div>

    </div>

    <!-- footer -->
    <div class="foot-rent-home">
        <a href="<%=request.getContextPath()%>/structure" class="foot-rent-back">
            <button>Back</button>
        </a>
        <a href="<%=request.getContextPath()%>/floor-plan">
            <button class="foot-rent-home-button">Next</button>
        </a>
        
    </div>
    <!-- footer -->
    
	<script src="assets/js/map.js"></script>
</body>
</html>
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
    <title>Confirm your location</title>
</head>
<body>
    <jsp:include page="header-rent-home.jsp" />
	
    <div class="structure-content">
        <h1>Confirm your place address</h1>
        <span>Street number must be correct.</span>
        <form action="location-confirm" method="post" class="location-input" id="location-confirm-form">
        	<div class="address-info">
        		<label>Street number</label>
	        	<input type="text" name="streetNumber" class="input-map-search" value="${streetNumber}" placeholder="Enter your true street number"/>
        	</div>
	        
	        <div class="address-info">
	        	<label>Route</label> 
	        	<input type="text" name="route" class="input-map-search" value="${route}" placeholder="Enter your route" />
	        </div>
	        
	        <div class="address-info">
	        	<label>District (optional)</label> 
	        	<input type="text" name="district" class="input-map-search" value="${district}" placeholder="Enter district (optional)" />
	        </div>
	        
	        <div class="address-info" >
	        	<label>City (State)</label>
	        	<input type="text" name="city" class="input-map-search blur-input" value="${city}" placeholder="Enter city or State" readonly/>
	        </div>
	        
	        <div class="address-info " >
	        	<label>Country</label>
	        	<input type="text" name="country" class="input-map-search blur-input" value="${country}" placeholder="Enter country" readonly/>
        	</div>
        </form>
    </div>
  
    <!-- footer -->
    <div class="foot-rent-home">
        <a href="<%=request.getContextPath()%>/location" class="foot-rent-back">
            <button>Back</button>
        </a>
        <a href="<%=request.getContextPath()%>/floor-plan">
            <button type="submit" class="foot-rent-home-button" form="location-confirm-form">Next</button>
        </a>

    </div>
    <!-- footer -->


</body>
</html>
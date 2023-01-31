<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta name="description" content="Step 1 to rent your house">
	<meta name="author" content="tindaking">
	<link rel="icon" href="assets/images/favicon.png">
    <link rel="stylesheet" href="assets/css/style.css">
    <title>Step 1: Tell us about your place</title>
</head>
<body>
	<jsp:include page="header-rent-home.jsp" />
	
    <div class="rent-home-content">
        <div class="rent-sub-home-content">
            <p>Step 1</p>
            <h1>Tell us about your place</h1>
            <p>In this step, we'll ask you which type of property you have and if guests 
                will book the entire place or just a room. Then let us know the location 
                and how many guests can stay.</p>
        </div>
        <div class="rent-sub-home-content" id="vid-rent">
            <video width="500" autoplay muted>
                <source src="https://stream.media.muscache.com/zFaydEaihX6LP01x8TSCl76WHblb01Z01RrFELxyCXoNek.mp4" type="video/mp4">
            </video>
        </div>
    </div>
    
    <!-- footer -->
    <div class="foot-rent-home">
        <a href="<%=request.getContextPath()%>/home" class="foot-rent-back">
            <button>Back</button>
        </a>
        <a href="<%=request.getContextPath()%>/structure">
            <button class="foot-rent-home-button">Next</button>
        </a>

    </div>
    <!-- footer -->
    
</body>
</html>
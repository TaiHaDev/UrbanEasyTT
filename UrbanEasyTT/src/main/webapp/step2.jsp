<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta name="description" content="Step 2 to rent your house">
	<meta name="author" content="tindaking">
	<link rel="icon" href="assets/images/favicon.png">
    <link rel="stylesheet" href="assets/css/style.css">
    <title>Step 2: Make your place stand out</title>
</head>
<body>
        <jsp:include page="header-rent-home.jsp" />
        
        <div class="rent-home-content">
            <div class="rent-sub-home-content">
                <p>Step 2</p>
                <h1>Make your place stand out</h1>
                <p>In this step, you'll add some of the amenities your place offers,
                     plus 5 or more photos. Then, you'll create a title and description.</p>
            </div>
            <div class="rent-sub-home-content" id="vid-rent">
                <video width="500" autoplay muted>
                    <source src="https://stream.media.muscache.com/H0101WTUG2qWbyFhy02jlOggSkpsM9H02VOWN52g02oxhDVM.mp4?v_q=high" type="video/mp4">
                </video>
            </div>
        </div>
        
        <!-- footer -->
        <div class="foot-rent-home">
            <a href="<%=request.getContextPath()%>/floor-plan" class="foot-rent-back">
                <button>Back</button>
            </a>
            <a href="<%=request.getContextPath()%>/amenities">
                <button class="foot-rent-home-button">Next</button>
            </a>
    
        </div>
        <!-- footer -->
    
</body>
</html>
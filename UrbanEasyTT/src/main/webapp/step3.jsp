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
    <title>Step 3: Finish up and publish</title>
</head>
<body>
        <jsp:include page="header-rent-home.jsp" />
        
        <div class="rent-home-content">
            <div class="rent-sub-home-content">
                <p>Step 3</p>
                <h1>Finish up and publish</h1>
                <p>Finally, you’ll choose if you'd like to start with an experienced guest,
                 then you'll set your nightly price.
                 Answer a few quick questions and publish when you're ready.</p>
            </div>
            <div class="rent-sub-home-content" id="vid-rent">
                <video width="500" autoplay muted>
                    <source src="https://stream.media.muscache.com/KeNKUpa01dRaT5g00SSBV95FqXYkqf01DJdzn01F1aT00vCI.mp4?v_q=high" type="video/mp4">
                </video>
            </div>
        </div>
        
        <!-- footer -->
        <div class="foot-rent-home">
            <a href="<%=request.getContextPath()%>/neighborhood" class="foot-rent-back">
                <button>Back</button>
            </a>
            <a href="<%=request.getContextPath()%>/price">
                <button class="foot-rent-home-button">Next</button>
            </a>
    
        </div>
        <!-- footer -->
    
</body>
</html>
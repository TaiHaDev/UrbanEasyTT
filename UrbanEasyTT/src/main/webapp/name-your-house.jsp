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
    <title>Give your place a title</title>
</head>
<body>
    <jsp:include page="header-rent-home.jsp" />
	
    <div class="structure-content">
        <h1>Now, let's give your apartment a title</h1>
        <span>Short titles work best. Have fun with it, you can always change it later.</span>
        <form action="title" method="post" class="name-title">
            <input type="text" name="name" class="input-map-search" placeholder="Write a cool title here"/>
            <input type="submit" value="Submit" class="button-map-search"/>
        </form>
    </div>
  
    <!-- footer -->
    <div class="foot-rent-home">
        <a href="<%=request.getContextPath()%>/image-upload" class="foot-rent-back">
            <button>Back</button>
        </a>
        <a href="<%=request.getContextPath()%>/description">
            <button type="submit" class="foot-rent-home-button">Next</button>
        </a>

    </div>
    <!-- footer -->



</body>
</html>
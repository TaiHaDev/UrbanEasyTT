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
    <title>Set your price</title>
</head>
<body>
    <jsp:include page="header-rent-home.jsp" />
	
    <div class="structure-content">
        <h1>Now, set your price</h1>
        <span>You can change it anytime.</span>
        <form action="price" method="post" class="name-title" id="form-price">
            <input type="number" min="1"  max="10000" name="price" class="input-map-search" value="${priceSaved}" placeholder="USD per night"/>

        </form>
    </div>
  
    <!-- footer -->
    <div class="foot-rent-home">
        <a href="step3.jsp" class="foot-rent-back">
            <button>Back</button>
        </a>
        <a href="<%=request.getContextPath()%>/congratulation">
            <button type="submit" class="foot-rent-home-button" form="form-price">Next</button>
        </a>

    </div>
    <!-- footer -->


</body>
</html>
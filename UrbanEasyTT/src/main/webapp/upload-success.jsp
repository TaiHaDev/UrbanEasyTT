<%@page import="java.io.File"%>
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
    <title>Congratulations</title>
</head>
<body>
    <jsp:include page="header-rent-home.jsp" />
	
    <div class="structure-content">
        <h1>Congratulations</h1>
        <span>Your house was uploaded, thank you for using UrbanEasy.</span>
        <br>
        <span>You will receive notification when someone rent your place.</span>
        
    </div>
  
    <!-- footer -->
    <div class="foot-rent-home">
        <a href="<%=request.getContextPath()%>/price" class="foot-rent-back">
            <button>Back</button>
        </a>
        <a href="<%=request.getContextPath()%>/home">
            <button type="submit" class="foot-rent-home-button">Finish</button>
        </a>

    </div>
    <!-- footer -->


</body>
</html>
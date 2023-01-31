<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
	<!-- header -->
        <div class="nav-rent-home">
        	<a href="<%=request.getContextPath()%>/home">
            	<img src="./assets/images/black-logo.png" alt="logo" height="45px"/>
            </a>
            <div class="nav-button-rent-home">
            	<a href="question.jsp">
                	<button class="button-nav-rent">Questions?</button>
                </a>
                <a href="<%=request.getContextPath()%>/home">
                	<button class="button-nav-rent">Exit</button>
                </a>
            </div>
        </div>
        <!-- header -->
</body>
</html>
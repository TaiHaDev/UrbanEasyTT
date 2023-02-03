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
        <span>Your house's upload was saved, thank you for using UrbanEasy.</span>
        <br>
        <span>Submit your information by clicking the Finish button.</span>
        <form action="congratulation" method="post" class="name-title" id="insert-database">
        	<input type="text" name="sendpost" value="insert-database"/>
        </form>
    </div>
  
    <!-- footer -->
    <div class="foot-rent-home">
        <a href="<%=request.getContextPath()%>/price" class="foot-rent-back">
            <button>Back</button>
        </a>
        <a href="<%=request.getContextPath()%>/home">
            <button type="submit" class="foot-rent-home-button" form="insert-database">Finish</button>
        </a>

    </div>
    <!-- footer -->


</body>
</html>
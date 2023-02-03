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
    <title>Describe more about the neighborhood</title>
</head>
<body>
    <jsp:include page="header-rent-home.jsp" />
	
    <div class="structure-content">
        <h1>Neighborhood Overview</h1>
        <span>Short titles work best. Have fun with it, you can always change it later.</span>
        <form action="neighborhood" method="post" class="name-title" id="form-neighbor">
            <input type="text" name="neighborhood" class="input-map-search" value="${neighborhoodSaved}" placeholder="Write some overview about your neighborhood"/>
        </form>
  
	</div>
	
	<!-- footer -->
        <div class="foot-rent-home">
            <a href="<%=request.getContextPath()%>/description" class="foot-rent-back">
                <button>Back</button>
            </a>
            <a href="step3.jsp">
                <button type="submit" class="foot-rent-home-button" form="form-neighbor">Next</button>
            </a>
    
        </div>
        <!-- footer -->

</body>
</html>
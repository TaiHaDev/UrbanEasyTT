<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="assets/images/favicon.png">
    <title>An error has occured</title>
</head>
<body>

	<jsp:include page="header-rent-home.jsp" />
	
    <div class="container-error">
        <h1>Error ${error} has occured.</h1>
        <img alt="error gif" src="https://i.gifer.com/origin/78/787899e9d4e4491f797aba5c61294dfc_w200.gif">
        <a href="<%=request.getContextPath()%>/home">Go back</a>
    </div>
    
    <style>
        @import url("https://fonts.googleapis.com/css?family=Montserrat:700");
    .container-error {
        height: 100vh;
        font-family: "Montserrat", "sans-serif";
        font-weight: bolder;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        
    }
    .container-error img{
    	padding: 10px 0px 40px 0px;
    }
    a {
        color: rgb(34, 34, 34);
    }
    </style>
</body>
</html>
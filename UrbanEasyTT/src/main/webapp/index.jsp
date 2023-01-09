<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">

</head>
<body>
 	<a href="<%=request.getContextPath()%>" >Products</a>
                 
	<c:forEach var="product" items="${productList}">
			
		<c:out value="${product.getCity()}" />

	</c:forEach>
</body>
</html>
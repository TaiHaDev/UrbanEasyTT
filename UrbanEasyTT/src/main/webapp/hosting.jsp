<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" 
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
    <link rel="icon" href="assets/images/favicon.png">
    <link rel="stylesheet" href="assets/css/hosting.css">
    <title>Hosing house management</title>
</head>
<body>
	<jsp:include page="header-rent-home.jsp" />

    <div class="container-listing">
        <div class="head-listing">
            <h2>${houseAmount} listings</h2>
        </div>
        <div class="table-container">
            <table class="table-listing">
                <tr>
                    <th class="small-size-col">Listing</th>
                    <th></th>
                    <th>Status</th>
                    <th class="small-size-col">Guests</th>
                    <th class="small-size-col">Bedrooms</th>
                    <th class="small-size-col">Beds</th>
                    <th class="small-size-col">Baths</th>
                    <th>Location</th>
                    <th>View</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <c:forEach var="p" items="${products}">
	                <tr>
	                	
	                    <td class="img-hosting-contain more-space">
	                    	<a href="<%=request.getContextPath()%>/product-detail?id=${p.getId()}">
	                    		<img class="img-hosting" src="${p.url}" alt="${p.id}">
	                    	</a>
	                    </td>
	                    <td>${p.name}</td> 
	                    <td class="more-space">${p.status}</td>
	                    <td>${p.guest}</td>
	                    <td>${p.bedroom}</td>
	                    <td>${p.bed}</td>
	                    <td>${p.bath}</td>
	                    <td>${p.city}, ${p.country}</td>
	                    <td>${p.view}</td>
	                    <td class="edit-listing"><i class="fa-regular fa-pen-to-square"></i></td>
	                    <td class="erase-listing">
	                    	<i class="delete-icon fa-regular fa-trash-can"></i>
		                    
			                <div class="confirm-popup popup hiddenn" href="#">
					            <div class="popup-content">
					            	<h4>Are you sure delete this house? Cannot recover renting history, and ratings.</h4>
					            	<form action="hosting" method="post" class="name-title hiddenn" id="${p.id}" name="${p.id}">  
			                    		<input type="text" class="hiddenn" name="delete" value="${p.id}" form="${p.id}"/>
					                	
					                </form> 
					                <button type="submit" class="button-danger" form="${p.id}" >Yeah I'm sure</button>
					                <a href="<%=request.getContextPath()%>/hosting" class="close">x</a>
					        	</div>
					        </div>
	                    </td>
	                	
	                </tr>
                </c:forEach>
                
                
            </table>
        </div>
    </div>
    
    <jsp:include page="footer.jsp" />
    <script src="assets/js/hosting.js"></script>
  
</body>
</html>
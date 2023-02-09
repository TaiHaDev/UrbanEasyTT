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
	<jsp:include page="header.jsp" />

    <div class="container-listing">
        <div class="head-listing">
            <h2>27 listings</h2>
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
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <tr>
                    <td></td>
                    <td>Wonderful house 933</td>
                    <td><i class="fa-solid fa-circle-check green-dot"></i>&nbsp Free</td>
                    <td>4</td>
                    <td>2</td>
                    <td>3</td>
                    <td>1</td>
                    <td>Sydney, Australia</td>
                    <td class="edit-listing"><i class="fa-regular fa-pen-to-square"></i></td>
                    <td class="erase-listing"><i class="fa-regular fa-trash-can"></i></td>
                </tr>
                <tr>
                    <td></td>
                    <td>Wonderful house 851</td>
                    <td><i class="fa-solid fa-circle-check grey-dot"></i>&nbsp Booked</td>
                    <td>4</td>
                    <td>2</td>
                    <td>3</td>
                    <td>1</td>
                    <td>Saigon, Vietnam</td>
                    <td class="edit-listing"><i class="fa-regular fa-pen-to-square"></i></td>
                    <td class="erase-listing"><i class="fa-regular fa-trash-can"></i></td>
                </tr>
            </table>
        </div>
    </div>
    
    <jsp:include page="footer.jsp" />
</body>
</html>
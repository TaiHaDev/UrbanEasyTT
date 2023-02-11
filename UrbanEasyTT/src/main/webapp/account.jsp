<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/account.css">
    <link rel="icon" href="assets/images/favicon.png">
    <title>Your account</title>
</head>
<body>
	<jsp:include page="header-rent-home.jsp" />

    <div class="account-container">
        <div class="avatar-info">
            <img src="${user.avatarURL}" alt="${user.name}">
            <div class="change-avatar">
                <button onclick="openForm()"> Change avatar</button>
  
            </div>
            <hr>
            <div class='flexing'>
            	<h3>${user.name}</h3>
            	<h3>confirmed</h3>
            </div>
            
            <div class="email-confirm">
                <svg viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg" style="display:block;height:16px;width:16px;fill:currentColor" aria-hidden="true" role="presentation" focusable="false">
                <path d="M13.102 2.537L15.365 4.8l-9.443 9.443L.057 8.378 2.32 6.115l3.602 3.602z"></path></svg>
                <p> &nbsp Email confirmed</p>
            </div>
        </div>

        <div class="form-popup" id="myForm">
            <form method="post" action="account" enctype="multipart/form-data" >
                <input type="file" name="file" multiple accept=".png,.jpeg,.jpg,.bmp,.webp,.pjeg"/>
                <input type="submit" value="Upload"/>
                <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
            </form>
        </div>
        
        <div class="info-user">
            <h1><b>Hi, I'm ${user.name}</b>  </h1>
            <p>Join in ${user.year}</p>
            <ul>
                <li><b>Phone number: ${user.phone}</b></li>
                <li><b>Email: ${user.email}</b></li>
            </ul>
            <div class="change-info" id="change-info">
                <form method="post" action="account" >
                    <label>New user name</label>
                    <input type="text" name="userName" placeholder="Enter new name"  value="${user.name}" required/> 
                    <label>New phone number</label>
                    <input type="text" name="phoneNum" placeholder="Enter new phone number"  value="${user.phone}" required/> 
                    <label>New email</label>
                    <input type="text" name="email" placeholder="Enter new email"  value="${user.email}" required/> 
                    <input type="submit" value="Update"/>
                    <button type="button" onclick="closeForm2()">Close</button>
                    
                </form>
            </div>
            
            <button onclick="openForm2()"> Change information</button>
        </div>
        
    </div>
    
    <jsp:include page="footer.jsp" />
    <script src="assets/js/account.js"></script>

</body>
</html>
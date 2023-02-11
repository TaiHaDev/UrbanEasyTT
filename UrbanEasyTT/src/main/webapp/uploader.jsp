<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="icon" href="assets/images/favicon.png">
    <title>Photo Uploader</title>
</head>
<body>

	<jsp:include page="header-rent-home.jsp" />
	
	<div class="uploader-div">
		<h1>Final step</h1>
		<h1>Upload as least 5 images</h1>
	    <span>Images should show the overview and details of your place</span>
		<div class="container-upload">
			
			<div class="upload">
				<form method="post" action="image-upload" enctype="multipart/form-data" id="upload-form">
					<input type="file" name="file" multiple accept=".png,.jpeg,.jpg,.bmp,.webp,.pjeg"/>
				</form>
			</div>
			<div class="photo-container"></div>
		</div>
	</div>
	
	  
	 <!-- footer -->
    <div class="foot-rent-home">
        <a href="<%=request.getContextPath()%>/amenities" class="foot-rent-back">
            <button>Back</button>
        </a>
        <a href="<%=request.getContextPath()%>/title">
            <button type="submit" id="submit-selections" class="foot-rent-home-button" form="upload-form">Next</button>
        </a>
    </div>
    <!-- footer -->
    
    <script>
    const fileInput = document.querySelector('input[type="file"]');
    const submitButton = document.querySelector('#submit-selections');
    const photoContainer = document.querySelector('.photo-container');
    let selectedFiles = [];

    fileInput.addEventListener('change', (event) => {
        selectedFiles = [...event.target.files];
        console.log(selectedFiles);
        if(selectedFiles.length >= 5 && selectedFiles.length <= 10) {
            submitButton.removeAttribute('disabled');
        } else {
            submitButton.setAttribute('disabled', 'disabled');
            alert("Upload as least 5, and less than 10 images should be best ^^");
        }

        createImageElements(selectedFiles);
    });
    
    const createImageElements = (files) => {
        photoContainer.innerHTML = '';
        files.forEach(file => {
            const reader = new FileReader();
            reader.onload = (event) => {
                const img = document.createElement('img');
                img.src = event.target.result;
                photoContainer.appendChild(img);
            };
            reader.readAsDataURL(file);
        });
    };

    submitButton.addEventListener('click', () => {
        let img = document.getElementById("verify-location");

        img.addEventListener('click', function() {
            console.log("nho doi url project thanh TT");
            fetch("http://localhost:8080/UrbanEasyTT/image-upload", {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(selectedFiles.length)
        });
        });
    });
    </script>
</body>
</html>
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
	
	
	<div class="container-upload">
		<div class="upload">
			<form method="post" action="image-upload" enctype="multipart/form-data">
			<input type="file" name="file" multiple accept=".png,.jpeg,.gif,.jpg"/>
			<input type="submit" value="Upload"/>
			</form>
		</div>
		<div class="photo-container"></div>
	</div>
	
	  <!-- Ajax to Java File Upload Logic -->
	  <script>
	  async function uploadFile() {
	    let formData = new FormData(); 
	    formData.append("file", ajaxfile.files[0]);
	    await fetch('fileuploadservlet', {
	      method: "POST", 
	      body: formData
	    }); 
	    alert('The file upload with Ajax and Java was a success!');
	  }
	  </script>
	 <!-- footer -->
    <div class="foot-rent-home">
        <a href="<%=request.getContextPath()%>/amenities" class="foot-rent-back">
            <button>Back</button>
        </a>
        <a href="<%=request.getContextPath()%>/title">
            <button type="submit" id="submit-selections" class="foot-rent-home-button">Next</button>
        </a>

    </div>
    <!-- footer -->
</body>
</html>
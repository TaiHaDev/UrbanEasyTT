<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Photo Uploader</title>
</head>
<body>
	<form method="post" action="image-upload" enctype="multipart/form-data">
		<input type="file" name="file"/>
		<input type="submit" value="Upload"/>
	</form>

	<!-- HTML5 Input Form Elements -->
	  <input id="ajaxfile" type="file"/> <br/>
	  <button onclick="uploadFile()"> Upload </button>
	
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
</body>
</html>
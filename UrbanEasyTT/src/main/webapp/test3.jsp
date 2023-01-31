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
    <style>
        body {
            background-color: #f2f2f2;
            width: 450px;
            margin: 0 auto;
            font-family: sans-serif;
            padding: 15px;
        }

        .upload {
            padding: 20px 0;
            text-align: center;
        }

        .upload input[type="file"] {
            background-color: #f2f2f2;
            border: none;
            margin-top: 20px;
        }

        .upload button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 12px 30px;
            margin: 20px 0;
            cursor: pointer;
        }

        .upload button:hover {
            background-color: #45a049;
        }

        .photo-container {
            display: flex;
            flex-direction: column;
            padding: 0 15px;
            margin-bottom: 10px;
        }

        .photo-container img {
            width: 100%;
            margin-bottom: 15px;
        }
    </style>
</head>

<body>
    <div class="upload">
        <input type="file" accept="image/jpg, image/jpeg, image/gif, image/png" multiple />
        <button type="button" disabled>Submit</button>
    </div>
    <div class="photo-container"></div>

    <script>
        const fileInput = document.querySelector('input[type="file"]');
        const submitButton = document.querySelector('button');
        const photoContainer = document.querySelector('.photo-container');
        let selectedFiles = [];

        fileInput.addEventListener('change', (event) => {
            selectedFiles = [...event.target.files];

            if(selectedFiles.length >= 5) {
                submitButton.removeAttribute('disabled');
            } else {
                submitButton.setAttribute('disabled', 'disabled');
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
            const formData = new FormData();

            for(let i = 0; i < selectedFiles.length; i++) {
                formData.append('image', selectedFiles[i]);
            }

            fetch('upload/url', {
                method: 'POST',
                body: formData
            })
            .then(res => res.json())
            .then(data => {
                const urls = data.map(img => img.url);
                console.log(urls);
            })
            .catch(err => console.log(err));
        });
    </script>
</body>
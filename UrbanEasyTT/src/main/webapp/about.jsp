<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
	<link rel="icon" href="assets/images/favicon.png">
    <link rel="stylesheet" href="assets/css/about.css">

    <title>About Us Page</title>
</head>
<body>
	<jsp:include page="header-rent-home.jsp" />
    <!-- Home section starts -->
    <section class="home" id="home">
        
        <div class="container">
            <div class="contentBx">
                <h1>Explore more about UrbanEasy</h1>
                <p>We are developing the best house renting web app for everyone.
                     <br> to utilize and create impact.</p>
            </div>
            <div class="imgBx">
                <img src="assets/images/favicon.png" alt="logo">
            </div>
        </div>
    </section>
    <!-- Home section ends -->


    <!-- About R&B section starts -->
    <section class="rab" id="rab">
        <h2 class="section__title">What is UrbanEasy</h2>
        <div class="grid">
            <div class="imageBx">
                <img src="assets/images/logo.png" alt="Scientist">
            </div>
            <div class="contentBx">
                <div class="description">
                    <p>
                        UrbanEasy is a platform for people to list and rent out their homes or other properties to guests. It is an online marketplace where people can list and rent short-term lodging, including vacation rentals, apartment rentals, homestays, hostel beds, or hotel rooms.
                    </p>
                    <div class="subsection">
                        <h3>Urban</h3>
                        <p>Stand for users, houses, places.</p>
                    </div>
                    <div class="subsection">
                        <h3> Easy</h3>
                        <p>This is what we want to improve the house renting experience. More easy, more flexible. </p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- About R&B section ends -->

    <!-- Our Story section starts -->
    <section class="ourstory" id="ourstory">
        <h2 class="section__title">How UrbanEasy Work</h2>
        <div class="grid">
            <div class="contentBx">
                <div class="description">
                    <p>
                        UrbanEasy works by connecting travelers to hosts who list their properties on the platform. Hosts list their properties on the platform, including photos, descriptions, and pricing information. Travelers can browse, search, and book properties on UrbanEasy directly through the platform.
                    </p>
      
                    <div class="subsection">
                        <h3> What we do? </h3>
                        <p>UrbanEasy is based on a peer-to-peer business model. This makes it simple, easy to use, and tends to be more profitable for both parties. The model also gives you the opportunity to customize and personalize your guests' experience the way you want.</p>
                    </div>
                    <div class="subsection">
                        <h3> If you have a place </h3>
                        <p>Whether you own a bed & breakfast or a vacation rental company, your reservation system can be integrated right into Airbnb. Many of these integrations will sync content, rates, and availability, so you can manage your content on UrbanEasy. </p>
                    </div>
                </div>
            </div>
            
            <div class="imageBx">
                <img src="assets/images/house.png" alt="Scientist">
            </div>
        </div>
    </section>
    <!-- Our Story section ends -->

   
    <!-- Our Mission section starts -->
    <section class="ourmission" id="ourmission">
        <h2 class="section__title">What are the benefits of UrbanEasy?</h2>
        <div class="grid">
            <div class="imageBx">
                <img src="assets/images/house2.png" alt="Scientist">
            </div>

            <div class="contentBx">
                <div class="description">
                    <div class="subsection">
                        <h3> Here are some outstanding advantages.  </h3>
                        <p>Affordable accommodations in desirable locations</p>
                        <p>Unique and memorable experiences</p>
                        <p>Opportunity to meet new people</p>
                        <p>Help support local economies</p>
                        <p>Flexible rental options</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Our Mission section ends -->

    <!-- Who Are We section starts -->
    <section class="who" id="who">
        <h2>Our team</h2>
        <div class="container">
            <div class="box">
                <div>
                    <img src="assets/images/tai.jpg" alt="">
                    <div class="content">
                        <h3> Thanh <br> Tai</h3>
                        <p>Designer / Full-stack developer</p>
                    </div>
                </div>
            </div>
            
            <div class="box">
                <div>
                    <img src="assets/images/tin.jpg" alt="">
                    <div class="content">
                        <h3> Hoang <br> Tin</h3>
                        <p>Full-stack developer / Designer</p>
                    </div>
                </div>
            </div>

            
        </div>

        <div class="image1">
            <img src="assets/images/TopRight.png" alt="">
        </div>
        <div class="image2">
            <img src="assets/images/BottomLeft.png" alt="">
        </div>
    </section>
    <!-- Who Are We section ends -->

    <!-- Map + Join us section starts -->
    <section class="job-map" id="job-map">
        
        <!-- Join Us Section starts -->
        <div class="job_wrapper">
            <div>
                <details>
                    <summary>Technology</summary>
                    <p>Our Technologies:</p>
                    <ul>
                        <li>Java Servlet MVC, Web API</li>
                        <li>Languages: Java, HTML, CSS, JavaScript, SQL</li>
                        <li>OOP, Design Pattern</li>
                        <li>Workspace: Eclipse, IntelliJ, MySQL, Visual Code, Trello, Google's tools, GitHub, Diagram.net</li>
                    </ul>
                </details>
            </div>

            <div>
                <details>
                    <summary>Main features</summary>
                    <p>Some main features:</p> 
                    <ul>
                        <li>Show houses from database</li>
                        <li>Log in, log out, sign up</li>
                        <li>Show house's detail</li>
                        <li>Upload house for rent</li>
                        <li>Payment</li>
                        <li>Filter houses</li>
                        <li>Searching</li>
                        <li>Booking</li>
                    </ul>
                </details>
            </div>

            <div>
                <details>
                    <summary>Design</summary>
                    <p>Web UI/UX Design and Database design:</p> 
                    <ul>
                        <li>UI/UX design inspired by Airbnb</li>
                        <li>Database design normalization to 3nf</li>
                    </ul>
                </details>
            </div>
        </div>
        <!-- Join Us Section ends -->

    </section>
    <!-- Map + Join us section ends -->

    <!-- Gsap CDN Links -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.11.3/gsap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.11.3/ScrollTrigger.min.js"></script>
    <!-- Js File -->
</body>
</html>
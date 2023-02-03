<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="icon" href="assets/images/favicon.png">
    <title>Select total guests</title>
</head>
<body>
    <jsp:include page="header-rent-home.jsp" />

    <div class="container-floor-plan">
        <div class="text-floor-plan">
            <h1>Share some basics about your place</h1>
            <span>You'll add more details later, like bed types.</span>
        </div>
        <div class="amount-floor-plan">
            <div class="amount-guest">
                <span>Guests</span>
                <div>
                    <button class="minus1">-</button>
                    <span class="num1">01</span>
                    <button class="plus1">+</button>
                </div>
            </div>
            <hr>
            <div class="amount-bedrooms">
                <span>Bedrooms</span>
                <div>
                    <button class="minus2">-</button>
                    <span class="num2">01</span>
                    <button class="plus2">+</button>
                </div>
            </div>
            <hr>
            <div class="amount-beds">
                <span>Beds</span>
                <div>
                    <button class="minus3">-</button>
                    <span class="num3">01</span>
                    <button class="plus3">+</button>
                </div>   
            </div>
            <hr>
            <div class="amount-bathrooms">
                <span>Bathrooms</span>
                <div>
                    <button class="minus4">-</button>
                    <span class="num4">01</span>
                    <button class="plus4">+</button>
                </div>
            </div>
        </div>
        
    </div>

    


    <!-- footer -->
    <div class="foot-rent-home">
        <a href="<%=request.getContextPath()%>/location" class="foot-rent-back">
            <button>Back</button>
        </a>
        <a href="step2.jsp">
            <button class="foot-rent-home-button" id="verify-floor-plan">Next</button>
        </a>

    </div>
    <!-- footer -->
	
	<script>
        const plus1 = document.querySelector(".plus1"),
        minus1 = document.querySelector(".minus1"),
        num1 = document.querySelector(".num1");
        let a = 1;
        plus1.addEventListener("click", ()=>{
            a++;
            a = (a < 10) ? "0" + a : a;
            num1.innerText = a;
            console.log(a)
        });
    
        minus1.addEventListener("click", ()=>{
        if(a > 1){
            a--;
            a = (a < 10) ? "0" + a : a;
            num1.innerText = a;
            console.log(a)

        }
        });

        const plus2 = document.querySelector(".plus2"),
        minus2 = document.querySelector(".minus2"),
        num2 = document.querySelector(".num2");
        let b = 1;
        plus2.addEventListener("click", ()=>{
            b++;
            b = (b < 10) ? "0" + b : b;
            num2.innerText = b;
            console.log(b)
        });
    
        minus2.addEventListener("click", ()=>{
        if(b > 1){
            b--;
            b = (b < 10) ? "0" + b : b;
            num2.innerText = b;
            console.log(b)

        }
        });
    
        const plus3 = document.querySelector(".plus3"),
        minus3 = document.querySelector(".minus3"),
        num3 = document.querySelector(".num3");
        let c = 1;
        plus3.addEventListener("click", ()=>{
            c++;
            c = (c < 10) ? "0" + c : c;
            num3.innerText = c;
            console.log(c)
        });
    
        minus3.addEventListener("click", ()=>{
        if(c > 1){
            c--;
            c = (c < 10) ? "0" + c : c;
            num3.innerText = c;
            console.log(c)

        }
        });
    
        const plus4 = document.querySelector(".plus4"),
        minus4 = document.querySelector(".minus4"),
        num4 = document.querySelector(".num4");
        let d = 1;
        plus4.addEventListener("click", ()=>{
            d++;
            d = (d < 10) ? "0" + d : d;
            num4.innerText = d;
            console.log(d)
        });
    
        minus4.addEventListener("click", ()=>{
        if(d > 1){
            d--;
            d = (d < 10) ? "0" + d : d;
            num4.innerText = d;
            console.log(d)

        }
        });
    	
        
        
        var el = document.getElementById("verify-floor-plan");

        el.addEventListener('click', function() {
        	let floorPlan ={};
        	floorPlan.guest=a;
            floorPlan.bedroom=b;
            floorPlan.bed=c;
            floorPlan.bathroom=d;
        	
        	fetch("http://localhost:8080/UrbanEasyTT/floor-plan", {
				method: 'POST',
				headers: {
					'Accept': 'application/json',
					'Content-Type': 'application/json'
				},
				body: JSON.stringify(floorPlan)
			});
        });
    </script>
	
</body>
</html>
const HTTP_URL = "http://localhost:8080/UrbanEasyTT/";


const button = document.getElementById("remove-button");

const modal = document.getElementById("modal");
const loginButton = document.getElementById("login-button");
const body = document.getElementsByTagName('body')[0];
const upper = document.getElementById("upper");
const signupButton = document.getElementById("signup-button");

const showModalHandler = () => {
   modal.classList.remove("hidden");
    body.classList.add("overflow-hidden");
  
}
const hideModalHandler = () => {
    modal.classList.add("hidden");
    body.classList.remove("overflow-hidden");
} 

// change login form to sign up form
const loginForm = document.getElementById("login-form");
const signupForm = document.getElementById("signup-form");
const loginFormTab = document.getElementById("login-tab");
const signupTab = document.getElementById("signup-tab");
const onClickLoginTabHandler = event => {
	loginFormTab.classList.add("bg-blue-600", "text-white");
	signupTab.classList.remove("bg-blue-600", "text-white");
	loginForm.classList.remove("hidden");
	signupForm.classList.add("hidden");
}

const onClickSignupTabHandler = event => {
	loginFormTab.classList.remove("bg-blue-600", "text-white");
	signupTab.classList.add("bg-blue-600", "text-white");
	loginForm.classList.add("hidden");
	signupForm.classList.remove("hidden");
}
signupButton.addEventListener("click", event => {
	showModalHandler();
	onClickSignupTabHandler();
})
loginButton.addEventListener('click', event => {
	showModalHandler();
	onClickLoginTabHandler();
});
button.addEventListener('click', hideModalHandler);
signupTab.addEventListener("click", onClickSignupTabHandler);
loginFormTab.addEventListener("click", onClickLoginTabHandler);

const reopenLoginForm = () => {
	const currentUrl = new URL(window.location.href);
	// Get the search parameters from the URL
	const searchParams = new URLSearchParams(currentUrl.search);
	// Get the value of a specific parameter
	const reValue = searchParams.get("re");
	if (reValue == "true") {
		showModalHandler();
		onClickLoginTabHandler();
	}
}
reopenLoginForm();
const checkEmail = async (email, password, name) => {
	let data = {
		email,
		name,
		password,
	}
	const response = await fetch("http://localhost:8080/UrbanEasyTT/SignupServlet", {
		method: 'POST',
		headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
	});
	const json = await response.json();
	return json;
}
signupFormOnSubmitHandler = async event => {
	event.preventDefault();
	const email = document.getElementById("signup-email");
	const password = document.getElementById("signup-password");
	const name = document.getElementById("name");
	const confirmedPassword = document.getElementById("signup-confirmed-password");
	const passwordError = document.getElementById("password-error");
	const emailError = document.getElementById("email-error");
	const response = await checkEmail(email.value, password.value, name.value);
	let isErrored = false;
	emailError.classList.add("hidden");
	passwordError.classList.add("hidden");
	if (response == "email false") {
		emailError.classList.remove("hidden");
		isErrored = true;
	}
	if (password.value !== confirmedPassword.value) {
		passwordError.classList.remove("hidden");
		isErrored = true;
	}
	if (!isErrored) {
		console.log(response);
		const verificationEmail = document.getElementById("verification-email");
		verificationEmail.innerText = email.value;
		upper.classList.add("hidden");
		const container = document.getElementById("email-verification");
		container.classList.remove("hidden");
		addSubmitVerificationHandler(response, email.value, password.value);
	}
}

signupForm.addEventListener("submit", signupFormOnSubmitHandler);

const addSubmitVerificationHandler = (verificationId, email, password) => {
	const container = document.getElementById("email-verification")
const verificationCodes = document.querySelectorAll(".verification-code")
container.addEventListener("keydown", async event => {
	if (event.key === "Enter") {
		let numbers = '';
		let isNotEmpty = true;
		verificationCodes.forEach(node => {
			if (node.value == '') {
				isNotEmpty = false;
			} 
			numbers += node.value
		})
		if (isNotEmpty) {
			const uri = HTTP_URL + "VerificationServlet" + "?id=" + verificationId + "&codes=" + numbers;
			const rawResponse = await fetch(uri);
			const response = await rawResponse.json();
			if (response == "ok") {
				const signinEmail = document.getElementById("email");
				const signinPassword = document.getElementById("password");
				signinEmail.value = email;	
				signinPassword.value = password;
				loginForm.submit()
			}	
		}
	}
})
}


/*
var usernameLogIn = document.querySelector('#exampleInputEmail1');
var passwordLogIn = document.querySelector('#exampleInputPassword1');

var usernameSignUp = document.querySelector('#email1');
var nameSignUp = document.querySelector('#nameInput');
var passwordSignUp1 = document.querySelector('#password1');
var passwordSignUp2 = document.querySelector('#password2');

var formLogin = document.querySelector('#form-login');
var formRegister = document.querySelector("#form-register")

function showError(input, message){
    let parent = input.parentElement;
    let small = parent.querySelector('small')
    parent.classList.add('error')
    small.innerText = message
}

function showSuccess(input){
    let parent = input.parentElement;
    let small = parent.querySelector('small')
    parent.classList.remove('error')
}

function checkEmpty(listInput){
    let isEmptyError = true;
    listInput.forEach(input => {
        input.value = input.value.trim()
        if(!input.value){
            isEmptyError = false;
            showError(input, 'Must be filled')
        }else{
            showSuccess(input)
        }
    });
    return isEmptyError
}

function checkEmail(input){
    const regexEmail = 
        /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
    input.value=input.value.trim()

    let isEmailError = regexEmail.test(input.value)
    if(isEmailError){
        showSuccess(input)
    } else{
        showError(input,"Email invalid")
    }

    return isEmailError
}

function checkPassword(input){
    input.value = input.value.trim()

    if(input.value.length < 8 ){
        showError(input, "Must be more than 8 characters")
        return false
    }
    if (input.value.length >36 ) {
        showError(input, "Must be more less than 36 characters")
        return false
    }
    var passw=  /^[A-Za-z]\w{7,14}$/;
    if(input.value.match(passw)) {
        
    }
    else{
        showError(input, "Must not have special character")
        return false;
    }


    showSuccess(input)
    return true
}

function checkConfirmPassword(pass1, pass2) {
    pass1.value = pass1.value.trim()
    pass2.value = pass2.value.trim()
    if(pass1.value != pass2.value){
        showError(pass2, "Must be the same with previous password")
        return false
    }
    return true
}

formLogin.addEventListener('submit', function(e){
    e.preventDefault()
    let isEmpty = checkEmpty([usernameLogIn,passwordLogIn])

    if(!isEmpty) {
        // do nothing
    }
    else {
        // backend handle
    }
})

formRegister.addEventListener('submit', function(e){
    e.preventDefault()
    
    let isLegitEmail = checkEmail(usernameSignUp)
    let passwordLegit = checkPassword(passwordSignUp1)
    let passwordConfirm = checkConfirmPassword(passwordSignUp1, passwordSignUp2)
    let isEmpty = checkEmpty([usernameSignUp, nameSignUp, passwordSignUp1, passwordSignUp2])

    if(!isEmpty || !isLegitEmail || !passwordLegit || !passwordConfirm) {
        // do nothing
    }
    else {
        // backend handle
    }
}) 
*/
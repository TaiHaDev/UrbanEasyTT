<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Additional CSS Files -->
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-plot-listing.css">
    <script src="https://kit.fontawesome.com/c14056925e.js" crossorigin="anonymous"></script>
    
    
</head>
<body>
	  <!--Sign-in section -->
    <div class="sign-in-modal">
		
      <div class="backdrop">
        
      </div>
      <div class="sign-in-form mb-3">
        <div class="sign-in-header">
          <button id="remove-button">
            <i class="fa-solid fa-xmark"></i></button>
          <div>Log in or Sign up</div>
        </div>
          <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
            <li class="nav-item" role="presentation">
              <button class="nav-link active" id="pills-home-tab" data-bs-toggle="pill" data-bs-target="#pills-home" type="button" role="tab" aria-controls="pills-home" aria-selected="true">Log in</button>
            </li>
            <li class="nav-item" role="presentation">
              <button class="nav-link" id="pills-profile-tab" data-bs-toggle="pill" data-bs-target="#pills-profile" type="button" role="tab" aria-controls="pills-profile" aria-selected="false">Sign up</button>
            </li>
          </ul>
        <div class="tab-content" id="pills-tabContent">
          <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
            <form id="form-login">
              <h5>Welcome back to UrbanEasy</h5>
              <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Email address</label>
                <input type="email" class="form-control error" id="exampleInputEmail1" placeholder="name@email.com" aria-describedby="emailHelp">
                <small></small>
              </div>
              <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Password</label>
                <input type="password" class="form-control" placeholder="Enter your password" id="exampleInputPassword1">
                <small></small>
              </div>  
              <div class="mb-3 form-check">
                <input type="checkbox" class="form-check-input" id="exampleCheck1">
                <label class="form-check-label" for="exampleCheck1">Check me out</label>
              </div>
              <div class="text-end">
                <button type="submit" class="btn btn-primary">Submit</button>
              </div>
            </form>
          </div>
          <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">
            <form id="form-register">
              <h5>Welcome to UrbanEasy</h5>
              <div class="mb-3">
                <label for="email1" class="form-label">Email address</label>
                <input type="email" class="form-control" id="email1" placeholder="name@email.com" >
                <small></small>
              </div>
              <div class="mb-3">
                <label for="nameInput" class="form-label">Name</label>
                <input type="text" class="form-control" id="nameInput" placeholder="Input your name here">
                <small></small>
              </div>
              <div class="mb-3">
                <label for="password1" class="form-label">Password</label>
                <input type="password" class="form-control" id="password1" placeholder="Create password">
                <small></small>
              </div>
              <div class="mb-3">
                <label for="password2" class="form-label">Confirm Password</label>
                <input type="password" class="form-control" id="password2" placeholder="Confirm password">
                <small></small>
              </div>
              <div class="mb-3 ">
                <div id="emailHelp" class="form-text">We'll never share your information with anyone else.</div>
              </div>
              <div class="text-end">
                <button type="submit" class="btn btn-primary">Submit</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    
    
  

  <!-- ***** Preloader Start ***** -->
  <div id="js-preloader" class="js-preloader">
    <div class="preloader-inner">
      <span class="dot"></span>
      <div class="dots">
        <span></span>
        <span></span>
        <span></span>
      </div>
    </div>
  </div>
  <!-- ***** Preloader End ***** -->

  <!-- ***** Header Area Start ***** -->
  
  <header
      class="bg-white px-4 sm:px-10 lg:px-24 border-b shadow-sm transition duration-1000"
    >
      <div class="flex h-20 justify-between items-center">
        <img
          src="./assets/images/black-logo.png"
          alt="logo"
          class="hidden h-12 lg:block"
        />
        <img
          src="./assets/images/favicon.png"
          alt="logo"
          class="hidden w-12 sm:block lg:hidden"
        />
        <div
          id="search-bar-small"
          class="border rounded-full py-1 px-2 w-3/4 flex items-center md:w-[24rem] shadow-sm hover:shadow-md"
        >
          <div
            class="w-1/3 text-center text-sm font-medium placeholder:text-slate-800 flex flex-col items-center md:flex-row md:justify-center border-r"
          >
            <svg
              xmlns="http://www.w3.org/2000/svg"
              fill="none"
              viewBox="0 0 24 24"
              stroke-width="1.5"
              stroke="currentColor"
              class="w-5 h-5 inline md:mr-1"
            >
              <path
                stroke-linecap="round"
                stroke-linejoin="round"
                d="M12.75 3.03v.568c0 .334.148.65.405.864l1.068.89c.442.369.535 1.01.216 1.49l-.51.766a2.25 2.25 0 01-1.161.886l-.143.048a1.107 1.107 0 00-.57 1.664c.369.555.169 1.307-.427 1.605L9 13.125l.423 1.059a.956.956 0 01-1.652.928l-.679-.906a1.125 1.125 0 00-1.906.172L4.5 15.75l-.612.153M12.75 3.031a9 9 0 00-8.862 12.872M12.75 3.031a9 9 0 016.69 14.036m0 0l-.177-.529A2.25 2.25 0 0017.128 15H16.5l-.324-.324a1.453 1.453 0 00-2.328.377l-.036.073a1.586 1.586 0 01-.982.816l-.99.282c-.55.157-.894.702-.8 1.267l.073.438c.08.474.49.821.97.821.846 0 1.598.542 1.865 1.345l.215.643m5.276-3.67a9.012 9.012 0 01-5.276 3.67m0 0a9 9 0 01-10.275-4.835M15.75 9c0 .896-.393 1.7-1.016 2.25"
              />
            </svg>
            Wherever
          </div>
          <div
            class="w-1/3 border-r text-center text-sm font-medium placeholder:text-slate-800 flex flex-col items-center md:flex-row md:justify-center"
          >
            <svg
              xmlns="http://www.w3.org/2000/svg"
              fill="none"
              viewBox="0 0 24 24"
              stroke-width="1.5"
              stroke="currentColor"
              class="w-5 h-5 inline md:mr-1"
            >
              <path
                stroke-linecap="round"
                stroke-linejoin="round"
                d="M6.75 3v2.25M17.25 3v2.25M3 18.75V7.5a2.25 2.25 0 012.25-2.25h13.5A2.25 2.25 0 0121 7.5v11.25m-18 0A2.25 2.25 0 005.25 21h13.5A2.25 2.25 0 0021 18.75m-18 0v-7.5A2.25 2.25 0 015.25 9h13.5A2.25 2.25 0 0121 11.25v7.5m-9-6h.008v.008H12v-.008zM12 15h.008v.008H12V15zm0 2.25h.008v.008H12v-.008zM9.75 15h.008v.008H9.75V15zm0 2.25h.008v.008H9.75v-.008zM7.5 15h.008v.008H7.5V15zm0 2.25h.008v.008H7.5v-.008zm6.75-4.5h.008v.008h-.008v-.008zm0 2.25h.008v.008h-.008V15zm0 2.25h.008v.008h-.008v-.008zm2.25-4.5h.008v.008H16.5v-.008zm0 2.25h.008v.008H16.5V15z"
              />
            </svg>

            Whenever
          </div>
          <div
            class="w-1/3 text-center text-sm font-medium placeholder:text-slate-800 flex flex-col items-center md:flex-row md:justify-center"
          >
            <svg
              xmlns="http://www.w3.org/2000/svg"
              fill="none"
              viewBox="0 0 24 24"
              stroke-width="1.5"
              stroke="currentColor"
              class="w-5 h-5 inline md:mr-1"
            >
              <path
                stroke-linecap="round"
                stroke-linejoin="round"
                d="M15 19.128a9.38 9.38 0 002.625.372 9.337 9.337 0 004.121-.952 4.125 4.125 0 00-7.533-2.493M15 19.128v-.003c0-1.113-.285-2.16-.786-3.07M15 19.128v.106A12.318 12.318 0 018.624 21c-2.331 0-4.512-.645-6.374-1.766l-.001-.109a6.375 6.375 0 0111.964-3.07M12 6.375a3.375 3.375 0 11-6.75 0 3.375 3.375 0 016.75 0zm8.25 2.25a2.625 2.625 0 11-5.25 0 2.625 2.625 0 015.25 0z"
              />
            </svg>

            Guests
          </div>
          <button id="search-button-small">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              fill="none"
              viewBox="0 0 24 24"
              stroke-width="1.5"
              stroke="currentColor"
              class="w-7 h-7 p-1.5 cursor-pointer inline bg-gray-500 text-white rounded-full"
            >
              <path
                stroke-linecap="round"
                stroke-linejoin="round"
                d="M21 21l-5.197-5.197m0 0A7.5 7.5 0 105.196 5.196a7.5 7.5 0 0010.607 10.607z"
              />
            </svg>
          </button>
        </div>
        <div class="relative">
          <button
            class="w-8 cursor-pointer focus:ring-2 focus:ring-offset-2 focus:ring-sky-400 rounded-full"
          >
            <svg
              xmlns="http://www.w3.org/2000/svg"
              fill="none"
              viewBox="0 0 24 24"
              stroke-width="1.5"
              stroke="currentColor"
              class="w-8 h-8"
              id="user"
            >
              <path
                stroke-linecap="round"
                stroke-linejoin="round"
                d="M17.982 18.725A7.488 7.488 0 0012 15.75a7.488 7.488 0 00-5.982 2.975m11.963 0a9 9 0 10-11.963 0m11.963 0A8.966 8.966 0 0112 21a8.966 8.966 0 01-5.982-2.275M15 9.75a3 3 0 11-6 0 3 3 0 016 0z"
              />
            </svg>
          </button>
          <div
            id="drop-down-menu"
            class="absolute hidden right-0 z-10 w-48 rounded-md bg-white py-1 shadow-lg ring-1 ring-black ring-opacity-5 focus:outline-none"
          >
            <div class="border-b">
              <a
                href="#"
                class="block px-4 py-2 text-sm text-gray-700 font-medium"
                >Your Account</a
              >
              <a
                href="#"
                class="block px-4 py-2 text-sm text-gray-700 font-medium"
                >Messages</a
              >
              <a
                href="#"
                class="block px-4 py-2 text-sm text-gray-700 font-medium"
                >Notification</a
              >
              <a
                href="#"
                class="block px-4 py-2 text-sm text-gray-700 font-medium"
                >Trips</a
              >
              <a
                href="#"
                class="block px-4 py-2 text-sm text-gray-700 font-medium"
                >Wish Lists</a
              >
            </div>
            <a href="#" class="block px-4 py-2 text-sm text-gray-700"
              >Switch to Hosting</a
            >
            <a href="#" class="block px-4 py-2 text-sm text-gray-700"
              >Sign out</a
            >
          </div>
        </div>
      </div>
      <div
        id="search-bar"
        class="hidden md:border md:rounded-full w-3/4 mx-auto py-4 px-8 my-1 flex flex-col md:flex-row shadow-sm hover:shadow-md sm:my-4"
      >
        <div
          class="md:w-[35%] ml-2 items-center md:items-stretch flex flex-col space-y-2 md:border-r mb-1"
        >
          <label class="text-xs font-medium" for="destination"
            >Your next destination</label
          >
          <input
            class="w-full text-center outline-none text-sm placeholder:text-sm border md:text-left border-slate-800/50 rounded-md py-1.5 md:border-none md:py-0"
            placeholder="Search destination"
            type="text"
          />
        </div>
        <div date-rangepicker class="flex flex-col md:flex-row md:w-[40%]">
          <div
            class="md:w-[50%] ml-2 items-center md:items-stretch flex flex-col space-y-2 md:border-r mb-1"
          >
            <label class="text-xs font-medium" for="destination"
              >Check in</label
            >
            <input
              id="check-in"
              name="start"
              class="md:w-full text-center outline-none text-sm placeholder:text-sm border md:text-left border-slate-800/50 rounded-md py-1.5 md:border-none md:py-0"
              placeholder="Add Dates"
              type="text"
            />
          </div>
          <div
            class="md:w-[50%] ml-2 items-center md:items-stretch flex flex-col space-y-2 md:border-r mb-1"
          >
            <label class="text-xs font-medium" for="destination"
              >Check out</label
            >
            <input
              id="check-out"
              name="end"
              class="text-center md:w-full outline-none text-sm placeholder:text-sm border md:text-left border-slate-800/50 rounded-md py-1.5 md:border-none md:py-0"
              placeholder="Add Dates"
              type="text"
            />
          </div>
        </div>
        <div
          class="md:w-[25%] ml-2 items-center md:items-stretch flex flex-col space-y-2 mb-1"
        >
          <label class="text-xs font-medium" for="destination">Guests</label>
          <input
            class="text-center md:text-left md:w-full outline-none text-sm placeholder:text-sm border border-slate-800/50 rounded-md py-1.5 md:border-none md:py-0"
            placeholder="Add guests"
            type="text"
          />
        </div>
        <button>
          <svg
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 24 24"
            stroke-width="1.5"
            stroke="currentColor"
            class="w-7 h-7 p-1.5 cursor-pointer inline bg-gray-500 text-white rounded-full"
          >
            <path
              stroke-linecap="round"
              stroke-linejoin="round"
              d="M21 21l-5.197-5.197m0 0A7.5 7.5 0 105.196 5.196a7.5 7.5 0 0010.607 10.607z"
            />
          </svg>
        </button>
      </div>
    </header>
  <!-- ***** Header Area End ***** -->
</body>
</html>
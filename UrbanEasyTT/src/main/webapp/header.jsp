<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
	  <!--Sign-in section -->
  <header
		class="bg-white px-4 sm:px-10 lg:px-24 border-b shadow-sm transition duration-1000">
		<div class="flex h-20 justify-between items-center">
			<img src="https://i.postimg.cc/8cdjfvRm/black-logo.png" alt="logo"
				class="hidden h-12 lg:block" /> <img
				src="https://i.postimg.cc/8cdjfvRm/black-logo.png" alt="logo"
				class="hidden w-12 sm:block lg:hidden" />
			<div id="search-bar-small"
				class="border rounded-full py-1 px-2 w-3/4 flex items-center md:w-[24rem] shadow-sm hover:shadow-md">
				<div
					class="w-1/3 text-center text-sm font-medium placeholder:text-slate-800 flex flex-col items-center md:flex-row md:justify-center border-r">
					<svg xmlns="http://www.w3.org/2000/svg" fill="none"
						viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor"
						class="w-5 h-5 inline md:mr-1">
              <path stroke-linecap="round" stroke-linejoin="round"
							d="M12.75 3.03v.568c0 .334.148.65.405.864l1.068.89c.442.369.535 1.01.216 1.49l-.51.766a2.25 2.25 0 01-1.161.886l-.143.048a1.107 1.107 0 00-.57 1.664c.369.555.169 1.307-.427 1.605L9 13.125l.423 1.059a.956.956 0 01-1.652.928l-.679-.906a1.125 1.125 0 00-1.906.172L4.5 15.75l-.612.153M12.75 3.031a9 9 0 00-8.862 12.872M12.75 3.031a9 9 0 016.69 14.036m0 0l-.177-.529A2.25 2.25 0 0017.128 15H16.5l-.324-.324a1.453 1.453 0 00-2.328.377l-.036.073a1.586 1.586 0 01-.982.816l-.99.282c-.55.157-.894.702-.8 1.267l.073.438c.08.474.49.821.97.821.846 0 1.598.542 1.865 1.345l.215.643m5.276-3.67a9.012 9.012 0 01-5.276 3.67m0 0a9 9 0 01-10.275-4.835M15.75 9c0 .896-.393 1.7-1.016 2.25" />
            </svg>
					Wherever
				</div>
				<div
					class="w-1/3 border-r text-center text-sm font-medium placeholder:text-slate-800 flex flex-col items-center md:flex-row md:justify-center">
					<svg xmlns="http://www.w3.org/2000/svg" fill="none"
						viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor"
						class="w-5 h-5 inline md:mr-1">
              <path stroke-linecap="round" stroke-linejoin="round"
							d="M6.75 3v2.25M17.25 3v2.25M3 18.75V7.5a2.25 2.25 0 012.25-2.25h13.5A2.25 2.25 0 0121 7.5v11.25m-18 0A2.25 2.25 0 005.25 21h13.5A2.25 2.25 0 0021 18.75m-18 0v-7.5A2.25 2.25 0 015.25 9h13.5A2.25 2.25 0 0121 11.25v7.5m-9-6h.008v.008H12v-.008zM12 15h.008v.008H12V15zm0 2.25h.008v.008H12v-.008zM9.75 15h.008v.008H9.75V15zm0 2.25h.008v.008H9.75v-.008zM7.5 15h.008v.008H7.5V15zm0 2.25h.008v.008H7.5v-.008zm6.75-4.5h.008v.008h-.008v-.008zm0 2.25h.008v.008h-.008V15zm0 2.25h.008v.008h-.008v-.008zm2.25-4.5h.008v.008H16.5v-.008zm0 2.25h.008v.008H16.5V15z" />
            </svg>

					Whenever
				</div>
				<div
					class="w-1/3 text-center text-sm font-medium placeholder:text-slate-800 flex flex-col items-center md:flex-row md:justify-center">
					<svg xmlns="http://www.w3.org/2000/svg" fill="none"
						viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor"
						class="w-5 h-5 inline md:mr-1">
              <path stroke-linecap="round" stroke-linejoin="round"
							d="M15 19.128a9.38 9.38 0 002.625.372 9.337 9.337 0 004.121-.952 4.125 4.125 0 00-7.533-2.493M15 19.128v-.003c0-1.113-.285-2.16-.786-3.07M15 19.128v.106A12.318 12.318 0 018.624 21c-2.331 0-4.512-.645-6.374-1.766l-.001-.109a6.375 6.375 0 0111.964-3.07M12 6.375a3.375 3.375 0 11-6.75 0 3.375 3.375 0 016.75 0zm8.25 2.25a2.625 2.625 0 11-5.25 0 2.625 2.625 0 015.25 0z" />
            </svg>

					Guests
				</div>
				<button id="search-button-small">
					<svg xmlns="http://www.w3.org/2000/svg" fill="none"
						viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor"
						class="w-7 h-7 p-1.5 cursor-pointer inline bg-gray-500 text-white rounded-full">
              <path stroke-linecap="round" stroke-linejoin="round"
							d="M21 21l-5.197-5.197m0 0A7.5 7.5 0 105.196 5.196a7.5 7.5 0 0010.607 10.607z" />
            </svg>
				</button>
			</div>
			<div class="relative">
				<button
					class="w-8 cursor-pointer focus:ring-2 focus:ring-offset-2 focus:ring-sky-400 rounded-full">
					<svg xmlns="http://www.w3.org/2000/svg" fill="none"
						viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor"
						class="w-8 h-8" id="user">
              <path stroke-linecap="round" stroke-linejoin="round"
							d="M17.982 18.725A7.488 7.488 0 0012 15.75a7.488 7.488 0 00-5.982 2.975m11.963 0a9 9 0 10-11.963 0m11.963 0A8.966 8.966 0 0112 21a8.966 8.966 0 01-5.982-2.275M15 9.75a3 3 0 11-6 0 3 3 0 016 0z" />
            </svg>
				</button>
				<div id="drop-down-menu"
					class="absolute hidden right-0 z-10 w-48 rounded-md bg-white py-1 shadow-lg ring-1 ring-black ring-opacity-5 focus:outline-none">
					<c:if test="${param.userId != \"\"}">
											<div class="in">
											<div class="border-b">
						<a href="#"
							class="block px-4 py-2 text-sm text-gray-700 font-medium">Your
							Account</a> <a href="#"
							class="block px-4 py-2 text-sm text-gray-700 font-medium">Messages</a>
						<a href="#"
							class="block px-4 py-2 text-sm text-gray-700 font-medium">Notification</a>
						<a href="#"
							class="block px-4 py-2 text-sm text-gray-700 font-medium">Trips</a>
						<a href="#"
							class="block px-4 py-2 text-sm text-gray-700 font-medium">Wish
							Lists</a>
					</div>
					<a href="<%=request.getContextPath()%>/hosting"  class="block px-4 py-2 text-sm text-gray-700">Switch
						to Hosting</a> <a href="<%=request.getContextPath()%>/LogoutServlet"
						class="block px-4 py-2 text-sm text-gray-700">Sign out</a>
					</div>
					</c:if>
					<c:if test="${param.userId == \"\" }">
						<div class="out">
						<div class="border-b">
							<a
							id="login-button"
							class="block px-4 py-2 text-sm text-gray-700 font-medium">Log in</a> 
							<a id="signup-button"
							class="block px-4 py-2 text-sm text-gray-700">Sign up</a>
						</div>
					</div>
					</c:if>
					
				</div>
			</div>
		</div>
		<div id="search-bar"
			class="hidden md:border md:rounded-full w-3/4 mx-auto py-4 px-8 my-1 flex flex-col md:flex-row shadow-sm hover:shadow-md sm:my-4">
			<div
				class="md:w-[35%] ml-2 items-center md:items-stretch flex flex-col space-y-2 md:border-r mb-1">
				<label class="text-xs font-medium" for="destination">Your
					next destination</label> <input
					class="w-full text-center outline-none text-sm placeholder:text-sm border md:text-left border-slate-800/50 rounded-md py-1.5 md:border-none md:py-0"
					placeholder="Search destination" type="text" />
			</div>
			<div class="flex flex-col md:flex-row md:w-[40%]">
				<div
					class="md:w-[50%] ml-2 items-center md:items-stretch flex flex-col space-y-2 md:border-r mb-1">
					<label class="text-xs font-medium" for="destination">Check
						in</label> <input id="check-in" name="start"
						class="md:w-full text-center outline-none text-sm placeholder:text-sm border md:text-left border-slate-800/50 rounded-md py-1.5 md:border-none md:py-0"
						placeholder="Add Dates" type="text" />
				</div>
				<div
					class="md:w-[50%] ml-2 items-center md:items-stretch flex flex-col space-y-2 md:border-r mb-1">
					<label class="text-xs font-medium" for="destination">Check
						out</label> <input id="check-out" name="end"
						class="text-center md:w-full outline-none text-sm placeholder:text-sm border md:text-left border-slate-800/50 rounded-md py-1.5 md:border-none md:py-0"
						placeholder="Add Dates" type="text" />
				</div>
			</div>
			<div
				class="md:w-[25%] ml-2 items-center md:items-stretch flex flex-col space-y-2 mb-1">
				<label class="text-xs font-medium" for="destination">Guests</label>
				<input
					class="text-center md:text-left md:w-full outline-none text-sm placeholder:text-sm border border-slate-800/50 rounded-md py-1.5 md:border-none md:py-0"
					placeholder="Add guests" type="text" />
			</div>
			<button>
				<svg xmlns="http://www.w3.org/2000/svg" fill="none"
					viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor"
					class="w-7 h-7 p-1.5 cursor-pointer inline bg-gray-500 text-white rounded-full">
            <path stroke-linecap="round" stroke-linejoin="round"
						d="M21 21l-5.197-5.197m0 0A7.5 7.5 0 105.196 5.196a7.5 7.5 0 0010.607 10.607z" />
          </svg>
			</button>
		</div>
	</header>
    <div id="modal" class="fixed top-0 left-0 h-full w-full bg-black bg-opacity-75 z-50 flex items-center hidden">
  <div id="upper" class="relative mx-auto  max-w-xl rounded-lg overflow-y-auto p-4 bg-white flex flex-col">
    <div class=" border-b p-3 text-center relative">
<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="absolute top-1/2 -translate-y-1/2 left-0 w-6 h-6 hover:bg-slate-800/30 rounded-full" id="remove-button">
  <path stroke-linecap="round" stroke-linejoin="round" d="M6 18L18 6M6 6l12 12" />
</svg>

    	
    <h2 class="text-lg font-medium">Login or Sign up</h2>
    </div>
    <div class="p-3">
    	<ul class="flex flex-wrap text-sm font-medium text-center text-gray-500 dark:text-gray-400 justify-center mt-1 mb-4">
    <li class="mr-2">
        <a  class="inline-block px-4 py-3 text-white bg-blue-600 rounded-lg hover:text-gray-900 hover:bg-gray-100 active" id="login-tab">Login</a>
    </li>
    <li class="mr-2">
        <a  class="inline-block px-4 py-3 rounded-lg hover:text-gray-900 hover:bg-gray-100 dark:hover:bg-gray-800 dark:hover:text-white" id="signup-tab">Sign up</a>
    </li></ul>
         <form action="<%=request.getContextPath()%>/LoginServlet" class="flex flex-col" id="login-form" method="post">
            <h5 class="font-medium text-lg mb-4">Welcome back to UrbanEasy</h5>
            <div class="mb-3 flex flex-col space-y-1">
              <label for="email">Email address</label>
              <input type="email"  id="email" name="email" class="w-96 h-10 bg-gray-200 rounded-md pl-2">
            </div>
            <div class="mb-3 flex flex-col space-y-1">
              <label for="password" >Password</label>
              <input type="password" id="password" name="password" class="w-96 h-10  bg-gray-200 rounded-md pl-2 ">
            </div>
           <div class="p-3 border-t self-end">
        <button type="submit" class="bg-blue-500 text-white p-2 rounded-lg hover:bg-blue-600" id="login-button">Submit</button>
    </div>
          </form>
          <form class="flex flex-col hidden" id="signup-form">
            <h5 class="font-medium text-lg mb-4">Welcome to UrbanEasy</h5>
            <div class="mb-3 flex flex-col space-y-1">
              <label for="phone" >Phone number</label>
              <input type="password" id="phone" name="phone" class="w-96 h-10  bg-gray-200 rounded-md pl-2 ">
            </div>
            <div class="mb-3 flex flex-col space-y-1">
              <label for="email">Email address</label>
              <input type="email"  id="email" name="email" class="w-96 h-10 bg-gray-200 rounded-md pl-2">
            </div>
            <div class="mb-3 flex flex-col space-y-1">
              <label for="name" >Name</label>
              <input   id="name" name="name" class="w-96 h-10 bg-gray-200 rounded-md pl-2">
            </div>
            <div class="mb-3 flex flex-col space-y-1">
              <label for="password" >Password</label>
              <input type="password" id="password" name="password" class="w-96 h-10  bg-gray-200 rounded-md pl-2 ">
            </div>
            <div class="mb-3 flex flex-col space-y-1">
              <label for="confirmed-password" >Confirm Password</label>
              <input type="password" id="confirmed-password" name="confirmed-password" class="w-96 h-10  bg-gray-200 rounded-md pl-2 ">
            </div>
           <div class="p-3 border-t self-end">
        <button type="submit" class="bg-blue-500 text-white p-2 rounded-lg hover:bg-blue-600">Submit</button>
    </div>
          </form>
    </div>
    
  </div>
</div>
<script src="./assets/js/signInFunction.js"></script>
<script src="./assets/js/ultilities.js"></script>
  <!-- ***** Header Area End ***** -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>Book Exchange</title>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
   <link rel="stylesheet" href="SignIn.css">
    <script src="SignIn.js"></script>
</head>
<body>
   <!-- NavBar -->
   <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">MyBookExchangePortal</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <form class="d-flex">
         <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
         <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
        <div class="d-flex">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-1">
            <li class="nav-item">
              <a class="nav-link" aria-current="page" href="../home/home.html">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" aria-current="page" href="../about/about.html">About</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="../wallet/wallet.html">Wallet</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                Profile
              </a>
              <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                <li><a class="dropdown-item" href="../mybooks/mybooks.html">My books</a></li>
                <!-- <li><a class="dropdown-item" href="#">Borrowed books</a></li> -->
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="../profile/profile.html">UserProfile</a></li>
                <li><a class="dropdown-item" href="../profile/editprofile.html">Edit Profile</a></li>
              </ul>
            </li>
            <li class="nav-item">
               <a class="nav-link active" aria-current="page" href="SignIn.html">Login/Logout</a>
            </li>
          </ul>
        </div>
        </div>
      </div>
    </nav>


   <!-- Sign UP -->
<div class="container mt-5 mb-5 p-0" id="container">
	<div class="form-container sign-up-container">
		<form th:action="save" modelAttribute="user" commandName="user" method="POST">
			<h2>Create Account</h2>
			<!-- <div class="social-container">
				<a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
				<a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
				<a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
			</div> -->
			<input type="text" path="name" placeholder="Full Name" />
			<input type="text" path="userName" placeholder="Display Name" />
			<input type="email" path="emailId" placeholder="Email" />
			<input type="number" path="age"placeholder="Age" />
			<input type="password" path="userPassword" placeholder="Password" />
			<button type="submit">Sign</button>
		</form>
	</div>
	<div class="form-container sign-in-container">
		<form action="#">
			<h1>Sign in</h1>
			<!-- <div class="social-container">
				<a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
				<a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
				<a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
			</div> -->
			<input type="email" placeholder="Email" />
			<input type="password" placeholder="Password" />
			<a href="#">Forgot your password?</a>
			<button>Sign In</button>
		</form>
	</div>
	<div class="overlay-container">
		<div class="overlay">
			<div class="overlay-panel overlay-left">
				<h1>Welcome Back!</h1>
				<p>To keep connected with us please login with your personal info</p>
				<button class="ghost" id="signIn">Sign In</button>
			</div>
			<div class="overlay-panel overlay-right">
				<h1>Hello, Friend!</h1>
				<p>Enter your personal details and start journey with us</p>
				<button class="ghost" id="signUp">Sign Up</button>
			</div>
		</div>
	</div>
</div>
   
  
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.*"%>

<%@ page import="java.util.*"%>
<!Doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Home Page</title>
</head>
<style>
.nav-item {
	padding: 10px;
}

body {
	font-family: Arial, Helvetica, sans-serif;
}

/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

/* Set a style for all buttons */
button {
	background-color: blue;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border-radius: 10px;
	cursor: pointer;
	width: 100%;
}

button:hover {
	opacity: 0.8;
}

.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
	position: relative;
}

img.avatar {
	width: 40%;
	border-radius: 50%;
}

.container {
	padding: 16px;
}

span.psw {
	float: right;
	padding-top: 16px;
}

.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
	padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 80%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
	position: absolute;
	right: 25px;
	top: 0;
	color: #000;
	font-size: 35px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: red;
	cursor: pointer;
}

/* Add Zoom Animation */
.animate {
	-webkit-animation: animatezoom 0.6s;
	animation: animatezoom 0.6s
}

@
-webkit-keyframes animatezoom {
	from {-webkit-transform: scale(0)
}

to {
	-webkit-transform: scale(1)
}

}
@
keyframes animatezoom {
	from {transform: scale(0)
}

to {
	transform: scale(1)
}

}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 200px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
</style>



<body>

	<%
	String i = (String) session.getAttribute("check");
	String str = (String) session.getAttribute("check1");
	String str1 = (String) session.getAttribute("check2");
	//use page directive to import a class in JSP page
	Customer c = (Customer) session.getAttribute("customer");
	Manager m = (Manager) session.getAttribute("manager");
	Admin a = (Admin) session.getAttribute("admin");
	if (i == null && str == null && str1 == null) {
	%>

	<!-- Navigation Bar -->
	<nav class="navbar navbar-expand-sm navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src="assets/bullet-g40039ee99_1920.png" alt="" width="60"
				height="60" class="d-inline-block align-text-top">
			</a> <a class="navbar-brand" href="#">GAMING <br> PARLOUR
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul style="font-size: 1.1rem; justify-content: center;"
					class="navbar-nav me-auto mb-2 mb-lg-0 ">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#home">Home</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">About</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#games">Games Category</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Gallery</a></li>

					<li class="nav-item"><button
							onclick="document.getElementById('id04').style.display='block'"
							style="width: auto;">Contact</button></li>
					<li class="nav-item"><button
							onclick="document.getElementById('id02').style.display='block'"
							style="width: auto;">Sign Up</button></li>

					<li class="nav-item"><button
							onclick="document.getElementById('id01').style.display='block'"
							style="width: auto;">Login</button></li>
				</ul>
			</div>
		</div>
	</nav>
	<%
	} else if (i != null) {
	%>
	<!-- Navigation Bar -->
	<nav class="navbar navbar-expand-sm navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src="assets/bullet-g40039ee99_1920.png" alt="" width="60"
				height="60" class="d-inline-block align-text-top">
			</a> <a class="navbar-brand" href="#">GAMING <br> PARLOUR
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul style="font-size: 1.1rem; justify-content: center;"
					class="navbar-nav me-auto mb-2 mb-lg-0 ">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#home">Home</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">About</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#games">Games Category</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Gallery</a></li>

					<li class="nav-item"><button
							onclick="document.getElementById('id04').style.display='block'"
							style="width: auto;">Contact</button></li>
					<li class="nav-item"><button
							onclick="document.getElementById('id06').style.display='block'"
							style="width: auto;">Profile</button></li>
					<li class="nav-item"><button
							onclick="document.getElementById('id05').style.display='block'"
							style="width: auto;">Logout</button></li>
				</ul>
			</div>
		</div>
	</nav>
	<%
	} else if (str != null) {
	%>
	<!-- Navigation Bar -->
	<nav class="navbar navbar-expand-sm navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src="assets/bullet-g40039ee99_1920.png" alt="" width="60"
				height="60" class="d-inline-block align-text-top">
			</a> <a class="navbar-brand" href="#">GAMING <br> PARLOUR
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul style="font-size: 1.1rem; justify-content: center;"
					class="navbar-nav me-auto mb-2 mb-lg-0 ">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#home">Home</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">About</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#games">Games Category</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Gallery</a></li>

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="ManagerDashBoard.jsp">DashBoard</a></li>
					<li class="nav-item"><button
							onclick="document.getElementById('id06').style.display='block'"
							style="width: auto;">Profile</button></li>

					<li class="nav-item"><button
							onclick="document.getElementById('id05').style.display='block'"
							style="width: auto;">Logout</button></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- For Admin -->
	<%
	} else if (str1 != null) {
	%>
	<!-- Navigation Bar -->
	<nav class="navbar navbar-expand-sm navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src="assets/bullet-g40039ee99_1920.png" alt="" width="60"
				height="60" class="d-inline-block align-text-top">
			</a> <a class="navbar-brand" href="#">GAMING <br> PARLOUR
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul style="font-size: 1.1rem; justify-content: center;"
					class="navbar-nav me-auto mb-2 mb-lg-0 ">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#home">Home</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">About</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#games">Games Category</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Gallery</a></li>

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="AdminDashBoard.jsp">DashBoard</a></li>
					<li class="nav-item"><button
							onclick="document.getElementById('id06').style.display='block'"
							style="width: auto;">Profile</button></li>

					<li class="nav-item"><button
							onclick="document.getElementById('id05').style.display='block'"
							style="width: auto;">Logout</button></li>
				</ul>
			</div>
		</div>
	</nav>
	<%
	}
	%>



	<section id="home">
		<div class="container">
			<h1 style="padding-top: 100px" class="h-primary centre">WELCOME!</h1>
			<h2 class="h-secondary centre">Gaming cafes provide an enriching
				experience and therefore preserve an ancient form of gaming, that
				combines entertainment with the opportunity to be physically social
				with others</h2>
			<%
			if (i != null || str != null || str1 != null) {
			%>
			<div class="centre">
				<button
					onclick="document.getElementById('id03').style.display='block'"
					style="width: auto;">Register</button>
			</div>
			<%
			} else if (i == null) {
			%>
			<div class="centre">
				<h3 style="color: white;">Please Login for Registration!!</h3>
			</div>
			<%
			}
			%>
		</div>
	</section>


	<!-- Login form -->
	<div id="id01" class="modal">

		<form class="modal-content animate" action="LoginServlet"
			method="post">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id01').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>

			<div class="container">
				<label for="uname"><b>Email</b></label> <input type="text"
					placeholder="Enter Username" name="email" required> <label
					for="psw"><b>Password</b></label> <input type="password"
					placeholder="Enter Password" name="psw" required> <label
					for="role">Choose a Role</label> <select name="role">
					<option value="Customer">Customer</option>
					<option value="Manager">Manager</option>
					<option value="Admin">Admin</option>
				</select>
				<button type="submit">Login</button>
				<label> <input type="checkbox" checked="checked"
					name="remember"> Remember me
				</label>
			</div>

			<div class="container" style="background-color: #f1f1f1">
				<button type="button"
					onclick="document.getElementById('id01').style.display='none'"
					class="cancelbtn">Cancel</button>
				<span class="psw">Forgot <a href="#">password?</a></span>
			</div>
		</form>
	</div>

	<script>
		// Get the modal
		var modal = document.getElementById('id01');

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>

	<div id="id04" class="modal">

		<form class="modal-content animate" action="" method="post">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id04').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>

			<div class="container">
				<div class="mb-3">
					<label for="exampleFormControlTextarea1" class="form-label">Example
						textarea</label>
					<textarea class="form-control" id="exampleFormControlTextarea1"
						rows="3"></textarea>
				</div>
				<button type="submit">Submit</button>
			</div>

			<div class="container" style="background-color: #f1f1f1">
				<button type="button"
					onclick="document.getElementById('id04').style.display='none'"
					class="cancelbtn">Cancel</button>
			</div>
		</form>
	</div>
	<!-- signUp form -->

	<div id="id02" class="modal">
		<span onclick="document.getElementById('id02').style.display='none'"
			class="close" title="Close Modal">&times;</span>
		<form class="modal-content" action="SignUpController">
			<div class="container">
				<h1>Sign Up</h1>
				<p>Please fill in this form to create an account.</p>
				<hr>
				<label for="fname"><b>First Name</b></label> <input type="text"
					placeholder="Enter First Name" name="fname" id="fname" required>

				<label for="lname"><b>Last Name</b></label> <input type="text"
					placeholder="Enter Last Name" name="lname" id="lname" required>
				<label for="email"><b>Email</b></label> <input type="text"
					placeholder="Enter Email" name="email" required> <label
					for="psw"><b>Password</b></label> <input type="password"
					placeholder="Enter Password" name="psw" required> <label
					for="psw-repeat"><b>Repeat Password</b></label> <input
					type="password" placeholder="Repeat Password" name="psw-repeat"
					required> <label> <input type="checkbox"
					checked="checked" name="remember" style="margin-bottom: 15px">
					Remember me
				</label>

				<p>
					By creating an account you agree to our <a href="#"
						style="color: dodgerblue">Terms & Privacy</a>.
				</p>

				<div class="clearfix">
					<button type="button"
						onclick="document.getElementById('id02').style.display='none'"
						class="cancelbtn">Cancel</button>
					<button type="submit" class="signupbtn">Sign Up</button>
				</div>
			</div>
		</form>
	</div>
	<!-- Register form -->
	<div id="id03" class="modal">
		<span onclick="document.getElementById('id03').style.display='none'"
			class="close" title="Close Modal">&times;</span>
		<form class="modal-content" action="Register1Controller">
			<div class="container">
				<h1>Register</h1>
				<p>Please fill in this form to Register</p>
				<hr>
				<label for="email"><b>Email</b></label> <input type="text"
					placeholder="Enter Email" name="email" required> <label
					for="game">Choose a Game</label> <select name="game">
					<option value="1">Game 1 (Price : - xyz rs/hr)</option>
					<option value="2">Game 2 (Price : - xyz rs/hr)</option>
					<option value="3">Game 3 (Price : - xyz rs/hr)</option>
				</select> <label for="time">Choose a Time</label> <select name="time">
					<option value="1">4 to 5 pm</option>
					<option value="2">5 to 6 pm</option>
					<option value="3">6 to 7 pm</option>
				</select>
				<div class="clearfix">
					<button type="button"
						onclick="document.getElementById('id03').style.display='none'"
						class="cancelbtn">Cancel</button>
					<button type="submit" class="signupbtn">Submit</button>
				</div>
			</div>
		</form>
	</div>

	<!-- logout -->
	<div id="id05" class="modal">
		<span onclick="document.getElementById('id05').style.display='none'"
			class="close" title="Close Modal">&times;</span>
		<form class="modal-content" action="Logout">
			<div class="container">
				<h1>Logout</h1>
				<p>Do you really want to logout?</p>
				<hr>
				<div class="clearfix">
					<button type="button"
						onclick="document.getElementById('id05').style.display='none'"
						class="cancelbtn">Cancel</button>
					<button type="submit" class="signupbtn">YES</button>
				</div>
			</div>
		</form>
	</div>
	<section id="games">
		<div class="container">
			<h1 class="h-primary centre">ALL GAMES</h1>
			<form action="homegame">
				<input type="submit" value="More games">
			</form>

			<div class="box">
				<div class="container">
					<div class="row">
						<%
						ArrayList<Games> lst = (ArrayList<Games>) session.getAttribute("gamelist");
						if (!session.isNew()) {
							System.out.println(lst.size());

							for (int j = 0; j < lst.size(); j++) {
						%>
						<div class="col">
							<div class="card" style="width: 18rem;">
								<img src="assets/neon-g644e4afd4_1920.jpg" class="card-img-top"
									alt="...">
								<div class="card-body">
									<h5 class="card-title">
										Game
										<%=lst.get(j).getGameID()%></h5>
									<p class="card-text">Some quick example text to build on
										the card title and make up the bulk of the card's content.</p>
									<button
										onclick="document.getElementById('id03').style.display='block'"
										style="width: auto;">Register</button>
								</div>
							</div>
						</div>

						<%
						}
						}
						%>
					</div>
				</div>
			</div>
		</div>
	</section>

	<div id="id06" class="modal" style="">
		<span onclick="document.getElementById('id06').style.display='none'"
			class="close" title="Close Modal">&times;</span>
		<form class="modal-content" action="Register1Controller">
			<div class="container">
				<h1>Profile</h1>
				<hr>
				<div
					style="display: flex; flex-direction: column; justify-content: center; align-items: center;">
					<img src="assets/download.png" alt="John" style="width: 40%">
					<%
					if (c != null) {
					%>
					<p>
						Name ::
						<%=c.getFname()%>
						<%=c.getLname()%>
					</p>
					<p class="title">
						Email ::
						<%=c.getEmail()%></p>
					<p>Role :: Customer</p>
					<%
					} else if (m != null) {
					%>
					<p>
						Manager ID ::
						<%=m.getMid()%></p>
					<p>
						Name ::
						<%=m.getFname()%>
						<%=m.getLname()%>
					</p>
					<p class="title">
						Email ::
						<%=m.getEmail()%></p>
					<p>Role :: Manager</p>
					<%
					} else if (str1 != null) {
					%>
					<p>Admin</p>
					<%
					}
					%>
					<div style="margin: 24px 0;">
						<a href="#"><i class="fa fa-dribbble"></i></a> <a href="#"><i
							class="fa fa-twitter"></i></a> <a href="#"><i
							class="fa fa-linkedin"></i></a> <a href="#"><i
							class="fa fa-facebook"></i></a>
					</div>
					<div class="clearfix">
						<button type="button"
							onclick="document.getElementById('id06').style.display='none'"
							class="cancelbtn">Cancel</button>
					</div>
				</div>
			</div>
		</form>
	</div>

	<!-- Footer -->
	<footer class="page-footer font-small blue pt-4">

		<!-- Footer Links -->
		<div class="container-fluid text-center text-md-left">

			<!-- Grid row -->
			<div class="row">

				<!-- Grid column -->
				<div class="col-md-6 mt-md-0 mt-3">

					<!-- Content -->
					<h5 class="text-uppercase">Gaming Parlour</h5>
					<a class="navbar-brand" href="#"> <img
						src="assets/bullet-g40039ee99_1920.png" alt="" width="60"
						height="60" class="d-inline-block align-text-top">
					</a>

				</div>
				<!-- Grid column -->

				<hr class="clearfix w-100 d-md-none pb-3">

				<!-- Grid column -->
				<div class="col-md-3 mb-md-0 mb-3">

					<!-- Links -->
					<h5 class="text-uppercase">Links</h5>

					<ul class="list-unstyled">
						<li><a href="#!">Link 1</a></li>
						<li><a href="#!">Link 2</a></li>
						<li><a href="#!">Link 3</a></li>
						<li><a href="#!">Link 4</a></li>
					</ul>

				</div>
				<!-- Grid column -->

				<!-- Grid column -->
				<div class="col-md-3 mb-md-0 mb-3">

					<!-- Links -->
					<h5 class="text-uppercase">Links</h5>

					<ul class="list-unstyled">
						<li><a href="#!">Link 1</a></li>
						<li><a href="#!">Link 2</a></li>
						<li><a href="#!">Link 3</a></li>
						<li><a href="#!">Link 4</a></li>
					</ul>

				</div>
				<!-- Grid column -->

			</div>
			<!-- Grid row -->

		</div>
		<!-- Footer Links -->

		<!-- Copyright -->
		<div class="footer-copyright text-center py-3">
			© 2022 Copyright: <a href="/">GamingParlour.com</a>
		</div>
		<!-- Copyright -->

	</footer>

	<!-- Footer -->
	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
</body>


</html>
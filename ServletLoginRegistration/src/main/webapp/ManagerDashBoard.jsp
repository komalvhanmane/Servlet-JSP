<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.model.*" %>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Manager DashBoard</title>
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
	border-radius: 15px;
	cursor: pointer;
	width: 100%;
}

button:hover {
	opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

/* Center the image and position the close button */
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

/* The Modal (background) */
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

.container1 {
	display: flex;
	justify-content: center;
}
</style>



<body>
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
						aria-current="page" href="Home.jsp">Home</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<section id="pc">
	<div class="container">
			<h1 class="h-primary centre">ALL PC</h1>
			<form action="Managerpc">
				<input type="submit" value="More PC">
			</form>

			<div class="box">
				<div class="container">
					<div class="row">
						<%
						ArrayList<PC> lst = (ArrayList<PC>) session.getAttribute("pclist");
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
										PC No. 
										<%=lst.get(j)%></h5>
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
	<section id="home">
		<h1 style="padding-top: 100px" class="h-primary centre">WELCOME
			MANAGER!</h1>
		<div class="container1">

			<button
				onclick="document.getElementById('id01').style.display='block'"
				style="width: auto;">ADD PC</button>
			<button
				onclick="document.getElementById('id02').style.display='block'"
				style="width: auto;">ADD SECTIONS</button>
			<button
				onclick="document.getElementById('id03').style.display='block'"
				style="width: auto;">DELETE PC</button>
			<button
				onclick="document.getElementById('id04').style.display='block'"
				style="width: auto;">DELETE SECTIONS</button>
			<button
				onclick="document.getElementById('id05').style.display='block'"
				style="width: auto;">ADD GAMES</button>
			<button
				onclick="document.getElementById('id06').style.display='block'"
				style="width: auto;">DELETE GAMES</button>
		</div>
	</section>

	<!--add pc -->

	<div id="id01" class="modal">
		<span onclick="document.getElementById('id01').style.display='none'"
			class="close" title="Close Modal">&times;</span>
		<form class="modal-content" action="AddPC">
			<div class="container">
				<h1>ADD PC</h1>

				<hr>
				<label for="pid"><b>PC ID</b></label> <input type="text"
					placeholder="Enter PC ID" name="pid" id="pid" required>
				<label for="sid"><b>SECTION NUMBER</b></label> <input type="text"
					placeholder="Enter SECTION NUMBER" name="sid" id="sid" required>

				<p>
					By creating an account you agree to our <a href="#"
						style="color: dodgerblue">Terms & Privacy</a>.
				</p>

				<div class="clearfix">
					<button type="button"
						onclick="document.getElementById('id01').style.display='none'"
						class="cancelbtn">Cancel</button>
					<button type="submit" class="signupbtn">ADD</button>
				</div>
			</div>
		</form>
	</div>
	
	<!-- add section -->
	<div id="id02" class="modal">
		<span onclick="document.getElementById('id02').style.display='none'"
			class="close" title="Close Modal">&times;</span>
		<form class="modal-content" action="AddSection">
			<div class="container">
				<h1>ADD SECTION</h1>

				<hr>
					<label for="sid"><b>Section ID</b></label> <input type="text"
					placeholder="Enter Section ID" name="sid" id="sid" required>

				<p>
					By deleting an account you lose all information <a href="#"
						style="color: dodgerblue">Terms & Privacy</a>.
				</p>

				<div class="clearfix">
					<button type="button"
						onclick="document.getElementById('id02').style.display='none'"
						class="cancelbtn">Cancel</button>
					<button type="submit" class="signupbtn">ADD</button>
				</div>
			</div>
		</form>
	</div>
	
	<!-- Delete pc -->
	<div id="id03" class="modal">
		<span onclick="document.getElementById('id03').style.display='none'"
			class="close" title="Close Modal">&times;</span>
		<form class="modal-content" action="DeletePC">
			<div class="container">
				<h1>DELETE PC</h1>

				<hr>
					<label for="pid"><b>PC ID</b></label> <input type="text"
					placeholder="Enter PC ID" name="pid" id="pid" required>

				<p>
					By deleting an account you lose all information <a href="#"
						style="color: dodgerblue">Terms & Privacy</a>.
				</p>

				<div class="clearfix">
					<button type="button"
						onclick="document.getElementById('id03').style.display='none'"
						class="cancelbtn">Cancel</button>
					<button type="submit" class="signupbtn">DELETE</button>
				</div>
			</div>
		</form>
	</div>
	
	
	<!-- Delete Sections  -->
	<div id="id04" class="modal">
		<span onclick="document.getElementById('id04').style.display='none'"
			class="close" title="Close Modal">&times;</span>
		<form class="modal-content" action="DeleteSection">
			<div class="container">
				<h1>Delete Sections</h1>

				<hr>
				<label for="sid"><b>Section ID</b></label> <input type="text"
					placeholder="Enter Section ID" name="sid" id="sid" required>
				<p>
					By updating an account you lose previous information <a href="#"
						style="color: dodgerblue">Terms & Privacy</a>.
				</p>

				<div class="clearfix">
					<button type="button"
						onclick="document.getElementById('id04').style.display='none'"
						class="cancelbtn">Cancel</button>
					<button type="submit" class="signupbtn">DELETE</button>
				</div>
			</div>
		</form>
	</div>
	
	<!-- add games  -->
	<div id="id05" class="modal">
		<span onclick="document.getElementById('id05').style.display='none'"
			class="close" title="Close Modal">&times;</span>
		<form class="modal-content" action="AddGames">
			<div class="container">
				<h1>ADD GAMES</h1>

				<hr>
				<label for="id"><b>Game ID</b></label> <input type="text"
					placeholder="Enter Game ID" name="gid" id="id" required>
				<p>
				<label for="id"><b>Game Price</b></label> <input type="text"
					placeholder="Enter Game Price" name="gpid" id="id" required>
				<p>
				<label for="id"><b>Game Name</b></label> <input type="text"
					placeholder="Enter Game Name" name="gnid" id="id" required>
				<p>
					By updating an account you lose previous information <a href="#"
						style="color: dodgerblue">Terms & Privacy</a>.
				</p>

				<div class="clearfix">
					<button type="button"
						onclick="document.getElementById('id05').style.display='none'"
						class="cancelbtn">Cancel</button>
					<button type="submit" class="signupbtn">ADD</button>
				</div>
			</div>
		</form>
	</div>
	
	<!-- Delete game  -->
	<div id="id06" class="modal">
		<span onclick="document.getElementById('id06').style.display='none'"
			class="close" title="Close Modal">&times;</span>
		<form class="modal-content" action="ManagerUpdate">
			<div class="container">
				<h1>Delete Game</h1>

				<hr>
				<label for="id"><b>Game ID</b></label> <input type="text"
					placeholder="Enter Game ID" name="id" id="id" required>
				<p>
					By updating an account you lose previous information <a href="#"
						style="color: dodgerblue">Terms & Privacy</a>.
				</p>

				<div class="clearfix">
					<button type="button"
						onclick="document.getElementById('id06').style.display='none'"
						class="cancelbtn">Cancel</button>
					<button type="submit" class="signupbtn">DELETE</button>
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
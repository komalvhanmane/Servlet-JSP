<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

<title>Home</title>
</head>
<style>
.carousel-inner img {
	height: 50%;
}
body{
background:black;
}
.container {
	padding: 16px;
	display: flex;
	justify-content: center;
}

/* The Modal (background) */
.modal {
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
	margin: 5% auto 15% auto;
	width: 80%;
}
</style>
<body>

	<!-- Navigation bar -->
	<nav class="navbar navbar-dark bg-dark">
	<div class="container-fluid">
		<a class="navbar-brand" href="#"> <img
			src="./assets1/alex-litvin-MAYsdoYpGuk-unsplash.jpg" alt="" width="30"
			height="24" class="d-inline-block align-text-top"> Movie RS
		</a>
<!-- 	<div class="d-flex  p-2"
			style="justify-content: center; padding: 20px">
			<button type="button" class="btn btn-outline-info">Action</button>
			<button type="button" class="btn btn-outline-info">Horrer</button>
			<button type="button" class="btn btn-outline-info">Comedy</button>
			<button type="button" class="btn btn-outline-info">Horror</button>
			<button type="button" class="btn btn-outline-info">Type3</button>
		</div>
		
		<form class="d-flex">
			<div id="search-autocomplete" class="form-outline">
				<input type="search" id="form1" class="form-control" /> <label
					class="form-label" for="form1">Search</label>
			</div>
			<button class="btn btn-outline-info" type="submit">Search</button>
		</form>
		 -->	
		<a href="Login.jsp"><button type="button" class="btn btn-outline-info">Sign
			In</button></a>
	</div>
	</nav>
	

	<div>
		<div id="carouselExampleCaptions" class="carousel slide"
			data-bs-ride="carousel">
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#carouselExampleCaptions"
					data-bs-slide-to="0" class="active" aria-current="true"
					aria-label="Slide 1"></button>
				<button type="button" data-bs-target="#carouselExampleCaptions"
					data-bs-slide-to="1" aria-label="Slide 2"></button>
				<button type="button" data-bs-target="#carouselExampleCaptions"
					data-bs-slide-to="2" aria-label="Slide 3"></button>
				<button type="button" data-bs-target="#carouselExampleCaptions"
					data-bs-slide-to="3" aria-label="Slide 4"></button>
			</div>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="./assets1/diego-sanchez-kAp8agsaFWo-unsplash.jpg"
						class="d-block w-100" alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5>First slide label</h5>
						<p>Some representative placeholder content for the first
							slide.</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="./assets1/mason-kimbarovsky-X_d7m2r70bA-unsplash.jpg"
						class="d-block w-100" alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5>Second slide label</h5>
						<p>Some representative placeholder content for the second
							slide.</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="./assets1/jonatan-pie-3l3RwQdHRHg-unsplash.jpg"
						class="d-block w-100" alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5>Third slide label</h5>
						<p>Some representative placeholder content for the third
							slide.</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="./assets1/tyson-moultrie-BQTHOGNHo08-unsplash.jpg"
						class="d-block w-100" alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5>Third slide label</h5>
						<p>Some representative placeholder content for the third
							slide.</p>
					</div>
				</div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
	</div>

	<!-- Popular Movies -->
	<form action="movieController">
		<div class="container">
			<input type="submit" class="btn btn-outline-info"
				" value="Click to see popular movies">
		</div>
	</form>

	<div class="container">
		<div class="row row-cols-2"></div>
	</div>

	<!-- Show popular movies -->
	<section class="container" style="margin-top: 100px;">
	<div class="container px-4">
		<div class="row gx-5">
			<div class="col">
				<div class="p-3 border bg-light">
				<p>Popular Movies</p>
				
					<div class="container">
						<div class="row row-cols-2 row-cols-lg-3 g-2 g-lg">
						
							<c:if test="${not empty popularMovie}">
								<c:forEach var="nameObj" items="${popularMovie}">
									<div class="col">
										<div class="p-3 border bg-light">
											<div class="card" style="width: 18rem;">
												<img src="./assets1/hello-i-m-nik-cKcPF4aQBFE-unsplash.jpg" class="card-img-top" alt="...">
												<div class="card-body">
													<h5 class="card-title"> Movie Name :: <c:out value="${nameObj.name}"></c:out></h5>
													<p class="card-text">Genres :: <c:out value="${nameObj.genres}"></c:out></p>
													<a href="#" class="btn btn-primary">Go somewhere</a>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</c:if>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>


	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form class="modal-content animate" action="" method="post">

						<div class="container">
							<label for="uname"><b>Username</b></label><input type="email"
								class="form-control" id="inputEmail3"
								placeholder="Enter Username" name="uname" required> <label
								for="psw"><b>Password</b></label><input type="password"
								class="form-control" id="inputPassword3" name="upass"
								placeholder="Enter Password" required> <label> <input
								type="checkbox" checked="checked" name="remember">
								Remember me
							</label>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Login</button>
					<div class="container" style="background-color: #f1f1f1">
						<span class="psw">Dont Have an Account ? <a
							href="Register.jsp">Create One.</a></span>
					</div>
				</div>
			</div>
		</div>
	</div>



	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>
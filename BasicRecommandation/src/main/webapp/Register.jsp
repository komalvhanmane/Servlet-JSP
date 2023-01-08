<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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

<title>Register</title>
</head>
<style>
.loginContainer form {
	display: flex;
	flex-direction: column;
	justify-content: center;
	background-color: white;
	padding: 10%;
	margin-left: 25%;
	margin-right: 25%;
	border-radius: 20px;
}

body::before {
	content: "";
	background: url('./assets1/hello-i-m-nik-cKcPF4aQBFE-unsplash.jpg')
		no-repeat center center/cover;
	position: absolute;
	height: 100%;
	width: 100%;
	z-index: -1;
	opacity: 0.9;
}

.box {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
}

.h-primary {
	color: white;
	font-size: 3rem;
	font-family: New Roman;
}

.centre {
	align-items: center;
}
</style>
<body>
	<nav class="navbar navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src="./assets1/alex-litvin-MAYsdoYpGuk-unsplash.jpg" alt=""
				width="30" height="24" class="d-inline-block align-text-top">
				Movie RS
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
			<a href="Login.jsp"><button type="button"
					class="btn btn-outline-info">Sign In</button></a>
		</div>
	</nav>
	<div class="box">
		<h1 class="h-primary centre">Register !!</h1>
	</div>
	<div class="loginContainer">
		<form action="RegisterrController">
			<div class="row mb-3">
				<label for="inputEmail3" class="col-sm-2 col-form-label" required>Email</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="inputEmail3"
						name="email">
				</div>
			</div>
			<div class="row mb-3">
				<label for="inputPassword3" class="col-sm-2 col-form-label" required>Password</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="inputPassword3"
						name="pass">
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Sign in</button>
		</form>
	</div>
	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

</body>
</html>
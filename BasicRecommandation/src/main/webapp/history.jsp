<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.info.*"%>
<%@ page import="com.model.*"%>
<%@ page import="java.util.*"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>DashBoard</title>
</head>
<style>
* {
	box-sizing: border-box;
}
body {
	font: 16px Arial;
	background: black;
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
			<a href="DashBoard.jsp"><button type="button"
					class="btn btn-outline-info">Home</button></a>
			<a href="index.jsp"><button type="button"
					class="btn btn-outline-info">Logout</button></a>
			
		</div>
	</nav>
	<!-- Show popular movies -->
	<section class="container" style="margin-top: 100px;">
		<div class="container px-4">
			<div class="row gx-5">
				<div class="col">
					<div class="p-3 border bg-light">
						<p>Search History</p>
						<div class="container">
							<div class="row row-cols-2 row-cols-lg-2 g-2 g-lg">
								<%
								Stack<History> lst = (Stack<History>) session.getAttribute("history");
								%>
								<%
								if (lst != null) {
								%>
								<%
								while(!lst.isEmpty()){
									History h=lst.pop();
								%>
								<div class="col">
									<div class="p-3 border bg-light">
										<div class="card" style="width: 18rem;">
											<div class="card-body">
											<p><%=h.getStr()%></p>
											</div>
										</div>
										<div class="card" style="width: 18rem;">
											<div class="card-body">
											<p><%=h.getDate()%></p>
											</div>
										</div>
									</div>
								</div>
								<%
								}
								%>
								<%
								}
								%>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>
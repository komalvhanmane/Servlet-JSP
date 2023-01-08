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
<title>FilteredMovies</title>
</head>
<style>
* {
	box-sizing: border-box;
}

body {
	font: 16px Arial;
}

/*the container must be positioned relative:*/
.autocomplete {
	position: relative;
	display: inline-block;
}

input {
	border: 1px solid transparent;
	background-color: #f1f1f1;
	padding: 10px;
	font-size: 16px;
}

input[type=text] {
	background-color: #f1f1f1;
	width: 100%;
}

input[type=submit] {
	background-color: DodgerBlue;
	color: #fff;
	cursor: pointer;
}

.autocomplete-items {
	position: absolute;
	border: 1px solid #d4d4d4;
	border-bottom: none;
	border-top: none;
	z-index: 99;
	/*position the autocomplete items to be the same width as the container:*/
	top: 100%;
	left: 0;
	right: 0;
}

.autocomplete-items div {
	padding: 10px;
	cursor: pointer;
	background-color: #fff;
	border-bottom: 1px solid #d4d4d4;
}

/*when hovering an item:*/
.autocomplete-items div:hover {
	background-color: #e9e9e9;
}

/*when navigating through the items using the arrow keys:*/
.autocomplete-active {
	background-color: DodgerBlue !important;
	color: #ffffff;
}

body::before {
	content: "";
	background: url('./assets1/richard-horvath-_nWaeTF6qo0-unsplash.jpg')
		 center center/cover;
	position: absolute;
	height: 100%;
	width: 100%;
	z-index: -1;
	opacity: 0.9;
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
			<div class="d-flex  p-2"
				style="justify-content: center; padding: 20px">
				<form action="FilterController">
					<button type="submit" class="btn btn-outline-info" value="action"
						name="filter">Action</button>
				</form>
				<form action="FilterController">
					<button type="submit" class="btn btn-outline-info" value="romance"
						name="filter">Romantic</button>
				</form>
				<form action="FilterController">
					<button type="submit" class="btn btn-outline-info" value="comedy"
						name="filter">Comedy</button>
				</form>
				<form action="FilterController">
					<button type="submit" class="btn btn-outline-info" value="horror"
						name="filter">Horror</button>
				</form>
				<form action="FilterController">
					<button type="submit" class="btn btn-outline-info"
						value="adventure" name="filter">Adventure</button>
				</form>
				<form action="FilterController">
					<button type="submit" class="btn btn-outline-info" value="thriller"
						name="filter">Thriller</button>
				</form>
				<form action="FilterController">
					<button type="submit" class="btn btn-outline-info" value="family"
						name="filter">Family</button>
				</form>
				<form action="FilterController">
					<button type="submit" class="btn btn-outline-info"
						value="documentary" name="filter">Documentary</button>
				</form>
				<form action="FilterController">
					<button type="submit" class="btn btn-outline-info" value="crime"
						name="filter">Crime</button>
				</form>
				<form action="FilterController">
					<button type="submit" class="btn btn-outline-info" value="war"
						name="filter">War</button>
				</form>
			</div>
			<a href="index.jsp"><button type="button"
					class="btn btn-outline-info">Logout</button></a>
		</div>
	</nav>

	<!-- search box -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02"
				aria-controls="navbarTogglerDemo02" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<form autocomplete="off" action="movieShowerController">
				<div class="autocomplete" style="width: 300px;">
					<input id="myInput" type="text"
						placeholder="Search Movie" name="searchmovie" required>
				</div>
				<input type="submit">
			</form>
		</div>
	</nav>
	<!-- Show popular movies -->
	<section class="container" style="margin-top: 100px;">
	<div class="container px-4">
		<div class="row gx-5">
			<div class="col">
				<div class="p-3 border bg-light">
				<p>Movies</p>
					<div class="container">
						<div class="row row-cols-2 row-cols-lg-3 g-2 g-lg">
						 <% LinkedList<Movie> lst=(LinkedList<Movie>)session.getAttribute("similarmovie"); %>
							<%if(lst!=null){ %>
								<%for(int i=0;i<lst.size();i++){ %>
									<div class="col">
										<div class="p-3 border bg-light">
											<div class="card" style="width: 18rem;">
												<img src="./assets1/hello-i-m-nik-cKcPF4aQBFE-unsplash.jpg" class="card-img-top" alt="...">
												<div class="card-body">
													<h5 class="card-title">Movie Name :: <%=lst.get(i).getName() %></h5>
													<p class="card-text">Genres :: <%=lst.get(i).getGenres() %></p>
													<a href="#" class="btn btn-primary">Go somewhere</a>
												</div>
											</div>
										</div>
									</div>
								<%} %>
							<%} %>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>
	<script>
	
	
	
		function autocomplete(inp, arr) {
			/*the autocomplete function takes two arguments,
			the text field element and an array of possible autocompleted values:*/
			var currentFocus;
			/*execute a function when someone writes in the text field:*/
			inp
					.addEventListener(
							"input",
							function(e) {
								var a, b, i, val = this.value;
								/*close any already open lists of autocompleted values*/
								closeAllLists();
								if (!val) {
									return false;
								}
								currentFocus = -1;
								/*create a DIV element that will contain the items (values):*/
								a = document.createElement("DIV");
								a.setAttribute("id", this.id
										+ "autocomplete-list");
								a.setAttribute("class", "autocomplete-items");
								/*append the DIV element as a child of the autocomplete container:*/
								this.parentNode.appendChild(a);
								/*for each item in the array...*/
								for (i = 0; i < arr.length; i++) {
									/*check if the item starts with the same letters as the text field value:*/
									if (arr[i].substr(0, val.length)
											.toUpperCase() == val.toUpperCase()) {
										/*create a DIV element for each matching element:*/
										b = document.createElement("DIV");
										/*make the matching letters bold:*/
										b.innerHTML = "<strong>"
												+ arr[i].substr(0, val.length)
												+ "</strong>";
										b.innerHTML += arr[i]
												.substr(val.length);
										/*insert a input field that will hold the current array item's value:*/
										b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
										/*execute a function when someone clicks on the item value (DIV element):*/
										b
												.addEventListener(
														"click",
														function(e) {
															/*insert the value for the autocomplete text field:*/
															inp.value = this
																	.getElementsByTagName("input")[0].value;
															/*close the list of autocompleted values,
															(or any other open lists of autocompleted values:*/
															closeAllLists();
														});
										a.appendChild(b);
									}
								}
							});
			/*execute a function presses a key on the keyboard:*/
			inp.addEventListener("keydown", function(e) {
				var x = document.getElementById(this.id + "autocomplete-list");
				if (x)
					x = x.getElementsByTagName("div");
				if (e.keyCode == 40) {
					/*If the arrow DOWN key is pressed,
					increase the currentFocus variable:*/
					currentFocus++;
					/*and and make the current item more visible:*/
					addActive(x);
				} else if (e.keyCode == 38) { //up
					/*If the arrow UP key is pressed,
					decrease the currentFocus variable:*/
					currentFocus--;
					/*and and make the current item more visible:*/
					addActive(x);
				} else if (e.keyCode == 13) {
					/*If the ENTER key is pressed, prevent the form from being submitted,*/
					e.preventDefault();
					if (currentFocus > -1) {
						/*and simulate a click on the "active" item:*/
						if (x)
							x[currentFocus].click();
					}
				}
			});
			function addActive(x) {
				/*a function to classify an item as "active":*/
				if (!x)
					return false;
				/*start by removing the "active" class on all items:*/
				removeActive(x);
				if (currentFocus >= x.length)
					currentFocus = 0;
				if (currentFocus < 0)
					currentFocus = (x.length - 1);
				/*add class "autocomplete-active":*/
				x[currentFocus].classList.add("autocomplete-active");
			}
			function removeActive(x) {
				/*a function to remove the "active" class from all autocomplete items:*/
				for (var i = 0; i < x.length; i++) {
					x[i].classList.remove("autocomplete-active");
				}
			}
			function closeAllLists(elmnt) {
				/*close all autocomplete lists in the document,
				except the one passed as an argument:*/
				var x = document.getElementsByClassName("autocomplete-items");
				for (var i = 0; i < x.length; i++) {
					if (elmnt != x[i] && elmnt != inp) {
						x[i].parentNode.removeChild(x[i]);
					}
				}
			}
			/*execute a function when someone clicks in the document:*/
			document.addEventListener("click", function(e) {
				closeAllLists(e.target);
			});
		}
		
		/*An array containing all the country names in the world:*/
		var countries = ["movie1"];
		<%showPopularMovies spm=new showPopularMovies();
		LinkedList<Movie> lst1=spm.save();
		for(int i=0;i<lst1.size();i++){
		%>
		countries.push("<%=lst1.get(i).getName()%>");
       <%}%>
         console.log(countries);
		/*initiate the autocomplete function on the "myInput" element, and pass along the countries array as possible autocomplete values:*/
		autocomplete(document.getElementById("myInput"), countries);
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>
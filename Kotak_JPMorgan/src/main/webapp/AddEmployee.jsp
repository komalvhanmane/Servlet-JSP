<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
* {
	box-sizing: border-box;
}

body {
	margin: 60px;
}

input[type=text], select, textarea {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	resize: vertical;
}

label {
	padding: 12px 12px 12px 0;
	display: inline-block;
}

input[type=submit] {
	background-color: #04AA6D;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	float: right;
}

input[type=submit]:hover {
	background-color: #45a049;
}

.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}

.col-25 {
	float: left;
	width: 25%;
	margin-top: 6px;
}

.col-75 {
	float: left;
	width: 75%;
	margin-top: 6px;
}

.row:after {
	content: "";
	display: table;
	clear: both;
}

@media screen and (max-width: 600px) {
	.col-25, .col-75, input[type=submit] {
		width: 100%;
		margin-top: 0;
	}
}
</style>
</head>
<body>

	<h2>ENTER YOUR PERSONAL INFORMATION</h2>

	<div class="container">
		<form action="addEmployee">
			<div class="row">
				<div class="col-50">
				<label for="id"><i class="fa fa-user"></i> Employee ID</label> <input
						type="text" id="id" name="Eid"
						placeholder="1234"> 
				<label for="fname"><i class="fa fa-user"></i> Full Name</label> <input
						type="text" id="fname" name="name"
						placeholder="Mr/Mrs/Miss Kotak"> 
				<label for="email"><i
						class="fa fa-envelope"></i> Email</label> <input type="text" id="email"
						name="email" placeholder="Kotak@example.com">
				<label for="id"> Designation</label> <input
						type="text" id="Designation" name="Designation"
						placeholder="Manager"> 
				<label for="id">Department</label> <input
						type="text" id="Department" name="Department"
						placeholder="Marketing"> 
				<label for="id">Level</label><input
						type="text" id="Level" name="Level"
						placeholder="Level">  
				</div>
				
			</div>
			<div class="row">
				<div class="col-25">

					<div class="row">
						<div class="col-25">
							<label for="gender">Gender</label>
						</div>
						<div class="col-50">
							<select id="gender" name="gender">

								<option value="M">Male</option>
								<option value="F">Female</option>
								<option value="Prefer not to say">Prefer not to say</option>
							</select>
						</div>
					</div>


					<label for="birthday"><i class="fa fa-birthday-cake"></i><span>
					</span>DateOfBirth</label><br>
					<td><input type="date" id="birthday" name="birthday"></td>
					<br>
					<br> <label for="jobjoin"><i class="fa fa-briefcase"></i><span>
					</span>DateOfJoin</label><br> <input type="date" id="jobjoin" name="jobjoin">



				</div>
			</div>

			<br>
			<div class="row">
				<input type="submit" value="Submit">
			</div>
		</form>
	</div>

</body>
</html>
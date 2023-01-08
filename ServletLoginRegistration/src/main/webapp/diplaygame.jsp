<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Games</title>
</head>
<body>

	<form action="homegame">
		<input type="submit" value="More games">
	</form>

	<% ArrayList<Games> lst = (ArrayList<Games>) session.getAttribute("gamelist");
if(!session.isNew()){
	System.out.println(lst.size());

for(int i=0;i<lst.size();i++){
	

%>
	<div class="card-body">
		<h5 class="card-title">Game ID :: <%= lst.get(i).getGameID() %></h5>
		<p class="card-text">Some quick example text to build on the card
			title and make up the bulk of the card's content.</p>
		<button
			onclick="document.getElementById('id03').style.display='block'"
			style="width: auto;">Register</button>
	</div>
	<%}} %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.*" %>
<%@ page import="com.dao.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en-US">
<body>

<h1>Analysis</h1>

 <% CustomerDao cd=new CustomerDao();%>
<%LinkedList<Employee> lst=cd.retrive(); int female=0;int male=0;%>
<%for(int i=0;i<lst.size();i++){
	if(lst.get(i).getGender().equals("F")){
		female++;
	}
	else{
		male++;
	}
}%>

<div id="piechart"></div>
<div id="piechart1"></div>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<script type="text/javascript">
// Load google charts
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);
// Draw the chart and set the chart values
function drawChart() {
  var data = google.visualization.arrayToDataTable([
  ['Gender', 'Number of people'],
  ['Men', <%=male%>],
  ['Women', <%=female%>]
]);

  // Optional; add a title and set the width and height of the chart
  var options = {'title':'Male Female Ratio', 'width':550, 'height':400};

  // Display the chart inside the <div> element with id="piechart"
  var chart = new google.visualization.PieChart(document.getElementById('piechart'));
  chart.draw(data, options);
}
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart1);

// Draw the chart and set the chart values
function drawChart1() {
  var data = google.visualization.arrayToDataTable([
  ['Task', 'Reason they left'],
  ['Salary', 6],
  ['Work culture', 2],
  ['Opportunities', 4],
  ['Retirement', 4],
  ['Other', 2]
]);

  // Optional; add a title and set the width and height of the chart
  var options = {'title':'Reasons for the interventions', 'width':550, 'height':400};

  // Display the chart inside the <div> element with id="piechart"
  var chart = new google.visualization.PieChart(document.getElementById('piechart1'));
  chart.draw(data, options);
}


</script>

</body>
</html>
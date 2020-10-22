<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.sql.*"    %>



<!DOCTYPE html>
<html lang="en">
<head>
	<title>Table V01</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="css/css2/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/css2/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/css2/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/css2/vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/css2/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/css2/vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/css2/css/util.css">
	<link rel="stylesheet" type="text/css" href="css/css2/css/main.css">
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100">
				    <%@ include file = "menu.jsp" %>
					<table>
						<thead>
							<tr class="table100-head">
								<th class="column1">First Name</th>
								<th class="column2">Last Name</th>
								<th class="column3">Email ID</th>
								<th class="column4">City</th>
								<th class="column5">Mobile Number</th>
								<th class="column6">Delete</th>
								<th class="column7">Update</th>
							</tr>
						</thead>
						<tbody>
						<% ResultSet results = (ResultSet)request.getAttribute("results"); %>
<% while(results.next()){  %>
								<tr>
									<td class="column1"><%= results.getString(1) %></td>
									<td class="column2"><%= results.getString(2) %></td>
									<td class="column3"><%= results.getString(3) %></td>
									<td class="column4"><%= results.getString(4) %></td>
									<td class="column5"><%= results.getString(5) %></td>
									<td class="column6"><a href = "deleteServlet?email=<%=results.getString(3)%>">Delete</a></td>
									<td class="column7"><a href = "updateServlet?email=<%=results.getString(3)%>&mobile=<%= results.getString(5)%>" >Update</a></td>
								</tr>
					
								<%} %>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>


	

<!--===============================================================================================-->	
	<script src="css/css2/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="css/css2/vendor/bootstrap/js/popper.js"></script>
	<script src="css/css2/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="css/css2/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="css/css2/js/main.js"></script>

</body>
</html>
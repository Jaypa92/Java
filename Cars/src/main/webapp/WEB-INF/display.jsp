<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DashBoard</title>
</head>
<body>
	<h1>Welcome <c:out value="${user.name}"/></h1>
	<a href="/add/car" >Add Car</a>
	<a href="/logout" >Log Out</a>
	<table>
		<tr>
			<th>Car Id</th>
			<th>Year</th>
			<th>Maker</th>
			<th>Model</th>
			<th>Price</th>
			<th>Posted By</th>
		</tr>
		<c:forEach var="car" items="${cars}">
		<tr>
			<td><c:out value="${car.id}" /></td>
			<td><c:out value="${car.year}" /></td>
			<td><c:out value="${car.maker}" /></td>
			<td><a href="/car/${car.id}" ><c:out value="${car.model}"/></a></td>
			<td>$<c:out value="${car.price}" /></td>
			<td><c:out value="${car.user.name}" /></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
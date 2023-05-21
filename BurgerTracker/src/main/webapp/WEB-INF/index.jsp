<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Burger Form</title>
</head>
<body>
	<h1>Add A Burger</h1>
	<form:form action="/addBurger" mode="post" modelAttribute="burger">
		<div>
			<form:label path="name">Burger Name</form:label>
			<form:errors path="name" />
			<form:input path="name"/>
		</div>
		<div>
			<form:label path="restaurant">Restaurant Name:</form:label>
			<form:errors path="restaurant" />
			<form:input path="restaurant"/>
		</div>
		<div>
			<form:label path="rating">Rating:</form:label>
			<form:errors path="rating" />
			<form:input path="rating"/>
		</div>
		<div>
			<form:label path="notes">Notes:</form:label>
			<form:errors path="notes" />
			<form:textarea path="notes" rows="4"/>
		</div>
		<div>
			<input type="submit" value="Submit" />
		</div>
	</form:form>
	<h1>Burger Tracker</h1>
	<table>
		<thead>
			<tr>
				<th>Burger Name</th>
				<th>Restaurant Name</th>
				<th>Rating</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="burger" items="${burgers}" >
				<tr>
					<td><c:out value="${burger.name}" /> </td>
					<td><c:out value="${burger.restaurant}" /></td>
					<td><c:out value="${burger.rating}"/></td>
					<td><a href="/edit/${burger.id}" >Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
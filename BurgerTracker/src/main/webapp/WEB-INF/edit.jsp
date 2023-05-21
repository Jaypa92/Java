<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Burger Tracker</title>
</head>
<body>
	<div>
		<h1>Edit Burger</h1>
		<a href="/" >Go Back</a>
	</div>
	<form:form action="/edit/${burger.id}" mode="put" modelAttribute="burger" >
		<div>
			<form:label path="name">Burger Name:</form:label>
			<form:errors path="name"/>
			<form:input path="name"/>
		</div>
		<div>
			<form:label path="restaurant">Restaurant Name:</form:label>
			<form:errors path="restaurant"/>
			<form:input path="restaurant"/>
		</div>
		<div>
			<form:label path="rating">Rating:</form:label>
			<form:errors path="rating"/>
			<form:input path="rating"/>
		</div>
		<div>
			<form:label path="notes" >Notes:</form:label>
			<form:errors path="notes"/>
			<form:textarea path="notes" rows="4"/>
		</div>
		<div>
			<input type="submit" value="Submit" />
		</div>
	</form:form>
</body>
</html>
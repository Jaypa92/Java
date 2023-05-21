<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Book</title>
</head>
<body>
	<h1>Edit A Book On Your Shelf!</h1>
	<a href="/display" >Back to the Shelves</a>
	<form:form action="/book/edit/${book.id}" method="post" modelAttribute="book" >
	<input type="hidden" name="_method" value="put"/>
	<form:hidden path="user"/>
		<div>
			<form:label path="title" >Title:</form:label>
			<form:errors path="title" />
			<form:input path="title" />
		</div>
		<div>
			<form:label path="authorName" >Author Name:</form:label>
			<form:errors path="authorName"/>
			<form:input path="authorName"/>
		</div>
		<div>
			<form:label path="thoughts" >Thoughts:</form:label>
			<form:errors path="thoughts"/>
			<form:textarea path="thoughts" rows="4" />
		</div>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
</head>
<body>
<h1>Add A Book to Your Shelf!</h1>
<a href="/display" >Back to the Shelves</a>
	<form:form action="/book/add" method="post" modelAttribute="newBook" >
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
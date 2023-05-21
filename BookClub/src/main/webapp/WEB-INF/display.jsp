<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books</title>
</head>
<body>
	<h1>Welcome <c:out value="${user.name}" /></h1>
	<h4>Book from everyone's shelves!</h4>
	<a href="/logout" >Log Out</a>
	<a href="/books" >Add to my Shelf</a>
	<table>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author Name</th>
			<th>Posted By</th>
		</tr>
		<c:forEach var="book" items="${books}" >
			<tr>
				<td><c:out value="${book.id}" /></td>
				<td><a href="/books/${book.id}" ><c:out value="${book.title}" /></a></td>
				<td><c:out value="${book.authorName}" /></td>
				<td><c:out value="${book.user.name}" /></td>
			</tr>
		</c:forEach>		
	</table>
</body>
</html>
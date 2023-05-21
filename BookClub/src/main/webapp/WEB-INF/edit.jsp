<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Info</title>
</head>
<body>
	<h1><c:out value="${book.title}" /></h1>
	<h4><c:out value="${book.user.name}" /> read <c:out value="${book.title}" /> by <c:out value="${book.authorName}"/></h4>
	<h4>Here are <c:out value="${book.user.name}" />'s thoughts</h4>
	<p><c:out value="${book.thoughts}" /></p>
	<a href="/display" >Go Back</a>
	<c:if test="${book.user.id == loggedUser.id}">
		<a href="/edit/${book.id}" >Edit</a>
		<form:form action="/book/delete/${book.id}" method="post" >
		<input type="hidden" name="_method" value="delete"/>
		<input type="submit" value="delete" />
		</form:form>
	</c:if>
</body>
</html>
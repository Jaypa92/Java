<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1><c:out value="${Car.year}" /> <c:out value="${Car.model}" /> by <c:out value="${Car.maker}"/></h1>
	<h2>Posted by <c:out value="${Car.user.name}" /></h2>
	<h2>$<c:out value="${Car.price}" /></h2>
	<a href="/display" >Dashboard</a>
	<p><c:out value="${Book.thoughts}"/></p>
	<c:if test="${Car.user.id == user.id}" >
		<a href="/edit/${Car.id}" >Edit</a>
		<form:form action="/delete/${Car.id}" method="post">
			<input type="hidden" name="_method" value="delete"/>
			<input type="submit" value="Delete"/>
		</form:form>
	</c:if>
	<c:if test="${Car.user.id != user.id}" >
		<form:form action="/delete/${Car.id}" method="post">
			<input type="hidden" name="_method" value="delete"/>
			<input type="submit" value="Purchase"/>
		</form:form>
	</c:if>
</body>
</html>
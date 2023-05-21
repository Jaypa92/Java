<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Dojo</title>
</head>
<body>
	<h1>New Dojo</h1>
	<a href="/ninja" >Add Ninja</a>
	<form:form action="/processDojo" method="post" modelAttribute="newDojo">
		<div>	
			<form:label path="name" >Name:</form:label>
			<form:errors path="name" />
			<form:input path="name"/>
		</div>
		<div>
			<input type="submit" value="Add" />
		</div>
	</form:form>
	<h1>All Dojos</h1>
	<c:forEach var="dojo" items="${dojos}">
		<a href="/${dojo.id}" ><c:out value="${dojo.name}"/></a>
	</c:forEach>
</body>
</html>
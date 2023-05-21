<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo With Ninjas</title>
</head>
<body>
	<h1>${dojo.name} Ninjas</h1>
	<a href="/" >Go Back</a>
	<a href="/ninja" >Add Ninja</a>
	<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="ninja" items="${dojo.ninjas}" >
				<td><c:out value="${ninja.firstName}" /></td>
				<td><c:out value="${ninja.lastName}"/></td>
				<td><c:out value="${ninja.age}" /></td>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
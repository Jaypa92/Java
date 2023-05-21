<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<h1>Fruit Store</h1>
	<div class="table-background" >	
		<table>
			<tr>
				<th class="wide" >Name</th>
				<th>Price</th>
			</tr>
			<c:forEach var="item" items="${fruit}">
			<tr>
				<td><c:out value="${item.name}"/></td>
				<td class="center" ><c:out value="${item.price}"/></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>  
</html>
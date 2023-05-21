<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold</title>
<link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
	<div class="flex-total" >		
		<h1>Your Gold: ${gold}</h1>
	</div>
	<div class="flex-forms" >
		<div>
			<form action="/processing" method="post">
				<h2>Farm</h2>
				<p>(earns 10-20 gold)</p>
				<input type="hidden" name="farm" />
				<button type="submit">Find Gold!</button>
			</form>
		</div>
		<div>
			<form action="/processing" method="post" >
				<h2>Cave</h2>
				<p>(earns 5-10 gold)</p>
				<input type="hidden" name="cave"/>
				<button type="submit" >Find Gold!</button>
			</form>
		</div>
		<div>
			<form action="/processing" method="post" >
				<h2>House</h2>
				<p>(earns 2-5 gold)</p>
				<input type="hidden" name="house">
				<button type="submit" >Find Gold!</button>
			</form>
		</div>
		<div>
			<form action="/processing" method="post" >
				<h2>Quest</h2>
				<p>(earns/takes 10-50 gold)</p>
				<input type="hidden" name="quest"/>
				<button type="submit" >Find Gold!</button>
			</form>
		</div>
	</div>
	<h1>Activities:</h1>
	<div class="scroll-box" >
		<c:forEach var="activity" items="${activities}">
			<c:if test="${activity.contains('earned')}">
				<p style="color:green;"><c:out value="${activity}"/></p>
			</c:if>
			<c:if test="${activity.contains('lost')}">
				<p style="color:red;" ><c:out value="${activity}"/></p>
			</c:if>
		</c:forEach>
	</div>
</body>
</html>
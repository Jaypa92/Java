<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Ninja</title>
</head>
<body>
	<h1>Add Ninja</h1>
	<a href="/" >Go Back</a>
	<form:form action="/ninja/process" method="post" modelAttribute="newNinja"  >
		<div>
			<form:label path="firstName" >First Name:</form:label>
			<form:errors path="firstName"/>
			<form:input path="firstName" />
		</div>
		<div>
			<form:label path="lastName" >Last Name:</form:label>
			<form:errors path="lastName"/>
			<form:input path="lastName"/>
		</div>
		<div>
			<form:label path="age" >Age:</form:label>
			<form:errors path="age" />
			<form:input type="number" path="age"/>
		</div>
		<div>
			<form:label path="dojo" >Select Dojo:</form:label>
			<form:select path="dojo">
				<form:option value="" >Choose Dojo</form:option>
				<c:forEach var="dojo" items="${dojos}">
					<form:option value="${dojo.id}" ><c:out value="${dojo.name}" /></form:option>				
				</c:forEach>
			</form:select>
		</div>
		<div>
			<input type="submit" value="Add" />
		</div>
	</form:form>
</body>
</html>